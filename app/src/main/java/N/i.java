package n;

import java.util.Arrays;

/* loaded from: classes.dex */
public class i {

    /* renamed from: k, reason: collision with root package name */
    private static int f6741k = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f6742a;
    public float e;

    /* renamed from: g, reason: collision with root package name */
    a f6747g;

    /* renamed from: b, reason: collision with root package name */
    public int f6743b = -1;

    /* renamed from: c, reason: collision with root package name */
    int f6744c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f6745d = 0;

    /* renamed from: f, reason: collision with root package name */
    float[] f6746f = new float[7];

    /* renamed from: h, reason: collision with root package name */
    C0294b[] f6748h = new C0294b[8];

    /* renamed from: i, reason: collision with root package name */
    int f6749i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f6750j = 0;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f6747g = aVar;
    }

    static void b() {
        f6741k++;
    }

    public final void a(C0294b c0294b) {
        int i2 = 0;
        while (true) {
            int i3 = this.f6749i;
            if (i2 >= i3) {
                C0294b[] c0294bArr = this.f6748h;
                if (i3 >= c0294bArr.length) {
                    this.f6748h = (C0294b[]) Arrays.copyOf(c0294bArr, c0294bArr.length * 2);
                }
                C0294b[] c0294bArr2 = this.f6748h;
                int i4 = this.f6749i;
                c0294bArr2[i4] = c0294b;
                this.f6749i = i4 + 1;
                return;
            }
            if (this.f6748h[i2] == c0294b) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void c(C0294b c0294b) {
        int i2 = this.f6749i;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f6748h[i3] == c0294b) {
                for (int i4 = 0; i4 < (i2 - i3) - 1; i4++) {
                    C0294b[] c0294bArr = this.f6748h;
                    int i5 = i3 + i4;
                    c0294bArr[i5] = c0294bArr[i5 + 1];
                }
                this.f6749i--;
                return;
            }
        }
    }

    public void d() {
        this.f6742a = null;
        this.f6747g = a.UNKNOWN;
        this.f6745d = 0;
        this.f6743b = -1;
        this.f6744c = -1;
        this.e = 0.0f;
        this.f6749i = 0;
        this.f6750j = 0;
    }

    public void e(a aVar, String str) {
        this.f6747g = aVar;
    }

    public final void f(C0294b c0294b) {
        int i2 = this.f6749i;
        for (int i3 = 0; i3 < i2; i3++) {
            C0294b c0294b2 = this.f6748h[i3];
            c0294b2.f6720d.n(c0294b2, c0294b, false);
        }
        this.f6749i = 0;
    }

    public String toString() {
        return "" + this.f6742a;
    }
}
