package b1;

import java.util.List;

/* renamed from: b1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0214b extends AbstractC0213a implements List, j1.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4618a = new a(null);

    /* renamed from: b1.b$a */
    public static final class a {
        public /* synthetic */ a(i1.g gVar) {
            this();
        }

        public final void a(int i2, int i3) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void b(int i2, int i3) {
            if (i2 < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final int c(int i2, int i3) {
            int i4 = i2 + (i2 >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            return i4 - 2147483639 > 0 ? i3 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i4;
        }

        private a() {
        }
    }
}
