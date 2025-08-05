package com.caglobal.kodakluma;

import Z0.e;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;

/* loaded from: classes.dex */
public class CustomApplication extends Application {

    /* renamed from: c, reason: collision with root package name */
    private static CustomApplication f4714c;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f4715a = new Handler();

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f4716b;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4717a;

        a(int i2) {
            this.f4717a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.h(CustomApplication.f4714c, CustomApplication.f4714c.getString(this.f4717a), null, CustomApplication.f4714c.getResources().getColor(R.color.colorAccent), CustomApplication.f4714c.getResources().getColor(R.color.white), 0, false, true).show();
        }
    }

    public static CustomApplication b() {
        return f4714c;
    }

    public static int c(String str, int i2) {
        SharedPreferences sharedPreferences;
        CustomApplication customApplication = f4714c;
        return (customApplication == null || (sharedPreferences = customApplication.f4716b) == null) ? i2 : sharedPreferences.getInt(str, i2);
    }

    public static void d(String str, boolean z2) {
        SharedPreferences sharedPreferences;
        CustomApplication customApplication = f4714c;
        if (customApplication == null || (sharedPreferences = customApplication.f4716b) == null) {
            return;
        }
        sharedPreferences.edit().putBoolean(str, z2).apply();
    }

    public static void e(String str, int i2) {
        SharedPreferences sharedPreferences;
        CustomApplication customApplication = f4714c;
        if (customApplication == null || (sharedPreferences = customApplication.f4716b) == null) {
            return;
        }
        sharedPreferences.edit().putInt(str, i2).apply();
    }

    public static void f(int i2) {
        CustomApplication customApplication = f4714c;
        if (customApplication == null) {
            return;
        }
        customApplication.f4715a.post(new a(i2));
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f4714c = this;
        e.a.c().a(false).b();
        this.f4716b = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }
}
