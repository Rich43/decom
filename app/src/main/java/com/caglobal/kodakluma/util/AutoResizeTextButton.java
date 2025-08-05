package com.caglobal.kodakluma.util;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.Button;

/* loaded from: classes.dex */
public class AutoResizeTextButton extends Button {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5441a;

    /* renamed from: b, reason: collision with root package name */
    private float f5442b;

    /* renamed from: c, reason: collision with root package name */
    private float f5443c;

    /* renamed from: d, reason: collision with root package name */
    private float f5444d;
    private float e;

    /* renamed from: f, reason: collision with root package name */
    private float f5445f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5446g;

    public interface a {
    }

    public AutoResizeTextButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int a(CharSequence charSequence, TextPaint textPaint, int i2, float f2) {
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(f2);
        return new StaticLayout(charSequence, textPaint2, i2, Layout.Alignment.ALIGN_NORMAL, this.e, this.f5445f, true).getHeight();
    }

    public void b() {
        float f2 = this.f5442b;
        if (f2 > 0.0f) {
            super.setTextSize(0, f2);
            this.f5443c = this.f5442b;
        }
    }

    public void c() {
        d((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingBottom()) - getPaddingTop());
    }

    public void d(int i2, int i3) {
        CharSequence text = getText();
        if (text == null || text.length() == 0 || i3 <= 0 || i2 <= 0 || this.f5442b == 0.0f) {
            return;
        }
        TextPaint paint = getPaint();
        paint.getTextSize();
        float f2 = this.f5443c;
        float fMin = f2 > 0.0f ? Math.min(this.f5442b, f2) : this.f5442b;
        int iA = a(text, paint, i2, fMin);
        float fMax = fMin;
        while (iA > i3) {
            float f3 = this.f5444d;
            if (fMax <= f3) {
                break;
            }
            fMax = Math.max(fMax - 2.0f, f3);
            iA = a(text, paint, i2, fMax);
        }
        if (this.f5446g && fMax == this.f5444d && iA > i3) {
            StaticLayout staticLayout = new StaticLayout(text, new TextPaint(paint), i2, Layout.Alignment.ALIGN_NORMAL, this.e, this.f5445f, false);
            if (staticLayout.getLineCount() > 0) {
                int lineForVertical = staticLayout.getLineForVertical(i3) - 1;
                if (lineForVertical < 0) {
                    setText("");
                } else {
                    int lineStart = staticLayout.getLineStart(lineForVertical);
                    int lineEnd = staticLayout.getLineEnd(lineForVertical);
                    float lineWidth = staticLayout.getLineWidth(lineForVertical);
                    float fMeasureText = paint.measureText("...");
                    while (i2 < lineWidth + fMeasureText) {
                        int i4 = lineEnd - 1;
                        float fMeasureText2 = paint.measureText(text.subSequence(lineStart, lineEnd).toString());
                        lineEnd = i4;
                        lineWidth = fMeasureText2;
                    }
                    setText(((Object) text.subSequence(0, lineEnd)) + "...");
                }
            }
        }
        setTextSize(0, fMax);
        setLineSpacing(this.f5445f, this.e);
        this.f5441a = false;
    }

    public boolean getAddEllipsis() {
        return this.f5446g;
    }

    public float getMaxTextSize() {
        return this.f5443c;
    }

    public float getMinTextSize() {
        return this.f5444d;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (z2 || this.f5441a) {
            d(((i4 - i2) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i5 - i3) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z2, i2, i3, i4, i5);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (i2 == i4 && i3 == i5) {
            return;
        }
        this.f5441a = true;
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f5441a = true;
        b();
    }

    public void setAddEllipsis(boolean z2) {
        this.f5446g = z2;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f2, float f3) {
        super.setLineSpacing(f2, f3);
        this.e = f3;
        this.f5445f = f2;
    }

    public void setMaxTextSize(float f2) {
        this.f5443c = f2;
        requestLayout();
        invalidate();
    }

    public void setMinTextSize(float f2) {
        this.f5444d = f2;
        requestLayout();
        invalidate();
    }

    public void setOnResizeListener(a aVar) {
    }

    @Override // android.widget.TextView
    public void setTextSize(float f2) {
        super.setTextSize(f2);
        this.f5442b = getTextSize();
    }

    public AutoResizeTextButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5441a = false;
        this.f5443c = 0.0f;
        this.f5444d = 10.0f;
        this.e = 1.0f;
        this.f5445f = 0.0f;
        this.f5446g = true;
        this.f5442b = getTextSize();
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        super.setTextSize(i2, f2);
        this.f5442b = getTextSize();
    }
}
