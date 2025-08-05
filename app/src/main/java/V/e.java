package V;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a */
    private final List f973a;

    /* renamed from: b */
    private f f974b;

    public e(String... strArr) {
        this.f973a = Arrays.asList(strArr);
    }

    private boolean b() {
        return ((String) this.f973a.get(r0.size() - 1)).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public e a(String str) {
        e eVar = new e(this);
        eVar.f973a.add(str);
        return eVar;
    }

    public boolean c(String str, int i2) {
        if (i2 >= this.f973a.size()) {
            return false;
        }
        boolean z2 = i2 == this.f973a.size() - 1;
        String str2 = (String) this.f973a.get(i2);
        if (!str2.equals("**")) {
            return (z2 || (i2 == this.f973a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z2 && ((String) this.f973a.get(i2 + 1)).equals(str)) {
            return i2 == this.f973a.size() + (-2) || (i2 == this.f973a.size() + (-3) && b());
        }
        if (z2) {
            return true;
        }
        int i3 = i2 + 1;
        if (i3 < this.f973a.size() - 1) {
            return false;
        }
        return ((String) this.f973a.get(i3)).equals(str);
    }

    public f d() {
        return this.f974b;
    }

    public int e(String str, int i2) {
        if (f(str)) {
            return 0;
        }
        if (((String) this.f973a.get(i2)).equals("**")) {
            return (i2 != this.f973a.size() - 1 && ((String) this.f973a.get(i2 + 1)).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean g(String str, int i2) {
        if (f(str)) {
            return true;
        }
        if (i2 >= this.f973a.size()) {
            return false;
        }
        return ((String) this.f973a.get(i2)).equals(str) || ((String) this.f973a.get(i2)).equals("**") || ((String) this.f973a.get(i2)).equals("*");
    }

    public boolean h(String str, int i2) {
        return "__container".equals(str) || i2 < this.f973a.size() - 1 || ((String) this.f973a.get(i2)).equals("**");
    }

    public e i(f fVar) {
        e eVar = new e(this);
        eVar.f974b = fVar;
        return eVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f973a);
        sb.append(",resolved=");
        sb.append(this.f974b != null);
        sb.append('}');
        return sb.toString();
    }

    private e(e eVar) {
        this.f973a = new ArrayList(eVar.f973a);
        this.f974b = eVar.f974b;
    }
}
