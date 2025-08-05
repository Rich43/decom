package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.e;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import u.h;

/* loaded from: classes.dex */
class k extends o {

    /* renamed from: b, reason: collision with root package name */
    private static final Class f3042b;

    /* renamed from: c, reason: collision with root package name */
    private static final Constructor f3043c;

    /* renamed from: d, reason: collision with root package name */
    private static final Method f3044d;
    private static final Method e;

    static {
        Method method;
        Class<?> cls;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f3043c = constructor;
        f3042b = cls;
        f3044d = method2;
        e = method;
    }

    k() {
    }

    private static boolean h(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z2) {
        try {
            return ((Boolean) f3044d.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z2))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface i(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f3042b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean j() {
        Method method = f3044d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object k() {
        try {
            return f3043c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.o
    public Typeface a(Context context, e.c cVar, Resources resources, int i2) {
        Object objK = k();
        if (objK == null) {
            return null;
        }
        for (e.d dVar : cVar.a()) {
            ByteBuffer byteBufferB = p.b(context, resources, dVar.b());
            if (byteBufferB == null || !h(objK, byteBufferB, dVar.c(), dVar.e(), dVar.f())) {
                return null;
            }
        }
        return i(objK);
    }

    @Override // androidx.core.graphics.o
    public Typeface b(Context context, CancellationSignal cancellationSignal, h.b[] bVarArr, int i2) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        Object objK = k();
        if (objK == null) {
            return null;
        }
        androidx.collection.g gVar = new androidx.collection.g();
        for (h.b bVar : bVarArr) {
            Uri uriD = bVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) gVar.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = p.f(context, cancellationSignal, uriD);
                gVar.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !h(objK, byteBufferF, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface typefaceI = i(objK);
        if (typefaceI == null) {
            return null;
        }
        return Typeface.create(typefaceI, i2);
    }
}
