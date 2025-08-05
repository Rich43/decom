package com.caglobal.kodakluma.activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.StrictMode;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.caglobal.kodakluma.CustomApplication;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.service.MediaService;
import com.caglobal.kodakluma.view.CircleBar;
import com.eshare.api.EShareAPI;
import com.eshare.api.IDevice;
import com.eshare.api.IEvent;
import com.eshare.api.IMedia;
import com.eshare.api.IScreen;
import com.eshare.api.bean.Device;
import com.eshare.api.callback.ConnectDeviceCallback;
import com.eshare.api.callback.FindDeviceCallback;
import com.eshare.api.utils.LogHelper;
import g0.c;
import g0.f;
import h0.C0263d;
import i0.AbstractViewOnClickListenerC0270a;
import j0.InterfaceC0272a;
import j0.b;
import j0.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import l0.AbstractC0283g;
import l0.C0281e;
import l0.C0282f;
import l0.InterfaceC0280d;
import m0.C0288b;
import m0.ViewOnClickListenerC0289c;
import m0.ViewOnClickListenerC0290d;
import m0.ViewOnClickListenerC0291e;
import m0.ViewOnClickListenerC0292f;
import m0.g;
import m0.h;
import m0.i;
import m0.j;
import m0.l;
import m0.m;
import m0.n;
import o0.C0301b;
import o0.C0303d;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import q0.AbstractC0313b;
import q0.AbstractC0314c;
import q0.AbstractC0320i;
import q0.k;
import q0.o;

/* loaded from: classes.dex */
public class MainActivity extends a implements b, C0301b.a, e, ViewOnClickListenerC0289c.a, j.h, ViewOnClickListenerC0290d.e, ViewOnClickListenerC0292f.a, C0288b.InterfaceC0091b, ViewOnClickListenerC0291e.b, i.d, h.c, n.a, m.b, l.b {
    public static boolean J1;
    private static MainActivity K1;
    public static Boolean L1 = Boolean.FALSE;

    /* renamed from: A0 */
    private ViewGroup f4913A0;
    private ViewOnClickListenerC0291e A1;

    /* renamed from: B0 */
    private CircleBar f4914B0;
    private h B1;

    /* renamed from: C0 */
    private ImageButton f4915C0;
    private n C1;

    /* renamed from: D0 */
    private TextView f4916D0;
    private i D1;

    /* renamed from: E0 */
    private TextView f4917E0;
    private g E1;

    /* renamed from: F0 */
    private ViewGroup f4918F0;
    private l F1;

    /* renamed from: G0 */
    private ViewGroup f4919G0;
    private m G1;

    /* renamed from: H0 */
    private TextView f4920H0;
    private TextView H1;

    /* renamed from: I0 */
    private RelativeLayout f4921I0;
    private TextView I1;

    /* renamed from: J0 */
    private Button f4922J0;

    /* renamed from: K0 */
    private View f4923K0;

    /* renamed from: L0 */
    private ViewGroup f4924L0;

    /* renamed from: M0 */
    private RecyclerView f4925M0;

    /* renamed from: N0 */
    private f f4926N0;

    /* renamed from: O0 */
    private C0303d f4927O0;

    /* renamed from: P0 */
    private C0301b f4928P0;

    /* renamed from: Q0 */
    private int f4929Q0;

    /* renamed from: R0 */
    private Toast f4930R0;

    /* renamed from: S0 */
    private Vibrator f4931S0;

    /* renamed from: T */
    public c f4932T;

    /* renamed from: U */
    public List f4934U;

    /* renamed from: V0 */
    private boolean f4937V0;

    /* renamed from: W */
    private InterfaceC0272a f4938W;

    /* renamed from: W0 */
    private ExecutorService f4939W0;

    /* renamed from: X */
    private boolean f4940X;

    /* renamed from: X0 */
    private IDevice f4941X0;

    /* renamed from: Y */
    private IEvent f4942Y;

    /* renamed from: Y0 */
    private IScreen f4943Y0;

    /* renamed from: Z */
    private ViewGroup f4944Z;

    /* renamed from: Z0 */
    private IMedia f4945Z0;

    /* renamed from: a0 */
    private ViewGroup f4946a0;

    /* renamed from: a1 */
    private MediaService f4947a1;

    /* renamed from: b0 */
    private TextView f4948b0;

    /* renamed from: b1 */
    private C0281e f4949b1;

    /* renamed from: c0 */
    private ImageButton f4950c0;

    /* renamed from: c1 */
    private EShareAPI f4951c1;

    /* renamed from: d0 */
    private boolean f4952d0;

    /* renamed from: d1 */
    AlertDialog f4953d1;

    /* renamed from: e0 */
    private boolean f4954e0;

    /* renamed from: f0 */
    private AppCompatEditText f4956f0;

    /* renamed from: f1 */
    private C0288b f4957f1;

    /* renamed from: g0 */
    private String f4958g0;

    /* renamed from: g1 */
    private ViewOnClickListenerC0290d f4959g1;

    /* renamed from: h0 */
    private RelativeLayout f4960h0;

    /* renamed from: h1 */
    private androidx.fragment.app.w f4961h1;

    /* renamed from: i0 */
    private LottieAnimationView f4962i0;

    /* renamed from: i1 */
    private Fragment f4963i1;

    /* renamed from: j0 */
    private TextView f4964j0;

    /* renamed from: j1 */
    private ImageButton f4965j1;

    /* renamed from: k0 */
    private TextView f4966k0;

    /* renamed from: k1 */
    private ViewOnClickListenerC0289c f4967k1;

    /* renamed from: l0 */
    private ImageView f4968l0;

    /* renamed from: l1 */
    private ViewOnClickListenerC0292f f4969l1;

    /* renamed from: m0 */
    private ImageButton f4970m0;

    /* renamed from: n0 */
    private boolean f4972n0;

    /* renamed from: n1 */
    private ImageButton f4973n1;

    /* renamed from: o1 */
    private ImageButton f4975o1;

    /* renamed from: p0 */
    private AlertDialog f4976p0;

    /* renamed from: p1 */
    private j f4977p1;

    /* renamed from: q0 */
    private C0263d f4978q0;

    /* renamed from: r0 */
    private String f4980r0;

    /* renamed from: r1 */
    private TextView f4981r1;

    /* renamed from: s0 */
    private ImageButton f4982s0;

    /* renamed from: s1 */
    private TextView f4983s1;

    /* renamed from: t0 */
    private boolean f4984t0;

    /* renamed from: t1 */
    private TextView f4985t1;

    /* renamed from: u0 */
    private int f4986u0;

    /* renamed from: u1 */
    private TextView f4987u1;

    /* renamed from: v0 */
    private ViewGroup f4988v0;
    private TextView v1;

    /* renamed from: w0 */
    private ViewGroup f4989w0;
    private TextView w1;

    /* renamed from: x0 */
    private RecyclerView f4990x0;
    private TextView x1;

    /* renamed from: y0 */
    private SwipeRefreshLayout f4991y0;

    /* renamed from: z0 */
    private TextView f4992z0;
    private ImageView z1;

    /* renamed from: V */
    private int f4936V = -1;

    /* renamed from: o0 */
    private List f4974o0 = new ArrayList();

    /* renamed from: T0 */
    private int f4933T0 = 5;

    /* renamed from: U0 */
    private int f4935U0 = 0;

    /* renamed from: e1 */
    private ServiceConnection f4955e1 = new ServiceConnectionC0238k();

    /* renamed from: m1 */
    private int f4971m1 = 2;

    /* renamed from: q1 */
    private View.OnClickListener f4979q1 = new t();
    private final Handler y1 = new C();

    class A implements View.OnClickListener {
        A() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog = MainActivity.this.f4953d1;
            if (alertDialog != null) {
                alertDialog.dismiss();
                MainActivity.this.f4953d1 = null;
            }
        }
    }

    class B implements View.OnClickListener {
        B() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            AlertDialog alertDialog = MainActivity.this.f4953d1;
            if (alertDialog != null) {
                alertDialog.dismiss();
                MainActivity.this.F3();
            }
        }
    }

    class C extends Handler {

        /* renamed from: a */
        private SharedPreferences.Editor f4995a;

        /* renamed from: b */
        private SharedPreferences f4996b;

        C() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            int i2 = message.what;
            if (i2 == 9) {
                Z0.e.h(MainActivity.this.getApplicationContext(), MainActivity.this.getString(R.string.host_function_disabled), null, MainActivity.this.getResources().getColor(R.color.c_666666), MainActivity.this.getResources().getColor(R.color.white), 0, false, true).show();
                return;
            }
            if (i2 == 10) {
                k.c("DISCONNECT_DEVICES...  ");
                MainActivity.this.U2();
                MainActivity.this.S3();
                MainActivity.this.W3();
                if (MirrorNoteActivity.m2() != null) {
                    MirrorNoteActivity.m2().finish();
                }
                MainActivity.this.z1.setImageResource(2131165742);
                MainActivity.this.F3();
                return;
            }
            if (i2 == 999) {
                MainActivity.N1(MainActivity.this);
                throw null;
            }
            if (i2 == 60000) {
                MainActivity.this.Q3();
                return;
            }
            switch (i2) {
                case 1:
                    Log.d("SHY", "MSG_CONNECT_SUCCESS.");
                    MainActivity.this.f4933T0 = 4;
                    MainActivity.this.W3();
                    MainActivity.this.J3();
                    s1.c.c().l(new q0.m(Boolean.FALSE));
                    MainActivity.this.Z3();
                    MainActivity.this.b3();
                    MainActivity.this.Q3();
                    if (!MainActivity.this.f4940X) {
                        CustomApplication.f(R.string.tv_devices_connect);
                    }
                    MainActivity.this.f4940X = false;
                    int iB = q0.q.b(MainActivity.this, "rate_number", 0);
                    if (iB == 2) {
                        MainActivity.this.A3();
                    }
                    q0.q.e(MainActivity.this, "rate_number", iB + 1);
                    Device device = (Device) message.obj;
                    if (device != null) {
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                        this.f4996b = defaultSharedPreferences;
                        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
                        this.f4995a = editorEdit;
                        editorEdit.putString("device_ip", device.getIpAddress()).apply();
                        this.f4995a.putString("device_name", device.getName()).apply();
                        this.f4995a.putInt("device_port", device.getPort()).apply();
                        this.f4995a.putInt("device_speaker_port", device.getSpeakerPort()).apply();
                        this.f4995a.putBoolean("device_config", true).apply();
                        this.f4995a.putInt("device_network_id", MainActivity.this.Z2()).apply();
                        return;
                    }
                    return;
                case 2:
                    k.c("connect fail    MSG_CONNECT_FAILED");
                    if (this.f4996b == null) {
                        SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                        this.f4996b = defaultSharedPreferences2;
                        this.f4995a = defaultSharedPreferences2.edit();
                    }
                    this.f4995a.putBoolean("device_config", false).apply();
                    s1.c.c().l(new q0.m(Boolean.FALSE));
                    MainActivity.this.t3();
                    MainActivity.this.f4933T0 = 3;
                    MainActivity.this.W3();
                    return;
                case 3:
                    MainActivity.this.v3();
                    return;
                case 4:
                    CustomApplication.f(R.string.input_empty);
                    MainActivity.this.v3();
                    return;
                case 5:
                    MainActivity.this.B3();
                    return;
                case 6:
                    if (MainActivity.this.f4948b0 != null) {
                        MainActivity.this.f4948b0.performClick();
                        return;
                    }
                    return;
                case 7:
                    if (MainActivity.this.f4976p0 != null && MainActivity.this.f4976p0.isShowing()) {
                        MainActivity.this.f4976p0.dismiss();
                    }
                    if (MainActivity.this.f4936V == 3) {
                        MainActivity.this.f4941X0.acceptCastInvitation(2);
                    }
                    MainActivity.this.f4936V = -1;
                    return;
                default:
                    switch (i2) {
                        case 99:
                            MainActivity.this.F3();
                            return;
                        case 100:
                            MainActivity.this.C3();
                            return;
                        case 101:
                            if (MainActivity.this.f4941X0.isDeviceConnect()) {
                                return;
                            }
                            MainActivity.this.s3();
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    class D implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Dialog f4998a;

        D(Dialog dialog) {
            this.f4998a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f4998a != null) {
                MainActivity.this.V2("com.caglobal.kodakluma", "com.android.vending");
                this.f4998a.dismiss();
            }
        }
    }

    class E implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Dialog f5000a;

        E(Dialog dialog) {
            this.f5000a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Dialog dialog = this.f5000a;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    class F implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ AlertDialog f5002a;

        F(AlertDialog alertDialog) {
            this.f5002a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            MainActivity.this.U2();
            this.f5002a.dismiss();
        }
    }

    class G implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f5004a;

        /* renamed from: b */
        final /* synthetic */ AlertDialog f5005b;

        G(int i2, AlertDialog alertDialog) {
            this.f5004a = i2;
            this.f5005b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            switch (this.f5004a) {
                case 101:
                    this.f5005b.dismiss();
                    break;
                case 102:
                    this.f5005b.dismiss();
                    break;
                case 103:
                    MainActivity.this.U2();
                    this.f5005b.dismiss();
                    break;
            }
        }
    }

    class H implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f5007a;

        /* renamed from: b */
        final /* synthetic */ AlertDialog f5008b;

        H(int i2, AlertDialog alertDialog) {
            this.f5007a = i2;
            this.f5008b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            switch (this.f5007a) {
                case 101:
                    MainActivity.this.n3(26);
                    MainActivity.this.U2();
                    this.f5008b.dismiss();
                    break;
                case 102:
                    MainActivity.this.U2();
                    this.f5008b.dismiss();
                    MainActivity.this.C3();
                    q0.q.d(MainActivity.this.getApplicationContext(), "LogSuccess", false);
                    MainActivity.this.N2();
                    break;
                case 103:
                    this.f5008b.dismiss();
                    break;
            }
        }
    }

    class I implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f5010a;

        I(int i2) {
            this.f5010a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.f4942Y.sendKeyEvent(this.f5010a);
        }
    }

    class J implements View.OnClickListener {
        J() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            MainActivity.this.F3();
        }
    }

    class K implements Animator.AnimatorListener {
        K() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            MainActivity.this.f4962i0.setVisibility(8);
            int unused = MainActivity.this.f4933T0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class L extends AbstractC0283g {
        L() {
        }

        @Override // l0.AbstractC0283g
        public void a(int i2) {
            if (MainActivity.this.f4941X0 != null) {
                MainActivity.this.f4941X0.disClientWithServer(((C0263d) MainActivity.this.f4974o0.get(i2)).a());
            }
            MainActivity.this.f4926N0.f6295c.remove(i2);
            MainActivity.this.f4926N0.i(i2);
            MainActivity.this.f4926N0.h(i2, MainActivity.this.f4926N0.c());
        }

        @Override // l0.AbstractC0283g
        public void b(int i2) {
            if (MainActivity.this.f4941X0 != null) {
                MainActivity.this.f4941X0.disClientWithServer(((C0263d) MainActivity.this.f4974o0.get(i2)).a());
            }
            MainActivity.this.f4926N0.f6295c.remove(i2);
            MainActivity.this.f4926N0.i(i2);
            MainActivity.this.f4926N0.h(i2, MainActivity.this.f4926N0.c());
        }
    }

    class M implements View.OnClickListener {

        /* renamed from: a */
        int f5015a = 0;

        M() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            Log.d("LXP", "click logo:" + this.f5015a);
            int i2 = this.f5015a + 1;
            this.f5015a = i2;
            if (i2 >= 4) {
                if (o.c(MainActivity.this, 1009)) {
                    k.c("request storage....");
                }
                this.f5015a = 0;
            }
        }
    }

    class N implements View.OnClickListener {

        /* renamed from: a */
        int f5017a = 0;

        N() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Log.d("LXP", "click logo:" + this.f5017a);
            int i2 = this.f5017a + 1;
            this.f5017a = i2;
            if (i2 >= 4) {
                this.f5017a = 0;
            }
        }
    }

    class O implements C0303d.a {
        O() {
        }

        @Override // o0.C0303d.a
        public void a() throws Throwable {
            k.c("onNetworkChanged...  ");
            MainActivity.this.Y3();
            if (MainActivity.this.f4959g1 == null || !MainActivity.this.f4959g1.isVisible()) {
                return;
            }
            MainActivity.this.X2();
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$a */
    class RunnableC0228a implements Runnable {
        RunnableC0228a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            String strC = q0.q.c(MainActivity.this, "email", "");
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            MainActivity.this.a3(strC);
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$b */
    class C0229b implements SwipeRefreshLayout.j {
        C0229b() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
        public void a() {
            MainActivity.this.f4941X0.stopFindDevice();
            MainActivity.this.X2();
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$c */
    class C0230c implements InterfaceC0280d {
        C0230c() {
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() {
            if (o.c(MainActivity.this, 1004)) {
                MainActivity.this.h3();
            }
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$d */
    class C0231d implements InterfaceC0280d {
        C0231d() {
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() {
            MainActivity.this.f4952d0 = false;
            if (o.b(MainActivity.this)) {
                MainActivity.this.g3();
            }
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$e */
    class C0232e implements InterfaceC0280d {
        C0232e() {
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() {
            MainActivity.this.startActivity(new Intent(MainActivity.this, (Class<?>) RemoteControlActivity.class));
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$f */
    class C0233f implements InterfaceC0280d {
        C0233f() {
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() {
            Intent intent = new Intent(MainActivity.this, (Class<?>) MirrorNoteActivity.class);
            intent.putExtra("com.ecloud.eshare.lib.extra.IP_ADDRESS", MainActivity.this.f4941X0.getCurrentDevice().getIpAddress());
            MainActivity.this.startActivity(intent);
            MainActivity.this.overridePendingTransition(R.anim.eshare_zoom_enter, R.anim.eshare_zoom_exit);
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$g */
    class C0234g implements InterfaceC0280d {

        /* renamed from: a */
        final /* synthetic */ a f5026a;

        C0234g(a aVar) {
            this.f5026a = aVar;
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() {
            MainActivity.this.f4935U0 = 0;
            if (AbstractC0313b.k(this.f5026a, "com.eshare.mirror.MirrorScreenCaptureService")) {
                MainActivity.this.f4943Y0.continueScreenMirror(this.f5026a);
            } else {
                MainActivity.this.f4943Y0.startScreenMirror(this.f5026a, true);
            }
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$h */
    class DialogInterfaceOnClickListenerC0235h implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ String f5028a;

        DialogInterfaceOnClickListenerC0235h(String str) {
            this.f5028a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(this.f5028a));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            MainActivity.this.startActivity(intent);
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$i */
    class DialogInterfaceOnClickListenerC0236i implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC0236i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$j */
    class C0237j implements FindDeviceCallback {
        C0237j() {
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$k */
    class ServiceConnectionC0238k implements ServiceConnection {
        ServiceConnectionC0238k() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws Throwable {
            MainActivity.this.v1("MainActivity", "onServiceConnected");
            MainActivity.this.f4947a1 = ((MediaService.f) iBinder).a();
            MainActivity.this.f4947a1.k(MainActivity.this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) throws Throwable {
            MainActivity.this.v1("MainActivity", "onServiceDisconnected");
            MainActivity.this.f4947a1 = null;
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$l */
    class C0239l implements ValueAnimator.AnimatorUpdateListener {
        C0239l() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$m */
    class C0240m implements ValueAnimator.AnimatorUpdateListener {
        C0240m() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$n */
    class RunnableC0241n implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f5035a;

        /* renamed from: b */
        final /* synthetic */ boolean f5036b;

        /* renamed from: com.caglobal.kodakluma.activity.MainActivity$n$a */
        class a implements ConnectDeviceCallback {
            a() {
            }
        }

        RunnableC0241n(String str, boolean z2) {
            this.f5035a = str;
            this.f5036b = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.f4941X0.connectDevice(this.f5035a, AbstractC0314c.a(MainActivity.this), new a());
        }
    }

    /* renamed from: com.caglobal.kodakluma.activity.MainActivity$o */
    class RunnableC0242o implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Device f5039a;

        /* renamed from: com.caglobal.kodakluma.activity.MainActivity$o$a */
        class a implements ConnectDeviceCallback {
            a() {
            }
        }

        RunnableC0242o(Device device) {
            this.f5039a = device;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.f4941X0.connectDevice(this.f5039a, AbstractC0314c.a(MainActivity.this), new a());
        }
    }

    class p implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ EditText f5042a;

        p(EditText editText) {
            this.f5042a = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) throws Throwable {
            String strTrim = this.f5042a.getText().toString().trim();
            if (TextUtils.isEmpty(strTrim)) {
                MainActivity.this.y1.sendEmptyMessage(4);
            } else {
                MainActivity.this.L2(strTrim);
            }
        }
    }

    class q implements DialogInterface.OnClickListener {
        q() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) throws Throwable {
            s1.c.c().l(new q0.m(Boolean.FALSE));
            MainActivity.this.U2();
        }
    }

    class r implements TextView.OnEditorActionListener {

        /* renamed from: a */
        final /* synthetic */ AlertDialog f5045a;

        r(AlertDialog alertDialog) {
            this.f5045a = alertDialog;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return false;
            }
            this.f5045a.getButton(-1).performClick();
            return true;
        }
    }

    class s implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f5047a;

        s(String str) {
            this.f5047a = str;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            boolean zAuthPassword = MainActivity.this.f4941X0.authPassword(this.f5047a);
            MainActivity.this.v1("authPassword", Boolean.valueOf(zAuthPassword));
            if (zAuthPassword) {
                MainActivity.this.y1.sendEmptyMessage(1);
            } else {
                MainActivity.this.y1.sendEmptyMessage(2);
            }
        }
    }

    class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (!MainActivity.this.f4941X0.isDeviceConnect()) {
                CustomApplication.f(R.string.device_not_connected);
            }
            int iJ = ((RecyclerView.C) view.getTag()).j();
            MainActivity mainActivity = MainActivity.this;
            mainActivity.f4978q0 = (C0263d) mainActivity.f4974o0.get(iJ);
            switch (view.getId()) {
                case R.id.iv_item_peer_device_allow /* 2131230976 */:
                    MainActivity.this.f4941X0.allowCast(true, MainActivity.this.f4978q0.a());
                    break;
                case R.id.iv_item_peer_device_cast /* 2131230977 */:
                    if (MainActivity.this.f4978q0.f() != 1) {
                        if (!TextUtils.equals(AbstractC0313b.g(MainActivity.this), MainActivity.this.f4978q0.a())) {
                            MainActivity.this.r3(2, "");
                            break;
                        } else {
                            MainActivity mainActivity2 = MainActivity.this;
                            mainActivity2.onClick(mainActivity2.f4921I0);
                            break;
                        }
                    } else if (TextUtils.equals(AbstractC0313b.g(MainActivity.this), MainActivity.this.f4978q0.a())) {
                        MainActivity.this.V3();
                        break;
                    }
                    break;
                case R.id.iv_item_peer_device_deny /* 2131230978 */:
                    MainActivity.this.f4941X0.allowCast(false, MainActivity.this.f4978q0.a());
                    break;
                case R.id.iv_item_peer_device_fullscreen /* 2131230980 */:
                    int iC = MainActivity.this.f4978q0.c();
                    if (iC != -1) {
                        if (iC != 0) {
                            MainActivity mainActivity3 = MainActivity.this;
                            mainActivity3.r3(5, mainActivity3.f4978q0.b());
                            break;
                        } else {
                            MainActivity mainActivity4 = MainActivity.this;
                            mainActivity4.r3(4, mainActivity4.f4978q0.b());
                            break;
                        }
                    }
                    break;
                case R.id.iv_item_peer_device_host /* 2131230981 */:
                    if (MainActivity.this.f4978q0.d() != 1) {
                        MainActivity mainActivity5 = MainActivity.this;
                        mainActivity5.r3(0, ((C0263d) mainActivity5.f4974o0.get(iJ)).b());
                        break;
                    }
                    break;
            }
        }
    }

    class u implements C0281e.a {

        class a implements ConnectDeviceCallback {
            a() {
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.r3(1, "");
            }
        }

        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.f4926N0.g();
            }
        }

        class e implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f5055a;

            e(int i2) {
                this.f5055a = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.X3(this.f5055a);
            }
        }

        u() {
        }

        @Override // l0.C0281e.a
        public void a() throws Throwable {
            k.c("onDeviceOffline...  ");
            if (MainActivity.this.f4941X0.isDeviceConnect()) {
                MainActivity.this.f4941X0.connectDevice(AbstractC0314c.a(MainActivity.this), new a());
            }
        }

        @Override // l0.C0281e.a
        public void b() {
            MainActivity.this.runOnUiThread(new c());
        }

        @Override // l0.C0281e.a
        public void c() {
        }

        @Override // l0.C0281e.a
        public void d(int i2) {
            MainActivity.this.f4986u0 = i2;
            MainActivity.this.f4982s0.post(new e(i2));
        }

        @Override // l0.C0281e.a
        public void e(String str) {
            MainActivity.this.runOnUiThread(new b());
        }

        @Override // l0.C0281e.a
        public void f(boolean z2) {
            MainActivity.this.f4972n0 = z2;
            MainActivity.this.M2(z2);
        }

        @Override // l0.C0281e.a
        public void g(List list) throws Throwable {
            if (!MainActivity.this.f4972n0) {
                MainActivity.this.f4972n0 = true;
                MainActivity mainActivity = MainActivity.this;
                mainActivity.M2(mainActivity.f4972n0);
            }
            MainActivity.this.f4974o0.clear();
            MainActivity.this.f4974o0.addAll(list);
            k.a("peerClientData size=" + MainActivity.this.f4974o0.size());
            if (MainActivity.this.f4926N0 == null) {
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.f4926N0 = new f(mainActivity2.f4974o0, MainActivity.this.f4979q1);
                MainActivity.this.f4925M0.setAdapter(MainActivity.this.f4926N0);
            }
            MainActivity.this.runOnUiThread(new d());
        }
    }

    class v implements InterfaceC0280d {
        v() {
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() {
        }
    }

    class w implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f5058a;

        w(boolean z2) {
            this.f5058a = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.f4970m0.setEnabled(this.f5058a);
            if (this.f5058a) {
                MainActivity mainActivity = MainActivity.this;
                Z0.e.h(mainActivity, mainActivity.getString(R.string.host_has_became), null, MainActivity.this.getResources().getColor(R.color.colorAccent), MainActivity.this.getResources().getColor(R.color.white), 0, false, true).show();
            }
        }
    }

    class x implements Runnable {
        x() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            MainActivity.this.W3();
        }
    }

    class y implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f5061a;

        y(int i2) {
            this.f5061a = i2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            MainActivity.this.T2(this.f5061a);
        }
    }

    class z implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f5063a;

        z(int i2) {
            this.f5063a = i2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            MainActivity.this.S2(this.f5063a);
        }
    }

    public void B3() {
        this.f4991y0.setVisibility(4);
        this.f4964j0.setText(R.string.main_connect_error);
        this.f4964j0.setVisibility(0);
        this.f4968l0.setVisibility(0);
        this.f4966k0.setVisibility(0);
    }

    public void C3() {
        Z3();
        this.f4965j1.setSelected(true);
        if (this.f4971m1 == 12) {
            return;
        }
        this.f4971m1 = 12;
        androidx.fragment.app.E eP = this.f4961h1.p();
        if (this.f4967k1 == null) {
            this.f4967k1 = new ViewOnClickListenerC0289c();
        }
        if (this.f4967k1.isAdded()) {
            eP.o(this.f4967k1).l(this.f4963i1).g();
        } else {
            eP.b(R.id.ll_main_center, this.f4967k1).o(this.f4967k1).l(this.f4963i1).g();
        }
        this.f4963i1 = this.f4967k1;
    }

    private void D3() {
        if (this.f4971m1 == 38) {
            return;
        }
        this.f4971m1 = 38;
        androidx.fragment.app.E eP = this.f4961h1.p();
        Z3();
        this.f4975o1.setSelected(true);
        this.F1 = null;
        this.F1 = new l();
        if (this.F1.isAdded()) {
            eP.o(this.F1).l(this.f4963i1).g();
        } else {
            eP.b(R.id.ll_main_center, this.F1).o(this.F1).l(this.f4963i1).g();
        }
        this.f4963i1 = this.F1;
    }

    private void E3() {
        if (this.f4971m1 == 39) {
            return;
        }
        this.f4971m1 = 39;
        androidx.fragment.app.E eP = this.f4961h1.p();
        Z3();
        this.f4975o1.setSelected(true);
        this.G1 = null;
        this.G1 = new m();
        if (this.G1.isAdded()) {
            eP.o(this.G1).l(this.f4963i1).g();
        } else {
            eP.b(R.id.ll_main_center, this.G1).o(this.G1).l(this.f4963i1).g();
        }
        this.f4963i1 = this.G1;
    }

    private void G3() {
        if (this.f4971m1 == 36) {
            return;
        }
        this.f4971m1 = 36;
        androidx.fragment.app.E eP = this.f4961h1.p();
        Z3();
        this.f4975o1.setSelected(true);
        this.B1 = null;
        this.B1 = new h();
        if (this.B1.isAdded()) {
            eP.o(this.B1).l(this.f4963i1).g();
        } else {
            eP.b(R.id.ll_main_center, this.B1).o(this.B1).l(this.f4963i1).g();
        }
        this.f4963i1 = this.B1;
    }

    private void H3() {
        if (this.f4971m1 == 37) {
            return;
        }
        this.f4971m1 = 37;
        androidx.fragment.app.E eP = this.f4961h1.p();
        Z3();
        this.f4975o1.setSelected(true);
        this.C1 = null;
        this.C1 = new n();
        if (this.C1.isAdded()) {
            eP.o(this.C1).l(this.f4963i1).g();
        } else {
            eP.b(R.id.ll_main_center, this.C1).o(this.C1).l(this.f4963i1).g();
        }
        this.f4963i1 = this.C1;
    }

    public synchronized void J3() {
        k.c("startHostHeartBeatCheck...  ");
        U3();
        C0281e c0281e = new C0281e(this.f4941X0, new u());
        this.f4949b1 = c0281e;
        c0281e.d();
    }

    public void L2(String str) throws Throwable {
        v1("authPassword", str);
        if (c3()) {
            this.f4939W0.execute(new s(str));
        }
    }

    private void L3() throws Throwable {
        if (this.f4941X0.isDeviceConnect()) {
            startActivity(new Intent(this, (Class<?>) MainFunctionActivity.class));
        } else {
            F3();
        }
    }

    public void M2(boolean z2) {
        this.f4970m0.post(new w(z2));
        if (this.f4933T0 != 6 || z2) {
            return;
        }
        this.f4933T0 = 4;
        runOnUiThread(new x());
    }

    static /* bridge */ /* synthetic */ AbstractViewOnClickListenerC0270a N1(MainActivity mainActivity) {
        mainActivity.getClass();
        return null;
    }

    public void N2() {
        startActivityForResult(new Intent(this, (Class<?>) BindAccountActivity.class), 10);
    }

    private void O2() {
        startActivityForResult(new Intent(this, (Class<?>) AnimActivity.class), 1002);
    }

    private void O3() throws Throwable {
        if (TextUtils.isEmpty(this.f4956f0.getText().toString())) {
            Z0.e.i(this, R.string.input_empty).show();
            return;
        }
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f4956f0.getWindowToken(), 0);
        this.f4954e0 = true;
        Map mapH = AbstractC0313b.h(this, this.f4956f0.getText().toString());
        String str = (String) mapH.get("key_decode_ip");
        if (TextUtils.isEmpty(str)) {
            this.y1.sendEmptyMessage(2);
            return;
        }
        boolean zBooleanValue = ((Boolean) mapH.get("key_decode_is_pin")).booleanValue();
        if (zBooleanValue) {
            this.f4958g0 = this.f4956f0.getText().toString();
        }
        Q2(str, zBooleanValue);
    }

    private void P2(Device device) throws Throwable {
        v1("connectDevice", device);
        u3();
        s1.c.c().l(new q0.m(Boolean.TRUE));
        if (c3()) {
            this.f4939W0.execute(new RunnableC0242o(device));
        }
    }

    private void Q2(String str, boolean z2) throws Throwable {
        k.c("connectDevice", str);
        u3();
        if (c3()) {
            this.f4939W0.execute(new RunnableC0241n(str, z2));
        }
    }

    private void R3() {
        Intent intent = new Intent();
        intent.putExtra("QR_TITLE", getString(R.string.qr_code_title));
        intent.setClass(getApplicationContext(), QRCaptureActivity.class);
        startActivityForResult(intent, 1);
    }

    public void S2(int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                this.f4941X0.acceptHost(false);
                return;
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    this.f4941X0.acceptCastInvitation(0);
                    return;
                } else if (i2 != 4 && i2 != 5) {
                    if (i2 != 7) {
                        return;
                    }
                    this.f4941X0.allowCast(false, this.f4980r0);
                    return;
                }
            }
        }
        this.f4976p0.dismiss();
        this.f4976p0 = null;
    }

    public void S3() throws Throwable {
        k.c("stopFindDevice...  ");
        IDevice iDevice = this.f4941X0;
        if (iDevice != null) {
            iDevice.stopFindDevice();
        }
    }

    public void T2(int i2) {
        if (i2 == 0) {
            this.f4941X0.assignHost(this.f4978q0.a());
            return;
        }
        if (i2 == 1) {
            this.f4941X0.acceptHost(true);
            return;
        }
        if (i2 == 2) {
            this.f4941X0.assignCast(this.f4978q0.a());
            return;
        }
        if (i2 == 3) {
            this.f4941X0.acceptCastInvitation(1);
            M3(false, this);
        } else if (i2 == 4) {
            this.f4941X0.assignFullCast(true, this.f4978q0.a());
        } else if (i2 == 5) {
            this.f4941X0.assignFullCast(false, this.f4978q0.a());
        } else {
            if (i2 != 7) {
                return;
            }
            this.f4941X0.allowCast(true, this.f4980r0);
        }
    }

    private synchronized void T3() {
    }

    public void U2() throws Throwable {
        k.c("disconnectDevice...  ");
        this.z1.setImageResource(2131165742);
        this.f4970m0.setEnabled(false);
        this.f4933T0 = 5;
        if (!isFinishing()) {
            W3();
        }
        this.f4923K0 = null;
        this.f4943Y0.stopScreenMirror(this);
        this.f4945Z0.stopMedia();
        this.f4914B0.setVisibility(4);
        MediaService mediaService = this.f4947a1;
        if (mediaService != null) {
            mediaService.o(null, true);
        }
        T3();
        U3();
        this.f4941X0.disconnectDevice(AbstractC0314c.a(this));
    }

    private synchronized void U3() {
        C0281e c0281e = this.f4949b1;
        if (c0281e != null) {
            c0281e.e();
            this.f4949b1 = null;
        }
    }

    public void V3() {
        this.f4935U0 = 2;
        this.f4943Y0.stopScreenMirror(this);
    }

    private void W2() throws Throwable {
        if (this.f4930R0.getView().getParent() == null) {
            this.f4930R0.show();
        } else {
            S3();
            finish();
        }
    }

    public void W3() throws Throwable {
        if (!d3()) {
            this.f4933T0 = 0;
        }
        k.c("mConnectState：" + this.f4933T0);
        J1 = false;
        l3();
        switch (this.f4933T0) {
            case 0:
                k.c("onNetworkChanged  STATE_NO_NETWORK...  ");
                this.f4989w0.setVisibility(0);
                x3();
                this.f4992z0.setText(R.string.app_name);
                break;
            case 1:
                k.c("onNetworkChanged  STATE_CONNECT...  ");
                this.f4920H0.setVisibility(0);
                this.f4992z0.setText(R.string.app_name);
                this.f4950c0.setVisibility(0);
                break;
            case 2:
                k.c("onNetworkChanged  STATE_CONNECTING...  ");
                this.f4946a0.setVisibility(0);
                this.f4992z0.setText(R.string.app_name);
                break;
            case 3:
                k.c("onNetworkChanged  STATE_CONNECT_ERROR...  ");
                if (!this.f4937V0) {
                    this.f4989w0.setVisibility(0);
                    this.f4992z0.setText(R.string.main_devices_title);
                    this.f4950c0.setVisibility(8);
                    break;
                } else {
                    this.f4992z0.setText(R.string.app_name);
                    this.f4950c0.setVisibility(0);
                    break;
                }
            case 4:
                k.c("onNetworkChanged  STATE_CONNECTED...  ");
                S3();
                this.f4913A0.setVisibility(0);
                if (!this.f4941X0.isProDevice() || !this.f4970m0.isEnabled()) {
                    w3(false, true);
                }
                if (this.f4941X0.getCurrentDevice() != null) {
                    Device currentDevice = this.f4941X0.getCurrentDevice();
                    if (!TextUtils.isEmpty(currentDevice.getName())) {
                        this.f4916D0.setText(currentDevice.getName());
                    }
                    this.f4917E0.setText(currentDevice.getIpAddress());
                }
                this.f4992z0.setText(R.string.app_name);
                break;
            case 5:
                k.c("onNetworkChanged  STATE_DEVICES...  ");
                break;
            case 6:
                k.c("onNetworkChanged  STATE_HOST...  ");
                J1 = true;
                this.f4913A0.setVisibility(0);
                this.f4924L0.setVisibility(0);
                w3(false, true);
                this.f4992z0.setText(R.string.app_name);
                break;
        }
    }

    public void X3(int i2) {
        if (i2 == 0) {
            this.f4982s0.setVisibility(4);
        } else if (i2 == 1) {
            if (this.f5380F == 1) {
                this.f4982s0.setVisibility(4);
            } else {
                this.f4982s0.setVisibility(0);
                this.f4982s0.setSelected(false);
            }
        } else if (i2 == 2) {
            this.f4982s0.setVisibility(0);
            this.f4982s0.setSelected(true);
        }
        this.f4984t0 = i2 == 2;
    }

    public static MainActivity Y2() {
        return K1;
    }

    public int Z2() {
        return ((WifiManager) getApplicationContext().getSystemService("wifi")).getConnectionInfo().getNetworkId();
    }

    public void a3(String str) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", q0.q.c(this, "fullname", ""));
            jSONObject.put("password", " ");
            jSONObject.put("email", str);
            jSONObject.put("dob", "1 jan 2019");
            jSONObject.put("login_with", "social");
            jSONObject.put("app_version_number", "1.0");
            jSONObject.put("platform", "platform");
            String strA = AbstractC0320i.a(jSONObject.toString(), "http://polaroidapps.testurapp.com/dev/kodak-api/Projector/register");
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            String string = new JSONObject(strA).getString("message");
            if (string != null && string.equals("Data insert successfully.")) {
                q0.q.d(this, "isRegistered", true);
            } else if (string != null && string.equals("You are already registered.")) {
                q0.q.d(this, "isRegistered", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean c3() {
        ExecutorService executorService = this.f4939W0;
        return (executorService == null || executorService.isShutdown()) ? false : true;
    }

    private void f3(View view) {
        if (this.f4921I0.isSelected()) {
            this.f4923K0 = view;
        }
        int id = view.getId();
        if (id == R.id.rl_main_camera) {
            I1(6, new C0231d());
            return;
        }
        if (id == R.id.rl_main_control) {
            I1(4, new C0232e());
            return;
        }
        switch (id) {
            case R.id.rl_main_document /* 2131231157 */:
                I1(0, new C0230c());
                break;
            case R.id.rl_main_media /* 2131231158 */:
                if (o.c(this, 1002)) {
                    i3();
                    break;
                }
                break;
            case R.id.rl_main_mirror /* 2131231159 */:
                if (!this.f4941X0.isDeviceConnect()) {
                    CustomApplication.f(R.string.device_not_connected);
                    break;
                } else {
                    I1(9, new C0233f());
                    break;
                }
            case R.id.rl_main_photo /* 2131231160 */:
                if (o.c(this, 1003)) {
                    j3();
                    break;
                }
                break;
        }
    }

    public void g3() {
        if (!this.f4941X0.isDeviceConnect()) {
            CustomApplication.f(R.string.device_not_connected);
        } else {
            CustomApplication.d("key_camera_request", false);
            startActivity(new Intent(this, (Class<?>) CameraActivity.class));
        }
    }

    public void h3() {
        startActivity(new Intent(this, (Class<?>) DocumentActivity.class));
    }

    private void i3() {
        startActivity(new Intent(this, (Class<?>) MediaActivity.class));
    }

    private void j3() {
        startActivity(new Intent(this, (Class<?>) PhotoActivity.class));
    }

    private void k3() {
        if (!this.f4941X0.isDeviceConnect()) {
            CustomApplication.f(R.string.device_not_connected);
        } else if (this.f4984t0) {
            this.f4941X0.exitFullScreen();
        } else {
            I1(8, new v());
        }
    }

    private void l3() {
        this.f4960h0.setVisibility(4);
        this.f4944Z.setVisibility(8);
        this.f4946a0.setVisibility(8);
        this.f4989w0.setVisibility(8);
        this.f4913A0.setVisibility(8);
        this.f4924L0.setVisibility(8);
        this.f4970m0.setVisibility(8);
        this.f4982s0.setVisibility(8);
        this.f4964j0.setVisibility(8);
        this.f4966k0.setVisibility(8);
        this.f4970m0.setEnabled(false);
        this.f4950c0.setVisibility(8);
        if (this.f4962i0.k()) {
            this.f4962i0.e();
        }
        this.f4968l0.setVisibility(4);
    }

    private void m3(String str) throws Throwable {
        Map mapO = AbstractC0313b.o(str);
        int iIntValue = ((Integer) mapO.get("key_qr_type")).intValue();
        if (iIntValue == 0) {
            z3(str);
            return;
        }
        if (iIntValue == 1) {
            Q2((String) mapO.get("key_qr_ip"), false);
            return;
        }
        if (iIntValue == 2) {
            this.f4958g0 = (String) mapO.get("key_qr_pin");
            Q2((String) mapO.get("key_qr_ip"), !TextUtils.isEmpty(this.f4958g0));
        } else {
            if (iIntValue != 3) {
                z3(str);
                return;
            }
            String str2 = (String) mapO.get("key_qr_ip");
            this.f4958g0 = (String) mapO.get("key_qr_pin");
            Q2(str2, !TextUtils.isEmpty(r0));
        }
    }

    private void o3(boolean z2) {
        this.f4921I0.setSelected(z2);
        if (!z2) {
            this.f4918F0.setVisibility(8);
            this.f4919G0.setVisibility(0);
        } else {
            this.f4935U0 = 1;
            this.f4919G0.setVisibility(8);
            this.f4918F0.setVisibility(0);
        }
    }

    private void q3(Dialog dialog) {
        Window window = dialog.getWindow();
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(48);
        attributes.width = (int) (defaultDisplay.getWidth() * 0.85d);
        attributes.x = 0;
        attributes.y = 250;
        window.setAttributes(attributes);
    }

    public void r3(int i2, String str) {
        String string;
        String string2;
        AlertDialog alertDialog = this.f4976p0;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f4976p0.dismiss();
        }
        this.y1.removeMessages(7);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String string3 = "";
        switch (i2) {
            case 0:
                string3 = getString(R.string.host_assign_ok_btn);
                string = String.format(getString(R.string.host_assign_content), str);
                String str2 = string3;
                string3 = string;
                string2 = str2;
                break;
            case 1:
                string3 = getString(R.string.host_cast_request_ok_btn);
                string = getString(R.string.host_be_admin);
                String str22 = string3;
                string3 = string;
                string2 = str22;
                break;
            case 2:
                string = String.format(getString(R.string.host_assign_cast_content), str);
                String str222 = string3;
                string3 = string;
                string2 = str222;
                break;
            case 3:
                string = String.format(getString(R.string.host_invite_cast), str);
                String str2222 = string3;
                string3 = string;
                string2 = str2222;
                break;
            case 4:
                string = String.format(getString(R.string.host_assign_fullscreen_content), str);
                String str22222 = string3;
                string3 = string;
                string2 = str22222;
                break;
            case 5:
                string = String.format(getString(R.string.host_recall_fullscreen_content), str);
                String str222222 = string3;
                string3 = string;
                string2 = str222222;
                break;
            case 6:
                string = String.format(getString(R.string.host_invite_fullscreen_content), str);
                String str2222222 = string3;
                string3 = string;
                string2 = str2222222;
                break;
            case 7:
                string3 = getString(R.string.host_cast_request_ok_btn);
                string = String.format(getString(R.string.host_cast_request_content), str);
                String str22222222 = string3;
                string3 = string;
                string2 = str22222222;
                break;
            default:
                string2 = "";
                break;
        }
        builder.setMessage(string3);
        if (TextUtils.isEmpty(string2)) {
            string2 = getString(android.R.string.yes);
        }
        builder.setPositiveButton(string2, new y(i2));
        builder.setNegativeButton(android.R.string.cancel, new z(i2));
        AlertDialog alertDialogCreate = builder.create();
        this.f4976p0 = alertDialogCreate;
        alertDialogCreate.show();
        this.f4936V = i2;
        if (i2 == 1 || i2 == 3) {
            this.y1.sendEmptyMessageDelayed(7, 10000L);
        }
    }

    private void u3() {
        this.f4960h0.setVisibility(0);
    }

    public void v3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.main_input_pwd);
        View viewInflate = View.inflate(this, R.layout.dialog_input, null);
        builder.setView(viewInflate);
        builder.setCancelable(false);
        EditText editText = (EditText) viewInflate.findViewById(R.id.et_dialog_input);
        builder.setPositiveButton(android.R.string.ok, new p(editText));
        builder.setNegativeButton(android.R.string.cancel, new q());
        AlertDialog alertDialogCreate = builder.create();
        editText.setOnEditorActionListener(new r(alertDialogCreate));
        alertDialogCreate.getWindow().setSoftInputMode(4);
        alertDialogCreate.show();
    }

    private void w3(boolean z2, boolean z3) {
        if (z2) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f4929Q0, 0);
            valueAnimatorOfInt.addUpdateListener(new C0239l());
            valueAnimatorOfInt.setDuration(300L).start();
        } else {
            ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(0, this.f4929Q0);
            valueAnimatorOfInt2.addUpdateListener(new C0240m());
            valueAnimatorOfInt2.setDuration(300L).start();
            if (z3) {
                w3(true, false);
            }
        }
    }

    private void x3() {
        this.f4991y0.setVisibility(4);
        this.f4962i0.setVisibility(0);
        this.f4962i0.m();
        this.f4964j0.setVisibility(0);
        this.f4964j0.setText(R.string.main_no_network_tip);
        this.f4964j0.setTextColor(-65536);
        this.f4968l0.setVisibility(8);
    }

    private void z3(String str) {
        String str2;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (str.startsWith("http://") || str.startsWith("https://")) {
            String str3 = String.format("%s%s", getString(R.string.qr_open_website), str);
            builder.setNegativeButton(android.R.string.cancel, new DialogInterfaceOnClickListenerC0236i()).setPositiveButton(android.R.string.yes, new DialogInterfaceOnClickListenerC0235h(str));
            str2 = str3;
        } else {
            str2 = String.format("%s%s", getString(R.string.qr_show_scan_ret), str);
        }
        builder.setTitle(R.string.qr_dialog_titile).setMessage(str2).setCancelable(true);
        builder.create().show();
    }

    protected void A3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View viewInflate = View.inflate(this, R.layout.dialog_rate, null);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.getContext().setTheme(R.style.dialogstyle);
        alertDialogCreate.show();
        q3(alertDialogCreate);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_rate);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_not_rate);
        textView.setOnClickListener(new D(alertDialogCreate));
        textView2.setOnClickListener(new E(alertDialogCreate));
    }

    @Override // m0.ViewOnClickListenerC0290d.e
    public void B() {
        L1 = Boolean.FALSE;
        P3();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        ImageButton imageButton = (ImageButton) findViewById(R.id.ibn_main_apps);
        this.f4965j1 = imageButton;
        imageButton.setOnClickListener(this);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.ibn_main_remote);
        this.f4973n1 = imageButton2;
        imageButton2.setOnClickListener(this);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.ibn_main_settings);
        this.f4975o1 = imageButton3;
        imageButton3.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.iv_connect_tips);
        this.z1 = imageView;
        imageView.setOnClickListener(new J());
        O2();
        this.f4944Z = (ViewGroup) findViewById(R.id.vg_main_network);
        this.f4946a0 = (ViewGroup) findViewById(R.id.vg_main_connecting);
        this.f4913A0 = (ViewGroup) findViewById(R.id.vg_main);
        this.f4948b0 = (TextView) findViewById(R.id.tv_main_connect_cancel);
        this.f4950c0 = (ImageButton) findViewById(R.id.ib_main_back);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.loadView_device);
        this.f4962i0 = lottieAnimationView;
        lottieAnimationView.setImageAssetsFolder("lottiefiles/");
        this.f4962i0.c(new K());
        this.f4960h0 = (RelativeLayout) findViewById(R.id.rl_main_devcs_connecting);
        this.f4964j0 = (TextView) findViewById(R.id.tv_main_connect_status);
        this.f4966k0 = (TextView) findViewById(R.id.tv_input_again);
        this.f4968l0 = (ImageView) findViewById(R.id.iv_error_pin);
        AppCompatEditText appCompatEditText = (AppCompatEditText) findViewById(R.id.et_pin_go);
        this.f4956f0 = appCompatEditText;
        appCompatEditText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        this.f4966k0.setOnClickListener(this);
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.ib_main_host);
        this.f4970m0 = imageButton4;
        imageButton4.setEnabled(false);
        this.f4982s0 = (ImageButton) findViewById(R.id.ib_main_full_cast);
        this.f4924L0 = (ViewGroup) findViewById(R.id.vg_main_host);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv_main_host);
        this.f4925M0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        new androidx.recyclerview.widget.f(new C0282f(this, new L())).m(this.f4925M0);
        this.f4988v0 = (ViewGroup) findViewById(R.id.vg_main_content);
        this.f4989w0 = (ViewGroup) findViewById(R.id.vg_main_devices);
        this.f4990x0 = (RecyclerView) findViewById(R.id.rv_main_devices);
        this.f4991y0 = (SwipeRefreshLayout) findViewById(R.id.swipeContainer_devices);
        this.f4992z0 = (TextView) findViewById(R.id.tv_main_title);
        this.f4914B0 = (CircleBar) findViewById(R.id.cb_main_media);
        this.f4915C0 = (ImageButton) findViewById(R.id.tv_main_disconnect);
        this.f4916D0 = (TextView) findViewById(R.id.tv_main_con_server_name);
        this.f4917E0 = (TextView) findViewById(R.id.tv_main_con_server_ip);
        this.f4921I0 = (RelativeLayout) findViewById(R.id.rl_main_cast_start);
        this.f4922J0 = (Button) findViewById(R.id.tv_main_cast_stop);
        this.f4918F0 = (ViewGroup) findViewById(R.id.vg_main_mirror_manage);
        this.f4919G0 = (ViewGroup) findViewById(R.id.vg_main_functions);
        findViewById(R.id.btn_main_start_scan_qrcode).setOnClickListener(this);
        findViewById(R.id.btn_device_con_go).setOnClickListener(this);
        findViewById(R.id.rl_main_media).setOnClickListener(this);
        findViewById(R.id.rl_main_photo).setOnClickListener(this);
        findViewById(R.id.rl_main_document).setOnClickListener(this);
        findViewById(R.id.rl_main_camera).setOnClickListener(this);
        findViewById(R.id.rl_main_control).setOnClickListener(this);
        findViewById(R.id.rl_main_mirror).setOnClickListener(this);
        findViewById(R.id.iv_main_setting).setOnClickListener(this);
        AppCompatEditText appCompatEditText2 = this.f4956f0;
        appCompatEditText2.addTextChangedListener(new q0.l(15, appCompatEditText2));
        Z3();
        this.f4973n1.setSelected(true);
        this.z1.setImageResource(2131165742);
        this.z1.setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.logo);
        this.H1 = textView;
        textView.setOnClickListener(new M());
        TextView textView2 = (TextView) findViewById(R.id.luma);
        this.I1 = textView2;
        textView2.setOnClickListener(new N());
    }

    @Override // m0.ViewOnClickListenerC0291e.b
    public void C() {
        N3();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_main;
    }

    @Override // m0.n.a
    public void D() {
        E3();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() throws Throwable {
        k.c("initData...  ");
        this.y1.sendEmptyMessageDelayed(10001, 100L);
        this.f4961h1 = N0();
        j jVar = new j();
        this.f4977p1 = jVar;
        if (jVar.isAdded()) {
            this.f4961h1.p().o(this.f4977p1).l(this.f4963i1).g();
        } else {
            this.f4961h1.p().b(R.id.ll_main_center, this.f4977p1).o(this.f4977p1).g();
        }
        this.f4963i1 = this.f4977p1;
        this.f4927O0 = new C0303d(this, new O());
        this.f4942Y = EShareAPI.init(this).event();
        this.f4931S0 = (Vibrator) getSystemService("vibrator");
        this.f4939W0 = Executors.newSingleThreadExecutor();
        if (!q0.q.a(this, "isRegistered", false)) {
            this.f4939W0.execute(new RunnableC0228a());
        }
        this.f4951c1 = EShareAPI.init(this);
        this.f4941X0 = EShareAPI.init(this).device();
        this.f4943Y0 = EShareAPI.init(this).screen();
        this.f4945Z0 = EShareAPI.init(this).media();
        bindService(new Intent(this, (Class<?>) MediaService.class), this.f4955e1, 1);
        C0301b c0301bC = C0301b.c();
        this.f4928P0 = c0301bC;
        c0301bC.d(this);
        this.f4928P0.e(this);
        this.f4930R0 = Z0.e.h(this, getString(R.string.click_to_exit), null, getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.white), 0, false, true);
        this.f4934U = new ArrayList();
        c cVar = new c(this);
        this.f4932T = cVar;
        cVar.y(this);
        this.f4986u0 = -1;
        this.f4991y0.setOnRefreshListener(new C0229b());
        this.f5378D = 0;
    }

    @Override // m0.h.c
    public void E() {
        H3();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() throws Throwable {
        this.f4948b0.setOnClickListener(this);
        this.f4915C0.setOnClickListener(this);
        this.f4921I0.setOnClickListener(this);
        this.f4922J0.setOnClickListener(this);
        this.f4950c0.setOnClickListener(this);
        this.f4970m0.setOnClickListener(this);
        this.f4982s0.setOnClickListener(this);
        this.f4990x0.setLayoutManager(new LinearLayoutManager(this));
        this.f4990x0.setAdapter(this.f4932T);
        W3();
        this.f4929Q0 = this.f4988v0.getMeasuredHeight();
    }

    public void F3() throws Throwable {
        k.c("startFindDevices...");
        X2();
        Z3();
        this.f4975o1.setSelected(true);
        if (this.f4971m1 == 15) {
            return;
        }
        this.f4971m1 = 15;
        androidx.fragment.app.E eP = this.f4961h1.p();
        this.f4959g1 = null;
        this.f4959g1 = new ViewOnClickListenerC0290d();
        if (this.f4959g1.isAdded()) {
            eP.o(this.f4959g1).l(this.f4963i1).g();
        } else {
            eP.b(R.id.ll_main_center, this.f4959g1).o(this.f4959g1).l(this.f4963i1).h();
        }
        this.f4963i1 = this.f4959g1;
    }

    @Override // m0.C0288b.InterfaceC0091b
    public void H() {
        this.y1.sendEmptyMessage(60000);
    }

    public void I3() {
        ViewOnClickListenerC0290d viewOnClickListenerC0290d = this.f4959g1;
        if (viewOnClickListenerC0290d != null) {
            viewOnClickListenerC0290d.f6613h.removeCallbacksAndMessages(null);
        }
        if (this.f4971m1 == 31) {
            return;
        }
        this.f4971m1 = 31;
        androidx.fragment.app.E eP = this.f4961h1.p();
        Z3();
        this.f4975o1.setSelected(true);
        this.A1 = null;
        this.A1 = new ViewOnClickListenerC0291e();
        if (this.A1.isAdded()) {
            eP.o(this.A1).l(this.f4963i1).g();
        } else {
            eP.b(R.id.ll_main_center, this.A1).o(this.A1).l(this.f4963i1).g();
        }
        this.f4963i1 = this.A1;
    }

    @Override // m0.j.h
    public void J() throws Throwable {
        W2();
    }

    @Override // m0.i.d
    public void K() throws Throwable {
        F3();
    }

    public void K3() {
        ViewOnClickListenerC0290d viewOnClickListenerC0290d = this.f4959g1;
        if (viewOnClickListenerC0290d != null) {
            viewOnClickListenerC0290d.f6613h.removeCallbacksAndMessages(null);
        }
        if (this.f4971m1 == 32) {
            return;
        }
        this.f4971m1 = 32;
        androidx.fragment.app.E eP = this.f4961h1.p();
        Z3();
        this.f4975o1.setSelected(true);
        this.f4969l1 = null;
        this.f4969l1 = new ViewOnClickListenerC0292f();
        if (this.f4969l1.isAdded()) {
            eP.o(this.f4969l1).l(this.f4963i1).g();
        } else {
            eP.b(R.id.ll_main_center, this.f4969l1).o(this.f4969l1).l(this.f4963i1).g();
        }
        this.f4963i1 = this.f4969l1;
    }

    public void M3(boolean z2, a aVar) {
        if (z2) {
            I1(7, new C0234g(aVar));
        } else {
            this.f4935U0 = 0;
            if (AbstractC0313b.k(aVar, "com.eshare.mirror.MirrorScreenCaptureService")) {
                this.f4943Y0.continueScreenMirror(aVar);
            } else {
                this.f4941X0.acceptCastInvitation(1);
                this.f4943Y0.startScreenMirror(aVar, true);
            }
        }
        o.a(this);
    }

    @Override // m0.n.a
    public void N() {
        G3();
    }

    public void N3() {
        ViewOnClickListenerC0290d viewOnClickListenerC0290d = this.f4959g1;
        if (viewOnClickListenerC0290d != null) {
            viewOnClickListenerC0290d.f6613h.removeCallbacksAndMessages(null);
        }
        if (this.f4971m1 == 34) {
            return;
        }
        this.f4971m1 = 34;
        androidx.fragment.app.E eP = this.f4961h1.p();
        Z3();
        this.f4975o1.setSelected(true);
        this.E1 = null;
        this.E1 = new g();
        if (this.E1.isAdded()) {
            eP.o(this.E1).l(this.f4963i1).g();
        } else {
            eP.b(R.id.ll_main_center, this.E1).o(this.E1).l(this.f4963i1).g();
        }
        this.f4963i1 = this.E1;
    }

    @Override // m0.i.d
    public void O() {
        G3();
    }

    @Override // o0.C0301b.a
    public void P(boolean z2) throws Throwable {
        View view;
        o3(z2);
        if (!z2 && this.f4935U0 == 1) {
            this.f4941X0.isDeviceConnect();
        }
        if (z2 || (view = this.f4923K0) == null) {
            return;
        }
        onClick(view);
        this.f4923K0 = null;
    }

    public void P3() {
        ViewOnClickListenerC0290d viewOnClickListenerC0290d = this.f4959g1;
        if (viewOnClickListenerC0290d != null) {
            viewOnClickListenerC0290d.f6613h.removeCallbacksAndMessages(null);
        }
        if (this.f4971m1 == 33) {
            return;
        }
        this.f4971m1 = 33;
        androidx.fragment.app.E eP = this.f4961h1.p();
        Z3();
        this.f4975o1.setSelected(true);
        this.D1 = null;
        this.D1 = new i();
        if (this.D1.isAdded()) {
            eP.o(this.D1).l(this.f4963i1).g();
        } else {
            eP.b(R.id.ll_main_center, this.D1).o(this.D1).l(this.f4963i1).g();
        }
        this.f4963i1 = this.D1;
    }

    public void Q3() {
        ViewOnClickListenerC0290d viewOnClickListenerC0290d = this.f4959g1;
        if (viewOnClickListenerC0290d != null) {
            viewOnClickListenerC0290d.f6613h.removeCallbacksAndMessages(null);
        }
        if (this.f4971m1 == 2) {
            return;
        }
        this.f4971m1 = 2;
        androidx.fragment.app.E eP = this.f4961h1.p();
        Z3();
        b3();
        this.f4977p1 = null;
        this.f4977p1 = new j();
        if (this.f4977p1.isAdded()) {
            eP.o(this.f4977p1).l(this.f4963i1).g();
        } else {
            eP.b(R.id.ll_main_center, this.f4977p1).o(this.f4977p1).l(this.f4963i1).g();
        }
        this.f4963i1 = this.f4977p1;
    }

    public void R2() throws Throwable {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (defaultSharedPreferences.getInt("device_network_id", 0) != Z2()) {
            Q3();
        } else if (defaultSharedPreferences.getBoolean("device_config", false)) {
            P2(new Device(defaultSharedPreferences.getString("device_name", ""), defaultSharedPreferences.getString("device_ip", "0.0.0.0"), String.valueOf(defaultSharedPreferences.getInt("device_port", 2012)), String.valueOf(defaultSharedPreferences.getInt("device_speaker_port", 25123)), (String) null));
        }
    }

    @Override // m0.ViewOnClickListenerC0290d.e
    public void S() {
        Q3();
    }

    @Override // m0.h.c
    public void U() {
        P3();
    }

    @Override // m0.l.b
    public void V() {
        H3();
    }

    public void V2(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
            }
            intent.addFlags(268435456);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "您的手机没有安装Android应用市场", 0).show();
            e.printStackTrace();
        }
    }

    @Override // m0.ViewOnClickListenerC0290d.e
    public void X() {
        X2();
    }

    public void X2() {
        this.f4941X0.startFindDevice();
        this.f4941X0.findDevices(new C0237j());
    }

    @Override // m0.j.h
    public void Y() {
        y3(101, 2);
    }

    public void Y3() throws Throwable {
        if (d3()) {
            this.f4934U.clear();
            this.f4933T0 = 5;
            W3();
        } else {
            if (this.f4933T0 == 0) {
                return;
            }
            this.f4941X0.clearDevices();
            this.f4933T0 = 0;
            W3();
        }
    }

    public void Z3() {
        this.f4965j1.setSelected(false);
        this.f4973n1.setSelected(false);
        this.f4975o1.setSelected(false);
        this.z1.setVisibility(8);
    }

    public void b3() {
        this.f4973n1.setSelected(true);
        if (this.f4941X0.isDeviceConnect()) {
            this.z1.setImageResource(2131165743);
        } else {
            this.z1.setImageResource(2131165742);
        }
        this.z1.setVisibility(0);
    }

    @Override // m0.ViewOnClickListenerC0291e.b
    public void c0() {
        K3();
    }

    public boolean d3() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected();
        }
        return false;
    }

    @Override // j0.b
    public void e(int i2, int i3) {
    }

    protected void e3(int i2, int i3, Intent intent) {
        if (i3 == 0 && i2 == 10) {
            finish();
        } else if (i3 == 5 && i2 == 10) {
            startActivity(new Intent(getApplicationContext(), (Class<?>) ScreenTutorialActivity.class));
            this.y1.sendEmptyMessageDelayed(101, 100L);
        } else {
            if (i2 == 2000) {
                return;
            }
            if (i3 == 1001 || i2 == 1002) {
                if (q0.q.a(getApplicationContext(), "LogSuccess", false)) {
                    R2();
                } else {
                    N2();
                }
            } else if (i3 == 90000) {
                Q3();
            }
        }
        if (this.f4943Y0.setScreenMirrorData(this, i2, i3, intent, null)) {
            o3(true);
            this.f4941X0.acceptCastInvitation(1);
        } else if (i2 != 1) {
            this.f4941X0.acceptCastInvitation(0);
            o3(false);
        } else {
            if (i3 != -1 || intent == null) {
                return;
            }
            m3(intent.getStringExtra("SCAN_RESULT"));
        }
    }

    @s1.m(threadMode = ThreadMode.MAIN)
    public void finishSelf(h0.g gVar) throws Throwable {
        if (gVar.a() == h0.g.f6395b) {
            U2();
        } else if (gVar.a() == h0.g.f6396c) {
            V3();
        }
    }

    @Override // m0.j.h
    public void i() throws Throwable {
        S3();
    }

    @Override // m0.m.b
    public void j() {
        H3();
    }

    @Override // m0.n.a
    public void k() {
        D3();
    }

    public void n3(int i2) {
        this.f4939W0.execute(new I(i2));
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2000 && Settings.canDrawOverlays(this)) {
            this.f4943Y0.startPaintController();
        }
        e3(i2, i3, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() throws Throwable {
        ViewOnClickListenerC0291e viewOnClickListenerC0291e = this.A1;
        if (viewOnClickListenerC0291e != null && viewOnClickListenerC0291e.isVisible()) {
            K3();
            return;
        }
        i iVar = this.D1;
        if (iVar != null && iVar.isVisible()) {
            I3();
            return;
        }
        g gVar = this.E1;
        if (gVar != null && gVar.isVisible()) {
            I3();
            return;
        }
        ViewOnClickListenerC0292f viewOnClickListenerC0292f = this.f4969l1;
        if (viewOnClickListenerC0292f != null && viewOnClickListenerC0292f.isVisible() && this.f4969l1.i()) {
            return;
        }
        W2();
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        int i2 = 0;
        switch (view.getId()) {
            case R.id.btn_device_con_go /* 2131230823 */:
                O3();
                break;
            case R.id.btn_main_start_scan_qrcode /* 2131230828 */:
                this.f4952d0 = true;
                if (o.b(this)) {
                    R3();
                    break;
                }
                break;
            case R.id.ib_main_back /* 2131230934 */:
                onBackPressed();
                break;
            case R.id.ib_main_full_cast /* 2131230935 */:
                k3();
                break;
            case R.id.ib_main_host /* 2131230936 */:
                if (this.f4926N0 == null) {
                    f fVar = new f(this.f4974o0, this.f4979q1);
                    this.f4926N0 = fVar;
                    this.f4925M0.setAdapter(fVar);
                }
                this.f4933T0 = 6;
                W3();
                break;
            case R.id.ibn_main_apps /* 2131230939 */:
                Z3();
                this.f4965j1.setSelected(true);
                break;
            case R.id.ibn_main_remote /* 2131230940 */:
                Z3();
                b3();
                i2 = 2;
                break;
            case R.id.ibn_main_settings /* 2131230941 */:
                Z3();
                this.f4975o1.setSelected(true);
                i2 = 1;
                break;
            case R.id.iv_main_setting /* 2131230999 */:
                startActivity(new Intent(this, (Class<?>) SettingActivity.class));
                break;
            case R.id.rl_main_cast_start /* 2131231152 */:
                M3(true, this);
                break;
            case R.id.tv_input_again /* 2131231323 */:
                if (!this.f4954e0) {
                    v3();
                    break;
                }
                break;
            case R.id.tv_main_cast_stop /* 2131231345 */:
                V3();
                break;
            case R.id.tv_main_connect_cancel /* 2131231348 */:
                this.f4941X0.cancelConnect();
                this.f4941X0.disconnectDevice(null);
                this.f4933T0 = 5;
                W3();
                break;
            case R.id.tv_main_disconnect /* 2131231350 */:
                U2();
                W3();
                break;
            default:
                f3(view);
                break;
        }
        if (this.f4971m1 == i2) {
            return;
        }
        ViewOnClickListenerC0290d viewOnClickListenerC0290d = this.f4959g1;
        if (viewOnClickListenerC0290d != null) {
            viewOnClickListenerC0290d.f6613h.removeCallbacksAndMessages(null);
        }
        this.f4971m1 = i2;
        androidx.fragment.app.E eP = this.f4961h1.p();
        if (i2 == 1) {
            S3();
            this.f4969l1 = null;
            this.f4969l1 = new ViewOnClickListenerC0292f();
            if (this.f4969l1.isAdded()) {
                eP.o(this.f4969l1).l(this.f4963i1).g();
            } else {
                eP.b(R.id.ll_main_center, this.f4969l1).o(this.f4969l1).l(this.f4963i1).g();
            }
            this.f4963i1 = this.f4969l1;
            return;
        }
        if (i2 != 0) {
            if (i2 == 2) {
                S3();
                this.f4977p1 = null;
                this.f4977p1 = new j();
                if (this.f4977p1.isAdded()) {
                    eP.o(this.f4977p1).l(this.f4963i1).g();
                } else {
                    eP.b(R.id.ll_main_center, this.f4977p1).o(this.f4977p1).l(this.f4963i1).g();
                }
                this.f4963i1 = this.f4977p1;
                return;
            }
            return;
        }
        S3();
        if (!this.f4941X0.isDeviceConnect()) {
            if (this.f4963i1.getClass().equals(ViewOnClickListenerC0289c.class)) {
                return;
            }
            C3();
        } else {
            this.f4957f1 = null;
            this.f4957f1 = new C0288b();
            if (this.f4957f1.isAdded()) {
                eP.o(this.f4957f1).l(this.f4963i1).g();
            } else {
                eP.b(R.id.ll_main_center, this.f4957f1).o(this.f4957f1).l(this.f4963i1).g();
            }
            this.f4963i1 = this.f4957f1;
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        K1 = this;
        new k(this);
        new LogHelper(this);
        if (Build.VERSION.SDK_INT >= 34) {
            setRequestedOrientation(5);
        } else {
            setRequestedOrientation(1);
        }
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() throws Throwable {
        super.onDestroy();
        MediaService mediaService = this.f4947a1;
        if (mediaService != null) {
            mediaService.v(this);
        }
        this.f4934U.clear();
        S3();
        unbindService(this.f4955e1);
        U2();
        this.y1.removeCallbacksAndMessages(null);
        this.f4943Y0.stopScreenMirror(this);
        this.f4928P0.f(this);
        this.f4939W0.shutdown();
        this.f4927O0.c();
        K1 = null;
        this.f4943Y0.stopPaintController();
    }

    @Override // androidx.appcompat.app.AbstractActivityC0128c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 25 || i2 == 24) {
            this.f4942Y.sendKeyEvent(i2);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) throws Throwable {
        boolean z2;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z2 = true;
                break;
            } else {
                if (iArr[i3] != 0) {
                    z2 = false;
                    break;
                }
                i3++;
            }
        }
        if (i2 == 1007) {
            if (z2) {
                Y3();
            }
            return;
        }
        if (i2 == 1009) {
            if (z2) {
                k.c("request storage success...");
                k.c("request storage success...");
                return;
            }
            return;
        }
        switch (i2) {
            case 1001:
                if (z2) {
                    if (!this.f4952d0) {
                        g3();
                        break;
                    } else {
                        R3();
                        break;
                    }
                }
                break;
            case 1002:
                if (z2) {
                    i3();
                    break;
                }
                break;
            case 1003:
                if (z2) {
                    j3();
                    break;
                }
                break;
            case 1004:
                if (z2) {
                    h3();
                    break;
                }
                break;
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onResume() throws Throwable {
        super.onResume();
        X3(this.f4986u0);
        if (this.f4933T0 == 0) {
            Y3();
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f4943Y0.stopScreenMirror(getApplicationContext());
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onStop() {
        super.onStop();
        J1 = false;
    }

    @Override // j0.e
    public void p(RecyclerView.g gVar, int i2) throws Throwable {
        c cVar = this.f4932T;
        if (gVar == cVar) {
            Device deviceV = cVar.v(i2);
            if (deviceV == null) {
                CustomApplication.f(R.string.main_connect_error_null);
            } else if (i2 == 0 && deviceV.getName().equals(this.f4951c1.getDeviceName())) {
                y3(103, 3);
            } else {
                P2(deviceV);
            }
        }
    }

    public void p3(InterfaceC0272a interfaceC0272a) {
        this.f4938W = interfaceC0272a;
    }

    @Override // m0.ViewOnClickListenerC0292f.a
    public void q() {
        I3();
    }

    protected void s3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View viewInflate = View.inflate(this, R.layout.dialog_connect_tips, null);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        this.f4953d1 = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        this.f4953d1.getContext().setTheme(R.style.dialogstyle);
        AlertDialog alertDialog = this.f4953d1;
        if (alertDialog != null) {
            alertDialog.show();
        }
        q3(this.f4953d1);
        this.f4981r1 = (TextView) viewInflate.findViewById(R.id.tv_connect_later);
        this.f4983s1 = (TextView) viewInflate.findViewById(R.id.tv_connect_device);
        this.f4981r1.setOnClickListener(new A());
        this.f4983s1.setOnClickListener(new B());
    }

    @Override // m0.ViewOnClickListenerC0292f.a
    public void t() throws Throwable {
        F3();
    }

    protected void t3() throws Throwable {
        k.c("showConnectErrorDialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View viewInflate = View.inflate(this, R.layout.dialog_connect_error, null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_faild_ok);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        q3(alertDialogCreate);
        textView.setOnClickListener(new F(alertDialogCreate));
    }

    @Override // m0.ViewOnClickListenerC0289c.a
    public void u() throws Throwable {
        F3();
    }

    @s1.m(threadMode = ThreadMode.MAIN)
    public void updateServerName(h0.k kVar) {
        if (TextUtils.isEmpty(kVar.a())) {
            return;
        }
        this.f4916D0.setText(kVar.a());
    }

    @Override // m0.j.h
    public void v() throws Throwable {
        L3();
    }

    @Override // m0.ViewOnClickListenerC0291e.b
    public void w() {
        L1 = Boolean.TRUE;
        P3();
    }

    public void y3(int i2, int i3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View viewInflate = View.inflate(this, R.layout.dialog_power_off, null);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        alertDialogCreate.setCancelable(false);
        q3(alertDialogCreate);
        this.f4985t1 = (TextView) viewInflate.findViewById(R.id.tv_dialog_title);
        this.f4987u1 = (TextView) viewInflate.findViewById(R.id.tv_power_cancel);
        this.v1 = (TextView) viewInflate.findViewById(R.id.tv_power_ok);
        this.w1 = (TextView) viewInflate.findViewById(R.id.tv_dialog_content);
        this.x1 = (TextView) viewInflate.findViewById(R.id.tv_power_cancel);
        switch (i2) {
            case 101:
                this.f4985t1.setText(getString(R.string.tv_main_poweroff));
                this.v1.setText(getString(R.string.tv_main_turnoff));
                this.w1.setText(getString(R.string.tv_sure));
                this.x1.setText(getString(R.string.tv_main_cancel));
                break;
            case 102:
                this.f4985t1.setText(getString(R.string.tv_logoff));
                this.v1.setText(getString(R.string.tv_logoff));
                this.w1.setText(getString(R.string.tv_sure));
                this.x1.setText(getString(R.string.tv_main_cancel));
                break;
            case 103:
                this.f4985t1.setText(getString(R.string.tv_paird));
                this.v1.setText(getString(R.string.tv_close));
                this.w1.setText(this.f4951c1.getDeviceName());
                this.x1.setText(getString(R.string.tv_forget));
                break;
        }
        this.f4987u1.setOnClickListener(new G(i2, alertDialogCreate));
        this.v1.setOnClickListener(new H(i2, alertDialogCreate));
    }

    @Override // m0.ViewOnClickListenerC0292f.a
    public void z() {
        y3(102, 1);
    }
}
