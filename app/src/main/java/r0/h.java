package r0;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a */
    static final String f7360a = System.getProperty("line.separator");

    public static C0324c c(Object[] objArr) {
        C0324c c0324c = new C0324c(objArr.length);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            c0324c.k(i2, h(objArr[i2]));
        }
        return c0324c;
    }

    public static d d(byte[] bArr) {
        return new d(bArr);
    }

    public static g e(double d2) {
        return new g(d2);
    }

    public static g f(long j2) {
        return new g(j2);
    }

    public static g g(boolean z2) {
        return new g(z2);
    }

    public static h h(Object obj) {
        if (obj == null) {
            throw new NullPointerException("A null object cannot be wrapped as a NSObject");
        }
        if (obj instanceof h) {
            return (h) obj;
        }
        Class<?> cls = obj.getClass();
        if (Boolean.class.equals(cls)) {
            return g(((Boolean) obj).booleanValue());
        }
        if (Byte.class.equals(cls)) {
            return f(((Byte) obj).byteValue());
        }
        if (Short.class.equals(cls)) {
            return f(((Short) obj).shortValue());
        }
        if (Integer.class.equals(cls)) {
            return f(((Integer) obj).intValue());
        }
        if (Long.class.isAssignableFrom(cls)) {
            return f(((Long) obj).longValue());
        }
        if (Float.class.equals(cls)) {
            return e(((Float) obj).floatValue());
        }
        if (Double.class.isAssignableFrom(cls)) {
            return e(((Double) obj).doubleValue());
        }
        if (String.class.equals(cls)) {
            return new i((String) obj);
        }
        if (Date.class.equals(cls)) {
            return new e((Date) obj);
        }
        if (!cls.isArray()) {
            if (!Map.class.isAssignableFrom(cls)) {
                return Collection.class.isAssignableFrom(cls) ? c(((Collection) obj).toArray()) : i(obj);
            }
            Map map = (Map) obj;
            Set setKeySet = map.keySet();
            f fVar = new f();
            for (Object obj2 : setKeySet) {
                fVar.put(String.valueOf(obj2), h(map.get(obj2)));
            }
            return fVar;
        }
        Class<?> componentType = cls.getComponentType();
        if (componentType.equals(Byte.TYPE)) {
            System.out.println("It's a byte array!");
            return d((byte[]) obj);
        }
        int i2 = 0;
        if (componentType.equals(Boolean.TYPE)) {
            boolean[] zArr = (boolean[]) obj;
            C0324c c0324c = new C0324c(zArr.length);
            while (i2 < zArr.length) {
                c0324c.k(i2, g(zArr[i2]));
                i2++;
            }
            return c0324c;
        }
        if (Float.TYPE.equals(componentType)) {
            float[] fArr = (float[]) obj;
            C0324c c0324c2 = new C0324c(fArr.length);
            while (i2 < fArr.length) {
                c0324c2.k(i2, e(fArr[i2]));
                i2++;
            }
            return c0324c2;
        }
        if (Double.TYPE.equals(componentType)) {
            double[] dArr = (double[]) obj;
            C0324c c0324c3 = new C0324c(dArr.length);
            while (i2 < dArr.length) {
                c0324c3.k(i2, e(dArr[i2]));
                i2++;
            }
            return c0324c3;
        }
        if (Short.TYPE.equals(componentType)) {
            short[] sArr = (short[]) obj;
            C0324c c0324c4 = new C0324c(sArr.length);
            while (i2 < sArr.length) {
                c0324c4.k(i2, f(sArr[i2]));
                i2++;
            }
            return c0324c4;
        }
        if (Integer.TYPE.equals(componentType)) {
            int[] iArr = (int[]) obj;
            C0324c c0324c5 = new C0324c(iArr.length);
            while (i2 < iArr.length) {
                c0324c5.k(i2, f(iArr[i2]));
                i2++;
            }
            return c0324c5;
        }
        if (!Long.TYPE.equals(componentType)) {
            return c((Object[]) obj);
        }
        long[] jArr = (long[]) obj;
        C0324c c0324c6 = new C0324c(jArr.length);
        while (i2 < jArr.length) {
            c0324c6.k(i2, f(jArr[i2]));
            i2++;
        }
        return c0324c6;
    }

    public static d i(Object obj) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            return new d(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            throw new RuntimeException("The given object of class " + obj.getClass().toString() + " could not be serialized and stored in a NSData object.");
        }
    }

    void a(C0323b c0323b) {
        c0323b.a(this);
    }

    abstract void b(C0323b c0323b);
}
