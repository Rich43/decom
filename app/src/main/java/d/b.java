package D;

import android.text.Editable;
import androidx.emoji2.text.o;

/* loaded from: classes.dex */
final class b extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f54a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile Editable.Factory f55b;

    /* renamed from: c, reason: collision with root package name */
    private static Class f56c;

    private b() {
        try {
            f56c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f55b == null) {
            synchronized (f54a) {
                try {
                    if (f55b == null) {
                        f55b = new b();
                    }
                } finally {
                }
            }
        }
        return f55b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f56c;
        return cls != null ? o.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
