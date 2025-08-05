package p0;

import h0.C0262c;
import java.util.Comparator;

/* renamed from: p0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0307b implements Comparator {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0262c c0262c, C0262c c0262c2) {
        String strG = c0262c.g();
        String strG2 = c0262c2.g();
        if (strG.equals("#") && !strG2.equals("#")) {
            return 1;
        }
        if (strG.equals("#") || !strG2.equals("#")) {
            return !strG.equals(strG2) ? strG.compareTo(strG2) : c0262c.d().compareTo(c0262c2.d());
        }
        return -1;
    }
}
