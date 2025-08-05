package U0;

/* loaded from: classes.dex */
public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: f, reason: collision with root package name */
    private static final f[] f919f;

    /* renamed from: a, reason: collision with root package name */
    private final int f921a;

    static {
        f fVar = L;
        f fVar2 = M;
        f fVar3 = Q;
        f919f = new f[]{fVar2, fVar, H, fVar3};
    }

    f(int i2) {
        this.f921a = i2;
    }

    public static f a(int i2) {
        if (i2 >= 0) {
            f[] fVarArr = f919f;
            if (i2 < fVarArr.length) {
                return fVarArr[i2];
            }
        }
        throw new IllegalArgumentException();
    }
}
