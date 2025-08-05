package m1;

import i1.g;

/* loaded from: classes.dex */
public final class c extends m1.a {
    public static final a e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final c f6699f = new c(1, 0);

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    public c(int i2, int i3) {
        super(i2, i3, 1);
    }

    @Override // m1.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (a() != cVar.a() || b() != cVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // m1.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // m1.a
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // m1.a
    public String toString() {
        return a() + ".." + b();
    }
}
