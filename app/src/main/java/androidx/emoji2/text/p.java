package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* loaded from: classes.dex */
public class p {

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f3343d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    private final int f3344a;

    /* renamed from: b, reason: collision with root package name */
    private final n f3345b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f3346c = 0;

    p(n nVar, int i2) {
        this.f3345b = nVar;
        this.f3344a = i2;
    }

    private C.a g() {
        ThreadLocal threadLocal = f3343d;
        C.a aVar = (C.a) threadLocal.get();
        if (aVar == null) {
            aVar = new C.a();
            threadLocal.set(aVar);
        }
        this.f3345b.d().j(aVar, this.f3344a);
        return aVar;
    }

    public void a(Canvas canvas, float f2, float f3, Paint paint) {
        Typeface typefaceG = this.f3345b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceG);
        canvas.drawText(this.f3345b.c(), this.f3344a * 2, 2, f2, f3, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i2) {
        return g().h(i2);
    }

    public int c() {
        return g().i();
    }

    public int d() {
        return this.f3346c & 3;
    }

    public int e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public short h() {
        return g().m();
    }

    public int i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    public boolean k() {
        return (this.f3346c & 4) > 0;
    }

    public void l(boolean z2) {
        int iD = d();
        if (z2) {
            this.f3346c = iD | 4;
        } else {
            this.f3346c = iD;
        }
    }

    public void m(boolean z2) {
        int i2 = this.f3346c & 4;
        this.f3346c = z2 ? i2 | 2 : i2 | 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int iC = c();
        for (int i2 = 0; i2 < iC; i2++) {
            sb.append(Integer.toHexString(b(i2)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
