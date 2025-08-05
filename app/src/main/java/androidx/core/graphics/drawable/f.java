package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
final class f extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    int f3022a;

    /* renamed from: b, reason: collision with root package name */
    Drawable.ConstantState f3023b;

    /* renamed from: c, reason: collision with root package name */
    ColorStateList f3024c;

    /* renamed from: d, reason: collision with root package name */
    PorterDuff.Mode f3025d;

    f(f fVar) {
        this.f3024c = null;
        this.f3025d = d.f3015g;
        if (fVar != null) {
            this.f3022a = fVar.f3022a;
            this.f3023b = fVar.f3023b;
            this.f3024c = fVar.f3024c;
            this.f3025d = fVar.f3025d;
        }
    }

    boolean a() {
        return this.f3023b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i2 = this.f3022a;
        Drawable.ConstantState constantState = this.f3023b;
        return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new e(this, resources);
    }
}
