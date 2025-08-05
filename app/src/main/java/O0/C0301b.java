package o0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import q0.k;

/* renamed from: o0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0301b {

    /* renamed from: a, reason: collision with root package name */
    private List f6988a;

    /* renamed from: b, reason: collision with root package name */
    private C0098b f6989b;

    /* renamed from: c, reason: collision with root package name */
    private Context f6990c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6991d;

    /* renamed from: o0.b$a */
    public interface a {
        void P(boolean z2);
    }

    /* renamed from: o0.b$b, reason: collision with other inner class name */
    private class C0098b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws Throwable {
            String action = intent.getAction();
            k.a("CastReceiver", action);
            if ("com.eshare.action.mirror.connected".equals(action)) {
                C0301b.this.f6991d = true;
                for (a aVar : C0301b.this.f6988a) {
                    if (aVar != null) {
                        aVar.P(true);
                    }
                }
                return;
            }
            if ("com.eshare.action.mirror.disconnected".equals(action)) {
                C0301b.this.f6991d = false;
                for (a aVar2 : C0301b.this.f6988a) {
                    if (aVar2 != null) {
                        aVar2.P(false);
                    }
                }
            }
        }

        private C0098b() {
        }
    }

    /* renamed from: o0.b$c */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static C0301b f6993a = new C0301b();
    }

    public static C0301b c() {
        return c.f6993a;
    }

    public void d(Context context) {
        this.f6990c = context;
    }

    public void e(a aVar) {
        this.f6988a.add(aVar);
        if (this.f6988a.isEmpty()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.eshare.action.mirror.connected");
        intentFilter.addAction("com.eshare.action.mirror.disconnected");
        C0098b c0098b = new C0098b();
        this.f6989b = c0098b;
        if (Build.VERSION.SDK_INT >= 33) {
            this.f6990c.registerReceiver(c0098b, intentFilter, 2);
        } else {
            this.f6990c.registerReceiver(c0098b, intentFilter);
        }
    }

    public void f(a aVar) {
        this.f6988a.remove(aVar);
        if (this.f6988a.isEmpty()) {
            this.f6990c.unregisterReceiver(this.f6989b);
            this.f6989b = null;
        }
    }

    private C0301b() {
        this.f6988a = new ArrayList();
    }
}
