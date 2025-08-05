package androidx.activity;

import android.window.BackEvent;

/* loaded from: classes.dex */
public final class b {
    public static final a e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final float f1503a;

    /* renamed from: b, reason: collision with root package name */
    private final float f1504b;

    /* renamed from: c, reason: collision with root package name */
    private final float f1505c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1506d;

    public static final class a {
        public /* synthetic */ a(i1.g gVar) {
            this();
        }

        private a() {
        }
    }

    public b(float f2, float f3, float f4, int i2) {
        this.f1503a = f2;
        this.f1504b = f3;
        this.f1505c = f4;
        this.f1506d = i2;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f1503a + ", touchY=" + this.f1504b + ", progress=" + this.f1505c + ", swipeEdge=" + this.f1506d + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(BackEvent backEvent) {
        i1.k.e(backEvent, "backEvent");
        androidx.activity.a aVar = androidx.activity.a.f1502a;
        this(aVar.d(backEvent), aVar.e(backEvent), aVar.b(backEvent), aVar.c(backEvent));
    }
}
