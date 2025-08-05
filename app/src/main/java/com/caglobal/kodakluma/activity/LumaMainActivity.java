package com.caglobal.kodakluma.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import androidx.fragment.app.E;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import com.caglobal.kodakluma.R;
import m0.ViewOnClickListenerC0289c;
import m0.ViewOnClickListenerC0292f;
import m0.j;

/* loaded from: classes.dex */
public class LumaMainActivity extends com.caglobal.kodakluma.activity.a implements ViewOnClickListenerC0289c.a {

    /* renamed from: T, reason: collision with root package name */
    private w f4902T;

    /* renamed from: U, reason: collision with root package name */
    private Fragment f4903U;

    /* renamed from: V, reason: collision with root package name */
    private ImageButton f4904V;

    /* renamed from: W, reason: collision with root package name */
    private ViewOnClickListenerC0289c f4905W;

    /* renamed from: X, reason: collision with root package name */
    private ViewOnClickListenerC0292f f4906X;

    /* renamed from: Z, reason: collision with root package name */
    private ImageButton f4908Z;

    /* renamed from: a0, reason: collision with root package name */
    private ImageButton f4909a0;

    /* renamed from: b0, reason: collision with root package name */
    private j f4910b0;

    /* renamed from: Y, reason: collision with root package name */
    private int f4907Y = 0;

    /* renamed from: c0, reason: collision with root package name */
    private Handler f4911c0 = new a();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1) {
                LumaMainActivity lumaMainActivity = LumaMainActivity.this;
                lumaMainActivity.onClick(lumaMainActivity.f4909a0);
            } else {
                if (i2 != 2) {
                    return;
                }
                LumaMainActivity lumaMainActivity2 = LumaMainActivity.this;
                lumaMainActivity2.onClick(lumaMainActivity2.f4904V);
            }
        }
    }

    private void N1() {
        startActivityForResult(new Intent(this, (Class<?>) BindAccountActivity.class), 10);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        ImageButton imageButton = (ImageButton) findViewById(R.id.ibn_main_apps);
        this.f4904V = imageButton;
        imageButton.setOnClickListener(this);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.ibn_main_remote);
        this.f4908Z = imageButton2;
        imageButton2.setOnClickListener(this);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.ibn_main_settings);
        this.f4909a0 = imageButton3;
        imageButton3.setOnClickListener(this);
        N1();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.luma_main;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f4902T = N0();
        ViewOnClickListenerC0289c viewOnClickListenerC0289c = new ViewOnClickListenerC0289c();
        this.f4905W = viewOnClickListenerC0289c;
        if (viewOnClickListenerC0289c.isAdded()) {
            this.f4902T.p().o(this.f4905W).l(this.f4903U).g();
        } else {
            this.f4902T.p().b(R.id.ll_main_center, this.f4905W).o(this.f4905W).g();
        }
        this.f4903U = this.f4905W;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == 0 && i2 == 10) {
            finish();
        } else if (i3 == 5 && i2 == 10) {
            this.f4911c0.sendEmptyMessage(2);
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int i2 = 0;
        switch (view.getId()) {
            case R.id.ibn_main_remote /* 2131230940 */:
                i2 = 2;
                break;
            case R.id.ibn_main_settings /* 2131230941 */:
                i2 = 1;
                break;
        }
        if (this.f4907Y == i2) {
            return;
        }
        this.f4907Y = i2;
        E eP = this.f4902T.p();
        if (i2 == 1) {
            if (this.f4906X == null) {
                this.f4906X = new ViewOnClickListenerC0292f();
            }
            if (this.f4906X.isAdded()) {
                eP.o(this.f4906X).l(this.f4903U).g();
            } else {
                eP.b(R.id.ll_main_center, this.f4906X).o(this.f4906X).l(this.f4903U).g();
            }
            this.f4903U = this.f4906X;
            return;
        }
        if (i2 == 0) {
            if (this.f4905W == null) {
                this.f4905W = new ViewOnClickListenerC0289c();
            }
            if (this.f4905W.isAdded()) {
                eP.o(this.f4905W).l(this.f4903U).g();
            } else {
                eP.b(R.id.ll_main_center, this.f4905W).o(this.f4905W).l(this.f4903U).g();
            }
            this.f4903U = this.f4905W;
            return;
        }
        if (i2 == 2) {
            if (this.f4910b0 == null) {
                this.f4910b0 = new j();
            }
            if (this.f4910b0.isAdded()) {
                eP.o(this.f4910b0).l(this.f4903U).g();
            } else {
                eP.b(R.id.ll_main_center, this.f4910b0).o(this.f4910b0).l(this.f4903U).g();
            }
            this.f4903U = this.f4910b0;
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 34) {
            setRequestedOrientation(5);
        } else {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
    }

    @Override // m0.ViewOnClickListenerC0289c.a
    public void u() {
        this.f4911c0.sendEmptyMessage(1);
    }
}
