package O;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class s {

    /* renamed from: b, reason: collision with root package name */
    public View f503b;

    /* renamed from: a, reason: collision with root package name */
    public final Map f502a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList f504c = new ArrayList();

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f503b == sVar.f503b && this.f502a.equals(sVar.f502a);
    }

    public int hashCode() {
        return (this.f503b.hashCode() * 31) + this.f502a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f503b + "\n") + "    values:";
        for (String str2 : this.f502a.keySet()) {
            str = str + "    " + str2 + ": " + this.f502a.get(str2) + "\n";
        }
        return str;
    }
}
