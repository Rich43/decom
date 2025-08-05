package Q;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f552a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f553b = false;

    /* renamed from: c, reason: collision with root package name */
    private static String[] f554c;

    /* renamed from: d, reason: collision with root package name */
    private static long[] f555d;
    private static int e;

    /* renamed from: f, reason: collision with root package name */
    private static int f556f;

    public static void a(String str) {
        if (f553b) {
            int i2 = e;
            if (i2 == 20) {
                f556f++;
                return;
            }
            f554c[i2] = str;
            f555d[i2] = System.nanoTime();
            androidx.core.os.o.a(str);
            e++;
        }
    }

    public static float b(String str) {
        int i2 = f556f;
        if (i2 > 0) {
            f556f = i2 - 1;
            return 0.0f;
        }
        if (!f553b) {
            return 0.0f;
        }
        int i3 = e - 1;
        e = i3;
        if (i3 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(f554c[i3])) {
            androidx.core.os.o.b();
            return (System.nanoTime() - f555d[e]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f554c[e] + ".");
    }
}
