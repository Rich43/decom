package W0;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.preference.PreferenceManager;

/* loaded from: classes.dex */
final class a implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1021a;

    /* renamed from: b, reason: collision with root package name */
    private X0.d f1022b;

    /* renamed from: c, reason: collision with root package name */
    private Sensor f1023c;

    a(Context context) {
        this.f1021a = context;
    }

    void a(X0.d dVar) {
        this.f1022b = dVar;
        if (X0.e.b(PreferenceManager.getDefaultSharedPreferences(this.f1021a)) == X0.e.AUTO) {
            SensorManager sensorManager = (SensorManager) this.f1021a.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f1023c = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    void b() {
        if (this.f1023c != null) {
            ((SensorManager) this.f1021a.getSystemService("sensor")).unregisterListener(this);
            this.f1022b = null;
            this.f1023c = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f2 = sensorEvent.values[0];
        X0.d dVar = this.f1022b;
        if (dVar != null) {
            if (f2 <= 45.0f) {
                dVar.m(true);
            } else if (f2 >= 450.0f) {
                dVar.m(false);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }
}
