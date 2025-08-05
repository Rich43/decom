package g;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.V;
import androidx.collection.h;
import androidx.core.content.res.k;
import g.AbstractC0255b;
import g.AbstractC0257d;
import h.AbstractC0259a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: g.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0254a extends AbstractC0257d implements androidx.core.graphics.drawable.b {
    private c o;

    /* renamed from: p, reason: collision with root package name */
    private g f6194p;

    /* renamed from: q, reason: collision with root package name */
    private int f6195q;
    private int r;
    private boolean s;

    /* renamed from: g.a$b */
    private static class b extends g {

        /* renamed from: a, reason: collision with root package name */
        private final Animatable f6196a;

        b(Animatable animatable) {
            super();
            this.f6196a = animatable;
        }

        @Override // g.C0254a.g
        public void c() {
            this.f6196a.start();
        }

        @Override // g.C0254a.g
        public void d() {
            this.f6196a.stop();
        }
    }

    /* renamed from: g.a$c */
    static class c extends AbstractC0257d.a {

        /* renamed from: K, reason: collision with root package name */
        androidx.collection.d f6197K;

        /* renamed from: L, reason: collision with root package name */
        h f6198L;

        c(c cVar, C0254a c0254a, Resources resources) {
            super(cVar, c0254a, resources);
            if (cVar != null) {
                this.f6197K = cVar.f6197K;
                this.f6198L = cVar.f6198L;
            } else {
                this.f6197K = new androidx.collection.d();
                this.f6198L = new h();
            }
        }

        private static long D(int i2, int i3) {
            return i3 | (i2 << 32);
        }

        int B(int[] iArr, Drawable drawable, int i2) {
            int iZ = super.z(iArr, drawable);
            this.f6198L.h(iZ, Integer.valueOf(i2));
            return iZ;
        }

        int C(int i2, int i3, Drawable drawable, boolean z2) {
            int iA = super.a(drawable);
            long jD = D(i2, i3);
            long j2 = z2 ? 8589934592L : 0L;
            long j3 = iA;
            this.f6197K.a(jD, Long.valueOf(j3 | j2));
            if (z2) {
                this.f6197K.a(D(i3, i2), Long.valueOf(4294967296L | j3 | j2));
            }
            return iA;
        }

        int E(int i2) {
            if (i2 < 0) {
                return 0;
            }
            return ((Integer) this.f6198L.f(i2, 0)).intValue();
        }

        int F(int[] iArr) {
            int iA = super.A(iArr);
            return iA >= 0 ? iA : super.A(StateSet.WILD_CARD);
        }

        int G(int i2, int i3) {
            return (int) ((Long) this.f6197K.g(D(i2, i3), -1L)).longValue();
        }

        boolean H(int i2, int i3) {
            return (((Long) this.f6197K.g(D(i2, i3), -1L)).longValue() & 4294967296L) != 0;
        }

        boolean I(int i2, int i3) {
            return (((Long) this.f6197K.g(D(i2, i3), -1L)).longValue() & 8589934592L) != 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C0254a(this, null);
        }

        @Override // g.AbstractC0257d.a, g.AbstractC0255b.d
        void r() {
            this.f6197K = this.f6197K.clone();
            this.f6198L = this.f6198L.clone();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C0254a(this, resources);
        }
    }

    /* renamed from: g.a$d */
    private static class d extends g {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.vectordrawable.graphics.drawable.b f6199a;

        d(androidx.vectordrawable.graphics.drawable.b bVar) {
            super();
            this.f6199a = bVar;
        }

        @Override // g.C0254a.g
        public void c() {
            this.f6199a.start();
        }

        @Override // g.C0254a.g
        public void d() {
            this.f6199a.stop();
        }
    }

    /* renamed from: g.a$e */
    private static class e extends g {

        /* renamed from: a, reason: collision with root package name */
        private final ObjectAnimator f6200a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f6201b;

        e(AnimationDrawable animationDrawable, boolean z2, boolean z3) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i2 = z2 ? numberOfFrames - 1 : 0;
            int i3 = z2 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z2);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i2, i3);
            objectAnimatorOfInt.setAutoCancel(true);
            objectAnimatorOfInt.setDuration(fVar.a());
            objectAnimatorOfInt.setInterpolator(fVar);
            this.f6201b = z3;
            this.f6200a = objectAnimatorOfInt;
        }

        @Override // g.C0254a.g
        public boolean a() {
            return this.f6201b;
        }

        @Override // g.C0254a.g
        public void b() {
            this.f6200a.reverse();
        }

        @Override // g.C0254a.g
        public void c() {
            this.f6200a.start();
        }

        @Override // g.C0254a.g
        public void d() {
            this.f6200a.cancel();
        }
    }

    /* renamed from: g.a$f */
    private static class f implements TimeInterpolator {

        /* renamed from: a, reason: collision with root package name */
        private int[] f6202a;

        /* renamed from: b, reason: collision with root package name */
        private int f6203b;

        /* renamed from: c, reason: collision with root package name */
        private int f6204c;

        f(AnimationDrawable animationDrawable, boolean z2) {
            b(animationDrawable, z2);
        }

        int a() {
            return this.f6204c;
        }

        int b(AnimationDrawable animationDrawable, boolean z2) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f6203b = numberOfFrames;
            int[] iArr = this.f6202a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f6202a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f6202a;
            int i2 = 0;
            for (int i3 = 0; i3 < numberOfFrames; i3++) {
                int duration = animationDrawable.getDuration(z2 ? (numberOfFrames - i3) - 1 : i3);
                iArr2[i3] = duration;
                i2 += duration;
            }
            this.f6204c = i2;
            return i2;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            int i2 = (int) ((f2 * this.f6204c) + 0.5f);
            int i3 = this.f6203b;
            int[] iArr = this.f6202a;
            int i4 = 0;
            while (i4 < i3) {
                int i5 = iArr[i4];
                if (i2 < i5) {
                    break;
                }
                i2 -= i5;
                i4++;
            }
            return (i4 / i3) + (i4 < i3 ? i2 / this.f6204c : 0.0f);
        }
    }

    public C0254a() {
        this(null, null);
    }

    public static C0254a l(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IllegalAccessException, NoSuchMethodException, SecurityException, IOException, IllegalArgumentException, InvocationTargetException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            C0254a c0254a = new C0254a();
            c0254a.m(context, resources, xmlPullParser, attributeSet, theme);
            return c0254a;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    p(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void o() {
        onStateChange(getState());
    }

    private int p(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, h.c.f6361h);
        int resourceId = typedArrayK.getResourceId(h.c.f6362i, 0);
        int resourceId2 = typedArrayK.getResourceId(h.c.f6363j, -1);
        Drawable drawableJ = resourceId2 > 0 ? V.h().j(context, resourceId2) : null;
        typedArrayK.recycle();
        int[] iArrJ = j(attributeSet);
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableJ = xmlPullParser.getName().equals("vector") ? androidx.vectordrawable.graphics.drawable.g.c(resources, xmlPullParser, attributeSet, theme) : AbstractC0259a.a(resources, xmlPullParser, attributeSet, theme);
        }
        if (drawableJ != null) {
            return this.o.B(iArrJ, drawableJ, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, h.c.f6364k);
        int resourceId = typedArrayK.getResourceId(h.c.f6367n, -1);
        int resourceId2 = typedArrayK.getResourceId(h.c.f6366m, -1);
        int resourceId3 = typedArrayK.getResourceId(h.c.f6365l, -1);
        Drawable drawableJ = resourceId3 > 0 ? V.h().j(context, resourceId3) : null;
        boolean z2 = typedArrayK.getBoolean(h.c.o, false);
        typedArrayK.recycle();
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableJ = xmlPullParser.getName().equals("animated-vector") ? androidx.vectordrawable.graphics.drawable.b.a(context, resources, xmlPullParser, attributeSet, theme) : AbstractC0259a.a(resources, xmlPullParser, attributeSet, theme);
        }
        if (drawableJ == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.o.C(resourceId, resourceId2, drawableJ, z2);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    private boolean r(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iC;
        int iG;
        g bVar;
        g gVar = this.f6194p;
        if (gVar == null) {
            iC = c();
        } else {
            if (i2 == this.f6195q) {
                return true;
            }
            if (i2 == this.r && gVar.a()) {
                gVar.b();
                this.f6195q = this.r;
                this.r = i2;
                return true;
            }
            iC = this.f6195q;
            gVar.d();
        }
        this.f6194p = null;
        this.r = -1;
        this.f6195q = -1;
        c cVar = this.o;
        int iE = cVar.E(iC);
        int iE2 = cVar.E(i2);
        if (iE2 == 0 || iE == 0 || (iG = cVar.G(iE, iE2)) < 0) {
            return false;
        }
        boolean zI = cVar.I(iE, iE2);
        g(iG);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.H(iE, iE2), zI);
        } else {
            if (!(current instanceof androidx.vectordrawable.graphics.drawable.b)) {
                if (current instanceof Animatable) {
                    bVar = new b((Animatable) current);
                }
                return false;
            }
            bVar = new d((androidx.vectordrawable.graphics.drawable.b) current);
        }
        bVar.c();
        this.f6194p = bVar;
        this.r = iC;
        this.f6195q = i2;
        return true;
    }

    private void s(TypedArray typedArray) {
        c cVar = this.o;
        cVar.f6230d |= AbstractC0259a.b(typedArray);
        cVar.x(typedArray.getBoolean(h.c.f6358d, cVar.f6234i));
        cVar.t(typedArray.getBoolean(h.c.e, cVar.f6237l));
        cVar.u(typedArray.getInt(h.c.f6359f, cVar.f6218A));
        cVar.v(typedArray.getInt(h.c.f6360g, cVar.f6219B));
        setDither(typedArray.getBoolean(h.c.f6356b, cVar.f6246x));
    }

    @Override // g.AbstractC0257d, g.AbstractC0255b
    void h(AbstractC0255b.d dVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.h(dVar);
        if (dVar instanceof c) {
            this.o = (c) dVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // g.AbstractC0255b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.jumpToCurrentState();
        g gVar = this.f6194p;
        if (gVar != null) {
            gVar.d();
            this.f6194p = null;
            g(this.f6195q);
            this.f6195q = -1;
            this.r = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0255b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public c b() {
        return new c(this.o, this, null);
    }

    public void m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IllegalAccessException, NoSuchMethodException, SecurityException, IOException, IllegalArgumentException, InvocationTargetException {
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, h.c.f6355a);
        setVisible(typedArrayK.getBoolean(h.c.f6357c, true), true);
        s(typedArrayK);
        i(resources);
        typedArrayK.recycle();
        n(context, resources, xmlPullParser, attributeSet, theme);
        o();
    }

    @Override // g.AbstractC0257d, g.AbstractC0255b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.s && super.mutate() == this) {
            this.o.r();
            this.s = true;
        }
        return this;
    }

    @Override // g.AbstractC0257d, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int iF = this.o.F(iArr);
        boolean z2 = iF != c() && (r(iF) || g(iF));
        Drawable current = getCurrent();
        return current != null ? z2 | current.setState(iArr) : z2;
    }

    @Override // g.AbstractC0255b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean visible = super.setVisible(z2, z3);
        g gVar = this.f6194p;
        if (gVar != null && (visible || z3)) {
            if (z2) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    C0254a(c cVar, Resources resources) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super(null);
        this.f6195q = -1;
        this.r = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* renamed from: g.a$g */
    private static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public abstract void c();

        public abstract void d();

        public void b() {
        }
    }
}
