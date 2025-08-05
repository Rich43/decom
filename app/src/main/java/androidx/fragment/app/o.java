package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import v.AbstractC0345h;

/* loaded from: classes.dex */
public abstract class o extends AbstractC0193k {

    /* renamed from: a */
    private final Activity f3570a;

    /* renamed from: b */
    private final Context f3571b;

    /* renamed from: c */
    private final Handler f3572c;

    /* renamed from: d */
    private final int f3573d;
    final w e;

    o(AbstractActivityC0191i abstractActivityC0191i) {
        this(abstractActivityC0191i, abstractActivityC0191i, new Handler(), 0);
    }

    Activity g() {
        return this.f3570a;
    }

    Context h() {
        return this.f3571b;
    }

    public Handler i() {
        return this.f3572c;
    }

    public abstract void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object k();

    public abstract LayoutInflater l();

    public void o(Fragment fragment, String[] strArr, int i2) {
    }

    public abstract boolean p(String str);

    public void q(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        if (i2 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        androidx.core.content.a.h(this.f3571b, intent, bundle);
    }

    public void t(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        androidx.core.app.b.p(this.f3570a, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public abstract void u();

    o(Activity activity, Context context, Handler handler, int i2) {
        this.e = new x();
        this.f3570a = activity;
        this.f3571b = (Context) AbstractC0345h.g(context, "context == null");
        this.f3572c = (Handler) AbstractC0345h.g(handler, "handler == null");
        this.f3573d = i2;
    }
}
