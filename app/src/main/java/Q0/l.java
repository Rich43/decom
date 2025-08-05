package q0;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;

/* loaded from: classes.dex */
public class l implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    private int f7215a;

    /* renamed from: b, reason: collision with root package name */
    private EditText f7216b;

    public l(int i2, EditText editText) {
        this.f7215a = i2;
        this.f7216b = editText;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Editable text = this.f7216b.getText();
        if (text.length() > this.f7215a) {
            int selectionEnd = Selection.getSelectionEnd(text);
            this.f7216b.setText(text.toString().substring(0, this.f7215a));
            Editable text2 = this.f7216b.getText();
            if (selectionEnd > text2.length()) {
                selectionEnd = text2.length();
            }
            Selection.setSelection(text2, selectionEnd);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
