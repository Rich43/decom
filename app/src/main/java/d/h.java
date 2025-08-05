package D;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

/* loaded from: classes.dex */
class h implements TransformationMethod {

    /* renamed from: a */
    private final TransformationMethod f76a;

    h(TransformationMethod transformationMethod) {
        this.f76a = transformationMethod;
    }

    public TransformationMethod a() {
        return this.f76a;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f76a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || androidx.emoji2.text.f.c().e() != 1) ? charSequence : androidx.emoji2.text.f.c().p(charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z2, int i2, Rect rect) {
        TransformationMethod transformationMethod = this.f76a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z2, i2, rect);
        }
    }
}
