package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.VirtualDisplay;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.projection.MediaProjection;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.caglobal.kodakluma.R;
import defpackage.e;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a */
    private q f7228a;

    /* renamed from: b */
    private byte[] f7229b = new byte[524288];

    /* renamed from: c */
    private ByteBuffer f7230c;

    /* renamed from: d */
    private ByteBuffer f7231d;
    private int e;

    /* renamed from: f */
    private MediaProjection f7232f;

    /* renamed from: g */
    private MediaCodec f7233g;

    /* renamed from: h */
    private VirtualDisplay f7234h;

    /* renamed from: i */
    private MediaCodec.BufferInfo f7235i;

    /* renamed from: j */
    private defpackage.e f7236j;

    /* renamed from: k */
    private Surface f7237k;

    /* renamed from: l */
    private String f7238l;

    /* renamed from: m */
    private Context f7239m;

    /* renamed from: n */
    private b f7240n;
    private Socket o;

    /* renamed from: p */
    private int f7241p;

    /* renamed from: q */
    private int f7242q;
    private int r;
    private int s;

    /* renamed from: t */
    private int f7243t;

    class a implements e.c {
        a() {
        }

        @Override // e.c
        public void a() {
            r.this.r();
        }

        @Override // e.c
        public void b(Bitmap bitmap) {
        }
    }

    class b extends Thread {

        /* renamed from: a */
        private volatile boolean f7245a;

        /* renamed from: b */
        private volatile boolean f7246b;

        /* renamed from: c */
        private final long f7247c = 10000;

        public b() {
        }

        private void a() throws IOException {
            if (r.this.o != null) {
                try {
                    r.this.o.close();
                    r.this.o = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void b(long j2) throws InterruptedException {
            try {
                Thread.sleep(j2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private boolean c() throws IOException {
            try {
                r.this.o = new Socket();
                r.this.o.connect(new InetSocketAddress(InetAddress.getByName(r.this.f7238l), 51030), 5000);
                r.this.o.setTcpNoDelay(true);
                r.this.o.setTrafficClass(136);
                r.this.o.setSoTimeout(3000);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        public synchronized void d() {
            try {
                Log.d("eshare", "startRunning begin " + this);
                start();
                while (!this.f7245a) {
                    b(50L);
                }
                Log.d("eshare", "startRunning over " + this);
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized void e() {
            try {
                Log.d("eshare", "stop running...begin " + this);
                if (this.f7245a) {
                    this.f7246b = true;
                    a();
                    while (true) {
                        if (!this.f7246b || r.this.f7236j == null) {
                            break;
                        }
                        Log.d("eshare", "stop running++++begin");
                        if (r.this.f7236j != null) {
                            r.this.f7236j.t();
                            b(50L);
                            break;
                        } else {
                            Log.d("eshare", "stop running++++over");
                            b(50L);
                        }
                    }
                    this.f7245a = false;
                }
                Log.d("eshare", "stop running...over ");
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f7245a = true;
            try {
                try {
                    if (c()) {
                        if (r.this.f7228a != null) {
                            r.this.f7228a.a(0);
                        }
                        while (this.f7245a && !this.f7246b) {
                            r.this.o();
                            r.this.m();
                            r.this.f7236j.s();
                            if (r.this.f7233g != null) {
                                r.this.f7233g.stop();
                                r.this.f7233g.release();
                                r.this.f7233g = null;
                            }
                            if (r.this.f7234h != null) {
                                r.this.f7234h.release();
                                r.this.f7234h = null;
                            }
                        }
                        this.f7246b = false;
                    } else if (r.this.f7228a != null) {
                        r.this.f7228a.a(256);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (r.this.f7228a != null) {
                        r.this.f7228a.a(256);
                    }
                    Log.e("eshare", "encode error");
                    if (r.this.f7236j != null) {
                    }
                }
                if (r.this.f7236j != null) {
                    Log.d("LXP", "%%%%%%%%");
                    r.this.f7236j.t();
                }
                r.this.f7236j = null;
                this.f7246b = false;
                this.f7245a = false;
            } catch (Throwable th) {
                if (r.this.f7236j != null) {
                    Log.d("LXP", "%%%%%%%%");
                    r.this.f7236j.t();
                }
                r.this.f7236j = null;
                this.f7246b = false;
                this.f7245a = false;
                throw th;
            }
        }
    }

    public abstract class c {

        /* renamed from: a */
        public static final int f7249a = 2130903081;

        /* renamed from: b */
        public static final int f7250b = 2130903344;

        /* renamed from: c */
        public static final int f7251c = 2130903465;
    }

    public abstract class d {

        /* renamed from: a */
        public static final int f7252a = 2131099738;

        /* renamed from: b */
        public static final int f7253b = 2131099739;
    }

    public abstract class e {

        /* renamed from: A */
        public static final int f7254A = 2131230752;

        /* renamed from: B */
        public static final int f7255B = 2131230753;

        /* renamed from: C */
        public static final int f7256C = 2131230754;

        /* renamed from: D */
        public static final int f7257D = 2131230755;

        /* renamed from: E */
        public static final int f7258E = 2131230756;

        /* renamed from: F */
        public static final int f7259F = 2131230757;

        /* renamed from: G */
        public static final int f7260G = 2131230758;

        /* renamed from: H */
        public static final int f7261H = 2131231238;

        /* renamed from: I */
        public static final int f7262I = 2131231239;

        /* renamed from: J */
        public static final int f7263J = 2131231240;

        /* renamed from: K */
        public static final int f7264K = 2131231241;

        /* renamed from: L */
        public static final int f7265L = 2131231242;

        /* renamed from: M */
        public static final int f7266M = 2131231243;

        /* renamed from: N */
        public static final int f7267N = 2131231244;

        /* renamed from: O */
        public static final int f7268O = 2131231245;

        /* renamed from: P */
        public static final int f7269P = 2131231246;

        /* renamed from: Q */
        public static final int f7270Q = 2131231248;

        /* renamed from: R */
        public static final int f7271R = 2131231249;

        /* renamed from: S */
        public static final int f7272S = 2131231250;

        /* renamed from: a */
        public static final int f7273a = 2131230726;

        /* renamed from: b */
        public static final int f7274b = 2131230727;

        /* renamed from: c */
        public static final int f7275c = 2131230728;

        /* renamed from: d */
        public static final int f7276d = 2131230729;
        public static final int e = 2131230730;

        /* renamed from: f */
        public static final int f7277f = 2131230731;

        /* renamed from: g */
        public static final int f7278g = 2131230732;

        /* renamed from: h */
        public static final int f7279h = 2131230733;

        /* renamed from: i */
        public static final int f7280i = 2131230734;

        /* renamed from: j */
        public static final int f7281j = 2131230735;

        /* renamed from: k */
        public static final int f7282k = 2131230736;

        /* renamed from: l */
        public static final int f7283l = 2131230737;

        /* renamed from: m */
        public static final int f7284m = 2131230738;

        /* renamed from: n */
        public static final int f7285n = 2131230739;
        public static final int o = 2131230740;

        /* renamed from: p */
        public static final int f7286p = 2131230741;

        /* renamed from: q */
        public static final int f7287q = 2131230742;
        public static final int r = 2131230743;
        public static final int s = 2131230744;

        /* renamed from: t */
        public static final int f7288t = 2131230745;

        /* renamed from: u */
        public static final int f7289u = 2131230746;

        /* renamed from: v */
        public static final int f7290v = 2131230747;

        /* renamed from: w */
        public static final int f7291w = 2131230748;

        /* renamed from: x */
        public static final int f7292x = 2131230749;

        /* renamed from: y */
        public static final int f7293y = 2131230750;

        /* renamed from: z */
        public static final int f7294z = 2131230751;
    }

    public abstract class f {

        /* renamed from: B */
        public static final int f7296B = 0;

        /* renamed from: C */
        public static final int f7297C = 1;

        /* renamed from: D */
        public static final int f7298D = 2;

        /* renamed from: E */
        public static final int f7299E = 3;

        /* renamed from: F */
        public static final int f7300F = 4;

        /* renamed from: G */
        public static final int f7301G = 5;

        /* renamed from: H */
        public static final int f7302H = 6;

        /* renamed from: I */
        public static final int f7303I = 7;

        /* renamed from: J */
        public static final int f7304J = 8;

        /* renamed from: K */
        public static final int f7305K = 9;

        /* renamed from: L */
        public static final int f7306L = 10;

        /* renamed from: M */
        public static final int f7307M = 11;

        /* renamed from: O */
        public static final int f7309O = 0;

        /* renamed from: P */
        public static final int f7310P = 1;

        /* renamed from: c */
        public static final int f7313c = 0;

        /* renamed from: d */
        public static final int f7314d = 1;
        public static final int e = 2;

        /* renamed from: f */
        public static final int f7315f = 3;

        /* renamed from: g */
        public static final int f7316g = 4;

        /* renamed from: i */
        public static final int f7318i = 0;

        /* renamed from: j */
        public static final int f7319j = 1;

        /* renamed from: k */
        public static final int f7320k = 2;

        /* renamed from: l */
        public static final int f7321l = 3;

        /* renamed from: m */
        public static final int f7322m = 4;

        /* renamed from: n */
        public static final int f7323n = 5;
        public static final int o = 6;

        /* renamed from: q */
        public static final int f7325q = 0;
        public static final int r = 1;
        public static final int s = 2;

        /* renamed from: t */
        public static final int f7326t = 3;

        /* renamed from: u */
        public static final int f7327u = 4;

        /* renamed from: v */
        public static final int f7328v = 5;

        /* renamed from: w */
        public static final int f7329w = 6;

        /* renamed from: x */
        public static final int f7330x = 7;

        /* renamed from: y */
        public static final int f7331y = 8;

        /* renamed from: z */
        public static final int f7332z = 9;

        /* renamed from: a */
        public static final int[] f7311a = {R.attr.queryPatterns, R.attr.shortcutMatchRequired};

        /* renamed from: b */
        public static final int[] f7312b = {android.R.attr.color, android.R.attr.alpha, android.R.attr.lStar, R.attr.alpha, R.attr.lStar};

        /* renamed from: h */
        public static final int[] f7317h = {R.attr.fontProviderAuthority, R.attr.fontProviderCerts, R.attr.fontProviderFetchStrategy, R.attr.fontProviderFetchTimeout, R.attr.fontProviderPackage, R.attr.fontProviderQuery, R.attr.fontProviderSystemFontFamily};

        /* renamed from: p */
        public static final int[] f7324p = {android.R.attr.font, android.R.attr.fontWeight, android.R.attr.fontStyle, android.R.attr.ttcIndex, android.R.attr.fontVariationSettings, R.attr.font, R.attr.fontStyle, R.attr.fontVariationSettings, R.attr.fontWeight, R.attr.ttcIndex};

        /* renamed from: A */
        public static final int[] f7295A = {android.R.attr.startColor, android.R.attr.endColor, android.R.attr.type, android.R.attr.centerX, android.R.attr.centerY, android.R.attr.gradientRadius, android.R.attr.tileMode, android.R.attr.centerColor, android.R.attr.startX, android.R.attr.startY, android.R.attr.endX, android.R.attr.endY};

        /* renamed from: N */
        public static final int[] f7308N = {android.R.attr.color, android.R.attr.offset};
    }

    public r(Context context, String str) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(128);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        this.f7230c = byteBufferAllocate.order(byteOrder);
        this.f7231d = ByteBuffer.allocate(8).order(byteOrder);
        this.e = 0;
        this.f7235i = new MediaCodec.BufferInfo();
        this.r = 1920;
        this.s = 1080;
        this.f7243t = 20;
        this.f7238l = str;
        this.f7232f = l.a().c();
        this.f7239m = context;
    }

    private int a() {
        int i2;
        return (this.r * this.s < 2073600 || (i2 = this.f7243t) == 20 || i2 == 30 || i2 != 60) ? 4194304 : 8388608;
    }

    private boolean i(byte[] bArr, int i2, short s, long j2) throws IOException {
        this.f7231d.rewind();
        m.a(j2).b(this.f7231d, 0);
        this.f7230c.rewind();
        this.f7230c.position(0);
        this.f7230c.putInt(i2);
        this.f7230c.putShort(s);
        this.f7230c.putShort((short) 0);
        this.f7230c.put(this.f7231d);
        try {
            this.o.getOutputStream().write(this.f7230c.array());
            if (i2 > 0) {
                this.o.getOutputStream().write(bArr, 0, i2);
            }
            this.o.getOutputStream().flush();
            return true;
        } catch (Exception unused) {
            Log.d("eshare", "send h264 failed");
            return false;
        }
    }

    public void m() throws IOException {
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/avc", this.f7241p, this.f7242q);
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("bitrate", a());
        mediaFormatCreateVideoFormat.setInteger("frame-rate", 20);
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 86400);
        MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f7233g = mediaCodecCreateEncoderByType;
        mediaCodecCreateEncoderByType.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        Surface surfaceCreateInputSurface = this.f7233g.createInputSurface();
        this.f7237k = surfaceCreateInputSurface;
        defpackage.e eVar = new defpackage.e(surfaceCreateInputSurface, this.f7241p, this.f7242q, 20);
        this.f7236j = eVar;
        eVar.f(new a());
        Log.d("LXP", "screen: " + this.f7241p + "   " + this.f7242q);
        this.f7234h = this.f7232f.createVirtualDisplay("screen", this.f7241p, this.f7242q, 1, 1, this.f7236j.l(), null, null);
        this.f7233g.start();
    }

    public boolean o() {
        int i2;
        int i3;
        Display defaultDisplay = ((WindowManager) this.f7239m.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        int i4 = point.x;
        int i5 = point.y;
        if (i4 * i5 >= 2073600) {
            i2 = 1920;
            i3 = 1080;
        } else {
            i2 = i4;
            i3 = i5;
        }
        if (this.f7241p == i2 && this.f7242q == i3) {
            return false;
        }
        this.f7241p = i2;
        this.f7242q = i3;
        Log.d("eshare", "Codec init with " + i2 + " x " + i3 + " " + i4 + " " + i5);
        return true;
    }

    public void r() {
        while (this.f7236j.p()) {
            int iDequeueOutputBuffer = this.f7233g.dequeueOutputBuffer(this.f7235i, 10000L);
            if (iDequeueOutputBuffer == -2) {
                this.f7233g.getOutputFormat();
            } else {
                if (iDequeueOutputBuffer == -1) {
                    return;
                }
                if (iDequeueOutputBuffer >= 0) {
                    f(this.f7235i, this.f7233g.getOutputBuffer(iDequeueOutputBuffer));
                    this.f7233g.releaseOutputBuffer(iDequeueOutputBuffer, false);
                }
            }
            if (o()) {
                Log.d("LXP", "///////");
                Log.d("eshare", "encoder format changed...");
                return;
            }
        }
    }

    protected void f(MediaCodec.BufferInfo bufferInfo, ByteBuffer byteBuffer) {
        int length = this.f7229b.length;
        int i2 = bufferInfo.size;
        if (length < i2) {
            this.f7229b = new byte[i2];
        }
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        byteBuffer.get(this.f7229b, 0, bufferInfo.size);
        long j2 = bufferInfo.presentationTimeUs / 1000;
        if ((bufferInfo.flags & 2) == 2 ? i(this.f7229b, bufferInfo.size, (short) 256, j2) : i(this.f7229b, bufferInfo.size, (short) 257, j2)) {
            return;
        }
        this.e = 259;
        defpackage.e eVar = this.f7236j;
        if (eVar != null) {
            eVar.t();
        }
    }

    public void g(q qVar) {
        this.f7228a = qVar;
    }

    public int j() {
        return this.e;
    }

    public synchronized void q() {
        if (this.f7240n == null) {
            b bVar = new b();
            this.f7240n = bVar;
            bVar.d();
        }
    }

    public synchronized void t() {
        b bVar = this.f7240n;
        if (bVar != null) {
            bVar.e();
            this.f7240n = null;
        }
    }
}
