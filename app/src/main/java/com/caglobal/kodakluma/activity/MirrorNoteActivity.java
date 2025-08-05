package com.caglobal.kodakluma.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.view.NoteView;
import com.eshare.api.EShareAPI;
import com.eshare.api.IDevice;
import com.eshare.api.IEvent;
import com.eshare.api.utils.EShareUtils;
import com.eshare.lib.JpgHelper;
import com.eshare.lib.JpgHelperCallback;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import l0.InterfaceC0280d;
import q0.AbstractC0312a;
import q0.AbstractC0316e;
import q0.n;
import q0.o;
import q0.r;
import s1.m;

/* loaded from: classes.dex */
public class MirrorNoteActivity extends com.caglobal.kodakluma.activity.a {

    /* renamed from: K0, reason: collision with root package name */
    public static MirrorNoteActivity f5103K0;

    /* renamed from: L0, reason: collision with root package name */
    private static WindowManager f5104L0;

    /* renamed from: M0, reason: collision with root package name */
    private static View f5105M0;

    /* renamed from: A0, reason: collision with root package name */
    private ImageButton f5106A0;

    /* renamed from: B0, reason: collision with root package name */
    private ImageButton f5107B0;

    /* renamed from: C0, reason: collision with root package name */
    private ImageButton f5108C0;

    /* renamed from: D0, reason: collision with root package name */
    private ImageButton f5109D0;

    /* renamed from: E0, reason: collision with root package name */
    private ImageButton f5110E0;

    /* renamed from: F0, reason: collision with root package name */
    private ImageButton f5111F0;

    /* renamed from: G0, reason: collision with root package name */
    private ImageButton f5112G0;

    /* renamed from: H0, reason: collision with root package name */
    private ImageButton f5113H0;

    /* renamed from: I0, reason: collision with root package name */
    private ImageButton f5114I0;

    /* renamed from: J0, reason: collision with root package name */
    private int f5115J0;

    /* renamed from: U, reason: collision with root package name */
    private ExecutorService f5117U;

    /* renamed from: V, reason: collision with root package name */
    private EShareAPI f5118V;

    /* renamed from: W, reason: collision with root package name */
    private IEvent f5119W;

    /* renamed from: X, reason: collision with root package name */
    private LinearLayout f5120X;

    /* renamed from: Y, reason: collision with root package name */
    private String f5121Y;

    /* renamed from: Z, reason: collision with root package name */
    private ImageView f5122Z;

    /* renamed from: a0, reason: collision with root package name */
    private RelativeLayout f5123a0;

    /* renamed from: b0, reason: collision with root package name */
    private RectF f5124b0;

    /* renamed from: c0, reason: collision with root package name */
    private Dialog f5125c0;

    /* renamed from: f0, reason: collision with root package name */
    private volatile boolean f5128f0;

    /* renamed from: g0, reason: collision with root package name */
    private Thread f5129g0;

    /* renamed from: h0, reason: collision with root package name */
    private Thread f5130h0;

    /* renamed from: i0, reason: collision with root package name */
    private DatagramSocket f5131i0;

    /* renamed from: j0, reason: collision with root package name */
    private long f5132j0;

    /* renamed from: l0, reason: collision with root package name */
    private BlockingQueue f5134l0;

    /* renamed from: m0, reason: collision with root package name */
    private Bitmap f5135m0;

    /* renamed from: n0, reason: collision with root package name */
    private AnimationSet f5136n0;

    /* renamed from: o0, reason: collision with root package name */
    private AnimationSet f5137o0;

    /* renamed from: p0, reason: collision with root package name */
    private com.caglobal.kodakluma.view.a f5138p0;

    /* renamed from: q0, reason: collision with root package name */
    private WindowManager.LayoutParams f5139q0;

    /* renamed from: r0, reason: collision with root package name */
    private k f5140r0;

    /* renamed from: s0, reason: collision with root package name */
    private l f5141s0;

    /* renamed from: t0, reason: collision with root package name */
    private IDevice f5142t0;

    /* renamed from: u0, reason: collision with root package name */
    private ProgressDialog f5143u0;

    /* renamed from: w0, reason: collision with root package name */
    private long f5145w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f5146x0;

    /* renamed from: y0, reason: collision with root package name */
    private NoteView f5147y0;

    /* renamed from: z0, reason: collision with root package name */
    private ImageButton f5148z0;

    /* renamed from: T, reason: collision with root package name */
    public boolean f5116T = false;

    /* renamed from: d0, reason: collision with root package name */
    private int f5126d0 = R.id.bcb_back_color_11;

    /* renamed from: e0, reason: collision with root package name */
    private int f5127e0 = R.id.bsb_back_size_02;

    /* renamed from: k0, reason: collision with root package name */
    private JpgHelper f5133k0 = new JpgHelper();

    /* renamed from: v0, reason: collision with root package name */
    private final Handler f5144v0 = new b();

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                if (MirrorNoteActivity.this.f5122Z == null || MirrorNoteActivity.this.f5135m0 == null) {
                    return;
                }
                MirrorNoteActivity.this.f5122Z.setImageBitmap(MirrorNoteActivity.this.f5135m0);
                return;
            }
            if (i2 == 2) {
                if (MirrorNoteActivity.this.f5131i0 != null) {
                    EShareUtils.getScreenCap(MirrorNoteActivity.this.f5131i0, MirrorNoteActivity.this.f5121Y);
                    MirrorNoteActivity.this.f5132j0 = System.currentTimeMillis();
                    sendMessageDelayed(obtainMessage(2), 100L);
                    return;
                }
                return;
            }
            if (i2 == 257) {
                MirrorNoteActivity.this.j2();
                Toast.makeText(MirrorNoteActivity.this.getApplicationContext(), (String) message.obj, 0).show();
                MirrorNoteActivity.this.y2((String) message.obj);
            } else {
                if (i2 != 258) {
                    return;
                }
                MirrorNoteActivity.this.j2();
                Toast.makeText(MirrorNoteActivity.this.getApplicationContext(), R.string.capture_failed, 0).show();
            }
        }
    }

    class c implements JpgHelperCallback {
        c() {
        }
    }

    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            WindowManager windowManager = (WindowManager) MirrorNoteActivity.this.getSystemService("window");
            MirrorNoteActivity.this.f5118V.event().sendTouchEvent(motionEvent, windowManager.getDefaultDisplay().getWidth() + MirrorNoteActivity.this.f5115J0, windowManager.getDefaultDisplay().getHeight());
            return true;
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() throws SecurityException, IOException, IllegalArgumentException {
            Process.setThreadPriority(Process.myTid(), -8);
            if (MirrorNoteActivity.this.f5131i0 == null) {
                return;
            }
            byte[] bArr = new byte[1450];
            boolean z2 = false;
            while (!MirrorNoteActivity.this.f5128f0) {
                DatagramPacket datagramPacket = new DatagramPacket(bArr, 1450);
                if ((System.currentTimeMillis() - MirrorNoteActivity.this.f5132j0 >= 100 || MirrorNoteActivity.this.f5132j0 == 0) && !z2) {
                    EShareUtils.getScreenCap(MirrorNoteActivity.this.f5131i0, MirrorNoteActivity.this.f5121Y);
                    MirrorNoteActivity.this.f5132j0 = System.currentTimeMillis();
                }
                try {
                    MirrorNoteActivity.this.f5131i0.receive(datagramPacket);
                    if (JpgHelper.byteArray2Int(bArr, 0) == 1) {
                        MirrorNoteActivity.this.f5133k0.unpack((String) null, bArr);
                    }
                    if (!z2 && !MirrorNoteActivity.this.f5144v0.hasMessages(2)) {
                        MirrorNoteActivity.this.f5144v0.sendEmptyMessage(2);
                        z2 = true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(Process.myTid(), -8);
            while (!MirrorNoteActivity.this.f5128f0) {
                try {
                    byte[] byteArray = ((ByteArrayOutputStream) MirrorNoteActivity.this.f5134l0.take()).toByteArray();
                    MirrorNoteActivity.this.f5135m0 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    MirrorNoteActivity.this.f5144v0.sendEmptyMessage(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class g implements InterfaceC0280d {
        g() {
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() {
            if (o.b(MirrorNoteActivity.this)) {
                MirrorNoteActivity.this.p2();
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String strC = AbstractC0312a.c(MirrorNoteActivity.this.f5118V.getIpAddress());
            if (TextUtils.isEmpty(strC)) {
                MirrorNoteActivity.this.f5144v0.sendEmptyMessage(258);
                return;
            }
            Message message = new Message();
            message.what = 257;
            message.obj = strC;
            MirrorNoteActivity.this.f5144v0.sendMessage(message);
        }
    }

    class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5157a;

        i(int i2) {
            this.f5157a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            MirrorNoteActivity.this.f5119W.sendKeyEvent(this.f5157a);
        }
    }

    class j implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5159a;

        j(String str) {
            this.f5159a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) throws Throwable {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            intent.addFlags(1);
            intent.putExtra("android.intent.extra.STREAM", FileProvider.h(MirrorNoteActivity.this, "com.caglobal.kodakluma.fileprovider", new File(this.f5159a)));
            try {
                MirrorNoteActivity mirrorNoteActivity = MirrorNoteActivity.this;
                mirrorNoteActivity.startActivity(Intent.createChooser(intent, mirrorNoteActivity.getString(R.string.capture_share_title)));
            } catch (Exception e) {
                q0.k.b("share image to other application failed =" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private class k implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private int f5161a;

        public k() {
            this.f5161a = 0;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            MirrorNoteActivity.f5104L0.getDefaultDisplay().getMetrics(displayMetrics);
            this.f5161a = displayMetrics.heightPixels;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r.a()) {
                return;
            }
            MirrorNoteActivity.this.f5138p0.g();
            MirrorNoteActivity mirrorNoteActivity = MirrorNoteActivity.this;
            mirrorNoteActivity.t2(mirrorNoteActivity.f5120X);
            MirrorNoteActivity.this.f5139q0.y = (this.f5161a / 2) - (view.getHeight() / 2);
            MirrorNoteActivity.f5104L0.updateViewLayout(view, MirrorNoteActivity.this.f5139q0);
        }
    }

    class l implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private int f5163a;

        /* renamed from: b, reason: collision with root package name */
        private float f5164b;

        /* renamed from: c, reason: collision with root package name */
        private float f5165c;

        /* renamed from: d, reason: collision with root package name */
        private long f5166d;
        private long e;

        /* renamed from: f, reason: collision with root package name */
        private int f5167f = 0;

        public l() {
            this.f5163a = 0;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            MirrorNoteActivity.f5104L0.getDefaultDisplay().getMetrics(displayMetrics);
            this.f5163a = displayMetrics.heightPixels;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f5164b = Math.abs(this.f5163a - motionEvent.getRawY());
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f5167f = 0;
                this.f5166d = System.currentTimeMillis();
                this.f5165c = this.f5164b;
            } else if (action == 1) {
                this.e = System.currentTimeMillis();
                MirrorNoteActivity.f5104L0.updateViewLayout(view, MirrorNoteActivity.this.f5139q0);
                if (this.f5164b - this.f5165c < 15.0f && this.e - this.f5166d < 200) {
                    MirrorNoteActivity.this.f5138p0.g();
                    MirrorNoteActivity mirrorNoteActivity = MirrorNoteActivity.this;
                    mirrorNoteActivity.t2(mirrorNoteActivity.f5120X);
                }
            } else if (action == 2) {
                int i2 = this.f5167f + 1;
                this.f5167f = i2;
                if (i2 > 2) {
                    MirrorNoteActivity.f5104L0.updateViewLayout(view, MirrorNoteActivity.this.f5139q0);
                }
            }
            return true;
        }
    }

    private void A2(int i2, int i3) {
        ProgressDialog progressDialog = this.f5143u0;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f5143u0.setTitle(i2);
            this.f5143u0.setMessage(getString(i3));
            return;
        }
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        this.f5143u0 = progressDialog2;
        progressDialog2.setTitle(i2);
        this.f5143u0.setMessage(getString(i3));
        this.f5143u0.setCanceledOnTouchOutside(false);
        this.f5143u0.show();
    }

    private void B2() {
        Thread thread = new Thread(new f());
        this.f5130h0 = thread;
        thread.start();
    }

    private void C2() throws SocketException {
        if (this.f5131i0 == null) {
            try {
                DatagramSocket datagramSocket = new DatagramSocket();
                this.f5131i0 = datagramSocket;
                datagramSocket.setSoTimeout(100);
                DatagramSocket datagramSocket2 = this.f5131i0;
                datagramSocket2.setReceiveBufferSize(datagramSocket2.getReceiveBufferSize() * 2);
                EShareUtils.getScreenCap(this.f5131i0, this.f5121Y);
            } catch (SocketException e2) {
                e2.printStackTrace();
            }
        }
        Thread thread = new Thread(new e());
        this.f5129g0 = thread;
        thread.start();
    }

    private void D2() throws SocketException {
        this.f5128f0 = false;
        C2();
        B2();
    }

    private void E2() {
        if (this.f5130h0 != null) {
            this.f5128f0 = true;
            this.f5130h0.interrupt();
        }
    }

    private void F2() {
        if (this.f5129g0 != null) {
            this.f5128f0 = true;
            this.f5129g0.interrupt();
        }
    }

    private void G2() {
        this.f5128f0 = true;
        this.f5144v0.removeMessages(2);
        F2();
        E2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j2() {
        ProgressDialog progressDialog = this.f5143u0;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.f5143u0.cancel();
        this.f5143u0 = null;
    }

    public static boolean k2(Context context) {
        return (ViewConfiguration.get(context).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
    }

    private int l2(Context context) {
        if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") == 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static MirrorNoteActivity m2() {
        return f5103K0;
    }

    private void n2() {
        this.f5136n0 = new AnimationSet(false);
        this.f5137o0 = new AnimationSet(false);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        this.f5136n0.addAnimation(alphaAnimation);
        this.f5136n0.addAnimation(translateAnimation);
        this.f5137o0.addAnimation(alphaAnimation2);
        this.f5137o0.addAnimation(translateAnimation2);
        this.f5136n0.setDuration(50L);
        this.f5137o0.setDuration(50L);
        this.f5136n0.setFillBefore(true);
        this.f5137o0.setFillBefore(true);
        this.f5136n0.setFillAfter(true);
        this.f5137o0.setFillAfter(true);
    }

    private void o2() {
        f5104L0 = (WindowManager) getSystemService("window");
        this.f5120X = (LinearLayout) findViewById(R.id.ll_right_panel);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.paint_tools, (ViewGroup) null);
        f5105M0 = viewInflate;
        this.f5120X.addView(viewInflate);
        ImageButton imageButton = (ImageButton) f5105M0.findViewById(R.id.btn_home_pro);
        this.f5148z0 = imageButton;
        imageButton.setOnClickListener(this);
        ImageButton imageButton2 = (ImageButton) f5105M0.findViewById(R.id.btn_back_pro);
        this.f5106A0 = imageButton2;
        imageButton2.setOnClickListener(this);
        ImageButton imageButton3 = (ImageButton) f5105M0.findViewById(R.id.btn_file);
        this.f5107B0 = imageButton3;
        imageButton3.setOnClickListener(this);
        ImageButton imageButton4 = (ImageButton) f5105M0.findViewById(R.id.btn_touch);
        this.f5108C0 = imageButton4;
        imageButton4.setOnClickListener(this);
        ImageButton imageButton5 = (ImageButton) f5105M0.findViewById(R.id.btn_pen);
        this.f5109D0 = imageButton5;
        imageButton5.setOnClickListener(this);
        ImageButton imageButton6 = (ImageButton) f5105M0.findViewById(R.id.btn_eraser);
        this.f5110E0 = imageButton6;
        imageButton6.setOnClickListener(this);
        ImageButton imageButton7 = (ImageButton) f5105M0.findViewById(R.id.btn_screen);
        this.f5111F0 = imageButton7;
        imageButton7.setOnClickListener(this);
        ImageButton imageButton8 = (ImageButton) f5105M0.findViewById(R.id.btn_min);
        this.f5112G0 = imageButton8;
        imageButton8.setOnClickListener(this);
        ImageButton imageButton9 = (ImageButton) f5105M0.findViewById(R.id.btn_screen_capture);
        this.f5113H0 = imageButton9;
        imageButton9.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p2() {
        startActivity(new Intent(this, (Class<?>) CameraActivity.class));
    }

    private void q2() {
        startActivity(new Intent(this, (Class<?>) ProFileActivity.class));
    }

    private void s2(View view) {
        view.startAnimation(this.f5136n0);
        Dialog dialog = this.f5125c0;
        if (dialog != null && dialog.isShowing()) {
            this.f5125c0.cancel();
        }
        this.f5148z0.setVisibility(8);
        this.f5106A0.setVisibility(8);
        this.f5107B0.setVisibility(8);
        this.f5108C0.setVisibility(8);
        this.f5109D0.setVisibility(8);
        this.f5110E0.setVisibility(8);
        this.f5111F0.setVisibility(8);
        this.f5112G0.setVisibility(8);
        this.f5113H0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2(View view) {
        view.startAnimation(this.f5137o0);
        this.f5148z0.setVisibility(0);
        this.f5106A0.setVisibility(0);
        this.f5107B0.setVisibility(8);
        this.f5108C0.setVisibility(8);
        this.f5109D0.setVisibility(8);
        this.f5110E0.setVisibility(8);
        this.f5111F0.setVisibility(8);
        this.f5112G0.setVisibility(0);
        this.f5113H0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.capture_success);
        View viewInflate = View.inflate(this, R.layout.dialog_capture, null);
        ((ImageView) viewInflate.findViewById(R.id.iv_capture_image)).setImageBitmap(AbstractC0312a.e(str));
        builder.setView(viewInflate);
        builder.setPositiveButton(R.string.capture_share, new j(str));
        builder.setNegativeButton(android.R.string.ok, new a());
        builder.show();
    }

    private void z2() {
        this.f5125c0.setContentView(R.layout.dialog_penset);
        this.f5125c0.findViewById(this.f5126d0).setSelected(true);
        this.f5125c0.findViewById(this.f5127e0).setSelected(true);
        Window window = this.f5125c0.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 21;
        attributes.x = AbstractC0316e.b(this, getResources().getDimension(R.dimen.dialog_penset_x));
        n.c(window);
        n.b(window);
        window.setAttributes(attributes);
        this.f5125c0.setCanceledOnTouchOutside(true);
        this.f5125c0.show();
        n.a(window);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        this.f5122Z = (ImageView) findViewById(R.id.eshare_iv_tv_mirror);
        this.f5123a0 = (RelativeLayout) findViewById(R.id.eshare_rl_tv_mirror);
        this.f5147y0 = (NoteView) findViewById(R.id.paintView);
        ImageButton imageButton = (ImageButton) findViewById(R.id.btn_remote_main_finish);
        this.f5114I0 = imageButton;
        imageButton.setOnClickListener(this);
        this.f5125c0 = new Dialog(this, R.style.Dialog);
        o2();
        n2();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_mirror_note;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f5378D = 2;
        n.c(getWindow());
        this.f5117U = Executors.newSingleThreadExecutor();
        EShareAPI eShareAPIInit = EShareAPI.init(this);
        this.f5118V = eShareAPIInit;
        this.f5119W = eShareAPIInit.event();
        this.f5142t0 = EShareAPI.init(this).device();
        this.f5121Y = getIntent().getStringExtra("com.ecloud.eshare.lib.extra.IP_ADDRESS");
        this.f5119W.setNoteMode(true);
        this.f5124b0 = new RectF();
        this.f5134l0 = new ArrayBlockingQueue(2);
        this.f5133k0.setJpgHelperCallback(new c());
        this.f5146x0 = ViewConfiguration.get(this).getScaledTouchSlop();
        this.f5145w0 = ViewConfiguration.getTapTimeout();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
        com.caglobal.kodakluma.view.a aVarE = com.caglobal.kodakluma.view.a.e();
        this.f5138p0 = aVarE;
        aVarE.a(this, R.drawable.icon_arrow_left);
        this.f5139q0 = this.f5138p0.d();
        k kVar = new k();
        this.f5140r0 = kVar;
        this.f5138p0.i(kVar);
        l lVar = new l();
        this.f5141s0 = lVar;
        this.f5138p0.j(lVar);
        if (k2(getApplicationContext())) {
            this.f5115J0 = l2(getApplicationContext());
        } else {
            this.f5115J0 = 0;
        }
        this.f5138p0.g();
        this.f5108C0.setSelected(true);
        this.f5123a0.setOnTouchListener(new d());
    }

    @m
    public void finishSelf(h0.g gVar) {
        if (gVar.a() != h0.g.f6396c) {
            finish();
        }
    }

    public void h2() {
        if (this.f5116T) {
            return;
        }
        this.f5147y0.setVisibility(0);
        this.f5147y0.f();
        this.f5116T = true;
        this.f5109D0.setSelected(true);
        this.f5108C0.setSelected(false);
    }

    public void i2() {
        A2(R.string.capture_title, R.string.capture_message);
        new Thread(new h()).start();
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        int i3;
        int i4;
        switch (view.getId()) {
            case R.id.btn_back_pro /* 2131230822 */:
                if (this.f5142t0.isProDevice() && (i2 = this.f5381G) != 1 && i2 != 3) {
                    Z0.e.h(getApplicationContext(), getString(R.string.host_function_disabled), null, getResources().getColor(R.color.c_666666), getResources().getColor(R.color.white), 0, false, true).show();
                    break;
                } else {
                    u2(4);
                    break;
                }
                break;
            case R.id.btn_eraser /* 2131230825 */:
                this.f5147y0.d();
                this.f5119W.clearNote();
                break;
            case R.id.btn_file /* 2131230826 */:
                if (o.c(this, 1004)) {
                    q2();
                    break;
                }
                break;
            case R.id.btn_home_pro /* 2131230827 */:
                if (this.f5142t0.isProDevice() && (i3 = this.f5381G) != 1 && i3 != 3) {
                    Z0.e.h(getApplicationContext(), getString(R.string.host_function_disabled), null, getResources().getColor(R.color.c_666666), getResources().getColor(R.color.white), 0, false, true).show();
                    break;
                } else {
                    u2(3);
                    break;
                }
                break;
            case R.id.btn_min /* 2131230829 */:
                s2(this.f5120X);
                this.f5138p0.h();
                break;
            case R.id.btn_pen /* 2131230830 */:
                if (this.f5142t0.isProDevice() && (i4 = this.f5381G) != 1 && i4 != 3) {
                    Z0.e.h(getApplicationContext(), getString(R.string.host_function_disabled), null, getResources().getColor(R.color.c_666666), getResources().getColor(R.color.white), 0, false, true).show();
                    break;
                } else {
                    NoteView noteView = this.f5147y0;
                    if (noteView != null && noteView.getVisibility() == 0) {
                        z2();
                        break;
                    } else {
                        h2();
                        break;
                    }
                }
                break;
            case R.id.btn_remote_main_finish /* 2131230831 */:
                finish();
                break;
            case R.id.btn_screen /* 2131230832 */:
                I1(6, new g());
                break;
            case R.id.btn_screen_capture /* 2131230833 */:
                if (o.c(this, 1003)) {
                    i2();
                    break;
                }
                break;
            case R.id.btn_touch /* 2131230834 */:
                r2();
                this.f5147y0.d();
                this.f5119W.clearNote();
                break;
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        f5103K0 = this;
        if (Build.VERSION.SDK_INT >= 34) {
            setRequestedOrientation(5);
        } else {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f5119W.setNoteMode(false);
        com.caglobal.kodakluma.view.a aVar = this.f5138p0;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // androidx.appcompat.app.AbstractActivityC0128c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 25 || i2 == 24) {
            this.f5118V.event().sendKeyEvent(i2);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        int length = iArr.length;
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z2 = true;
                break;
            } else if (iArr[i3] != 0) {
                break;
            } else {
                i3++;
            }
        }
        if (i2 == 1001) {
            if (z2) {
                p2();
            }
        } else if (i2 == 1003) {
            if (z2) {
                i2();
            }
        } else if (i2 == 1004 && z2) {
            q2();
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onStart() throws SocketException {
        super.onStart();
        G2();
        D2();
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onStop() {
        super.onStop();
        G2();
    }

    public void r2() {
        if (this.f5116T) {
            this.f5147y0.setVisibility(8);
            this.f5116T = false;
            this.f5109D0.setSelected(false);
            this.f5108C0.setSelected(true);
        }
    }

    public void u2(int i2) {
        this.f5117U.execute(new i(i2));
    }

    @m
    public void updateMirorrAbility(h0.h hVar) {
        if (hVar.c() == 2) {
            r2();
            Dialog dialog = this.f5125c0;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.f5125c0.cancel();
        }
    }

    public void v2(int i2) {
        Dialog dialog = this.f5125c0;
        if (dialog != null) {
            dialog.cancel();
        }
        this.f5147y0.setPenColor(i2);
    }

    public void w2(int i2) {
        Dialog dialog = this.f5125c0;
        if (dialog != null) {
            dialog.cancel();
        }
        NoteView noteView = this.f5147y0;
        if (noteView != null) {
            noteView.setPenSize(i2);
        }
    }

    public void x2(int i2, boolean z2) {
        Dialog dialog = this.f5125c0;
        if (dialog != null && z2) {
            dialog.findViewById(this.f5126d0).setSelected(false);
            this.f5126d0 = i2;
            this.f5125c0.findViewById(i2).setSelected(true);
        } else {
            if (dialog == null || z2) {
                return;
            }
            dialog.findViewById(this.f5127e0).setSelected(false);
            this.f5127e0 = i2;
            this.f5125c0.findViewById(i2).setSelected(true);
        }
    }
}
