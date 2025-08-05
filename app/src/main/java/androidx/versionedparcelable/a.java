package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final androidx.collection.a f4476a;

    /* renamed from: b, reason: collision with root package name */
    protected final androidx.collection.a f4477b;

    /* renamed from: c, reason: collision with root package name */
    protected final androidx.collection.a f4478c;

    public a(androidx.collection.a aVar, androidx.collection.a aVar2, androidx.collection.a aVar3) {
        this.f4476a = aVar;
        this.f4477b = aVar2;
        this.f4478c = aVar3;
    }

    private void N(P.a aVar) {
        try {
            I(c(aVar.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(aVar.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    private Class c(Class cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.f4478c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f4478c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) throws NoSuchMethodException, SecurityException {
        Method method = (Method) this.f4476a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f4476a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method e(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method method = (Method) this.f4477b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, a.class);
        this.f4477b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i2) {
        w(i2);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i2) {
        w(i2);
        C(charSequence);
    }

    protected abstract void E(int i2);

    public void F(int i2, int i3) {
        w(i3);
        E(i2);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i2) {
        w(i2);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i2) {
        w(i2);
        I(str);
    }

    protected void K(P.a aVar, a aVar2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            e(aVar.getClass()).invoke(null, aVar, aVar2);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (!(e4.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
            throw ((RuntimeException) e4.getCause());
        }
    }

    protected void L(P.a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (aVar == null) {
            I(null);
            return;
        }
        N(aVar);
        a aVarB = b();
        K(aVar, aVarB);
        aVarB.a();
    }

    public void M(P.a aVar, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        w(i2);
        L(aVar);
    }

    protected abstract void a();

    protected abstract a b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z2, int i2) {
        return !m(i2) ? z2 : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i2) {
        return !m(i2) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i2) {
        return !m(i2) ? charSequence : k();
    }

    protected abstract boolean m(int i2);

    protected P.a n(String str, a aVar) {
        try {
            return (P.a) d(str).invoke(null, aVar);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    protected abstract int o();

    public int p(int i2, int i3) {
        return !m(i3) ? i2 : o();
    }

    protected abstract Parcelable q();

    public Parcelable r(Parcelable parcelable, int i2) {
        return !m(i2) ? parcelable : q();
    }

    protected abstract String s();

    public String t(String str, int i2) {
        return !m(i2) ? str : s();
    }

    protected P.a u() {
        String strS = s();
        if (strS == null) {
            return null;
        }
        return n(strS, b());
    }

    public P.a v(P.a aVar, int i2) {
        return !m(i2) ? aVar : u();
    }

    protected abstract void w(int i2);

    public void x(boolean z2, boolean z3) {
    }

    protected abstract void y(boolean z2);

    public void z(boolean z2, int i2) {
        w(i2);
        y(z2);
    }
}
