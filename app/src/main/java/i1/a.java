package i1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class a implements Iterator, j1.a {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f6456a;

    /* renamed from: b, reason: collision with root package name */
    private int f6457b;

    public a(Object[] objArr) {
        k.e(objArr, "array");
        this.f6456a = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f6457b < this.f6456a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f6456a;
            int i2 = this.f6457b;
            this.f6457b = i2 + 1;
            return objArr[i2];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f6457b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
