package V;

import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final List f968a;

    /* renamed from: b, reason: collision with root package name */
    private final char f969b;

    /* renamed from: c, reason: collision with root package name */
    private final double f970c;

    /* renamed from: d, reason: collision with root package name */
    private final double f971d;
    private final String e;

    /* renamed from: f, reason: collision with root package name */
    private final String f972f;

    public d(List list, char c2, double d2, double d3, String str, String str2) {
        this.f968a = list;
        this.f969b = c2;
        this.f970c = d2;
        this.f971d = d3;
        this.e = str;
        this.f972f = str2;
    }

    public static int c(char c2, String str, String str2) {
        return (((c2 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List a() {
        return this.f968a;
    }

    public double b() {
        return this.f971d;
    }

    public int hashCode() {
        return c(this.f969b, this.f972f, this.e);
    }
}
