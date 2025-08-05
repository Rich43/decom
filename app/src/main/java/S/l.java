package S;

import X.h;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class l implements m, j {

    /* renamed from: d */
    private final String f794d;

    /* renamed from: f */
    private final X.h f795f;

    /* renamed from: a */
    private final Path f791a = new Path();

    /* renamed from: b */
    private final Path f792b = new Path();

    /* renamed from: c */
    private final Path f793c = new Path();
    private final List e = new ArrayList();

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f796a;

        static {
            int[] iArr = new int[h.a.values().length];
            f796a = iArr;
            try {
                iArr[h.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f796a[h.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f796a[h.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f796a[h.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f796a[h.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(X.h hVar) {
        this.f794d = hVar.c();
        this.f795f = hVar;
    }

    private void b() {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            this.f793c.addPath(((m) this.e.get(i2)).h());
        }
    }

    private void c(Path.Op op) {
        this.f792b.reset();
        this.f791a.reset();
        for (int size = this.e.size() - 1; size >= 1; size--) {
            m mVar = (m) this.e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List listK = dVar.k();
                for (int size2 = listK.size() - 1; size2 >= 0; size2--) {
                    Path pathH = ((m) listK.get(size2)).h();
                    pathH.transform(dVar.l());
                    this.f792b.addPath(pathH);
                }
            } else {
                this.f792b.addPath(mVar.h());
            }
        }
        m mVar2 = (m) this.e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List listK2 = dVar2.k();
            for (int i2 = 0; i2 < listK2.size(); i2++) {
                Path pathH2 = ((m) listK2.get(i2)).h();
                pathH2.transform(dVar2.l());
                this.f791a.addPath(pathH2);
            }
        } else {
            this.f791a.set(mVar2.h());
        }
        this.f793c.op(this.f791a, this.f792b, op);
    }

    @Override // S.c
    public void d(List list, List list2) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            ((m) this.e.get(i2)).d(list, list2);
        }
    }

    @Override // S.j
    public void e(ListIterator listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVar = (c) listIterator.previous();
            if (cVar instanceof m) {
                this.e.add((m) cVar);
                listIterator.remove();
            }
        }
    }

    @Override // S.m
    public Path h() {
        this.f793c.reset();
        if (this.f795f.d()) {
            return this.f793c;
        }
        int i2 = a.f796a[this.f795f.b().ordinal()];
        if (i2 == 1) {
            b();
        } else if (i2 == 2) {
            c(Path.Op.UNION);
        } else if (i2 == 3) {
            c(Path.Op.REVERSE_DIFFERENCE);
        } else if (i2 == 4) {
            c(Path.Op.INTERSECT);
        } else if (i2 == 5) {
            c(Path.Op.XOR);
        }
        return this.f793c;
    }
}
