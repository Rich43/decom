package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import defpackage.r;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class k {

    public static class a {
    }

    public static final class b {
        public static Notification.BubbleMetadata a(b bVar) {
            return null;
        }
    }

    public static class c {

        /* renamed from: A, reason: collision with root package name */
        boolean f2878A;

        /* renamed from: B, reason: collision with root package name */
        String f2879B;

        /* renamed from: C, reason: collision with root package name */
        Bundle f2880C;

        /* renamed from: F, reason: collision with root package name */
        Notification f2883F;

        /* renamed from: G, reason: collision with root package name */
        RemoteViews f2884G;

        /* renamed from: H, reason: collision with root package name */
        RemoteViews f2885H;

        /* renamed from: I, reason: collision with root package name */
        RemoteViews f2886I;

        /* renamed from: J, reason: collision with root package name */
        String f2887J;

        /* renamed from: L, reason: collision with root package name */
        String f2889L;

        /* renamed from: M, reason: collision with root package name */
        long f2890M;

        /* renamed from: P, reason: collision with root package name */
        boolean f2893P;

        /* renamed from: Q, reason: collision with root package name */
        Notification f2894Q;

        /* renamed from: R, reason: collision with root package name */
        boolean f2895R;

        /* renamed from: S, reason: collision with root package name */
        Object f2896S;

        /* renamed from: T, reason: collision with root package name */
        public ArrayList f2897T;

        /* renamed from: a, reason: collision with root package name */
        public Context f2898a;
        CharSequence e;

        /* renamed from: f, reason: collision with root package name */
        CharSequence f2902f;

        /* renamed from: g, reason: collision with root package name */
        PendingIntent f2903g;

        /* renamed from: h, reason: collision with root package name */
        PendingIntent f2904h;

        /* renamed from: i, reason: collision with root package name */
        RemoteViews f2905i;

        /* renamed from: j, reason: collision with root package name */
        IconCompat f2906j;

        /* renamed from: k, reason: collision with root package name */
        CharSequence f2907k;

        /* renamed from: l, reason: collision with root package name */
        int f2908l;

        /* renamed from: m, reason: collision with root package name */
        int f2909m;
        boolean o;

        /* renamed from: p, reason: collision with root package name */
        CharSequence f2911p;

        /* renamed from: q, reason: collision with root package name */
        CharSequence f2912q;
        CharSequence[] r;
        int s;

        /* renamed from: t, reason: collision with root package name */
        int f2913t;

        /* renamed from: u, reason: collision with root package name */
        boolean f2914u;

        /* renamed from: v, reason: collision with root package name */
        String f2915v;

        /* renamed from: w, reason: collision with root package name */
        boolean f2916w;

        /* renamed from: x, reason: collision with root package name */
        String f2917x;

        /* renamed from: z, reason: collision with root package name */
        boolean f2919z;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f2899b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f2900c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        ArrayList f2901d = new ArrayList();

        /* renamed from: n, reason: collision with root package name */
        boolean f2910n = true;

        /* renamed from: y, reason: collision with root package name */
        boolean f2918y = false;

        /* renamed from: D, reason: collision with root package name */
        int f2881D = 0;

        /* renamed from: E, reason: collision with root package name */
        int f2882E = 0;

        /* renamed from: K, reason: collision with root package name */
        int f2888K = 0;

        /* renamed from: N, reason: collision with root package name */
        int f2891N = 0;

        /* renamed from: O, reason: collision with root package name */
        int f2892O = 0;

        public c(Context context, String str) {
            Notification notification = new Notification();
            this.f2894Q = notification;
            this.f2898a = context;
            this.f2887J = str;
            notification.when = System.currentTimeMillis();
            this.f2894Q.audioStreamType = -1;
            this.f2909m = 0;
            this.f2897T = new ArrayList();
            this.f2893P = true;
        }

        private void f(int i2, boolean z2) {
            if (z2) {
                Notification notification = this.f2894Q;
                notification.flags = i2 | notification.flags;
            } else {
                Notification notification2 = this.f2894Q;
                notification2.flags = (~i2) & notification2.flags;
            }
        }

        public Notification a() {
            return new l(this).b();
        }

        public Bundle b() {
            if (this.f2880C == null) {
                this.f2880C = new Bundle();
            }
            return this.f2880C;
        }

        public c c(int i2) {
            this.f2881D = i2;
            return this;
        }

        public c d(RemoteViews remoteViews) {
            this.f2894Q.contentView = remoteViews;
            return this;
        }

        public c e(PendingIntent pendingIntent) {
            this.f2903g = pendingIntent;
            return this;
        }

        public c g(Bitmap bitmap) {
            this.f2906j = bitmap == null ? null : IconCompat.b(k.a(this.f2898a, bitmap));
            return this;
        }

        public c h(boolean z2) {
            f(2, z2);
            return this;
        }

        public c i(int i2) {
            this.f2909m = i2;
            return this;
        }

        public c j(int i2) {
            this.f2894Q.icon = i2;
            return this;
        }

        public c k(long j2) {
            this.f2894Q.when = j2;
            return this;
        }
    }

    public static Bitmap a(Context context, Bitmap bitmap) throws Resources.NotFoundException {
        if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
            return bitmap;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(r.d.f7253b);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(r.d.f7252a);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double dMin = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * dMin), (int) Math.ceil(bitmap.getHeight() * dMin), true);
    }
}
