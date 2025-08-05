package S;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private List f743a = new ArrayList();

    void a(s sVar) {
        this.f743a.add(sVar);
    }

    public void b(Path path) {
        for (int size = this.f743a.size() - 1; size >= 0; size--) {
            c0.j.b(path, (s) this.f743a.get(size));
        }
    }
}
