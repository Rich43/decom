package D;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;

/* loaded from: classes.dex */
final class c extends InputConnectionWrapper {

    /* renamed from: a */
    private final TextView f57a;

    /* renamed from: b */
    private final a f58b;

    public static class a {
        public boolean a(InputConnection inputConnection, Editable editable, int i2, int i3, boolean z2) {
            return androidx.emoji2.text.f.f(inputConnection, editable, i2, i3, z2);
        }

        public void b(EditorInfo editorInfo) {
            if (androidx.emoji2.text.f.i()) {
                androidx.emoji2.text.f.c().v(editorInfo);
            }
        }
    }

    c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    private Editable a() {
        return this.f57a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i2, int i3) {
        return this.f58b.a(this, a(), i2, i3, false) || super.deleteSurroundingText(i2, i3);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i2, int i3) {
        return this.f58b.a(this, a(), i2, i3, true) || super.deleteSurroundingTextInCodePoints(i2, i3);
    }

    c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, a aVar) {
        super(inputConnection, false);
        this.f57a = textView;
        this.f58b = aVar;
        aVar.b(editorInfo);
    }
}
