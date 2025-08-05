package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final DataSetObservable f4556a = new DataSetObservable();

    /* renamed from: b, reason: collision with root package name */
    private DataSetObserver f4557b;

    public abstract void a(ViewGroup viewGroup, int i2, Object obj);

    public void b(View view) {
    }

    public void c(ViewGroup viewGroup) {
        b(viewGroup);
    }

    public abstract int d();

    public int e(Object obj) {
        return -1;
    }

    public float f(int i2) {
        return 1.0f;
    }

    public abstract Object g(ViewGroup viewGroup, int i2);

    public abstract boolean h(View view, Object obj);

    public void i(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable j() {
        return null;
    }

    public void k(View view, int i2, Object obj) {
    }

    public void l(ViewGroup viewGroup, int i2, Object obj) {
        k(viewGroup, i2, obj);
    }

    void m(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f4557b = dataSetObserver;
        }
    }

    public void n(View view) {
    }

    public void o(ViewGroup viewGroup) {
        n(viewGroup);
    }
}
