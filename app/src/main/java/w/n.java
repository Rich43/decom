package W;

import d0.C0244a;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
abstract class n implements m {

    /* renamed from: a, reason: collision with root package name */
    final List f1020a;

    n(List list) {
        this.f1020a = list;
    }

    @Override // W.m
    public List b() {
        return this.f1020a;
    }

    @Override // W.m
    public boolean c() {
        if (this.f1020a.isEmpty()) {
            return true;
        }
        return this.f1020a.size() == 1 && ((C0244a) this.f1020a.get(0)).h();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f1020a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f1020a.toArray()));
        }
        return sb.toString();
    }
}
