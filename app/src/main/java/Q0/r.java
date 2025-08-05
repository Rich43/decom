package q0;

/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    private static long f7224a;

    public static boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - f7224a;
        if (0 < j2 && j2 < 360) {
            return true;
        }
        f7224a = jCurrentTimeMillis;
        return false;
    }
}
