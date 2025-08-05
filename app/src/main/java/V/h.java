package V;

/* loaded from: classes.dex */
public class h {

    /* renamed from: d, reason: collision with root package name */
    private static String f977d = "\r";

    /* renamed from: a, reason: collision with root package name */
    private final String f978a;

    /* renamed from: b, reason: collision with root package name */
    public final float f979b;

    /* renamed from: c, reason: collision with root package name */
    public final float f980c;

    public h(String str, float f2, float f3) {
        this.f978a = str;
        this.f980c = f3;
        this.f979b = f2;
    }

    public boolean a(String str) {
        if (this.f978a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f978a.endsWith(f977d)) {
            String str2 = this.f978a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
