package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import java.util.ArrayList;
import java.util.List;
import v.C0343f;
import v.InterfaceC0342e;

/* loaded from: classes.dex */
class a implements j.a {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0342e f4108a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f4109b;

    /* renamed from: c, reason: collision with root package name */
    final ArrayList f4110c;

    /* renamed from: d, reason: collision with root package name */
    final InterfaceC0050a f4111d;
    Runnable e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f4112f;

    /* renamed from: g, reason: collision with root package name */
    final j f4113g;

    /* renamed from: h, reason: collision with root package name */
    private int f4114h;

    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    interface InterfaceC0050a {
        void a(int i2, int i3);

        void b(b bVar);

        RecyclerView.C c(int i2);

        void d(int i2, int i3);

        void e(int i2, int i3);

        void f(b bVar);

        void g(int i2, int i3);

        void h(int i2, int i3, Object obj);
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        int f4115a;

        /* renamed from: b, reason: collision with root package name */
        int f4116b;

        /* renamed from: c, reason: collision with root package name */
        Object f4117c;

        /* renamed from: d, reason: collision with root package name */
        int f4118d;

        b(int i2, int i3, int i4, Object obj) {
            this.f4115a = i2;
            this.f4116b = i3;
            this.f4118d = i4;
            this.f4117c = obj;
        }

        String a() {
            int i2 = this.f4115a;
            return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i2 = this.f4115a;
            if (i2 != bVar.f4115a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f4118d - this.f4116b) == 1 && this.f4118d == bVar.f4116b && this.f4116b == bVar.f4118d) {
                return true;
            }
            if (this.f4118d != bVar.f4118d || this.f4116b != bVar.f4116b) {
                return false;
            }
            Object obj2 = this.f4117c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f4117c)) {
                    return false;
                }
            } else if (bVar.f4117c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f4115a * 31) + this.f4116b) * 31) + this.f4118d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f4116b + "c:" + this.f4118d + ",p:" + this.f4117c + "]";
        }
    }

    a(InterfaceC0050a interfaceC0050a) {
        this(interfaceC0050a, false);
    }

    private void c(b bVar) {
        t(bVar);
    }

    private void d(b bVar) {
        t(bVar);
    }

    private void f(b bVar) {
        boolean z2;
        char c2;
        int i2 = bVar.f4116b;
        int i3 = bVar.f4118d + i2;
        char c3 = 65535;
        int i4 = i2;
        int i5 = 0;
        while (i4 < i3) {
            if (this.f4111d.c(i4) != null || h(i4)) {
                if (c3 == 0) {
                    k(b(2, i2, i5, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    t(b(2, i2, i5, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c2 = 0;
            }
            if (z2) {
                i4 -= i5;
                i3 -= i5;
                i5 = 1;
            } else {
                i5++;
            }
            i4++;
            c3 = c2;
        }
        if (i5 != bVar.f4118d) {
            a(bVar);
            bVar = b(2, i2, i5, null);
        }
        if (c3 == 0) {
            k(bVar);
        } else {
            t(bVar);
        }
    }

    private void g(b bVar) {
        int i2 = bVar.f4116b;
        int i3 = bVar.f4118d + i2;
        int i4 = i2;
        char c2 = 65535;
        int i5 = 0;
        while (i2 < i3) {
            if (this.f4111d.c(i2) != null || h(i2)) {
                if (c2 == 0) {
                    k(b(4, i4, i5, bVar.f4117c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    t(b(4, i4, i5, bVar.f4117c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 0;
            }
            i5++;
            i2++;
        }
        if (i5 != bVar.f4118d) {
            Object obj = bVar.f4117c;
            a(bVar);
            bVar = b(4, i4, i5, obj);
        }
        if (c2 == 0) {
            k(bVar);
        } else {
            t(bVar);
        }
    }

    private boolean h(int i2) {
        int size = this.f4110c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = (b) this.f4110c.get(i3);
            int i4 = bVar.f4115a;
            if (i4 == 8) {
                if (n(bVar.f4118d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = bVar.f4116b;
                int i6 = bVar.f4118d + i5;
                while (i5 < i6) {
                    if (n(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i2;
        int i3 = bVar.f4115a;
        if (i3 == 1 || i3 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iX = x(bVar.f4116b, i3);
        int i4 = bVar.f4116b;
        int i5 = bVar.f4115a;
        if (i5 == 2) {
            i2 = 0;
        } else {
            if (i5 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i2 = 1;
        }
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.f4118d; i7++) {
            int iX2 = x(bVar.f4116b + (i2 * i7), bVar.f4115a);
            int i8 = bVar.f4115a;
            if (i8 == 2 ? iX2 != iX : !(i8 == 4 && iX2 == iX + 1)) {
                b bVarB = b(i8, iX, i6, bVar.f4117c);
                l(bVarB, i4);
                a(bVarB);
                if (bVar.f4115a == 4) {
                    i4 += i6;
                }
                iX = iX2;
                i6 = 1;
            } else {
                i6++;
            }
        }
        Object obj = bVar.f4117c;
        a(bVar);
        if (i6 > 0) {
            b bVarB2 = b(bVar.f4115a, iX, i6, obj);
            l(bVarB2, i4);
            a(bVarB2);
        }
    }

    private void t(b bVar) {
        this.f4110c.add(bVar);
        int i2 = bVar.f4115a;
        if (i2 == 1) {
            this.f4111d.g(bVar.f4116b, bVar.f4118d);
            return;
        }
        if (i2 == 2) {
            this.f4111d.e(bVar.f4116b, bVar.f4118d);
            return;
        }
        if (i2 == 4) {
            this.f4111d.h(bVar.f4116b, bVar.f4118d, bVar.f4117c);
        } else {
            if (i2 == 8) {
                this.f4111d.a(bVar.f4116b, bVar.f4118d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int x(int i2, int i3) {
        int i4;
        int i5;
        for (int size = this.f4110c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f4110c.get(size);
            int i6 = bVar.f4115a;
            if (i6 == 8) {
                int i7 = bVar.f4116b;
                int i8 = bVar.f4118d;
                if (i7 < i8) {
                    i5 = i7;
                    i4 = i8;
                } else {
                    i4 = i7;
                    i5 = i8;
                }
                if (i2 < i5 || i2 > i4) {
                    if (i2 < i7) {
                        if (i3 == 1) {
                            bVar.f4116b = i7 + 1;
                            bVar.f4118d = i8 + 1;
                        } else if (i3 == 2) {
                            bVar.f4116b = i7 - 1;
                            bVar.f4118d = i8 - 1;
                        }
                    }
                } else if (i5 == i7) {
                    if (i3 == 1) {
                        bVar.f4118d = i8 + 1;
                    } else if (i3 == 2) {
                        bVar.f4118d = i8 - 1;
                    }
                    i2++;
                } else {
                    if (i3 == 1) {
                        bVar.f4116b = i7 + 1;
                    } else if (i3 == 2) {
                        bVar.f4116b = i7 - 1;
                    }
                    i2--;
                }
            } else {
                int i9 = bVar.f4116b;
                if (i9 <= i2) {
                    if (i6 == 1) {
                        i2 -= bVar.f4118d;
                    } else if (i6 == 2) {
                        i2 += bVar.f4118d;
                    }
                } else if (i3 == 1) {
                    bVar.f4116b = i9 + 1;
                } else if (i3 == 2) {
                    bVar.f4116b = i9 - 1;
                }
            }
        }
        for (int size2 = this.f4110c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f4110c.get(size2);
            if (bVar2.f4115a == 8) {
                int i10 = bVar2.f4118d;
                if (i10 == bVar2.f4116b || i10 < 0) {
                    this.f4110c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f4118d <= 0) {
                this.f4110c.remove(size2);
                a(bVar2);
            }
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.j.a
    public void a(b bVar) {
        if (this.f4112f) {
            return;
        }
        bVar.f4117c = null;
        this.f4108a.release(bVar);
    }

    @Override // androidx.recyclerview.widget.j.a
    public b b(int i2, int i3, int i4, Object obj) {
        b bVar = (b) this.f4108a.acquire();
        if (bVar == null) {
            return new b(i2, i3, i4, obj);
        }
        bVar.f4115a = i2;
        bVar.f4116b = i3;
        bVar.f4118d = i4;
        bVar.f4117c = obj;
        return bVar;
    }

    public int e(int i2) {
        int size = this.f4109b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = (b) this.f4109b.get(i3);
            int i4 = bVar.f4115a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.f4116b;
                    if (i5 <= i2) {
                        int i6 = bVar.f4118d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.f4116b;
                    if (i7 == i2) {
                        i2 = bVar.f4118d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.f4118d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.f4116b <= i2) {
                i2 += bVar.f4118d;
            }
        }
        return i2;
    }

    void i() {
        int size = this.f4110c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4111d.b((b) this.f4110c.get(i2));
        }
        v(this.f4110c);
        this.f4114h = 0;
    }

    void j() {
        i();
        int size = this.f4109b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.f4109b.get(i2);
            int i3 = bVar.f4115a;
            if (i3 == 1) {
                this.f4111d.b(bVar);
                this.f4111d.g(bVar.f4116b, bVar.f4118d);
            } else if (i3 == 2) {
                this.f4111d.b(bVar);
                this.f4111d.d(bVar.f4116b, bVar.f4118d);
            } else if (i3 == 4) {
                this.f4111d.b(bVar);
                this.f4111d.h(bVar.f4116b, bVar.f4118d, bVar.f4117c);
            } else if (i3 == 8) {
                this.f4111d.b(bVar);
                this.f4111d.a(bVar.f4116b, bVar.f4118d);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        v(this.f4109b);
        this.f4114h = 0;
    }

    void l(b bVar, int i2) {
        this.f4111d.f(bVar);
        int i3 = bVar.f4115a;
        if (i3 == 2) {
            this.f4111d.d(i2, bVar.f4118d);
        } else {
            if (i3 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f4111d.h(i2, bVar.f4118d, bVar.f4117c);
        }
    }

    int m(int i2) {
        return n(i2, 0);
    }

    int n(int i2, int i3) {
        int size = this.f4110c.size();
        while (i3 < size) {
            b bVar = (b) this.f4110c.get(i3);
            int i4 = bVar.f4115a;
            if (i4 == 8) {
                int i5 = bVar.f4116b;
                if (i5 == i2) {
                    i2 = bVar.f4118d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (bVar.f4118d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = bVar.f4116b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = bVar.f4118d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += bVar.f4118d;
                }
            }
            i3++;
        }
        return i2;
    }

    boolean o(int i2) {
        return (i2 & this.f4114h) != 0;
    }

    boolean p() {
        return this.f4109b.size() > 0;
    }

    boolean q() {
        return (this.f4110c.isEmpty() || this.f4109b.isEmpty()) ? false : true;
    }

    boolean r(int i2, int i3, Object obj) {
        if (i3 < 1) {
            return false;
        }
        this.f4109b.add(b(4, i2, i3, obj));
        this.f4114h |= 4;
        return this.f4109b.size() == 1;
    }

    boolean s(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f4109b.add(b(2, i2, i3, null));
        this.f4114h |= 2;
        return this.f4109b.size() == 1;
    }

    void u() {
        this.f4113g.b(this.f4109b);
        int size = this.f4109b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.f4109b.get(i2);
            int i3 = bVar.f4115a;
            if (i3 == 1) {
                c(bVar);
            } else if (i3 == 2) {
                f(bVar);
            } else if (i3 == 4) {
                g(bVar);
            } else if (i3 == 8) {
                d(bVar);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f4109b.clear();
    }

    void v(List list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a((b) list.get(i2));
        }
        list.clear();
    }

    void w() {
        v(this.f4109b);
        v(this.f4110c);
        this.f4114h = 0;
    }

    a(InterfaceC0050a interfaceC0050a, boolean z2) {
        this.f4108a = new C0343f(30);
        this.f4109b = new ArrayList();
        this.f4110c = new ArrayList();
        this.f4114h = 0;
        this.f4111d = interfaceC0050a;
        this.f4112f = z2;
        this.f4113g = new j(this);
    }
}
