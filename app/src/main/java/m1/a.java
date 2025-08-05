package m1;

import b1.A;
import i1.g;

/* loaded from: classes.dex */
public class a implements Iterable, j1.a {

    /* renamed from: d */
    public static final C0093a f6691d = new C0093a(null);

    /* renamed from: a */
    private final int f6692a;

    /* renamed from: b */
    private final int f6693b;

    /* renamed from: c */
    private final int f6694c;

    /* renamed from: m1.a$a */
    public static final class C0093a {
        public /* synthetic */ C0093a(g gVar) {
            this();
        }

        public final a a(int i2, int i3, int i4) {
            return new a(i2, i3, i4);
        }

        private C0093a() {
        }
    }

    public a(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f6692a = i2;
        this.f6693b = d1.c.b(i2, i3, i4);
        this.f6694c = i4;
    }

    public final int a() {
        return this.f6692a;
    }

    public final int b() {
        return this.f6693b;
    }

    public final int c() {
        return this.f6694c;
    }

    @Override // java.lang.Iterable
    /* renamed from: d */
    public A iterator() {
        return new b(this.f6692a, this.f6693b, this.f6694c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f6692a != aVar.f6692a || this.f6693b != aVar.f6693b || this.f6694c != aVar.f6694c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f6692a * 31) + this.f6693b) * 31) + this.f6694c;
    }

    public boolean isEmpty() {
        if (this.f6694c > 0) {
            if (this.f6692a <= this.f6693b) {
                return false;
            }
        } else if (this.f6692a >= this.f6693b) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f6694c > 0) {
            sb = new StringBuilder();
            sb.append(this.f6692a);
            sb.append("..");
            sb.append(this.f6693b);
            sb.append(" step ");
            i2 = this.f6694c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f6692a);
            sb.append(" downTo ");
            sb.append(this.f6693b);
            sb.append(" step ");
            i2 = -this.f6694c;
        }
        sb.append(i2);
        return sb.toString();
    }
}
