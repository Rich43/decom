package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.res.k;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class b extends f implements Animatable {

    /* renamed from: b, reason: collision with root package name */
    private C0058b f4399b;

    /* renamed from: c, reason: collision with root package name */
    private Context f4400c;

    /* renamed from: d, reason: collision with root package name */
    private ArgbEvaluator f4401d;
    private Animator.AnimatorListener e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList f4402f;

    /* renamed from: g, reason: collision with root package name */
    final Drawable.Callback f4403g;

    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            b.this.scheduleSelf(runnable, j2);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.b$b, reason: collision with other inner class name */
    private static class C0058b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f4405a;

        /* renamed from: b, reason: collision with root package name */
        g f4406b;

        /* renamed from: c, reason: collision with root package name */
        AnimatorSet f4407c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList f4408d;
        androidx.collection.a e;

        public C0058b(Context context, C0058b c0058b, Drawable.Callback callback, Resources resources) {
            if (c0058b != null) {
                this.f4405a = c0058b.f4405a;
                g gVar = c0058b.f4406b;
                if (gVar != null) {
                    Drawable.ConstantState constantState = gVar.getConstantState();
                    if (resources != null) {
                        this.f4406b = (g) constantState.newDrawable(resources);
                    } else {
                        this.f4406b = (g) constantState.newDrawable();
                    }
                    g gVar2 = (g) this.f4406b.mutate();
                    this.f4406b = gVar2;
                    gVar2.setCallback(callback);
                    this.f4406b.setBounds(c0058b.f4406b.getBounds());
                    this.f4406b.h(false);
                }
                ArrayList arrayList = c0058b.f4408d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f4408d = new ArrayList(size);
                    this.e = new androidx.collection.a(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        Animator animator = (Animator) c0058b.f4408d.get(i2);
                        Animator animatorClone = animator.clone();
                        String str = (String) c0058b.e.get(animator);
                        animatorClone.setTarget(this.f4406b.d(str));
                        this.f4408d.add(animatorClone);
                        this.e.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f4407c == null) {
                this.f4407c = new AnimatorSet();
            }
            this.f4407c.playTogether(this.f4408d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4405a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    b() {
        this(null, null, null);
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.f4399b.f4406b.d(str));
        C0058b c0058b = this.f4399b;
        if (c0058b.f4408d == null) {
            c0058b.f4408d = new ArrayList();
            this.f4399b.e = new androidx.collection.a();
        }
        this.f4399b.f4408d.add(animator);
        this.f4399b.e.put(animator, str);
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f4399b.f4406b.draw(canvas);
        if (this.f4399b.f4407c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f4412a;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.f4399b.f4406b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f4412a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f4399b.f4405a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f4412a;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f4399b.f4406b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f4412a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.f4412a.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f4412a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f4399b.f4406b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f4412a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f4399b.f4406b.getIntrinsicWidth();
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
        return drawable != null ? drawable.getOpacity() : this.f4399b.f4406b.getOpacity();
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

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayK = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.e);
                    int resourceId = typedArrayK.getResourceId(0, 0);
                    if (resourceId != 0) {
                        g gVarB = g.b(resources, resourceId, theme);
                        gVarB.h(false);
                        gVarB.setCallback(this.f4403g);
                        g gVar = this.f4399b.f4406b;
                        if (gVar != null) {
                            gVar.setCallback(null);
                        }
                        this.f4399b.f4406b = gVarB;
                    }
                    typedArrayK.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.graphics.drawable.a.f4392f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f4400c;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        b(string, d.i(context, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f4399b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f4412a;
        return drawable != null ? androidx.core.graphics.drawable.a.g(drawable) : this.f4399b.f4406b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f4412a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f4399b.f4407c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f4412a;
        return drawable != null ? drawable.isStateful() : this.f4399b.f4406b.isStateful();
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
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f4399b.f4406b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.f, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        Drawable drawable = this.f4412a;
        return drawable != null ? drawable.setLevel(i2) : this.f4399b.f4406b.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f4412a;
        return drawable != null ? drawable.setState(iArr) : this.f4399b.f4406b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.f4399b.f4406b.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.i(drawable, z2);
        } else {
            this.f4399b.f4406b.setAutoMirrored(z2);
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
            this.f4399b.f4406b.setTint(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, colorStateList);
        } else {
            this.f4399b.f4406b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, mode);
        } else {
            this.f4399b.f4406b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            return drawable.setVisible(z2, z3);
        }
        this.f4399b.f4406b.setVisible(z2, z3);
        return super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f4399b.f4407c.isStarted()) {
                return;
            }
            this.f4399b.f4407c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f4399b.f4407c.end();
        }
    }

    private b(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4412a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f4399b.f4406b.setColorFilter(colorFilter);
        }
    }

    private static class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f4409a;

        public c(Drawable.ConstantState constantState) {
            this.f4409a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f4409a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4409a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b();
            Drawable drawableNewDrawable = this.f4409a.newDrawable();
            bVar.f4412a = drawableNewDrawable;
            drawableNewDrawable.setCallback(bVar.f4403g);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            Drawable drawableNewDrawable = this.f4409a.newDrawable(resources);
            bVar.f4412a = drawableNewDrawable;
            drawableNewDrawable.setCallback(bVar.f4403g);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            Drawable drawableNewDrawable = this.f4409a.newDrawable(resources, theme);
            bVar.f4412a = drawableNewDrawable;
            drawableNewDrawable.setCallback(bVar.f4403g);
            return bVar;
        }
    }

    private b(Context context, C0058b c0058b, Resources resources) {
        this.f4401d = null;
        this.e = null;
        this.f4402f = null;
        a aVar = new a();
        this.f4403g = aVar;
        this.f4400c = context;
        if (c0058b != null) {
            this.f4399b = c0058b;
        } else {
            this.f4399b = new C0058b(context, c0058b, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, Resources.NotFoundException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
