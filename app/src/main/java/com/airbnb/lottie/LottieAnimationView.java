package com.airbnb.lottie;

import Q.g;
import Q.i;
import Q.k;
import Q.l;
import Q.m;
import Q.n;
import Q.o;
import Q.p;
import V.e;
import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.F;
import androidx.appcompat.widget.C0149q;
import c0.j;
import d0.C0246c;
import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class LottieAnimationView extends C0149q {

    /* renamed from: q, reason: collision with root package name */
    private static final String f4652q = "LottieAnimationView";

    /* renamed from: d, reason: collision with root package name */
    private final g f4653d;
    private final g e;

    /* renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.a f4654f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4655g;

    /* renamed from: h, reason: collision with root package name */
    private String f4656h;

    /* renamed from: i, reason: collision with root package name */
    private int f4657i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4658j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4659k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4660l;

    /* renamed from: m, reason: collision with root package name */
    private n f4661m;

    /* renamed from: n, reason: collision with root package name */
    private Set f4662n;
    private k o;

    /* renamed from: p, reason: collision with root package name */
    private Q.d f4663p;

    class a implements g {
        a() {
        }

        @Override // Q.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Q.d dVar) {
            LottieAnimationView.this.setComposition(dVar);
        }
    }

    class b implements g {
        b() {
        }

        @Override // Q.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Throwable th) {
            throw new IllegalStateException("Unable to parse composition", th);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4666a;

        static {
            int[] iArr = new int[n.values().length];
            f4666a = iArr;
            try {
                iArr[n.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4666a[n.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4666a[n.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f4667a;

        /* renamed from: b, reason: collision with root package name */
        int f4668b;

        /* renamed from: c, reason: collision with root package name */
        float f4669c;

        /* renamed from: d, reason: collision with root package name */
        boolean f4670d;
        String e;

        /* renamed from: f, reason: collision with root package name */
        int f4671f;

        /* renamed from: g, reason: collision with root package name */
        int f4672g;

        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i2) {
                return new d[i2];
            }
        }

        /* synthetic */ d(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f4667a);
            parcel.writeFloat(this.f4669c);
            parcel.writeInt(this.f4670d ? 1 : 0);
            parcel.writeString(this.e);
            parcel.writeInt(this.f4671f);
            parcel.writeInt(this.f4672g);
        }

        d(Parcelable parcelable) {
            super(parcelable);
        }

        private d(Parcel parcel) {
            super(parcel);
            this.f4667a = parcel.readString();
            this.f4669c = parcel.readFloat();
            this.f4670d = parcel.readInt() == 1;
            this.e = parcel.readString();
            this.f4671f = parcel.readInt();
            this.f4672g = parcel.readInt();
        }
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4653d = new a();
        this.e = new b();
        this.f4654f = new com.airbnb.lottie.a();
        this.f4658j = false;
        this.f4659k = false;
        this.f4660l = false;
        this.f4661m = n.AUTOMATIC;
        this.f4662n = new HashSet();
        j(attributeSet);
    }

    private void f() {
        k kVar = this.o;
        if (kVar != null) {
            kVar.k(this.f4653d);
            this.o.j(this.e);
        }
    }

    private void g() {
        this.f4663p = null;
        this.f4654f.g();
    }

    private void i() {
        Q.d dVar;
        Q.d dVar2;
        int i2 = c.f4666a[this.f4661m.ordinal()];
        int i3 = 2;
        if (i2 != 1 && (i2 == 2 || i2 != 3 || (((dVar = this.f4663p) != null && dVar.p() && Build.VERSION.SDK_INT < 28) || ((dVar2 = this.f4663p) != null && dVar2.l() > 4)))) {
            i3 = 1;
        }
        if (i3 != getLayerType()) {
            setLayerType(i3, null);
        }
    }

    private void j(AttributeSet attributeSet) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.f627C);
        if (!isInEditMode()) {
            int i2 = m.f635K;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i2);
            int i3 = m.f631G;
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i3);
            int i4 = m.f641Q;
            boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(i4);
            if (zHasValue && zHasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (zHasValue) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (zHasValue2) {
                String string2 = typedArrayObtainStyledAttributes.getString(i3);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(i4)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (typedArrayObtainStyledAttributes.getBoolean(m.f628D, false)) {
            this.f4659k = true;
            this.f4660l = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(m.f633I, false)) {
            this.f4654f.W(-1);
        }
        int i5 = m.f638N;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(i5, 1));
        }
        int i6 = m.f637M;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(i6, -1));
        }
        int i7 = m.f640P;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(i7, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(m.f632H));
        setProgress(typedArrayObtainStyledAttributes.getFloat(m.f634J, 0.0f));
        h(typedArrayObtainStyledAttributes.getBoolean(m.f630F, false));
        int i8 = m.f629E;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            d(new e("**"), i.f588B, new C0246c(new o(typedArrayObtainStyledAttributes.getColor(i8, 0))));
        }
        int i9 = m.f639O;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            this.f4654f.Y(typedArrayObtainStyledAttributes.getFloat(i9, 1.0f));
        }
        int i10 = m.f636L;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            n nVar = n.AUTOMATIC;
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(i10, nVar.ordinal());
            if (iOrdinal >= n.values().length) {
                iOrdinal = nVar.ordinal();
            }
            this.f4661m = n.values()[iOrdinal];
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f4654f.a0(Boolean.valueOf(j.f(getContext()) != 0.0f));
        i();
        this.f4655g = true;
    }

    private void setCompositionTask(k kVar) {
        g();
        f();
        this.o = kVar.f(this.f4653d).e(this.e);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z2) {
        super.buildDrawingCache(z2);
        if (getLayerType() == 1 && getDrawingCache(z2) == null) {
            setRenderMode(n.HARDWARE);
        }
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.f4654f.c(animatorListener);
    }

    public void d(e eVar, Object obj, C0246c c0246c) {
        this.f4654f.d(eVar, obj, c0246c);
    }

    public void e() {
        this.f4658j = false;
        this.f4654f.f();
        i();
    }

    public Q.d getComposition() {
        return this.f4663p;
    }

    public long getDuration() {
        Q.d dVar = this.f4663p;
        if (dVar != null) {
            return (long) dVar.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f4654f.n();
    }

    public String getImageAssetsFolder() {
        return this.f4654f.q();
    }

    public float getMaxFrame() {
        return this.f4654f.r();
    }

    public float getMinFrame() {
        return this.f4654f.t();
    }

    public l getPerformanceTracker() {
        return this.f4654f.u();
    }

    public float getProgress() {
        return this.f4654f.v();
    }

    public int getRepeatCount() {
        return this.f4654f.w();
    }

    public int getRepeatMode() {
        return this.f4654f.x();
    }

    public float getScale() {
        return this.f4654f.y();
    }

    public float getSpeed() {
        return this.f4654f.z();
    }

    public void h(boolean z2) {
        this.f4654f.h(z2);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        com.airbnb.lottie.a aVar = this.f4654f;
        if (drawable2 == aVar) {
            super.invalidateDrawable(aVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean k() {
        return this.f4654f.C();
    }

    public void l() {
        this.f4660l = false;
        this.f4659k = false;
        this.f4658j = false;
        this.f4654f.D();
        i();
    }

    public void m() {
        if (!isShown()) {
            this.f4658j = true;
        } else {
            this.f4654f.E();
            i();
        }
    }

    public void n() {
        if (!isShown()) {
            this.f4658j = true;
        } else {
            this.f4654f.G();
            i();
        }
    }

    public void o(b0.c cVar, String str) {
        setCompositionTask(Q.e.h(cVar, str));
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4660l || this.f4659k) {
            m();
            this.f4660l = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (k()) {
            e();
            this.f4659k = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        String str = dVar.f4667a;
        this.f4656h = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f4656h);
        }
        int i2 = dVar.f4668b;
        this.f4657i = i2;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(dVar.f4669c);
        if (dVar.f4670d) {
            m();
        }
        this.f4654f.L(dVar.e);
        setRepeatMode(dVar.f4671f);
        setRepeatCount(dVar.f4672g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f4667a = this.f4656h;
        dVar.f4668b = this.f4657i;
        dVar.f4669c = this.f4654f.v();
        dVar.f4670d = this.f4654f.C();
        dVar.e = this.f4654f.q();
        dVar.f4671f = this.f4654f.x();
        dVar.f4672g = this.f4654f.w();
        return dVar;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        if (this.f4655g) {
            if (isShown()) {
                if (this.f4658j) {
                    n();
                    this.f4658j = false;
                    return;
                }
                return;
            }
            if (k()) {
                l();
                this.f4658j = true;
            }
        }
    }

    public void p(String str, String str2) {
        o(b0.c.v(r1.e.a(r1.e.c(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    public void setAnimation(int i2) {
        this.f4657i = i2;
        this.f4656h = null;
        setCompositionTask(Q.e.k(getContext(), i2));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        p(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(Q.e.m(getContext(), str));
    }

    public void setComposition(Q.d dVar) {
        if (Q.c.f552a) {
            Log.v(f4652q, "Set Composition \n" + dVar);
        }
        this.f4654f.setCallback(this);
        this.f4663p = dVar;
        boolean zH = this.f4654f.H(dVar);
        i();
        if (getDrawable() != this.f4654f || zH) {
            setImageDrawable(null);
            setImageDrawable(this.f4654f);
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator it = this.f4662n.iterator();
            if (it.hasNext()) {
                F.a(it.next());
                throw null;
            }
        }
    }

    public void setFontAssetDelegate(Q.a aVar) {
        this.f4654f.I(aVar);
    }

    public void setFrame(int i2) {
        this.f4654f.J(i2);
    }

    public void setImageAssetDelegate(Q.b bVar) {
        this.f4654f.K(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f4654f.L(str);
    }

    @Override // androidx.appcompat.widget.C0149q, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        f();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.C0149q, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        f();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.C0149q, android.widget.ImageView
    public void setImageResource(int i2) {
        f();
        super.setImageResource(i2);
    }

    public void setMaxFrame(int i2) {
        this.f4654f.M(i2);
    }

    public void setMaxProgress(float f2) {
        this.f4654f.O(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.f4654f.Q(str);
    }

    public void setMinFrame(int i2) {
        this.f4654f.R(i2);
    }

    public void setMinProgress(float f2) {
        this.f4654f.T(f2);
    }

    public void setPerformanceTrackingEnabled(boolean z2) {
        this.f4654f.U(z2);
    }

    public void setProgress(float f2) {
        this.f4654f.V(f2);
    }

    public void setRenderMode(n nVar) {
        this.f4661m = nVar;
        i();
    }

    public void setRepeatCount(int i2) {
        this.f4654f.W(i2);
    }

    public void setRepeatMode(int i2) {
        this.f4654f.X(i2);
    }

    public void setScale(float f2) {
        this.f4654f.Y(f2);
        if (getDrawable() == this.f4654f) {
            setImageDrawable(null);
            setImageDrawable(this.f4654f);
        }
    }

    public void setSpeed(float f2) {
        this.f4654f.Z(f2);
    }

    public void setTextDelegate(p pVar) {
        this.f4654f.b0(pVar);
    }

    public void setMaxFrame(String str) {
        this.f4654f.N(str);
    }

    public void setMinFrame(String str) {
        this.f4654f.S(str);
    }

    public void setAnimation(String str) {
        this.f4656h = str;
        this.f4657i = 0;
        setCompositionTask(Q.e.d(getContext(), str));
    }
}
