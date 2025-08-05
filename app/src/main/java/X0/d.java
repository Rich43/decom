package X0;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;
import z0.j;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: n, reason: collision with root package name */
    private static final String f1244n = "d";

    /* renamed from: a, reason: collision with root package name */
    private final Context f1245a;

    /* renamed from: b, reason: collision with root package name */
    private final b f1246b;

    /* renamed from: c, reason: collision with root package name */
    private Y0.b f1247c;

    /* renamed from: d, reason: collision with root package name */
    private a f1248d;
    private Rect e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f1249f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1250g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1251h;

    /* renamed from: i, reason: collision with root package name */
    private int f1252i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f1253j;

    /* renamed from: k, reason: collision with root package name */
    private int f1254k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1255l;

    /* renamed from: m, reason: collision with root package name */
    private final f f1256m;

    public d(Context context) {
        this.f1245a = context.getApplicationContext();
        b bVar = new b(context);
        this.f1246b = bVar;
        this.f1256m = new f(bVar);
    }

    public j a(byte[] bArr, int i2, int i3) {
        if (e() == null) {
            return null;
        }
        if (this.f1255l) {
            return new j(bArr, i2, i3, 0, 0, i2, i3, false);
        }
        int iMin = Math.min(i2, i3);
        return new j(bArr, i2, i3, (i2 - iMin) / 2, (i3 - iMin) / 2, iMin, iMin, false);
    }

    public synchronized void b() {
        Y0.b bVar = this.f1247c;
        if (bVar != null) {
            bVar.a().release();
            this.f1247c = null;
            this.e = null;
            this.f1249f = null;
        }
    }

    public Point c() {
        return this.f1246b.b();
    }

    public synchronized Rect d() {
        try {
            if (this.e == null) {
                if (this.f1247c == null) {
                    return null;
                }
                Point pointB = this.f1246b.b();
                if (pointB == null) {
                    return null;
                }
                int i2 = pointB.x;
                int i3 = pointB.y;
                if (this.f1255l) {
                    this.e = new Rect(0, 0, i2, i3);
                } else {
                    int iMin = Math.min(i2, i3);
                    int i4 = (i2 - iMin) / 2;
                    int i5 = (i3 - iMin) / 2;
                    this.e = new Rect(i4, i5, i4 + iMin, iMin + i5);
                }
            }
            return this.e;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized Rect e() {
        if (this.f1249f == null) {
            Rect rectD = d();
            if (rectD == null) {
                return null;
            }
            Rect rect = new Rect(rectD);
            Point pointB = this.f1246b.b();
            Point pointC = this.f1246b.c();
            if (pointB != null && pointC != null) {
                int i2 = rect.left;
                int i3 = pointB.y;
                int i4 = pointC.x;
                rect.left = (i2 * i3) / i4;
                rect.right = (rect.right * i3) / i4;
                int i5 = rect.top;
                int i6 = pointB.x;
                int i7 = pointC.y;
                rect.top = (i5 * i6) / i7;
                rect.bottom = (rect.bottom * i6) / i7;
                this.f1249f = rect;
            }
            return null;
        }
        return this.f1249f;
    }

    public Y0.b f() {
        return this.f1247c;
    }

    public Point g() {
        return this.f1246b.c();
    }

    public synchronized boolean h() {
        return this.f1247c != null;
    }

    public synchronized void i(SurfaceHolder surfaceHolder) {
        int i2;
        try {
            Y0.b bVarA = this.f1247c;
            if (bVarA == null) {
                bVarA = Y0.c.a(this.f1252i);
                if (bVarA == null) {
                    throw new IOException("Camera.open() failed to return object from driver");
                }
                this.f1247c = bVarA;
            }
            if (!this.f1250g) {
                this.f1250g = true;
                this.f1246b.e(bVarA);
                int i3 = this.f1253j;
                if (i3 > 0 && (i2 = this.f1254k) > 0) {
                    l(i3, i2);
                    this.f1253j = 0;
                    this.f1254k = 0;
                }
            }
            Camera cameraA = bVarA.a();
            Camera.Parameters parameters = cameraA.getParameters();
            String strFlatten = parameters == null ? null : parameters.flatten();
            try {
                this.f1246b.g(bVarA, false);
            } catch (RuntimeException unused) {
                String str = f1244n;
                Log.w(str, "Camera rejected parameters. Setting only minimal safe-mode parameters");
                Log.i(str, "Resetting to saved camera params: " + strFlatten);
                if (strFlatten != null) {
                    Camera.Parameters parameters2 = cameraA.getParameters();
                    parameters2.unflatten(strFlatten);
                    try {
                        cameraA.setParameters(parameters2);
                        this.f1246b.g(bVarA, true);
                    } catch (RuntimeException unused2) {
                        Log.w(f1244n, "Camera rejected even safe-mode parameters! No configuration");
                    }
                }
            }
            cameraA.setPreviewDisplay(surfaceHolder);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void j(Handler handler, int i2) {
        Y0.b bVar = this.f1247c;
        if (bVar != null && this.f1251h) {
            this.f1256m.a(handler, i2);
            bVar.a().setOneShotPreviewCallback(this.f1256m);
        }
    }

    public void k(boolean z2) {
        this.f1255l = z2;
    }

    public synchronized void l(int i2, int i3) {
        try {
            if (this.f1250g) {
                Point pointC = this.f1246b.c();
                int i4 = pointC.x;
                if (i2 > i4) {
                    i2 = i4;
                }
                int i5 = pointC.y;
                if (i3 > i5) {
                    i3 = i5;
                }
                int i6 = (i4 - i2) / 2;
                int i7 = (i5 - i3) / 2;
                this.e = new Rect(i6, i7, i2 + i6, i3 + i7);
                Log.d(f1244n, "Calculated manual framing rect: " + this.e);
                this.f1249f = null;
            } else {
                this.f1253j = i2;
                this.f1254k = i3;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void m(boolean z2) {
        try {
            Y0.b bVar = this.f1247c;
            if (bVar != null && z2 != this.f1246b.d(bVar.a())) {
                a aVar = this.f1248d;
                boolean z3 = aVar != null;
                if (z3) {
                    aVar.d();
                    this.f1248d = null;
                }
                this.f1246b.h(bVar.a(), z2);
                if (z3) {
                    a aVar2 = new a(this.f1245a, bVar.a());
                    this.f1248d = aVar2;
                    aVar2.c();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void n() {
        Y0.b bVar = this.f1247c;
        if (bVar != null && !this.f1251h) {
            bVar.a().startPreview();
            this.f1251h = true;
            this.f1248d = new a(this.f1245a, bVar.a());
        }
    }

    public synchronized void o() {
        try {
            a aVar = this.f1248d;
            if (aVar != null) {
                aVar.d();
                this.f1248d = null;
            }
            Y0.b bVar = this.f1247c;
            if (bVar != null && this.f1251h) {
                bVar.a().stopPreview();
                this.f1256m.a(null, 0);
                this.f1251h = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
