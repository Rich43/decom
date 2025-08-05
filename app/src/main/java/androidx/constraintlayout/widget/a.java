package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.o;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class a extends View {

    /* renamed from: a */
    protected int[] f2724a;

    /* renamed from: b */
    protected int f2725b;

    /* renamed from: c */
    protected Context f2726c;

    /* renamed from: d */
    protected o.k f2727d;
    protected boolean e;

    /* renamed from: f */
    private String f2728f;

    public a(Context context) throws IllegalAccessException, IllegalArgumentException {
        super(context);
        this.f2724a = new int[32];
        this.e = false;
        this.f2726c = context;
        b(null);
    }

    private void a(String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        Object objC;
        if (str == null || this.f2726c == null) {
            return;
        }
        String strTrim = str.trim();
        try {
            iIntValue = p.b.class.getField(strTrim).getInt(null);
        } catch (Exception unused) {
            iIntValue = 0;
        }
        if (iIntValue == 0) {
            iIntValue = this.f2726c.getResources().getIdentifier(strTrim, "id", this.f2726c.getPackageName());
        }
        if (iIntValue == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (objC = ((ConstraintLayout) getParent()).c(0, strTrim)) != null && (objC instanceof Integer)) {
            iIntValue = ((Integer) objC).intValue();
        }
        if (iIntValue != 0) {
            setTag(iIntValue, null);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    private void setIds(String str) throws IllegalAccessException, IllegalArgumentException {
        if (str == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i2);
            if (iIndexOf == -1) {
                a(str.substring(i2));
                return;
            } else {
                a(str.substring(i2, iIndexOf));
                i2 = iIndexOf + 1;
            }
        }
    }

    protected void b(AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p.c.f7064a);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == p.c.f7090j) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f2728f = string;
                    setIds(string);
                }
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
    }

    public void d(ConstraintLayout constraintLayout) {
    }

    public void e(ConstraintLayout constraintLayout) throws IllegalAccessException, IllegalArgumentException {
        if (isInEditMode()) {
            setIds(this.f2728f);
        }
        o.k kVar = this.f2727d;
        if (kVar == null) {
            return;
        }
        kVar.J0();
        for (int i2 = 0; i2 < this.f2725b; i2++) {
            View viewE = constraintLayout.e(this.f2724a[i2]);
            if (viewE != null) {
                this.f2727d.I0(constraintLayout.f(viewE));
            }
        }
    }

    public void f() {
        if (this.f2727d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a) layoutParams).f2710l0 = this.f2727d;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f2724a, this.f2725b);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.e) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f2725b = 0;
        for (int i2 : iArr) {
            setTag(i2, null);
        }
    }

    @Override // android.view.View
    public void setTag(int i2, Object obj) {
        int i3 = this.f2725b + 1;
        int[] iArr = this.f2724a;
        if (i3 > iArr.length) {
            this.f2724a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f2724a;
        int i4 = this.f2725b;
        iArr2[i4] = i2;
        this.f2725b = i4 + 1;
    }
}
