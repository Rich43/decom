package s1;

import android.util.Log;
import java.io.PrintStream;
import java.util.logging.Level;

/* loaded from: classes.dex */
public interface g {

    public static class a implements g {

        /* renamed from: b, reason: collision with root package name */
        static final boolean f7469b;

        /* renamed from: a, reason: collision with root package name */
        private final String f7470a;

        static {
            boolean z2;
            try {
                Class.forName("android.util.Log");
                z2 = true;
            } catch (ClassNotFoundException unused) {
                z2 = false;
            }
            f7469b = z2;
        }

        public a(String str) {
            this.f7470a = str;
        }

        public static boolean c() {
            return f7469b;
        }

        @Override // s1.g
        public void a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(d(level), this.f7470a, str);
            }
        }

        @Override // s1.g
        public void b(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                Log.println(d(level), this.f7470a, str + "\n" + Log.getStackTraceString(th));
            }
        }

        protected int d(Level level) {
            int iIntValue = level.intValue();
            if (iIntValue < 800) {
                return iIntValue < 500 ? 2 : 3;
            }
            if (iIntValue < 900) {
                return 4;
            }
            return iIntValue < 1000 ? 5 : 6;
        }
    }

    public static class b implements g {
        @Override // s1.g
        public void a(Level level, String str) {
            System.out.println("[" + level + "] " + str);
        }

        @Override // s1.g
        public void b(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(printStream);
        }
    }

    void a(Level level, String str);

    void b(Level level, String str, Throwable th);
}
