package p0;

import h0.l;
import java.util.Comparator;

/* renamed from: p0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0308c implements Comparator {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(l lVar, l lVar2) {
        long jB = lVar.b();
        long jB2 = lVar2.b();
        if (jB > jB2) {
            return -1;
        }
        if (jB < jB2) {
            return 1;
        }
        return lVar.d().compareTo(lVar2.d());
    }
}
