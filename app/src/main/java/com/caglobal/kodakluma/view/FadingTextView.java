package com.caglobal.kodakluma.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import com.caglobal.kodakluma.R;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public final class FadingTextView extends EditText {

    /* renamed from: a, reason: collision with root package name */
    private final AlphaAnimation f5455a;

    /* renamed from: b, reason: collision with root package name */
    private b f5456b;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (FadingTextView.this.f5456b != null) {
                FadingTextView.this.f5456b.b(FadingTextView.this.getText());
            }
            FadingTextView.this.setText("");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public interface b {
        boolean a(int i2, KeyEvent keyEvent);

        boolean b(CharSequence charSequence);
    }

    public FadingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5455a = new AlphaAnimation(1.0f, 0.0f);
        b();
    }

    private void b() {
        this.f5455a.setDuration(getContext().getResources().getInteger(R.integer.fading_text_timeout));
        this.f5455a.setFillAfter(true);
        this.f5455a.setAnimationListener(new a());
        setAnimation(this.f5455a);
    }

    private void c() {
        this.f5455a.reset();
        this.f5455a.start();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        b bVar = this.f5456b;
        if (bVar != null) {
            bVar.a(i2, keyEvent);
        }
        return super.onKeyPreIme(i2, keyEvent);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        c();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setInterceptor(b bVar) {
        this.f5456b = bVar;
    }
}
