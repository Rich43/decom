package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
class o {

    /* renamed from: a, reason: collision with root package name */
    final b f4282a;

    /* renamed from: b, reason: collision with root package name */
    a f4283b = new a();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f4284a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f4285b;

        /* renamed from: c, reason: collision with root package name */
        int f4286c;

        /* renamed from: d, reason: collision with root package name */
        int f4287d;
        int e;

        a() {
        }

        void a(int i2) {
            this.f4284a = i2 | this.f4284a;
        }

        boolean b() {
            int i2 = this.f4284a;
            if ((i2 & 7) != 0 && (i2 & c(this.f4287d, this.f4285b)) == 0) {
                return false;
            }
            int i3 = this.f4284a;
            if ((i3 & 112) != 0 && (i3 & (c(this.f4287d, this.f4286c) << 4)) == 0) {
                return false;
            }
            int i4 = this.f4284a;
            if ((i4 & 1792) != 0 && (i4 & (c(this.e, this.f4285b) << 8)) == 0) {
                return false;
            }
            int i5 = this.f4284a;
            return (i5 & 28672) == 0 || (i5 & (c(this.e, this.f4286c) << 12)) != 0;
        }

        int c(int i2, int i3) {
            if (i2 > i3) {
                return 1;
            }
            return i2 == i3 ? 2 : 4;
        }

        void d() {
            this.f4284a = 0;
        }

        void e(int i2, int i3, int i4, int i5) {
            this.f4285b = i2;
            this.f4286c = i3;
            this.f4287d = i4;
            this.e = i5;
        }
    }

    interface b {
        View a(int i2);

        int b();

        int c();

        int d(View view);

        int e(View view);
    }

    o(b bVar) {
        this.f4282a = bVar;
    }

    View a(int i2, int i3, int i4, int i5) {
        int iC = this.f4282a.c();
        int iB = this.f4282a.b();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View viewA = this.f4282a.a(i2);
            this.f4283b.e(iC, iB, this.f4282a.e(viewA), this.f4282a.d(viewA));
            if (i4 != 0) {
                this.f4283b.d();
                this.f4283b.a(i4);
                if (this.f4283b.b()) {
                    return viewA;
                }
            }
            if (i5 != 0) {
                this.f4283b.d();
                this.f4283b.a(i5);
                if (this.f4283b.b()) {
                    view = viewA;
                }
            }
            i2 += i6;
        }
        return view;
    }

    boolean b(View view, int i2) {
        this.f4283b.e(this.f4282a.c(), this.f4282a.b(), this.f4282a.e(view), this.f4282a.d(view));
        if (i2 == 0) {
            return false;
        }
        this.f4283b.d();
        this.f4283b.a(i2);
        return this.f4283b.b();
    }
}
