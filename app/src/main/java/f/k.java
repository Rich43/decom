package F;

import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public final class k extends m {

    /* renamed from: b, reason: collision with root package name */
    private final boolean f179b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Fragment fragment, boolean z2) {
        super(fragment, "Attempting to set user visible hint to " + z2 + " for fragment " + fragment);
        i1.k.e(fragment, "fragment");
        this.f179b = z2;
    }
}
