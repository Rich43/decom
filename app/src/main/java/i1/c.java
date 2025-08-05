package i1;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class c implements n1.a, Serializable {

    /* renamed from: g */
    public static final Object f6458g = a.f6464a;

    /* renamed from: a */
    private transient n1.a f6459a;

    /* renamed from: b */
    protected final Object f6460b;

    /* renamed from: c */
    private final Class f6461c;

    /* renamed from: d */
    private final String f6462d;
    private final String e;

    /* renamed from: f */
    private final boolean f6463f;

    private static class a implements Serializable {

        /* renamed from: a */
        private static final a f6464a = new a();

        private a() {
        }
    }

    protected c(Object obj, Class cls, String str, String str2, boolean z2) {
        this.f6460b = obj;
        this.f6461c = cls;
        this.f6462d = str;
        this.e = str2;
        this.f6463f = z2;
    }

    public n1.a b() {
        n1.a aVar = this.f6459a;
        if (aVar != null) {
            return aVar;
        }
        n1.a aVarC = c();
        this.f6459a = aVarC;
        return aVarC;
    }

    protected abstract n1.a c();

    public Object d() {
        return this.f6460b;
    }

    public String e() {
        return this.f6462d;
    }

    public n1.c f() {
        Class cls = this.f6461c;
        if (cls == null) {
            return null;
        }
        return this.f6463f ? n.c(cls) : n.b(cls);
    }

    public String g() {
        return this.e;
    }
}
