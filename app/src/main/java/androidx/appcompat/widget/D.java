package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.content.res.h;
import defpackage.e;
import java.lang.ref.WeakReference;
import java.util.Locale;
import z.AbstractC0378c;

/* loaded from: classes.dex */
class D {

    /* renamed from: a */
    private final TextView f2147a;

    /* renamed from: b */
    private b0 f2148b;

    /* renamed from: c */
    private b0 f2149c;

    /* renamed from: d */
    private b0 f2150d;
    private b0 e;

    /* renamed from: f */
    private b0 f2151f;

    /* renamed from: g */
    private b0 f2152g;

    /* renamed from: h */
    private b0 f2153h;

    /* renamed from: i */
    private final F f2154i;

    /* renamed from: j */
    private int f2155j = 0;

    /* renamed from: k */
    private int f2156k = -1;

    /* renamed from: l */
    private Typeface f2157l;

    /* renamed from: m */
    private boolean f2158m;

    class a extends h.e {

        /* renamed from: a */
        final /* synthetic */ int f2159a;

        /* renamed from: b */
        final /* synthetic */ int f2160b;

        /* renamed from: c */
        final /* synthetic */ WeakReference f2161c;

        a(int i2, int i3, WeakReference weakReference) {
            this.f2159a = i2;
            this.f2160b = i3;
            this.f2161c = weakReference;
        }

        @Override // androidx.core.content.res.h.e
        /* renamed from: h */
        public void f(int i2) {
        }

        @Override // androidx.core.content.res.h.e
        /* renamed from: i */
        public void g(Typeface typeface) {
            int i2;
            if (Build.VERSION.SDK_INT >= 28 && (i2 = this.f2159a) != -1) {
                typeface = f.a(typeface, i2, (this.f2160b & 2) != 0);
            }
            D.this.n(this.f2161c, typeface);
        }
    }

    class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ TextView f2163a;

        /* renamed from: b */
        final /* synthetic */ Typeface f2164b;

        /* renamed from: c */
        final /* synthetic */ int f2165c;

        b(TextView textView, Typeface typeface, int i2) {
            this.f2163a = textView;
            this.f2164b = typeface;
            this.f2165c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2163a.setTypeface(this.f2164b, this.f2165c);
        }
    }

    static class c {
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    static class d {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    static class e {
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void b(TextView textView, int i2, int i3, int i4, int i5) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }

        static void c(TextView textView, int[] iArr, int i2) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }

        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    static class f {
        static Typeface a(Typeface typeface, int i2, boolean z2) {
            return Typeface.create(typeface, i2, z2);
        }
    }

    D(TextView textView) {
        this.f2147a = textView;
        this.f2154i = new F(textView);
    }

    private void B(int i2, float f2) {
        this.f2154i.t(i2, f2);
    }

    private void C(Context context, d0 d0Var) {
        String strN;
        this.f2155j = d0Var.j(e.m.q2, this.f2155j);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int iJ = d0Var.j(e.m.v2, -1);
            this.f2156k = iJ;
            if (iJ != -1) {
                this.f2155j &= 2;
            }
        }
        int i3 = e.m.u2;
        if (!d0Var.r(i3) && !d0Var.r(e.m.w2)) {
            int i4 = e.m.p2;
            if (d0Var.r(i4)) {
                this.f2158m = false;
                int iJ2 = d0Var.j(i4, 1);
                if (iJ2 == 1) {
                    this.f2157l = Typeface.SANS_SERIF;
                    return;
                } else if (iJ2 == 2) {
                    this.f2157l = Typeface.SERIF;
                    return;
                } else {
                    if (iJ2 != 3) {
                        return;
                    }
                    this.f2157l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f2157l = null;
        int i5 = e.m.w2;
        if (d0Var.r(i5)) {
            i3 = i5;
        }
        int i6 = this.f2156k;
        int i7 = this.f2155j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceI = d0Var.i(i3, this.f2155j, new a(i6, i7, new WeakReference(this.f2147a)));
                if (typefaceI != null) {
                    if (i2 < 28 || this.f2156k == -1) {
                        this.f2157l = typefaceI;
                    } else {
                        this.f2157l = f.a(Typeface.create(typefaceI, 0), this.f2156k, (this.f2155j & 2) != 0);
                    }
                }
                this.f2158m = this.f2157l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f2157l != null || (strN = d0Var.n(i3)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f2156k == -1) {
            this.f2157l = Typeface.create(strN, this.f2155j);
        } else {
            this.f2157l = f.a(Typeface.create(strN, 0), this.f2156k, (this.f2155j & 2) != 0);
        }
    }

    private void a(Drawable drawable, b0 b0Var) {
        if (drawable == null || b0Var == null) {
            return;
        }
        C0143k.i(drawable, b0Var, this.f2147a.getDrawableState());
    }

    private static b0 d(Context context, C0143k c0143k, int i2) {
        ColorStateList colorStateListF = c0143k.f(context, i2);
        if (colorStateListF == null) {
            return null;
        }
        b0 b0Var = new b0();
        b0Var.f2383d = true;
        b0Var.f2380a = colorStateListF;
        return b0Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f2147a.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.f2147a;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f2147a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.f2147a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f2147a.getCompoundDrawables();
        TextView textView2 = this.f2147a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        b0 b0Var = this.f2153h;
        this.f2148b = b0Var;
        this.f2149c = b0Var;
        this.f2150d = b0Var;
        this.e = b0Var;
        this.f2151f = b0Var;
        this.f2152g = b0Var;
    }

    void A(int i2, float f2) {
        if (o0.f2505c || l()) {
            return;
        }
        B(i2, f2);
    }

    void b() {
        if (this.f2148b != null || this.f2149c != null || this.f2150d != null || this.e != null) {
            Drawable[] compoundDrawables = this.f2147a.getCompoundDrawables();
            a(compoundDrawables[0], this.f2148b);
            a(compoundDrawables[1], this.f2149c);
            a(compoundDrawables[2], this.f2150d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f2151f == null && this.f2152g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f2147a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f2151f);
        a(compoundDrawablesRelative[2], this.f2152g);
    }

    void c() {
        this.f2154i.a();
    }

    int e() {
        return this.f2154i.f();
    }

    int f() {
        return this.f2154i.g();
    }

    int g() {
        return this.f2154i.h();
    }

    int[] h() {
        return this.f2154i.i();
    }

    int i() {
        return this.f2154i.j();
    }

    ColorStateList j() {
        b0 b0Var = this.f2153h;
        if (b0Var != null) {
            return b0Var.f2380a;
        }
        return null;
    }

    PorterDuff.Mode k() {
        b0 b0Var = this.f2153h;
        if (b0Var != null) {
            return b0Var.f2381b;
        }
        return null;
    }

    boolean l() {
        return this.f2154i.n();
    }

    /* JADX WARN: Removed duplicated region for block: B:201:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:346:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m(android.util.AttributeSet r23, int r24) {
        /*
            Method dump skipped, instructions count: 830
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.D.m(android.util.AttributeSet, int):void");
    }

    void n(WeakReference weakReference, Typeface typeface) {
        if (this.f2158m) {
            this.f2157l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new b(textView, typeface, this.f2155j));
                } else {
                    textView.setTypeface(typeface, this.f2155j);
                }
            }
        }
    }

    void o(boolean z2, int i2, int i3, int i4, int i5) {
        if (o0.f2505c) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i2) {
        String strN;
        ColorStateList colorStateListC;
        ColorStateList colorStateListC2;
        ColorStateList colorStateListC3;
        d0 d0VarS = d0.s(context, i2, e.m.n2);
        int i3 = e.m.y2;
        if (d0VarS.r(i3)) {
            s(d0VarS.a(i3, false));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            int i5 = e.m.r2;
            if (d0VarS.r(i5) && (colorStateListC3 = d0VarS.c(i5)) != null) {
                this.f2147a.setTextColor(colorStateListC3);
            }
            int i6 = e.m.t2;
            if (d0VarS.r(i6) && (colorStateListC2 = d0VarS.c(i6)) != null) {
                this.f2147a.setLinkTextColor(colorStateListC2);
            }
            int i7 = e.m.s2;
            if (d0VarS.r(i7) && (colorStateListC = d0VarS.c(i7)) != null) {
                this.f2147a.setHintTextColor(colorStateListC);
            }
        }
        int i8 = e.m.o2;
        if (d0VarS.r(i8) && d0VarS.e(i8, -1) == 0) {
            this.f2147a.setTextSize(0, 0.0f);
        }
        C(context, d0VarS);
        if (i4 >= 26) {
            int i9 = e.m.x2;
            if (d0VarS.r(i9) && (strN = d0VarS.n(i9)) != null) {
                e.d(this.f2147a, strN);
            }
        }
        d0VarS.w();
        Typeface typeface = this.f2157l;
        if (typeface != null) {
            this.f2147a.setTypeface(typeface, this.f2155j);
        }
    }

    void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        AbstractC0378c.f(editorInfo, textView.getText());
    }

    void s(boolean z2) {
        this.f2147a.setAllCaps(z2);
    }

    void t(int i2, int i3, int i4, int i5) {
        this.f2154i.p(i2, i3, i4, i5);
    }

    void u(int[] iArr, int i2) {
        this.f2154i.q(iArr, i2);
    }

    void v(int i2) {
        this.f2154i.r(i2);
    }

    void w(ColorStateList colorStateList) {
        if (this.f2153h == null) {
            this.f2153h = new b0();
        }
        b0 b0Var = this.f2153h;
        b0Var.f2380a = colorStateList;
        b0Var.f2383d = colorStateList != null;
        z();
    }

    void x(PorterDuff.Mode mode) {
        if (this.f2153h == null) {
            this.f2153h = new b0();
        }
        b0 b0Var = this.f2153h;
        b0Var.f2381b = mode;
        b0Var.f2382c = mode != null;
        z();
    }
}
