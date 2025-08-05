package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import defpackage.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class F {

    /* renamed from: l, reason: collision with root package name */
    private static final RectF f2176l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap f2177m = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private int f2178a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2179b = false;

    /* renamed from: c, reason: collision with root package name */
    private float f2180c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f2181d = -1.0f;
    private float e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    private int[] f2182f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    private boolean f2183g = false;

    /* renamed from: h, reason: collision with root package name */
    private TextPaint f2184h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f2185i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f2186j;

    /* renamed from: k, reason: collision with root package name */
    private final d f2187k;

    private static final class a {
        static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3, TextView textView, TextPaint textPaint, d dVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i2);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i3 == -1) {
                i3 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i3);
            try {
                dVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    private static class b extends d {
        b() {
        }

        @Override // androidx.appcompat.widget.F.d
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) F.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    private static class c extends b {
        c() {
        }

        @Override // androidx.appcompat.widget.F.b, androidx.appcompat.widget.F.d
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.F.d
        boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    private static class d {
        d() {
        }

        void a(StaticLayout.Builder builder, TextView textView) {
        }

        boolean b(TextView textView) {
            return ((Boolean) F.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    F(TextView textView) {
        this.f2185i = textView;
        this.f2186j = textView.getContext();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            this.f2187k = new c();
        } else if (i2 >= 23) {
            this.f2187k = new b();
        } else {
            this.f2187k = new d();
        }
    }

    private int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f2178a = 0;
        this.f2181d = -1.0f;
        this.e = -1.0f;
        this.f2180c = -1.0f;
        this.f2182f = new int[0];
        this.f2179b = false;
    }

    private int e(RectF rectF) {
        int length = this.f2182f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i2 = 1;
        int i3 = length - 1;
        int i4 = 0;
        while (i2 <= i3) {
            int i5 = (i2 + i3) / 2;
            if (x(this.f2182f[i5], rectF)) {
                int i6 = i5 + 1;
                i4 = i2;
                i2 = i6;
            } else {
                i4 = i5 - 1;
                i3 = i4;
            }
        }
        return this.f2182f[i4];
    }

    private static Method k(String str) throws SecurityException {
        try {
            Method declaredMethod = (Method) f2177m.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, null)) != null) {
                declaredMethod.setAccessible(true);
                f2177m.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    static Object m(Object obj, String str, Object obj2) {
        try {
            return k(str).invoke(obj, null);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return obj2;
        }
    }

    private void s(float f2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f2 != this.f2185i.getPaint().getTextSize()) {
            this.f2185i.getPaint().setTextSize(f2);
            boolean zIsInLayout = this.f2185i.isInLayout();
            if (this.f2185i.getLayout() != null) {
                this.f2179b = false;
                try {
                    Method methodK = k("nullLayouts");
                    if (methodK != null) {
                        methodK.invoke(this.f2185i, null);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (zIsInLayout) {
                    this.f2185i.forceLayout();
                } else {
                    this.f2185i.requestLayout();
                }
                this.f2185i.invalidate();
            }
        }
    }

    private boolean u() {
        if (y() && this.f2178a == 1) {
            if (!this.f2183g || this.f2182f.length == 0) {
                int iFloor = ((int) Math.floor((this.e - this.f2181d) / this.f2180c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i2 = 0; i2 < iFloor; i2++) {
                    iArr[i2] = Math.round(this.f2181d + (i2 * this.f2180c));
                }
                this.f2182f = b(iArr);
            }
            this.f2179b = true;
        } else {
            this.f2179b = false;
        }
        return this.f2179b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.f2182f = b(iArr);
            w();
        }
    }

    private boolean w() {
        boolean z2 = this.f2182f.length > 0;
        this.f2183g = z2;
        if (z2) {
            this.f2178a = 1;
            this.f2181d = r0[0];
            this.e = r0[r1 - 1];
            this.f2180c = -1.0f;
        }
        return z2;
    }

    private boolean x(int i2, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f2185i.getText();
        TransformationMethod transformationMethod = this.f2185i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f2185i)) != null) {
            text = transformation;
        }
        int maxLines = this.f2185i.getMaxLines();
        l(i2);
        StaticLayout staticLayoutD = d(text, (Layout.Alignment) m(this.f2185i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutD.getLineCount() <= maxLines && staticLayoutD.getLineEnd(staticLayoutD.getLineCount() - 1) == text.length())) && ((float) staticLayoutD.getHeight()) <= rectF.bottom;
    }

    private boolean y() {
        return !(this.f2185i instanceof AppCompatEditText);
    }

    private void z(float f2, float f3, float f4) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        }
        if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        }
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
        this.f2178a = 1;
        this.f2181d = f2;
        this.e = f3;
        this.f2180c = f4;
        this.f2183g = false;
    }

    void a() {
        if (n()) {
            if (this.f2179b) {
                if (this.f2185i.getMeasuredHeight() <= 0 || this.f2185i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f2187k.b(this.f2185i) ? 1048576 : (this.f2185i.getMeasuredWidth() - this.f2185i.getTotalPaddingLeft()) - this.f2185i.getTotalPaddingRight();
                int height = (this.f2185i.getHeight() - this.f2185i.getCompoundPaddingBottom()) - this.f2185i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f2176l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fE = e(rectF);
                        if (fE != this.f2185i.getTextSize()) {
                            t(0, fE);
                        }
                    } finally {
                    }
                }
            }
            this.f2179b = true;
        }
    }

    StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(charSequence, alignment, i2, i3, this.f2185i, this.f2184h, this.f2187k);
        }
        return new StaticLayout(charSequence, this.f2184h, i2, alignment, this.f2185i.getLineSpacingMultiplier(), this.f2185i.getLineSpacingExtra(), this.f2185i.getIncludeFontPadding());
    }

    int f() {
        return Math.round(this.e);
    }

    int g() {
        return Math.round(this.f2181d);
    }

    int h() {
        return Math.round(this.f2180c);
    }

    int[] i() {
        return this.f2182f;
    }

    int j() {
        return this.f2178a;
    }

    void l(int i2) {
        TextPaint textPaint = this.f2184h;
        if (textPaint == null) {
            this.f2184h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f2184h.set(this.f2185i.getPaint());
        this.f2184h.setTextSize(i2);
    }

    boolean n() {
        return y() && this.f2178a != 0;
    }

    void o(AttributeSet attributeSet, int i2) {
        int resourceId;
        Context context = this.f2186j;
        int[] iArr = e.m.f6042g0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        TextView textView = this.f2185i;
        androidx.core.view.M.d0(textView, textView.getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        int i3 = e.m.f6057l0;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            this.f2178a = typedArrayObtainStyledAttributes.getInt(i3, 0);
        }
        int i4 = e.m.f6054k0;
        float dimension = typedArrayObtainStyledAttributes.hasValue(i4) ? typedArrayObtainStyledAttributes.getDimension(i4, -1.0f) : -1.0f;
        int i5 = e.m.f6048i0;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(i5) ? typedArrayObtainStyledAttributes.getDimension(i5, -1.0f) : -1.0f;
        int i6 = e.m.f6045h0;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(i6) ? typedArrayObtainStyledAttributes.getDimension(i6, -1.0f) : -1.0f;
        int i7 = e.m.f6051j0;
        if (typedArrayObtainStyledAttributes.hasValue(i7) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i7, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!y()) {
            this.f2178a = 0;
            return;
        }
        if (this.f2178a == 1) {
            if (!this.f2183g) {
                DisplayMetrics displayMetrics = this.f2186j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                z(dimension2, dimension3, dimension);
            }
            u();
        }
    }

    void p(int i2, int i3, int i4, int i5) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f2186j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i5, i2, displayMetrics), TypedValue.applyDimension(i5, i3, displayMetrics), TypedValue.applyDimension(i5, i4, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    void q(int[] iArr, int i2) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i2 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f2186j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArrCopyOf[i3] = Math.round(TypedValue.applyDimension(i2, iArr[i3], displayMetrics));
                    }
                }
                this.f2182f = b(iArrCopyOf);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f2183g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    void r(int i2) {
        if (y()) {
            if (i2 == 0) {
                c();
                return;
            }
            if (i2 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i2);
            }
            DisplayMetrics displayMetrics = this.f2186j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    void t(int i2, float f2) {
        Context context = this.f2186j;
        s(TypedValue.applyDimension(i2, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
