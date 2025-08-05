package T;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final List f860a;

    /* renamed from: b, reason: collision with root package name */
    private final List f861b;

    /* renamed from: c, reason: collision with root package name */
    private final List f862c;

    public g(List list) {
        this.f862c = list;
        this.f860a = new ArrayList(list.size());
        this.f861b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f860a.add(((X.g) list.get(i2)).b().a());
            this.f861b.add(((X.g) list.get(i2)).c().a());
        }
    }

    public List a() {
        return this.f860a;
    }

    public List b() {
        return this.f862c;
    }

    public List c() {
        return this.f861b;
    }
}
