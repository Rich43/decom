package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.content.res.k;
import androidx.core.graphics.h;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class g extends androidx.vectordrawable.graphics.drawable.f {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f4413k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    private h f4414b;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuffColorFilter f4415c;

    /* renamed from: d, reason: collision with root package name */
    private ColorFilter f4416d;
    private boolean e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4417f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable.ConstantState f4418g;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f4419h;

    /* renamed from: i, reason: collision with root package name */
    private final Matrix f4420i;

    /* renamed from: j, reason: collision with root package name */
    private final Rect f4421j;

    private static class b extends f {
        b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f4445b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f4444a = androidx.core.graphics.h.d(string2);
            }
            this.f4446c = k.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (k.j(xmlPullParser, "pathData")) {
                TypedArray typedArrayK = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f4391d);
                f(typedArrayK, xmlPullParser);
                typedArrayK.recycle();
            }
        }

        b(b bVar) {
            super(bVar);
        }
    }

    private static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    private static class h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f4463a;

        /* renamed from: b, reason: collision with root package name */
        C0059g f4464b;

        /* renamed from: c, reason: collision with root package name */
        ColorStateList f4465c;

        /* renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f4466d;
        boolean e;

        /* renamed from: f, reason: collision with root package name */
        Bitmap f4467f;

        /* renamed from: g, reason: collision with root package name */
        ColorStateList f4468g;

        /* renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f4469h;

        /* renamed from: i, reason: collision with root package name */
        int f4470i;

        /* renamed from: j, reason: collision with root package name */
        boolean f4471j;

        /* renamed from: k, reason: collision with root package name */
        boolean f4472k;

        /* renamed from: l, reason: collision with root package name */
        Paint f4473l;

        public h(h hVar) {
            this.f4465c = null;
            this.f4466d = g.f4413k;
            if (hVar != null) {
                this.f4463a = hVar.f4463a;
                C0059g c0059g = new C0059g(hVar.f4464b);
                this.f4464b = c0059g;
                if (hVar.f4464b.e != null) {
                    c0059g.e = new Paint(hVar.f4464b.e);
                }
                if (hVar.f4464b.f4452d != null) {
                    this.f4464b.f4452d = new Paint(hVar.f4464b.f4452d);
                }
                this.f4465c = hVar.f4465c;
                this.f4466d = hVar.f4466d;
                this.e = hVar.e;
            }
        }

        public boolean a(int i2, int i3) {
            return i2 == this.f4467f.getWidth() && i3 == this.f4467f.getHeight();
        }

        public boolean b() {
            return !this.f4472k && this.f4468g == this.f4465c && this.f4469h == this.f4466d && this.f4471j == this.e && this.f4470i == this.f4464b.getRootAlpha();
        }

        public void c(int i2, int i3) {
            if (this.f4467f == null || !a(i2, i3)) {
                this.f4467f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.f4472k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f4467f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f4473l == null) {
                Paint paint = new Paint();
                this.f4473l = paint;
                paint.setFilterBitmap(true);
            }
            this.f4473l.setAlpha(this.f4464b.getRootAlpha());
            this.f4473l.setColorFilter(colorFilter);
            return this.f4473l;
        }

        public boolean f() {
            return this.f4464b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f4464b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4463a;
        }

        public boolean h(int[] iArr) {
            boolean zG = this.f4464b.g(iArr);
            this.f4472k |= zG;
            return zG;
        }

        public void i() {
            this.f4468g = this.f4465c;
            this.f4469h = this.f4466d;
            this.f4470i = this.f4464b.getRootAlpha();
            this.f4471j = this.e;
            this.f4472k = false;
        }

        public void j(int i2, int i3) {
            this.f4467f.eraseColor(0);
            this.f4464b.b(new Canvas(this.f4467f), i2, i3, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new g(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new g(this);
        }

        public h() {
            this.f4465c = null;
            this.f4466d = g.f4413k;
            this.f4464b = new C0059g();
        }
    }

    g() {
        this.f4417f = true;
        this.f4419h = new float[9];
        this.f4420i = new Matrix();
        this.f4421j = new Rect();
        this.f4414b = new h();
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f2)) << 24);
    }

    public static g b(Resources resources, int i2, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            g gVar = new g();
            gVar.f4412a = androidx.core.content.res.h.d(resources, i2, theme);
            gVar.f4418g = new i(gVar.f4412a.getConstantState());
            return gVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static g c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        g gVar = new g();
        gVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return gVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f4414b;
        C0059g c0059g = hVar.f4464b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(c0059g.f4455h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f4433b.add(cVar);
                    if (cVar.getPathName() != null) {
                        c0059g.f4462p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f4463a = cVar.f4447d | hVar.f4463a;
                    z2 = false;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f4433b.add(bVar);
                    if (bVar.getPathName() != null) {
                        c0059g.f4462p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f4463a = bVar.f4447d | hVar.f4463a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f4433b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        c0059g.f4462p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f4463a = dVar2.f4441k | hVar.f4463a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }

    private static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f4414b;
        C0059g c0059g = hVar.f4464b;
        hVar.f4466d = g(k.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListC = k.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListC != null) {
            hVar.f4465c = colorStateListC;
        }
        hVar.e = k.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.e);
        c0059g.f4458k = k.f(typedArray, xmlPullParser, "viewportWidth", 7, c0059g.f4458k);
        float f2 = k.f(typedArray, xmlPullParser, "viewportHeight", 8, c0059g.f4459l);
        c0059g.f4459l = f2;
        if (c0059g.f4458k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f2 <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        c0059g.f4456i = typedArray.getDimension(3, c0059g.f4456i);
        float dimension = typedArray.getDimension(2, c0059g.f4457j);
        c0059g.f4457j = dimension;
        if (c0059g.f4456i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        c0059g.setAlpha(k.f(typedArray, xmlPullParser, "alpha", 4, c0059g.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            c0059g.f4461n = string;
            c0059g.f4462p.put(string, c0059g);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f4412a;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    Object d(String str) {
        return this.f4414b.f4464b.f4462p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f4421j);
        if (this.f4421j.width() <= 0 || this.f4421j.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f4416d;
        if (colorFilter == null) {
            colorFilter = this.f4415c;
        }
        canvas.getMatrix(this.f4420i);
        this.f4420i.getValues(this.f4419h);
        float fAbs = Math.abs(this.f4419h[0]);
        float fAbs2 = Math.abs(this.f4419h[4]);
        float fAbs3 = Math.abs(this.f4419h[1]);
        float fAbs4 = Math.abs(this.f4419h[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(2048, (int) (this.f4421j.width() * fAbs));
        int iMin2 = Math.min(2048, (int) (this.f4421j.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f4421j;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f4421j.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f4421j.offsetTo(0, 0);
        this.f4414b.c(iMin, iMin2);
        if (!this.f4417f) {
            this.f4414b.j(iMin, iMin2);
        } else if (!this.f4414b.b()) {
            this.f4414b.j(iMin, iMin2);
            this.f4414b.i();
        }
        this.f4414b.d(canvas, colorFilter, this.f4421j);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f4412a;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.f4414b.f4464b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f4412a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f4414b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f4412a;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f4416d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f4412a != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f4412a.getConstantState());
        }
        this.f4414b.f4463a = getChangingConfigurations();
        return this.f4414b;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f4412a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f4414b.f4464b.f4457j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f4412a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f4414b.f4464b.f4456i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    void h(boolean z2) {
        this.f4417f = z2;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f4412a;
        return drawable != null ? androidx.core.graphics.drawable.a.g(drawable) : this.f4414b.e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f4412a;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((hVar = this.f4414b) != null && (hVar.g() || ((colorStateList = this.f4414b.f4465c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.e && super.mutate() == this) {
            this.f4414b = new h(this.f4414b);
            this.e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z2;
        PorterDuff.Mode mode;
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f4414b;
        ColorStateList colorStateList = hVar.f4465c;
        if (colorStateList == null || (mode = hVar.f4466d) == null) {
            z2 = false;
        } else {
            this.f4415c = j(this.f4415c, colorStateList, mode);
            invalidateSelf();
            z2 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z2;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f4414b.f4464b.getRootAlpha() != i2) {
            this.f4414b.f4464b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.i(drawable, z2);
        } else {
            this.f4414b.e = z2;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z2) {
        super.setFilterBitmap(z2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.m(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, colorStateList);
            return;
        }
        h hVar = this.f4414b;
        if (hVar.f4465c != colorStateList) {
            hVar.f4465c = colorStateList;
            this.f4415c = j(this.f4415c, colorStateList, hVar.f4466d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, mode);
            return;
        }
        h hVar = this.f4414b;
        if (hVar.f4466d != mode) {
            hVar.f4466d = mode;
            this.f4415c = j(this.f4415c, hVar.f4465c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.f4412a;
        return drawable != null ? drawable.setVisible(z2, z3) : super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    private static class i extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f4474a;

        public i(Drawable.ConstantState constantState) {
            this.f4474a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f4474a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4474a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g();
            gVar.f4412a = (VectorDrawable) this.f4474a.newDrawable();
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            g gVar = new g();
            gVar.f4412a = (VectorDrawable) this.f4474a.newDrawable(resources);
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            g gVar = new g();
            gVar.f4412a = (VectorDrawable) this.f4474a.newDrawable(resources, theme);
            return gVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f4416d = colorFilter;
            invalidateSelf();
        }
    }

    private static abstract class f extends e {

        /* renamed from: a, reason: collision with root package name */
        protected h.b[] f4444a;

        /* renamed from: b, reason: collision with root package name */
        String f4445b;

        /* renamed from: c, reason: collision with root package name */
        int f4446c;

        /* renamed from: d, reason: collision with root package name */
        int f4447d;

        public f() {
            super();
            this.f4444a = null;
            this.f4446c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            h.b[] bVarArr = this.f4444a;
            if (bVarArr != null) {
                h.b.i(bVarArr, path);
            }
        }

        public h.b[] getPathData() {
            return this.f4444a;
        }

        public String getPathName() {
            return this.f4445b;
        }

        public void setPathData(h.b[] bVarArr) {
            if (androidx.core.graphics.h.b(this.f4444a, bVarArr)) {
                androidx.core.graphics.h.k(this.f4444a, bVarArr);
            } else {
                this.f4444a = androidx.core.graphics.h.f(bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f4444a = null;
            this.f4446c = 0;
            this.f4445b = fVar.f4445b;
            this.f4447d = fVar.f4447d;
            this.f4444a = androidx.core.graphics.h.f(fVar.f4444a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f4414b;
        hVar.f4464b = new C0059g();
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f4388a);
        i(typedArrayK, xmlPullParser, theme);
        typedArrayK.recycle();
        hVar.f4463a = getChangingConfigurations();
        hVar.f4472k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f4415c = j(this.f4415c, hVar.f4465c, hVar.f4466d);
    }

    g(h hVar) {
        this.f4417f = true;
        this.f4419h = new float[9];
        this.f4420i = new Matrix();
        this.f4421j = new Rect();
        this.f4414b = hVar;
        this.f4415c = j(this.f4415c, hVar.f4465c, hVar.f4466d);
    }

    private static class c extends f {
        private int[] e;

        /* renamed from: f, reason: collision with root package name */
        androidx.core.content.res.d f4422f;

        /* renamed from: g, reason: collision with root package name */
        float f4423g;

        /* renamed from: h, reason: collision with root package name */
        androidx.core.content.res.d f4424h;

        /* renamed from: i, reason: collision with root package name */
        float f4425i;

        /* renamed from: j, reason: collision with root package name */
        float f4426j;

        /* renamed from: k, reason: collision with root package name */
        float f4427k;

        /* renamed from: l, reason: collision with root package name */
        float f4428l;

        /* renamed from: m, reason: collision with root package name */
        float f4429m;

        /* renamed from: n, reason: collision with root package name */
        Paint.Cap f4430n;
        Paint.Join o;

        /* renamed from: p, reason: collision with root package name */
        float f4431p;

        c() {
            this.f4423g = 0.0f;
            this.f4425i = 1.0f;
            this.f4426j = 1.0f;
            this.f4427k = 0.0f;
            this.f4428l = 1.0f;
            this.f4429m = 0.0f;
            this.f4430n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.f4431p = 4.0f;
        }

        private Paint.Cap e(int i2, Paint.Cap cap) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join f(int i2, Paint.Join join) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.e = null;
            if (k.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f4445b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f4444a = androidx.core.graphics.h.d(string2);
                }
                this.f4424h = k.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f4426j = k.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f4426j);
                this.f4430n = e(k.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f4430n);
                this.o = f(k.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.f4431p = k.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f4431p);
                this.f4422f = k.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f4425i = k.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f4425i);
                this.f4423g = k.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f4423g);
                this.f4428l = k.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f4428l);
                this.f4429m = k.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f4429m);
                this.f4427k = k.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f4427k);
                this.f4446c = k.g(typedArray, xmlPullParser, "fillType", 13, this.f4446c);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.e
        public boolean a() {
            return this.f4424h.i() || this.f4422f.i();
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.e
        public boolean b(int[] iArr) {
            return this.f4422f.j(iArr) | this.f4424h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayK = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f4390c);
            h(typedArrayK, xmlPullParser, theme);
            typedArrayK.recycle();
        }

        float getFillAlpha() {
            return this.f4426j;
        }

        int getFillColor() {
            return this.f4424h.e();
        }

        float getStrokeAlpha() {
            return this.f4425i;
        }

        int getStrokeColor() {
            return this.f4422f.e();
        }

        float getStrokeWidth() {
            return this.f4423g;
        }

        float getTrimPathEnd() {
            return this.f4428l;
        }

        float getTrimPathOffset() {
            return this.f4429m;
        }

        float getTrimPathStart() {
            return this.f4427k;
        }

        void setFillAlpha(float f2) {
            this.f4426j = f2;
        }

        void setFillColor(int i2) {
            this.f4424h.k(i2);
        }

        void setStrokeAlpha(float f2) {
            this.f4425i = f2;
        }

        void setStrokeColor(int i2) {
            this.f4422f.k(i2);
        }

        void setStrokeWidth(float f2) {
            this.f4423g = f2;
        }

        void setTrimPathEnd(float f2) {
            this.f4428l = f2;
        }

        void setTrimPathOffset(float f2) {
            this.f4429m = f2;
        }

        void setTrimPathStart(float f2) {
            this.f4427k = f2;
        }

        c(c cVar) {
            super(cVar);
            this.f4423g = 0.0f;
            this.f4425i = 1.0f;
            this.f4426j = 1.0f;
            this.f4427k = 0.0f;
            this.f4428l = 1.0f;
            this.f4429m = 0.0f;
            this.f4430n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.f4431p = 4.0f;
            this.e = cVar.e;
            this.f4422f = cVar.f4422f;
            this.f4423g = cVar.f4423g;
            this.f4425i = cVar.f4425i;
            this.f4424h = cVar.f4424h;
            this.f4446c = cVar.f4446c;
            this.f4426j = cVar.f4426j;
            this.f4427k = cVar.f4427k;
            this.f4428l = cVar.f4428l;
            this.f4429m = cVar.f4429m;
            this.f4430n = cVar.f4430n;
            this.o = cVar.o;
            this.f4431p = cVar.f4431p;
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.g$g, reason: collision with other inner class name */
    private static class C0059g {

        /* renamed from: q, reason: collision with root package name */
        private static final Matrix f4448q = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        private final Path f4449a;

        /* renamed from: b, reason: collision with root package name */
        private final Path f4450b;

        /* renamed from: c, reason: collision with root package name */
        private final Matrix f4451c;

        /* renamed from: d, reason: collision with root package name */
        Paint f4452d;
        Paint e;

        /* renamed from: f, reason: collision with root package name */
        private PathMeasure f4453f;

        /* renamed from: g, reason: collision with root package name */
        private int f4454g;

        /* renamed from: h, reason: collision with root package name */
        final d f4455h;

        /* renamed from: i, reason: collision with root package name */
        float f4456i;

        /* renamed from: j, reason: collision with root package name */
        float f4457j;

        /* renamed from: k, reason: collision with root package name */
        float f4458k;

        /* renamed from: l, reason: collision with root package name */
        float f4459l;

        /* renamed from: m, reason: collision with root package name */
        int f4460m;

        /* renamed from: n, reason: collision with root package name */
        String f4461n;
        Boolean o;

        /* renamed from: p, reason: collision with root package name */
        final androidx.collection.a f4462p;

        public C0059g() {
            this.f4451c = new Matrix();
            this.f4456i = 0.0f;
            this.f4457j = 0.0f;
            this.f4458k = 0.0f;
            this.f4459l = 0.0f;
            this.f4460m = 255;
            this.f4461n = null;
            this.o = null;
            this.f4462p = new androidx.collection.a();
            this.f4455h = new d();
            this.f4449a = new Path();
            this.f4450b = new Path();
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            dVar.f4432a.set(matrix);
            dVar.f4432a.preConcat(dVar.f4440j);
            canvas.save();
            for (int i4 = 0; i4 < dVar.f4433b.size(); i4++) {
                e eVar = (e) dVar.f4433b.get(i4);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f4432a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = i2 / this.f4458k;
            float f3 = i3 / this.f4459l;
            float fMin = Math.min(f2, f3);
            Matrix matrix = dVar.f4432a;
            this.f4451c.set(matrix);
            this.f4451c.postScale(f2, f3);
            float fE = e(matrix);
            if (fE == 0.0f) {
                return;
            }
            fVar.d(this.f4449a);
            Path path = this.f4449a;
            this.f4450b.reset();
            if (fVar.c()) {
                this.f4450b.setFillType(fVar.f4446c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f4450b.addPath(path, this.f4451c);
                canvas.clipPath(this.f4450b);
                return;
            }
            c cVar = (c) fVar;
            float f4 = cVar.f4427k;
            if (f4 != 0.0f || cVar.f4428l != 1.0f) {
                float f5 = cVar.f4429m;
                float f6 = (f4 + f5) % 1.0f;
                float f7 = (cVar.f4428l + f5) % 1.0f;
                if (this.f4453f == null) {
                    this.f4453f = new PathMeasure();
                }
                this.f4453f.setPath(this.f4449a, false);
                float length = this.f4453f.getLength();
                float f8 = f6 * length;
                float f9 = f7 * length;
                path.reset();
                if (f8 > f9) {
                    this.f4453f.getSegment(f8, length, path, true);
                    this.f4453f.getSegment(0.0f, f9, path, true);
                } else {
                    this.f4453f.getSegment(f8, f9, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f4450b.addPath(path, this.f4451c);
            if (cVar.f4424h.l()) {
                androidx.core.content.res.d dVar2 = cVar.f4424h;
                if (this.e == null) {
                    Paint paint = new Paint(1);
                    this.e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.e;
                if (dVar2.h()) {
                    Shader shaderF = dVar2.f();
                    shaderF.setLocalMatrix(this.f4451c);
                    paint2.setShader(shaderF);
                    paint2.setAlpha(Math.round(cVar.f4426j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(g.a(dVar2.e(), cVar.f4426j));
                }
                paint2.setColorFilter(colorFilter);
                this.f4450b.setFillType(cVar.f4446c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f4450b, paint2);
            }
            if (cVar.f4422f.l()) {
                androidx.core.content.res.d dVar3 = cVar.f4422f;
                if (this.f4452d == null) {
                    Paint paint3 = new Paint(1);
                    this.f4452d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f4452d;
                Paint.Join join = cVar.o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f4430n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f4431p);
                if (dVar3.h()) {
                    Shader shaderF2 = dVar3.f();
                    shaderF2.setLocalMatrix(this.f4451c);
                    paint4.setShader(shaderF2);
                    paint4.setAlpha(Math.round(cVar.f4425i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(g.a(dVar3.e(), cVar.f4425i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f4423g * fMin * fE);
                canvas.drawPath(this.f4450b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fA) / fMax;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            c(this.f4455h, f4448q, canvas, i2, i3, colorFilter);
        }

        public boolean f() {
            if (this.o == null) {
                this.o = Boolean.valueOf(this.f4455h.a());
            }
            return this.o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f4455h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f4460m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.f4460m = i2;
        }

        public C0059g(C0059g c0059g) {
            this.f4451c = new Matrix();
            this.f4456i = 0.0f;
            this.f4457j = 0.0f;
            this.f4458k = 0.0f;
            this.f4459l = 0.0f;
            this.f4460m = 255;
            this.f4461n = null;
            this.o = null;
            androidx.collection.a aVar = new androidx.collection.a();
            this.f4462p = aVar;
            this.f4455h = new d(c0059g.f4455h, aVar);
            this.f4449a = new Path(c0059g.f4449a);
            this.f4450b = new Path(c0059g.f4450b);
            this.f4456i = c0059g.f4456i;
            this.f4457j = c0059g.f4457j;
            this.f4458k = c0059g.f4458k;
            this.f4459l = c0059g.f4459l;
            this.f4454g = c0059g.f4454g;
            this.f4460m = c0059g.f4460m;
            this.f4461n = c0059g.f4461n;
            String str = c0059g.f4461n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.o = c0059g.o;
        }
    }

    private static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        final Matrix f4432a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList f4433b;

        /* renamed from: c, reason: collision with root package name */
        float f4434c;

        /* renamed from: d, reason: collision with root package name */
        private float f4435d;
        private float e;

        /* renamed from: f, reason: collision with root package name */
        private float f4436f;

        /* renamed from: g, reason: collision with root package name */
        private float f4437g;

        /* renamed from: h, reason: collision with root package name */
        private float f4438h;

        /* renamed from: i, reason: collision with root package name */
        private float f4439i;

        /* renamed from: j, reason: collision with root package name */
        final Matrix f4440j;

        /* renamed from: k, reason: collision with root package name */
        int f4441k;

        /* renamed from: l, reason: collision with root package name */
        private int[] f4442l;

        /* renamed from: m, reason: collision with root package name */
        private String f4443m;

        public d(d dVar, androidx.collection.a aVar) {
            f bVar;
            super();
            this.f4432a = new Matrix();
            this.f4433b = new ArrayList();
            this.f4434c = 0.0f;
            this.f4435d = 0.0f;
            this.e = 0.0f;
            this.f4436f = 1.0f;
            this.f4437g = 1.0f;
            this.f4438h = 0.0f;
            this.f4439i = 0.0f;
            Matrix matrix = new Matrix();
            this.f4440j = matrix;
            this.f4443m = null;
            this.f4434c = dVar.f4434c;
            this.f4435d = dVar.f4435d;
            this.e = dVar.e;
            this.f4436f = dVar.f4436f;
            this.f4437g = dVar.f4437g;
            this.f4438h = dVar.f4438h;
            this.f4439i = dVar.f4439i;
            this.f4442l = dVar.f4442l;
            String str = dVar.f4443m;
            this.f4443m = str;
            this.f4441k = dVar.f4441k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f4440j);
            ArrayList arrayList = dVar.f4433b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Object obj = arrayList.get(i2);
                if (obj instanceof d) {
                    this.f4433b.add(new d((d) obj, aVar));
                } else {
                    if (obj instanceof c) {
                        bVar = new c((c) obj);
                    } else {
                        if (!(obj instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) obj);
                    }
                    this.f4433b.add(bVar);
                    Object obj2 = bVar.f4445b;
                    if (obj2 != null) {
                        aVar.put(obj2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.f4440j.reset();
            this.f4440j.postTranslate(-this.f4435d, -this.e);
            this.f4440j.postScale(this.f4436f, this.f4437g);
            this.f4440j.postRotate(this.f4434c, 0.0f, 0.0f);
            this.f4440j.postTranslate(this.f4438h + this.f4435d, this.f4439i + this.e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f4442l = null;
            this.f4434c = k.f(typedArray, xmlPullParser, "rotation", 5, this.f4434c);
            this.f4435d = typedArray.getFloat(1, this.f4435d);
            this.e = typedArray.getFloat(2, this.e);
            this.f4436f = k.f(typedArray, xmlPullParser, "scaleX", 3, this.f4436f);
            this.f4437g = k.f(typedArray, xmlPullParser, "scaleY", 4, this.f4437g);
            this.f4438h = k.f(typedArray, xmlPullParser, "translateX", 6, this.f4438h);
            this.f4439i = k.f(typedArray, xmlPullParser, "translateY", 7, this.f4439i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f4443m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.e
        public boolean a() {
            for (int i2 = 0; i2 < this.f4433b.size(); i2++) {
                if (((e) this.f4433b.get(i2)).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.g.e
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i2 = 0; i2 < this.f4433b.size(); i2++) {
                zB |= ((e) this.f4433b.get(i2)).b(iArr);
            }
            return zB;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayK = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f4389b);
            e(typedArrayK, xmlPullParser);
            typedArrayK.recycle();
        }

        public String getGroupName() {
            return this.f4443m;
        }

        public Matrix getLocalMatrix() {
            return this.f4440j;
        }

        public float getPivotX() {
            return this.f4435d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.f4434c;
        }

        public float getScaleX() {
            return this.f4436f;
        }

        public float getScaleY() {
            return this.f4437g;
        }

        public float getTranslateX() {
            return this.f4438h;
        }

        public float getTranslateY() {
            return this.f4439i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f4435d) {
                this.f4435d = f2;
                d();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.e) {
                this.e = f2;
                d();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f4434c) {
                this.f4434c = f2;
                d();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f4436f) {
                this.f4436f = f2;
                d();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f4437g) {
                this.f4437g = f2;
                d();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f4438h) {
                this.f4438h = f2;
                d();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f4439i) {
                this.f4439i = f2;
                d();
            }
        }

        public d() {
            super();
            this.f4432a = new Matrix();
            this.f4433b = new ArrayList();
            this.f4434c = 0.0f;
            this.f4435d = 0.0f;
            this.e = 0.0f;
            this.f4436f = 1.0f;
            this.f4437g = 1.0f;
            this.f4438h = 0.0f;
            this.f4439i = 0.0f;
            this.f4440j = new Matrix();
            this.f4443m = null;
        }
    }
}
