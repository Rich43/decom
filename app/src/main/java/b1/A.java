package b1;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class A implements Iterator, j1.a {
    public abstract int a();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
