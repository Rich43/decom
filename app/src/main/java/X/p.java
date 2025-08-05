package X;

import S.r;
import android.graphics.Paint;
import java.util.List;

/* loaded from: classes.dex */
public class p implements X.b {

    /* renamed from: a */
    private final String f1203a;

    /* renamed from: b */
    private final W.b f1204b;

    /* renamed from: c */
    private final List f1205c;

    /* renamed from: d */
    private final W.a f1206d;
    private final W.d e;

    /* renamed from: f */
    private final W.b f1207f;

    /* renamed from: g */
    private final b f1208g;

    /* renamed from: h */
    private final c f1209h;

    /* renamed from: i */
    private final float f1210i;

    /* renamed from: j */
    private final boolean f1211j;

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1212a;

        /* renamed from: b */
        static final /* synthetic */ int[] f1213b;

        static {
            int[] iArr = new int[c.values().length];
            f1213b = iArr;
            try {
                iArr[c.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1213b[c.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1213b[c.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[b.values().length];
            f1212a = iArr2;
            try {
                iArr2[b.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1212a[b.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1212a[b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum b {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap a() {
            int i2 = a.f1212a[ordinal()];
            return i2 != 1 ? i2 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    public enum c {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join a() {
            int i2 = a.f1213b[ordinal()];
            if (i2 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i2 == 2) {
                return Paint.Join.MITER;
            }
            if (i2 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public p(String str, W.b bVar, List list, W.a aVar, W.d dVar, W.b bVar2, b bVar3, c cVar, float f2, boolean z2) {
        this.f1203a = str;
        this.f1204b = bVar;
        this.f1205c = list;
        this.f1206d = aVar;
        this.e = dVar;
        this.f1207f = bVar2;
        this.f1208g = bVar3;
        this.f1209h = cVar;
        this.f1210i = f2;
        this.f1211j = z2;
    }

    @Override // X.b
    public S.c a(com.airbnb.lottie.a aVar, Y.a aVar2) {
        return new r(aVar, aVar2, this);
    }

    public b b() {
        return this.f1208g;
    }

    public W.a c() {
        return this.f1206d;
    }

    public W.b d() {
        return this.f1204b;
    }

    public c e() {
        return this.f1209h;
    }

    public List f() {
        return this.f1205c;
    }

    public float g() {
        return this.f1210i;
    }

    public String h() {
        return this.f1203a;
    }

    public W.d i() {
        return this.e;
    }

    public W.b j() {
        return this.f1207f;
    }

    public boolean k() {
        return this.f1211j;
    }
}
