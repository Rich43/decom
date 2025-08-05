package b1;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class n extends m {
    public static final Collection d(Object[] objArr) {
        i1.k.e(objArr, "<this>");
        return new C0216d(objArr, false);
    }

    public static List e() {
        return x.f4626a;
    }

    public static final int f(List list) {
        i1.k.e(list, "<this>");
        return list.size() - 1;
    }

    public static List g(Object... objArr) {
        i1.k.e(objArr, "elements");
        return objArr.length > 0 ? AbstractC0221i.b(objArr) : l.e();
    }

    public static void h() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
