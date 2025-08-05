package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private TypedValue f2140a;

    /* renamed from: b, reason: collision with root package name */
    private TypedValue f2141b;

    /* renamed from: c, reason: collision with root package name */
    private TypedValue f2142c;

    /* renamed from: d, reason: collision with root package name */
    private TypedValue f2143d;
    private TypedValue e;

    /* renamed from: f, reason: collision with root package name */
    private TypedValue f2144f;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f2145g;

    /* renamed from: h, reason: collision with root package name */
    private a f2146h;

    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f2145g.set(i2, i3, i4, i5);
        if (isLaidOut()) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f2144f == null) {
            this.f2144f = new TypedValue();
        }
        return this.f2144f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f2142c == null) {
            this.f2142c = new TypedValue();
        }
        return this.f2142c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f2143d == null) {
            this.f2143d = new TypedValue();
        }
        return this.f2143d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f2140a == null) {
            this.f2140a = new TypedValue();
        }
        return this.f2140a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f2141b == null) {
            this.f2141b = new TypedValue();
        }
        return this.f2141b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f2146h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f2146h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f2146h = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2145g = new Rect();
    }
}
