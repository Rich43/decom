package W0;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.Log;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import z0.EnumC0379a;
import z0.EnumC0383e;
import z0.p;

/* loaded from: classes.dex */
final class h extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1083a;

    /* renamed from: b, reason: collision with root package name */
    private final X0.d f1084b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f1085c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f1086d;
    private d e;

    /* renamed from: f, reason: collision with root package name */
    private final CountDownLatch f1087f = new CountDownLatch(1);

    h(Context context, X0.d dVar, d dVar2, Collection collection, Map map, String str, p pVar) {
        this.f1083a = context;
        this.f1084b = dVar;
        this.e = dVar2;
        EnumMap enumMap = new EnumMap(EnumC0383e.class);
        this.f1085c = enumMap;
        if (map != null) {
            enumMap.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            collection = EnumSet.noneOf(EnumC0379a.class);
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_product", true)) {
                collection.addAll(f.f1070b);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_industrial", true)) {
                collection.addAll(f.f1071c);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_QR", true)) {
                collection.addAll(f.e);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Data_Matrix", true)) {
                collection.addAll(f.f1073f);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Aztec", false)) {
                collection.addAll(f.f1074g);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_PDF417", false)) {
                collection.addAll(f.f1075h);
            }
        }
        enumMap.put((EnumMap) EnumC0383e.POSSIBLE_FORMATS, (EnumC0383e) collection);
        if (str != null) {
            enumMap.put((EnumMap) EnumC0383e.CHARACTER_SET, (EnumC0383e) str);
        }
        enumMap.put((EnumMap) EnumC0383e.NEED_RESULT_POINT_CALLBACK, (EnumC0383e) pVar);
        Log.i("DecodeThread", "Hints: " + enumMap);
    }

    Handler a() throws InterruptedException {
        try {
            this.f1087f.await();
        } catch (InterruptedException unused) {
        }
        return this.f1086d;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f1086d = new g(this.f1083a, this.f1084b, this.e, this.f1085c);
        this.f1087f.countDown();
        Looper.loop();
    }
}
