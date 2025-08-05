package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.h;
import f.AbstractC0250a;

/* loaded from: classes.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2415a;

    /* renamed from: b, reason: collision with root package name */
    private final TypedArray f2416b;

    /* renamed from: c, reason: collision with root package name */
    private TypedValue f2417c;

    private d0(Context context, TypedArray typedArray) {
        this.f2415a = context;
        this.f2416b = typedArray;
    }

    public static d0 s(Context context, int i2, int[] iArr) {
        return new d0(context, context.obtainStyledAttributes(i2, iArr));
    }

    public static d0 t(Context context, AttributeSet attributeSet, int[] iArr) {
        return new d0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static d0 u(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new d0(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public boolean a(int i2, boolean z2) {
        return this.f2416b.getBoolean(i2, z2);
    }

    public int b(int i2, int i3) {
        return this.f2416b.getColor(i2, i3);
    }

    public ColorStateList c(int i2) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f2416b.hasValue(i2) || (resourceId = this.f2416b.getResourceId(i2, 0)) == 0 || (colorStateListA = AbstractC0250a.a(this.f2415a, resourceId)) == null) ? this.f2416b.getColorStateList(i2) : colorStateListA;
    }

    public int d(int i2, int i3) {
        return this.f2416b.getDimensionPixelOffset(i2, i3);
    }

    public int e(int i2, int i3) {
        return this.f2416b.getDimensionPixelSize(i2, i3);
    }

    public Drawable f(int i2) {
        int resourceId;
        return (!this.f2416b.hasValue(i2) || (resourceId = this.f2416b.getResourceId(i2, 0)) == 0) ? this.f2416b.getDrawable(i2) : AbstractC0250a.b(this.f2415a, resourceId);
    }

    public Drawable g(int i2) {
        int resourceId;
        if (!this.f2416b.hasValue(i2) || (resourceId = this.f2416b.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return C0143k.b().d(this.f2415a, resourceId, true);
    }

    public float h(int i2, float f2) {
        return this.f2416b.getFloat(i2, f2);
    }

    public Typeface i(int i2, int i3, h.e eVar) {
        int resourceId = this.f2416b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f2417c == null) {
            this.f2417c = new TypedValue();
        }
        return androidx.core.content.res.h.f(this.f2415a, resourceId, this.f2417c, i3, eVar);
    }

    public int j(int i2, int i3) {
        return this.f2416b.getInt(i2, i3);
    }

    public int k(int i2, int i3) {
        return this.f2416b.getInteger(i2, i3);
    }

    public int l(int i2, int i3) {
        return this.f2416b.getLayoutDimension(i2, i3);
    }

    public int m(int i2, int i3) {
        return this.f2416b.getResourceId(i2, i3);
    }

    public String n(int i2) {
        return this.f2416b.getString(i2);
    }

    public CharSequence o(int i2) {
        return this.f2416b.getText(i2);
    }

    public CharSequence[] p(int i2) {
        return this.f2416b.getTextArray(i2);
    }

    public TypedArray q() {
        return this.f2416b;
    }

    public boolean r(int i2) {
        return this.f2416b.hasValue(i2);
    }

    public TypedValue v(int i2) {
        return this.f2416b.peekValue(i2);
    }

    public void w() {
        this.f2416b.recycle();
    }
}
