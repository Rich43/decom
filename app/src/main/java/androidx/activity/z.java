package androidx.activity;

import android.view.View;

/* loaded from: classes.dex */
public abstract class z {
    public static final void a(View view, w wVar) {
        i1.k.e(view, "<this>");
        i1.k.e(wVar, "onBackPressedDispatcherOwner");
        view.setTag(x.f1541b, wVar);
    }
}
