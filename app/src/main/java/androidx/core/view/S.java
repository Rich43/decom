package androidx.core.view;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class S {

    static class a {
        static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        static void c(ViewGroup viewGroup, boolean z2) {
            viewGroup.setTransitionGroup(z2);
        }
    }

    public static boolean a(ViewGroup viewGroup) {
        return a.b(viewGroup);
    }
}
