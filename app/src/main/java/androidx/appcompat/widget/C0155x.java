package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import defpackage.e;
import java.lang.reflect.InvocationTargetException;

/* renamed from: androidx.appcompat.widget.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0155x extends SeekBar {

    /* renamed from: a, reason: collision with root package name */
    private final C0156y f2527a;

    public C0155x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.d.f5832E);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f2527a.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f2527a.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2527a.g(canvas);
    }

    public C0155x(Context context, AttributeSet attributeSet, int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, i2);
        Z.a(this, getContext());
        C0156y c0156y = new C0156y(this);
        this.f2527a = c0156y;
        c0156y.c(attributeSet, i2);
    }
}
