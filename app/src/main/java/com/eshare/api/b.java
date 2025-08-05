package com.eshare.api;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.MotionEvent;
import android.view.View;
import defpackage.g;

/* loaded from: classes.dex */
final class b implements View.OnTouchListener, SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private float f5544a;

    /* renamed from: b, reason: collision with root package name */
    private Context f5545b;

    /* renamed from: c, reason: collision with root package name */
    private float f5546c;

    /* renamed from: d, reason: collision with root package name */
    private float f5547d;

    /* renamed from: i, reason: collision with root package name */
    private long f5551i;

    /* renamed from: k, reason: collision with root package name */
    private a f5553k;
    private int e = 1280;

    /* renamed from: f, reason: collision with root package name */
    private int f5548f = 720;

    /* renamed from: g, reason: collision with root package name */
    private float f5549g = 640;

    /* renamed from: h, reason: collision with root package name */
    private float f5550h = 360;

    /* renamed from: j, reason: collision with root package name */
    private int f5552j = -1;

    b(Context context, a aVar) {
        this.f5545b = context;
        this.f5553k = aVar;
        this.f5544a = g.a(context, "com.ecloud.eshare.lib.key.SENSITIVITY", 0.85f);
    }

    private void a(float f2, float f3, int i2) {
        this.f5553k.e(f2, f3, i2);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        float f2 = 1.0f - this.f5544a;
        if (type == 4) {
            float[] fArr = sensorEvent.values;
            float f3 = -((int) (fArr[2] * 30.0f));
            float f4 = -((int) (fArr[0] * 30.0f));
            if (f3 == this.f5546c && f4 == this.f5547d) {
                return;
            }
            this.f5546c = f3;
            this.f5547d = f4;
            float f5 = f2 * 100.0f;
            float f6 = this.f5549g + (f3 / f5);
            this.f5549g = f6;
            float f7 = this.f5550h + (f4 / f5);
            this.f5550h = f7;
            if (f6 < 0.0f) {
                this.f5549g = 0.0f;
            } else {
                float f8 = this.e;
                if (f6 > f8) {
                    this.f5549g = f8;
                }
            }
            if (f7 < 0.0f) {
                this.f5550h = 0.0f;
            } else {
                float f9 = this.f5548f;
                if (f7 > f9) {
                    this.f5550h = f9;
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f5551i > f5) {
                this.f5551i = jCurrentTimeMillis;
                a(this.f5549g, this.f5550h, this.f5552j);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        this.f5552j = action;
        if (action == 0) {
            a(this.f5549g, this.f5550h, 0);
        } else if (action == 1 || action == 3) {
            a(this.f5549g, this.f5550h, 1);
            this.f5552j = -1;
        }
        return true;
    }
}
