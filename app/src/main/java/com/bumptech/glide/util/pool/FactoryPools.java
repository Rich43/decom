package com.bumptech.glide.util.pool;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import v.C0343f;
import v.C0344g;
import v.InterfaceC0342e;

/* loaded from: classes.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(Object obj) {
        }
    };
    private static final String TAG = "FactoryPools";

    public interface Factory<T> {
        T create();
    }

    private static final class FactoryPool<T> implements InterfaceC0342e {
        private final Factory<T> factory;
        private final InterfaceC0342e pool;
        private final Resetter<T> resetter;

        FactoryPool(InterfaceC0342e interfaceC0342e, Factory<T> factory, Resetter<T> resetter) {
            this.pool = interfaceC0342e;
            this.factory = factory;
            this.resetter = resetter;
        }

        @Override // v.InterfaceC0342e
        public T acquire() {
            T tCreate = (T) this.pool.acquire();
            if (tCreate == null) {
                tCreate = this.factory.create();
                if (Log.isLoggable(FactoryPools.TAG, 2)) {
                    Log.v(FactoryPools.TAG, "Created new " + tCreate.getClass());
                }
            }
            if (tCreate instanceof Poolable) {
                tCreate.getVerifier().setRecycled(false);
            }
            return (T) tCreate;
        }

        @Override // v.InterfaceC0342e
        public boolean release(T t2) {
            if (t2 instanceof Poolable) {
                ((Poolable) t2).getVerifier().setRecycled(true);
            }
            this.resetter.reset(t2);
            return this.pool.release(t2);
        }
    }

    public interface Poolable {
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(T t2);
    }

    private FactoryPools() {
    }

    private static <T extends Poolable> InterfaceC0342e build(InterfaceC0342e interfaceC0342e, Factory<T> factory) {
        return build(interfaceC0342e, factory, emptyResetter());
    }

    private static <T> Resetter<T> emptyResetter() {
        return (Resetter<T>) EMPTY_RESETTER;
    }

    public static <T extends Poolable> InterfaceC0342e simple(int i2, Factory<T> factory) {
        return build(new C0343f(i2), factory);
    }

    public static <T extends Poolable> InterfaceC0342e threadSafe(int i2, Factory<T> factory) {
        return build(new C0344g(i2), factory);
    }

    public static <T> InterfaceC0342e threadSafeList() {
        return threadSafeList(DEFAULT_POOL_SIZE);
    }

    private static <T> InterfaceC0342e build(InterfaceC0342e interfaceC0342e, Factory<T> factory, Resetter<T> resetter) {
        return new FactoryPool(interfaceC0342e, factory, resetter);
    }

    public static <T> InterfaceC0342e threadSafeList(int i2) {
        return build(new C0344g(i2), new Factory<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public List<T> create() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public void reset(List<T> list) {
                list.clear();
            }
        });
    }
}
