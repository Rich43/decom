package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.res.e;
import androidx.core.content.res.h;
import u.h;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a */
    private static final o f3035a;

    /* renamed from: b */
    private static final androidx.collection.e f3036b;

    public static class a extends h.c {

        /* renamed from: a */
        private h.e f3037a;

        public a(h.e eVar) {
            this.f3037a = eVar;
        }

        @Override // u.h.c
        public void a(int i2) {
            h.e eVar = this.f3037a;
            if (eVar != null) {
                eVar.f(i2);
            }
        }

        @Override // u.h.c
        public void b(Typeface typeface) {
            h.e eVar = this.f3037a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            f3035a = new n();
        } else if (i2 >= 28) {
            f3035a = new m();
        } else if (i2 >= 26) {
            f3035a = new l();
        } else if (i2 < 24 || !k.j()) {
            f3035a = new j();
        } else {
            f3035a = new k();
        }
        f3036b = new androidx.collection.e(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i2) {
        if (context != null) {
            return Typeface.create(typeface, i2);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, h.b[] bVarArr, int i2) {
        return f3035a.b(context, cancellationSignal, bVarArr, i2);
    }

    public static Typeface c(Context context, e.b bVar, Resources resources, int i2, String str, int i3, int i4, h.e eVar, Handler handler, boolean z2) {
        Typeface typefaceA;
        if (bVar instanceof e.C0028e) {
            e.C0028e c0028e = (e.C0028e) bVar;
            Typeface typefaceG = g(c0028e.c());
            if (typefaceG != null) {
                if (eVar != null) {
                    eVar.d(typefaceG, handler);
                }
                return typefaceG;
            }
            typefaceA = u.h.c(context, c0028e.b(), i4, !z2 ? eVar != null : c0028e.a() != 0, z2 ? c0028e.d() : -1, h.e.e(handler), new a(eVar));
        } else {
            typefaceA = f3035a.a(context, (e.c) bVar, resources, i4);
            if (eVar != null) {
                if (typefaceA != null) {
                    eVar.d(typefaceA, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f3036b.d(e(resources, i2, str, i3, i4), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface d(Context context, Resources resources, int i2, String str, int i3, int i4) {
        Typeface typefaceD = f3035a.d(context, resources, i2, str, i4);
        if (typefaceD != null) {
            f3036b.d(e(resources, i2, str, i3, i4), typefaceD);
        }
        return typefaceD;
    }

    private static String e(Resources resources, int i2, String str, int i3, int i4) {
        return resources.getResourcePackageName(i2) + '-' + str + '-' + i3 + '-' + i2 + '-' + i4;
    }

    public static Typeface f(Resources resources, int i2, String str, int i3, int i4) {
        return (Typeface) f3036b.c(e(resources, i2, str, i3, i4));
    }

    private static Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
