package O;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
abstract class E {
    E() {
    }

    public abstract void a(View view);

    public float b(View view) {
        Float f2 = (Float) view.getTag(i.f443a);
        return f2 != null ? view.getAlpha() / f2.floatValue() : view.getAlpha();
    }

    public abstract void c(View view);

    public void d(View view, int i2, int i3, int i4, int i5) {
        view.setLeft(i2);
        view.setTop(i3);
        view.setRight(i4);
        view.setBottom(i5);
    }

    public abstract void e(View view, float f2);

    public abstract void f(View view, Matrix matrix);

    public abstract void g(View view, Matrix matrix);
}
