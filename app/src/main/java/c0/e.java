package c0;

import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class e implements Q.h {

    /* renamed from: a, reason: collision with root package name */
    private static final Set f4634a = new HashSet();

    @Override // Q.h
    public void a(String str) {
        d(str, null);
    }

    @Override // Q.h
    public void b(String str, Throwable th) {
        Set set = f4634a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }

    @Override // Q.h
    public void c(String str) {
        b(str, null);
    }

    public void d(String str, Throwable th) {
        if (Q.c.f552a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
