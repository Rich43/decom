package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import v.AbstractC0345h;

/* loaded from: classes.dex */
final class C {

    /* renamed from: a, reason: collision with root package name */
    private TextView f2138a;

    /* renamed from: b, reason: collision with root package name */
    private TextClassifier f2139b;

    private static final class a {
        static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    C(TextView textView) {
        this.f2138a = (TextView) AbstractC0345h.f(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f2139b;
        return textClassifier == null ? a.a(this.f2138a) : textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f2139b = textClassifier;
    }
}
