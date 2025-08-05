package com.caglobal.kodakluma.activity;

import W0.c;
import W0.f;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.caglobal.kodakluma.R;

/* loaded from: classes.dex */
public class QRCaptureActivity extends c implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private TextView f5295d;
    private ImageView e;

    private void i(View view) {
        boolean zIsSelected = view.isSelected();
        k(!zIsSelected);
        view.setSelected(!zIsSelected);
    }

    @Override // W0.c, W0.j
    public boolean a(String str) {
        return super.a(str);
    }

    @Override // W0.c
    public int d() {
        return R.layout.activity_qrcapture;
    }

    public boolean j() {
        return getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public void k(boolean z2) {
        Camera cameraA = b().f().a();
        Camera.Parameters parameters = cameraA.getParameters();
        X0.c.j(parameters, z2);
        cameraA.setParameters(parameters);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivFlash /* 2131230955 */:
                i(view);
                break;
            case R.id.ivLeft /* 2131230956 */:
                onBackPressed();
                break;
            case R.id.iv_qrcode_back /* 2131231018 */:
                finish();
                break;
        }
    }

    @Override // W0.c, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5295d = (TextView) findViewById(R.id.ivFlash);
        ImageView imageView = (ImageView) findViewById(R.id.iv_qrcode_back);
        this.e = imageView;
        imageView.setOnClickListener(this);
        if (!j()) {
            this.f5295d.setVisibility(8);
        }
        c().t(false).x(true).j(f.e).w(false).i(false);
    }
}
