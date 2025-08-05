package Y;

import W.j;
import W.k;
import W.l;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final List f1296a;

    /* renamed from: b, reason: collision with root package name */
    private final Q.d f1297b;

    /* renamed from: c, reason: collision with root package name */
    private final String f1298c;

    /* renamed from: d, reason: collision with root package name */
    private final long f1299d;
    private final a e;

    /* renamed from: f, reason: collision with root package name */
    private final long f1300f;

    /* renamed from: g, reason: collision with root package name */
    private final String f1301g;

    /* renamed from: h, reason: collision with root package name */
    private final List f1302h;

    /* renamed from: i, reason: collision with root package name */
    private final l f1303i;

    /* renamed from: j, reason: collision with root package name */
    private final int f1304j;

    /* renamed from: k, reason: collision with root package name */
    private final int f1305k;

    /* renamed from: l, reason: collision with root package name */
    private final int f1306l;

    /* renamed from: m, reason: collision with root package name */
    private final float f1307m;

    /* renamed from: n, reason: collision with root package name */
    private final float f1308n;
    private final int o;

    /* renamed from: p, reason: collision with root package name */
    private final int f1309p;

    /* renamed from: q, reason: collision with root package name */
    private final j f1310q;
    private final k r;
    private final W.b s;

    /* renamed from: t, reason: collision with root package name */
    private final List f1311t;

    /* renamed from: u, reason: collision with root package name */
    private final b f1312u;

    /* renamed from: v, reason: collision with root package name */
    private final boolean f1313v;

    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum b {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public d(List list, Q.d dVar, String str, long j2, a aVar, long j3, String str2, List list2, l lVar, int i2, int i3, int i4, float f2, float f3, int i5, int i6, j jVar, k kVar, List list3, b bVar, W.b bVar2, boolean z2) {
        this.f1296a = list;
        this.f1297b = dVar;
        this.f1298c = str;
        this.f1299d = j2;
        this.e = aVar;
        this.f1300f = j3;
        this.f1301g = str2;
        this.f1302h = list2;
        this.f1303i = lVar;
        this.f1304j = i2;
        this.f1305k = i3;
        this.f1306l = i4;
        this.f1307m = f2;
        this.f1308n = f3;
        this.o = i5;
        this.f1309p = i6;
        this.f1310q = jVar;
        this.r = kVar;
        this.f1311t = list3;
        this.f1312u = bVar;
        this.s = bVar2;
        this.f1313v = z2;
    }

    Q.d a() {
        return this.f1297b;
    }

    public long b() {
        return this.f1299d;
    }

    List c() {
        return this.f1311t;
    }

    public a d() {
        return this.e;
    }

    List e() {
        return this.f1302h;
    }

    b f() {
        return this.f1312u;
    }

    String g() {
        return this.f1298c;
    }

    long h() {
        return this.f1300f;
    }

    int i() {
        return this.f1309p;
    }

    int j() {
        return this.o;
    }

    String k() {
        return this.f1301g;
    }

    List l() {
        return this.f1296a;
    }

    int m() {
        return this.f1306l;
    }

    int n() {
        return this.f1305k;
    }

    int o() {
        return this.f1304j;
    }

    float p() {
        return this.f1308n / this.f1297b.e();
    }

    j q() {
        return this.f1310q;
    }

    k r() {
        return this.r;
    }

    W.b s() {
        return this.s;
    }

    float t() {
        return this.f1307m;
    }

    public String toString() {
        return w("");
    }

    l u() {
        return this.f1303i;
    }

    public boolean v() {
        return this.f1313v;
    }

    public String w(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append("\n");
        d dVarS = this.f1297b.s(h());
        if (dVarS != null) {
            sb.append("\t\tParents: ");
            sb.append(dVarS.g());
            d dVarS2 = this.f1297b.s(dVarS.h());
            while (dVarS2 != null) {
                sb.append("->");
                sb.append(dVarS2.g());
                dVarS2 = this.f1297b.s(dVarS2.h());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append("\n");
        }
        if (o() != 0 && n() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.f1296a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (Object obj : this.f1296a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(obj);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
