package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.emoji2.text.f;

/* loaded from: classes.dex */
class e implements f.e {

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f3265b = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    private final TextPaint f3266a;

    e() {
        TextPaint textPaint = new TextPaint();
        this.f3266a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal threadLocal = f3265b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    @Override // androidx.emoji2.text.f.e
    public boolean a(CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 23 && i4 > i5) {
            return false;
        }
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i2 < i3) {
            sbB.append(charSequence.charAt(i2));
            i2++;
        }
        return androidx.core.graphics.g.a(this.f3266a, sbB.toString());
    }
}
