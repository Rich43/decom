package androidx.collection;

/* loaded from: classes.dex */
public class d implements Cloneable {
    private static final Object e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private boolean f2596a;

    /* renamed from: b, reason: collision with root package name */
    private long[] f2597b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f2598c;

    /* renamed from: d, reason: collision with root package name */
    private int f2599d;

    public d() {
        this(10);
    }

    private void e() {
        int i2 = this.f2599d;
        long[] jArr = this.f2597b;
        Object[] objArr = this.f2598c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != e) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f2596a = false;
        this.f2599d = i3;
    }

    public void a(long j2, Object obj) {
        int i2 = this.f2599d;
        if (i2 != 0 && j2 <= this.f2597b[i2 - 1]) {
            j(j2, obj);
            return;
        }
        if (this.f2596a && i2 >= this.f2597b.length) {
            e();
        }
        int i3 = this.f2599d;
        if (i3 >= this.f2597b.length) {
            int iF = c.f(i3 + 1);
            long[] jArr = new long[iF];
            Object[] objArr = new Object[iF];
            long[] jArr2 = this.f2597b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f2598c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f2597b = jArr;
            this.f2598c = objArr;
        }
        this.f2597b[i3] = j2;
        this.f2598c[i3] = obj;
        this.f2599d = i3 + 1;
    }

    public void b() {
        int i2 = this.f2599d;
        Object[] objArr = this.f2598c;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f2599d = 0;
        this.f2596a = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            d dVar = (d) super.clone();
            dVar.f2597b = (long[]) this.f2597b.clone();
            dVar.f2598c = (Object[]) this.f2598c.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean d(long j2) {
        return h(j2) >= 0;
    }

    public Object f(long j2) {
        return g(j2, null);
    }

    public Object g(long j2, Object obj) {
        Object obj2;
        int iB = c.b(this.f2597b, this.f2599d, j2);
        return (iB < 0 || (obj2 = this.f2598c[iB]) == e) ? obj : obj2;
    }

    public int h(long j2) {
        if (this.f2596a) {
            e();
        }
        return c.b(this.f2597b, this.f2599d, j2);
    }

    public long i(int i2) {
        if (this.f2596a) {
            e();
        }
        return this.f2597b[i2];
    }

    public void j(long j2, Object obj) {
        int iB = c.b(this.f2597b, this.f2599d, j2);
        if (iB >= 0) {
            this.f2598c[iB] = obj;
            return;
        }
        int i2 = ~iB;
        int i3 = this.f2599d;
        if (i2 < i3) {
            Object[] objArr = this.f2598c;
            if (objArr[i2] == e) {
                this.f2597b[i2] = j2;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.f2596a && i3 >= this.f2597b.length) {
            e();
            i2 = ~c.b(this.f2597b, this.f2599d, j2);
        }
        int i4 = this.f2599d;
        if (i4 >= this.f2597b.length) {
            int iF = c.f(i4 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f2597b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f2598c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f2597b = jArr;
            this.f2598c = objArr2;
        }
        int i5 = this.f2599d;
        if (i5 - i2 != 0) {
            long[] jArr3 = this.f2597b;
            int i6 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i6, i5 - i2);
            Object[] objArr4 = this.f2598c;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f2599d - i2);
        }
        this.f2597b[i2] = j2;
        this.f2598c[i2] = obj;
        this.f2599d++;
    }

    public void k(long j2) {
        int iB = c.b(this.f2597b, this.f2599d, j2);
        if (iB >= 0) {
            Object[] objArr = this.f2598c;
            Object obj = objArr[iB];
            Object obj2 = e;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f2596a = true;
            }
        }
    }

    public void l(int i2) {
        Object[] objArr = this.f2598c;
        Object obj = objArr[i2];
        Object obj2 = e;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f2596a = true;
        }
    }

    public int m() {
        if (this.f2596a) {
            e();
        }
        return this.f2599d;
    }

    public Object n(int i2) {
        if (this.f2596a) {
            e();
        }
        return this.f2598c[i2];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2599d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2599d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(i(i2));
            sb.append('=');
            Object objN = n(i2);
            if (objN != this) {
                sb.append(objN);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i2) {
        this.f2596a = false;
        if (i2 == 0) {
            this.f2597b = c.f2594b;
            this.f2598c = c.f2595c;
        } else {
            int iF = c.f(i2);
            this.f2597b = new long[iF];
            this.f2598c = new Object[iF];
        }
    }
}
