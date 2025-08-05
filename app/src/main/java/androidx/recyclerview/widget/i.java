package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class i {

    /* renamed from: b, reason: collision with root package name */
    int f4268b;

    /* renamed from: c, reason: collision with root package name */
    int f4269c;

    /* renamed from: d, reason: collision with root package name */
    int f4270d;
    int e;

    /* renamed from: h, reason: collision with root package name */
    boolean f4273h;

    /* renamed from: i, reason: collision with root package name */
    boolean f4274i;

    /* renamed from: a, reason: collision with root package name */
    boolean f4267a = true;

    /* renamed from: f, reason: collision with root package name */
    int f4271f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f4272g = 0;

    i() {
    }

    boolean a(RecyclerView.z zVar) {
        int i2 = this.f4269c;
        return i2 >= 0 && i2 < zVar.b();
    }

    View b(RecyclerView.v vVar) {
        View viewO = vVar.o(this.f4269c);
        this.f4269c += this.f4270d;
        return viewO;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f4268b + ", mCurrentPosition=" + this.f4269c + ", mItemDirection=" + this.f4270d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f4271f + ", mEndLine=" + this.f4272g + '}';
    }
}
