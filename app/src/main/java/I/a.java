package I;

import i1.k;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map f235a = new LinkedHashMap();

    /* renamed from: I.a$a, reason: collision with other inner class name */
    public static final class C0006a extends a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0006a f236b = new C0006a();

        private C0006a() {
        }

        @Override // I.a
        public Object a(b bVar) {
            k.e(bVar, "key");
            return null;
        }
    }

    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.f235a;
    }
}
