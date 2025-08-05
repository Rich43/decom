package defpackage;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.caglobal.kodakluma.R;
import java.nio.IntBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class e implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: b, reason: collision with root package name */
    private t f5808b;

    /* renamed from: c, reason: collision with root package name */
    private SurfaceTexture f5809c;
    private EGLContext e;

    /* renamed from: f, reason: collision with root package name */
    private EGLContext f5811f;

    /* renamed from: g, reason: collision with root package name */
    private EGLSurface f5812g;

    /* renamed from: h, reason: collision with root package name */
    private EGLSurface f5813h;

    /* renamed from: i, reason: collision with root package name */
    private Surface f5814i;

    /* renamed from: j, reason: collision with root package name */
    private int f5815j;

    /* renamed from: k, reason: collision with root package name */
    private int f5816k;

    /* renamed from: l, reason: collision with root package name */
    private int f5817l;

    /* renamed from: m, reason: collision with root package name */
    private int f5818m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5819n;
    private c o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5820p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f5821q;
    private long r;
    private long s;

    /* renamed from: t, reason: collision with root package name */
    private Handler f5822t;

    /* renamed from: u, reason: collision with root package name */
    private ExecutorService f5823u;

    /* renamed from: v, reason: collision with root package name */
    private int f5824v;

    /* renamed from: a, reason: collision with root package name */
    private final int f5807a = 0;

    /* renamed from: d, reason: collision with root package name */
    private EGLDisplay f5810d = EGL14.EGL_NO_DISPLAY;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 0 || e.this.o == null || message.obj == null) {
                return;
            }
            e.this.o.b((Bitmap) message.obj);
        }
    }

    private class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private int[] f5826a;

        public b(int[] iArr) {
            this.f5826a = iArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f5826a.length];
            for (int i2 = 0; i2 < e.this.f5816k; i2++) {
                int i3 = e.this.f5815j * i2;
                int i4 = ((e.this.f5816k - i2) - 1) * e.this.f5815j;
                for (int i5 = 0; i5 < e.this.f5815j; i5++) {
                    int i6 = this.f5826a[i3 + i5];
                    iArr[i4 + i5] = (i6 & (-16711936)) | ((i6 << 16) & 16711680) | ((i6 >> 16) & 255);
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, e.this.f5815j, e.this.f5816k, Bitmap.Config.ARGB_8888);
            this.f5826a = null;
            e.this.f5822t.obtainMessage(0, bitmapCreateBitmap).sendToTarget();
        }
    }

    public interface c {
        void a();

        void b(Bitmap bitmap);
    }

    public abstract class d {

        /* renamed from: A, reason: collision with root package name */
        public static final int f5828A = 2130903427;

        /* renamed from: B, reason: collision with root package name */
        public static final int f5829B = 2130903474;

        /* renamed from: C, reason: collision with root package name */
        public static final int f5830C = 2130903492;

        /* renamed from: D, reason: collision with root package name */
        public static final int f5831D = 2130903496;

        /* renamed from: E, reason: collision with root package name */
        public static final int f5832E = 2130903508;

        /* renamed from: F, reason: collision with root package name */
        public static final int f5833F = 2130903526;

        /* renamed from: G, reason: collision with root package name */
        public static final int f5834G = 2130903627;

        /* renamed from: H, reason: collision with root package name */
        public static final int f5835H = 2130903628;

        /* renamed from: a, reason: collision with root package name */
        public static final int f5836a = 2130903042;

        /* renamed from: b, reason: collision with root package name */
        public static final int f5837b = 2130903043;

        /* renamed from: c, reason: collision with root package name */
        public static final int f5838c = 2130903045;

        /* renamed from: d, reason: collision with root package name */
        public static final int f5839d = 2130903049;
        public static final int e = 2130903050;

        /* renamed from: f, reason: collision with root package name */
        public static final int f5840f = 2130903064;

        /* renamed from: g, reason: collision with root package name */
        public static final int f5841g = 2130903068;

        /* renamed from: h, reason: collision with root package name */
        public static final int f5842h = 2130903071;

        /* renamed from: i, reason: collision with root package name */
        public static final int f5843i = 2130903072;

        /* renamed from: j, reason: collision with root package name */
        public static final int f5844j = 2130903077;

        /* renamed from: k, reason: collision with root package name */
        public static final int f5845k = 2130903078;

        /* renamed from: l, reason: collision with root package name */
        public static final int f5846l = 2130903079;

        /* renamed from: m, reason: collision with root package name */
        public static final int f5847m = 2130903086;

        /* renamed from: n, reason: collision with root package name */
        public static final int f5848n = 2130903133;
        public static final int o = 2130903148;

        /* renamed from: p, reason: collision with root package name */
        public static final int f5849p = 2130903153;

        /* renamed from: q, reason: collision with root package name */
        public static final int f5850q = 2130903186;
        public static final int r = 2130903188;
        public static final int s = 2130903189;

        /* renamed from: t, reason: collision with root package name */
        public static final int f5851t = 2130903190;

        /* renamed from: u, reason: collision with root package name */
        public static final int f5852u = 2130903191;

        /* renamed from: v, reason: collision with root package name */
        public static final int f5853v = 2130903196;

        /* renamed from: w, reason: collision with root package name */
        public static final int f5854w = 2130903226;

        /* renamed from: x, reason: collision with root package name */
        public static final int f5855x = 2130903242;

        /* renamed from: y, reason: collision with root package name */
        public static final int f5856y = 2130903246;

        /* renamed from: z, reason: collision with root package name */
        public static final int f5857z = 2130903321;
    }

    /* renamed from: e$e, reason: collision with other inner class name */
    public abstract class AbstractC0072e {

        /* renamed from: a, reason: collision with root package name */
        public static final int f5858a = 2130968576;
    }

    public abstract class f {

        /* renamed from: a, reason: collision with root package name */
        public static final int f5859a = 2131034117;

        /* renamed from: b, reason: collision with root package name */
        public static final int f5860b = 2131034118;

        /* renamed from: c, reason: collision with root package name */
        public static final int f5861c = 2131034131;

        /* renamed from: d, reason: collision with root package name */
        public static final int f5862d = 2131034132;
        public static final int e = 2131034133;

        /* renamed from: f, reason: collision with root package name */
        public static final int f5863f = 2131034134;

        /* renamed from: g, reason: collision with root package name */
        public static final int f5864g = 2131034135;

        /* renamed from: h, reason: collision with root package name */
        public static final int f5865h = 2131034136;
    }

    public abstract class g {

        /* renamed from: a, reason: collision with root package name */
        public static final int f5866a = 2131099670;

        /* renamed from: b, reason: collision with root package name */
        public static final int f5867b = 2131099671;

        /* renamed from: c, reason: collision with root package name */
        public static final int f5868c = 2131099707;

        /* renamed from: d, reason: collision with root package name */
        public static final int f5869d = 2131099708;
        public static final int e = 2131099709;

        /* renamed from: f, reason: collision with root package name */
        public static final int f5870f = 2131099910;

        /* renamed from: g, reason: collision with root package name */
        public static final int f5871g = 2131099911;

        /* renamed from: h, reason: collision with root package name */
        public static final int f5872h = 2131099913;

        /* renamed from: i, reason: collision with root package name */
        public static final int f5873i = 2131099914;
    }

    public abstract class h {

        /* renamed from: A, reason: collision with root package name */
        public static final int f5874A = 2131165249;

        /* renamed from: B, reason: collision with root package name */
        public static final int f5875B = 2131165250;

        /* renamed from: C, reason: collision with root package name */
        public static final int f5876C = 2131165251;

        /* renamed from: D, reason: collision with root package name */
        public static final int f5877D = 2131165252;

        /* renamed from: E, reason: collision with root package name */
        public static final int f5878E = 2131165253;

        /* renamed from: F, reason: collision with root package name */
        public static final int f5879F = 2131165254;

        /* renamed from: G, reason: collision with root package name */
        public static final int f5880G = 2131165255;

        /* renamed from: H, reason: collision with root package name */
        public static final int f5881H = 2131165256;

        /* renamed from: I, reason: collision with root package name */
        public static final int f5882I = 2131165257;

        /* renamed from: J, reason: collision with root package name */
        public static final int f5883J = 2131165258;

        /* renamed from: K, reason: collision with root package name */
        public static final int f5884K = 2131165260;

        /* renamed from: L, reason: collision with root package name */
        public static final int f5885L = 2131165261;

        /* renamed from: M, reason: collision with root package name */
        public static final int f5886M = 2131165262;

        /* renamed from: N, reason: collision with root package name */
        public static final int f5887N = 2131165263;

        /* renamed from: O, reason: collision with root package name */
        public static final int f5888O = 2131165264;

        /* renamed from: P, reason: collision with root package name */
        public static final int f5889P = 2131165265;

        /* renamed from: Q, reason: collision with root package name */
        public static final int f5890Q = 2131165266;

        /* renamed from: R, reason: collision with root package name */
        public static final int f5891R = 2131165267;

        /* renamed from: S, reason: collision with root package name */
        public static final int f5892S = 2131165268;

        /* renamed from: a, reason: collision with root package name */
        public static final int f5893a = 2131165191;

        /* renamed from: b, reason: collision with root package name */
        public static final int f5894b = 2131165193;

        /* renamed from: c, reason: collision with root package name */
        public static final int f5895c = 2131165194;

        /* renamed from: d, reason: collision with root package name */
        public static final int f5896d = 2131165195;
        public static final int e = 2131165198;

        /* renamed from: f, reason: collision with root package name */
        public static final int f5897f = 2131165199;

        /* renamed from: g, reason: collision with root package name */
        public static final int f5898g = 2131165200;

        /* renamed from: h, reason: collision with root package name */
        public static final int f5899h = 2131165201;

        /* renamed from: i, reason: collision with root package name */
        public static final int f5900i = 2131165206;

        /* renamed from: j, reason: collision with root package name */
        public static final int f5901j = 2131165207;

        /* renamed from: k, reason: collision with root package name */
        public static final int f5902k = 2131165208;

        /* renamed from: l, reason: collision with root package name */
        public static final int f5903l = 2131165210;

        /* renamed from: m, reason: collision with root package name */
        public static final int f5904m = 2131165211;

        /* renamed from: n, reason: collision with root package name */
        public static final int f5905n = 2131165212;
        public static final int o = 2131165215;

        /* renamed from: p, reason: collision with root package name */
        public static final int f5906p = 2131165217;

        /* renamed from: q, reason: collision with root package name */
        public static final int f5907q = 2131165218;
        public static final int r = 2131165220;
        public static final int s = 2131165221;

        /* renamed from: t, reason: collision with root package name */
        public static final int f5908t = 2131165222;

        /* renamed from: u, reason: collision with root package name */
        public static final int f5909u = 2131165228;

        /* renamed from: v, reason: collision with root package name */
        public static final int f5910v = 2131165239;

        /* renamed from: w, reason: collision with root package name */
        public static final int f5911w = 2131165240;

        /* renamed from: x, reason: collision with root package name */
        public static final int f5912x = 2131165241;

        /* renamed from: y, reason: collision with root package name */
        public static final int f5913y = 2131165242;

        /* renamed from: z, reason: collision with root package name */
        public static final int f5914z = 2131165243;
    }

    public abstract class i {

        /* renamed from: A, reason: collision with root package name */
        public static final int f5915A = 2131231253;

        /* renamed from: B, reason: collision with root package name */
        public static final int f5916B = 2131231254;

        /* renamed from: C, reason: collision with root package name */
        public static final int f5917C = 2131231266;

        /* renamed from: D, reason: collision with root package name */
        public static final int f5918D = 2131231267;

        /* renamed from: E, reason: collision with root package name */
        public static final int f5919E = 2131231268;

        /* renamed from: F, reason: collision with root package name */
        public static final int f5920F = 2131231274;

        /* renamed from: a, reason: collision with root package name */
        public static final int f5921a = 2131230765;

        /* renamed from: b, reason: collision with root package name */
        public static final int f5922b = 2131230766;

        /* renamed from: c, reason: collision with root package name */
        public static final int f5923c = 2131230767;

        /* renamed from: d, reason: collision with root package name */
        public static final int f5924d = 2131230770;
        public static final int e = 2131230771;

        /* renamed from: f, reason: collision with root package name */
        public static final int f5925f = 2131230773;

        /* renamed from: g, reason: collision with root package name */
        public static final int f5926g = 2131230777;

        /* renamed from: h, reason: collision with root package name */
        public static final int f5927h = 2131230779;

        /* renamed from: i, reason: collision with root package name */
        public static final int f5928i = 2131230780;

        /* renamed from: j, reason: collision with root package name */
        public static final int f5929j = 2131230788;

        /* renamed from: k, reason: collision with root package name */
        public static final int f5930k = 2131230835;

        /* renamed from: l, reason: collision with root package name */
        public static final int f5931l = 2131230855;

        /* renamed from: m, reason: collision with root package name */
        public static final int f5932m = 2131230856;

        /* renamed from: n, reason: collision with root package name */
        public static final int f5933n = 2131230858;
        public static final int o = 2131230859;

        /* renamed from: p, reason: collision with root package name */
        public static final int f5934p = 2131230865;

        /* renamed from: q, reason: collision with root package name */
        public static final int f5935q = 2131230924;
        public static final int r = 2131231089;
        public static final int s = 2131231112;

        /* renamed from: t, reason: collision with root package name */
        public static final int f5936t = 2131231184;

        /* renamed from: u, reason: collision with root package name */
        public static final int f5937u = 2131231185;

        /* renamed from: v, reason: collision with root package name */
        public static final int f5938v = 2131231186;

        /* renamed from: w, reason: collision with root package name */
        public static final int f5939w = 2131231201;

        /* renamed from: x, reason: collision with root package name */
        public static final int f5940x = 2131231214;

        /* renamed from: y, reason: collision with root package name */
        public static final int f5941y = 2131231216;

        /* renamed from: z, reason: collision with root package name */
        public static final int f5942z = 2131231227;
    }

    public abstract class j {

        /* renamed from: a, reason: collision with root package name */
        public static final int f5943a = 2131427328;

        /* renamed from: b, reason: collision with root package name */
        public static final int f5944b = 2131427330;

        /* renamed from: c, reason: collision with root package name */
        public static final int f5945c = 2131427331;

        /* renamed from: d, reason: collision with root package name */
        public static final int f5946d = 2131427333;
        public static final int e = 2131427339;

        /* renamed from: f, reason: collision with root package name */
        public static final int f5947f = 2131427340;

        /* renamed from: g, reason: collision with root package name */
        public static final int f5948g = 2131427341;

        /* renamed from: h, reason: collision with root package name */
        public static final int f5949h = 2131427342;

        /* renamed from: i, reason: collision with root package name */
        public static final int f5950i = 2131427343;

        /* renamed from: j, reason: collision with root package name */
        public static final int f5951j = 2131427344;

        /* renamed from: k, reason: collision with root package name */
        public static final int f5952k = 2131427345;

        /* renamed from: l, reason: collision with root package name */
        public static final int f5953l = 2131427346;

        /* renamed from: m, reason: collision with root package name */
        public static final int f5954m = 2131427347;

        /* renamed from: n, reason: collision with root package name */
        public static final int f5955n = 2131427349;
        public static final int o = 2131427350;

        /* renamed from: p, reason: collision with root package name */
        public static final int f5956p = 2131427351;

        /* renamed from: q, reason: collision with root package name */
        public static final int f5957q = 2131427355;
        public static final int r = 2131427481;
    }

    public abstract class k {

        /* renamed from: a, reason: collision with root package name */
        public static final int f5958a = 2131623937;

        /* renamed from: b, reason: collision with root package name */
        public static final int f5959b = 2131623944;

        /* renamed from: c, reason: collision with root package name */
        public static final int f5960c = 2131623945;

        /* renamed from: d, reason: collision with root package name */
        public static final int f5961d = 2131623946;
        public static final int e = 2131623947;

        /* renamed from: f, reason: collision with root package name */
        public static final int f5962f = 2131623948;

        /* renamed from: g, reason: collision with root package name */
        public static final int f5963g = 2131623949;

        /* renamed from: h, reason: collision with root package name */
        public static final int f5964h = 2131623950;

        /* renamed from: i, reason: collision with root package name */
        public static final int f5965i = 2131623951;

        /* renamed from: j, reason: collision with root package name */
        public static final int f5966j = 2131623952;

        /* renamed from: k, reason: collision with root package name */
        public static final int f5967k = 2131623953;
    }

    public abstract class l {

        /* renamed from: a, reason: collision with root package name */
        public static final int f5968a = 2131689476;

        /* renamed from: b, reason: collision with root package name */
        public static final int f5969b = 2131689800;

        /* renamed from: c, reason: collision with root package name */
        public static final int f5970c = 2131689812;

        /* renamed from: d, reason: collision with root package name */
        public static final int f5971d = 2131689813;
    }

    public abstract class m {

        /* renamed from: A, reason: collision with root package name */
        public static final int f5972A = 2;

        /* renamed from: A0, reason: collision with root package name */
        public static final int f5973A0 = 1;
        public static final int A1 = 4;

        /* renamed from: B, reason: collision with root package name */
        public static final int f5974B = 3;

        /* renamed from: B0, reason: collision with root package name */
        public static final int f5975B0 = 86;
        public static final int B1 = 5;
        public static final int B2 = 0;

        /* renamed from: C, reason: collision with root package name */
        public static final int f5976C = 4;

        /* renamed from: C0, reason: collision with root package name */
        public static final int f5977C0 = 116;
        public static final int C1 = 6;
        public static final int C2 = 2;

        /* renamed from: D, reason: collision with root package name */
        public static final int f5978D = 5;

        /* renamed from: D0, reason: collision with root package name */
        public static final int f5979D0 = 117;
        public static final int D1 = 7;
        public static final int D2 = 3;

        /* renamed from: E0, reason: collision with root package name */
        public static final int f5981E0 = 118;
        public static final int E1 = 8;
        public static final int E2 = 4;

        /* renamed from: F0, reason: collision with root package name */
        public static final int f5983F0 = 119;
        public static final int F1 = 9;
        public static final int F2 = 5;

        /* renamed from: G, reason: collision with root package name */
        public static final int f5984G = 0;

        /* renamed from: G0, reason: collision with root package name */
        public static final int f5985G0 = 120;
        public static final int G1 = 10;
        public static final int G2 = 6;

        /* renamed from: H, reason: collision with root package name */
        public static final int f5986H = 1;

        /* renamed from: H0, reason: collision with root package name */
        public static final int f5987H0 = 121;
        public static final int H1 = 11;
        public static final int H2 = 7;

        /* renamed from: I, reason: collision with root package name */
        public static final int f5988I = 2;

        /* renamed from: I0, reason: collision with root package name */
        public static final int f5989I0 = 122;
        public static final int I1 = 12;
        public static final int I2 = 8;

        /* renamed from: J, reason: collision with root package name */
        public static final int f5990J = 3;

        /* renamed from: J0, reason: collision with root package name */
        public static final int f5991J0 = 123;
        public static final int J1 = 13;
        public static final int J2 = 9;

        /* renamed from: K, reason: collision with root package name */
        public static final int f5992K = 4;

        /* renamed from: K0, reason: collision with root package name */
        public static final int f5993K0 = 124;
        public static final int K1 = 14;
        public static final int K2 = 10;

        /* renamed from: L, reason: collision with root package name */
        public static final int f5994L = 5;

        /* renamed from: L0, reason: collision with root package name */
        public static final int f5995L0 = 125;
        public static final int L1 = 15;
        public static final int L2 = 11;

        /* renamed from: M, reason: collision with root package name */
        public static final int f5996M = 6;

        /* renamed from: M0, reason: collision with root package name */
        public static final int f5997M0 = 126;
        public static final int M1 = 16;
        public static final int M2 = 12;

        /* renamed from: N, reason: collision with root package name */
        public static final int f5998N = 7;
        public static final int N1 = 17;
        public static final int N2 = 13;

        /* renamed from: O0, reason: collision with root package name */
        public static final int f6001O0 = 0;
        public static final int O1 = 18;
        public static final int O2 = 14;
        public static final int P1 = 19;
        public static final int P2 = 15;

        /* renamed from: Q, reason: collision with root package name */
        public static final int f6004Q = 1;

        /* renamed from: Q0, reason: collision with root package name */
        public static final int f6005Q0 = 0;
        public static final int Q1 = 20;
        public static final int Q2 = 16;

        /* renamed from: R, reason: collision with root package name */
        public static final int f6006R = 2;

        /* renamed from: R0, reason: collision with root package name */
        public static final int f6007R0 = 1;
        public static final int R1 = 21;
        public static final int R2 = 17;

        /* renamed from: S, reason: collision with root package name */
        public static final int f6008S = 3;

        /* renamed from: S0, reason: collision with root package name */
        public static final int f6009S0 = 2;
        public static final int S1 = 22;
        public static final int S2 = 18;

        /* renamed from: T0, reason: collision with root package name */
        public static final int f6011T0 = 3;
        public static final int T2 = 19;

        /* renamed from: U, reason: collision with root package name */
        public static final int f6012U = 0;
        public static final int U1 = 1;
        public static final int U2 = 20;

        /* renamed from: V, reason: collision with root package name */
        public static final int f6014V = 1;

        /* renamed from: V0, reason: collision with root package name */
        public static final int f6015V0 = 0;
        public static final int V1 = 5;
        public static final int V2 = 21;

        /* renamed from: W, reason: collision with root package name */
        public static final int f6016W = 2;

        /* renamed from: W0, reason: collision with root package name */
        public static final int f6017W0 = 1;
        public static final int W1 = 7;
        public static final int W2 = 22;

        /* renamed from: X, reason: collision with root package name */
        public static final int f6018X = 3;

        /* renamed from: X0, reason: collision with root package name */
        public static final int f6019X0 = 2;
        public static final int X1 = 8;
        public static final int X2 = 23;

        /* renamed from: Y0, reason: collision with root package name */
        public static final int f6021Y0 = 3;
        public static final int Y2 = 24;

        /* renamed from: Z, reason: collision with root package name */
        public static final int f6022Z = 0;
        public static final int Z1 = 0;
        public static final int Z2 = 25;

        /* renamed from: a0, reason: collision with root package name */
        public static final int f6025a0 = 1;
        public static final int a2 = 2;
        public static final int a3 = 26;

        /* renamed from: b, reason: collision with root package name */
        public static final int f6027b = 0;

        /* renamed from: b0, reason: collision with root package name */
        public static final int f6028b0 = 2;

        /* renamed from: b1, reason: collision with root package name */
        public static final int f6029b1 = 0;
        public static final int b3 = 27;

        /* renamed from: c, reason: collision with root package name */
        public static final int f6030c = 1;

        /* renamed from: c0, reason: collision with root package name */
        public static final int f6031c0 = 3;

        /* renamed from: c1, reason: collision with root package name */
        public static final int f6032c1 = 1;
        public static final int c3 = 28;

        /* renamed from: d, reason: collision with root package name */
        public static final int f6033d = 2;

        /* renamed from: d0, reason: collision with root package name */
        public static final int f6034d0 = 4;

        /* renamed from: d1, reason: collision with root package name */
        public static final int f6035d1 = 2;
        public static final int d2 = 0;
        public static final int d3 = 29;
        public static final int e = 3;

        /* renamed from: e0, reason: collision with root package name */
        public static final int f6036e0 = 5;

        /* renamed from: e1, reason: collision with root package name */
        public static final int f6037e1 = 3;
        public static final int e2 = 1;

        /* renamed from: f, reason: collision with root package name */
        public static final int f6038f = 7;

        /* renamed from: f0, reason: collision with root package name */
        public static final int f6039f0 = 6;

        /* renamed from: f1, reason: collision with root package name */
        public static final int f6040f1 = 4;
        public static final int f3 = 0;

        /* renamed from: g, reason: collision with root package name */
        public static final int f6041g = 9;

        /* renamed from: g1, reason: collision with root package name */
        public static final int f6043g1 = 5;
        public static final int g3 = 4;

        /* renamed from: h, reason: collision with root package name */
        public static final int f6044h = 10;

        /* renamed from: h0, reason: collision with root package name */
        public static final int f6045h0 = 1;

        /* renamed from: h1, reason: collision with root package name */
        public static final int f6046h1 = 6;
        public static final int h2 = 0;

        /* renamed from: i, reason: collision with root package name */
        public static final int f6047i = 12;

        /* renamed from: i0, reason: collision with root package name */
        public static final int f6048i0 = 2;

        /* renamed from: i1, reason: collision with root package name */
        public static final int f6049i1 = 7;
        public static final int i2 = 1;
        public static final int i3 = 0;

        /* renamed from: j, reason: collision with root package name */
        public static final int f6050j = 13;

        /* renamed from: j0, reason: collision with root package name */
        public static final int f6051j0 = 3;

        /* renamed from: j1, reason: collision with root package name */
        public static final int f6052j1 = 8;
        public static final int j2 = 2;
        public static final int j3 = 1;

        /* renamed from: k, reason: collision with root package name */
        public static final int f6053k = 14;

        /* renamed from: k0, reason: collision with root package name */
        public static final int f6054k0 = 4;
        public static final int k2 = 3;
        public static final int k3 = 2;

        /* renamed from: l, reason: collision with root package name */
        public static final int f6056l = 15;

        /* renamed from: l0, reason: collision with root package name */
        public static final int f6057l0 = 5;
        public static final int l2 = 4;

        /* renamed from: m, reason: collision with root package name */
        public static final int f6059m = 17;

        /* renamed from: m0, reason: collision with root package name */
        public static final int f6060m0 = 6;

        /* renamed from: m1, reason: collision with root package name */
        public static final int f6061m1 = 0;
        public static final int m3 = 0;

        /* renamed from: n, reason: collision with root package name */
        public static final int f6062n = 20;

        /* renamed from: n0, reason: collision with root package name */
        public static final int f6063n0 = 7;

        /* renamed from: n1, reason: collision with root package name */
        public static final int f6064n1 = 1;
        public static final int n3 = 1;
        public static final int o = 22;

        /* renamed from: o0, reason: collision with root package name */
        public static final int f6065o0 = 8;
        public static final int o2 = 0;
        public static final int o3 = 2;

        /* renamed from: p, reason: collision with root package name */
        public static final int f6067p = 25;

        /* renamed from: p0, reason: collision with root package name */
        public static final int f6068p0 = 9;

        /* renamed from: p1, reason: collision with root package name */
        public static final int f6069p1 = 0;
        public static final int p2 = 1;

        /* renamed from: q, reason: collision with root package name */
        public static final int f6070q = 26;

        /* renamed from: q0, reason: collision with root package name */
        public static final int f6071q0 = 10;

        /* renamed from: q1, reason: collision with root package name */
        public static final int f6072q1 = 1;
        public static final int q2 = 2;
        public static final int r = 27;

        /* renamed from: r0, reason: collision with root package name */
        public static final int f6073r0 = 11;

        /* renamed from: r1, reason: collision with root package name */
        public static final int f6074r1 = 2;
        public static final int r2 = 3;
        public static final int s = 28;

        /* renamed from: s0, reason: collision with root package name */
        public static final int f6075s0 = 12;

        /* renamed from: s1, reason: collision with root package name */
        public static final int f6076s1 = 3;
        public static final int s2 = 4;

        /* renamed from: t0, reason: collision with root package name */
        public static final int f6078t0 = 13;

        /* renamed from: t1, reason: collision with root package name */
        public static final int f6079t1 = 4;
        public static final int t2 = 5;

        /* renamed from: u, reason: collision with root package name */
        public static final int f6080u = 0;

        /* renamed from: u0, reason: collision with root package name */
        public static final int f6081u0 = 14;

        /* renamed from: u1, reason: collision with root package name */
        public static final int f6082u1 = 5;
        public static final int u2 = 10;

        /* renamed from: v0, reason: collision with root package name */
        public static final int f6084v0 = 15;
        public static final int v2 = 11;

        /* renamed from: w, reason: collision with root package name */
        public static final int f6085w = 0;

        /* renamed from: w0, reason: collision with root package name */
        public static final int f6086w0 = 18;
        public static final int w1 = 0;
        public static final int w2 = 12;

        /* renamed from: x0, reason: collision with root package name */
        public static final int f6088x0 = 19;
        public static final int x1 = 1;
        public static final int x2 = 13;
        public static final int y1 = 2;
        public static final int y2 = 14;

        /* renamed from: z, reason: collision with root package name */
        public static final int f6091z = 0;

        /* renamed from: z0, reason: collision with root package name */
        public static final int f6092z0 = 0;
        public static final int z1 = 3;
        public static final int z2 = 15;

        /* renamed from: a, reason: collision with root package name */
        public static final int[] f6024a = {R.attr.background, R.attr.backgroundSplit, R.attr.backgroundStacked, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.customNavigationLayout, R.attr.displayOptions, R.attr.divider, R.attr.elevation, R.attr.height, R.attr.hideOnContentScroll, R.attr.homeAsUpIndicator, R.attr.homeLayout, R.attr.icon, R.attr.indeterminateProgressStyle, R.attr.itemPadding, R.attr.logo, R.attr.navigationMode, R.attr.popupTheme, R.attr.progressBarPadding, R.attr.progressBarStyle, R.attr.subtitle, R.attr.subtitleTextStyle, R.attr.title, R.attr.titleTextStyle};

        /* renamed from: t, reason: collision with root package name */
        public static final int[] f6077t = {android.R.attr.layout_gravity};

        /* renamed from: v, reason: collision with root package name */
        public static final int[] f6083v = {android.R.attr.minWidth};

        /* renamed from: x, reason: collision with root package name */
        public static final int[] f6087x = new int[0];

        /* renamed from: y, reason: collision with root package name */
        public static final int[] f6089y = {R.attr.background, R.attr.backgroundSplit, R.attr.closeItemLayout, R.attr.height, R.attr.subtitleTextStyle, R.attr.titleTextStyle};

        /* renamed from: E, reason: collision with root package name */
        public static final int[] f5980E = {R.attr.expandActivityOverflowButtonDrawable, R.attr.initialActivityCount};

        /* renamed from: F, reason: collision with root package name */
        public static final int[] f5982F = {android.R.attr.layout, R.attr.buttonIconDimen, R.attr.buttonPanelSideLayout, R.attr.listItemLayout, R.attr.listLayout, R.attr.multiChoiceItemLayout, R.attr.showTitle, R.attr.singleChoiceItemLayout};

        /* renamed from: O, reason: collision with root package name */
        public static final int[] f6000O = new int[0];

        /* renamed from: P, reason: collision with root package name */
        public static final int[] f6002P = {android.R.attr.src, R.attr.srcCompat, R.attr.tint, R.attr.tintMode};

        /* renamed from: T, reason: collision with root package name */
        public static final int[] f6010T = {android.R.attr.thumb, R.attr.tickMark, R.attr.tickMarkTint, R.attr.tickMarkTintMode};

        /* renamed from: Y, reason: collision with root package name */
        public static final int[] f6020Y = {android.R.attr.textAppearance, android.R.attr.drawableTop, android.R.attr.drawableBottom, android.R.attr.drawableLeft, android.R.attr.drawableRight, android.R.attr.drawableStart, android.R.attr.drawableEnd};

        /* renamed from: g0, reason: collision with root package name */
        public static final int[] f6042g0 = {android.R.attr.textAppearance, R.attr.autoSizeMaxTextSize, R.attr.autoSizeMinTextSize, R.attr.autoSizePresetSizes, R.attr.autoSizeStepGranularity, R.attr.autoSizeTextType, R.attr.drawableBottomCompat, R.attr.drawableEndCompat, R.attr.drawableLeftCompat, R.attr.drawableRightCompat, R.attr.drawableStartCompat, R.attr.drawableTint, R.attr.drawableTintMode, R.attr.drawableTopCompat, R.attr.emojiCompatEnabled, R.attr.firstBaselineToTopHeight, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.lastBaselineToBottomHeight, R.attr.lineHeight, R.attr.textAllCaps, R.attr.textLocale};

        /* renamed from: y0, reason: collision with root package name */
        public static final int[] f6090y0 = {android.R.attr.windowIsFloating, android.R.attr.windowAnimationStyle, R.attr.actionBarDivider, R.attr.actionBarItemBackground, R.attr.actionBarPopupTheme, R.attr.actionBarSize, R.attr.actionBarSplitStyle, R.attr.actionBarStyle, R.attr.actionBarTabBarStyle, R.attr.actionBarTabStyle, R.attr.actionBarTabTextStyle, R.attr.actionBarTheme, R.attr.actionBarWidgetTheme, R.attr.actionButtonStyle, R.attr.actionDropDownStyle, R.attr.actionMenuTextAppearance, R.attr.actionMenuTextColor, R.attr.actionModeBackground, R.attr.actionModeCloseButtonStyle, R.attr.actionModeCloseContentDescription, R.attr.actionModeCloseDrawable, R.attr.actionModeCopyDrawable, R.attr.actionModeCutDrawable, R.attr.actionModeFindDrawable, R.attr.actionModePasteDrawable, R.attr.actionModePopupWindowStyle, R.attr.actionModeSelectAllDrawable, R.attr.actionModeShareDrawable, R.attr.actionModeSplitBackground, R.attr.actionModeStyle, R.attr.actionModeTheme, R.attr.actionModeWebSearchDrawable, R.attr.actionOverflowButtonStyle, R.attr.actionOverflowMenuStyle, R.attr.activityChooserViewStyle, R.attr.alertDialogButtonGroupStyle, R.attr.alertDialogCenterButtons, R.attr.alertDialogStyle, R.attr.alertDialogTheme, R.attr.autoCompleteTextViewStyle, R.attr.borderlessButtonStyle, R.attr.buttonBarButtonStyle, R.attr.buttonBarNegativeButtonStyle, R.attr.buttonBarNeutralButtonStyle, R.attr.buttonBarPositiveButtonStyle, R.attr.buttonBarStyle, R.attr.buttonStyle, R.attr.buttonStyleSmall, R.attr.checkboxStyle, R.attr.checkedTextViewStyle, R.attr.colorAccent, R.attr.colorBackgroundFloating, R.attr.colorButtonNormal, R.attr.colorControlActivated, R.attr.colorControlHighlight, R.attr.colorControlNormal, R.attr.colorError, R.attr.colorPrimary, R.attr.colorPrimaryDark, R.attr.colorSwitchThumbNormal, R.attr.controlBackground, R.attr.dialogCornerRadius, R.attr.dialogPreferredPadding, R.attr.dialogTheme, R.attr.dividerHorizontal, R.attr.dividerVertical, R.attr.dropDownListViewStyle, R.attr.dropdownListPreferredItemHeight, R.attr.editTextBackground, R.attr.editTextColor, R.attr.editTextStyle, R.attr.homeAsUpIndicator, R.attr.imageButtonStyle, R.attr.listChoiceBackgroundIndicator, R.attr.listChoiceIndicatorMultipleAnimated, R.attr.listChoiceIndicatorSingleAnimated, R.attr.listDividerAlertDialog, R.attr.listMenuViewStyle, R.attr.listPopupWindowStyle, R.attr.listPreferredItemHeight, R.attr.listPreferredItemHeightLarge, R.attr.listPreferredItemHeightSmall, R.attr.listPreferredItemPaddingEnd, R.attr.listPreferredItemPaddingLeft, R.attr.listPreferredItemPaddingRight, R.attr.listPreferredItemPaddingStart, R.attr.panelBackground, R.attr.panelMenuListTheme, R.attr.panelMenuListWidth, R.attr.popupMenuStyle, R.attr.popupWindowStyle, R.attr.radioButtonStyle, R.attr.ratingBarStyle, R.attr.ratingBarStyleIndicator, R.attr.ratingBarStyleSmall, R.attr.searchViewStyle, R.attr.seekBarStyle, R.attr.selectableItemBackground, R.attr.selectableItemBackgroundBorderless, R.attr.spinnerDropDownItemStyle, R.attr.spinnerStyle, R.attr.switchStyle, R.attr.textAppearanceLargePopupMenu, R.attr.textAppearanceListItem, R.attr.textAppearanceListItemSecondary, R.attr.textAppearanceListItemSmall, R.attr.textAppearancePopupMenuHeader, R.attr.textAppearanceSearchResultSubtitle, R.attr.textAppearanceSearchResultTitle, R.attr.textAppearanceSmallPopupMenu, R.attr.textColorAlertDialogListItem, R.attr.textColorSearchUrl, R.attr.toolbarNavigationButtonStyle, R.attr.toolbarStyle, R.attr.tooltipForegroundColor, R.attr.tooltipFrameBackground, R.attr.viewInflaterClass, R.attr.windowActionBar, R.attr.windowActionBarOverlay, R.attr.windowActionModeOverlay, R.attr.windowFixedHeightMajor, R.attr.windowFixedHeightMinor, R.attr.windowFixedWidthMajor, R.attr.windowFixedWidthMinor, R.attr.windowMinWidthMajor, R.attr.windowMinWidthMinor, R.attr.windowNoTitle};

        /* renamed from: N0, reason: collision with root package name */
        public static final int[] f5999N0 = {R.attr.allowStacking};

        /* renamed from: P0, reason: collision with root package name */
        public static final int[] f6003P0 = {android.R.attr.checkMark, R.attr.checkMarkCompat, R.attr.checkMarkTint, R.attr.checkMarkTintMode};

        /* renamed from: U0, reason: collision with root package name */
        public static final int[] f6013U0 = {android.R.attr.button, R.attr.buttonCompat, R.attr.buttonTint, R.attr.buttonTintMode};

        /* renamed from: Z0, reason: collision with root package name */
        public static final int[] f6023Z0 = {R.attr.arrowHeadLength, R.attr.arrowShaftLength, R.attr.barLength, R.attr.color, R.attr.drawableSize, R.attr.gapBetweenBars, R.attr.spinBars, R.attr.thickness};

        /* renamed from: a1, reason: collision with root package name */
        public static final int[] f6026a1 = {android.R.attr.gravity, android.R.attr.orientation, android.R.attr.baselineAligned, android.R.attr.baselineAlignedChildIndex, android.R.attr.weightSum, R.attr.divider, R.attr.dividerPadding, R.attr.measureWithLargestChild, R.attr.showDividers};

        /* renamed from: k1, reason: collision with root package name */
        public static final int[] f6055k1 = {android.R.attr.layout_gravity, android.R.attr.layout_width, android.R.attr.layout_height, android.R.attr.layout_weight};

        /* renamed from: l1, reason: collision with root package name */
        public static final int[] f6058l1 = {android.R.attr.dropDownHorizontalOffset, android.R.attr.dropDownVerticalOffset};

        /* renamed from: o1, reason: collision with root package name */
        public static final int[] f6066o1 = {android.R.attr.enabled, android.R.attr.id, android.R.attr.visible, android.R.attr.menuCategory, android.R.attr.orderInCategory, android.R.attr.checkableBehavior};
        public static final int[] v1 = {android.R.attr.icon, android.R.attr.enabled, android.R.attr.id, android.R.attr.checked, android.R.attr.visible, android.R.attr.menuCategory, android.R.attr.orderInCategory, android.R.attr.title, android.R.attr.titleCondensed, android.R.attr.alphabeticShortcut, android.R.attr.numericShortcut, android.R.attr.checkable, android.R.attr.onClick, R.attr.actionLayout, R.attr.actionProviderClass, R.attr.actionViewClass, R.attr.alphabeticModifiers, R.attr.contentDescription, R.attr.iconTint, R.attr.iconTintMode, R.attr.numericModifiers, R.attr.showAsAction, R.attr.tooltipText};
        public static final int[] T1 = {android.R.attr.windowAnimationStyle, android.R.attr.itemTextAppearance, android.R.attr.horizontalDivider, android.R.attr.verticalDivider, android.R.attr.headerBackground, android.R.attr.itemBackground, android.R.attr.itemIconDisabledAlpha, R.attr.preserveIconSpacing, R.attr.subMenuArrow};
        public static final int[] Y1 = {android.R.attr.popupBackground, android.R.attr.popupAnimationStyle, R.attr.overlapAnchor};
        public static final int[] b2 = {R.attr.state_above_anchor};
        public static final int[] c2 = {R.attr.paddingBottomNoButtons, R.attr.paddingTopNoTitle};
        public static final int[] f2 = {android.R.attr.focusable, android.R.attr.maxWidth, android.R.attr.inputType, android.R.attr.imeOptions, R.attr.closeIcon, R.attr.commitIcon, R.attr.defaultQueryHint, R.attr.goIcon, R.attr.iconifiedByDefault, R.attr.layout, R.attr.queryBackground, R.attr.queryHint, R.attr.searchHintIcon, R.attr.searchIcon, R.attr.submitBackground, R.attr.suggestionRowLayout, R.attr.voiceIcon};
        public static final int[] g2 = {android.R.attr.entries, android.R.attr.popupBackground, android.R.attr.prompt, android.R.attr.dropDownWidth, R.attr.popupTheme};
        public static final int[] m2 = {android.R.attr.textOn, android.R.attr.textOff, android.R.attr.thumb, R.attr.showText, R.attr.splitTrack, R.attr.switchMinWidth, R.attr.switchPadding, R.attr.switchTextAppearance, R.attr.thumbTextPadding, R.attr.thumbTint, R.attr.thumbTintMode, R.attr.track, R.attr.trackTint, R.attr.trackTintMode};
        public static final int[] n2 = {android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.textColor, android.R.attr.textColorHint, android.R.attr.textColorLink, android.R.attr.shadowColor, android.R.attr.shadowDx, android.R.attr.shadowDy, android.R.attr.shadowRadius, android.R.attr.fontFamily, android.R.attr.textFontWeight, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.textAllCaps, R.attr.textLocale};
        public static final int[] A2 = {android.R.attr.gravity, android.R.attr.minHeight, R.attr.buttonGravity, R.attr.collapseContentDescription, R.attr.collapseIcon, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.logo, R.attr.logoDescription, R.attr.maxButtonHeight, R.attr.menu, R.attr.navigationContentDescription, R.attr.navigationIcon, R.attr.popupTheme, R.attr.subtitle, R.attr.subtitleTextAppearance, R.attr.subtitleTextColor, R.attr.title, R.attr.titleMargin, R.attr.titleMarginBottom, R.attr.titleMarginEnd, R.attr.titleMarginStart, R.attr.titleMarginTop, R.attr.titleMargins, R.attr.titleTextAppearance, R.attr.titleTextColor};
        public static final int[] e3 = {android.R.attr.theme, android.R.attr.focusable, R.attr.paddingEnd, R.attr.paddingStart, R.attr.theme};
        public static final int[] h3 = {android.R.attr.background, R.attr.backgroundTint, R.attr.backgroundTintMode};
        public static final int[] l3 = {android.R.attr.id, android.R.attr.layout, android.R.attr.inflatedId};
    }

    public e(Surface surface, int i2, int i3, int i4) {
        EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
        this.e = eGLContext;
        this.f5811f = eGLContext;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        this.f5812g = eGLSurface;
        this.f5813h = eGLSurface;
        this.f5819n = true;
        this.f5820p = false;
        this.r = 0L;
        this.f5822t = new a(Looper.getMainLooper());
        this.f5823u = Executors.newSingleThreadExecutor();
        this.f5824v = 1;
        this.f5815j = i2;
        this.f5816k = i3;
        j(i4);
        e(surface);
        q();
        r();
    }

    private EGLConfig a(int i2) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f5810d, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w("EncodeDecodeSurface", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    private void d(long j2) throws InterruptedException {
        try {
            TimeUnit.MILLISECONDS.sleep(j2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void e(Surface surface) {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.f5810d = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            this.f5810d = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f5810d, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        EGLConfig eGLConfigA = a(2);
        int[] iArr2 = {12440, 2, 12344};
        this.e = EGL14.eglCreateContext(this.f5810d, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, iArr2, 0);
        g("eglCreateContext");
        EGLContext eGLContext = this.e;
        if (eGLContext == null) {
            throw new RuntimeException("null context");
        }
        this.f5811f = EGL14.eglCreateContext(this.f5810d, eGLConfigA, eGLContext, iArr2, 0);
        g("eglCreateContext");
        if (this.f5811f == null) {
            throw new RuntimeException("null context2");
        }
        this.f5812g = EGL14.eglCreatePbufferSurface(this.f5810d, eGLConfigArr[0], new int[]{12375, this.f5815j, 12374, this.f5816k, 12344}, 0);
        g("eglCreatePbufferSurface");
        if (this.f5812g == null) {
            throw new RuntimeException("surface was null");
        }
        this.f5813h = EGL14.eglCreateWindowSurface(this.f5810d, eGLConfigA, surface, new int[]{12344}, 0);
        g("eglCreateWindowSurface");
        if (this.f5813h == null) {
            throw new RuntimeException("surface was null");
        }
    }

    private void g(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }

    private void j(int i2) {
        this.f5817l = i2;
        this.f5818m = 1000 / i2;
    }

    private void o() {
        IntBuffer intBufferAllocate = IntBuffer.allocate(this.f5815j * this.f5816k);
        intBufferAllocate.position(0);
        GLES20.glReadPixels(0, 0, this.f5815j, this.f5816k, 6408, 5121, intBufferAllocate);
        int[] iArrArray = intBufferAllocate.array();
        intBufferAllocate.clear();
        this.f5823u.execute(new b(iArrArray));
    }

    private void r() {
        t tVar = new t(this.f5815j, this.f5816k);
        this.f5808b = tVar;
        tVar.d();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f5808b.b());
        this.f5809c = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(this.f5815j, this.f5816k);
        this.f5809c.setOnFrameAvailableListener(this);
        this.f5814i = new Surface(this.f5809c);
    }

    public void c() {
        if (this.f5819n) {
            this.f5819n = false;
            this.f5809c.updateTexImage();
        }
    }

    public void f(c cVar) {
        this.o = cVar;
    }

    public void i() {
        this.f5808b.a();
    }

    public Surface l() {
        return this.f5814i;
    }

    public void m(int i2) {
        if (i2 == 0) {
            EGLDisplay eGLDisplay = this.f5810d;
            EGLSurface eGLSurface = this.f5812g;
            if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.e)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
            return;
        }
        EGLDisplay eGLDisplay2 = this.f5810d;
        EGLSurface eGLSurface2 = this.f5813h;
        if (!EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface2, eGLSurface2, this.f5811f)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f5819n = true;
    }

    public boolean p() {
        return this.f5821q;
    }

    public void q() {
        EGLDisplay eGLDisplay = this.f5810d;
        EGLSurface eGLSurface = this.f5812g;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.e)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void s() throws InterruptedException {
        this.f5821q = true;
        while (this.f5821q) {
            m(1);
            c();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.s = jCurrentTimeMillis;
            long j2 = jCurrentTimeMillis - this.r;
            long j3 = this.f5818m;
            if (j2 >= j3) {
                i();
                u();
                this.o.a();
                if (this.f5820p) {
                    o();
                    this.f5820p = false;
                }
                this.r = this.s;
            } else {
                long j4 = j3 - j2;
                if (j4 > 0 && j4 < j3) {
                    d(j4);
                }
            }
        }
        if (this.f5808b != null) {
            EGLDisplay eGLDisplay = this.f5810d;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.f5810d, this.f5812g);
            EGL14.eglDestroyContext(this.f5810d, this.e);
            EGL14.eglDestroySurface(this.f5810d, this.f5813h);
            EGL14.eglDestroyContext(this.f5810d, this.f5811f);
            EGL14.eglTerminate(this.f5810d);
        }
    }

    public void t() {
        this.f5821q = false;
        Log.d("eshare", "stop capture..." + this);
    }

    public boolean u() {
        boolean zEglSwapBuffers = EGL14.eglSwapBuffers(this.f5810d, this.f5813h);
        g("eglSwapBuffers");
        return zEglSwapBuffers;
    }
}
