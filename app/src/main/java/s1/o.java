package s1;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    final Method f7484a;

    /* renamed from: b, reason: collision with root package name */
    final ThreadMode f7485b;

    /* renamed from: c, reason: collision with root package name */
    final Class f7486c;

    /* renamed from: d, reason: collision with root package name */
    final int f7487d;
    final boolean e;

    /* renamed from: f, reason: collision with root package name */
    String f7488f;

    public o(Method method, Class cls, ThreadMode threadMode, int i2, boolean z2) {
        this.f7484a = method;
        this.f7485b = threadMode;
        this.f7486c = cls;
        this.f7487d = i2;
        this.e = z2;
    }

    private synchronized void a() {
        if (this.f7488f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f7484a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f7484a.getName());
            sb.append('(');
            sb.append(this.f7486c.getName());
            this.f7488f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        a();
        o oVar = (o) obj;
        oVar.a();
        return this.f7488f.equals(oVar.f7488f);
    }

    public int hashCode() {
        return this.f7484a.hashCode();
    }
}
