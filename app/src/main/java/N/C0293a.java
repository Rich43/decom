package n;

import java.util.Arrays;
import n.i;

/* renamed from: n.a */
/* loaded from: classes.dex */
public class C0293a {

    /* renamed from: b */
    private final C0294b f6708b;

    /* renamed from: c */
    private final C0295c f6709c;

    /* renamed from: a */
    int f6707a = 0;

    /* renamed from: d */
    private int f6710d = 8;
    private i e = null;

    /* renamed from: f */
    private int[] f6711f = new int[8];

    /* renamed from: g */
    private int[] f6712g = new int[8];

    /* renamed from: h */
    private float[] f6713h = new float[8];

    /* renamed from: i */
    private int f6714i = -1;

    /* renamed from: j */
    private int f6715j = -1;

    /* renamed from: k */
    private boolean f6716k = false;

    C0293a(C0294b c0294b, C0295c c0295c) {
        this.f6708b = c0294b;
        this.f6709c = c0295c;
    }

    private boolean k(i iVar, e eVar) {
        return iVar.f6750j <= 1;
    }

    final void a(i iVar, float f2, boolean z2) {
        if (f2 == 0.0f) {
            return;
        }
        int i2 = this.f6714i;
        if (i2 == -1) {
            this.f6714i = 0;
            this.f6713h[0] = f2;
            this.f6711f[0] = iVar.f6743b;
            this.f6712g[0] = -1;
            iVar.f6750j++;
            iVar.a(this.f6708b);
            this.f6707a++;
            if (this.f6716k) {
                return;
            }
            int i3 = this.f6715j + 1;
            this.f6715j = i3;
            int[] iArr = this.f6711f;
            if (i3 >= iArr.length) {
                this.f6716k = true;
                this.f6715j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i2 != -1 && i5 < this.f6707a; i5++) {
            int i6 = this.f6711f[i2];
            int i7 = iVar.f6743b;
            if (i6 == i7) {
                float[] fArr = this.f6713h;
                float f3 = fArr[i2] + f2;
                fArr[i2] = f3;
                if (f3 == 0.0f) {
                    if (i2 == this.f6714i) {
                        this.f6714i = this.f6712g[i2];
                    } else {
                        int[] iArr2 = this.f6712g;
                        iArr2[i4] = iArr2[i2];
                    }
                    if (z2) {
                        iVar.c(this.f6708b);
                    }
                    if (this.f6716k) {
                        this.f6715j = i2;
                    }
                    iVar.f6750j--;
                    this.f6707a--;
                    return;
                }
                return;
            }
            if (i6 < i7) {
                i4 = i2;
            }
            i2 = this.f6712g[i2];
        }
        int length = this.f6715j;
        int i8 = length + 1;
        if (this.f6716k) {
            int[] iArr3 = this.f6711f;
            if (iArr3[length] != -1) {
                length = iArr3.length;
            }
        } else {
            length = i8;
        }
        int[] iArr4 = this.f6711f;
        if (length >= iArr4.length && this.f6707a < iArr4.length) {
            int i9 = 0;
            while (true) {
                int[] iArr5 = this.f6711f;
                if (i9 >= iArr5.length) {
                    break;
                }
                if (iArr5[i9] == -1) {
                    length = i9;
                    break;
                }
                i9++;
            }
        }
        int[] iArr6 = this.f6711f;
        if (length >= iArr6.length) {
            length = iArr6.length;
            int i10 = this.f6710d * 2;
            this.f6710d = i10;
            this.f6716k = false;
            this.f6715j = length - 1;
            this.f6713h = Arrays.copyOf(this.f6713h, i10);
            this.f6711f = Arrays.copyOf(this.f6711f, this.f6710d);
            this.f6712g = Arrays.copyOf(this.f6712g, this.f6710d);
        }
        this.f6711f[length] = iVar.f6743b;
        this.f6713h[length] = f2;
        if (i4 != -1) {
            int[] iArr7 = this.f6712g;
            iArr7[length] = iArr7[i4];
            iArr7[i4] = length;
        } else {
            this.f6712g[length] = this.f6714i;
            this.f6714i = length;
        }
        iVar.f6750j++;
        iVar.a(this.f6708b);
        this.f6707a++;
        if (!this.f6716k) {
            this.f6715j++;
        }
        int i11 = this.f6715j;
        int[] iArr8 = this.f6711f;
        if (i11 >= iArr8.length) {
            this.f6716k = true;
            this.f6715j = iArr8.length - 1;
        }
    }

    i b(e eVar) {
        int i2 = this.f6714i;
        i iVar = null;
        i iVar2 = null;
        boolean z2 = false;
        boolean z3 = false;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i3 = 0; i2 != -1 && i3 < this.f6707a; i3++) {
            float[] fArr = this.f6713h;
            float f4 = fArr[i2];
            i iVar3 = this.f6709c.f6723c[this.f6711f[i2]];
            if (f4 < 0.0f) {
                if (f4 > -0.001f) {
                    fArr[i2] = 0.0f;
                    iVar3.c(this.f6708b);
                    f4 = 0.0f;
                }
            } else if (f4 < 0.001f) {
                fArr[i2] = 0.0f;
                iVar3.c(this.f6708b);
                f4 = 0.0f;
            }
            if (f4 != 0.0f) {
                if (iVar3.f6747g == i.a.UNRESTRICTED) {
                    if (iVar2 == null || f2 > f4) {
                        boolean zK = k(iVar3, eVar);
                        z2 = zK;
                        f2 = f4;
                        iVar2 = iVar3;
                    } else if (!z2 && k(iVar3, eVar)) {
                        f2 = f4;
                        iVar2 = iVar3;
                        z2 = true;
                    }
                } else if (iVar2 == null && f4 < 0.0f) {
                    if (iVar == null || f3 > f4) {
                        boolean zK2 = k(iVar3, eVar);
                        z3 = zK2;
                        f3 = f4;
                        iVar = iVar3;
                    } else if (!z3 && k(iVar3, eVar)) {
                        f3 = f4;
                        iVar = iVar3;
                        z3 = true;
                    }
                }
            }
            i2 = this.f6712g[i2];
        }
        return iVar2 != null ? iVar2 : iVar;
    }

    public final void c() {
        int i2 = this.f6714i;
        for (int i3 = 0; i2 != -1 && i3 < this.f6707a; i3++) {
            i iVar = this.f6709c.f6723c[this.f6711f[i2]];
            if (iVar != null) {
                iVar.c(this.f6708b);
            }
            i2 = this.f6712g[i2];
        }
        this.f6714i = -1;
        this.f6715j = -1;
        this.f6716k = false;
        this.f6707a = 0;
    }

    final boolean d(i iVar) {
        int i2 = this.f6714i;
        if (i2 == -1) {
            return false;
        }
        for (int i3 = 0; i2 != -1 && i3 < this.f6707a; i3++) {
            if (this.f6711f[i2] == iVar.f6743b) {
                return true;
            }
            i2 = this.f6712g[i2];
        }
        return false;
    }

    void e(float f2) {
        int i2 = this.f6714i;
        for (int i3 = 0; i2 != -1 && i3 < this.f6707a; i3++) {
            float[] fArr = this.f6713h;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f6712g[i2];
        }
    }

    public final float f(i iVar) {
        int i2 = this.f6714i;
        for (int i3 = 0; i2 != -1 && i3 < this.f6707a; i3++) {
            if (this.f6711f[i2] == iVar.f6743b) {
                return this.f6713h[i2];
            }
            i2 = this.f6712g[i2];
        }
        return 0.0f;
    }

    i g(boolean[] zArr, i iVar) {
        i.a aVar;
        int i2 = this.f6714i;
        i iVar2 = null;
        float f2 = 0.0f;
        for (int i3 = 0; i2 != -1 && i3 < this.f6707a; i3++) {
            float f3 = this.f6713h[i2];
            if (f3 < 0.0f) {
                i iVar3 = this.f6709c.f6723c[this.f6711f[i2]];
                if ((zArr == null || !zArr[iVar3.f6743b]) && iVar3 != iVar && (((aVar = iVar3.f6747g) == i.a.SLACK || aVar == i.a.ERROR) && f3 < f2)) {
                    f2 = f3;
                    iVar2 = iVar3;
                }
            }
            i2 = this.f6712g[i2];
        }
        return iVar2;
    }

    final i h(int i2) {
        int i3 = this.f6714i;
        for (int i4 = 0; i3 != -1 && i4 < this.f6707a; i4++) {
            if (i4 == i2) {
                return this.f6709c.f6723c[this.f6711f[i3]];
            }
            i3 = this.f6712g[i3];
        }
        return null;
    }

    final float i(int i2) {
        int i3 = this.f6714i;
        for (int i4 = 0; i3 != -1 && i4 < this.f6707a; i4++) {
            if (i4 == i2) {
                return this.f6713h[i3];
            }
            i3 = this.f6712g[i3];
        }
        return 0.0f;
    }

    void j() {
        int i2 = this.f6714i;
        for (int i3 = 0; i2 != -1 && i3 < this.f6707a; i3++) {
            float[] fArr = this.f6713h;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.f6712g[i2];
        }
    }

    public final void l(i iVar, float f2) {
        if (f2 == 0.0f) {
            m(iVar, true);
            return;
        }
        int i2 = this.f6714i;
        if (i2 == -1) {
            this.f6714i = 0;
            this.f6713h[0] = f2;
            this.f6711f[0] = iVar.f6743b;
            this.f6712g[0] = -1;
            iVar.f6750j++;
            iVar.a(this.f6708b);
            this.f6707a++;
            if (this.f6716k) {
                return;
            }
            int i3 = this.f6715j + 1;
            this.f6715j = i3;
            int[] iArr = this.f6711f;
            if (i3 >= iArr.length) {
                this.f6716k = true;
                this.f6715j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i2 != -1 && i5 < this.f6707a; i5++) {
            int i6 = this.f6711f[i2];
            int i7 = iVar.f6743b;
            if (i6 == i7) {
                this.f6713h[i2] = f2;
                return;
            }
            if (i6 < i7) {
                i4 = i2;
            }
            i2 = this.f6712g[i2];
        }
        int length = this.f6715j;
        int i8 = length + 1;
        if (this.f6716k) {
            int[] iArr2 = this.f6711f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i8;
        }
        int[] iArr3 = this.f6711f;
        if (length >= iArr3.length && this.f6707a < iArr3.length) {
            int i9 = 0;
            while (true) {
                int[] iArr4 = this.f6711f;
                if (i9 >= iArr4.length) {
                    break;
                }
                if (iArr4[i9] == -1) {
                    length = i9;
                    break;
                }
                i9++;
            }
        }
        int[] iArr5 = this.f6711f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i10 = this.f6710d * 2;
            this.f6710d = i10;
            this.f6716k = false;
            this.f6715j = length - 1;
            this.f6713h = Arrays.copyOf(this.f6713h, i10);
            this.f6711f = Arrays.copyOf(this.f6711f, this.f6710d);
            this.f6712g = Arrays.copyOf(this.f6712g, this.f6710d);
        }
        this.f6711f[length] = iVar.f6743b;
        this.f6713h[length] = f2;
        if (i4 != -1) {
            int[] iArr6 = this.f6712g;
            iArr6[length] = iArr6[i4];
            iArr6[i4] = length;
        } else {
            this.f6712g[length] = this.f6714i;
            this.f6714i = length;
        }
        iVar.f6750j++;
        iVar.a(this.f6708b);
        int i11 = this.f6707a + 1;
        this.f6707a = i11;
        if (!this.f6716k) {
            this.f6715j++;
        }
        int[] iArr7 = this.f6711f;
        if (i11 >= iArr7.length) {
            this.f6716k = true;
        }
        if (this.f6715j >= iArr7.length) {
            this.f6716k = true;
            this.f6715j = iArr7.length - 1;
        }
    }

    public final float m(i iVar, boolean z2) {
        if (this.e == iVar) {
            this.e = null;
        }
        int i2 = this.f6714i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f6707a) {
            if (this.f6711f[i2] == iVar.f6743b) {
                if (i2 == this.f6714i) {
                    this.f6714i = this.f6712g[i2];
                } else {
                    int[] iArr = this.f6712g;
                    iArr[i4] = iArr[i2];
                }
                if (z2) {
                    iVar.c(this.f6708b);
                }
                iVar.f6750j--;
                this.f6707a--;
                this.f6711f[i2] = -1;
                if (this.f6716k) {
                    this.f6715j = i2;
                }
                return this.f6713h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f6712g[i2];
        }
        return 0.0f;
    }

    final void n(C0294b c0294b, C0294b c0294b2, boolean z2) {
        int i2 = this.f6714i;
        while (true) {
            for (int i3 = 0; i2 != -1 && i3 < this.f6707a; i3++) {
                int i4 = this.f6711f[i2];
                i iVar = c0294b2.f6717a;
                if (i4 == iVar.f6743b) {
                    float f2 = this.f6713h[i2];
                    m(iVar, z2);
                    C0293a c0293a = c0294b2.f6720d;
                    int i5 = c0293a.f6714i;
                    for (int i6 = 0; i5 != -1 && i6 < c0293a.f6707a; i6++) {
                        a(this.f6709c.f6723c[c0293a.f6711f[i5]], c0293a.f6713h[i5] * f2, z2);
                        i5 = c0293a.f6712g[i5];
                    }
                    c0294b.f6718b += c0294b2.f6718b * f2;
                    if (z2) {
                        c0294b2.f6717a.c(c0294b);
                    }
                    i2 = this.f6714i;
                } else {
                    i2 = this.f6712g[i2];
                }
            }
            return;
        }
    }

    void o(C0294b c0294b, C0294b[] c0294bArr) {
        int i2 = this.f6714i;
        while (true) {
            for (int i3 = 0; i2 != -1 && i3 < this.f6707a; i3++) {
                i iVar = this.f6709c.f6723c[this.f6711f[i2]];
                if (iVar.f6744c != -1) {
                    float f2 = this.f6713h[i2];
                    m(iVar, true);
                    C0294b c0294b2 = c0294bArr[iVar.f6744c];
                    if (!c0294b2.e) {
                        C0293a c0293a = c0294b2.f6720d;
                        int i4 = c0293a.f6714i;
                        for (int i5 = 0; i4 != -1 && i5 < c0293a.f6707a; i5++) {
                            a(this.f6709c.f6723c[c0293a.f6711f[i4]], c0293a.f6713h[i4] * f2, true);
                            i4 = c0293a.f6712g[i4];
                        }
                    }
                    c0294b.f6718b += c0294b2.f6718b * f2;
                    c0294b2.f6717a.c(c0294b);
                    i2 = this.f6714i;
                } else {
                    i2 = this.f6712g[i2];
                }
            }
            return;
        }
    }

    public String toString() {
        int i2 = this.f6714i;
        String str = "";
        for (int i3 = 0; i2 != -1 && i3 < this.f6707a; i3++) {
            str = ((str + " -> ") + this.f6713h[i2] + " : ") + this.f6709c.f6723c[this.f6711f[i2]];
            i2 = this.f6712g[i2];
        }
        return str;
    }
}
