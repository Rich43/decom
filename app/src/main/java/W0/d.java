package W0;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.king.zxing.ViewfinderView;
import java.util.Collection;
import java.util.Map;
import z0.p;

/* loaded from: classes.dex */
public class d extends Handler implements p {

    /* renamed from: a */
    private final k f1031a;

    /* renamed from: b */
    private final h f1032b;

    /* renamed from: c */
    private a f1033c;

    /* renamed from: d */
    private final X0.d f1034d;
    private final Activity e;

    /* renamed from: f */
    private final ViewfinderView f1035f;

    /* renamed from: g */
    private boolean f1036g;

    /* renamed from: h */
    private boolean f1037h;

    /* renamed from: i */
    private boolean f1038i;

    private enum a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    d(Activity activity, ViewfinderView viewfinderView, k kVar, Collection collection, Map map, String str, X0.d dVar) {
        this.e = activity;
        this.f1035f = viewfinderView;
        this.f1031a = kVar;
        h hVar = new h(activity, dVar, this, collection, map, str, this);
        this.f1032b = hVar;
        hVar.start();
        this.f1033c = a.SUCCESS;
        this.f1034d = dVar;
        dVar.n();
        f();
    }

    private z0.o j(z0.o oVar) {
        float fC;
        float fD;
        int iMax;
        Point pointG = this.f1034d.g();
        Point pointC = this.f1034d.c();
        int i2 = pointG.x;
        int i3 = pointG.y;
        if (i2 < i3) {
            fC = (oVar.c() * ((i2 * 1.0f) / pointC.y)) - (Math.max(pointG.x, pointC.y) / 2);
            fD = oVar.d() * ((i3 * 1.0f) / pointC.x);
            iMax = Math.min(pointG.y, pointC.x) / 2;
        } else {
            fC = (oVar.c() * ((i2 * 1.0f) / pointC.x)) - (Math.min(pointG.y, pointC.y) / 2);
            fD = oVar.d() * ((i3 * 1.0f) / pointC.y);
            iMax = Math.max(pointG.x, pointC.x) / 2;
        }
        return new z0.o(fC, fD - iMax);
    }

    @Override // z0.p
    public void a(z0.o oVar) {
        if (this.f1035f != null) {
            this.f1035f.a(j(oVar));
        }
    }

    public boolean b() {
        return this.f1037h;
    }

    public boolean c() {
        return this.f1038i;
    }

    public boolean d() {
        return this.f1036g;
    }

    public void e() throws InterruptedException {
        this.f1033c = a.DONE;
        this.f1034d.o();
        Message.obtain(this.f1032b.a(), m.f1102d).sendToTarget();
        try {
            this.f1032b.join(500L);
        } catch (InterruptedException unused) {
        }
        removeMessages(m.f1101c);
        removeMessages(m.f1100b);
    }

    public void f() {
        if (this.f1033c == a.SUCCESS) {
            this.f1033c = a.PREVIEW;
            this.f1034d.j(this.f1032b.a(), m.f1099a);
            this.f1035f.j();
        }
    }

    public void g(boolean z2) {
        this.f1037h = z2;
    }

    public void h(boolean z2) {
        this.f1038i = z2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        float f2;
        int i2 = message.what;
        if (i2 == m.e) {
            f();
            return;
        }
        if (i2 != m.f1101c) {
            if (i2 == m.f1100b) {
                this.f1033c = a.PREVIEW;
                this.f1034d.j(this.f1032b.a(), m.f1099a);
                return;
            }
            return;
        }
        this.f1033c = a.SUCCESS;
        Bundle data = message.getData();
        if (data != null) {
            byte[] byteArray = data.getByteArray("barcode_bitmap");
            bitmapCopy = byteArray != null ? BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, null).copy(Bitmap.Config.ARGB_8888, true) : null;
            f2 = data.getFloat("barcode_scaled_factor");
        } else {
            f2 = 1.0f;
        }
        this.f1031a.a((z0.m) message.obj, bitmapCopy, f2);
    }

    public void i(boolean z2) {
        this.f1036g = z2;
    }
}
