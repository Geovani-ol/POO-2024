package utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {
    private final Class<T> baseType;
    private final String typeFieldName;
    private final Map<String, Class<? extends T>> labelToSubtype = new HashMap<>();
    private final Map<Class<? extends T>, String> subtypeToLabel = new HashMap<>();

    private RuntimeTypeAdapterFactory(Class<T> baseType, String typeFieldName) {
        if (baseType == null || typeFieldName == null) {
            throw new NullPointerException("Base type and type field name must not be null");
        }
        this.baseType = baseType;
        this.typeFieldName = typeFieldName;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> baseType, String typeFieldName) {
        return new RuntimeTypeAdapterFactory<>(baseType, typeFieldName);
    }

    // Corregido: Ahora se requiere el parámetro 'label' para asociar el subtipo con su etiqueta
    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> subtype, String label) {
        if (subtype == null || label == null) {
            throw new NullPointerException("Subtype and label must not be null");
        }
        if (labelToSubtype.containsKey(label) || subtypeToLabel.containsKey(subtype)) {
            throw new IllegalArgumentException("Subtype and label must be unique");
        }
        labelToSubtype.put(label, subtype);
        subtypeToLabel.put(subtype, label);
        return this;
    }

    @Override
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> type) {
        if (!baseType.isAssignableFrom(type.getRawType())) {
            return null;
        }

        final Map<String, TypeAdapter<?>> labelToDelegate = new HashMap<>();
        final Map<Class<?>, TypeAdapter<?>> subtypeToDelegate = new HashMap<>();

        for (Map.Entry<String, Class<? extends T>> entry : labelToSubtype.entrySet()) {
            TypeAdapter<?> delegate = gson.getDelegateAdapter(this, TypeToken.get(entry.getValue()));
            labelToDelegate.put(entry.getKey(), delegate);
            subtypeToDelegate.put(entry.getValue(), delegate);
        }

        return new TypeAdapter<R>() {
            @Override
            public void write(JsonWriter out, R value) throws IOException {
                Class<?> srcType = value.getClass();
                String label = subtypeToLabel.get(srcType);
                if (label == null) {
                    throw new JsonParseException("Unknown type: " + srcType);
                }
                @SuppressWarnings("unchecked")
                TypeAdapter<R> delegate = (TypeAdapter<R>) subtypeToDelegate.get(srcType);
                if (delegate == null) {
                    throw new JsonParseException("No delegate for " + srcType);
                }
                out.beginObject();
                out.name(typeFieldName).value(label);  // Escribe el tipo de la subclase
                delegate.write(out, value);
                out.endObject();
            }

            @Override
            public R read(JsonReader in) throws IOException {
                in.beginObject();
                String label = null;
                if (in.peek() == JsonToken.NAME && typeFieldName.equals(in.nextName())) {
                    label = in.nextString();  // Lee el tipo de la subclase
                }
                if (label == null) {
                    throw new JsonParseException("Missing type field: " + typeFieldName);
                }
                @SuppressWarnings("unchecked")
                TypeAdapter<R> delegate = (TypeAdapter<R>) labelToDelegate.get(label);
                if (delegate == null) {
                    throw new JsonParseException("No delegate for label: " + label);
                }
                R result = delegate.read(in);
                in.endObject();
                return result;
            }
        }.nullSafe();
    }
}
