package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import defpackage.e;

/* loaded from: classes.dex */
class m0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2492a;

    /* renamed from: b, reason: collision with root package name */
    private final View f2493b;

    /* renamed from: c, reason: collision with root package name */
    private final TextView f2494c;

    /* renamed from: d, reason: collision with root package name */
    private final WindowManager.LayoutParams f2495d;
    private final Rect e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f2496f;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f2497g;

    m0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f2495d = layoutParams;
        this.e = new Rect();
        this.f2496f = new int[2];
        this.f2497g = new int[2];
        this.f2492a = context;
        View viewInflate = LayoutInflater.from(context).inflate(e.j.f5957q, (ViewGroup) null);
        this.f2493b = viewInflate;
        this.f2494c = (TextView) viewInflate.findViewById(e.i.r);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = e.l.f5968a;
        layoutParams.flags = 24;
    }

    private void a(View view, int i2, int i3, boolean z2, WindowManager.LayoutParams layoutParams) throws Resources.NotFoundException {
        int height;
        int i4;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f2492a.getResources().getDimensionPixelOffset(e.g.f5871g);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f2492a.getResources().getDimensionPixelOffset(e.g.f5870f);
            height = i3 + dimensionPixelOffset2;
            i4 = i3 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f2492a.getResources().getDimensionPixelOffset(z2 ? e.g.f5873i : e.g.f5872h);
        View viewB = b(view);
        if (viewB == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.e);
        Rect rect = this.e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f2492a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f2497g);
        view.getLocationOnScreen(this.f2496f);
        int[] iArr = this.f2496f;
        int i5 = iArr[0];
        int[] iArr2 = this.f2497g;
        int i6 = i5 - iArr2[0];
        iArr[0] = i6;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i6 + i2) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f2493b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f2493b.getMeasuredHeight();
        int i7 = this.f2496f[1];
        int i8 = ((i4 + i7) - dimensionPixelOffset3) - measuredHeight;
        int i9 = i7 + height + dimensionPixelOffset3;
        if (z2) {
            if (i8 >= 0) {
                layoutParams.y = i8;
                return;
            } else {
                layoutParams.y = i9;
                return;
            }
        }
        if (measuredHeight + i9 <= this.e.height()) {
            layoutParams.y = i9;
        } else {
            layoutParams.y = i8;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    void c() {
        if (d()) {
            ((WindowManager) this.f2492a.getSystemService("window")).removeView(this.f2493b);
        }
    }

    boolean d() {
        return this.f2493b.getParent() != null;
    }

    void e(View view, int i2, int i3, boolean z2, CharSequence charSequence) throws Resources.NotFoundException {
        if (d()) {
            c();
        }
        this.f2494c.setText(charSequence);
        a(view, i2, i3, z2, this.f2495d);
        ((WindowManager) this.f2492a.getSystemService("window")).addView(this.f2493b, this.f2495d);
    }
}
