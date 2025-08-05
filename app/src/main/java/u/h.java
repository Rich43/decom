package u;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import v.AbstractC0345h;

/* loaded from: classes.dex */
public abstract class h {

    public static class a {

        /* renamed from: a */
        private final int f7547a;

        /* renamed from: b */
        private final b[] f7548b;

        public a(int i2, b[] bVarArr) {
            this.f7547a = i2;
            this.f7548b = bVarArr;
        }

        static a a(int i2, b[] bVarArr) {
            return new a(i2, bVarArr);
        }

        public b[] b() {
            return this.f7548b;
        }

        public int c() {
            return this.f7547a;
        }
    }

    public static class b {

        /* renamed from: a */
        private final Uri f7549a;

        /* renamed from: b */
        private final int f7550b;

        /* renamed from: c */
        private final int f7551c;

        /* renamed from: d */
        private final boolean f7552d;
        private final int e;

        public b(Uri uri, int i2, int i3, boolean z2, int i4) {
            this.f7549a = (Uri) AbstractC0345h.f(uri);
            this.f7550b = i2;
            this.f7551c = i3;
            this.f7552d = z2;
            this.e = i4;
        }

        static b a(Uri uri, int i2, int i3, boolean z2, int i4) {
            return new b(uri, i2, i3, z2, i4);
        }

        public int b() {
            return this.e;
        }

        public int c() {
            return this.f7550b;
        }

        public Uri d() {
            return this.f7549a;
        }

        public int e() {
            return this.f7551c;
        }

        public boolean f() {
            return this.f7552d;
        }
    }

    public static class c {
        public abstract void a(int i2);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return androidx.core.graphics.i.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, f fVar) {
        return e.e(context, fVar, cancellationSignal);
    }

    public static Typeface c(Context context, f fVar, int i2, boolean z2, int i3, Handler handler, c cVar) {
        C0329a c0329a = new C0329a(cVar, handler);
        return z2 ? g.e(context, fVar, c0329a, i2, i3) : g.d(context, fVar, i2, null, c0329a);
    }
}
