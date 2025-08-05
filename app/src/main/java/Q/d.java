package Q;

import android.graphics.Rect;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class d {

    /* renamed from: c */
    private Map f559c;

    /* renamed from: d */
    private Map f560d;
    private Map e;

    /* renamed from: f */
    private List f561f;

    /* renamed from: g */
    private androidx.collection.h f562g;

    /* renamed from: h */
    private androidx.collection.d f563h;

    /* renamed from: i */
    private List f564i;

    /* renamed from: j */
    private Rect f565j;

    /* renamed from: k */
    private float f566k;

    /* renamed from: l */
    private float f567l;

    /* renamed from: m */
    private float f568m;

    /* renamed from: n */
    private boolean f569n;

    /* renamed from: a */
    private final l f557a = new l();

    /* renamed from: b */
    private final HashSet f558b = new HashSet();
    private int o = 0;

    public void a(String str) {
        c0.f.b(str);
        this.f558b.add(str);
    }

    public Rect b() {
        return this.f565j;
    }

    public androidx.collection.h c() {
        return this.f562g;
    }

    public float d() {
        return (long) ((e() / this.f568m) * 1000.0f);
    }

    public float e() {
        return this.f567l - this.f566k;
    }

    public float f() {
        return this.f567l;
    }

    public Map g() {
        return this.e;
    }

    public float h() {
        return this.f568m;
    }

    public Map i() {
        return this.f560d;
    }

    public List j() {
        return this.f564i;
    }

    public V.h k(String str) {
        this.f561f.size();
        for (int i2 = 0; i2 < this.f561f.size(); i2++) {
            V.h hVar = (V.h) this.f561f.get(i2);
            if (hVar.a(str)) {
                return hVar;
            }
        }
        return null;
    }

    public int l() {
        return this.o;
    }

    public l m() {
        return this.f557a;
    }

    public List n(String str) {
        return (List) this.f559c.get(str);
    }

    public float o() {
        return this.f566k;
    }

    public boolean p() {
        return this.f569n;
    }

    public void q(int i2) {
        this.o += i2;
    }

    public void r(Rect rect, float f2, float f3, float f4, List list, androidx.collection.d dVar, Map map, Map map2, androidx.collection.h hVar, Map map3, List list2) {
        this.f565j = rect;
        this.f566k = f2;
        this.f567l = f3;
        this.f568m = f4;
        this.f564i = list;
        this.f563h = dVar;
        this.f559c = map;
        this.f560d = map2;
        this.f562g = hVar;
        this.e = map3;
        this.f561f = list2;
    }

    public Y.d s(long j2) {
        return (Y.d) this.f563h.f(j2);
    }

    public void t(boolean z2) {
        this.f569n = z2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator it = this.f564i.iterator();
        while (it.hasNext()) {
            sb.append(((Y.d) it.next()).w("\t"));
        }
        return sb.toString();
    }

    public void u(boolean z2) {
        this.f557a.b(z2);
    }
}
