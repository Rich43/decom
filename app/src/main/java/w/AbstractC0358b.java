package w;

import android.view.accessibility.AccessibilityEvent;

/* renamed from: w.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0358b {
    public static int a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public static void b(AccessibilityEvent accessibilityEvent, int i2) {
        accessibilityEvent.setContentChangeTypes(i2);
    }
}
