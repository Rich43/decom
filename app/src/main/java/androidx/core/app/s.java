package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class s implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f2936a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Context f2937b;

    public interface a {
        Intent A();
    }

    private s(Context context) {
        this.f2937b = context;
    }

    public static s d(Context context) {
        return new s(context);
    }

    public s a(Intent intent) {
        this.f2936a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s b(Activity activity) {
        Intent intentA = activity instanceof a ? ((a) activity).A() : null;
        if (intentA == null) {
            intentA = j.a(activity);
        }
        if (intentA != null) {
            ComponentName component = intentA.getComponent();
            if (component == null) {
                component = intentA.resolveActivity(this.f2937b.getPackageManager());
            }
            c(component);
            a(intentA);
        }
        return this;
    }

    public s c(ComponentName componentName) {
        int size = this.f2936a.size();
        try {
            Intent intentB = j.b(this.f2937b, componentName);
            while (intentB != null) {
                this.f2936a.add(size, intentB);
                intentB = j.b(this.f2937b, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public void e() {
        f(null);
    }

    public void f(Bundle bundle) {
        if (this.f2936a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f2936a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.a.g(this.f2937b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f2937b.startActivity(intent);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f2936a.iterator();
    }
}
