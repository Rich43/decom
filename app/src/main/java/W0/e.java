package W0;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.king.zxing.ViewfinderView;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public class e {

    /* renamed from: z, reason: collision with root package name */
    public static final String f1043z = "e";

    /* renamed from: a, reason: collision with root package name */
    private Activity f1044a;

    /* renamed from: b, reason: collision with root package name */
    private d f1045b;

    /* renamed from: c, reason: collision with root package name */
    private k f1046c;

    /* renamed from: d, reason: collision with root package name */
    private X0.d f1047d;
    private i e;

    /* renamed from: f, reason: collision with root package name */
    private W0.b f1048f;

    /* renamed from: g, reason: collision with root package name */
    private W0.a f1049g;

    /* renamed from: h, reason: collision with root package name */
    private ViewfinderView f1050h;

    /* renamed from: i, reason: collision with root package name */
    private SurfaceHolder f1051i;

    /* renamed from: j, reason: collision with root package name */
    private SurfaceHolder.Callback f1052j;

    /* renamed from: k, reason: collision with root package name */
    private Collection f1053k;

    /* renamed from: l, reason: collision with root package name */
    private Map f1054l;

    /* renamed from: m, reason: collision with root package name */
    private String f1055m;

    /* renamed from: p, reason: collision with root package name */
    private float f1057p;

    /* renamed from: t, reason: collision with root package name */
    private boolean f1059t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f1060u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f1061v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f1062w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f1063x;

    /* renamed from: y, reason: collision with root package name */
    private j f1064y;
    private boolean o = true;

    /* renamed from: q, reason: collision with root package name */
    private boolean f1058q = true;
    private boolean r = false;
    private boolean s = true;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1056n = false;

    class b implements k {
        b() {
        }

        @Override // W0.k
        public void a(z0.m mVar, Bitmap bitmap, float f2) {
            e.this.e.d();
            e.this.f1048f.k();
            e.this.q(mVar);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1067a;

        c(String str) {
            this.f1067a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f1064y == null || !e.this.f1064y.a(this.f1067a)) {
                Intent intent = new Intent();
                intent.putExtra("SCAN_RESULT", this.f1067a);
                e.this.f1044a.setResult(-1, intent);
                e.this.f1044a.finish();
            }
        }
    }

    public e(Activity activity, SurfaceView surfaceView, ViewfinderView viewfinderView) {
        this.f1044a = activity;
        this.f1050h = viewfinderView;
        this.f1051i = surfaceView.getHolder();
    }

    private float h(MotionEvent motionEvent) {
        float x2 = motionEvent.getX(0) - motionEvent.getX(1);
        float y2 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x2 * x2) + (y2 * y2));
    }

    private void l(boolean z2, Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        if (!parameters.isZoomSupported()) {
            Log.i(f1043z, "zoom not supported");
            return;
        }
        int maxZoom = parameters.getMaxZoom();
        int zoom = parameters.getZoom();
        if (z2 && zoom < maxZoom) {
            zoom++;
        } else if (zoom > 0) {
            zoom--;
        }
        parameters.setZoom(zoom);
        camera.setParameters(parameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (this.f1047d.h()) {
            Log.w(f1043z, "initCamera() while already open -- late SurfaceView callback?");
            return;
        }
        try {
            this.f1047d.i(surfaceHolder);
            if (this.f1045b == null) {
                d dVar = new d(this.f1044a, this.f1050h, this.f1046c, this.f1053k, this.f1054l, this.f1055m, this.f1047d);
                this.f1045b = dVar;
                dVar.i(this.f1061v);
                this.f1045b.g(this.f1062w);
                this.f1045b.h(this.f1058q);
            }
        } catch (IOException e) {
            Log.w(f1043z, e);
        } catch (RuntimeException e2) {
            Log.w(f1043z, "Unexpected error initializing camera", e2);
        }
    }

    public e i(boolean z2) {
        this.r = z2;
        return this;
    }

    public e j(Collection collection) {
        this.f1053k = collection;
        return this;
    }

    public X0.d k() {
        return this.f1047d;
    }

    public void n() {
        this.e = new i(this.f1044a);
        this.f1048f = new W0.b(this.f1044a);
        this.f1049g = new W0.a(this.f1044a);
        X0.d dVar = new X0.d(this.f1044a);
        this.f1047d = dVar;
        dVar.k(this.f1063x);
        this.f1052j = new a();
        this.f1046c = new b();
        this.f1048f.l(this.f1059t);
        this.f1048f.m(this.f1060u);
    }

    public void o() {
        this.e.g();
    }

    public void p() throws InterruptedException {
        d dVar = this.f1045b;
        if (dVar != null) {
            dVar.e();
            this.f1045b = null;
        }
        this.e.e();
        this.f1049g.b();
        this.f1048f.close();
        this.f1047d.b();
        if (this.f1056n) {
            return;
        }
        this.f1051i.removeCallback(this.f1052j);
    }

    public void q(z0.m mVar) {
        String strF = mVar.f();
        if (this.r) {
            j jVar = this.f1064y;
            if (jVar != null) {
                jVar.a(strF);
            }
            if (this.s) {
                u();
                return;
            }
            return;
        }
        if (this.f1059t) {
            this.f1045b.postDelayed(new c(strF), 100L);
            return;
        }
        j jVar2 = this.f1064y;
        if (jVar2 == null || !jVar2.a(strF)) {
            Intent intent = new Intent();
            intent.putExtra("SCAN_RESULT", strF);
            this.f1044a.setResult(-1, intent);
            this.f1044a.finish();
        }
    }

    public void r() {
        this.f1048f.o();
        this.f1049g.a(this.f1047d);
        this.e.f();
        this.f1051i.addCallback(this.f1052j);
        if (this.f1056n) {
            m(this.f1051i);
        } else {
            this.f1051i.addCallback(this.f1052j);
        }
    }

    public boolean s(MotionEvent motionEvent) {
        Camera cameraA;
        if (!this.o || !this.f1047d.h() || (cameraA = this.f1047d.f().a()) == null || motionEvent.getPointerCount() <= 1) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 2) {
            float fH = h(motionEvent);
            float f2 = this.f1057p;
            if (fH > f2 + 6.0f) {
                l(true, cameraA);
            } else if (fH < f2 - 6.0f) {
                l(false, cameraA);
            }
            this.f1057p = fH;
        } else if (action == 5) {
            this.f1057p = h(motionEvent);
        }
        return true;
    }

    public e t(boolean z2) {
        this.f1059t = z2;
        W0.b bVar = this.f1048f;
        if (bVar != null) {
            bVar.l(z2);
        }
        return this;
    }

    public void u() {
        d dVar = this.f1045b;
        if (dVar != null) {
            dVar.f();
        }
    }

    public e v(j jVar) {
        this.f1064y = jVar;
        return this;
    }

    public e w(boolean z2) {
        this.f1061v = z2;
        d dVar = this.f1045b;
        if (dVar != null) {
            dVar.i(z2);
        }
        return this;
    }

    public e x(boolean z2) {
        this.f1060u = z2;
        W0.b bVar = this.f1048f;
        if (bVar != null) {
            bVar.m(z2);
        }
        return this;
    }

    class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (surfaceHolder == null) {
                Log.e(e.f1043z, "*** WARNING *** surfaceCreated() gave us a null surface!");
            }
            if (e.this.f1056n) {
                return;
            }
            e.this.f1056n = true;
            e.this.m(surfaceHolder);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            e.this.f1056n = false;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }
    }
}
