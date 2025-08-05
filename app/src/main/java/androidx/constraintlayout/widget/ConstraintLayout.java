package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import defpackage.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    SparseArray f2647a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList f2648b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList f2649c;

    /* renamed from: d, reason: collision with root package name */
    o.h f2650d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private int f2651f;

    /* renamed from: g, reason: collision with root package name */
    private int f2652g;

    /* renamed from: h, reason: collision with root package name */
    private int f2653h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2654i;

    /* renamed from: j, reason: collision with root package name */
    private int f2655j;

    /* renamed from: k, reason: collision with root package name */
    private b f2656k;

    /* renamed from: l, reason: collision with root package name */
    private int f2657l;

    /* renamed from: m, reason: collision with root package name */
    private HashMap f2658m;

    /* renamed from: n, reason: collision with root package name */
    private int f2659n;
    private int o;

    /* renamed from: p, reason: collision with root package name */
    int f2660p;

    /* renamed from: q, reason: collision with root package name */
    int f2661q;
    int r;
    int s;

    public ConstraintLayout(Context context, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        super(context, attributeSet);
        this.f2647a = new SparseArray();
        this.f2648b = new ArrayList(4);
        this.f2649c = new ArrayList(100);
        this.f2650d = new o.h();
        this.e = 0;
        this.f2651f = 0;
        this.f2652g = Integer.MAX_VALUE;
        this.f2653h = Integer.MAX_VALUE;
        this.f2654i = true;
        this.f2655j = 7;
        this.f2656k = null;
        this.f2657l = -1;
        this.f2658m = new HashMap();
        this.f2659n = -1;
        this.o = -1;
        this.f2660p = -1;
        this.f2661q = -1;
        this.r = 0;
        this.s = 0;
        g(attributeSet);
    }

    private final o.g d(int i2) {
        if (i2 == 0) {
            return this.f2650d;
        }
        View viewFindViewById = (View) this.f2647a.get(i2);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i2)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f2650d;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((a) viewFindViewById.getLayoutParams()).f2710l0;
    }

    private void g(AttributeSet attributeSet) throws XmlPullParserException, IOException {
        this.f2650d.W(this);
        this.f2647a.put(getId(), this);
        this.f2656k = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p.c.f7064a);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == p.c.e) {
                    this.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                } else if (index == p.c.f7078f) {
                    this.f2651f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2651f);
                } else if (index == p.c.f7070c) {
                    this.f2652g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2652g);
                } else if (index == p.c.f7073d) {
                    this.f2653h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2653h);
                } else if (index == p.c.f7085h0) {
                    this.f2655j = typedArrayObtainStyledAttributes.getInt(index, this.f2655j);
                } else if (index == p.c.f7087i) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        b bVar = new b();
                        this.f2656k = bVar;
                        bVar.d(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.f2656k = null;
                    }
                    this.f2657l = resourceId;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f2650d.c1(this.f2655j);
    }

    private void h(int i2, int i3) {
        boolean z2;
        boolean z3;
        int baseline;
        int childMeasureSpec;
        int childMeasureSpec2;
        boolean z4;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                o.g gVar = aVar.f2710l0;
                if (!aVar.f2686Y && !aVar.f2687Z) {
                    gVar.x0(childAt.getVisibility());
                    int measuredWidth = ((ViewGroup.MarginLayoutParams) aVar).width;
                    int measuredHeight = ((ViewGroup.MarginLayoutParams) aVar).height;
                    boolean z5 = aVar.f2683V;
                    if (z5 || (z4 = aVar.f2684W) || (!z5 && aVar.f2670I == 1) || measuredWidth == -1 || (!z4 && (aVar.f2671J == 1 || measuredHeight == -1))) {
                        if (measuredWidth == 0) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingLeft, -2);
                            z2 = true;
                        } else if (measuredWidth == -1) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingLeft, -1);
                            z2 = false;
                        } else {
                            z2 = measuredWidth == -2;
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingLeft, measuredWidth);
                        }
                        if (measuredHeight == 0) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
                            z3 = true;
                        } else if (measuredHeight == -1) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, paddingTop, -1);
                            z3 = false;
                        } else {
                            z3 = measuredHeight == -2;
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, paddingTop, measuredHeight);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        gVar.z0(measuredWidth == -2);
                        gVar.c0(measuredHeight == -2);
                        measuredWidth = childAt.getMeasuredWidth();
                        measuredHeight = childAt.getMeasuredHeight();
                    } else {
                        z2 = false;
                        z3 = false;
                    }
                    gVar.y0(measuredWidth);
                    gVar.b0(measuredHeight);
                    if (z2) {
                        gVar.B0(measuredWidth);
                    }
                    if (z3) {
                        gVar.A0(measuredHeight);
                    }
                    if (aVar.f2685X && (baseline = childAt.getBaseline()) != -1) {
                        gVar.V(baseline);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x029b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i(int r25, int r26) {
        /*
            Method dump skipped, instructions count: 679
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.i(int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v0, types: [android.view.View, android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v32 */
    private void j() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        float f2;
        int i2;
        int i3;
        o.g gVarD;
        o.g gVarD2;
        o.g gVarD3;
        o.g gVarD4;
        int i4;
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        ?? r3 = 0;
        if (zIsInEditMode) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    k(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    d(childAt.getId()).X(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            o.g gVarF = f(getChildAt(i6));
            if (gVarF != null) {
                gVarF.Q();
            }
        }
        if (this.f2657l != -1) {
            for (int i7 = 0; i7 < childCount; i7++) {
                getChildAt(i7).getId();
            }
        }
        b bVar = this.f2656k;
        if (bVar != null) {
            bVar.a(this);
        }
        this.f2650d.M0();
        int size = this.f2648b.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                ((androidx.constraintlayout.widget.a) this.f2648b.get(i8)).e(this);
            }
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            getChildAt(i9);
        }
        int i10 = 0;
        while (i10 < childCount) {
            View childAt2 = getChildAt(i10);
            o.g gVarF2 = f(childAt2);
            if (gVarF2 != null) {
                a aVar = (a) childAt2.getLayoutParams();
                aVar.a();
                if (aVar.f2712m0) {
                    aVar.f2712m0 = r3;
                } else if (zIsInEditMode) {
                    try {
                        String resourceName2 = getResources().getResourceName(childAt2.getId());
                        k(r3, resourceName2, Integer.valueOf(childAt2.getId()));
                        d(childAt2.getId()).X(resourceName2.substring(resourceName2.indexOf("id/") + 3));
                    } catch (Resources.NotFoundException unused2) {
                    }
                }
                gVarF2.x0(childAt2.getVisibility());
                if (aVar.f2689a0) {
                    gVarF2.x0(8);
                }
                gVarF2.W(childAt2);
                this.f2650d.I0(gVarF2);
                if (!aVar.f2684W || !aVar.f2683V) {
                    this.f2649c.add(gVarF2);
                }
                if (aVar.f2686Y) {
                    o.j jVar = (o.j) gVarF2;
                    int i11 = aVar.f2704i0;
                    int i12 = aVar.f2706j0;
                    float f3 = aVar.f2708k0;
                    if (f3 != -1.0f) {
                        jVar.L0(f3);
                    } else if (i11 != -1) {
                        jVar.J0(i11);
                    } else if (i12 != -1) {
                        jVar.K0(i12);
                    }
                } else if (aVar.f2694d != -1 || aVar.e != -1 || aVar.f2697f != -1 || aVar.f2699g != -1 || aVar.f2715q != -1 || aVar.f2714p != -1 || aVar.r != -1 || aVar.s != -1 || aVar.f2701h != -1 || aVar.f2703i != -1 || aVar.f2705j != -1 || aVar.f2707k != -1 || aVar.f2709l != -1 || aVar.f2678Q != -1 || aVar.f2679R != -1 || aVar.f2711m != -1 || ((ViewGroup.MarginLayoutParams) aVar).width == -1 || ((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                    int i13 = aVar.f2691b0;
                    int i14 = aVar.f2693c0;
                    int i15 = aVar.f2695d0;
                    int i16 = aVar.f2696e0;
                    int i17 = aVar.f2698f0;
                    int i18 = aVar.f2700g0;
                    float f4 = aVar.f2702h0;
                    int i19 = aVar.f2711m;
                    if (i19 != -1) {
                        o.g gVarD5 = d(i19);
                        if (gVarD5 != null) {
                            gVarF2.f(gVarD5, aVar.o, aVar.f2713n);
                        }
                    } else {
                        if (i13 != -1) {
                            o.g gVarD6 = d(i13);
                            if (gVarD6 != null) {
                                o.f.d dVar = o.f.d.LEFT;
                                f2 = f4;
                                i2 = i18;
                                i3 = i16;
                                gVarF2.J(dVar, gVarD6, dVar, ((ViewGroup.MarginLayoutParams) aVar).leftMargin, i17);
                            } else {
                                f2 = f4;
                                i2 = i18;
                                i3 = i16;
                            }
                        } else {
                            f2 = f4;
                            i2 = i18;
                            i3 = i16;
                            if (i14 != -1 && (gVarD = d(i14)) != null) {
                                gVarF2.J(o.f.d.LEFT, gVarD, o.f.d.RIGHT, ((ViewGroup.MarginLayoutParams) aVar).leftMargin, i17);
                            }
                        }
                        if (i15 != -1) {
                            o.g gVarD7 = d(i15);
                            if (gVarD7 != null) {
                                gVarF2.J(o.f.d.RIGHT, gVarD7, o.f.d.LEFT, ((ViewGroup.MarginLayoutParams) aVar).rightMargin, i2);
                            }
                        } else {
                            int i20 = i3;
                            if (i20 != -1 && (gVarD2 = d(i20)) != null) {
                                o.f.d dVar2 = o.f.d.RIGHT;
                                gVarF2.J(dVar2, gVarD2, dVar2, ((ViewGroup.MarginLayoutParams) aVar).rightMargin, i2);
                            }
                        }
                        int i21 = aVar.f2701h;
                        if (i21 != -1) {
                            o.g gVarD8 = d(i21);
                            if (gVarD8 != null) {
                                o.f.d dVar3 = o.f.d.TOP;
                                gVarF2.J(dVar3, gVarD8, dVar3, ((ViewGroup.MarginLayoutParams) aVar).topMargin, aVar.f2717u);
                            }
                        } else {
                            int i22 = aVar.f2703i;
                            if (i22 != -1 && (gVarD3 = d(i22)) != null) {
                                gVarF2.J(o.f.d.TOP, gVarD3, o.f.d.BOTTOM, ((ViewGroup.MarginLayoutParams) aVar).topMargin, aVar.f2717u);
                            }
                        }
                        int i23 = aVar.f2705j;
                        if (i23 != -1) {
                            o.g gVarD9 = d(i23);
                            if (gVarD9 != null) {
                                gVarF2.J(o.f.d.BOTTOM, gVarD9, o.f.d.TOP, ((ViewGroup.MarginLayoutParams) aVar).bottomMargin, aVar.f2719w);
                            }
                        } else {
                            int i24 = aVar.f2707k;
                            if (i24 != -1 && (gVarD4 = d(i24)) != null) {
                                o.f.d dVar4 = o.f.d.BOTTOM;
                                gVarF2.J(dVar4, gVarD4, dVar4, ((ViewGroup.MarginLayoutParams) aVar).bottomMargin, aVar.f2719w);
                            }
                        }
                        int i25 = aVar.f2709l;
                        if (i25 != -1) {
                            View view = (View) this.f2647a.get(i25);
                            o.g gVarD10 = d(aVar.f2709l);
                            if (gVarD10 != null && view != null && (view.getLayoutParams() instanceof a)) {
                                a aVar2 = (a) view.getLayoutParams();
                                aVar.f2685X = true;
                                aVar2.f2685X = true;
                                o.f.d dVar5 = o.f.d.BASELINE;
                                gVarF2.h(dVar5).a(gVarD10.h(dVar5), 0, -1, o.f.c.STRONG, 0, true);
                                gVarF2.h(o.f.d.TOP).m();
                                gVarF2.h(o.f.d.BOTTOM).m();
                            }
                        }
                        if (f2 >= 0.0f && f2 != 0.5f) {
                            gVarF2.d0(f2);
                        }
                        float f5 = aVar.f2662A;
                        if (f5 >= 0.0f && f5 != 0.5f) {
                            gVarF2.r0(f5);
                        }
                    }
                    if (zIsInEditMode && ((i4 = aVar.f2678Q) != -1 || aVar.f2679R != -1)) {
                        gVarF2.o0(i4, aVar.f2679R);
                    }
                    if (aVar.f2683V) {
                        gVarF2.g0(o.g.b.FIXED);
                        gVarF2.y0(((ViewGroup.MarginLayoutParams) aVar).width);
                    } else if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                        gVarF2.g0(o.g.b.MATCH_PARENT);
                        gVarF2.h(o.f.d.LEFT).e = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                        gVarF2.h(o.f.d.RIGHT).e = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                    } else {
                        gVarF2.g0(o.g.b.MATCH_CONSTRAINT);
                        gVarF2.y0(0);
                    }
                    if (aVar.f2684W) {
                        r3 = 0;
                        gVarF2.u0(o.g.b.FIXED);
                        gVarF2.b0(((ViewGroup.MarginLayoutParams) aVar).height);
                    } else if (((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                        gVarF2.u0(o.g.b.MATCH_PARENT);
                        gVarF2.h(o.f.d.TOP).e = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                        gVarF2.h(o.f.d.BOTTOM).e = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        r3 = 0;
                    } else {
                        gVarF2.u0(o.g.b.MATCH_CONSTRAINT);
                        r3 = 0;
                        gVarF2.b0(0);
                    }
                    String str = aVar.f2663B;
                    if (str != null) {
                        gVarF2.Y(str);
                    }
                    gVarF2.i0(aVar.f2666E);
                    gVarF2.w0(aVar.f2667F);
                    gVarF2.e0(aVar.f2668G);
                    gVarF2.s0(aVar.f2669H);
                    gVarF2.h0(aVar.f2670I, aVar.f2672K, aVar.f2674M, aVar.f2676O);
                    gVarF2.v0(aVar.f2671J, aVar.f2673L, aVar.f2675N, aVar.f2677P);
                }
            }
            i10++;
            r3 = r3;
        }
    }

    private void l(int i2, int i3) {
        int iMin;
        o.g.b bVar;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        o.g.b bVar2 = o.g.b.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                bVar = o.g.b.WRAP_CONTENT;
            } else if (mode != 1073741824) {
                bVar = bVar2;
            } else {
                iMin = Math.min(this.f2652g, size) - paddingLeft;
                bVar = bVar2;
            }
            iMin = 0;
        } else {
            iMin = size;
            bVar = o.g.b.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                bVar2 = o.g.b.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.f2653h, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            bVar2 = o.g.b.WRAP_CONTENT;
        }
        this.f2650d.m0(0);
        this.f2650d.l0(0);
        this.f2650d.g0(bVar);
        this.f2650d.y0(iMin);
        this.f2650d.u0(bVar2);
        this.f2650d.b0(size2);
        this.f2650d.m0((this.e - getPaddingLeft()) - getPaddingRight());
        this.f2650d.l0((this.f2651f - getPaddingTop()) - getPaddingBottom());
    }

    private void n() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (getChildAt(i2).isLayoutRequested()) {
                this.f2649c.clear();
                j();
                return;
            }
        }
    }

    private void o() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2);
        }
        int size = this.f2648b.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                ((androidx.constraintlayout.widget.a) this.f2648b.get(i3)).d(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
    }

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public Object c(int i2, Object obj) {
        if (i2 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap map = this.f2658m;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f2658m.get(str);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) throws NumberFormatException {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i3 = Integer.parseInt(strArrSplit[0]);
                        int i4 = Integer.parseInt(strArrSplit[1]);
                        int i5 = Integer.parseInt(strArrSplit[2]);
                        int i6 = (int) ((i3 / 1080.0f) * width);
                        int i7 = (int) ((i4 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = i6;
                        float f3 = i7;
                        float f4 = i6 + ((int) ((i5 / 1080.0f) * width));
                        canvas.drawLine(f2, f3, f4, f3, paint);
                        float f5 = i7 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f4, f3, f4, f5, paint);
                        canvas.drawLine(f4, f5, f2, f5, paint);
                        canvas.drawLine(f2, f5, f2, f3, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f2, f3, f4, f5, paint);
                        canvas.drawLine(f2, f5, f4, f3, paint);
                    }
                }
            }
        }
    }

    public View e(int i2) {
        return (View) this.f2647a.get(i2);
    }

    public final o.g f(View view) {
        if (view == this) {
            return this.f2650d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).f2710l0;
    }

    public int getMaxHeight() {
        return this.f2653h;
    }

    public int getMaxWidth() {
        return this.f2652g;
    }

    public int getMinHeight() {
        return this.f2651f;
    }

    public int getMinWidth() {
        return this.e;
    }

    public int getOptimizationLevel() {
        return this.f2650d.R0();
    }

    public void k(int i2, Object obj, Object obj2) {
        if (i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f2658m == null) {
                this.f2658m = new HashMap();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.f2658m.put(strSubstring, num);
        }
    }

    protected void m(String str) {
        this.f2650d.K0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            a aVar = (a) childAt.getLayoutParams();
            o.g gVar = aVar.f2710l0;
            if ((childAt.getVisibility() != 8 || aVar.f2686Y || aVar.f2687Z || zIsInEditMode) && !aVar.f2689a0) {
                int iP = gVar.p();
                int iQ = gVar.q();
                childAt.layout(iP, iQ, gVar.D() + iP, gVar.r() + iQ);
            }
        }
        int size = this.f2648b.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                ((androidx.constraintlayout.widget.a) this.f2648b.get(i7)).c(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0117 A[PHI: r11
  0x0117: PHI (r11v1 int) = (r11v0 int), (r11v10 int), (r11v10 int) binds: [B:38:0x00ca, B:54:0x010a, B:56:0x010e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r21, int r22) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 881
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        o.g gVarF = f(view);
        if ((view instanceof c) && !(gVarF instanceof o.j)) {
            a aVar = (a) view.getLayoutParams();
            o.j jVar = new o.j();
            aVar.f2710l0 = jVar;
            aVar.f2686Y = true;
            jVar.M0(aVar.f2680S);
        }
        if (view instanceof androidx.constraintlayout.widget.a) {
            androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) view;
            aVar2.f();
            ((a) view.getLayoutParams()).f2687Z = true;
            if (!this.f2648b.contains(aVar2)) {
                this.f2648b.add(aVar2);
            }
        }
        this.f2647a.put(view.getId(), view);
        this.f2654i = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f2647a.remove(view.getId());
        o.g gVarF = f(view);
        this.f2650d.L0(gVarF);
        this.f2648b.remove(view);
        this.f2649c.remove(gVarF);
        this.f2654i = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.f2654i = true;
        this.f2659n = -1;
        this.o = -1;
        this.f2660p = -1;
        this.f2661q = -1;
        this.r = 0;
        this.s = 0;
    }

    public void setConstraintSet(b bVar) {
        this.f2656k = bVar;
    }

    @Override // android.view.View
    public void setId(int i2) {
        this.f2647a.remove(getId());
        super.setId(i2);
        this.f2647a.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 == this.f2653h) {
            return;
        }
        this.f2653h = i2;
        requestLayout();
    }

    public void setMaxWidth(int i2) {
        if (i2 == this.f2652g) {
            return;
        }
        this.f2652g = i2;
        requestLayout();
    }

    public void setMinHeight(int i2) {
        if (i2 == this.f2651f) {
            return;
        }
        this.f2651f = i2;
        requestLayout();
    }

    public void setMinWidth(int i2) {
        if (i2 == this.e) {
            return;
        }
        this.e = i2;
        requestLayout();
    }

    public void setOptimizationLevel(int i2) {
        this.f2650d.c1(i2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public static class a extends ViewGroup.MarginLayoutParams {

        /* renamed from: A, reason: collision with root package name */
        public float f2662A;

        /* renamed from: B, reason: collision with root package name */
        public String f2663B;

        /* renamed from: C, reason: collision with root package name */
        float f2664C;

        /* renamed from: D, reason: collision with root package name */
        int f2665D;

        /* renamed from: E, reason: collision with root package name */
        public float f2666E;

        /* renamed from: F, reason: collision with root package name */
        public float f2667F;

        /* renamed from: G, reason: collision with root package name */
        public int f2668G;

        /* renamed from: H, reason: collision with root package name */
        public int f2669H;

        /* renamed from: I, reason: collision with root package name */
        public int f2670I;

        /* renamed from: J, reason: collision with root package name */
        public int f2671J;

        /* renamed from: K, reason: collision with root package name */
        public int f2672K;

        /* renamed from: L, reason: collision with root package name */
        public int f2673L;

        /* renamed from: M, reason: collision with root package name */
        public int f2674M;

        /* renamed from: N, reason: collision with root package name */
        public int f2675N;

        /* renamed from: O, reason: collision with root package name */
        public float f2676O;

        /* renamed from: P, reason: collision with root package name */
        public float f2677P;

        /* renamed from: Q, reason: collision with root package name */
        public int f2678Q;

        /* renamed from: R, reason: collision with root package name */
        public int f2679R;

        /* renamed from: S, reason: collision with root package name */
        public int f2680S;

        /* renamed from: T, reason: collision with root package name */
        public boolean f2681T;

        /* renamed from: U, reason: collision with root package name */
        public boolean f2682U;

        /* renamed from: V, reason: collision with root package name */
        boolean f2683V;

        /* renamed from: W, reason: collision with root package name */
        boolean f2684W;

        /* renamed from: X, reason: collision with root package name */
        boolean f2685X;

        /* renamed from: Y, reason: collision with root package name */
        boolean f2686Y;

        /* renamed from: Z, reason: collision with root package name */
        boolean f2687Z;

        /* renamed from: a, reason: collision with root package name */
        public int f2688a;

        /* renamed from: a0, reason: collision with root package name */
        boolean f2689a0;

        /* renamed from: b, reason: collision with root package name */
        public int f2690b;

        /* renamed from: b0, reason: collision with root package name */
        int f2691b0;

        /* renamed from: c, reason: collision with root package name */
        public float f2692c;

        /* renamed from: c0, reason: collision with root package name */
        int f2693c0;

        /* renamed from: d, reason: collision with root package name */
        public int f2694d;

        /* renamed from: d0, reason: collision with root package name */
        int f2695d0;
        public int e;

        /* renamed from: e0, reason: collision with root package name */
        int f2696e0;

        /* renamed from: f, reason: collision with root package name */
        public int f2697f;

        /* renamed from: f0, reason: collision with root package name */
        int f2698f0;

        /* renamed from: g, reason: collision with root package name */
        public int f2699g;

        /* renamed from: g0, reason: collision with root package name */
        int f2700g0;

        /* renamed from: h, reason: collision with root package name */
        public int f2701h;

        /* renamed from: h0, reason: collision with root package name */
        float f2702h0;

        /* renamed from: i, reason: collision with root package name */
        public int f2703i;

        /* renamed from: i0, reason: collision with root package name */
        int f2704i0;

        /* renamed from: j, reason: collision with root package name */
        public int f2705j;

        /* renamed from: j0, reason: collision with root package name */
        int f2706j0;

        /* renamed from: k, reason: collision with root package name */
        public int f2707k;

        /* renamed from: k0, reason: collision with root package name */
        float f2708k0;

        /* renamed from: l, reason: collision with root package name */
        public int f2709l;

        /* renamed from: l0, reason: collision with root package name */
        o.g f2710l0;

        /* renamed from: m, reason: collision with root package name */
        public int f2711m;

        /* renamed from: m0, reason: collision with root package name */
        public boolean f2712m0;

        /* renamed from: n, reason: collision with root package name */
        public int f2713n;
        public float o;

        /* renamed from: p, reason: collision with root package name */
        public int f2714p;

        /* renamed from: q, reason: collision with root package name */
        public int f2715q;
        public int r;
        public int s;

        /* renamed from: t, reason: collision with root package name */
        public int f2716t;

        /* renamed from: u, reason: collision with root package name */
        public int f2717u;

        /* renamed from: v, reason: collision with root package name */
        public int f2718v;

        /* renamed from: w, reason: collision with root package name */
        public int f2719w;

        /* renamed from: x, reason: collision with root package name */
        public int f2720x;

        /* renamed from: y, reason: collision with root package name */
        public int f2721y;

        /* renamed from: z, reason: collision with root package name */
        public float f2722z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a, reason: collision with other inner class name */
        private static class C0023a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f2723a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f2723a = sparseIntArray;
                sparseIntArray.append(p.c.f7028I, 8);
                sparseIntArray.append(p.c.f7030J, 9);
                sparseIntArray.append(p.c.f7034L, 10);
                sparseIntArray.append(p.c.f7036M, 11);
                sparseIntArray.append(p.c.f7046R, 12);
                sparseIntArray.append(p.c.f7044Q, 13);
                sparseIntArray.append(p.c.f7110q, 14);
                sparseIntArray.append(p.c.f7107p, 15);
                sparseIntArray.append(p.c.f7102n, 16);
                sparseIntArray.append(p.c.r, 2);
                sparseIntArray.append(p.c.f7117t, 3);
                sparseIntArray.append(p.c.s, 4);
                sparseIntArray.append(p.c.f7062Z, 49);
                sparseIntArray.append(p.c.f7065a0, 50);
                sparseIntArray.append(p.c.f7127x, 5);
                sparseIntArray.append(p.c.f7129y, 6);
                sparseIntArray.append(p.c.f7131z, 7);
                sparseIntArray.append(p.c.f7067b, 1);
                sparseIntArray.append(p.c.f7038N, 17);
                sparseIntArray.append(p.c.f7040O, 18);
                sparseIntArray.append(p.c.f7125w, 19);
                sparseIntArray.append(p.c.f7123v, 20);
                sparseIntArray.append(p.c.f7074d0, 21);
                sparseIntArray.append(p.c.f7082g0, 22);
                sparseIntArray.append(p.c.f7076e0, 23);
                sparseIntArray.append(p.c.f7068b0, 24);
                sparseIntArray.append(p.c.f7079f0, 25);
                sparseIntArray.append(p.c.f7071c0, 26);
                sparseIntArray.append(p.c.f7020E, 29);
                sparseIntArray.append(p.c.f7048S, 30);
                sparseIntArray.append(p.c.f7120u, 44);
                sparseIntArray.append(p.c.f7024G, 45);
                sparseIntArray.append(p.c.f7052U, 46);
                sparseIntArray.append(p.c.f7022F, 47);
                sparseIntArray.append(p.c.f7050T, 48);
                sparseIntArray.append(p.c.f7096l, 27);
                sparseIntArray.append(p.c.f7093k, 28);
                sparseIntArray.append(p.c.f7054V, 31);
                sparseIntArray.append(p.c.f7012A, 32);
                sparseIntArray.append(p.c.f7058X, 33);
                sparseIntArray.append(p.c.f7056W, 34);
                sparseIntArray.append(p.c.f7060Y, 35);
                sparseIntArray.append(p.c.f7016C, 36);
                sparseIntArray.append(p.c.f7014B, 37);
                sparseIntArray.append(p.c.f7018D, 38);
                sparseIntArray.append(p.c.f7026H, 39);
                sparseIntArray.append(p.c.f7042P, 40);
                sparseIntArray.append(p.c.f7032K, 41);
                sparseIntArray.append(p.c.o, 42);
                sparseIntArray.append(p.c.f7099m, 43);
            }
        }

        public a(Context context, AttributeSet attributeSet) throws NumberFormatException {
            int i2;
            super(context, attributeSet);
            this.f2688a = -1;
            this.f2690b = -1;
            this.f2692c = -1.0f;
            this.f2694d = -1;
            this.e = -1;
            this.f2697f = -1;
            this.f2699g = -1;
            this.f2701h = -1;
            this.f2703i = -1;
            this.f2705j = -1;
            this.f2707k = -1;
            this.f2709l = -1;
            this.f2711m = -1;
            this.f2713n = 0;
            this.o = 0.0f;
            this.f2714p = -1;
            this.f2715q = -1;
            this.r = -1;
            this.s = -1;
            this.f2716t = -1;
            this.f2717u = -1;
            this.f2718v = -1;
            this.f2719w = -1;
            this.f2720x = -1;
            this.f2721y = -1;
            this.f2722z = 0.5f;
            this.f2662A = 0.5f;
            this.f2663B = null;
            this.f2664C = 0.0f;
            this.f2665D = 1;
            this.f2666E = -1.0f;
            this.f2667F = -1.0f;
            this.f2668G = 0;
            this.f2669H = 0;
            this.f2670I = 0;
            this.f2671J = 0;
            this.f2672K = 0;
            this.f2673L = 0;
            this.f2674M = 0;
            this.f2675N = 0;
            this.f2676O = 1.0f;
            this.f2677P = 1.0f;
            this.f2678Q = -1;
            this.f2679R = -1;
            this.f2680S = -1;
            this.f2681T = false;
            this.f2682U = false;
            this.f2683V = true;
            this.f2684W = true;
            this.f2685X = false;
            this.f2686Y = false;
            this.f2687Z = false;
            this.f2689a0 = false;
            this.f2691b0 = -1;
            this.f2693c0 = -1;
            this.f2695d0 = -1;
            this.f2696e0 = -1;
            this.f2698f0 = -1;
            this.f2700g0 = -1;
            this.f2702h0 = 0.5f;
            this.f2710l0 = new o.g();
            this.f2712m0 = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.c.f7064a);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                int i4 = C0023a.f2723a.get(index);
                switch (i4) {
                    case 1:
                        this.f2680S = typedArrayObtainStyledAttributes.getInt(index, this.f2680S);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f2711m);
                        this.f2711m = resourceId;
                        if (resourceId == -1) {
                            this.f2711m = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f2713n = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2713n);
                        break;
                    case 4:
                        float f2 = typedArrayObtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        this.o = f2;
                        if (f2 < 0.0f) {
                            this.o = (360.0f - f2) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f2688a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2688a);
                        break;
                    case 6:
                        this.f2690b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2690b);
                        break;
                    case 7:
                        this.f2692c = typedArrayObtainStyledAttributes.getFloat(index, this.f2692c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2694d);
                        this.f2694d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f2694d = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.e);
                        this.e = resourceId3;
                        if (resourceId3 == -1) {
                            this.e = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2697f);
                        this.f2697f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f2697f = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2699g);
                        this.f2699g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f2699g = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2701h);
                        this.f2701h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f2701h = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2703i);
                        this.f2703i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f2703i = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2705j);
                        this.f2705j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f2705j = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2707k);
                        this.f2707k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f2707k = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2709l);
                        this.f2709l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f2709l = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2714p);
                        this.f2714p = resourceId11;
                        if (resourceId11 == -1) {
                            this.f2714p = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2715q);
                        this.f2715q = resourceId12;
                        if (resourceId12 == -1) {
                            this.f2715q = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.r);
                        this.r = resourceId13;
                        if (resourceId13 == -1) {
                            this.r = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId14;
                        if (resourceId14 == -1) {
                            this.s = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f2716t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2716t);
                        break;
                    case 22:
                        this.f2717u = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2717u);
                        break;
                    case 23:
                        this.f2718v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2718v);
                        break;
                    case 24:
                        this.f2719w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2719w);
                        break;
                    case 25:
                        this.f2720x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2720x);
                        break;
                    case 26:
                        this.f2721y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2721y);
                        break;
                    case 27:
                        this.f2681T = typedArrayObtainStyledAttributes.getBoolean(index, this.f2681T);
                        break;
                    case 28:
                        this.f2682U = typedArrayObtainStyledAttributes.getBoolean(index, this.f2682U);
                        break;
                    case 29:
                        this.f2722z = typedArrayObtainStyledAttributes.getFloat(index, this.f2722z);
                        break;
                    case 30:
                        this.f2662A = typedArrayObtainStyledAttributes.getFloat(index, this.f2662A);
                        break;
                    case 31:
                        int i5 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f2670I = i5;
                        if (i5 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i6 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f2671J = i6;
                        if (i6 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.f2672K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2672K);
                            break;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2672K) == -2) {
                                this.f2672K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.f2674M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2674M);
                            break;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2674M) == -2) {
                                this.f2674M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.f2676O = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f2676O));
                        break;
                    case 36:
                        try {
                            this.f2673L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2673L);
                            break;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2673L) == -2) {
                                this.f2673L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.f2675N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2675N);
                            break;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2675N) == -2) {
                                this.f2675N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.f2677P = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f2677P));
                        break;
                    default:
                        switch (i4) {
                            case 44:
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                this.f2663B = string;
                                this.f2664C = Float.NaN;
                                this.f2665D = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int iIndexOf = this.f2663B.indexOf(44);
                                    if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                        i2 = 0;
                                    } else {
                                        String strSubstring = this.f2663B.substring(0, iIndexOf);
                                        if (strSubstring.equalsIgnoreCase("W")) {
                                            this.f2665D = 0;
                                        } else if (strSubstring.equalsIgnoreCase("H")) {
                                            this.f2665D = 1;
                                        }
                                        i2 = iIndexOf + 1;
                                    }
                                    int iIndexOf2 = this.f2663B.indexOf(58);
                                    if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                        String strSubstring2 = this.f2663B.substring(i2);
                                        if (strSubstring2.length() > 0) {
                                            this.f2664C = Float.parseFloat(strSubstring2);
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        String strSubstring3 = this.f2663B.substring(i2, iIndexOf2);
                                        String strSubstring4 = this.f2663B.substring(iIndexOf2 + 1);
                                        if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                                            break;
                                        } else {
                                            try {
                                                float f3 = Float.parseFloat(strSubstring3);
                                                float f4 = Float.parseFloat(strSubstring4);
                                                if (f3 <= 0.0f || f4 <= 0.0f) {
                                                    break;
                                                } else if (this.f2665D == 1) {
                                                    this.f2664C = Math.abs(f4 / f3);
                                                    break;
                                                } else {
                                                    this.f2664C = Math.abs(f3 / f4);
                                                    break;
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    break;
                                }
                                break;
                            case 45:
                                this.f2666E = typedArrayObtainStyledAttributes.getFloat(index, this.f2666E);
                                break;
                            case 46:
                                this.f2667F = typedArrayObtainStyledAttributes.getFloat(index, this.f2667F);
                                break;
                            case 47:
                                this.f2668G = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.f2669H = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.f2678Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2678Q);
                                break;
                            case 50:
                                this.f2679R = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2679R);
                                break;
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.f2686Y = false;
            this.f2683V = true;
            this.f2684W = true;
            int i2 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i2 == -2 && this.f2681T) {
                this.f2683V = false;
                this.f2670I = 1;
            }
            int i3 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i3 == -2 && this.f2682U) {
                this.f2684W = false;
                this.f2671J = 1;
            }
            if (i2 == 0 || i2 == -1) {
                this.f2683V = false;
                if (i2 == 0 && this.f2670I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f2681T = true;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.f2684W = false;
                if (i3 == 0 && this.f2671J == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f2682U = true;
                }
            }
            if (this.f2692c == -1.0f && this.f2688a == -1 && this.f2690b == -1) {
                return;
            }
            this.f2686Y = true;
            this.f2683V = true;
            this.f2684W = true;
            if (!(this.f2710l0 instanceof o.j)) {
                this.f2710l0 = new o.j();
            }
            ((o.j) this.f2710l0).M0(this.f2680S);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x007b  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r7) {
            /*
                Method dump skipped, instructions count: 256
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.resolveLayoutDirection(int):void");
        }

        public a(int i2, int i3) {
            super(i2, i3);
            this.f2688a = -1;
            this.f2690b = -1;
            this.f2692c = -1.0f;
            this.f2694d = -1;
            this.e = -1;
            this.f2697f = -1;
            this.f2699g = -1;
            this.f2701h = -1;
            this.f2703i = -1;
            this.f2705j = -1;
            this.f2707k = -1;
            this.f2709l = -1;
            this.f2711m = -1;
            this.f2713n = 0;
            this.o = 0.0f;
            this.f2714p = -1;
            this.f2715q = -1;
            this.r = -1;
            this.s = -1;
            this.f2716t = -1;
            this.f2717u = -1;
            this.f2718v = -1;
            this.f2719w = -1;
            this.f2720x = -1;
            this.f2721y = -1;
            this.f2722z = 0.5f;
            this.f2662A = 0.5f;
            this.f2663B = null;
            this.f2664C = 0.0f;
            this.f2665D = 1;
            this.f2666E = -1.0f;
            this.f2667F = -1.0f;
            this.f2668G = 0;
            this.f2669H = 0;
            this.f2670I = 0;
            this.f2671J = 0;
            this.f2672K = 0;
            this.f2673L = 0;
            this.f2674M = 0;
            this.f2675N = 0;
            this.f2676O = 1.0f;
            this.f2677P = 1.0f;
            this.f2678Q = -1;
            this.f2679R = -1;
            this.f2680S = -1;
            this.f2681T = false;
            this.f2682U = false;
            this.f2683V = true;
            this.f2684W = true;
            this.f2685X = false;
            this.f2686Y = false;
            this.f2687Z = false;
            this.f2689a0 = false;
            this.f2691b0 = -1;
            this.f2693c0 = -1;
            this.f2695d0 = -1;
            this.f2696e0 = -1;
            this.f2698f0 = -1;
            this.f2700g0 = -1;
            this.f2702h0 = 0.5f;
            this.f2710l0 = new o.g();
            this.f2712m0 = false;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2688a = -1;
            this.f2690b = -1;
            this.f2692c = -1.0f;
            this.f2694d = -1;
            this.e = -1;
            this.f2697f = -1;
            this.f2699g = -1;
            this.f2701h = -1;
            this.f2703i = -1;
            this.f2705j = -1;
            this.f2707k = -1;
            this.f2709l = -1;
            this.f2711m = -1;
            this.f2713n = 0;
            this.o = 0.0f;
            this.f2714p = -1;
            this.f2715q = -1;
            this.r = -1;
            this.s = -1;
            this.f2716t = -1;
            this.f2717u = -1;
            this.f2718v = -1;
            this.f2719w = -1;
            this.f2720x = -1;
            this.f2721y = -1;
            this.f2722z = 0.5f;
            this.f2662A = 0.5f;
            this.f2663B = null;
            this.f2664C = 0.0f;
            this.f2665D = 1;
            this.f2666E = -1.0f;
            this.f2667F = -1.0f;
            this.f2668G = 0;
            this.f2669H = 0;
            this.f2670I = 0;
            this.f2671J = 0;
            this.f2672K = 0;
            this.f2673L = 0;
            this.f2674M = 0;
            this.f2675N = 0;
            this.f2676O = 1.0f;
            this.f2677P = 1.0f;
            this.f2678Q = -1;
            this.f2679R = -1;
            this.f2680S = -1;
            this.f2681T = false;
            this.f2682U = false;
            this.f2683V = true;
            this.f2684W = true;
            this.f2685X = false;
            this.f2686Y = false;
            this.f2687Z = false;
            this.f2689a0 = false;
            this.f2691b0 = -1;
            this.f2693c0 = -1;
            this.f2695d0 = -1;
            this.f2696e0 = -1;
            this.f2698f0 = -1;
            this.f2700g0 = -1;
            this.f2702h0 = 0.5f;
            this.f2710l0 = new o.g();
            this.f2712m0 = false;
        }
    }
}
