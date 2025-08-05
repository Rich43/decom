package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class f {
    public static final f e = new f(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f3026a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3027b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3028c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3029d;

    static class a {
        static Insets a(int i2, int i3, int i4, int i5) {
            return Insets.of(i2, i3, i4, i5);
        }
    }

    private f(int i2, int i3, int i4, int i5) {
        this.f3026a = i2;
        this.f3027b = i3;
        this.f3028c = i4;
        this.f3029d = i5;
    }

    public static f a(f fVar, f fVar2) {
        return b(Math.max(fVar.f3026a, fVar2.f3026a), Math.max(fVar.f3027b, fVar2.f3027b), Math.max(fVar.f3028c, fVar2.f3028c), Math.max(fVar.f3029d, fVar2.f3029d));
    }

    public static f b(int i2, int i3, int i4, int i5) {
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? e : new f(i2, i3, i4, i5);
    }

    public static f c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static f d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f3026a, this.f3027b, this.f3028c, this.f3029d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f3029d == fVar.f3029d && this.f3026a == fVar.f3026a && this.f3028c == fVar.f3028c && this.f3027b == fVar.f3027b;
    }

    public int hashCode() {
        return (((((this.f3026a * 31) + this.f3027b) * 31) + this.f3028c) * 31) + this.f3029d;
    }

    public String toString() {
        return "Insets{left=" + this.f3026a + ", top=" + this.f3027b + ", right=" + this.f3028c + ", bottom=" + this.f3029d + '}';
    }
}
