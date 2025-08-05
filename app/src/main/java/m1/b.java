package m1;

import b1.A;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b extends A {

    /* renamed from: a, reason: collision with root package name */
    private final int f6695a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6696b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6697c;

    /* renamed from: d, reason: collision with root package name */
    private int f6698d;

    public b(int i2, int i3, int i4) {
        this.f6695a = i4;
        this.f6696b = i3;
        boolean z2 = false;
        if (i4 <= 0 ? i2 >= i3 : i2 <= i3) {
            z2 = true;
        }
        this.f6697c = z2;
        this.f6698d = z2 ? i2 : i3;
    }

    @Override // b1.A
    public int a() {
        int i2 = this.f6698d;
        if (i2 != this.f6696b) {
            this.f6698d = this.f6695a + i2;
        } else {
            if (!this.f6697c) {
                throw new NoSuchElementException();
            }
            this.f6697c = false;
        }
        return i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f6697c;
    }
}
