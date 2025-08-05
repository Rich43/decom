package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.appcompat.app.F;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes.dex */
class f extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference f7181a;

    public f(a aVar) {
        super(Looper.getMainLooper());
        this.f7181a = new WeakReference(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = (a) this.f7181a.get();
        if (aVar == null) {
            return;
        }
        if (message.what == -1) {
            aVar.invalidateSelf();
            return;
        }
        Iterator it = aVar.f7143h.iterator();
        if (it.hasNext()) {
            F.a(it.next());
            throw null;
        }
    }
}
