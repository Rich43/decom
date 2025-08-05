package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.AbstractC0159b;
import com.eshare.mirror.AndroidMirrorPaintView;
import s0.AbstractC0325a;
import s0.AbstractC0326b;

/* loaded from: classes.dex */
public class s implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private View f7393a;

    /* renamed from: b, reason: collision with root package name */
    private View f7394b;

    /* renamed from: c, reason: collision with root package name */
    private Context f7395c;

    /* renamed from: d, reason: collision with root package name */
    private WindowManager f7396d;
    private WindowManager.LayoutParams e;

    /* renamed from: f, reason: collision with root package name */
    private WindowManager.LayoutParams f7397f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f7398g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7399h;

    /* renamed from: i, reason: collision with root package name */
    private AndroidMirrorPaintView f7400i;

    /* renamed from: j, reason: collision with root package name */
    private View f7401j;

    /* renamed from: k, reason: collision with root package name */
    private View f7402k;

    /* renamed from: l, reason: collision with root package name */
    private int f7403l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f7404m;

    /* renamed from: n, reason: collision with root package name */
    private int f7405n;
    private float o;

    /* renamed from: p, reason: collision with root package name */
    private float f7406p;

    /* renamed from: q, reason: collision with root package name */
    private float f7407q;
    private float r;
    private long s;

    /* renamed from: t, reason: collision with root package name */
    private int f7408t;

    /* renamed from: u, reason: collision with root package name */
    private int f7409u;

    /* renamed from: v, reason: collision with root package name */
    private long f7410v;

    /* renamed from: w, reason: collision with root package name */
    private int f7411w;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.f7400i.setVisibility(8);
        }
    }

    public interface b extends Menu {
    }

    public interface c extends MenuItem {
        c a(AbstractC0159b abstractC0159b);

        AbstractC0159b b();

        @Override // android.view.MenuItem
        boolean collapseActionView();

        @Override // android.view.MenuItem
        boolean expandActionView();

        @Override // android.view.MenuItem
        View getActionView();

        @Override // android.view.MenuItem
        int getAlphabeticModifiers();

        @Override // android.view.MenuItem
        CharSequence getContentDescription();

        @Override // android.view.MenuItem
        ColorStateList getIconTintList();

        @Override // android.view.MenuItem
        PorterDuff.Mode getIconTintMode();

        @Override // android.view.MenuItem
        int getNumericModifiers();

        @Override // android.view.MenuItem
        CharSequence getTooltipText();

        @Override // android.view.MenuItem
        boolean isActionViewExpanded();

        @Override // android.view.MenuItem
        MenuItem setActionView(int i2);

        @Override // android.view.MenuItem
        MenuItem setActionView(View view);

        @Override // android.view.MenuItem
        MenuItem setAlphabeticShortcut(char c2, int i2);

        @Override // android.view.MenuItem
        c setContentDescription(CharSequence charSequence);

        @Override // android.view.MenuItem
        MenuItem setIconTintList(ColorStateList colorStateList);

        @Override // android.view.MenuItem
        MenuItem setIconTintMode(PorterDuff.Mode mode);

        @Override // android.view.MenuItem
        MenuItem setNumericShortcut(char c2, int i2);

        @Override // android.view.MenuItem
        MenuItem setShortcut(char c2, char c3, int i2, int i3);

        @Override // android.view.MenuItem
        void setShowAsAction(int i2);

        @Override // android.view.MenuItem
        MenuItem setShowAsActionFlags(int i2);

        @Override // android.view.MenuItem
        c setTooltipText(CharSequence charSequence);
    }

    public s(Context context) {
        this.f7395c = context;
        f();
    }

    private void c() {
        this.f7398g = false;
        if (Build.VERSION.SDK_INT >= 26) {
            this.e.type = 2038;
            this.f7397f.type = 2038;
        } else {
            this.e.type = 2002;
            this.f7397f.type = 2002;
        }
        WindowManager.LayoutParams layoutParams = this.e;
        layoutParams.flags = 40;
        layoutParams.format = 1;
        WindowManager.LayoutParams layoutParams2 = this.f7397f;
        layoutParams2.flags = 40;
        layoutParams2.format = 1;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams2.width = -2;
        layoutParams2.height = this.f7409u;
        int i2 = layoutParams2.x;
        int i3 = this.f7405n;
        if (i2 > i3 / 2) {
            layoutParams2.x = i3;
        } else {
            layoutParams2.x = 0;
        }
        layoutParams.gravity = 8388659;
        this.f7400i.setVisibility(0);
        if (this.f7399h) {
            try {
                this.f7396d.updateViewLayout(this.f7393a, this.e);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.f7396d.updateViewLayout(this.f7394b, this.f7397f);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            this.f7397f.gravity = 8388661;
            try {
                this.f7396d.addView(this.f7393a, this.e);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                this.f7396d.addView(this.f7394b, this.f7397f);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        this.f7399h = true;
    }

    private void d() {
        if (this.f7398g) {
            h();
            this.f7403l = -65536;
            this.f7400i.setColor(-65536);
            c();
            this.f7401j.setBackgroundResource(AbstractC0325a.f7413a);
            return;
        }
        this.f7400i.a();
        g();
        this.f7401j.setBackgroundResource(AbstractC0325a.f7414b);
        this.f7402k.setVisibility(8);
        e();
    }

    private void e() {
        this.f7394b.findViewById(AbstractC0326b.e).setVisibility(8);
        this.f7394b.findViewById(AbstractC0326b.f7422g).setVisibility(8);
        this.f7394b.findViewById(AbstractC0326b.f7417a).setVisibility(8);
        this.f7394b.findViewById(AbstractC0326b.f7423h).setVisibility(8);
        this.f7394b.findViewById(AbstractC0326b.f7418b).setVisibility(8);
    }

    private void f() {
        this.f7396d = (WindowManager) this.f7395c.getApplicationContext().getSystemService("window");
        View view = new View(this.f7395c);
        this.f7401j = view;
        view.setBackgroundColor(-16777216);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.e = layoutParams;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
        layoutParams.format = 1;
        layoutParams.flags = 56;
        layoutParams.gravity = 8388659;
        layoutParams.width = 40;
        layoutParams.height = 40;
        this.f7396d.addView(this.f7401j, layoutParams);
        this.f7401j.setAlpha(0.0f);
    }

    private void g() {
        this.f7398g = true;
        if (Build.VERSION.SDK_INT >= 26) {
            this.e.type = 2038;
            this.f7397f.type = 2038;
        } else {
            this.e.type = 2002;
            this.f7397f.type = 2002;
        }
        WindowManager.LayoutParams layoutParams = this.e;
        layoutParams.flags = 40;
        layoutParams.format = 1;
        WindowManager.LayoutParams layoutParams2 = this.f7397f;
        layoutParams2.flags = 40;
        layoutParams2.format = 1;
        layoutParams.width = -2;
        layoutParams.height = -2;
        int i2 = this.f7408t;
        layoutParams2.width = i2;
        layoutParams2.height = i2;
        if (Math.abs(this.r - layoutParams2.y) > (this.f7408t * 3) / 2) {
            this.f7397f.y = (int) this.r;
        }
        WindowManager.LayoutParams layoutParams3 = this.f7397f;
        int i3 = layoutParams3.x;
        int i4 = this.f7405n;
        if (i3 > i4 / 2) {
            layoutParams3.x = i4;
        } else {
            layoutParams3.x = 0;
        }
        if (this.f7399h) {
            try {
                this.f7396d.updateViewLayout(this.f7393a, this.e);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.f7396d.updateViewLayout(this.f7394b, this.f7397f);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            layoutParams3.gravity = 8388661;
            try {
                this.f7396d.addView(this.f7393a, this.e);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                this.f7396d.addView(this.f7394b, this.f7397f);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        this.f7400i.post(new a());
        this.f7399h = true;
    }

    private void h() {
        this.f7394b.findViewById(AbstractC0326b.e).setVisibility(0);
        this.f7394b.findViewById(AbstractC0326b.f7422g).setVisibility(0);
        this.f7394b.findViewById(AbstractC0326b.f7417a).setVisibility(0);
        this.f7394b.findViewById(AbstractC0326b.f7423h).setVisibility(0);
        this.f7394b.findViewById(AbstractC0326b.f7418b).setVisibility(0);
    }

    public void b() {
        View view = this.f7401j;
        if (view != null) {
            this.f7396d.removeViewImmediate(view);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == AbstractC0326b.f7420d) {
            d();
            return;
        }
        if (id == AbstractC0326b.f7419c) {
            h();
            view.setVisibility(8);
            return;
        }
        if (id == AbstractC0326b.f7421f) {
            this.f7404m = true;
            return;
        }
        if (id == AbstractC0326b.e) {
            this.f7403l = -65536;
        } else if (id == AbstractC0326b.f7422g) {
            this.f7403l = -1;
        } else if (id == AbstractC0326b.f7417a) {
            this.f7403l = -16777216;
        } else if (id == AbstractC0326b.f7423h) {
            this.f7403l = -3840;
        } else if (id != AbstractC0326b.f7418b) {
            return;
        } else {
            this.f7403l = -16727297;
        }
        this.f7400i.setColor(this.f7403l);
        e();
        this.f7402k.setVisibility(0);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() != AbstractC0326b.f7420d) {
            return false;
        }
        this.f7407q = Math.abs(motionEvent.getRawX() - this.f7405n);
        this.r = Math.abs(motionEvent.getRawY());
        int action = motionEvent.getAction();
        if (action == 0) {
            this.o = motionEvent.getRawX();
            this.f7406p = motionEvent.getRawY();
            this.s = System.currentTimeMillis();
        } else if (action != 1) {
            if (action == 2 && (Math.abs(motionEvent.getRawX() - this.o) > this.f7411w || Math.abs(motionEvent.getRawY() - this.f7406p) > this.f7411w)) {
                this.f7397f.x = (int) Math.abs(motionEvent.getRawX() - this.f7405n);
                this.f7397f.y = (int) Math.abs(motionEvent.getRawY());
                WindowManager.LayoutParams layoutParams = this.f7397f;
                int i2 = this.f7408t;
                layoutParams.width = i2;
                layoutParams.height = i2;
                this.f7396d.updateViewLayout(this.f7394b, layoutParams);
            }
        } else if (Math.abs(motionEvent.getRawX() - this.o) >= this.f7411w || Math.abs(motionEvent.getRawY() - this.f7406p) >= this.f7411w) {
            WindowManager.LayoutParams layoutParams2 = this.f7397f;
            int i3 = layoutParams2.x;
            int i4 = this.f7405n;
            if (i3 > i4 / 2) {
                layoutParams2.x = i4;
            } else {
                layoutParams2.x = 0;
            }
            layoutParams2.y = (int) (motionEvent.getRawY() - (this.f7401j.getMeasuredHeight() / 2));
            this.f7396d.updateViewLayout(this.f7394b, this.f7397f);
        } else if (System.currentTimeMillis() - this.s < this.f7410v) {
            view.performClick();
        }
        return true;
    }
}
