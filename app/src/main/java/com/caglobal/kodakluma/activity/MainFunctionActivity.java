package com.caglobal.kodakluma.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import b.b;
import b.c;
import c.C0225b;
import com.caglobal.kodakluma.R;
import com.eshare.api.EShareAPI;
import com.eshare.api.IDevice;
import com.eshare.api.IScreen;
import com.eshare.api.utils.CompatibleUtil;
import java.util.Map;
import q0.o;

/* loaded from: classes.dex */
public class MainFunctionActivity extends com.caglobal.kodakluma.activity.a {

    /* renamed from: c0, reason: collision with root package name */
    private static boolean f5065c0 = false;

    /* renamed from: T, reason: collision with root package name */
    private TextView f5066T;

    /* renamed from: U, reason: collision with root package name */
    private TextView f5067U;

    /* renamed from: V, reason: collision with root package name */
    private IDevice f5068V;

    /* renamed from: W, reason: collision with root package name */
    private TextView f5069W;

    /* renamed from: X, reason: collision with root package name */
    private IScreen f5070X;

    /* renamed from: Y, reason: collision with root package name */
    private final int f5071Y = 100;

    /* renamed from: Z, reason: collision with root package name */
    private Handler f5072Z = new a();

    /* renamed from: a0, reason: collision with root package name */
    private final String[] f5073a0 = {"android.permission.POST_NOTIFICATIONS"};

    /* renamed from: b0, reason: collision with root package name */
    private c f5074b0 = G0(new C0225b(), new b() { // from class: f0.c
        @Override // b.b
        public final void a(Object obj) {
            this.f6190a.N1((Map) obj);
        }
    });

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1 && Build.VERSION.SDK_INT >= 23) {
                o.a(MainFunctionActivity.this);
            }
        }
    }

    private void M1() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N1(Map map) {
        if (map.containsValue(Boolean.FALSE)) {
            Log.d("miao", "notification permission not allowed..");
        }
        IScreen iScreen = this.f5070X;
        if (iScreen != null) {
            iScreen.startScreenMirror(this, true);
        }
    }

    private void O1() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = (int) (defaultDisplay.getHeight() * 0.7d);
        attributes.width = (int) (defaultDisplay.getWidth() * 0.8d);
        getWindow().setAttributes(attributes);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        TextView textView = (TextView) findViewById(R.id.tv_function_cancel);
        this.f5066T = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.tv_function_mirror);
        this.f5067U = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) findViewById(R.id.tv_function_screen);
        this.f5069W = textView3;
        textView3.setOnClickListener(this);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_main_function;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f5068V = EShareAPI.init(this).device();
        this.f5070X = EShareAPI.init(this).screen();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
    }

    public void P1() {
        if (!CompatibleUtil.isAndroidT()) {
            o.a(this);
            this.f5070X.startScreenMirror(this, true);
        } else if (androidx.core.content.a.a(this, "android.permission.POST_NOTIFICATIONS") == 0) {
            this.f5070X.startScreenMirror(this, true);
        } else {
            this.f5074b0.a(this.f5073a0);
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100 && i3 == -1) {
            M1();
            f5065c0 = true;
        }
        if (i2 == 2000 && Settings.canDrawOverlays(this)) {
            P1();
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.tv_function_cancel /* 2131231320 */:
                finish();
                break;
            case R.id.tv_function_mirror /* 2131231321 */:
                Intent intent = new Intent(getApplicationContext(), (Class<?>) MirrorNoteActivity.class);
                if (this.f5068V.getCurrentDevice() != null) {
                    intent.putExtra("com.ecloud.eshare.lib.extra.IP_ADDRESS", this.f5068V.getCurrentDevice().getIpAddress());
                }
                startActivity(intent);
                overridePendingTransition(R.anim.eshare_zoom_enter, R.anim.eshare_zoom_exit);
                finish();
                break;
            case R.id.tv_function_screen /* 2131231322 */:
                P1();
                break;
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O1();
        if (Build.VERSION.SDK_INT >= 34) {
            setRequestedOrientation(5);
        } else {
            setRequestedOrientation(1);
        }
        setFinishOnTouchOutside(true);
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f5072Z.sendEmptyMessageDelayed(1, 500L);
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onStart() {
        this.f5070X.stopScreenMirror(getApplicationContext());
        super.onStart();
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onStop() {
        super.onStop();
    }
}
