package com.caglobal.kodakluma.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.caglobal.kodakluma.R;
import com.eshare.api.EShareAPI;
import com.eshare.api.IMedia;
import com.eshare.api.ISensor;
import h0.g;
import s1.m;

/* loaded from: classes.dex */
public class AirMouseActivity extends com.caglobal.kodakluma.activity.a implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: T */
    private SeekBar f4720T;

    /* renamed from: U */
    private ImageButton f4721U;

    /* renamed from: V */
    private ImageButton f4722V;

    /* renamed from: W */
    private ImageButton f4723W;

    /* renamed from: X */
    private ImageButton f4724X;

    /* renamed from: Y */
    private ISensor f4725Y;

    /* renamed from: Z */
    private ImageView f4726Z;

    /* renamed from: a0 */
    private ImageView f4727a0;

    /* renamed from: b0 */
    private float f4728b0 = 0.85f;

    /* renamed from: c0 */
    private TextView f4729c0;

    /* renamed from: d0 */
    private IMedia f4730d0;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            AirMouseActivity.this.f4728b0 = (i2 * 1.0f) / 100.0f;
            AirMouseActivity.this.f4729c0.setText(String.format("%s%.2f", AirMouseActivity.this.getString(R.string.remote_airmouse_sensitivity), Float.valueOf(AirMouseActivity.this.f4728b0)));
            AirMouseActivity.this.f4725Y.setSensitivity(AirMouseActivity.this.f4728b0);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    private void P1() {
        this.f4725Y.initCursorPosition();
    }

    private void Q1(boolean z2) {
        if (z2) {
            this.f4725Y.registerListener();
        } else {
            this.f4725Y.unregisterListener();
        }
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        this.f4729c0 = (TextView) findViewById(R.id.tiptext);
        ImageButton imageButton = (ImageButton) findViewById(R.id.calibrate);
        this.f4721U = imageButton;
        imageButton.setOnClickListener(this);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.airmouse_home);
        this.f4722V = imageButton2;
        imageButton2.setOnClickListener(this);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.airmouse_back);
        this.f4723W = imageButton3;
        imageButton3.setOnClickListener(this);
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.airmouse_keyboard);
        this.f4724X = imageButton4;
        imageButton4.setOnClickListener(this);
        this.f4726Z = (ImageView) findViewById(R.id.full_touchPad_mouse);
        ImageView imageView = (ImageView) findViewById(R.id.iv_air_back);
        this.f4727a0 = imageView;
        imageView.setOnClickListener(this);
        SeekBar seekBar = (SeekBar) findViewById(R.id.vol_progresss);
        seekBar.setThumb(null);
        seekBar.setProgress(RemoteControlActivity.f5297S0);
        seekBar.setOnSeekBarChangeListener(this);
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekfactor);
        this.f4720T = seekBar2;
        seekBar2.setOnSeekBarChangeListener(new a());
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_air_mouse;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f4725Y = EShareAPI.init(this).sensor();
        this.f4730d0 = EShareAPI.init(this).media();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
        this.f4726Z.setOnTouchListener(this.f4725Y);
        this.f4726Z.setOnClickListener(this);
        this.f4728b0 = this.f4725Y.getSensitivity();
        this.f4729c0.setText(String.format("%s%.2f", getString(R.string.remote_airmouse_sensitivity), Float.valueOf(this.f4728b0)));
        this.f4720T.setProgress((int) (this.f4728b0 * 100.0f));
        this.f4720T.setThumb(null);
    }

    @m
    public void finishSelf(g gVar) {
        if (gVar.a() != g.f6396c) {
            finish();
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.calibrate) {
            P1();
        }
        if (id == R.id.iv_air_back) {
            setResult(10, new Intent());
            finish();
            return;
        }
        switch (id) {
            case R.id.airmouse_back /* 2131230785 */:
                RemoteControlActivity.R1().U1(4);
                break;
            case R.id.airmouse_home /* 2131230786 */:
                RemoteControlActivity.R1().U1(3);
                break;
            case R.id.airmouse_keyboard /* 2131230787 */:
                RemoteControlActivity.R1().Y1(KeyboardActivity.class);
                break;
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onPause() {
        super.onPause();
        Q1(false);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        RemoteControlActivity.f5297S0 = seekBar.getProgress();
        this.f4730d0.setVolume(seekBar.getProgress());
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onResume() {
        super.onResume();
        Q1(true);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        RemoteControlActivity.R1().X1(seekBar.getProgress());
    }
}
