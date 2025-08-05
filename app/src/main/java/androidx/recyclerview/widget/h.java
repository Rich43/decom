package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.M;

/* loaded from: classes.dex */
class h implements g {

    /* renamed from: a */
    static final g f4266a = new h();

    h() {
    }

    private static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != view) {
                float fS = M.s(childAt);
                if (fS > f2) {
                    f2 = fS;
                }
            }
        }
        return f2;
    }

    @Override // androidx.recyclerview.widget.g
    public void a(View view) {
        int i2 = K.b.f254a;
        Object tag = view.getTag(i2);
        if (tag != null && (tag instanceof Float)) {
            M.m0(view, ((Float) tag).floatValue());
        }
        view.setTag(i2, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.g
    public void b(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int i2, boolean z2) {
    }

    @Override // androidx.recyclerview.widget.g
    public void c(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int i2, boolean z2) {
        if (z2) {
            int i3 = K.b.f254a;
            if (view.getTag(i3) == null) {
                Float fValueOf = Float.valueOf(M.s(view));
                M.m0(view, e(recyclerView, view) + 1.0f);
                view.setTag(i3, fValueOf);
            }
        }
        view.setTranslationX(f2);
        view.setTranslationY(f3);
    }

    @Override // androidx.recyclerview.widget.g
    public void d(View view) {
    }
}
