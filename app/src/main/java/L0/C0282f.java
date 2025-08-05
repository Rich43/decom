package l0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;

/* renamed from: l0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0282f extends f.e {

    /* renamed from: d, reason: collision with root package name */
    private boolean f6550d = false;
    private EnumC0279c e = EnumC0279c.GONE;

    /* renamed from: f, reason: collision with root package name */
    private RectF f6551f = null;

    /* renamed from: g, reason: collision with root package name */
    private RecyclerView.C f6552g = null;

    /* renamed from: h, reason: collision with root package name */
    private AbstractC0283g f6553h;

    /* renamed from: i, reason: collision with root package name */
    private Context f6554i;

    /* renamed from: l0.f$a */
    class a implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f6555a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Canvas f6556b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RecyclerView f6557c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.C f6558d;
        final /* synthetic */ float e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f6559f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f6560g;

        a(float f2, Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, float f3, int i2, boolean z2) {
            this.f6555a = f2;
            this.f6556b = canvas;
            this.f6557c = recyclerView;
            this.f6558d = c2;
            this.e = f3;
            this.f6559f = i2;
            this.f6560g = z2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            C0282f c0282f = C0282f.this;
            boolean z2 = true;
            if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
                z2 = false;
            }
            c0282f.f6550d = z2;
            if (C0282f.this.f6550d) {
                float f2 = this.f6555a;
                if (f2 < -300.0f) {
                    C0282f.this.e = EnumC0279c.RIGHT_VISIBLE;
                } else if (f2 > 300.0f) {
                    C0282f.this.e = EnumC0279c.LEFT_VISIBLE;
                }
                if (C0282f.this.e != EnumC0279c.GONE) {
                    C0282f.this.O(this.f6556b, this.f6557c, this.f6558d, this.f6555a, this.e, this.f6559f, this.f6560g);
                    C0282f.this.N(this.f6557c, false);
                }
            }
            return false;
        }
    }

    /* renamed from: l0.f$b */
    class b implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Canvas f6562a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView f6563b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RecyclerView.C f6564c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f6565d;
        final /* synthetic */ float e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f6566f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f6567g;

        b(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, float f2, float f3, int i2, boolean z2) {
            this.f6562a = canvas;
            this.f6563b = recyclerView;
            this.f6564c = c2;
            this.f6565d = f2;
            this.e = f3;
            this.f6566f = i2;
            this.f6567g = z2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            C0282f.this.Q(this.f6562a, this.f6563b, this.f6564c, this.f6565d, this.e, this.f6566f, this.f6567g);
            return false;
        }
    }

    /* renamed from: l0.f$c */
    class c implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Canvas f6569a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView f6570b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RecyclerView.C f6571c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f6572d;
        final /* synthetic */ int e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f6573f;

        /* renamed from: l0.f$c$a */
        class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        }

        c(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, float f2, int i2, boolean z2) {
            this.f6569a = canvas;
            this.f6570b = recyclerView;
            this.f6571c = c2;
            this.f6572d = f2;
            this.e = i2;
            this.f6573f = z2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                C0282f.super.u(this.f6569a, this.f6570b, this.f6571c, 0.0f, this.f6572d, this.e, this.f6573f);
                this.f6570b.setOnTouchListener(new a());
                C0282f.this.N(this.f6570b, true);
                C0282f.this.f6550d = false;
                if (C0282f.this.f6553h != null && C0282f.this.f6551f != null && C0282f.this.f6551f.contains(motionEvent.getX(), motionEvent.getY())) {
                    if (C0282f.this.e == EnumC0279c.LEFT_VISIBLE) {
                        C0282f.this.f6553h.a(this.f6571c.j());
                    } else if (C0282f.this.e == EnumC0279c.RIGHT_VISIBLE) {
                        C0282f.this.f6553h.b(this.f6571c.j());
                    }
                }
                C0282f.this.e = EnumC0279c.GONE;
                C0282f.this.f6552g = null;
            }
            return false;
        }
    }

    public C0282f(Context context, AbstractC0283g abstractC0283g) {
        this.f6553h = abstractC0283g;
        this.f6554i = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(RecyclerView recyclerView, boolean z2) {
        for (int i2 = 0; i2 < recyclerView.getChildCount(); i2++) {
            recyclerView.getChildAt(i2).setClickable(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, float f2, float f3, int i2, boolean z2) {
        recyclerView.setOnTouchListener(new b(canvas, recyclerView, c2, f2, f3, i2, z2));
    }

    private void P(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, float f2, float f3, int i2, boolean z2) {
        recyclerView.setOnTouchListener(new a(f2, canvas, recyclerView, c2, f3, i2, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, float f2, float f3, int i2, boolean z2) {
        recyclerView.setOnTouchListener(new c(canvas, recyclerView, c2, f3, i2, z2));
    }

    @Override // androidx.recyclerview.widget.f.e
    public int d(int i2, int i3) {
        if (!this.f6550d) {
            return super.d(i2, i3);
        }
        this.f6550d = this.e != EnumC0279c.GONE;
        return 0;
    }

    @Override // androidx.recyclerview.widget.f.e
    public int k(RecyclerView recyclerView, RecyclerView.C c2) {
        return f.e.t(0, 8);
    }

    @Override // androidx.recyclerview.widget.f.e
    public void u(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, float f2, float f3, int i2, boolean z2) {
        float f4;
        if (i2 != 1) {
            f4 = f2;
        } else {
            EnumC0279c enumC0279c = this.e;
            if (enumC0279c != EnumC0279c.GONE) {
                if (enumC0279c == EnumC0279c.LEFT_VISIBLE) {
                    f2 = Math.max(f2, 300.0f);
                }
                if (this.e == EnumC0279c.RIGHT_VISIBLE) {
                    f2 = Math.min(f2, -300.0f);
                }
                f4 = f2;
                super.u(canvas, recyclerView, c2, f4, f3, i2, z2);
            } else {
                P(canvas, recyclerView, c2, f2, f3, i2, z2);
                f4 = f2;
            }
        }
        if (this.e == EnumC0279c.GONE) {
            super.u(canvas, recyclerView, c2, f4, f3, i2, z2);
        }
        this.f6552g = c2;
    }

    @Override // androidx.recyclerview.widget.f.e
    public boolean y(RecyclerView recyclerView, RecyclerView.C c2, RecyclerView.C c3) {
        return false;
    }

    @Override // androidx.recyclerview.widget.f.e
    public void B(RecyclerView.C c2, int i2) {
    }
}
