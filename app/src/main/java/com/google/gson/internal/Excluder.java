package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private static final double IGNORE_VERSIONS = -1.0d;
    private boolean requireExpose;
    private double version = IGNORE_VERSIONS;
    private int modifiers = 136;
    private boolean serializeInnerClasses = true;
    private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();

    /* renamed from: com.google.gson.internal.Excluder$1 */
    class AnonymousClass1<T> extends TypeAdapter<T> {
        private TypeAdapter<T> delegate;
        final /* synthetic */ Gson val$gson;
        final /* synthetic */ boolean val$skipDeserialize;
        final /* synthetic */ boolean val$skipSerialize;
        final /* synthetic */ TypeToken val$type;

        AnonymousClass1(boolean z2, boolean z3, Gson gson, TypeToken typeToken) {
            z = z2;
            z = z3;
            gson = gson;
            typeToken = typeToken;
        }

        private TypeAdapter<T> delegate() {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
            this.delegate = delegateAdapter;
            return delegateAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (!z) {
                return delegate().read(jsonReader);
            }
            jsonReader.skipValue();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t2) throws IOException {
            if (z) {
                jsonWriter.nullValue();
            } else {
                delegate().write(jsonWriter, t2);
            }
        }
    }

    private boolean isAnonymousOrLocal(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean isInnerClass(Class<?> cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean isValidSince(Since since) {
        return since == null || since.value() <= this.version;
    }

    private boolean isValidUntil(Until until) {
        return until == null || until.value() > this.version;
    }

    private boolean isValidVersion(Since since, Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean zExcludeClass = excludeClass(rawType, true);
        boolean zExcludeClass2 = excludeClass(rawType, false);
        if (zExcludeClass || zExcludeClass2) {
            return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1
                private TypeAdapter<T> delegate;
                final /* synthetic */ Gson val$gson;
                final /* synthetic */ boolean val$skipDeserialize;
                final /* synthetic */ boolean val$skipSerialize;
                final /* synthetic */ TypeToken val$type;

                AnonymousClass1(boolean zExcludeClass22, boolean zExcludeClass3, Gson gson2, TypeToken typeToken2) {
                    z = zExcludeClass22;
                    z = zExcludeClass3;
                    gson = gson2;
                    typeToken = typeToken2;
                }

                private TypeAdapter<T> delegate() {
                    TypeAdapter<T> typeAdapter = this.delegate;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                    this.delegate = delegateAdapter;
                    return delegateAdapter;
                }

                @Override // com.google.gson.TypeAdapter
                public T read(JsonReader jsonReader) throws IOException {
                    if (!z) {
                        return delegate().read(jsonReader);
                    }
                    jsonReader.skipValue();
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, T t2) throws IOException {
                    if (z) {
                        jsonWriter.nullValue();
                    } else {
                        delegate().write(jsonWriter, t2);
                    }
                }
            };
        }
        return null;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder excluderM3clone = m3clone();
        excluderM3clone.serializeInnerClasses = false;
        return excluderM3clone;
    }

    public boolean excludeClass(Class<?> cls, boolean z2) {
        if (this.version != IGNORE_VERSIONS && !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(cls)) || isAnonymousOrLocal(cls)) {
            return true;
        }
        Iterator<ExclusionStrategy> it = (z2 ? this.serializationStrategies : this.deserializationStrategies).iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean excludeField(Field field, boolean z2) {
        Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != IGNORE_VERSIONS && !isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z2 ? expose.deserialize() : expose.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrLocal(field.getType())) {
            return true;
        }
        List<ExclusionStrategy> list = z2 ? this.serializationStrategies : this.deserializationStrategies;
        if (list.isEmpty()) {
            return false;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        Iterator<ExclusionStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder excluderM3clone = m3clone();
        excluderM3clone.requireExpose = true;
        return excluderM3clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z2, boolean z3) {
        Excluder excluderM3clone = m3clone();
        if (z2) {
            ArrayList arrayList = new ArrayList(this.serializationStrategies);
            excluderM3clone.serializationStrategies = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z3) {
            ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
            excluderM3clone.deserializationStrategies = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return excluderM3clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder excluderM3clone = m3clone();
        excluderM3clone.modifiers = 0;
        for (int i2 : iArr) {
            excluderM3clone.modifiers = i2 | excluderM3clone.modifiers;
        }
        return excluderM3clone;
    }

    public Excluder withVersion(double d2) {
        Excluder excluderM3clone = m3clone();
        excluderM3clone.version = d2;
        return excluderM3clone;
    }

    /* renamed from: clone */
    public Excluder m3clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
