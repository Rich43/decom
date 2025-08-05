package b1;

import java.util.AbstractList;
import java.util.List;

/* renamed from: b1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0215c extends AbstractList implements List, j1.a {
    protected AbstractC0215c() {
    }

    public abstract int a();

    public abstract Object b(int i2);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i2) {
        return b(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
