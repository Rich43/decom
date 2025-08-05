package j0;

import android.content.Context;
import android.view.OrientationEventListener;

/* loaded from: classes.dex */
public class c extends OrientationEventListener {

    /* renamed from: a, reason: collision with root package name */
    private a f6488a;

    public interface a {
        void a(int i2);
    }

    public c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.f6488a = aVar;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i2) {
        this.f6488a.a(i2);
    }
}
