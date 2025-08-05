package q0;

import android.content.Context;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a */
    public static boolean f7212a = false;

    /* renamed from: b */
    private static boolean f7213b = true;

    /* renamed from: c */
    private static Context f7214c;

    public k(Context context) {
        f7214c = context;
    }

    public static void a(Object... objArr) throws Throwable {
        f(3, objArr);
    }

    public static void b(Object... objArr) throws Throwable {
        f(6, objArr);
    }

    public static void c(Object... objArr) throws Throwable {
        f(4, objArr);
    }

    private static String d(Object obj) {
        return obj instanceof Object[] ? Arrays.toString((Object[]) obj) : obj instanceof int[] ? Arrays.toString((int[]) obj) : obj instanceof float[] ? Arrays.toString((float[]) obj) : obj instanceof byte[] ? Arrays.toString((byte[]) obj) : obj instanceof char[] ? Arrays.toString((char[]) obj) : obj instanceof boolean[] ? Arrays.toString((boolean[]) obj) : obj instanceof long[] ? Arrays.toString((long[]) obj) : obj instanceof double[] ? Arrays.toString((double[]) obj) : obj instanceof short[] ? Arrays.toString((short[]) obj) : obj instanceof Throwable ? Log.getStackTraceString((Throwable) obj) : String.valueOf(obj);
    }

    private static void e(int i2, String str, String str2) throws Throwable {
        Log.d("LXP", "println msg:" + str2);
        Log.d("LXP", "isDebug:" + f7212a + " mSaveLog:" + f7213b);
        if (f7212a) {
            Log.println(i2, str, str2);
        }
        if (f7213b) {
            String strE = AbstractC0313b.e("yyyyMMdd_HHmmss_SSS");
            g(strE + " [" + str + "] " + str2, String.format("%s_%s.txt", "Log", strE.substring(0, 11)), true, f7214c);
        }
    }

    private static void f(int i2, Object... objArr) throws Throwable {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d(objArr[0]));
        for (int i3 = 1; i3 < objArr.length; i3++) {
            sb.append(" - ");
            sb.append(d(objArr[i3]));
        }
        e(i2, "miao", sb.toString());
    }

    public static void g(String str, String str2, boolean z2, Context context) throws Throwable {
        AbstractC0319h.k(str, context);
    }
}
