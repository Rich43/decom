package androidx.media;

import java.util.Arrays;

/* loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    int f3772a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f3773b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f3774c = 0;

    /* renamed from: d, reason: collision with root package name */
    int f3775d = -1;

    AudioAttributesImplBase() {
    }

    public int a() {
        return this.f3773b;
    }

    public int b() {
        int i2 = this.f3774c;
        int iC = c();
        if (iC == 6) {
            i2 |= 4;
        } else if (iC == 7) {
            i2 |= 1;
        }
        return i2 & 273;
    }

    public int c() {
        int i2 = this.f3775d;
        return i2 != -1 ? i2 : AudioAttributesCompat.a(false, this.f3774c, this.f3772a);
    }

    public int d() {
        return this.f3772a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f3773b == audioAttributesImplBase.a() && this.f3774c == audioAttributesImplBase.b() && this.f3772a == audioAttributesImplBase.d() && this.f3775d == audioAttributesImplBase.f3775d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3773b), Integer.valueOf(this.f3774c), Integer.valueOf(this.f3772a), Integer.valueOf(this.f3775d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f3775d != -1) {
            sb.append(" stream=");
            sb.append(this.f3775d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f3772a));
        sb.append(" content=");
        sb.append(this.f3773b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3774c).toUpperCase());
        return sb.toString();
    }
}
