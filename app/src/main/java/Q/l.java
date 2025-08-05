package Q;

import androidx.appcompat.app.F;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import v.C0341d;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private boolean f620a = false;

    /* renamed from: b, reason: collision with root package name */
    private final Set f621b = new androidx.collection.b();

    /* renamed from: c, reason: collision with root package name */
    private final Map f622c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Comparator f623d = new a();

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0341d c0341d, C0341d c0341d2) {
            float fFloatValue = ((Float) c0341d.f7672b).floatValue();
            float fFloatValue2 = ((Float) c0341d2.f7672b).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    }

    public void a(String str, float f2) {
        if (this.f620a) {
            c0.h hVar = (c0.h) this.f622c.get(str);
            if (hVar == null) {
                hVar = new c0.h();
                this.f622c.put(str, hVar);
            }
            hVar.a(f2);
            if (str.equals("__container")) {
                Iterator it = this.f621b.iterator();
                if (it.hasNext()) {
                    F.a(it.next());
                    throw null;
                }
            }
        }
    }

    void b(boolean z2) {
        this.f620a = z2;
    }
}
