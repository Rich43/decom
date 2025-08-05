package f1;

import k1.c;

/* loaded from: classes.dex */
public class a extends e1.a {

    /* renamed from: f1.a$a */
    private static final class C0073a {

        /* renamed from: a */
        public static final C0073a f6191a = new C0073a();

        /* renamed from: b */
        public static final Integer f6192b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null && num2.intValue() > 0) {
                num = num2;
            }
            f6192b = num;
        }

        private C0073a() {
        }
    }

    private final boolean b(int i2) {
        Integer num = C0073a.f6192b;
        return num == null || num.intValue() >= i2;
    }

    @Override // d1.a
    public c a() {
        return b(34) ? new l1.a() : super.a();
    }
}
