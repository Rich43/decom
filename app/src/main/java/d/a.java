package D;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import v.AbstractC0345h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f49a;

    /* renamed from: b, reason: collision with root package name */
    private int f50b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    private int f51c = 0;

    /* renamed from: D.a$a, reason: collision with other inner class name */
    private static class C0004a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final EditText f52a;

        /* renamed from: b, reason: collision with root package name */
        private final g f53b;

        C0004a(EditText editText, boolean z2) {
            this.f52a = editText;
            g gVar = new g(editText, z2);
            this.f53b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(D.b.getInstance());
        }

        @Override // D.a.b
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // D.a.b
        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f52a, inputConnection, editorInfo);
        }

        @Override // D.a.b
        void c(boolean z2) {
            this.f53b.c(z2);
        }
    }

    static class b {
        b() {
        }

        abstract KeyListener a(KeyListener keyListener);

        abstract InputConnection b(InputConnection inputConnection, EditorInfo editorInfo);

        abstract void c(boolean z2);
    }

    public a(EditText editText, boolean z2) {
        AbstractC0345h.g(editText, "editText cannot be null");
        this.f49a = new C0004a(editText, z2);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f49a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f49a.b(inputConnection, editorInfo);
    }

    public void c(boolean z2) {
        this.f49a.c(z2);
    }
}
