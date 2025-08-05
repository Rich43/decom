package com.king.zxing;

import W0.l;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import z0.o;

/* loaded from: classes.dex */
public final class ViewfinderView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f5752a;

    /* renamed from: b, reason: collision with root package name */
    private TextPaint f5753b;

    /* renamed from: c, reason: collision with root package name */
    private int f5754c;

    /* renamed from: d, reason: collision with root package name */
    private int f5755d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private int f5756f;

    /* renamed from: g, reason: collision with root package name */
    private int f5757g;

    /* renamed from: h, reason: collision with root package name */
    private float f5758h;

    /* renamed from: i, reason: collision with root package name */
    private c f5759i;

    /* renamed from: j, reason: collision with root package name */
    private String f5760j;

    /* renamed from: k, reason: collision with root package name */
    private int f5761k;

    /* renamed from: l, reason: collision with root package name */
    private float f5762l;

    /* renamed from: m, reason: collision with root package name */
    public int f5763m;

    /* renamed from: n, reason: collision with root package name */
    public int f5764n;
    private boolean o;

    /* renamed from: p, reason: collision with root package name */
    private int f5765p;

    /* renamed from: q, reason: collision with root package name */
    private int f5766q;
    private int r;
    private int s;

    /* renamed from: t, reason: collision with root package name */
    private b f5767t;

    /* renamed from: u, reason: collision with root package name */
    private int f5768u;

    /* renamed from: v, reason: collision with root package name */
    private int f5769v;

    /* renamed from: w, reason: collision with root package name */
    private Rect f5770w;

    /* renamed from: x, reason: collision with root package name */
    private List f5771x;

    /* renamed from: y, reason: collision with root package name */
    private List f5772y;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5773a;

        static {
            int[] iArr = new int[b.values().length];
            f5773a = iArr;
            try {
                iArr[b.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5773a[b.GRID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        NONE(0),
        LINE(1),
        GRID(2);


        /* renamed from: a, reason: collision with root package name */
        private int f5777a;

        b(int i2) {
            this.f5777a = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b c(int i2) {
            for (b bVar : values()) {
                if (bVar.f5777a == i2) {
                    return bVar;
                }
            }
            return LINE;
        }
    }

    public enum c {
        TOP(0),
        BOTTOM(1);


        /* renamed from: a, reason: collision with root package name */
        private int f5781a;

        c(int i2) {
            this.f5781a = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b(int i2) {
            for (c cVar : values()) {
                if (cVar.f5781a == i2) {
                    return cVar;
                }
            }
            return TOP;
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(Canvas canvas, Rect rect) {
        this.f5752a.setColor(this.f5756f);
        canvas.drawRect(rect.left, rect.top, r0 + 8, r1 + 40, this.f5752a);
        canvas.drawRect(rect.left, rect.top, r0 + 40, r1 + 8, this.f5752a);
        int i2 = rect.right;
        canvas.drawRect(i2 - 8, rect.top, i2, r1 + 40, this.f5752a);
        int i3 = rect.right;
        canvas.drawRect(i3 - 40, rect.top, i3, r1 + 8, this.f5752a);
        canvas.drawRect(rect.left, r1 - 8, r0 + 40, rect.bottom, this.f5752a);
        canvas.drawRect(rect.left, r1 - 40, r0 + 8, rect.bottom, this.f5752a);
        canvas.drawRect(r0 - 8, r1 - 40, rect.right, rect.bottom, this.f5752a);
        canvas.drawRect(r0 - 40, r10 - 8, rect.right, rect.bottom, this.f5752a);
    }

    private void c(Canvas canvas, Rect rect, int i2, int i3) {
        this.f5752a.setColor(this.f5754c);
        float f2 = i2;
        canvas.drawRect(0.0f, 0.0f, f2, rect.top, this.f5752a);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f5752a);
        canvas.drawRect(rect.right + 1, rect.top, f2, rect.bottom + 1, this.f5752a);
        canvas.drawRect(0.0f, rect.bottom + 1, f2, i3, this.f5752a);
    }

    private void d(Canvas canvas, Rect rect) {
        this.f5752a.setColor(this.f5755d);
        canvas.drawRect(rect.left, rect.top, rect.right + 1, r0 + 2, this.f5752a);
        canvas.drawRect(rect.left, rect.top + 2, r0 + 2, rect.bottom - 1, this.f5752a);
        int i2 = rect.right;
        canvas.drawRect(i2 - 1, rect.top, i2 + 1, rect.bottom - 1, this.f5752a);
        float f2 = rect.left;
        int i3 = rect.bottom;
        canvas.drawRect(f2, i3 - 1, rect.right + 1, i3 + 1, this.f5752a);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(android.graphics.Canvas r14, android.graphics.Rect r15) {
        /*
            Method dump skipped, instructions count: 192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.zxing.ViewfinderView.e(android.graphics.Canvas, android.graphics.Rect):void");
    }

    private void f(Canvas canvas, Rect rect) {
        if (this.f5767t != null) {
            this.f5752a.setColor(this.e);
            int i2 = a.f5773a[this.f5767t.ordinal()];
            if (i2 == 1) {
                g(canvas, rect);
            } else if (i2 == 2) {
                e(canvas, rect);
            }
            this.f5752a.setShader(null);
        }
    }

    private void g(Canvas canvas, Rect rect) {
        int i2 = rect.left;
        this.f5752a.setShader(new LinearGradient(i2, this.f5763m, i2, r2 + 10, l(this.e), this.e, Shader.TileMode.MIRROR));
        if (this.f5763m > this.f5764n) {
            this.f5763m = rect.top;
            return;
        }
        canvas.drawOval(new RectF(rect.left + 20, this.f5763m, rect.right - 20, r2 + 10), this.f5752a);
        this.f5763m += 6;
    }

    private DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    private void h(Canvas canvas, Rect rect) {
        if (this.o) {
            List<o> list = this.f5771x;
            List<o> list2 = this.f5772y;
            if (list.isEmpty()) {
                this.f5772y = null;
            } else {
                this.f5771x = new ArrayList(5);
                this.f5772y = list;
                this.f5752a.setAlpha(160);
                this.f5752a.setColor(this.f5757g);
                synchronized (list) {
                    try {
                        for (o oVar : list) {
                            canvas.drawCircle(oVar.c(), oVar.d(), 10.0f, this.f5752a);
                        }
                    } finally {
                    }
                }
            }
            if (list2 != null) {
                this.f5752a.setAlpha(80);
                this.f5752a.setColor(this.f5757g);
                synchronized (list2) {
                    try {
                        for (o oVar2 : list2) {
                            canvas.drawCircle(oVar2.c(), oVar2.d(), 10.0f, this.f5752a);
                        }
                    } finally {
                    }
                }
            }
        }
    }

    private void i(Canvas canvas, Rect rect) {
        if (TextUtils.isEmpty(this.f5760j)) {
            return;
        }
        this.f5753b.setColor(this.f5761k);
        this.f5753b.setTextSize(this.f5762l);
        this.f5753b.setTextAlign(Paint.Align.CENTER);
        StaticLayout staticLayout = new StaticLayout(this.f5760j, this.f5753b, canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        if (this.f5759i == c.BOTTOM) {
            canvas.translate(rect.left + (rect.width() / 2), rect.bottom + this.f5758h);
            staticLayout.draw(canvas);
        } else {
            canvas.translate(rect.left + (rect.width() / 2), (rect.top - this.f5758h) - staticLayout.getHeight());
            staticLayout.draw(canvas);
        }
    }

    private void k(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W0.o.f1106a);
        this.f5754c = typedArrayObtainStyledAttributes.getColor(W0.o.o, androidx.core.content.a.b(context, l.f1097d));
        this.f5755d = typedArrayObtainStyledAttributes.getColor(W0.o.f1108c, androidx.core.content.a.b(context, l.f1095b));
        this.f5756f = typedArrayObtainStyledAttributes.getColor(W0.o.f1107b, androidx.core.content.a.b(context, l.f1094a));
        this.e = typedArrayObtainStyledAttributes.getColor(W0.o.f1117m, androidx.core.content.a.b(context, l.f1096c));
        this.f5757g = typedArrayObtainStyledAttributes.getColor(W0.o.f1119p, androidx.core.content.a.b(context, l.e));
        this.f5760j = typedArrayObtainStyledAttributes.getString(W0.o.f1112h);
        this.f5761k = typedArrayObtainStyledAttributes.getColor(W0.o.f1113i, androidx.core.content.a.b(context, l.f1098f));
        this.f5762l = typedArrayObtainStyledAttributes.getDimension(W0.o.f1116l, TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        this.f5758h = typedArrayObtainStyledAttributes.getDimension(W0.o.f1115k, TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        this.f5759i = c.b(typedArrayObtainStyledAttributes.getInt(W0.o.f1114j, 0));
        this.o = typedArrayObtainStyledAttributes.getBoolean(W0.o.f1120q, false);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(W0.o.e, 0);
        this.s = typedArrayObtainStyledAttributes.getDimensionPixelSize(W0.o.f1109d, 0);
        this.f5767t = b.c(typedArrayObtainStyledAttributes.getInt(W0.o.f1118n, b.LINE.f5777a));
        this.f5768u = typedArrayObtainStyledAttributes.getInt(W0.o.f1110f, 20);
        this.f5769v = (int) typedArrayObtainStyledAttributes.getDimension(W0.o.f1111g, TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics()));
        typedArrayObtainStyledAttributes.recycle();
        this.f5752a = new Paint(1);
        this.f5753b = new TextPaint(1);
        this.f5771x = new ArrayList(5);
        this.f5772y = null;
        this.f5765p = getDisplayMetrics().widthPixels;
        this.f5766q = getDisplayMetrics().heightPixels;
        int iMin = (int) (Math.min(this.f5765p, r4) * 0.625f);
        int i2 = this.r;
        if (i2 <= 0 || i2 > this.f5765p) {
            this.r = iMin;
        }
        int i3 = this.s;
        if (i3 <= 0 || i3 > this.f5766q) {
            this.s = iMin;
        }
    }

    public void a(o oVar) {
        if (this.o) {
            List list = this.f5771x;
            synchronized (list) {
                try {
                    list.add(oVar);
                    int size = list.size();
                    if (size > 20) {
                        list.subList(0, size - 10).clear();
                    }
                } finally {
                }
            }
        }
    }

    public void j() {
        invalidate();
    }

    public int l(int i2) {
        return Integer.valueOf("01" + Integer.toHexString(i2).substring(2), 16).intValue();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect = this.f5770w;
        if (rect == null) {
            return;
        }
        if (this.f5763m == 0 || this.f5764n == 0) {
            this.f5763m = rect.top;
            this.f5764n = rect.bottom - 10;
        }
        c(canvas, this.f5770w, canvas.getWidth(), canvas.getHeight());
        f(canvas, this.f5770w);
        d(canvas, this.f5770w);
        b(canvas, this.f5770w);
        i(canvas, this.f5770w);
        h(canvas, this.f5770w);
        Rect rect2 = this.f5770w;
        postInvalidateDelayed(15L, rect2.left - 20, rect2.top - 20, rect2.right + 20, rect2.bottom + 20);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int paddingLeft = (((this.f5765p - this.r) / 2) + getPaddingLeft()) - getPaddingRight();
        int paddingTop = (((this.f5766q - this.s) / 2) + getPaddingTop()) - getPaddingBottom();
        this.f5770w = new Rect(paddingLeft, paddingTop, this.r + paddingLeft, this.s + paddingTop);
    }

    public void setLabelText(String str) {
        this.f5760j = str;
    }

    public void setLabelTextColor(int i2) {
        this.f5761k = i2;
    }

    public void setLabelTextColorResource(int i2) {
        this.f5761k = androidx.core.content.a.b(getContext(), i2);
    }

    public void setLabelTextSize(float f2) {
        this.f5762l = f2;
    }

    public void setLaserStyle(b bVar) {
        this.f5767t = bVar;
    }

    public void setShowResultPoint(boolean z2) {
        this.o = z2;
    }

    public ViewfinderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5763m = 0;
        this.f5764n = 0;
        k(context, attributeSet);
    }
}
