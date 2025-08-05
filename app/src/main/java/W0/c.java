package W0;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import com.king.zxing.ViewfinderView;

/* loaded from: classes.dex */
public abstract class c extends Activity implements j {

    /* renamed from: a, reason: collision with root package name */
    private SurfaceView f1028a;

    /* renamed from: b, reason: collision with root package name */
    private ViewfinderView f1029b;

    /* renamed from: c, reason: collision with root package name */
    private e f1030c;

    @Override // W0.j
    public boolean a(String str) {
        return false;
    }

    public X0.d b() {
        return this.f1030c.k();
    }

    public e c() {
        return this.f1030c;
    }

    public abstract int d();

    public int e() {
        return m.f1103f;
    }

    public int f() {
        return m.f1104g;
    }

    public void g() {
        this.f1028a = (SurfaceView) findViewById(e());
        this.f1029b = (ViewfinderView) findViewById(f());
        e eVar = new e(this, this.f1028a, this.f1029b);
        this.f1030c = eVar;
        eVar.v(this);
        this.f1030c.n();
    }

    public boolean h(int i2) {
        return true;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int iD = d();
        if (h(iD)) {
            setContentView(iD);
        }
        g();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f1030c.o();
    }

    @Override // android.app.Activity
    public void onPause() throws InterruptedException {
        super.onPause();
        this.f1030c.p();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f1030c.r();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1030c.s(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
