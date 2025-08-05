package F;

import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public final class a extends m {

    /* renamed from: b, reason: collision with root package name */
    private final String f159b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Fragment fragment, String str) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + str);
        i1.k.e(fragment, "fragment");
        i1.k.e(str, "previousFragmentId");
        this.f159b = str;
    }
}
