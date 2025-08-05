package com.caglobal.kodakluma.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.caglobal.kodakluma.CustomApplication;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.util.AutoResizeTextButton;
import com.caglobal.kodakluma.view.KeysButton;
import com.eshare.api.EShareAPI;
import com.eshare.api.IDevice;
import com.eshare.api.IEvent;
import com.eshare.api.IMedia;
import g0.i;
import h0.h;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import n0.C0296a;
import q0.C0315d;
import s1.m;

/* loaded from: classes.dex */
public class RemoteControlActivity extends com.caglobal.kodakluma.activity.a implements C0296a.d, j0.e, SeekBar.OnSeekBarChangeListener, View.OnLongClickListener {

    /* renamed from: R0, reason: collision with root package name */
    public static RemoteControlActivity f5296R0 = null;

    /* renamed from: S0, reason: collision with root package name */
    public static int f5297S0 = 10;

    /* renamed from: A0, reason: collision with root package name */
    private IMedia f5298A0;

    /* renamed from: B0, reason: collision with root package name */
    private RecyclerView f5299B0;

    /* renamed from: C0, reason: collision with root package name */
    private SharedPreferences f5300C0;

    /* renamed from: D0, reason: collision with root package name */
    private String f5301D0;

    /* renamed from: E0, reason: collision with root package name */
    private String f5302E0;

    /* renamed from: H0, reason: collision with root package name */
    private i f5305H0;

    /* renamed from: I0, reason: collision with root package name */
    private AutoResizeTextButton f5306I0;

    /* renamed from: J0, reason: collision with root package name */
    private AutoResizeTextButton f5307J0;

    /* renamed from: K0, reason: collision with root package name */
    private ImageView f5308K0;

    /* renamed from: L0, reason: collision with root package name */
    private ImageView f5309L0;

    /* renamed from: M0, reason: collision with root package name */
    private ImageView f5310M0;

    /* renamed from: N0, reason: collision with root package name */
    private ImageView f5311N0;

    /* renamed from: O0, reason: collision with root package name */
    private ImageView f5312O0;

    /* renamed from: P0, reason: collision with root package name */
    private ImageView f5313P0;

    /* renamed from: Q0, reason: collision with root package name */
    private ImageView f5314Q0;

    /* renamed from: Y, reason: collision with root package name */
    private ImageButton f5320Y;

    /* renamed from: Z, reason: collision with root package name */
    private IEvent f5321Z;

    /* renamed from: a0, reason: collision with root package name */
    private SeekBar f5322a0;

    /* renamed from: b0, reason: collision with root package name */
    private ExecutorService f5323b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageButton f5324c0;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f5325d0;

    /* renamed from: e0, reason: collision with root package name */
    private ImageButton f5326e0;

    /* renamed from: f0, reason: collision with root package name */
    private ViewGroup f5327f0;

    /* renamed from: g0, reason: collision with root package name */
    private ViewGroup f5328g0;

    /* renamed from: h0, reason: collision with root package name */
    private ViewGroup f5329h0;

    /* renamed from: i0, reason: collision with root package name */
    private ViewGroup f5330i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f5331j0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f5332k0;

    /* renamed from: l0, reason: collision with root package name */
    private TextView f5333l0;

    /* renamed from: m0, reason: collision with root package name */
    private TextView f5334m0;

    /* renamed from: n0, reason: collision with root package name */
    private ImageView f5335n0;

    /* renamed from: o0, reason: collision with root package name */
    private TextView f5336o0;

    /* renamed from: p0, reason: collision with root package name */
    private ImageView f5337p0;

    /* renamed from: r0, reason: collision with root package name */
    private AlertDialog f5339r0;

    /* renamed from: t0, reason: collision with root package name */
    private RecyclerView f5341t0;

    /* renamed from: u0, reason: collision with root package name */
    private ProgressDialog f5342u0;

    /* renamed from: v0, reason: collision with root package name */
    private C0296a f5343v0;

    /* renamed from: w0, reason: collision with root package name */
    private i f5344w0;

    /* renamed from: x0, reason: collision with root package name */
    private IDevice f5345x0;

    /* renamed from: y0, reason: collision with root package name */
    private KeysButton f5346y0;

    /* renamed from: z0, reason: collision with root package name */
    private ImageView f5347z0;

    /* renamed from: T, reason: collision with root package name */
    private final String f5315T = "user_key0";

    /* renamed from: U, reason: collision with root package name */
    private final String f5316U = "user_key1";

    /* renamed from: V, reason: collision with root package name */
    private final String f5317V = "APP_NAME0";

    /* renamed from: W, reason: collision with root package name */
    private final String f5318W = "APP_NAME1";

    /* renamed from: X, reason: collision with root package name */
    private final Handler f5319X = new a();

    /* renamed from: q0, reason: collision with root package name */
    private boolean f5338q0 = false;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f5340s0 = false;

    /* renamed from: F0, reason: collision with root package name */
    private String f5303F0 = "";

    /* renamed from: G0, reason: collision with root package name */
    private String f5304G0 = "";

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            Z0.e.h(RemoteControlActivity.f5296R0, RemoteControlActivity.this.getString(R.string.host_function_disabled), null, RemoteControlActivity.this.getResources().getColor(R.color.c_666666), RemoteControlActivity.this.getResources().getColor(R.color.white), 0, false, true).show();
        }
    }

    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            RemoteControlActivity remoteControlActivity = RemoteControlActivity.this;
            remoteControlActivity.V1(motionEvent, remoteControlActivity.f5335n0.getMeasuredWidth(), RemoteControlActivity.this.f5335n0.getMeasuredHeight());
            return false;
        }
    }

    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            RemoteControlActivity remoteControlActivity = RemoteControlActivity.this;
            remoteControlActivity.W1(motionEvent, remoteControlActivity.f5335n0.getWidth(), RemoteControlActivity.this.f5335n0.getHeight());
            return false;
        }
    }

    class d implements KeysButton.a {
        d() {
        }

        @Override // com.caglobal.kodakluma.view.KeysButton.a
        public void a(int i2) {
            if (i2 == 1) {
                RemoteControlActivity.this.U1(19);
                return;
            }
            if (i2 == 2) {
                RemoteControlActivity.this.U1(20);
                return;
            }
            if (i2 == 3) {
                RemoteControlActivity.this.U1(21);
            } else if (i2 == 4) {
                RemoteControlActivity.this.U1(22);
            } else {
                if (i2 != 5) {
                    return;
                }
                RemoteControlActivity.this.U1(66);
            }
        }

        @Override // com.caglobal.kodakluma.view.KeysButton.a
        public void b(int i2) {
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5352a;

        e(int i2) {
            this.f5352a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            RemoteControlActivity.this.f5321Z.sendKeyEvent(this.f5352a);
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5354a;

        f(int i2) {
            this.f5354a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            RemoteControlActivity.this.f5345x0.startApp(RemoteControlActivity.this.f5344w0.x(this.f5354a).c());
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RemoteControlActivity.this.f5339r0.dismiss();
        }
    }

    public static RemoteControlActivity R1() {
        return f5296R0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1(MotionEvent motionEvent, int i2, int i3) {
        this.f5321Z.sendTouchEvent(motionEvent, i2, i3, 1.0f);
    }

    private void a2() {
        Intent intent = new Intent(this, (Class<?>) AirMouseActivity.class);
        intent.addFlags(67108864);
        startActivityForResult(intent, 1);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        this.f5336o0 = (TextView) findViewById(R.id.tv_control_title);
        this.f5335n0 = (ImageView) findViewById(R.id.iv_mouse_pad);
        ImageButton imageButton = (ImageButton) findViewById(R.id.ib_remote_home);
        this.f5320Y = imageButton;
        imageButton.setOnClickListener(this);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.ib_remote_back);
        this.f5324c0 = imageButton2;
        imageButton2.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.button_keyboard);
        this.f5325d0 = imageView;
        imageView.setOnClickListener(this);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.button_airmouse);
        this.f5326e0 = imageButton3;
        imageButton3.setOnClickListener(this);
        this.f5337p0 = (ImageView) findViewById(R.id.touch_pad);
        this.f5327f0 = (ViewGroup) findViewById(R.id.mouse_id);
        this.f5328g0 = (ViewGroup) findViewById(R.id.touch_id);
        this.f5329h0 = (ViewGroup) findViewById(R.id.keys_id);
        this.f5330i0 = (ViewGroup) findViewById(R.id.apps_id);
        TextView textView = (TextView) findViewById(R.id.shubiao);
        this.f5331j0 = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.chumo);
        this.f5332k0 = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) findViewById(R.id.anjian);
        this.f5333l0 = textView3;
        textView3.setOnClickListener(this);
        TextView textView4 = (TextView) findViewById(R.id.app);
        this.f5334m0 = textView4;
        textView4.setOnClickListener(this);
        this.f5341t0 = (RecyclerView) findViewById(R.id.rv_app);
        this.f5346y0 = (KeysButton) findViewById(R.id.kb_control_keys);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_control_back);
        this.f5347z0 = imageView2;
        imageView2.setOnClickListener(this);
        SeekBar seekBar = (SeekBar) findViewById(R.id.vol_progresss);
        this.f5322a0 = seekBar;
        seekBar.setThumb(null);
        this.f5322a0.setProgress(f5297S0);
        this.f5322a0.setOnSeekBarChangeListener(this);
        T1();
        this.f5327f0.setVisibility(0);
        this.f5336o0.setText(getString(R.string.remote_tv_mouse_control));
        this.f5331j0.setSelected(true);
        ImageView imageView3 = (ImageView) findViewById(R.id.keybutton_up);
        this.f5308K0 = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) findViewById(R.id.keybutton_down);
        this.f5309L0 = imageView4;
        imageView4.setOnClickListener(this);
        ImageView imageView5 = (ImageView) findViewById(R.id.keybutton_right_0);
        this.f5310M0 = imageView5;
        imageView5.setOnClickListener(this);
        ImageView imageView6 = (ImageView) findViewById(R.id.keybutton_right_1);
        this.f5311N0 = imageView6;
        imageView6.setOnClickListener(this);
        ImageView imageView7 = (ImageView) findViewById(R.id.keybutton_left);
        this.f5312O0 = imageView7;
        imageView7.setOnClickListener(this);
        ImageView imageView8 = (ImageView) findViewById(R.id.keybutton_ok);
        this.f5313P0 = imageView8;
        imageView8.setOnClickListener(this);
        ImageView imageView9 = (ImageView) findViewById(R.id.keybutton_right);
        this.f5314Q0 = imageView9;
        imageView9.setOnClickListener(this);
        this.f5306I0 = (AutoResizeTextButton) findViewById(R.id.keybutton_userdefine01);
        this.f5307J0 = (AutoResizeTextButton) findViewById(R.id.keybutton_userdefine02);
        this.f5306I0.setOnClickListener(this);
        this.f5306I0.setOnLongClickListener(this);
        this.f5307J0.setOnClickListener(this);
        this.f5307J0.setOnLongClickListener(this);
        this.f5306I0.setMinTextSize(12.0f);
        this.f5306I0.c();
        this.f5307J0.setMinTextSize(12.0f);
        this.f5307J0.c();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.remote_layout;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f5378D = 2;
        this.f5321Z = EShareAPI.init(this).event();
        this.f5323b0 = Executors.newSingleThreadExecutor();
        this.f5345x0 = EShareAPI.init(this).device();
        this.f5298A0 = EShareAPI.init(this).media();
        C0296a c0296aH = C0296a.h();
        this.f5343v0 = c0296aH;
        c0296aH.l(this);
        this.f5342u0 = C0315d.b(this);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.f5300C0 = defaultSharedPreferences;
        this.f5301D0 = defaultSharedPreferences.getString("user_key0", "");
        this.f5302E0 = this.f5300C0.getString("user_key1", "");
        this.f5303F0 = this.f5300C0.getString("APP_NAME0", "");
        this.f5304G0 = this.f5300C0.getString("APP_NAME1", "");
        if (this.f5303F0.length() < 1) {
            this.f5306I0.setText(getString(R.string.user_define));
        } else {
            this.f5306I0.setText(this.f5303F0);
        }
        if (this.f5304G0.length() < 1) {
            this.f5307J0.setText(getString(R.string.user_define));
        } else {
            this.f5307J0.setText(this.f5304G0);
        }
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
        this.f5335n0.setOnTouchListener(new b());
        this.f5337p0.setOnTouchListener(new c());
        this.f5346y0.setButtonClickListener(new d());
    }

    @Override // n0.C0296a.d
    public void F(boolean z2, List list) {
        this.f5342u0.cancel();
        if (!z2) {
            CustomApplication.f(R.string.program_list_failed);
            return;
        }
        i iVar = new i(this, list, true);
        this.f5344w0 = iVar;
        iVar.A(this);
        this.f5341t0.setLayoutManager(new GridLayoutManager(this, 4));
        this.f5341t0.setAdapter(this.f5344w0);
        i iVar2 = new i(this, list, true);
        this.f5305H0 = iVar2;
        iVar2.A(this);
        RecyclerView recyclerView = this.f5299B0;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
            this.f5299B0.setAdapter(this.f5305H0);
        }
    }

    public void S1() {
        this.f5343v0.i(this);
        this.f5342u0.show();
    }

    void T1() {
        this.f5327f0.setVisibility(8);
        this.f5328g0.setVisibility(8);
        this.f5329h0.setVisibility(8);
        this.f5330i0.setVisibility(8);
        this.f5331j0.setSelected(false);
        this.f5332k0.setSelected(false);
        this.f5333l0.setSelected(false);
        this.f5334m0.setSelected(false);
    }

    public void U1(int i2) {
        this.f5323b0.execute(new e(i2));
    }

    public void V1(MotionEvent motionEvent, int i2, int i3) {
        this.f5321Z.sendMouseEvent(motionEvent, i2, i3, 1.5f);
    }

    public void X1(int i2) {
        this.f5298A0.setVolume(i2);
    }

    public void Y1(Class cls) {
        Intent intent = new Intent(this, (Class<?>) cls);
        intent.addFlags(67108864);
        startActivity(intent);
    }

    void Z1(boolean z2) {
        this.f5338q0 = z2;
        if (this.f5339r0 == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.custom_apps_layout, (ViewGroup) null);
            this.f5299B0 = (RecyclerView) viewInflate.findViewById(R.id.appView);
            Button button = (Button) viewInflate.findViewById(R.id.app_close);
            button.setVisibility(0);
            button.setOnClickListener(new g());
            builder.setView(viewInflate);
            this.f5339r0 = builder.create();
        }
        this.f5339r0.show();
    }

    @m
    public void finishSelf(h0.g gVar) {
        if (gVar.a() != h0.g.f6396c) {
            finish();
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == 10) {
            this.f5322a0.setProgress(f5297S0);
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.chumo) {
            T1();
            this.f5328g0.setVisibility(0);
            this.f5336o0.setText(getString(R.string.remote_tv_touch_control));
            this.f5332k0.setSelected(true);
        }
        if (id == R.id.iv_control_back) {
            finish();
            return;
        }
        if (id == R.id.shubiao) {
            T1();
            this.f5327f0.setVisibility(0);
            this.f5336o0.setText(getString(R.string.remote_tv_mouse_control));
            this.f5331j0.setSelected(true);
            return;
        }
        switch (id) {
            case R.id.anjian /* 2131230791 */:
                T1();
                this.f5329h0.setVisibility(0);
                this.f5336o0.setText(getString(R.string.remote_tv_button_control));
                this.f5333l0.setSelected(true);
                break;
            case R.id.app /* 2131230792 */:
                T1();
                this.f5330i0.setVisibility(0);
                this.f5336o0.setText(getString(R.string.remote_tv_application));
                this.f5334m0.setSelected(true);
                S1();
                break;
            default:
                switch (id) {
                    case R.id.button_airmouse /* 2131230836 */:
                        a2();
                        break;
                    case R.id.button_keyboard /* 2131230837 */:
                        Y1(KeyboardActivity.class);
                        break;
                    default:
                        switch (id) {
                            case R.id.ib_remote_back /* 2131230937 */:
                                U1(4);
                                break;
                            case R.id.ib_remote_home /* 2131230938 */:
                                U1(3);
                                break;
                            default:
                                switch (id) {
                                    case R.id.keybutton_down /* 2131231033 */:
                                        U1(20);
                                        break;
                                    case R.id.keybutton_left /* 2131231034 */:
                                        U1(21);
                                        break;
                                    case R.id.keybutton_ok /* 2131231035 */:
                                        U1(66);
                                        break;
                                    case R.id.keybutton_right /* 2131231036 */:
                                        U1(22);
                                        break;
                                    case R.id.keybutton_right_0 /* 2131231037 */:
                                        U1(92);
                                        break;
                                    case R.id.keybutton_right_1 /* 2131231038 */:
                                        U1(93);
                                        break;
                                    case R.id.keybutton_up /* 2131231039 */:
                                        U1(19);
                                        break;
                                    case R.id.keybutton_userdefine01 /* 2131231040 */:
                                        if (this.f5301D0.length() >= 1) {
                                            this.f5345x0.startApp(this.f5301D0);
                                            break;
                                        } else {
                                            Z1(true);
                                            S1();
                                            break;
                                        }
                                    case R.id.keybutton_userdefine02 /* 2131231041 */:
                                        if (this.f5302E0.length() >= 1) {
                                            this.f5345x0.startApp(this.f5302E0);
                                            break;
                                        } else {
                                            Z1(false);
                                            S1();
                                            break;
                                        }
                                }
                        }
                }
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f5296R0 = this;
        if (Build.VERSION.SDK_INT >= 34) {
            setRequestedOrientation(5);
        } else {
            setRequestedOrientation(1);
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        f5296R0 = null;
        this.f5323b0.shutdown();
    }

    @Override // androidx.appcompat.app.AbstractActivityC0128c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 25 || i2 == 24) {
            this.f5321Z.sendKeyEvent(i2);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.keybutton_userdefine01 /* 2131231040 */:
                Z1(true);
                S1();
                return true;
            case R.id.keybutton_userdefine02 /* 2131231041 */:
                Z1(false);
                S1();
                return true;
            default:
                return true;
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        if (f5297S0 == 0) {
            X1(1);
        }
        int progress = seekBar.getProgress();
        f5297S0 = progress;
        X1(progress);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override // j0.e
    public void p(RecyclerView.g gVar, int i2) {
        String str;
        String str2;
        if (gVar == this.f5344w0) {
            this.f5323b0.execute(new f(i2));
        }
        i iVar = this.f5305H0;
        if (gVar == iVar) {
            String strC = iVar.x(i2).c();
            String strB = this.f5305H0.x(i2).b();
            if (this.f5338q0) {
                this.f5301D0 = strC;
                this.f5306I0.setText(strB);
                str = "user_key0";
                str2 = "APP_NAME0";
            } else {
                this.f5302E0 = strC;
                this.f5307J0.setText(strB);
                str = "user_key1";
                str2 = "APP_NAME1";
            }
            SharedPreferences.Editor editorEdit = this.f5300C0.edit();
            editorEdit.putString(str, strC);
            editorEdit.putString(str2, strB);
            editorEdit.commit();
            this.f5339r0.dismiss();
        }
    }

    @m
    public void updateMirorrAbility(h hVar) {
        if (hVar.c() == 2) {
            this.f5319X.sendEmptyMessage(1);
            finish();
        }
    }
}
