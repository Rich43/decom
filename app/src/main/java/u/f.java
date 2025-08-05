package u;

import android.util.Base64;
import java.util.List;
import v.AbstractC0345h;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final String f7526a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7527b;

    /* renamed from: c, reason: collision with root package name */
    private final String f7528c;

    /* renamed from: d, reason: collision with root package name */
    private final List f7529d;
    private final int e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final String f7530f;

    public f(String str, String str2, String str3, List list) {
        this.f7526a = (String) AbstractC0345h.f(str);
        this.f7527b = (String) AbstractC0345h.f(str2);
        this.f7528c = (String) AbstractC0345h.f(str3);
        this.f7529d = (List) AbstractC0345h.f(list);
        this.f7530f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.f7529d;
    }

    public int c() {
        return this.e;
    }

    String d() {
        return this.f7530f;
    }

    public String e() {
        return this.f7526a;
    }

    public String f() {
        return this.f7527b;
    }

    public String g() {
        return this.f7528c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f7526a + ", mProviderPackage: " + this.f7527b + ", mQuery: " + this.f7528c + ", mCertificates:");
        for (int i2 = 0; i2 < this.f7529d.size(); i2++) {
            sb.append(" [");
            List list = (List) this.f7529d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }
}
