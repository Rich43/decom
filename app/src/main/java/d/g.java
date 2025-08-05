package D;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.f;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class g implements TextWatcher {

    /* renamed from: a */
    private final EditText f70a;

    /* renamed from: b */
    private final boolean f71b;

    /* renamed from: c */
    private f.AbstractC0039f f72c;

    /* renamed from: d */
    private int f73d = Integer.MAX_VALUE;
    private int e = 0;

    /* renamed from: f */
    private boolean f74f = true;

    private static class a extends f.AbstractC0039f {

        /* renamed from: a */
        private final Reference f75a;

        a(EditText editText) {
            this.f75a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.f.AbstractC0039f
        public void b() {
            super.b();
            g.b((EditText) this.f75a.get(), 1);
        }
    }

    g(EditText editText, boolean z2) {
        this.f70a = editText;
        this.f71b = z2;
    }

    private f.AbstractC0039f a() {
        if (this.f72c == null) {
            this.f72c = new a(this.f70a);
        }
        return this.f72c;
    }

    static void b(EditText editText, int i2) {
        if (i2 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.f.c().p(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean d() {
        return (this.f74f && (this.f71b || androidx.emoji2.text.f.i())) ? false : true;
    }

    public void c(boolean z2) {
        if (this.f74f != z2) {
            if (this.f72c != null) {
                androidx.emoji2.text.f.c().u(this.f72c);
            }
            this.f74f = z2;
            if (z2) {
                b(this.f70a, androidx.emoji2.text.f.c().e());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (this.f70a.isInEditMode() || d() || i3 > i4 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iE = androidx.emoji2.text.f.c().e();
        if (iE != 0) {
            if (iE == 1) {
                androidx.emoji2.text.f.c().s((Spannable) charSequence, i2, i2 + i4, this.f73d, this.e);
                return;
            } else if (iE != 3) {
                return;
            }
        }
        androidx.emoji2.text.f.c().t(a());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
