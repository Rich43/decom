package F;

import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public abstract class m extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f180a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Fragment fragment, String str) {
        super(str);
        i1.k.e(fragment, "fragment");
        this.f180a = fragment;
    }

    public final Fragment a() {
        return this.f180a;
    }
}
