package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    /* renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1 */
    class AnonymousClass1 extends BoundField {
        final /* synthetic */ Gson val$context;
        final /* synthetic */ Field val$field;
        final /* synthetic */ TypeToken val$fieldType;
        final /* synthetic */ boolean val$isPrimitive;
        final /* synthetic */ boolean val$jsonAdapterPresent;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, boolean z2, boolean z3, Field field, boolean z4, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean z5) {
            super(str, z2, z3);
            field = field;
            z = z4;
            typeAdapter = typeAdapter;
            gson = gson;
            typeToken = typeToken;
            z = z5;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        void read(JsonReader jsonReader, Object obj) throws IllegalAccessException, IllegalArgumentException {
            Object obj2 = typeAdapter.read(jsonReader);
            if (obj2 == null && z) {
                return;
            }
            field.set(obj, obj2);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IllegalArgumentException {
            (z ? typeAdapter : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, typeToken.getType())).write(jsonWriter, field.get(obj));
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        public boolean writeField(Object obj) {
            return this.serialized && field.get(obj) != obj;
        }
    }

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;

        Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T tConstruct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader.skipValue();
                    } else {
                        boundField.read(jsonReader, tConstruct);
                    }
                }
                jsonReader.endObject();
                return tConstruct;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t2) throws IOException {
            if (t2 == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    if (boundField.writeField(t2)) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t2);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        protected BoundField(String str, boolean z2, boolean z3) {
            this.name = str;
            this.serialized = z2;
            this.deserialized = z3;
        }

        abstract void read(JsonReader jsonReader, Object obj);

        abstract void write(JsonWriter jsonWriter, Object obj);

        abstract boolean writeField(Object obj);
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    private BoundField createBoundField(Gson gson, Field field, String str, TypeToken<?> typeToken, boolean z2, boolean z3) {
        boolean zIsPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter<?> typeAdapter = jsonAdapter != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter) : null;
        boolean z4 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        return new BoundField(str, z2, z3) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            final /* synthetic */ Gson val$context;
            final /* synthetic */ Field val$field;
            final /* synthetic */ TypeToken val$fieldType;
            final /* synthetic */ boolean val$isPrimitive;
            final /* synthetic */ boolean val$jsonAdapterPresent;
            final /* synthetic */ TypeAdapter val$typeAdapter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str2, boolean z22, boolean z32, Field field2, boolean z42, TypeAdapter typeAdapter2, Gson gson2, TypeToken typeToken2, boolean zIsPrimitive2) {
                super(str2, z22, z32);
                field = field2;
                z = z42;
                typeAdapter = typeAdapter2;
                gson = gson2;
                typeToken = typeToken2;
                z = zIsPrimitive2;
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void read(JsonReader jsonReader, Object obj) throws IllegalAccessException, IllegalArgumentException {
                Object obj2 = typeAdapter.read(jsonReader);
                if (obj2 == null && z) {
                    return;
                }
                field.set(obj, obj2);
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IllegalArgumentException {
                (z ? typeAdapter : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, typeToken.getType())).write(jsonWriter, field.get(obj));
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public boolean writeField(Object obj) {
                return this.serialized && field.get(obj) != obj;
            }
        };
    }

    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls) throws SecurityException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        TypeToken<?> typeToken2 = typeToken;
        Class<?> rawType = cls;
        while (rawType != Object.class) {
            Field[] declaredFields = rawType.getDeclaredFields();
            int length = declaredFields.length;
            boolean z2 = false;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                boolean zExcludeField = excludeField(field, true);
                boolean zExcludeField2 = excludeField(field, z2);
                if (zExcludeField || zExcludeField2) {
                    field.setAccessible(true);
                    Type typeResolve = C$Gson$Types.resolve(typeToken2.getType(), rawType, field.getGenericType());
                    List<String> fieldNames = getFieldNames(field);
                    int size = fieldNames.size();
                    BoundField boundField = null;
                    int i3 = 0;
                    while (i3 < size) {
                        String str = fieldNames.get(i3);
                        boolean z3 = i3 != 0 ? false : zExcludeField;
                        int i4 = i3;
                        BoundField boundField2 = boundField;
                        int i5 = size;
                        List<String> list = fieldNames;
                        Field field2 = field;
                        boundField = boundField2 == null ? (BoundField) linkedHashMap.put(str, createBoundField(gson, field, str, TypeToken.get(typeResolve), z3, zExcludeField2)) : boundField2;
                        i3 = i4 + 1;
                        zExcludeField = z3;
                        fieldNames = list;
                        size = i5;
                        field = field2;
                    }
                    BoundField boundField3 = boundField;
                    if (boundField3 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField3.name);
                    }
                }
                i2++;
                z2 = false;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = typeToken2.getRawType();
        }
        return linkedHashMap;
    }

    private List<String> getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String strValue = serializedName.value();
        String[] strArrAlternate = serializedName.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        for (String str : strArrAlternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
        }
        return null;
    }

    public boolean excludeField(Field field, boolean z2) {
        return excludeField(field, z2, this.excluder);
    }

    static boolean excludeField(Field field, boolean z2, Excluder excluder) {
        return (excluder.excludeClass(field.getType(), z2) || excluder.excludeField(field, z2)) ? false : true;
    }
}
