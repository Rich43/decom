package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0203h;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class E {

    /* renamed from: a */
    private final n f3374a;

    /* renamed from: b */
    private final ClassLoader f3375b;

    /* renamed from: d */
    int f3377d;
    int e;

    /* renamed from: f */
    int f3378f;

    /* renamed from: g */
    int f3379g;

    /* renamed from: h */
    int f3380h;

    /* renamed from: i */
    boolean f3381i;

    /* renamed from: k */
    String f3383k;

    /* renamed from: l */
    int f3384l;

    /* renamed from: m */
    CharSequence f3385m;

    /* renamed from: n */
    int f3386n;
    CharSequence o;

    /* renamed from: p */
    ArrayList f3387p;

    /* renamed from: q */
    ArrayList f3388q;
    ArrayList s;

    /* renamed from: c */
    ArrayList f3376c = new ArrayList();

    /* renamed from: j */
    boolean f3382j = true;
    boolean r = false;

    static final class a {

        /* renamed from: a */
        int f3389a;

        /* renamed from: b */
        Fragment f3390b;

        /* renamed from: c */
        boolean f3391c;

        /* renamed from: d */
        int f3392d;
        int e;

        /* renamed from: f */
        int f3393f;

        /* renamed from: g */
        int f3394g;

        /* renamed from: h */
        AbstractC0203h.b f3395h;

        /* renamed from: i */
        AbstractC0203h.b f3396i;

        a() {
        }

        a(int i2, Fragment fragment) {
            this.f3389a = i2;
            this.f3390b = fragment;
            this.f3391c = false;
            AbstractC0203h.b bVar = AbstractC0203h.b.RESUMED;
            this.f3395h = bVar;
            this.f3396i = bVar;
        }

        a(int i2, Fragment fragment, boolean z2) {
            this.f3389a = i2;
            this.f3390b = fragment;
            this.f3391c = z2;
            AbstractC0203h.b bVar = AbstractC0203h.b.RESUMED;
            this.f3395h = bVar;
            this.f3396i = bVar;
        }
    }

    E(n nVar, ClassLoader classLoader) {
        this.f3374a = nVar;
        this.f3375b = classLoader;
    }

    public E b(int i2, Fragment fragment) {
        k(i2, fragment, null, 1);
        return this;
    }

    public E c(int i2, Fragment fragment, String str) {
        k(i2, fragment, str, 1);
        return this;
    }

    E d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public E e(Fragment fragment, String str) {
        k(0, fragment, str, 1);
        return this;
    }

    void f(a aVar) {
        this.f3376c.add(aVar);
        aVar.f3392d = this.f3377d;
        aVar.e = this.e;
        aVar.f3393f = this.f3378f;
        aVar.f3394g = this.f3379g;
    }

    public abstract int g();

    public abstract int h();

    public abstract void i();

    public E j() {
        if (this.f3381i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f3382j = false;
        return this;
    }

    void k(int i2, Fragment fragment, String str, int i3) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            F.c.f(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i4 = fragment.mFragmentId;
            if (i4 != 0 && i4 != i2) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
            }
            fragment.mFragmentId = i2;
            fragment.mContainerId = i2;
        }
        f(new a(i3, fragment));
    }

    public E l(Fragment fragment) {
        f(new a(4, fragment));
        return this;
    }

    public E m(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public E n(boolean z2) {
        this.r = z2;
        return this;
    }

    public E o(Fragment fragment) {
        f(new a(5, fragment));
        return this;
    }
}
