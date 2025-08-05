package D;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.f;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class d implements InputFilter {

    /* renamed from: a */
    private final TextView f59a;

    /* renamed from: b */
    private f.AbstractC0039f f60b;

    private static class a extends f.AbstractC0039f {

        /* renamed from: a */
        private final Reference f61a;

        /* renamed from: b */
        private final Reference f62b;

        a(TextView textView, d dVar) {
            this.f61a = new WeakReference(textView);
            this.f62b = new WeakReference(dVar);
        }

        private boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.emoji2.text.f.AbstractC0039f
        public void b() {
            CharSequence text;
            CharSequence charSequenceP;
            super.b();
            TextView textView = (TextView) this.f61a.get();
            if (c(textView, (InputFilter) this.f62b.get()) && textView.isAttachedToWindow() && text != (charSequenceP = androidx.emoji2.text.f.c().p((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceP);
                int selectionEnd = Selection.getSelectionEnd(charSequenceP);
                textView.setText(charSequenceP);
                if (charSequenceP instanceof Spannable) {
                    d.b((Spannable) charSequenceP, selectionStart, selectionEnd);
                }
            }
        }
    }

    d(TextView textView) {
        this.f59a = textView;
    }

    private f.AbstractC0039f a() {
        if (this.f60b == null) {
            this.f60b = new a(this.f59a, this);
        }
        return this.f60b;
    }

    static void b(Spannable spannable, int i2, int i3) {
        if (i2 >= 0 && i3 >= 0) {
            Selection.setSelection(spannable, i2, i3);
        } else if (i2 >= 0) {
            Selection.setSelection(spannable, i2);
        } else if (i3 >= 0) {
            Selection.setSelection(spannable, i3);
        }
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        if (this.f59a.isInEditMode()) {
            return charSequence;
        }
        int iE = androidx.emoji2.text.f.c().e();
        if (iE != 0) {
            if (iE == 1) {
                if ((i5 == 0 && i4 == 0 && spanned.length() == 0 && charSequence == this.f59a.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i2 != 0 || i3 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i2, i3);
                }
                return androidx.emoji2.text.f.c().q(charSequence, 0, charSequence.length());
            }
            if (iE != 3) {
                return charSequence;
            }
        }
        androidx.emoji2.text.f.c().t(a());
        return charSequence;
    }
}
