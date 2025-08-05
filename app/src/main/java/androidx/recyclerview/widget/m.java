package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
abstract class m {
    static int a(RecyclerView.z zVar, k kVar, View view, View view2, RecyclerView.o oVar, boolean z2) {
        if (oVar.J() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return Math.abs(oVar.g0(view) - oVar.g0(view2)) + 1;
        }
        return Math.min(kVar.n(), kVar.d(view2) - kVar.g(view));
    }

    static int b(RecyclerView.z zVar, k kVar, View view, View view2, RecyclerView.o oVar, boolean z2, boolean z3) {
        if (oVar.J() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z3 ? Math.max(0, (zVar.b() - Math.max(oVar.g0(view), oVar.g0(view2))) - 1) : Math.max(0, Math.min(oVar.g0(view), oVar.g0(view2)));
        if (z2) {
            return Math.round((iMax * (Math.abs(kVar.d(view2) - kVar.g(view)) / (Math.abs(oVar.g0(view) - oVar.g0(view2)) + 1))) + (kVar.m() - kVar.g(view)));
        }
        return iMax;
    }

    static int c(RecyclerView.z zVar, k kVar, View view, View view2, RecyclerView.o oVar, boolean z2) {
        if (oVar.J() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return zVar.b();
        }
        return (int) (((kVar.d(view2) - kVar.g(view)) / (Math.abs(oVar.g0(view) - oVar.g0(view2)) + 1)) * zVar.b());
    }
}
