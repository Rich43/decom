package com.caglobal.kodakluma.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

@SuppressLint({"ShowToast", "ClickableViewAccessibility"})
/* loaded from: classes.dex */
public class FloatingService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private WindowManager f5416a;

    /* renamed from: b, reason: collision with root package name */
    private WindowManager.LayoutParams f5417b;

    /* renamed from: c, reason: collision with root package name */
    private Button f5418c;

    class a implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private int f5419a;

        /* renamed from: b, reason: collision with root package name */
        private int f5420b;

        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f5419a = (int) motionEvent.getRawX();
                this.f5420b = (int) motionEvent.getRawY();
                return false;
            }
            if (action != 2) {
                return false;
            }
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int i2 = rawX - this.f5419a;
            int i3 = rawY - this.f5420b;
            this.f5419a = rawX;
            this.f5420b = rawY;
            FloatingService.this.f5417b.x += i2;
            FloatingService.this.f5417b.y += i3;
            FloatingService.this.f5416a.updateViewLayout(view, FloatingService.this.f5417b);
            return false;
        }
    }

    private void c() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23 || Settings.canDrawOverlays(this)) {
            this.f5416a = (WindowManager) getSystemService("window");
            Button button = new Button(getApplicationContext());
            this.f5418c = button;
            button.setText("Floating Window");
            this.f5418c.setBackgroundColor(-16776961);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f5417b = layoutParams;
            if (i2 >= 26) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2003;
            }
            layoutParams.format = 1;
            layoutParams.width = 1;
            layoutParams.height = 1;
            layoutParams.x = 100;
            layoutParams.y = 300;
            layoutParams.flags = 262184;
            this.f5416a.addView(this.f5418c, layoutParams);
            this.f5418c.setOnTouchListener(new a());
        }
    }

    private void d() {
        this.f5416a.removeView(this.f5418c);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        d();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        c();
        return super.onStartCommand(intent, i2, i3);
    }
}
