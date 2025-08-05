package v0;

import android.animation.TimeInterpolator;

/* renamed from: v0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0348b {

    /* renamed from: a, reason: collision with root package name */
    private long f7680a;

    /* renamed from: b, reason: collision with root package name */
    private long f7681b;

    /* renamed from: c, reason: collision with root package name */
    private TimeInterpolator f7682c = null;

    /* renamed from: d, reason: collision with root package name */
    private int f7683d = 0;
    private int e = 1;

    public C0348b(long j2, long j3) {
        this.f7680a = j2;
        this.f7681b = j3;
    }

    public long a() {
        return this.f7680a;
    }

    public long b() {
        return this.f7681b;
    }

    public TimeInterpolator c() {
        TimeInterpolator timeInterpolator = this.f7682c;
        return timeInterpolator != null ? timeInterpolator : AbstractC0347a.f7677b;
    }

    public int d() {
        return this.f7683d;
    }

    public int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0348b c0348b = (C0348b) obj;
        if (a() == c0348b.a() && b() == c0348b.b() && d() == c0348b.d() && e() == c0348b.e()) {
            return c().getClass().equals(c0348b.c().getClass());
        }
        return false;
    }

    public int hashCode() {
        return (((((((((int) (a() ^ (a() >>> 32))) * 31) + ((int) (b() ^ (b() >>> 32)))) * 31) + c().getClass().hashCode()) * 31) + d()) * 31) + e();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + a() + " duration: " + b() + " interpolator: " + c().getClass() + " repeatCount: " + d() + " repeatMode: " + e() + "}\n";
    }
}
