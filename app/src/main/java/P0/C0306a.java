package p0;

import h0.C0260a;
import java.util.Comparator;

/* renamed from: p0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0306a implements Comparator {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0260a c0260a, C0260a c0260a2) {
        if (c0260a.i() && !c0260a2.i()) {
            return -1;
        }
        if (c0260a.i() || !c0260a2.i()) {
            return c0260a.d().compareTo(c0260a2.d());
        }
        return 1;
    }
}
