package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class LruCache implements Cache {
    private int evictionCount;
    private int hitCount;
    final LinkedHashMap<String, Bitmap> map;
    private final int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(Context context) {
        this(Utils.calculateMemoryCacheSize(context));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void trimToSize(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.size     // Catch: java.lang.Throwable -> L12
            if (r0 < 0) goto L55
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.map     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r3.size     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L55
            goto L14
        L12:
            r4 = move-exception
            goto L74
        L14:
            int r0 = r3.size     // Catch: java.lang.Throwable -> L12
            if (r0 <= r4) goto L53
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.map     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L21
            goto L53
        L21:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.map     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.map     // Catch: java.lang.Throwable -> L12
            r2.remove(r1)     // Catch: java.lang.Throwable -> L12
            int r1 = r3.size     // Catch: java.lang.Throwable -> L12
            int r0 = com.squareup.picasso.Utils.getBitmapBytes(r0)     // Catch: java.lang.Throwable -> L12
            int r1 = r1 - r0
            r3.size = r1     // Catch: java.lang.Throwable -> L12
            int r0 = r3.evictionCount     // Catch: java.lang.Throwable -> L12
            int r0 = r0 + 1
            r3.evictionCount = r0     // Catch: java.lang.Throwable -> L12
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            goto L0
        L53:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L55:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L12
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r0.<init>()     // Catch: java.lang.Throwable -> L12
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L12
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L12
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L12
            throw r4     // Catch: java.lang.Throwable -> L12
        L74:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.LruCache.trimToSize(int):void");
    }

    @Override // com.squareup.picasso.Cache
    public final synchronized void clear() {
        evictAll();
    }

    @Override // com.squareup.picasso.Cache
    public final synchronized void clearKeyUri(String str) {
        try {
            int length = str.length();
            Iterator<Map.Entry<String, Bitmap>> it = this.map.entrySet().iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                Map.Entry<String, Bitmap> next = it.next();
                String key = next.getKey();
                Bitmap value = next.getValue();
                int iIndexOf = key.indexOf(10);
                if (iIndexOf == length && key.substring(0, iIndexOf).equals(str)) {
                    it.remove();
                    this.size -= Utils.getBitmapBytes(value);
                    z2 = true;
                }
            }
            if (z2) {
                trimToSize(this.maxSize);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    @Override // com.squareup.picasso.Cache
    public Bitmap get(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                Bitmap bitmap = this.map.get(str);
                if (bitmap != null) {
                    this.hitCount++;
                    return bitmap;
                }
                this.missCount++;
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    @Override // com.squareup.picasso.Cache
    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    @Override // com.squareup.picasso.Cache
    public void set(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            try {
                this.putCount++;
                this.size += Utils.getBitmapBytes(bitmap);
                Bitmap bitmapPut = this.map.put(str, bitmap);
                if (bitmapPut != null) {
                    this.size -= Utils.getBitmapBytes(bitmapPut);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        trimToSize(this.maxSize);
    }

    @Override // com.squareup.picasso.Cache
    public final synchronized int size() {
        return this.size;
    }

    public LruCache(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.maxSize = i2;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }
}
