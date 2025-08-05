package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* loaded from: classes.dex */
public final class q extends j {

    /* renamed from: g, reason: collision with root package name */
    private static Paint f3347g;

    /* renamed from: f, reason: collision with root package name */
    private TextPaint f3348f;

    public q(p pVar) {
        super(pVar);
    }

    private TextPaint c(CharSequence charSequence, int i2, int i3, Paint paint) {
        if (!(charSequence instanceof Spanned)) {
            if (paint instanceof TextPaint) {
                return (TextPaint) paint;
            }
            return null;
        }
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i2, i3, CharacterStyle.class);
        if (characterStyleArr.length != 0) {
            if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                TextPaint textPaint = this.f3348f;
                if (textPaint == null) {
                    textPaint = new TextPaint();
                    this.f3348f = textPaint;
                }
                textPaint.set(paint);
                for (CharacterStyle characterStyle : characterStyleArr) {
                    characterStyle.updateDrawState(textPaint);
                }
                return textPaint;
            }
        }
        if (paint instanceof TextPaint) {
            return (TextPaint) paint;
        }
        return null;
    }

    private static Paint e() {
        if (f3347g == null) {
            TextPaint textPaint = new TextPaint();
            f3347g = textPaint;
            textPaint.setColor(f.c().d());
            f3347g.setStyle(Paint.Style.FILL);
        }
        return f3347g;
    }

    void d(Canvas canvas, TextPaint textPaint, float f2, float f3, float f4, float f5) {
        int color = textPaint.getColor();
        Paint.Style style = textPaint.getStyle();
        textPaint.setColor(textPaint.bgColor);
        textPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(f2, f4, f3, f5, textPaint);
        textPaint.setStyle(style);
        textPaint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Paint paint2 = paint;
        TextPaint textPaintC = c(charSequence, i2, i3, paint2);
        if (textPaintC != null && textPaintC.bgColor != 0) {
            d(canvas, textPaintC, f2, f2 + b(), i4, i6);
        }
        if (f.c().j()) {
            canvas.drawRect(f2, i4, f2 + b(), i6, e());
        }
        p pVarA = a();
        float f3 = i5;
        if (textPaintC != null) {
            paint2 = textPaintC;
        }
        pVarA.a(canvas, f2, f3, paint2);
    }
}
