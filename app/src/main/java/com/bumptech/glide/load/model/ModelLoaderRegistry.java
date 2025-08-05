package com.bumptech.glide.load.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import v.InterfaceC0342e;

/* loaded from: classes.dex */
public class ModelLoaderRegistry {
    private final ModelLoaderCache cache;
    private final MultiModelLoaderFactory multiModelLoaderFactory;

    private static class ModelLoaderCache {
        private final Map<Class<?>, Entry<?>> cachedModelLoaders = new HashMap();

        private static class Entry<Model> {
            final List<ModelLoader<Model, ?>> loaders;

            public Entry(List<ModelLoader<Model, ?>> list) {
                this.loaders = list;
            }
        }

        ModelLoaderCache() {
        }

        public void clear() {
            this.cachedModelLoaders.clear();
        }

        public <Model> List<ModelLoader<Model, ?>> get(Class<Model> cls) {
            Entry<?> entry = this.cachedModelLoaders.get(cls);
            if (entry == null) {
                return null;
            }
            return (List<ModelLoader<Model, ?>>) entry.loaders;
        }

        public <Model> void put(Class<Model> cls, List<ModelLoader<Model, ?>> list) {
            if (this.cachedModelLoaders.put(cls, new Entry<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public ModelLoaderRegistry(InterfaceC0342e interfaceC0342e) {
        this(new MultiModelLoaderFactory(interfaceC0342e));
    }

    private static <A> Class<A> getClass(A a2) {
        return (Class<A>) a2.getClass();
    }

    private <A> List<ModelLoader<A, ?>> getModelLoadersForClass(Class<A> cls) {
        List<ModelLoader<A, ?>> list = this.cache.get(cls);
        if (list != null) {
            return list;
        }
        List<ModelLoader<A, ?>> listUnmodifiableList = Collections.unmodifiableList(this.multiModelLoaderFactory.build(cls));
        this.cache.put(cls, listUnmodifiableList);
        return listUnmodifiableList;
    }

    private <Model, Data> void tearDown(List<ModelLoaderFactory<? extends Model, ? extends Data>> list) {
        Iterator<ModelLoaderFactory<? extends Model, ? extends Data>> it = list.iterator();
        while (it.hasNext()) {
            it.next().teardown();
        }
    }

    public synchronized <Model, Data> void append(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.multiModelLoaderFactory.append(cls, cls2, modelLoaderFactory);
        this.cache.clear();
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> build(Class<Model> cls, Class<Data> cls2) {
        return this.multiModelLoaderFactory.build(cls, cls2);
    }

    public synchronized List<Class<?>> getDataClasses(Class<?> cls) {
        return this.multiModelLoaderFactory.getDataClasses(cls);
    }

    public synchronized <A> List<ModelLoader<A, ?>> getModelLoaders(A a2) {
        ArrayList arrayList;
        List<ModelLoader<A, ?>> modelLoadersForClass = getModelLoadersForClass(getClass(a2));
        int size = modelLoadersForClass.size();
        arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            ModelLoader<A, ?> modelLoader = modelLoadersForClass.get(i2);
            if (modelLoader.handles(a2)) {
                arrayList.add(modelLoader);
            }
        }
        return arrayList;
    }

    public synchronized <Model, Data> void prepend(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.multiModelLoaderFactory.prepend(cls, cls2, modelLoaderFactory);
        this.cache.clear();
    }

    public synchronized <Model, Data> void remove(Class<Model> cls, Class<Data> cls2) {
        tearDown(this.multiModelLoaderFactory.remove(cls, cls2));
        this.cache.clear();
    }

    public synchronized <Model, Data> void replace(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        tearDown(this.multiModelLoaderFactory.replace(cls, cls2, modelLoaderFactory));
        this.cache.clear();
    }

    private ModelLoaderRegistry(MultiModelLoaderFactory multiModelLoaderFactory) {
        this.cache = new ModelLoaderCache();
        this.multiModelLoaderFactory = multiModelLoaderFactory;
    }
}
