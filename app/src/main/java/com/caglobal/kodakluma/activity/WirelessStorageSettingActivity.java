package com.caglobal.kodakluma.activity;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import com.caglobal.kodakluma.R;
import com.eshare.api.EShareAPI;
import com.eshare.api.IEShare;
import q0.AbstractC0313b;

/* loaded from: classes.dex */
public class WirelessStorageSettingActivity extends com.caglobal.kodakluma.activity.a {

    /* renamed from: T, reason: collision with root package name */
    private TextView f5371T;

    /* renamed from: U, reason: collision with root package name */
    private TextView f5372U;

    /* renamed from: V, reason: collision with root package name */
    private TextView f5373V;

    /* renamed from: W, reason: collision with root package name */
    private ImageButton f5374W;

    /* renamed from: X, reason: collision with root package name */
    private IEShare f5375X;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WirelessStorageSettingActivity.this.finish();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zIsWirelessStorageEnabled = WirelessStorageSettingActivity.this.f5375X.isWirelessStorageEnabled();
            WirelessStorageSettingActivity.this.f5375X.enableWirelessStorage(!zIsWirelessStorageEnabled);
            if (zIsWirelessStorageEnabled) {
                WirelessStorageSettingActivity.this.O1();
            } else {
                WirelessStorageSettingActivity.this.P1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        this.f5373V.setText(R.string.document_storage_enable);
        this.f5372U.setVisibility(4);
        this.f5371T.setText(R.string.document_storage_disable_content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1() {
        this.f5372U.setVisibility(0);
        this.f5372U.setText("http://" + AbstractC0313b.g(this) + ":" + this.f5375X.getWebServerPort());
        this.f5371T.setText(R.string.document_storage_enable_content);
        this.f5373V.setText(R.string.document_storage_disable);
    }

    private void Q1() {
        if (this.f5375X.isWirelessStorageEnabled()) {
            P1();
        } else {
            O1();
        }
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth() * 0.85d);
        attributes.height = -2;
        window.setAttributes(attributes);
        this.f5371T = (TextView) findViewById(R.id.tv_wireless_storage_content);
        this.f5372U = (TextView) findViewById(R.id.tv_wireless_storage_ip);
        this.f5373V = (TextView) findViewById(R.id.tv_wireless_storage_enable);
        ImageButton imageButton = (ImageButton) findViewById(R.id.ibtn_wireless_storage_close);
        this.f5374W = imageButton;
        imageButton.setOnClickListener(new a());
        this.f5373V.setOnClickListener(new b());
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_wireless_storage_setting;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f5375X = EShareAPI.init(this).server();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
        Q1();
    }
}
