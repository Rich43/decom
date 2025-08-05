package k1;

import i1.k;
import java.util.Random;

/* loaded from: classes.dex */
public final class b extends k1.a {

    /* renamed from: c */
    private final a f6517c = new a();

    public static final class a extends ThreadLocal {
        a() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // k1.a
    public Random c() {
        Object obj = this.f6517c.get();
        k.d(obj, "get(...)");
        return (Random) obj;
    }
}
