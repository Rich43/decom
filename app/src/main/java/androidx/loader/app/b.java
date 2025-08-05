package androidx.loader.app;

import androidx.collection.h;
import androidx.lifecycle.E;
import androidx.lifecycle.F;
import androidx.lifecycle.G;
import androidx.lifecycle.I;
import androidx.lifecycle.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import v.AbstractC0339b;

/* loaded from: classes.dex */
class b extends androidx.loader.app.a {

    /* renamed from: a, reason: collision with root package name */
    private final m f3763a;

    /* renamed from: b, reason: collision with root package name */
    private final a f3764b;

    static class a extends E {

        /* renamed from: f, reason: collision with root package name */
        private static final F.b f3765f = new C0047a();

        /* renamed from: d, reason: collision with root package name */
        private h f3766d = new h();
        private boolean e = false;

        /* renamed from: androidx.loader.app.b$a$a, reason: collision with other inner class name */
        static class C0047a implements F.b {
            C0047a() {
            }

            @Override // androidx.lifecycle.F.b
            public E a(Class cls) {
                return new a();
            }

            @Override // androidx.lifecycle.F.b
            public /* synthetic */ E b(Class cls, I.a aVar) {
                return G.b(this, cls, aVar);
            }
        }

        a() {
        }

        static a g(I i2) {
            return (a) new F(i2, f3765f).a(a.class);
        }

        @Override // androidx.lifecycle.E
        protected void d() {
            super.d();
            if (this.f3766d.i() <= 0) {
                this.f3766d.b();
            } else {
                androidx.appcompat.app.F.a(this.f3766d.j(0));
                throw null;
            }
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3766d.i() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("    ");
                if (this.f3766d.i() <= 0) {
                    return;
                }
                androidx.appcompat.app.F.a(this.f3766d.j(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f3766d.g(0));
                printWriter.print(": ");
                throw null;
            }
        }

        void h() {
            if (this.f3766d.i() <= 0) {
                return;
            }
            androidx.appcompat.app.F.a(this.f3766d.j(0));
            throw null;
        }
    }

    b(m mVar, I i2) {
        this.f3763a = mVar;
        this.f3764b = a.g(i2);
    }

    @Override // androidx.loader.app.a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3764b.f(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public void c() {
        this.f3764b.h();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        AbstractC0339b.a(this.f3763a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
