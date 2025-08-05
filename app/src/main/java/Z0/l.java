package z0;

/* loaded from: classes.dex */
public abstract class l extends Exception {

    /* renamed from: a */
    protected static final boolean f7797a;

    /* renamed from: b */
    protected static final StackTraceElement[] f7798b;

    static {
        f7797a = System.getProperty("surefire.test.class.path") != null;
        f7798b = new StackTraceElement[0];
    }

    l() {
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    l(Throwable th) {
        super(th);
    }
}
