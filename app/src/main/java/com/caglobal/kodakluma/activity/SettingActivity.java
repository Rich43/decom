package com.caglobal.kodakluma.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.caglobal.kodakluma.R;
import h0.g;
import q0.AbstractC0314c;
import s1.m;

/* loaded from: classes.dex */
public class SettingActivity extends com.caglobal.kodakluma.activity.a {

    /* renamed from: T, reason: collision with root package name */
    private TextView f5369T;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SettingActivity.this.f5369T.setText(AbstractC0314c.a(SettingActivity.this));
        }
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        this.f5369T = (TextView) findViewById(R.id.tv_setting_name);
        findViewById(R.id.iv_setting_back).setOnClickListener(this);
        findViewById(R.id.vg_setting_name).setOnClickListener(this);
        findViewById(R.id.vg_setting_about).setOnClickListener(this);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_setting;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f5369T.setText(AbstractC0314c.a(this));
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
    }

    @m
    public void finishSelf(g gVar) {
        finish();
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_setting_back /* 2131231026 */:
                finish();
                break;
            case R.id.vg_setting_about /* 2131231402 */:
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.vg_setting_name /* 2131231403 */:
                H1(new a());
                break;
        }
    }
}
