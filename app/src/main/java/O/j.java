package O;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: classes.dex */
class j implements TypeEvaluator {

    /* renamed from: a, reason: collision with root package name */
    private Rect f445a;

    j() {
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f2, Rect rect, Rect rect2) {
        int i2 = rect.left + ((int) ((rect2.left - r0) * f2));
        int i3 = rect.top + ((int) ((rect2.top - r1) * f2));
        int i4 = rect.right + ((int) ((rect2.right - r2) * f2));
        int i5 = rect.bottom + ((int) ((rect2.bottom - r6) * f2));
        Rect rect3 = this.f445a;
        if (rect3 == null) {
            return new Rect(i2, i3, i4, i5);
        }
        rect3.set(i2, i3, i4, i5);
        return this.f445a;
    }
}
