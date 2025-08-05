package U0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f905a;

    /* renamed from: b, reason: collision with root package name */
    public static final c f906b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f907c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f908d;
    public static final c e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f909f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f910g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f911h;

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ c[] f912i;

    enum a extends c {
        a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // U0.c
        boolean a(int i2, int i3) {
            return ((i2 + i3) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        f905a = aVar;
        c cVar = new c("DATA_MASK_001", 1) { // from class: U0.c.b
            {
                a aVar2 = null;
            }

            @Override // U0.c
            boolean a(int i2, int i3) {
                return (i2 & 1) == 0;
            }
        };
        f906b = cVar;
        c cVar2 = new c("DATA_MASK_010", 2) { // from class: U0.c.c
            {
                a aVar2 = null;
            }

            @Override // U0.c
            boolean a(int i2, int i3) {
                return i3 % 3 == 0;
            }
        };
        f907c = cVar2;
        c cVar3 = new c("DATA_MASK_011", 3) { // from class: U0.c.d
            {
                a aVar2 = null;
            }

            @Override // U0.c
            boolean a(int i2, int i3) {
                return (i2 + i3) % 3 == 0;
            }
        };
        f908d = cVar3;
        c cVar4 = new c("DATA_MASK_100", 4) { // from class: U0.c.e
            {
                a aVar2 = null;
            }

            @Override // U0.c
            boolean a(int i2, int i3) {
                return (((i2 / 2) + (i3 / 3)) & 1) == 0;
            }
        };
        e = cVar4;
        c cVar5 = new c("DATA_MASK_101", 5) { // from class: U0.c.f
            {
                a aVar2 = null;
            }

            @Override // U0.c
            boolean a(int i2, int i3) {
                return (i2 * i3) % 6 == 0;
            }
        };
        f909f = cVar5;
        c cVar6 = new c("DATA_MASK_110", 6) { // from class: U0.c.g
            {
                a aVar2 = null;
            }

            @Override // U0.c
            boolean a(int i2, int i3) {
                return (i2 * i3) % 6 < 3;
            }
        };
        f910g = cVar6;
        c cVar7 = new c("DATA_MASK_111", 7) { // from class: U0.c.h
            {
                a aVar2 = null;
            }

            @Override // U0.c
            boolean a(int i2, int i3) {
                return (((i2 + i3) + ((i2 * i3) % 3)) & 1) == 0;
            }
        };
        f911h = cVar7;
        f912i = new c[]{aVar, cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7};
    }

    private c(String str, int i2) {
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f912i.clone();
    }

    abstract boolean a(int i2, int i3);

    final void b(D0.b bVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (a(i3, i4)) {
                    bVar.c(i4, i3);
                }
            }
        }
    }

    /* synthetic */ c(String str, int i2, a aVar) {
        this(str, i2);
    }
}
