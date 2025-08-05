package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import v.AbstractC0345h;

/* loaded from: classes.dex */
public abstract class j extends ReplacementSpan {

    /* renamed from: b */
    private final p f3316b;

    /* renamed from: a */
    private final Paint.FontMetricsInt f3315a = new Paint.FontMetricsInt();

    /* renamed from: c */
    private short f3317c = -1;

    /* renamed from: d */
    private short f3318d = -1;
    private float e = 1.0f;

    j(p pVar) {
        AbstractC0345h.g(pVar, "rasterizer cannot be null");
        this.f3316b = pVar;
    }

    public final p a() {
        return this.f3316b;
    }

    final int b() {
        return this.f3317c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f3315a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f3315a;
        this.e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f3316b.e();
        this.f3318d = (short) (this.f3316b.e() * this.e);
        short sI = (short) (this.f3316b.i() * this.e);
        this.f3317c = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f3315a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
