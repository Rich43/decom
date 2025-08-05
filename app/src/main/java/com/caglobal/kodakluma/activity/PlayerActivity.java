package com.caglobal.kodakluma.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.caglobal.kodakluma.CustomApplication;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.service.MediaService;
import com.eshare.api.EShareAPI;
import com.eshare.api.IMedia;
import h0.l;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import q0.AbstractC0313b;
import s1.m;

/* loaded from: classes.dex */
public class PlayerActivity extends com.caglobal.kodakluma.activity.a implements j0.b, MediaService.g, MediaService.d {

    /* renamed from: z0, reason: collision with root package name */
    public static Boolean f5188z0 = Boolean.FALSE;

    /* renamed from: T, reason: collision with root package name */
    private TextView f5189T;

    /* renamed from: U, reason: collision with root package name */
    private TextView f5190U;

    /* renamed from: V, reason: collision with root package name */
    private TextView f5191V;

    /* renamed from: W, reason: collision with root package name */
    private TextView f5192W;

    /* renamed from: X, reason: collision with root package name */
    private TextView f5193X;

    /* renamed from: Y, reason: collision with root package name */
    private ImageView f5194Y;

    /* renamed from: Z, reason: collision with root package name */
    private ImageView f5195Z;

    /* renamed from: a0, reason: collision with root package name */
    private ImageView f5196a0;

    /* renamed from: b0, reason: collision with root package name */
    private ImageView f5197b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageView f5198c0;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f5199d0;

    /* renamed from: e0, reason: collision with root package name */
    private ImageView f5200e0;

    /* renamed from: f0, reason: collision with root package name */
    private ImageView f5201f0;

    /* renamed from: g0, reason: collision with root package name */
    private SeekBar f5202g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f5203h0;

    /* renamed from: i0, reason: collision with root package name */
    private File f5204i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f5205j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f5206k0;

    /* renamed from: m0, reason: collision with root package name */
    private long f5208m0;

    /* renamed from: n0, reason: collision with root package name */
    private volatile boolean f5209n0;

    /* renamed from: o0, reason: collision with root package name */
    private volatile boolean f5210o0;

    /* renamed from: s0, reason: collision with root package name */
    private int f5214s0;

    /* renamed from: t0, reason: collision with root package name */
    private IMedia f5215t0;

    /* renamed from: u0, reason: collision with root package name */
    private ExecutorService f5216u0;

    /* renamed from: v0, reason: collision with root package name */
    private MediaService f5217v0;

    /* renamed from: w0, reason: collision with root package name */
    private Vibrator f5218w0;

    /* renamed from: l0, reason: collision with root package name */
    private int f5207l0 = 10;

    /* renamed from: p0, reason: collision with root package name */
    private int f5211p0 = -3;

    /* renamed from: q0, reason: collision with root package name */
    private int f5212q0 = 1;

    /* renamed from: r0, reason: collision with root package name */
    private int f5213r0 = -1;

    /* renamed from: x0, reason: collision with root package name */
    private Boolean f5219x0 = Boolean.FALSE;

    /* renamed from: y0, reason: collision with root package name */
    private ServiceConnection f5220y0 = new a();

    class a implements ServiceConnection {

        /* renamed from: com.caglobal.kodakluma.activity.PlayerActivity$a$a, reason: collision with other inner class name */
        class RunnableC0065a implements Runnable {

            /* renamed from: com.caglobal.kodakluma.activity.PlayerActivity$a$a$a, reason: collision with other inner class name */
            class RunnableC0066a implements Runnable {
                RunnableC0066a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PlayerActivity.this.j2(-1);
                }
            }

            RunnableC0065a() {
            }

            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (!PlayerActivity.this.f5215t0.openMedia(PlayerActivity.this.f5204i0)) {
                    PlayerActivity.this.runOnUiThread(new RunnableC0066a());
                    return;
                }
                PlayerActivity.this.f5217v0.o(PlayerActivity.this.f5204i0, PlayerActivity.this.f5203h0);
                PlayerActivity.this.f5217v0.p(CustomApplication.c("com.eshare.optoma.key.MUSIC_MODE", 0));
                PlayerActivity.this.f5217v0.t();
            }
        }

        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws Throwable {
            PlayerActivity.this.v1("PlayerActivity", "onServiceConnected");
            PlayerActivity.this.f5217v0 = ((MediaService.f) iBinder).a();
            PlayerActivity.this.f5217v0.k(PlayerActivity.this);
            PlayerActivity.this.f5217v0.r(PlayerActivity.this);
            PlayerActivity.this.f5217v0.m(PlayerActivity.this);
            if (!PlayerActivity.this.f5206k0) {
                PlayerActivity.this.f5216u0.execute(new RunnableC0065a());
            } else {
                PlayerActivity.this.f5217v0.o(PlayerActivity.this.f5204i0, PlayerActivity.this.f5203h0);
                PlayerActivity.this.f5217v0.t();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) throws Throwable {
            PlayerActivity.this.v1("PlayerActivity", "onServiceDisconnected");
            PlayerActivity.this.f5217v0 = null;
        }
    }

    class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            PlayerActivity.this.f5215t0.setProgress(seekBar.getProgress());
            PlayerActivity.this.e2();
        }
    }

    class c implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.i2(!r0.g2());
            }
        }

        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!PlayerActivity.this.f5215t0.pauseMedia(!PlayerActivity.this.g2())) {
                CustomApplication.f(R.string.player_control_failed);
            } else {
                PlayerActivity.this.f2();
                PlayerActivity.this.runOnUiThread(new a());
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            if (PlayerActivity.this.f5215t0.stopMedia()) {
                PlayerActivity.this.h2();
            } else {
                CustomApplication.f(R.string.player_control_failed);
            }
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f5228a;

        e(boolean z2) {
            this.f5228a = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5228a) {
                PlayerActivity.this.f5195Z.setSelected(true);
                PlayerActivity.this.f5195Z.setImageResource(R.drawable.ic_play);
            } else {
                PlayerActivity.this.f5195Z.setSelected(false);
                PlayerActivity.this.f5195Z.setImageResource(R.drawable.ic_pause);
            }
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerActivity.this.f5209n0 = false;
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerActivity.this.f5210o0 = false;
        }
    }

    class h implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.f5191V.setText(PlayerActivity.this.f5205j0);
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.j2(-1);
            }
        }

        h() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Log.e("miao", "onNextFile.....");
            if (!PlayerActivity.this.f5215t0.openMedia(PlayerActivity.this.f5204i0)) {
                PlayerActivity.this.runOnUiThread(new b());
            } else {
                PlayerActivity.this.f5217v0.t();
                PlayerActivity.this.runOnUiThread(new a());
            }
        }
    }

    private void d2() {
        int i2 = this.f5214s0 + 1;
        this.f5214s0 = i2;
        if (i2 > 2) {
            this.f5214s0 = 0;
        }
        this.f5217v0.p(this.f5214s0);
        CustomApplication.e("com.eshare.optoma.key.MUSIC_MODE", this.f5214s0);
        m2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2() {
        this.f5210o0 = true;
        this.f5202g0.postDelayed(new g(), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f2() {
        this.f5209n0 = true;
        this.f5195Z.postDelayed(new f(), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g2() {
        return this.f5195Z.isSelected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h2() throws Throwable {
        w1("playOver");
        MediaService mediaService = this.f5217v0;
        if (mediaService != null) {
            mediaService.o(null, this.f5203h0);
            this.f5217v0.u();
        }
        if (isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i2(boolean z2) {
        runOnUiThread(new e(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j2(int i2) {
        if (this.f5207l0 == i2) {
            return;
        }
        this.f5207l0 = i2;
        if (i2 == -1) {
            this.f5190U.setText(R.string.player_error);
            this.f5194Y.setSelected(false);
            return;
        }
        if (i2 == 1) {
            if (this.f5203h0) {
                this.f5190U.setText(R.string.player_video_playing);
            } else {
                this.f5190U.setText(R.string.player_audio_playing);
            }
            this.f5194Y.setSelected(false);
            return;
        }
        if (i2 != 11) {
            return;
        }
        if (this.f5203h0) {
            this.f5190U.setText(R.string.player_video_loading);
        } else {
            this.f5190U.setText(R.string.player_audio_loading);
        }
        this.f5194Y.setSelected(false);
    }

    private void k2() {
        if (this.f5203h0) {
            this.f5190U.setVisibility(0);
            this.f5189T.setText(R.string.player_video);
            this.f5194Y.setImageResource(R.drawable.ic_video_play_ok);
        } else {
            this.f5189T.setText(R.string.player_audio);
            this.f5190U.setVisibility(4);
            this.f5194Y.setImageResource(R.drawable.ic_audio_play);
        }
    }

    private void l2() {
        this.f5216u0.execute(new d());
    }

    private void m2() {
        int i2 = this.f5214s0;
        if (i2 == 0) {
            this.f5198c0.setImageResource(R.drawable.ic_music_loop_selector);
            this.f5199d0.setImageResource(R.drawable.ic_music_list_random_closed_selector);
        } else if (i2 == 1) {
            this.f5198c0.setImageResource(R.drawable.ic_music_single_cycle_selector);
            this.f5199d0.setImageResource(R.drawable.ic_music_list_random_closed_selector);
        } else {
            if (i2 != 2) {
                return;
            }
            this.f5199d0.setImageResource(R.drawable.ic_music_random_selector);
            this.f5198c0.setImageResource(R.drawable.ic_music_loop_closed_selector);
        }
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        this.f5189T = (TextView) findViewById(R.id.tv_player_title);
        this.f5190U = (TextView) findViewById(R.id.tv_player_state);
        this.f5191V = (TextView) findViewById(R.id.tv_player_name);
        this.f5192W = (TextView) findViewById(R.id.tv_player_progress);
        this.f5193X = (TextView) findViewById(R.id.tv_player_duration);
        this.f5194Y = (ImageView) findViewById(R.id.iv_player_state);
        this.f5200e0 = (ImageView) findViewById(R.id.iv_player_volume_up);
        this.f5201f0 = (ImageView) findViewById(R.id.iv_player_volume_down);
        this.f5195Z = (ImageView) findViewById(R.id.iv_player_play);
        this.f5196a0 = (ImageView) findViewById(R.id.iv_player_next);
        this.f5197b0 = (ImageView) findViewById(R.id.iv_player_prev);
        this.f5198c0 = (ImageView) findViewById(R.id.iv_play_loop);
        this.f5199d0 = (ImageView) findViewById(R.id.iv_player_random);
        this.f5202g0 = (SeekBar) findViewById(R.id.sb_player);
        findViewById(R.id.iv_player_back).setOnClickListener(this);
        findViewById(R.id.tv_player_stop).setOnClickListener(this);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_player;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f5378D = 1;
        this.f5211p0 = -3;
        this.f5218w0 = (Vibrator) getSystemService("vibrator");
        this.f5203h0 = getIntent().getBooleanExtra("com.eshare.optoma.extra.MEDIA_IS_VIDEO", true);
        k2();
        this.f5204i0 = new File(getIntent().getStringExtra("com.eshare.optoma.extra.MEDIA_PATH"));
        this.f5205j0 = getIntent().getStringExtra("com.eshare.optoma.extra.MEDIA_TITLE");
        boolean booleanExtra = getIntent().getBooleanExtra("com.eshare.optoma.extra.MEDIA_PLAYING", false);
        this.f5206k0 = booleanExtra;
        j2(booleanExtra ? 1 : 11);
        this.f5214s0 = CustomApplication.c("com.eshare.optoma.key.MUSIC_MODE", 0);
        this.f5216u0 = Executors.newCachedThreadPool();
        this.f5215t0 = EShareAPI.init(this).media();
        bindService(new Intent(this, (Class<?>) MediaService.class), this.f5220y0, 1);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
        this.f5195Z.setOnClickListener(this);
        this.f5197b0.setOnClickListener(this);
        this.f5196a0.setOnClickListener(this);
        if (this.f5203h0) {
            this.f5200e0.setOnClickListener(this);
            this.f5201f0.setOnClickListener(this);
            this.f5198c0.setVisibility(8);
            this.f5199d0.setVisibility(8);
        } else {
            this.f5199d0.setOnClickListener(this);
            this.f5198c0.setOnClickListener(this);
            m2();
            this.f5201f0.setVisibility(8);
            this.f5200e0.setVisibility(8);
        }
        this.f5191V.setText(this.f5205j0);
        this.f5202g0.setOnSeekBarChangeListener(new b());
    }

    @Override // j0.b
    public void e(int i2, int i3) throws Throwable {
        if (this.f5210o0) {
            return;
        }
        this.f5202g0.setMax(i3);
        this.f5193X.setText(AbstractC0313b.b(i3));
        this.f5202g0.setProgress(i2);
        this.f5192W.setText(AbstractC0313b.b(i2));
        if (i2 > 0) {
            this.f5211p0 = i2;
            j2(1);
            return;
        }
        if (this.f5211p0 == i2) {
            return;
        }
        this.f5211p0 = i2;
        if (i2 == -3) {
            if (!this.f5219x0.booleanValue()) {
                this.f5219x0 = Boolean.TRUE;
                return;
            } else {
                this.f5219x0 = Boolean.TRUE;
                h2();
                return;
            }
        }
        if (i2 == -2) {
            this.f5217v0.j(this.f5212q0, this.f5203h0);
            e2();
        } else {
            if (i2 != -1) {
                return;
            }
            h2();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        l2();
        super.finish();
    }

    @m
    public void finishSelf(h0.g gVar) {
        if (gVar.a() != h0.g.f6397d) {
            finish();
        }
    }

    @Override // com.caglobal.kodakluma.service.MediaService.g
    public void l(l lVar) {
        if (lVar != null) {
            this.f5205j0 = lVar.d();
            this.f5204i0 = new File(lVar.c());
            this.f5216u0.execute(new h());
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        int id = view.getId();
        if (id == R.id.tv_player_stop) {
            l2();
        }
        switch (id) {
            case R.id.iv_play_loop /* 2131231009 */:
            case R.id.iv_player_random /* 2131231014 */:
                d2();
                break;
            case R.id.iv_player_back /* 2131231010 */:
                finish();
                break;
            case R.id.iv_player_next /* 2131231011 */:
                this.f5217v0.j(this.f5212q0, this.f5203h0);
                break;
            case R.id.iv_player_play /* 2131231012 */:
                this.f5216u0.execute(new c());
                break;
            case R.id.iv_player_prev /* 2131231013 */:
                this.f5217v0.j(this.f5213r0, this.f5203h0);
                break;
            default:
                switch (id) {
                    case R.id.iv_player_volume_down /* 2131231016 */:
                        this.f5215t0.changeVolume(false);
                        break;
                    case R.id.iv_player_volume_up /* 2131231017 */:
                        this.f5215t0.changeVolume(true);
                        break;
                }
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5208m0 = SystemClock.uptimeMillis();
        Boolean bool = Boolean.FALSE;
        f5188z0 = bool;
        this.f5219x0 = bool;
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() throws Throwable {
        super.onDestroy();
        MediaService mediaService = this.f5217v0;
        if (mediaService != null) {
            mediaService.u();
            this.f5217v0.v(this);
        }
        unbindService(this.f5220y0);
        this.f5216u0.shutdown();
    }

    @Override // androidx.appcompat.app.AbstractActivityC0128c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 24) {
            this.f5215t0.changeVolume(true);
            return true;
        }
        if (i2 != 25) {
            return super.onKeyDown(i2, keyEvent);
        }
        this.f5215t0.changeVolume(false);
        return true;
    }
}
