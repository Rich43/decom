package s1;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class j {

    /* renamed from: d, reason: collision with root package name */
    private static final List f7474d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    Object f7475a;

    /* renamed from: b, reason: collision with root package name */
    q f7476b;

    /* renamed from: c, reason: collision with root package name */
    j f7477c;

    private j(Object obj, q qVar) {
        this.f7475a = obj;
        this.f7476b = qVar;
    }

    static j a(q qVar, Object obj) {
        List list = f7474d;
        synchronized (list) {
            try {
                int size = list.size();
                if (size <= 0) {
                    return new j(obj, qVar);
                }
                j jVar = (j) list.remove(size - 1);
                jVar.f7475a = obj;
                jVar.f7476b = qVar;
                jVar.f7477c = null;
                return jVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void b(j jVar) {
        jVar.f7475a = null;
        jVar.f7476b = null;
        jVar.f7477c = null;
        List list = f7474d;
        synchronized (list) {
            try {
                if (list.size() < 10000) {
                    list.add(jVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
