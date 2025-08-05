package com.caglobal.kodakluma.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.view.FadingTextView;
import com.eshare.api.EShareAPI;
import com.eshare.api.IEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import q0.p;

/* loaded from: classes.dex */
public final class KeyboardActivity extends com.caglobal.kodakluma.activity.a {

    /* renamed from: T, reason: collision with root package name */
    private FadingTextView f4889T;

    /* renamed from: U, reason: collision with root package name */
    private ExecutorService f4890U;

    /* renamed from: V, reason: collision with root package name */
    private IEvent f4891V;

    /* renamed from: W, reason: collision with root package name */
    private ImageView f4892W;

    class a implements p.b {
        a() {
        }

        @Override // q0.p.b
        public void a(int i2) {
            KeyboardActivity.this.finish();
        }

        @Override // q0.p.b
        public void b(int i2) {
        }
    }

    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            KeyboardActivity keyboardActivity = KeyboardActivity.this;
            keyboardActivity.Q1(motionEvent, keyboardActivity.f4892W.getMeasuredWidth(), KeyboardActivity.this.f4892W.getMeasuredHeight());
            return false;
        }
    }

    class c implements FadingTextView.b {
        c() {
        }

        @Override // com.caglobal.kodakluma.view.FadingTextView.b
        public boolean a(int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1 || i2 != 4) {
                return false;
            }
            KeyboardActivity.this.finish();
            return false;
        }

        @Override // com.caglobal.kodakluma.view.FadingTextView.b
        public boolean b(CharSequence charSequence) {
            KeyboardActivity.this.O1(1, 0, charSequence.toString());
            return false;
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4896a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4897b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4898c;

        d(int i2, int i3, String str) {
            this.f4896a = i2;
            this.f4897b = i3;
            this.f4898c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            KeyboardActivity.this.f4891V.sendInputText(this.f4896a, this.f4897b, this.f4898c);
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4900a;

        e(int i2) {
            this.f4900a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            KeyboardActivity.this.f4891V.sendKeyEvent(this.f4900a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1(int i2, int i3, String str) {
        this.f4890U.execute(new d(i2, i3, str));
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        FadingTextView fadingTextView = (FadingTextView) findViewById(R.id.text_feedback_chars);
        this.f4889T = fadingTextView;
        fadingTextView.requestFocus();
        this.f4892W = (ImageView) findViewById(R.id.touchPad);
        p.c(this, new a());
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_keyboard;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f4891V = EShareAPI.init(this).event();
        this.f4890U = Executors.newSingleThreadExecutor();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
        this.f4892W.setOnTouchListener(new b());
        this.f4889T.setInterceptor(new c());
    }

    public void P1(int i2) {
        this.f4890U.execute(new e(i2));
    }

    public void Q1(MotionEvent motionEvent, int i2, int i3) {
        this.f4891V.sendMouseEvent(motionEvent, i2, i3, 1.5f);
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 66) {
            P1(i2);
            finish();
        }
        if (keyEvent.getKeyCode() == 4) {
            finish();
        }
        if (i2 != 67 || this.f4889T.getText().length() > 0) {
            return true;
        }
        P1(i2);
        return true;
    }
}
