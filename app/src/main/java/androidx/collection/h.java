package androidx.collection;

/* loaded from: classes.dex */
public class h implements Cloneable {
    private static final Object e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private boolean f2621a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f2622b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f2623c;

    /* renamed from: d, reason: collision with root package name */
    private int f2624d;

    public h() {
        this(10);
    }

    private void d() {
        int i2 = this.f2624d;
        int[] iArr = this.f2622b;
        Object[] objArr = this.f2623c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != e) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f2621a = false;
        this.f2624d = i3;
    }

    public void a(int i2, Object obj) {
        int i3 = this.f2624d;
        if (i3 != 0 && i2 <= this.f2622b[i3 - 1]) {
            h(i2, obj);
            return;
        }
        if (this.f2621a && i3 >= this.f2622b.length) {
            d();
        }
        int i4 = this.f2624d;
        if (i4 >= this.f2622b.length) {
            int iE = c.e(i4 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.f2622b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f2623c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f2622b = iArr;
            this.f2623c = objArr;
        }
        this.f2622b[i4] = i2;
        this.f2623c[i4] = obj;
        this.f2624d = i4 + 1;
    }

    public void b() {
        int i2 = this.f2624d;
        Object[] objArr = this.f2623c;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f2624d = 0;
        this.f2621a = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h clone() {
        try {
            h hVar = (h) super.clone();
            hVar.f2622b = (int[]) this.f2622b.clone();
            hVar.f2623c = (Object[]) this.f2623c.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public Object e(int i2) {
        return f(i2, null);
    }

    public Object f(int i2, Object obj) {
        Object obj2;
        int iA = c.a(this.f2622b, this.f2624d, i2);
        return (iA < 0 || (obj2 = this.f2623c[iA]) == e) ? obj : obj2;
    }

    public int g(int i2) {
        if (this.f2621a) {
            d();
        }
        return this.f2622b[i2];
    }

    public void h(int i2, Object obj) {
        int iA = c.a(this.f2622b, this.f2624d, i2);
        if (iA >= 0) {
            this.f2623c[iA] = obj;
            return;
        }
        int i3 = ~iA;
        int i4 = this.f2624d;
        if (i3 < i4) {
            Object[] objArr = this.f2623c;
            if (objArr[i3] == e) {
                this.f2622b[i3] = i2;
                objArr[i3] = obj;
                return;
            }
        }
        if (this.f2621a && i4 >= this.f2622b.length) {
            d();
            i3 = ~c.a(this.f2622b, this.f2624d, i2);
        }
        int i5 = this.f2624d;
        if (i5 >= this.f2622b.length) {
            int iE = c.e(i5 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.f2622b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f2623c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f2622b = iArr;
            this.f2623c = objArr2;
        }
        int i6 = this.f2624d;
        if (i6 - i3 != 0) {
            int[] iArr3 = this.f2622b;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr4 = this.f2623c;
            System.arraycopy(objArr4, i3, objArr4, i7, this.f2624d - i3);
        }
        this.f2622b[i3] = i2;
        this.f2623c[i3] = obj;
        this.f2624d++;
    }

    public int i() {
        if (this.f2621a) {
            d();
        }
        return this.f2624d;
    }

    public Object j(int i2) {
        if (this.f2621a) {
            d();
        }
        return this.f2623c[i2];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2624d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2624d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(g(i2));
            sb.append('=');
            Object objJ = j(i2);
            if (objJ != this) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public h(int i2) {
        this.f2621a = false;
        if (i2 == 0) {
            this.f2622b = c.f2593a;
            this.f2623c = c.f2595c;
        } else {
            int iE = c.e(i2);
            this.f2622b = new int[iE];
            this.f2623c = new Object[iE];
        }
    }
}
