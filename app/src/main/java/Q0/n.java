package q0;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public abstract class n {

    class a implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Window f7218a;

        a(Window window) {
            this.f7218a = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            this.f7218a.getDecorView().setSystemUiVisibility(5894);
        }
    }

    public static void a(Window window) {
        window.clearFlags(8);
    }

    public static void b(Window window) {
        window.setFlags(8, 8);
    }

    public static void c(Window window) {
        window.getDecorView().setSystemUiVisibility(2);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new a(window));
    }
}
