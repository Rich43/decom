package F;

import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public final class j extends l {

    /* renamed from: b, reason: collision with root package name */
    private final Fragment f177b;

    /* renamed from: c, reason: collision with root package name */
    private final int f178c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Fragment fragment, Fragment fragment2, int i2) {
        super(fragment, "Attempting to set target fragment " + fragment2 + " with request code " + i2 + " for fragment " + fragment);
        i1.k.e(fragment, "fragment");
        i1.k.e(fragment2, "targetFragment");
        this.f177b = fragment2;
        this.f178c = i2;
    }
}
