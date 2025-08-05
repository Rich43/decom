package w;

import android.view.accessibility.AccessibilityManager;

/* renamed from: w.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0359c {

    /* renamed from: w.c$a */
    public interface a {
        void onTouchExplorationStateChanged(boolean z2);
    }

    /* renamed from: w.c$b */
    private static final class b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final a f7737a;

        b(a aVar) {
            this.f7737a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f7737a.equals(((b) obj).f7737a);
            }
            return false;
        }

        public int hashCode() {
            return this.f7737a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z2) {
            this.f7737a.onTouchExplorationStateChanged(z2);
        }
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        return accessibilityManager.addTouchExplorationStateChangeListener(new b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        return accessibilityManager.removeTouchExplorationStateChangeListener(new b(aVar));
    }
}
