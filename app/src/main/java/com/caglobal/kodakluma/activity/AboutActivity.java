package com.caglobal.kodakluma.activity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.caglobal.kodakluma.CustomApplication;
import com.caglobal.kodakluma.R;

/* loaded from: classes.dex */
public class AboutActivity extends a {

    /* renamed from: T, reason: collision with root package name */
    private TextView f4718T;

    /* renamed from: U, reason: collision with root package name */
    private Button f4719U;

    private String L1(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        ((TextView) findViewById(R.id.tvTitle)).setText(R.string.setting_about);
        this.f4718T = (TextView) findViewById(R.id.tv_version);
        Button button = (Button) findViewById(R.id.btn_about_app_update);
        this.f4719U = button;
        button.setOnClickListener(this);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_about;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f4718T.setText(L1(this));
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_about_app_update) {
            CustomApplication.f(R.string.btn_update);
        } else {
            if (id != R.id.ivLeft) {
                return;
            }
            onBackPressed();
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
