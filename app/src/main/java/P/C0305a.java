package p;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import defpackage.o;

/* renamed from: p.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0305a extends androidx.constraintlayout.widget.a {

    /* renamed from: g, reason: collision with root package name */
    private int f7009g;

    /* renamed from: h, reason: collision with root package name */
    private int f7010h;

    /* renamed from: i, reason: collision with root package name */
    private o.c f7011i;

    public C0305a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.a
    protected void b(AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException {
        super.b(attributeSet);
        this.f7011i = new o.c();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.f7064a);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == c.f7084h) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == c.f7081g) {
                    this.f7011i.K0(typedArrayObtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f2727d = this.f7011i;
        f();
    }

    public int getType() {
        return this.f7009g;
    }

    public void setAllowsGoneWidget(boolean z2) {
        this.f7011i.K0(z2);
    }

    public void setType(int i2) {
        this.f7009g = i2;
        this.f7010h = i2;
        if (1 == getResources().getConfiguration().getLayoutDirection()) {
            int i3 = this.f7009g;
            if (i3 == 5) {
                this.f7010h = 1;
            } else if (i3 == 6) {
                this.f7010h = 0;
            }
        } else {
            int i4 = this.f7009g;
            if (i4 == 5) {
                this.f7010h = 0;
            } else if (i4 == 6) {
                this.f7010h = 1;
            }
        }
        this.f7011i.L0(this.f7010h);
    }
}
