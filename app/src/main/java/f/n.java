package F;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public final class n extends m {

    /* renamed from: b, reason: collision with root package name */
    private final ViewGroup f181b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Fragment fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView");
        i1.k.e(fragment, "fragment");
        i1.k.e(viewGroup, "container");
        this.f181b = viewGroup;
    }
}
