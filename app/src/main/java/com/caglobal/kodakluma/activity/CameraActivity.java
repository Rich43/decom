package com.caglobal.kodakluma.activity;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.caglobal.kodakluma.R;
import com.eshare.api.EShareAPI;
import com.eshare.api.IDevice;
import com.eshare.api.IMedia;
import com.eshare.camera.JpgHelper;
import com.eshare.camera.JpgHelperCallback;
import j0.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import q0.InterfaceC0321j;
import q0.o;
import q0.s;
import s1.m;

/* loaded from: classes.dex */
public class CameraActivity extends com.caglobal.kodakluma.activity.a implements View.OnClickListener, InterfaceC0321j, View.OnTouchListener, SensorEventListener {

    /* renamed from: W0 */
    private static Camera f4763W0;

    /* renamed from: X0 */
    private static DatagramSocket f4764X0;

    /* renamed from: Y0 */
    private static h f4765Y0;

    /* renamed from: A0 */
    private SensorManager f4766A0;

    /* renamed from: B0 */
    private Sensor f4767B0;

    /* renamed from: I0 */
    private IMedia f4774I0;

    /* renamed from: J0 */
    private ImageView f4775J0;

    /* renamed from: K0 */
    private Bitmap f4776K0;

    /* renamed from: L0 */
    private int f4777L0;

    /* renamed from: Q0 */
    private double f4782Q0;

    /* renamed from: V0 */
    private TextView f4790V0;

    /* renamed from: W */
    private SurfaceView f4791W;

    /* renamed from: X */
    private SurfaceHolder f4792X;

    /* renamed from: Y */
    private ImageView f4793Y;

    /* renamed from: Z */
    private ImageView f4794Z;

    /* renamed from: a0 */
    private ImageView f4795a0;

    /* renamed from: b0 */
    private View f4796b0;

    /* renamed from: c0 */
    private YuvImage f4797c0;

    /* renamed from: g0 */
    private s f4801g0;

    /* renamed from: h0 */
    private BlockingQueue f4802h0;

    /* renamed from: i0 */
    private JpgHelper f4803i0;

    /* renamed from: k0 */
    private InetAddress f4805k0;

    /* renamed from: m0 */
    private volatile boolean f4807m0;

    /* renamed from: n0 */
    private g f4808n0;

    /* renamed from: o0 */
    private j0.c f4809o0;

    /* renamed from: u0 */
    private IDevice f4815u0;

    /* renamed from: v0 */
    private EShareAPI f4816v0;

    /* renamed from: x0 */
    private boolean f4818x0;

    /* renamed from: y0 */
    private boolean f4819y0;

    /* renamed from: z0 */
    private boolean f4820z0;

    /* renamed from: T */
    private final int f4785T = 3;

    /* renamed from: U */
    private final int f4787U = 1;

    /* renamed from: V */
    Boolean f4789V = Boolean.FALSE;

    /* renamed from: d0 */
    private int f4798d0 = 70;

    /* renamed from: e0 */
    private int f4799e0 = 320;

    /* renamed from: f0 */
    private int f4800f0 = 240;

    /* renamed from: j0 */
    private byte[] f4804j0 = new byte[1450];

    /* renamed from: l0 */
    private volatile boolean f4806l0 = true;

    /* renamed from: p0 */
    private int f4810p0 = 0;

    /* renamed from: q0 */
    private volatile int f4811q0 = 0;

    /* renamed from: r0 */
    private volatile int f4812r0 = 0;

    /* renamed from: s0 */
    private int f4813s0 = 0;

    /* renamed from: t0 */
    private boolean f4814t0 = false;

    /* renamed from: w0 */
    private String f4817w0 = Environment.getExternalStorageDirectory().getAbsolutePath();

    /* renamed from: C0 */
    private boolean f4768C0 = true;

    /* renamed from: D0 */
    private boolean f4769D0 = false;

    /* renamed from: E0 */
    private float f4770E0 = 0.0f;

    /* renamed from: F0 */
    private float f4771F0 = 0.0f;

    /* renamed from: G0 */
    private float f4772G0 = 0.0f;

    /* renamed from: H0 */
    private long f4773H0 = 0;

    /* renamed from: M0 */
    private Camera.PreviewCallback f4778M0 = new a();

    /* renamed from: N0 */
    private Camera.AutoFocusCallback f4779N0 = new b();

    /* renamed from: O0 */
    private Handler f4780O0 = new c();

    /* renamed from: P0 */
    private SurfaceHolder.Callback f4781P0 = new d();

    /* renamed from: R0 */
    private int f4783R0 = 1;

    /* renamed from: S0 */
    private double f4784S0 = 1.0d;

    /* renamed from: T0 */
    private double f4786T0 = 1.0d;

    /* renamed from: U0 */
    private boolean f4788U0 = true;

    class a implements Camera.PreviewCallback {
        a() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraActivity.this.f4797c0 = new YuvImage(bArr, 17, CameraActivity.this.f4799e0, CameraActivity.this.f4800f0, null);
        }
    }

    class b implements Camera.AutoFocusCallback {
        b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z2, Camera camera) {
            CameraActivity.this.f4768C0 = true;
        }
    }

    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws InterruptedException {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2) {
                    CameraActivity.this.finish();
                    return;
                } else {
                    if (i2 != 100) {
                        return;
                    }
                    CameraActivity.this.N2();
                    return;
                }
            }
            File file = new File((String) message.obj);
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.add(file);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((File) it.next()).getName());
            }
            CameraActivity.this.f4774I0.openImagesFromFolder(((File) arrayList.get(0)).getParent(), arrayList2, 0);
            Toast.makeText(CameraActivity.this.getApplicationContext(), (String) message.obj, 0).show();
            CameraActivity.this.f4780O0.sendEmptyMessageDelayed(2, 1000L);
        }
    }

    class d implements SurfaceHolder.Callback {
        d() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            CameraActivity.this.D2(i3, i4);
            CameraActivity.this.M2();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (CameraActivity.f4763W0 != null) {
                CameraActivity.f4763W0.stopPreview();
                CameraActivity.f4763W0.setPreviewCallback(null);
                CameraActivity.f4763W0.release();
                CameraActivity.f4763W0 = null;
            }
            CameraActivity.this.f4797c0 = null;
        }
    }

    class e implements JpgHelperCallback {
        e() {
        }
    }

    class f implements c.a {
        f() {
        }

        @Override // j0.c.a
        public void a(int i2) {
            CameraActivity.this.f4777L0 = i2;
            if (i2 == -1) {
                return;
            }
            if (i2 >= 310 || i2 <= 50) {
                CameraActivity.this.f4793Y.setRotation(0.0f);
                CameraActivity.this.f4794Z.setRotation(0.0f);
                return;
            }
            if (i2 >= 50 && i2 <= 140) {
                CameraActivity.this.f4793Y.setRotation(270.0f);
                CameraActivity.this.f4794Z.setRotation(270.0f);
            } else if (i2 <= 140 || i2 > 220) {
                CameraActivity.this.f4793Y.setRotation(90.0f);
                CameraActivity.this.f4794Z.setRotation(90.0f);
            } else {
                CameraActivity.this.f4793Y.setRotation(180.0f);
                CameraActivity.this.f4794Z.setRotation(180.0f);
            }
        }
    }

    private class g extends OrientationEventListener {
        public g(Context context, int i2) {
            super(context, i2);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i2) {
            if (i2 == -1) {
                return;
            }
            if (Math.abs(i2 - CameraActivity.this.f4813s0) > 44) {
                CameraActivity.this.f4813s0 = i2;
            } else {
                CameraActivity cameraActivity = CameraActivity.this;
                cameraActivity.f4810p0 = CameraActivity.H2(i2, cameraActivity.f4810p0);
            }
        }
    }

    class h extends Thread {

        /* renamed from: a */
        volatile boolean f4828a;

        h() {
        }

        void a() {
            this.f4828a = true;
        }

        /* JADX WARN: Removed duplicated region for block: B:203:0x01b3  */
        /* JADX WARN: Removed duplicated region for block: B:217:0x0205  */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.InterruptedException, java.io.IOException {
            /*
                Method dump skipped, instructions count: 551
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caglobal.kodakluma.activity.CameraActivity.h.run():void");
        }
    }

    private double A2(MotionEvent motionEvent) {
        float fAbs = Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
        float fAbs2 = Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
        return Math.sqrt((fAbs * fAbs) + (fAbs2 * fAbs2));
    }

    private void C2() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            int i3 = cameraInfo.facing;
            if (i3 == 1 || i3 == 0) {
                try {
                    Camera cameraOpen = Camera.open(i2);
                    f4763W0 = cameraOpen;
                    if (cameraOpen != null) {
                        this.f4783R0 = x2();
                        this.f4790V0.setText("× " + ((int) Math.round(this.f4786T0)));
                    }
                    this.f4811q0 = i2;
                    return;
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    public void D2(int i2, int i3) {
        if (f4763W0 == null || this.f4792X.getSurface() == null) {
            return;
        }
        try {
            f4763W0.setPreviewDisplay(this.f4792X);
        } catch (Throwable unused) {
        }
        Camera.Parameters parameters = f4763W0.getParameters();
        Camera.Size sizeZ2 = z2(parameters.getSupportedPreviewSizes(), 1280, 720);
        int i4 = sizeZ2.height;
        this.f4800f0 = i4;
        int i5 = sizeZ2.width;
        this.f4799e0 = i5;
        parameters.setPreviewSize(i5, i4);
        if (this.f4820z0) {
            parameters.setExposureCompensation(0);
            parameters.setFocusMode("continuous-picture");
        }
        if (this.f4818x0) {
            parameters.setFlashMode("torch");
        } else {
            parameters.setFlashMode("off");
        }
        try {
            f4763W0.setParameters(parameters);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void E2() {
        this.f4815u0.stopCameraLive();
    }

    private void F2() {
        this.f4818x0 = true;
        Camera camera = f4763W0;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode("torch");
            try {
                f4763W0.setParameters(parameters);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Bitmap G2(int i2, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmapCreateBitmap != bitmap && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static int H2(int i2, int i3) {
        if (i3 != -1) {
            int iAbs = Math.abs(i2 - i3);
            if (Math.min(iAbs, 360 - iAbs) < 50) {
                return i3;
            }
        }
        return (((i2 + 45) / 90) * 90) % 360;
    }

    private void I2() {
        Camera camera = f4763W0;
        if (camera == null) {
            return;
        }
        String focusMode = camera.getParameters().getFocusMode();
        if (focusMode.equals("auto") || focusMode.equals("macro")) {
            f4763W0.autoFocus(this.f4779N0);
        }
    }

    private void J2() {
        if (f4763W0 != null) {
            f4763W0.setDisplayOrientation(t2(u2(this), this.f4811q0));
        }
    }

    private void K2(int i2) {
        Camera.Parameters parameters = f4763W0.getParameters();
        if (parameters.isZoomSupported()) {
            if (i2 > parameters.getMaxZoom() || i2 < 0) {
                throw new IllegalArgumentException();
            }
            parameters.setZoom(i2);
            f4763W0.setParameters(parameters);
        }
    }

    private void L2() throws SocketException {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.f4801g0, intentFilter, 2);
        } else {
            registerReceiver(this.f4801g0, intentFilter);
        }
        y2(0);
        this.f4815u0.startCameraLive();
        if (this.f4806l0) {
            DatagramSocket datagramSocket = f4764X0;
            if (datagramSocket != null) {
                datagramSocket.disconnect();
                f4764X0.close();
            }
            try {
                DatagramSocket datagramSocket2 = new DatagramSocket();
                f4764X0 = datagramSocket2;
                datagramSocket2.setSendBufferSize(ArrayPool.STANDARD_BUFFER_SIZE_BYTES);
            } catch (SocketException unused) {
            }
            try {
                this.f4805k0 = InetAddress.getByName(this.f4816v0.getIpAddress());
            } catch (UnknownHostException unused2) {
            }
            this.f4806l0 = false;
            h hVar = new h();
            f4765Y0 = hVar;
            hVar.start();
        }
    }

    public void M2() {
        Camera camera = f4763W0;
        if (camera != null) {
            camera.stopPreview();
            f4763W0.setPreviewCallback(this.f4778M0);
            try {
                J2();
                f4763W0.startPreview();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        I2();
    }

    private void p2() {
        this.f4818x0 = false;
        Camera camera = f4763W0;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode("off");
            try {
                f4763W0.setParameters(parameters);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void q2() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1) {
                Camera camera = f4763W0;
                if (camera != null) {
                    camera.stopPreview();
                    f4763W0.setPreviewCallback(null);
                    f4763W0.release();
                    f4763W0 = null;
                }
                try {
                    Camera cameraOpen = Camera.open(i2);
                    f4763W0 = cameraOpen;
                    if (cameraOpen != null) {
                        this.f4783R0 = x2();
                        this.f4790V0.setText("× " + ((int) Math.round(this.f4786T0)));
                    }
                    this.f4811q0 = i2;
                    D2(this.f4799e0, this.f4800f0);
                    M2();
                    this.f4820z0 = true;
                    return;
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static int t2(int i2, int i3) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i3, cameraInfo);
        return cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i2) % 360)) % 360 : ((cameraInfo.orientation - i2) + 360) % 360;
    }

    public static int u2(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }

    private byte[] v2(InputStream inputStream) throws IOException {
        byte[] byteArray = null;
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr);
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            inputStream.close();
            return byteArray;
        } catch (IOException e2) {
            e2.printStackTrace();
            return byteArray;
        }
    }

    private int x2() {
        Camera.Parameters parameters = f4763W0.getParameters();
        if (parameters.isZoomSupported()) {
            return parameters.getMaxZoom();
        }
        return -1;
    }

    private Camera.Size z2(List list, int i2, int i3) {
        double d2 = i2 / i3;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        double dAbs = Double.MAX_VALUE;
        double dAbs2 = Double.MAX_VALUE;
        while (it.hasNext()) {
            Camera.Size size2 = (Camera.Size) it.next();
            if (Math.abs((size2.width / size2.height) - d2) <= 0.05d && Math.abs(size2.height - i3) < dAbs2) {
                dAbs2 = Math.abs(size2.height - i3);
                size = size2;
            }
        }
        if (size == null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Camera.Size size3 = (Camera.Size) it2.next();
                int i4 = i2 * i3;
                if (Math.abs((size3.height * size3.width) - i4) < dAbs) {
                    dAbs = Math.abs((size3.height * size3.width) - i4);
                    size = size3;
                }
            }
        }
        return size;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        this.f4791W = (SurfaceView) findViewById(R.id.cameraview);
        this.f4796b0 = findViewById(R.id.root_view);
        this.f4791W.setOnClickListener(this);
        this.f4791W.setOnTouchListener(this);
        SurfaceHolder holder = this.f4791W.getHolder();
        this.f4792X = holder;
        holder.addCallback(this.f4781P0);
        this.f4792X.setType(3);
        TextView textView = (TextView) findViewById(R.id.tv_camera_zoom);
        this.f4790V0 = textView;
        textView.setText("× " + ((int) Math.round(this.f4786T0)));
        this.f4793Y = (ImageView) findViewById(R.id.light);
        this.f4794Z = (ImageView) findViewById(R.id.switchover);
        this.f4795a0 = (ImageView) findViewById(R.id.image_save);
        this.f4793Y.setOnClickListener(this);
        this.f4794Z.setOnClickListener(this);
        this.f4795a0.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.iv_camera_close);
        this.f4775J0 = imageView;
        imageView.setOnClickListener(this);
    }

    public byte[] B2() {
        return v2(getResources().openRawResource(R.raw.emylive_standby));
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_camera;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f5378D = 1;
        Window window = getWindow();
        window.addFlags(128);
        window.setFlags(1024, 1024);
        this.f4809o0 = new j0.c(this);
        EShareAPI eShareAPIInit = EShareAPI.init(this);
        this.f4816v0 = eShareAPIInit;
        this.f4815u0 = eShareAPIInit.device();
        this.f4774I0 = this.f4816v0.media();
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        this.f4766A0 = sensorManager;
        this.f4767B0 = sensorManager.getDefaultSensor(1);
        this.f4802h0 = new ArrayBlockingQueue(10);
        this.f4801g0 = new s(this);
        JpgHelper jpgHelper = new JpgHelper();
        this.f4803i0 = jpgHelper;
        jpgHelper.setJpgHelperCallback(new e());
        this.f4808n0 = new g(this, 600000);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
        if (this.f4817w0.contains("/emulated/0")) {
            this.f4817w0 = "/sdcard";
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(this.f4817w0 + "/eshare_image");
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        this.f4819y0 = true;
        if (Camera.getNumberOfCameras() < 2) {
            this.f4794Z.setVisibility(8);
        }
        this.f4809o0.a(new f());
    }

    public void N2() {
        Camera camera = f4763W0;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                parameters.setFocusMode("auto");
                f4763W0.setParameters(parameters);
                this.f4768C0 = false;
                f4763W0.autoFocus(this.f4779N0);
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
        this.f4807m0 = true;
    }

    @Override // q0.InterfaceC0321j
    public void c() throws InterruptedException {
        finish();
    }

    @Override // android.app.Activity
    public void finish() throws InterruptedException {
        this.f4806l0 = true;
        h hVar = f4765Y0;
        if (hVar != null) {
            hVar.a();
        }
        try {
            unregisterReceiver(this.f4801g0);
        } catch (Exception unused) {
        }
        if (!this.f4814t0) {
            E2();
            try {
                Thread.sleep(300L);
            } catch (InterruptedException unused2) {
            }
            E2();
            try {
                Thread.sleep(300L);
            } catch (InterruptedException unused3) {
            }
            E2();
            try {
                Thread.sleep(300L);
            } catch (InterruptedException unused4) {
            }
            E2();
        }
        super.finish();
    }

    @m
    public void finishSelf(h0.g gVar) throws InterruptedException {
        if (gVar.a() != h0.g.f6397d) {
            finish();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() throws InterruptedException {
        super.onBackPressed();
        finish();
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) throws InterruptedException {
        switch (view.getId()) {
            case R.id.cameraview /* 2131230839 */:
                Camera camera = f4763W0;
                if (camera != null) {
                    try {
                        Camera.Parameters parameters = camera.getParameters();
                        parameters.setFocusMode("auto");
                        f4763W0.setParameters(parameters);
                        f4763W0.autoFocus(this.f4779N0);
                        break;
                    } catch (RuntimeException e2) {
                        e2.printStackTrace();
                    }
                }
                break;
            case R.id.image_save /* 2131230950 */:
                if (o.c(this, 1001)) {
                    N2();
                    break;
                }
                break;
            case R.id.iv_camera_close /* 2131230960 */:
                finish();
                break;
            case R.id.light /* 2131231047 */:
                if (!this.f4818x0) {
                    F2();
                    this.f4793Y.setImageResource(R.drawable.light_close);
                    break;
                } else {
                    p2();
                    this.f4793Y.setImageResource(R.drawable.light_open);
                    break;
                }
            case R.id.switchover /* 2131231233 */:
                this.f4812r0 = 3;
                this.f4789V = Boolean.valueOf(!this.f4789V.booleanValue());
                if (!this.f4820z0) {
                    this.f4818x0 = false;
                    this.f4793Y.setImageResource(R.drawable.light_open);
                    q2();
                    break;
                } else {
                    this.f4820z0 = false;
                    Camera camera2 = f4763W0;
                    if (camera2 != null) {
                        camera2.stopPreview();
                        f4763W0.setPreviewCallback(null);
                        f4763W0.release();
                        f4763W0 = null;
                    }
                    try {
                        this.f4818x0 = false;
                        this.f4793Y.setImageResource(R.drawable.light_open);
                        Camera cameraOpen = Camera.open();
                        f4763W0 = cameraOpen;
                        if (cameraOpen != null) {
                            this.f4783R0 = x2();
                            this.f4790V0.setText("× " + ((int) Math.round(this.f4786T0)));
                        }
                        this.f4811q0 = 0;
                        D2(this.f4799e0, this.f4800f0);
                        M2();
                        break;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() {
        if (this.f4820z0) {
            f4763W0 = Camera.open();
        }
        Camera camera = f4763W0;
        if (camera != null) {
            camera.stopPreview();
            f4763W0.setPreviewCallback(null);
            f4763W0.release();
            f4763W0 = null;
        }
        this.f4766A0.unregisterListener(this);
        try {
            unregisterReceiver(this.f4801g0);
            g gVar = this.f4808n0;
            if (gVar != null) {
                gVar.disable();
            }
        } catch (Exception unused) {
        }
        h hVar = f4765Y0;
        if (hVar != null && hVar.isAlive()) {
            f4765Y0.a();
        }
        E2();
        g gVar2 = this.f4808n0;
        if (gVar2 != null) {
            gVar2.disable();
            this.f4808n0 = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onPause() {
        this.f4809o0.disable();
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
        if (i2 == 1001 && z2) {
            this.f4780O0.sendEmptyMessage(100);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    public void onResume() throws SocketException, InterruptedException {
        super.onResume();
        this.f4809o0.enable();
        this.f4807m0 = false;
        this.f4766A0.registerListener(this, this.f4767B0, 2);
        g gVar = this.f4808n0;
        if (gVar != null) {
            gVar.enable();
        }
        try {
            if (f4763W0 == null) {
                Camera cameraOpen = Camera.open();
                f4763W0 = cameraOpen;
                if (cameraOpen != null) {
                    this.f4783R0 = x2();
                    this.f4790V0.setText("× " + ((int) Math.round(this.f4786T0)));
                }
            }
        } catch (Exception unused) {
        }
        try {
            if (f4763W0 == null) {
                C2();
            }
        } catch (Exception unused2) {
        }
        Camera camera = f4763W0;
        if (camera != null) {
            try {
                camera.autoFocus(this.f4779N0);
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
        if (f4763W0 == null) {
            this.f4806l0 = false;
            finish();
        }
        if (!this.f4806l0 || this.f4816v0.getIpAddress() == null) {
            return;
        }
        h hVar = f4765Y0;
        if (hVar != null) {
            hVar.a();
        }
        L2();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.f4773H0;
        if (jCurrentTimeMillis - j2 < 3000 || j2 == 0) {
            return;
        }
        this.f4773H0 = jCurrentTimeMillis;
        float[] fArr = sensorEvent.values;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        if (!this.f4769D0) {
            this.f4770E0 = f2;
            this.f4771F0 = f3;
            this.f4772G0 = f4;
            this.f4769D0 = true;
        }
        float fAbs = Math.abs(this.f4770E0 - f2);
        float fAbs2 = Math.abs(this.f4771F0 - f3);
        float fAbs3 = Math.abs(this.f4772G0 - f4);
        if (fAbs > 0.5d && this.f4768C0) {
            this.f4768C0 = false;
            I2();
        }
        if (fAbs2 > 0.5d && this.f4768C0) {
            this.f4768C0 = false;
            I2();
        }
        if (fAbs3 > 0.5d && this.f4768C0) {
            this.f4768C0 = false;
            I2();
        }
        this.f4770E0 = f2;
        this.f4771F0 = f3;
        this.f4772G0 = f4;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4788U0 = true;
        } else if (action != 2) {
            if (action == 5 && motionEvent.getPointerCount() == 2) {
                this.f4782Q0 = A2(motionEvent);
                this.f4788U0 = false;
            }
        } else if (motionEvent.getPointerCount() == 2) {
            double dA2 = A2(motionEvent);
            this.f4784S0 = dA2 / this.f4782Q0;
            if (this.f4788U0) {
                this.f4784S0 = 1.0d;
                this.f4788U0 = false;
            }
            this.f4782Q0 = dA2;
            double d2 = this.f4786T0 * this.f4784S0;
            this.f4786T0 = d2;
            int i2 = this.f4783R0;
            if (d2 > i2) {
                this.f4786T0 = i2;
            } else if (d2 < 1.0d) {
                this.f4786T0 = 1.0d;
            }
            if (f4763W0 != null) {
                K2((int) Math.round(this.f4786T0));
                this.f4790V0.setText("× " + ((int) Math.round(this.f4786T0)));
            }
        }
        return false;
    }

    public Bitmap r2() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.f4797c0.compressToJpeg(new Rect(0, 0, this.f4799e0, this.f4800f0), this.f4798d0, byteArrayOutputStream);
            this.f4776K0 = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return this.f4776K0;
    }

    public byte[] s2() throws IOException {
        byte[] byteArray = null;
        if (this.f4797c0 == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.f4797c0.compressToJpeg(new Rect(0, 0, this.f4799e0, this.f4800f0), this.f4798d0, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e2) {
            e2.printStackTrace();
            return byteArray;
        }
    }

    public byte[] w2(Bitmap bitmap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byteArray = null;
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, this.f4798d0, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e2) {
            e2.printStackTrace();
            return byteArray;
        }
    }

    public void y2(int i2) {
        this.f4802h0.offer(Integer.valueOf(i2));
    }
}
