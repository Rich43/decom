package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
import p.C0305a;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b */
    private static final int[] f2729b = {0, 4, 8};

    /* renamed from: c */
    private static SparseIntArray f2730c;

    /* renamed from: a */
    private HashMap f2731a = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2730c = sparseIntArray;
        sparseIntArray.append(p.c.f7086h1, 25);
        f2730c.append(p.c.f7089i1, 26);
        f2730c.append(p.c.f7095k1, 29);
        f2730c.append(p.c.f7098l1, 30);
        f2730c.append(p.c.f7112q1, 36);
        f2730c.append(p.c.f7109p1, 35);
        f2730c.append(p.c.f7043P0, 4);
        f2730c.append(p.c.f7041O0, 3);
        f2730c.append(p.c.f7037M0, 1);
        f2730c.append(p.c.y1, 6);
        f2730c.append(p.c.z1, 7);
        f2730c.append(p.c.f7057W0, 17);
        f2730c.append(p.c.f7059X0, 18);
        f2730c.append(p.c.f7061Y0, 19);
        f2730c.append(p.c.f7094k0, 27);
        f2730c.append(p.c.f7101m1, 32);
        f2730c.append(p.c.f7104n1, 33);
        f2730c.append(p.c.f7055V0, 10);
        f2730c.append(p.c.f7053U0, 9);
        f2730c.append(p.c.C1, 13);
        f2730c.append(p.c.F1, 16);
        f2730c.append(p.c.D1, 14);
        f2730c.append(p.c.A1, 11);
        f2730c.append(p.c.E1, 15);
        f2730c.append(p.c.B1, 12);
        f2730c.append(p.c.f7119t1, 40);
        f2730c.append(p.c.f7080f1, 39);
        f2730c.append(p.c.f7077e1, 41);
        f2730c.append(p.c.f7116s1, 42);
        f2730c.append(p.c.f7075d1, 20);
        f2730c.append(p.c.f7114r1, 37);
        f2730c.append(p.c.f7051T0, 5);
        f2730c.append(p.c.f7083g1, 75);
        f2730c.append(p.c.f7106o1, 75);
        f2730c.append(p.c.f7092j1, 75);
        f2730c.append(p.c.f7039N0, 75);
        f2730c.append(p.c.f7035L0, 75);
        f2730c.append(p.c.f7108p0, 24);
        f2730c.append(p.c.f7113r0, 28);
        f2730c.append(p.c.f7019D0, 31);
        f2730c.append(p.c.f7021E0, 8);
        f2730c.append(p.c.f7111q0, 34);
        f2730c.append(p.c.f7115s0, 2);
        f2730c.append(p.c.f7103n0, 23);
        f2730c.append(p.c.f7105o0, 21);
        f2730c.append(p.c.f7100m0, 22);
        f2730c.append(p.c.f7118t0, 43);
        f2730c.append(p.c.f7025G0, 44);
        f2730c.append(p.c.f7015B0, 45);
        f2730c.append(p.c.f7017C0, 46);
        f2730c.append(p.c.f7013A0, 60);
        f2730c.append(p.c.f7130y0, 47);
        f2730c.append(p.c.f7132z0, 48);
        f2730c.append(p.c.f7121u0, 49);
        f2730c.append(p.c.f7124v0, 50);
        f2730c.append(p.c.f7126w0, 51);
        f2730c.append(p.c.f7128x0, 52);
        f2730c.append(p.c.f7023F0, 53);
        f2730c.append(p.c.f7122u1, 54);
        f2730c.append(p.c.f7063Z0, 55);
        f2730c.append(p.c.v1, 56);
        f2730c.append(p.c.f7066a1, 57);
        f2730c.append(p.c.w1, 58);
        f2730c.append(p.c.f7069b1, 59);
        f2730c.append(p.c.f7045Q0, 61);
        f2730c.append(p.c.f7049S0, 62);
        f2730c.append(p.c.f7047R0, 63);
        f2730c.append(p.c.f7097l0, 38);
        f2730c.append(p.c.x1, 69);
        f2730c.append(p.c.f7072c1, 70);
        f2730c.append(p.c.f7031J0, 71);
        f2730c.append(p.c.f7029I0, 72);
        f2730c.append(p.c.f7033K0, 73);
        f2730c.append(p.c.f7027H0, 74);
    }

    private int[] b(View view, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        Object objC;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < strArrSplit.length) {
            String strTrim = strArrSplit[i2].trim();
            try {
                iIntValue = p.b.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objC = ((ConstraintLayout) view.getParent()).c(0, strTrim)) != null && (objC instanceof Integer)) {
                iIntValue = ((Integer) objC).intValue();
            }
            iArr[i3] = iIntValue;
            i2++;
            i3++;
        }
        return i3 != strArrSplit.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    private C0024b c(Context context, AttributeSet attributeSet) {
        C0024b c0024b = new C0024b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.c.f7091j0);
        f(c0024b, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return c0024b;
    }

    private static int e(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    private void f(C0024b c0024b, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            int i3 = f2730c.get(index);
            switch (i3) {
                case 1:
                    c0024b.f2786p = e(typedArray, index, c0024b.f2786p);
                    break;
                case 2:
                    c0024b.f2738G = typedArray.getDimensionPixelSize(index, c0024b.f2738G);
                    break;
                case 3:
                    c0024b.o = e(typedArray, index, c0024b.o);
                    break;
                case 4:
                    c0024b.f2783n = e(typedArray, index, c0024b.f2783n);
                    break;
                case 5:
                    c0024b.f2798w = typedArray.getString(index);
                    break;
                case 6:
                    c0024b.f2732A = typedArray.getDimensionPixelOffset(index, c0024b.f2732A);
                    break;
                case 7:
                    c0024b.f2733B = typedArray.getDimensionPixelOffset(index, c0024b.f2733B);
                    break;
                case 8:
                    c0024b.f2739H = typedArray.getDimensionPixelSize(index, c0024b.f2739H);
                    break;
                case 9:
                    c0024b.f2792t = e(typedArray, index, c0024b.f2792t);
                    break;
                case 10:
                    c0024b.s = e(typedArray, index, c0024b.s);
                    break;
                case 11:
                    c0024b.f2745N = typedArray.getDimensionPixelSize(index, c0024b.f2745N);
                    break;
                case 12:
                    c0024b.f2746O = typedArray.getDimensionPixelSize(index, c0024b.f2746O);
                    break;
                case 13:
                    c0024b.f2742K = typedArray.getDimensionPixelSize(index, c0024b.f2742K);
                    break;
                case 14:
                    c0024b.f2744M = typedArray.getDimensionPixelSize(index, c0024b.f2744M);
                    break;
                case 15:
                    c0024b.f2747P = typedArray.getDimensionPixelSize(index, c0024b.f2747P);
                    break;
                case 16:
                    c0024b.f2743L = typedArray.getDimensionPixelSize(index, c0024b.f2743L);
                    break;
                case 17:
                    c0024b.e = typedArray.getDimensionPixelOffset(index, c0024b.e);
                    break;
                case 18:
                    c0024b.f2767f = typedArray.getDimensionPixelOffset(index, c0024b.f2767f);
                    break;
                case 19:
                    c0024b.f2769g = typedArray.getFloat(index, c0024b.f2769g);
                    break;
                case 20:
                    c0024b.f2794u = typedArray.getFloat(index, c0024b.f2794u);
                    break;
                case 21:
                    c0024b.f2762c = typedArray.getLayoutDimension(index, c0024b.f2762c);
                    break;
                case 22:
                    int i4 = typedArray.getInt(index, c0024b.f2741J);
                    c0024b.f2741J = i4;
                    c0024b.f2741J = f2729b[i4];
                    break;
                case 23:
                    c0024b.f2760b = typedArray.getLayoutDimension(index, c0024b.f2760b);
                    break;
                case 24:
                    c0024b.f2735D = typedArray.getDimensionPixelSize(index, c0024b.f2735D);
                    break;
                case 25:
                    c0024b.f2771h = e(typedArray, index, c0024b.f2771h);
                    break;
                case 26:
                    c0024b.f2773i = e(typedArray, index, c0024b.f2773i);
                    break;
                case 27:
                    c0024b.f2734C = typedArray.getInt(index, c0024b.f2734C);
                    break;
                case 28:
                    c0024b.f2736E = typedArray.getDimensionPixelSize(index, c0024b.f2736E);
                    break;
                case 29:
                    c0024b.f2775j = e(typedArray, index, c0024b.f2775j);
                    break;
                case 30:
                    c0024b.f2777k = e(typedArray, index, c0024b.f2777k);
                    break;
                case 31:
                    c0024b.f2740I = typedArray.getDimensionPixelSize(index, c0024b.f2740I);
                    break;
                case 32:
                    c0024b.f2788q = e(typedArray, index, c0024b.f2788q);
                    break;
                case 33:
                    c0024b.r = e(typedArray, index, c0024b.r);
                    break;
                case 34:
                    c0024b.f2737F = typedArray.getDimensionPixelSize(index, c0024b.f2737F);
                    break;
                case 35:
                    c0024b.f2781m = e(typedArray, index, c0024b.f2781m);
                    break;
                case 36:
                    c0024b.f2779l = e(typedArray, index, c0024b.f2779l);
                    break;
                case 37:
                    c0024b.f2796v = typedArray.getFloat(index, c0024b.f2796v);
                    break;
                case 38:
                    c0024b.f2764d = typedArray.getResourceId(index, c0024b.f2764d);
                    break;
                case 39:
                    c0024b.f2749R = typedArray.getFloat(index, c0024b.f2749R);
                    break;
                case 40:
                    c0024b.f2748Q = typedArray.getFloat(index, c0024b.f2748Q);
                    break;
                case 41:
                    c0024b.f2750S = typedArray.getInt(index, c0024b.f2750S);
                    break;
                case 42:
                    c0024b.f2751T = typedArray.getInt(index, c0024b.f2751T);
                    break;
                case 43:
                    c0024b.f2752U = typedArray.getFloat(index, c0024b.f2752U);
                    break;
                case 44:
                    c0024b.f2753V = true;
                    c0024b.f2754W = typedArray.getDimension(index, c0024b.f2754W);
                    break;
                case 45:
                    c0024b.f2756Y = typedArray.getFloat(index, c0024b.f2756Y);
                    break;
                case 46:
                    c0024b.f2757Z = typedArray.getFloat(index, c0024b.f2757Z);
                    break;
                case 47:
                    c0024b.f2759a0 = typedArray.getFloat(index, c0024b.f2759a0);
                    break;
                case 48:
                    c0024b.f2761b0 = typedArray.getFloat(index, c0024b.f2761b0);
                    break;
                case 49:
                    c0024b.f2763c0 = typedArray.getFloat(index, c0024b.f2763c0);
                    break;
                case 50:
                    c0024b.f2765d0 = typedArray.getFloat(index, c0024b.f2765d0);
                    break;
                case 51:
                    c0024b.f2766e0 = typedArray.getDimension(index, c0024b.f2766e0);
                    break;
                case 52:
                    c0024b.f2768f0 = typedArray.getDimension(index, c0024b.f2768f0);
                    break;
                case 53:
                    c0024b.f2770g0 = typedArray.getDimension(index, c0024b.f2770g0);
                    break;
                default:
                    switch (i3) {
                        case 60:
                            c0024b.f2755X = typedArray.getFloat(index, c0024b.f2755X);
                            break;
                        case 61:
                            c0024b.f2799x = e(typedArray, index, c0024b.f2799x);
                            break;
                        case 62:
                            c0024b.f2800y = typedArray.getDimensionPixelSize(index, c0024b.f2800y);
                            break;
                        case 63:
                            c0024b.f2801z = typedArray.getFloat(index, c0024b.f2801z);
                            break;
                        default:
                            switch (i3) {
                                case 69:
                                    c0024b.f2787p0 = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    c0024b.f2789q0 = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    c0024b.f2791s0 = typedArray.getInt(index, c0024b.f2791s0);
                                    break;
                                case 73:
                                    c0024b.f2797v0 = typedArray.getString(index);
                                    break;
                                case 74:
                                    c0024b.f2790r0 = typedArray.getBoolean(index, c0024b.f2790r0);
                                    break;
                                case 75:
                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f2730c.get(index));
                                    break;
                                default:
                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f2730c.get(index));
                                    break;
                            }
                    }
            }
        }
    }

    void a(ConstraintLayout constraintLayout) throws IllegalAccessException, IllegalArgumentException {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f2731a.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (this.f2731a.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                C0024b c0024b = (C0024b) this.f2731a.get(Integer.valueOf(id));
                if (childAt instanceof C0305a) {
                    c0024b.f2793t0 = 1;
                }
                int i3 = c0024b.f2793t0;
                if (i3 != -1 && i3 == 1) {
                    C0305a c0305a = (C0305a) childAt;
                    c0305a.setId(id);
                    c0305a.setType(c0024b.f2791s0);
                    c0305a.setAllowsGoneWidget(c0024b.f2790r0);
                    int[] iArr = c0024b.f2795u0;
                    if (iArr != null) {
                        c0305a.setReferencedIds(iArr);
                    } else {
                        String str = c0024b.f2797v0;
                        if (str != null) {
                            int[] iArrB = b(c0305a, str);
                            c0024b.f2795u0 = iArrB;
                            c0305a.setReferencedIds(iArrB);
                        }
                    }
                }
                ConstraintLayout.a aVar = (ConstraintLayout.a) childAt.getLayoutParams();
                c0024b.a(aVar);
                childAt.setLayoutParams(aVar);
                childAt.setVisibility(c0024b.f2741J);
                childAt.setAlpha(c0024b.f2752U);
                childAt.setRotation(c0024b.f2755X);
                childAt.setRotationX(c0024b.f2756Y);
                childAt.setRotationY(c0024b.f2757Z);
                childAt.setScaleX(c0024b.f2759a0);
                childAt.setScaleY(c0024b.f2761b0);
                if (!Float.isNaN(c0024b.f2763c0)) {
                    childAt.setPivotX(c0024b.f2763c0);
                }
                if (!Float.isNaN(c0024b.f2765d0)) {
                    childAt.setPivotY(c0024b.f2765d0);
                }
                childAt.setTranslationX(c0024b.f2766e0);
                childAt.setTranslationY(c0024b.f2768f0);
                childAt.setTranslationZ(c0024b.f2770g0);
                if (c0024b.f2753V) {
                    childAt.setElevation(c0024b.f2754W);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            C0024b c0024b2 = (C0024b) this.f2731a.get(num);
            int i4 = c0024b2.f2793t0;
            if (i4 != -1 && i4 == 1) {
                C0305a c0305a2 = new C0305a(constraintLayout.getContext());
                c0305a2.setId(num.intValue());
                int[] iArr2 = c0024b2.f2795u0;
                if (iArr2 != null) {
                    c0305a2.setReferencedIds(iArr2);
                } else {
                    String str2 = c0024b2.f2797v0;
                    if (str2 != null) {
                        int[] iArrB2 = b(c0305a2, str2);
                        c0024b2.f2795u0 = iArrB2;
                        c0305a2.setReferencedIds(iArrB2);
                    }
                }
                c0305a2.setType(c0024b2.f2791s0);
                ConstraintLayout.a aVarGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                c0305a2.f();
                c0024b2.a(aVarGenerateDefaultLayoutParams);
                constraintLayout.addView(c0305a2, aVarGenerateDefaultLayoutParams);
            }
            if (c0024b2.f2758a) {
                View cVar = new c(constraintLayout.getContext());
                cVar.setId(num.intValue());
                ConstraintLayout.a aVarGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                c0024b2.a(aVarGenerateDefaultLayoutParams2);
                constraintLayout.addView(cVar, aVarGenerateDefaultLayoutParams2);
            }
        }
    }

    public void d(Context context, int i2) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    C0024b c0024bC = c(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        c0024bC.f2758a = true;
                    }
                    this.f2731a.put(Integer.valueOf(c0024bC.f2764d), c0024bC);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.b$b */
    private static class C0024b {

        /* renamed from: A */
        public int f2732A;

        /* renamed from: B */
        public int f2733B;

        /* renamed from: C */
        public int f2734C;

        /* renamed from: D */
        public int f2735D;

        /* renamed from: E */
        public int f2736E;

        /* renamed from: F */
        public int f2737F;

        /* renamed from: G */
        public int f2738G;

        /* renamed from: H */
        public int f2739H;

        /* renamed from: I */
        public int f2740I;

        /* renamed from: J */
        public int f2741J;

        /* renamed from: K */
        public int f2742K;

        /* renamed from: L */
        public int f2743L;

        /* renamed from: M */
        public int f2744M;

        /* renamed from: N */
        public int f2745N;

        /* renamed from: O */
        public int f2746O;

        /* renamed from: P */
        public int f2747P;

        /* renamed from: Q */
        public float f2748Q;

        /* renamed from: R */
        public float f2749R;

        /* renamed from: S */
        public int f2750S;

        /* renamed from: T */
        public int f2751T;

        /* renamed from: U */
        public float f2752U;

        /* renamed from: V */
        public boolean f2753V;

        /* renamed from: W */
        public float f2754W;

        /* renamed from: X */
        public float f2755X;

        /* renamed from: Y */
        public float f2756Y;

        /* renamed from: Z */
        public float f2757Z;

        /* renamed from: a */
        boolean f2758a;

        /* renamed from: a0 */
        public float f2759a0;

        /* renamed from: b */
        public int f2760b;

        /* renamed from: b0 */
        public float f2761b0;

        /* renamed from: c */
        public int f2762c;

        /* renamed from: c0 */
        public float f2763c0;

        /* renamed from: d */
        int f2764d;

        /* renamed from: d0 */
        public float f2765d0;
        public int e;

        /* renamed from: e0 */
        public float f2766e0;

        /* renamed from: f */
        public int f2767f;

        /* renamed from: f0 */
        public float f2768f0;

        /* renamed from: g */
        public float f2769g;

        /* renamed from: g0 */
        public float f2770g0;

        /* renamed from: h */
        public int f2771h;

        /* renamed from: h0 */
        public boolean f2772h0;

        /* renamed from: i */
        public int f2773i;

        /* renamed from: i0 */
        public boolean f2774i0;

        /* renamed from: j */
        public int f2775j;

        /* renamed from: j0 */
        public int f2776j0;

        /* renamed from: k */
        public int f2777k;

        /* renamed from: k0 */
        public int f2778k0;

        /* renamed from: l */
        public int f2779l;

        /* renamed from: l0 */
        public int f2780l0;

        /* renamed from: m */
        public int f2781m;

        /* renamed from: m0 */
        public int f2782m0;

        /* renamed from: n */
        public int f2783n;

        /* renamed from: n0 */
        public int f2784n0;
        public int o;

        /* renamed from: o0 */
        public int f2785o0;

        /* renamed from: p */
        public int f2786p;

        /* renamed from: p0 */
        public float f2787p0;

        /* renamed from: q */
        public int f2788q;

        /* renamed from: q0 */
        public float f2789q0;
        public int r;

        /* renamed from: r0 */
        public boolean f2790r0;
        public int s;

        /* renamed from: s0 */
        public int f2791s0;

        /* renamed from: t */
        public int f2792t;

        /* renamed from: t0 */
        public int f2793t0;

        /* renamed from: u */
        public float f2794u;

        /* renamed from: u0 */
        public int[] f2795u0;

        /* renamed from: v */
        public float f2796v;

        /* renamed from: v0 */
        public String f2797v0;

        /* renamed from: w */
        public String f2798w;

        /* renamed from: x */
        public int f2799x;

        /* renamed from: y */
        public int f2800y;

        /* renamed from: z */
        public float f2801z;

        private C0024b() {
            this.f2758a = false;
            this.e = -1;
            this.f2767f = -1;
            this.f2769g = -1.0f;
            this.f2771h = -1;
            this.f2773i = -1;
            this.f2775j = -1;
            this.f2777k = -1;
            this.f2779l = -1;
            this.f2781m = -1;
            this.f2783n = -1;
            this.o = -1;
            this.f2786p = -1;
            this.f2788q = -1;
            this.r = -1;
            this.s = -1;
            this.f2792t = -1;
            this.f2794u = 0.5f;
            this.f2796v = 0.5f;
            this.f2798w = null;
            this.f2799x = -1;
            this.f2800y = 0;
            this.f2801z = 0.0f;
            this.f2732A = -1;
            this.f2733B = -1;
            this.f2734C = -1;
            this.f2735D = -1;
            this.f2736E = -1;
            this.f2737F = -1;
            this.f2738G = -1;
            this.f2739H = -1;
            this.f2740I = -1;
            this.f2741J = 0;
            this.f2742K = -1;
            this.f2743L = -1;
            this.f2744M = -1;
            this.f2745N = -1;
            this.f2746O = -1;
            this.f2747P = -1;
            this.f2748Q = 0.0f;
            this.f2749R = 0.0f;
            this.f2750S = 0;
            this.f2751T = 0;
            this.f2752U = 1.0f;
            this.f2753V = false;
            this.f2754W = 0.0f;
            this.f2755X = 0.0f;
            this.f2756Y = 0.0f;
            this.f2757Z = 0.0f;
            this.f2759a0 = 1.0f;
            this.f2761b0 = 1.0f;
            this.f2763c0 = Float.NaN;
            this.f2765d0 = Float.NaN;
            this.f2766e0 = 0.0f;
            this.f2768f0 = 0.0f;
            this.f2770g0 = 0.0f;
            this.f2772h0 = false;
            this.f2774i0 = false;
            this.f2776j0 = 0;
            this.f2778k0 = 0;
            this.f2780l0 = -1;
            this.f2782m0 = -1;
            this.f2784n0 = -1;
            this.f2785o0 = -1;
            this.f2787p0 = 1.0f;
            this.f2789q0 = 1.0f;
            this.f2790r0 = false;
            this.f2791s0 = -1;
            this.f2793t0 = -1;
        }

        public void a(ConstraintLayout.a aVar) {
            aVar.f2694d = this.f2771h;
            aVar.e = this.f2773i;
            aVar.f2697f = this.f2775j;
            aVar.f2699g = this.f2777k;
            aVar.f2701h = this.f2779l;
            aVar.f2703i = this.f2781m;
            aVar.f2705j = this.f2783n;
            aVar.f2707k = this.o;
            aVar.f2709l = this.f2786p;
            aVar.f2714p = this.f2788q;
            aVar.f2715q = this.r;
            aVar.r = this.s;
            aVar.s = this.f2792t;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = this.f2735D;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = this.f2736E;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = this.f2737F;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = this.f2738G;
            aVar.f2720x = this.f2747P;
            aVar.f2721y = this.f2746O;
            aVar.f2722z = this.f2794u;
            aVar.f2662A = this.f2796v;
            aVar.f2711m = this.f2799x;
            aVar.f2713n = this.f2800y;
            aVar.o = this.f2801z;
            aVar.f2663B = this.f2798w;
            aVar.f2678Q = this.f2732A;
            aVar.f2679R = this.f2733B;
            aVar.f2667F = this.f2748Q;
            aVar.f2666E = this.f2749R;
            aVar.f2669H = this.f2751T;
            aVar.f2668G = this.f2750S;
            aVar.f2681T = this.f2772h0;
            aVar.f2682U = this.f2774i0;
            aVar.f2670I = this.f2776j0;
            aVar.f2671J = this.f2778k0;
            aVar.f2674M = this.f2780l0;
            aVar.f2675N = this.f2782m0;
            aVar.f2672K = this.f2784n0;
            aVar.f2673L = this.f2785o0;
            aVar.f2676O = this.f2787p0;
            aVar.f2677P = this.f2789q0;
            aVar.f2680S = this.f2734C;
            aVar.f2692c = this.f2769g;
            aVar.f2688a = this.e;
            aVar.f2690b = this.f2767f;
            ((ViewGroup.MarginLayoutParams) aVar).width = this.f2760b;
            ((ViewGroup.MarginLayoutParams) aVar).height = this.f2762c;
            aVar.setMarginStart(this.f2740I);
            aVar.setMarginEnd(this.f2739H);
            aVar.a();
        }

        /* renamed from: b */
        public C0024b clone() {
            C0024b c0024b = new C0024b();
            c0024b.f2758a = this.f2758a;
            c0024b.f2760b = this.f2760b;
            c0024b.f2762c = this.f2762c;
            c0024b.e = this.e;
            c0024b.f2767f = this.f2767f;
            c0024b.f2769g = this.f2769g;
            c0024b.f2771h = this.f2771h;
            c0024b.f2773i = this.f2773i;
            c0024b.f2775j = this.f2775j;
            c0024b.f2777k = this.f2777k;
            c0024b.f2779l = this.f2779l;
            c0024b.f2781m = this.f2781m;
            c0024b.f2783n = this.f2783n;
            c0024b.o = this.o;
            c0024b.f2786p = this.f2786p;
            c0024b.f2788q = this.f2788q;
            c0024b.r = this.r;
            c0024b.s = this.s;
            c0024b.f2792t = this.f2792t;
            c0024b.f2794u = this.f2794u;
            c0024b.f2796v = this.f2796v;
            c0024b.f2798w = this.f2798w;
            c0024b.f2732A = this.f2732A;
            c0024b.f2733B = this.f2733B;
            c0024b.f2794u = this.f2794u;
            c0024b.f2794u = this.f2794u;
            c0024b.f2794u = this.f2794u;
            c0024b.f2794u = this.f2794u;
            c0024b.f2794u = this.f2794u;
            c0024b.f2734C = this.f2734C;
            c0024b.f2735D = this.f2735D;
            c0024b.f2736E = this.f2736E;
            c0024b.f2737F = this.f2737F;
            c0024b.f2738G = this.f2738G;
            c0024b.f2739H = this.f2739H;
            c0024b.f2740I = this.f2740I;
            c0024b.f2741J = this.f2741J;
            c0024b.f2742K = this.f2742K;
            c0024b.f2743L = this.f2743L;
            c0024b.f2744M = this.f2744M;
            c0024b.f2745N = this.f2745N;
            c0024b.f2746O = this.f2746O;
            c0024b.f2747P = this.f2747P;
            c0024b.f2748Q = this.f2748Q;
            c0024b.f2749R = this.f2749R;
            c0024b.f2750S = this.f2750S;
            c0024b.f2751T = this.f2751T;
            c0024b.f2752U = this.f2752U;
            c0024b.f2753V = this.f2753V;
            c0024b.f2754W = this.f2754W;
            c0024b.f2755X = this.f2755X;
            c0024b.f2756Y = this.f2756Y;
            c0024b.f2757Z = this.f2757Z;
            c0024b.f2759a0 = this.f2759a0;
            c0024b.f2761b0 = this.f2761b0;
            c0024b.f2763c0 = this.f2763c0;
            c0024b.f2765d0 = this.f2765d0;
            c0024b.f2766e0 = this.f2766e0;
            c0024b.f2768f0 = this.f2768f0;
            c0024b.f2770g0 = this.f2770g0;
            c0024b.f2772h0 = this.f2772h0;
            c0024b.f2774i0 = this.f2774i0;
            c0024b.f2776j0 = this.f2776j0;
            c0024b.f2778k0 = this.f2778k0;
            c0024b.f2780l0 = this.f2780l0;
            c0024b.f2782m0 = this.f2782m0;
            c0024b.f2784n0 = this.f2784n0;
            c0024b.f2785o0 = this.f2785o0;
            c0024b.f2787p0 = this.f2787p0;
            c0024b.f2789q0 = this.f2789q0;
            c0024b.f2791s0 = this.f2791s0;
            c0024b.f2793t0 = this.f2793t0;
            int[] iArr = this.f2795u0;
            if (iArr != null) {
                c0024b.f2795u0 = Arrays.copyOf(iArr, iArr.length);
            }
            c0024b.f2799x = this.f2799x;
            c0024b.f2800y = this.f2800y;
            c0024b.f2801z = this.f2801z;
            c0024b.f2790r0 = this.f2790r0;
            return c0024b;
        }

        /* synthetic */ C0024b(a aVar) {
            this();
        }
    }
}
