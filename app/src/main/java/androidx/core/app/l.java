package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.appcompat.app.F;
import androidx.core.app.k;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class l {

    /* renamed from: a */
    private final Context f2920a;

    /* renamed from: b */
    private final Notification.Builder f2921b;

    /* renamed from: c */
    private final k.c f2922c;

    /* renamed from: d */
    private RemoteViews f2923d;
    private RemoteViews e;

    /* renamed from: f */
    private final List f2924f = new ArrayList();

    /* renamed from: g */
    private final Bundle f2925g = new Bundle();

    /* renamed from: h */
    private int f2926h;

    /* renamed from: i */
    private RemoteViews f2927i;

    static class a {
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Action.Builder e(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i2, charSequence, pendingIntent);
        }

        static String f(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder h(Notification.Builder builder, boolean z2) {
            return builder.setGroupSummary(z2);
        }

        static Notification.Builder i(Notification.Builder builder, boolean z2) {
            return builder.setLocalOnly(z2);
        }

        static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    static class b {
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder c(Notification.Builder builder, int i2) {
            return builder.setColor(i2);
        }

        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder f(Notification.Builder builder, int i2) {
            return builder.setVisibility(i2);
        }
    }

    static class c {
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    static class d {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z2) {
            return builder.setAllowGeneratedReplies(z2);
        }

        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    static class e {
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder b(Notification.Builder builder, int i2) {
            return builder.setBadgeIconType(i2);
        }

        static Notification.Builder c(Notification.Builder builder, boolean z2) {
            return builder.setColorized(z2);
        }

        static Notification.Builder d(Notification.Builder builder, int i2) {
            return builder.setGroupAlertBehavior(i2);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        static Notification.Builder g(Notification.Builder builder, long j2) {
            return builder.setTimeoutAfter(j2);
        }
    }

    static class f {
        static Notification.Builder a(Notification.Builder builder, boolean z2) {
            return builder.setAllowSystemGeneratedContextualActions(z2);
        }

        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z2) {
            return builder.setContextual(z2);
        }

        static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    static class g {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z2) {
            return builder.setAuthenticationRequired(z2);
        }

        static Notification.Builder b(Notification.Builder builder, int i2) {
            return builder.setForegroundServiceBehavior(i2);
        }
    }

    l(k.c cVar) {
        int i2;
        Object obj;
        this.f2922c = cVar;
        Context context = cVar.f2898a;
        this.f2920a = context;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            this.f2921b = e.a(context, cVar.f2887J);
        } else {
            this.f2921b = new Notification.Builder(cVar.f2898a);
        }
        Notification notification = cVar.f2894Q;
        this.f2921b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, cVar.f2905i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(cVar.e).setContentText(cVar.f2902f).setContentInfo(cVar.f2907k).setContentIntent(cVar.f2903g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(cVar.f2904h, (notification.flags & 128) != 0).setNumber(cVar.f2908l).setProgress(cVar.s, cVar.f2913t, cVar.f2914u);
        if (i3 < 23) {
            Notification.Builder builder = this.f2921b;
            IconCompat iconCompat = cVar.f2906j;
            builder.setLargeIcon(iconCompat == null ? null : iconCompat.c());
        } else {
            Notification.Builder builder2 = this.f2921b;
            IconCompat iconCompat2 = cVar.f2906j;
            c.b(builder2, iconCompat2 == null ? null : iconCompat2.j(context));
        }
        this.f2921b.setSubText(cVar.f2911p).setUsesChronometer(cVar.o).setPriority(cVar.f2909m);
        Iterator it = cVar.f2899b.iterator();
        while (it.hasNext()) {
            F.a(it.next());
            a(null);
        }
        Bundle bundle = cVar.f2880C;
        if (bundle != null) {
            this.f2925g.putAll(bundle);
        }
        int i4 = Build.VERSION.SDK_INT;
        this.f2923d = cVar.f2884G;
        this.e = cVar.f2885H;
        this.f2921b.setShowWhen(cVar.f2910n);
        a.i(this.f2921b, cVar.f2918y);
        a.g(this.f2921b, cVar.f2915v);
        a.j(this.f2921b, cVar.f2917x);
        a.h(this.f2921b, cVar.f2916w);
        this.f2926h = cVar.f2891N;
        b.b(this.f2921b, cVar.f2879B);
        b.c(this.f2921b, cVar.f2881D);
        b.f(this.f2921b, cVar.f2882E);
        b.d(this.f2921b, cVar.f2883F);
        b.e(this.f2921b, notification.sound, notification.audioAttributes);
        List listD = i4 < 28 ? d(e(cVar.f2900c), cVar.f2897T) : cVar.f2897T;
        if (listD != null && !listD.isEmpty()) {
            Iterator it2 = listD.iterator();
            while (it2.hasNext()) {
                b.a(this.f2921b, (String) it2.next());
            }
        }
        this.f2927i = cVar.f2886I;
        if (cVar.f2901d.size() > 0) {
            Bundle bundle2 = cVar.b().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i5 = 0; i5 < cVar.f2901d.size(); i5++) {
                String string = Integer.toString(i5);
                F.a(cVar.f2901d.get(i5));
                bundle4.putBundle(string, m.a(null));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            cVar.b().putBundle("android.car.EXTENSIONS", bundle2);
            this.f2925g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 23 && (obj = cVar.f2896S) != null) {
            c.c(this.f2921b, obj);
        }
        if (i6 >= 24) {
            this.f2921b.setExtras(cVar.f2880C);
            d.e(this.f2921b, cVar.r);
            RemoteViews remoteViews = cVar.f2884G;
            if (remoteViews != null) {
                d.c(this.f2921b, remoteViews);
            }
            RemoteViews remoteViews2 = cVar.f2885H;
            if (remoteViews2 != null) {
                d.b(this.f2921b, remoteViews2);
            }
            RemoteViews remoteViews3 = cVar.f2886I;
            if (remoteViews3 != null) {
                d.d(this.f2921b, remoteViews3);
            }
        }
        if (i6 >= 26) {
            e.b(this.f2921b, cVar.f2888K);
            e.e(this.f2921b, cVar.f2912q);
            e.f(this.f2921b, cVar.f2889L);
            e.g(this.f2921b, cVar.f2890M);
            e.d(this.f2921b, cVar.f2891N);
            if (cVar.f2878A) {
                e.c(this.f2921b, cVar.f2919z);
            }
            if (!TextUtils.isEmpty(cVar.f2887J)) {
                this.f2921b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i6 >= 28) {
            Iterator it3 = cVar.f2900c.iterator();
            if (it3.hasNext()) {
                F.a(it3.next());
                throw null;
            }
        }
        if (i6 >= 29) {
            f.a(this.f2921b, cVar.f2893P);
            f.b(this.f2921b, k.b.a(null));
        }
        if (i6 >= 31 && (i2 = cVar.f2892O) != 0) {
            g.b(this.f2921b, i2);
        }
        if (cVar.f2895R) {
            if (this.f2922c.f2916w) {
                this.f2926h = 2;
            } else {
                this.f2926h = 1;
            }
            this.f2921b.setVibrate(null);
            this.f2921b.setSound(null);
            int i7 = notification.defaults & (-4);
            notification.defaults = i7;
            this.f2921b.setDefaults(i7);
            if (i6 >= 26) {
                if (TextUtils.isEmpty(this.f2922c.f2915v)) {
                    a.g(this.f2921b, "silent");
                }
                e.d(this.f2921b, this.f2926h);
            }
        }
    }

    private void a(k.a aVar) {
        throw null;
    }

    private static List d(List list, List list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        androidx.collection.b bVar = new androidx.collection.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List e(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        F.a(it.next());
        throw null;
    }

    private void f(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    public Notification b() {
        this.f2922c.getClass();
        Notification notificationC = c();
        RemoteViews remoteViews = this.f2922c.f2884G;
        if (remoteViews != null) {
            notificationC.contentView = remoteViews;
        }
        return notificationC;
    }

    protected Notification c() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return this.f2921b.build();
        }
        if (i2 >= 24) {
            Notification notificationBuild = this.f2921b.build();
            if (this.f2926h != 0) {
                if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) != 0 && this.f2926h == 2) {
                    f(notificationBuild);
                }
                if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) == 0 && this.f2926h == 1) {
                    f(notificationBuild);
                }
            }
            return notificationBuild;
        }
        this.f2921b.setExtras(this.f2925g);
        Notification notificationBuild2 = this.f2921b.build();
        RemoteViews remoteViews = this.f2923d;
        if (remoteViews != null) {
            notificationBuild2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.e;
        if (remoteViews2 != null) {
            notificationBuild2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f2927i;
        if (remoteViews3 != null) {
            notificationBuild2.headsUpContentView = remoteViews3;
        }
        if (this.f2926h != 0) {
            if (a.f(notificationBuild2) != null && (notificationBuild2.flags & 512) != 0 && this.f2926h == 2) {
                f(notificationBuild2);
            }
            if (a.f(notificationBuild2) != null && (notificationBuild2.flags & 512) == 0 && this.f2926h == 1) {
                f(notificationBuild2);
            }
        }
        return notificationBuild2;
    }
}
