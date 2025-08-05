package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f2128a = {R.attr.background};

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d0 d0VarT = d0.t(context, attributeSet, f2128a);
        setBackgroundDrawable(d0VarT.f(0));
        d0VarT.w();
    }
}
