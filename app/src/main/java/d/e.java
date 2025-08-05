package D;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;

/* loaded from: classes.dex */
final class e implements KeyListener {

    /* renamed from: a */
    private final KeyListener f63a;

    /* renamed from: b */
    private final a f64b;

    public static class a {
        public boolean a(Editable editable, int i2, KeyEvent keyEvent) {
            return androidx.emoji2.text.f.g(editable, i2, keyEvent);
        }
    }

    e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i2) {
        this.f63a.clearMetaKeyState(view, editable, i2);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f63a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i2, KeyEvent keyEvent) {
        return this.f64b.a(editable, i2, keyEvent) || this.f63a.onKeyDown(view, editable, i2, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f63a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i2, KeyEvent keyEvent) {
        return this.f63a.onKeyUp(view, editable, i2, keyEvent);
    }

    e(KeyListener keyListener, a aVar) {
        this.f63a = keyListener;
        this.f64b = aVar;
    }
}
