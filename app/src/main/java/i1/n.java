package i1;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a */
    private static final o f6477a;

    /* renamed from: b */
    private static final n1.b[] f6478b;

    static {
        o oVar = null;
        try {
            oVar = (o) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (oVar == null) {
            oVar = new o();
        }
        f6477a = oVar;
        f6478b = new n1.b[0];
    }

    public static n1.d a(i iVar) {
        return f6477a.a(iVar);
    }

    public static n1.b b(Class cls) {
        return f6477a.b(cls);
    }

    public static n1.c c(Class cls) {
        return f6477a.c(cls, "");
    }

    public static String d(l lVar) {
        return f6477a.e(lVar);
    }
}
