package com.caglobal.kodakluma.view;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    protected static a f5512g;

    /* renamed from: a, reason: collision with root package name */
    private int f5513a;

    /* renamed from: b, reason: collision with root package name */
    private int f5514b;

    /* renamed from: c, reason: collision with root package name */
    private Context f5515c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f5516d;
    private WindowManager e;

    /* renamed from: f, reason: collision with root package name */
    private WindowManager.LayoutParams f5517f;

    private View b(int i2) {
        ImageView imageView = new ImageView(this.f5515c);
        imageView.setImageResource(i2);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(20, 20));
        return imageView;
    }

    public static synchronized a e() {
        try {
            if (f5512g == null) {
                f5512g = new a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f5512g;
    }

    private void f() {
        if (this.f5513a == 0 && this.f5514b == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.e.getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.heightPixels;
            this.f5513a = 0;
            this.f5514b = i2 / 2;
        }
    }

    public void a(Context context, int i2) {
        this.f5515c = context;
        this.e = (WindowManager) context.getSystemService("window");
        this.f5517f = new WindowManager.LayoutParams();
        this.f5516d = (ImageView) b(i2);
        f();
        WindowManager.LayoutParams layoutParams = this.f5517f;
        layoutParams.gravity = 85;
        layoutParams.format = 1;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.x = this.f5513a;
        layoutParams.y = this.f5514b - 25;
        layoutParams.flags = 40;
        layoutParams.alpha = 1.0f;
        this.e.addView(this.f5516d, layoutParams);
    }

    public void c() {
        ImageView imageView = this.f5516d;
        if (imageView != null) {
            this.e.removeViewImmediate(imageView);
            this.f5516d = null;
        }
    }

    public WindowManager.LayoutParams d() {
        return this.f5517f;
    }

    public void g() {
        ImageView imageView = this.f5516d;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    public void h() {
        ImageView imageView = this.f5516d;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.e.updateViewLayout(this.f5516d, this.f5517f);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        this.f5516d.setOnClickListener(onClickListener);
    }

    public void j(View.OnTouchListener onTouchListener) {
        this.f5516d.setOnTouchListener(onTouchListener);
    }
}
