package com.airbnb.lottie;

import Q.p;
import a0.s;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import d0.C0246c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class a extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: a */
    private final Matrix f4673a = new Matrix();

    /* renamed from: b */
    private Q.d f4674b;

    /* renamed from: c */
    private final c0.g f4675c;

    /* renamed from: d */
    private float f4676d;
    private boolean e;

    /* renamed from: f */
    private final Set f4677f;

    /* renamed from: g */
    private final ArrayList f4678g;

    /* renamed from: h */
    private U.b f4679h;

    /* renamed from: i */
    private String f4680i;

    /* renamed from: j */
    private U.a f4681j;

    /* renamed from: k */
    private boolean f4682k;

    /* renamed from: l */
    private Y.b f4683l;

    /* renamed from: m */
    private int f4684m;

    /* renamed from: n */
    private boolean f4685n;
    private boolean o;

    /* renamed from: com.airbnb.lottie.a$a */
    class C0064a implements o {

        /* renamed from: a */
        final /* synthetic */ String f4686a;

        C0064a(String str) {
            this.f4686a = str;
        }

        @Override // com.airbnb.lottie.a.o
        public void a(Q.d dVar) {
            a.this.Q(this.f4686a);
        }
    }

    class b implements o {

        /* renamed from: a */
        final /* synthetic */ int f4688a;

        /* renamed from: b */
        final /* synthetic */ int f4689b;

        b(int i2, int i3) {
            this.f4688a = i2;
            this.f4689b = i3;
        }

        @Override // com.airbnb.lottie.a.o
        public void a(Q.d dVar) {
            a.this.P(this.f4688a, this.f4689b);
        }
    }

    class c implements o {

        /* renamed from: a */
        final /* synthetic */ int f4691a;

        c(int i2) {
            this.f4691a = i2;
        }

        @Override // com.airbnb.lottie.a.o
        public void a(Q.d dVar) {
            a.this.J(this.f4691a);
        }
    }

    class d implements o {

        /* renamed from: a */
        final /* synthetic */ float f4693a;

        d(float f2) {
            this.f4693a = f2;
        }

        @Override // com.airbnb.lottie.a.o
        public void a(Q.d dVar) {
            a.this.V(this.f4693a);
        }
    }

    class e implements o {

        /* renamed from: a */
        final /* synthetic */ V.e f4695a;

        /* renamed from: b */
        final /* synthetic */ Object f4696b;

        /* renamed from: c */
        final /* synthetic */ C0246c f4697c;

        e(V.e eVar, Object obj, C0246c c0246c) {
            this.f4695a = eVar;
            this.f4696b = obj;
            this.f4697c = c0246c;
        }

        @Override // com.airbnb.lottie.a.o
        public void a(Q.d dVar) {
            a.this.d(this.f4695a, this.f4696b, this.f4697c);
        }
    }

    class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (a.this.f4683l != null) {
                a.this.f4683l.H(a.this.f4675c.h());
            }
        }
    }

    class g implements o {
        g() {
        }

        @Override // com.airbnb.lottie.a.o
        public void a(Q.d dVar) {
            a.this.E();
        }
    }

    class h implements o {
        h() {
        }

        @Override // com.airbnb.lottie.a.o
        public void a(Q.d dVar) {
            a.this.G();
        }
    }

    class i implements o {

        /* renamed from: a */
        final /* synthetic */ int f4702a;

        i(int i2) {
            this.f4702a = i2;
        }

        @Override // com.airbnb.lottie.a.o
        public void a(Q.d dVar) {
            a.this.R(this.f4702a);
        }
    }

    class j implements o {

        /* renamed from: a */
        final /* synthetic */ float f4704a;

        j(float f2) {
            this.f4704a = f2;
        }

        @Override // com.airbnb.lottie.a.o
        public void a(Q.d dVar) {
            a.this.T(this.f4704a);
        }
    }

    class k implements o {

        /* renamed from: a */
        final /* synthetic */ int f4706a;

        k(int i2) {
            this.f4706a = i2;
        }

        @Override // com.airbnb.lottie.a.o
        public void a(Q.d dVar) {
            a.this.M(this.f4706a);
        }
    }

    class l implements o {

        /* renamed from: a */
        final /* synthetic */ float f4708a;

        l(float f2) {
            this.f4708a = f2;
        }

        @Override // com.airbnb.lottie.a.o
        public void a(Q.d dVar) {
            a.this.O(this.f4708a);
        }
    }

    class m implements o {

        /* renamed from: a */
        final /* synthetic */ String f4710a;

        m(String str) {
            this.f4710a = str;
        }

        @Override // com.airbnb.lottie.a.o
        public void a(Q.d dVar) {
            a.this.S(this.f4710a);
        }
    }

    class n implements o {

        /* renamed from: a */
        final /* synthetic */ String f4712a;

        n(String str) {
            this.f4712a = str;
        }

        @Override // com.airbnb.lottie.a.o
        public void a(Q.d dVar) {
            a.this.N(this.f4712a);
        }
    }

    private interface o {
        void a(Q.d dVar);
    }

    public a() {
        c0.g gVar = new c0.g();
        this.f4675c = gVar;
        this.f4676d = 1.0f;
        this.e = true;
        this.f4677f = new HashSet();
        this.f4678g = new ArrayList();
        this.f4684m = 255;
        this.o = false;
        gVar.addUpdateListener(new f());
    }

    private void c0() {
        if (this.f4674b == null) {
            return;
        }
        float fY = y();
        setBounds(0, 0, (int) (this.f4674b.b().width() * fY), (int) (this.f4674b.b().height() * fY));
    }

    private void e() {
        this.f4683l = new Y.b(this, s.a(this.f4674b), this.f4674b.j(), this.f4674b);
    }

    private Context l() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private U.a m() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f4681j == null) {
            this.f4681j = new U.a(getCallback(), null);
        }
        return this.f4681j;
    }

    private U.b p() {
        if (getCallback() == null) {
            return null;
        }
        U.b bVar = this.f4679h;
        if (bVar != null && !bVar.b(l())) {
            this.f4679h = null;
        }
        if (this.f4679h == null) {
            this.f4679h = new U.b(getCallback(), this.f4680i, null, this.f4674b.i());
        }
        return this.f4679h;
    }

    private float s(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f4674b.b().width(), canvas.getHeight() / this.f4674b.b().height());
    }

    public p A() {
        return null;
    }

    public Typeface B(String str, String str2) {
        U.a aVarM = m();
        if (aVarM != null) {
            return aVarM.b(str, str2);
        }
        return null;
    }

    public boolean C() {
        return this.f4675c.isRunning();
    }

    public void D() {
        this.f4678g.clear();
        this.f4675c.o();
    }

    public void E() {
        if (this.f4683l == null) {
            this.f4678g.add(new g());
            return;
        }
        if (this.e || w() == 0) {
            this.f4675c.p();
        }
        if (this.e) {
            return;
        }
        J((int) (z() < 0.0f ? t() : r()));
    }

    public List F(V.e eVar) {
        if (this.f4683l == null) {
            c0.f.b("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f4683l.f(eVar, 0, arrayList, new V.e(new String[0]));
        return arrayList;
    }

    public void G() {
        if (this.f4683l == null) {
            this.f4678g.add(new h());
        } else {
            this.f4675c.t();
        }
    }

    public boolean H(Q.d dVar) {
        if (this.f4674b == dVar) {
            return false;
        }
        this.o = false;
        g();
        this.f4674b = dVar;
        e();
        this.f4675c.v(dVar);
        V(this.f4675c.getAnimatedFraction());
        Y(this.f4676d);
        c0();
        Iterator it = new ArrayList(this.f4678g).iterator();
        while (it.hasNext()) {
            ((o) it.next()).a(dVar);
            it.remove();
        }
        this.f4678g.clear();
        dVar.u(this.f4685n);
        return true;
    }

    public void I(Q.a aVar) {
        U.a aVar2 = this.f4681j;
        if (aVar2 != null) {
            aVar2.c(aVar);
        }
    }

    public void J(int i2) {
        if (this.f4674b == null) {
            this.f4678g.add(new c(i2));
        } else {
            this.f4675c.w(i2);
        }
    }

    public void K(Q.b bVar) {
        U.b bVar2 = this.f4679h;
        if (bVar2 != null) {
            bVar2.d(bVar);
        }
    }

    public void L(String str) {
        this.f4680i = str;
    }

    public void M(int i2) {
        if (this.f4674b == null) {
            this.f4678g.add(new k(i2));
        } else {
            this.f4675c.x(i2 + 0.99f);
        }
    }

    public void N(String str) {
        Q.d dVar = this.f4674b;
        if (dVar == null) {
            this.f4678g.add(new n(str));
            return;
        }
        V.h hVarK = dVar.k(str);
        if (hVarK != null) {
            M((int) (hVarK.f979b + hVarK.f980c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void O(float f2) {
        Q.d dVar = this.f4674b;
        if (dVar == null) {
            this.f4678g.add(new l(f2));
        } else {
            M((int) c0.i.j(dVar.o(), this.f4674b.f(), f2));
        }
    }

    public void P(int i2, int i3) {
        if (this.f4674b == null) {
            this.f4678g.add(new b(i2, i3));
        } else {
            this.f4675c.y(i2, i3 + 0.99f);
        }
    }

    public void Q(String str) {
        Q.d dVar = this.f4674b;
        if (dVar == null) {
            this.f4678g.add(new C0064a(str));
            return;
        }
        V.h hVarK = dVar.k(str);
        if (hVarK != null) {
            int i2 = (int) hVarK.f979b;
            P(i2, ((int) hVarK.f980c) + i2);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public void R(int i2) {
        if (this.f4674b == null) {
            this.f4678g.add(new i(i2));
        } else {
            this.f4675c.z(i2);
        }
    }

    public void S(String str) {
        Q.d dVar = this.f4674b;
        if (dVar == null) {
            this.f4678g.add(new m(str));
            return;
        }
        V.h hVarK = dVar.k(str);
        if (hVarK != null) {
            R((int) hVarK.f979b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void T(float f2) {
        Q.d dVar = this.f4674b;
        if (dVar == null) {
            this.f4678g.add(new j(f2));
        } else {
            R((int) c0.i.j(dVar.o(), this.f4674b.f(), f2));
        }
    }

    public void U(boolean z2) {
        this.f4685n = z2;
        Q.d dVar = this.f4674b;
        if (dVar != null) {
            dVar.u(z2);
        }
    }

    public void V(float f2) {
        Q.d dVar = this.f4674b;
        if (dVar == null) {
            this.f4678g.add(new d(f2));
        } else {
            this.f4675c.w(c0.i.j(dVar.o(), this.f4674b.f(), f2));
        }
    }

    public void W(int i2) {
        this.f4675c.setRepeatCount(i2);
    }

    public void X(int i2) {
        this.f4675c.setRepeatMode(i2);
    }

    public void Y(float f2) {
        this.f4676d = f2;
        c0();
    }

    public void Z(float f2) {
        this.f4675c.A(f2);
    }

    void a0(Boolean bool) {
        this.e = bool.booleanValue();
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.f4675c.addListener(animatorListener);
    }

    public void d(V.e eVar, Object obj, C0246c c0246c) {
        if (this.f4683l == null) {
            this.f4678g.add(new e(eVar, obj, c0246c));
            return;
        }
        boolean zIsEmpty = true;
        if (eVar.d() != null) {
            eVar.d().c(obj, c0246c);
        } else {
            List listF = F(eVar);
            for (int i2 = 0; i2 < listF.size(); i2++) {
                ((V.e) listF.get(i2)).d().c(obj, c0246c);
            }
            zIsEmpty = true ^ listF.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (obj == Q.i.f587A) {
                V(v());
            }
        }
    }

    public boolean d0() {
        return this.f4674b.c().i() > 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f2;
        int iSave;
        this.o = false;
        Q.c.a("Drawable#draw");
        if (this.f4683l == null) {
            return;
        }
        float f3 = this.f4676d;
        float fS = s(canvas);
        if (f3 > fS) {
            f2 = this.f4676d / fS;
        } else {
            fS = f3;
            f2 = 1.0f;
        }
        if (f2 > 1.0f) {
            iSave = canvas.save();
            float fWidth = this.f4674b.b().width() / 2.0f;
            float fHeight = this.f4674b.b().height() / 2.0f;
            float f4 = fWidth * fS;
            float f5 = fHeight * fS;
            canvas.translate((y() * fWidth) - f4, (y() * fHeight) - f5);
            canvas.scale(f2, f2, f4, f5);
        } else {
            iSave = -1;
        }
        this.f4673a.reset();
        this.f4673a.preScale(fS, fS);
        this.f4683l.g(canvas, this.f4673a, this.f4684m);
        Q.c.b("Drawable#draw");
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    public void f() {
        this.f4678g.clear();
        this.f4675c.cancel();
    }

    public void g() {
        if (this.f4675c.isRunning()) {
            this.f4675c.cancel();
        }
        this.f4674b = null;
        this.f4683l = null;
        this.f4679h = null;
        this.f4675c.f();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f4684m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f4674b == null) {
            return -1;
        }
        return (int) (r0.b().height() * y());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f4674b == null) {
            return -1;
        }
        return (int) (r0.b().width() * y());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(boolean z2) {
        if (this.f4682k == z2) {
            return;
        }
        this.f4682k = z2;
        if (this.f4674b != null) {
            e();
        }
    }

    public boolean i() {
        return this.f4682k;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.o) {
            return;
        }
        this.o = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return C();
    }

    public void j() {
        this.f4678g.clear();
        this.f4675c.g();
    }

    public Q.d k() {
        return this.f4674b;
    }

    public int n() {
        return (int) this.f4675c.i();
    }

    public Bitmap o(String str) {
        U.b bVarP = p();
        if (bVarP != null) {
            return bVarP.a(str);
        }
        return null;
    }

    public String q() {
        return this.f4680i;
    }

    public float r() {
        return this.f4675c.k();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f4684m = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c0.f.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        E();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        j();
    }

    public float t() {
        return this.f4675c.l();
    }

    public Q.l u() {
        Q.d dVar = this.f4674b;
        if (dVar != null) {
            return dVar.m();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public float v() {
        return this.f4675c.h();
    }

    public int w() {
        return this.f4675c.getRepeatCount();
    }

    public int x() {
        return this.f4675c.getRepeatMode();
    }

    public float y() {
        return this.f4676d;
    }

    public float z() {
        return this.f4675c.m();
    }

    public void b0(p pVar) {
    }
}
