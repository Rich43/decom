package b0;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import r1.f;

/* loaded from: classes.dex */
public abstract class c implements Closeable {

    /* renamed from: g */
    private static final String[] f4591g = new String[128];

    /* renamed from: a */
    int f4592a;

    /* renamed from: b */
    int[] f4593b = new int[32];

    /* renamed from: c */
    String[] f4594c = new String[32];

    /* renamed from: d */
    int[] f4595d = new int[32];
    boolean e;

    /* renamed from: f */
    boolean f4596f;

    public static final class a {

        /* renamed from: a */
        final String[] f4597a;

        /* renamed from: b */
        final f f4598b;

        private a(String[] strArr, f fVar) {
            this.f4597a = strArr;
            this.f4598b = fVar;
        }

        public static a a(String... strArr) {
            try {
                r1.d[] dVarArr = new r1.d[strArr.length];
                r1.a aVar = new r1.a();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    c.B(aVar, strArr[i2]);
                    aVar.r();
                    dVarArr[i2] = aVar.u();
                }
                return new a((String[]) strArr.clone(), f.d(dVarArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f4591g[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f4591g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    c() {
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void B(r1.b r7, java.lang.String r8) {
        /*
            java.lang.String[] r0 = b0.c.f4591g
            r1 = 34
            r7.h(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.a(r8, r4, r3)
        L2e:
            r7.e(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.a(r8, r4, r2)
        L3b:
            r7.h(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.c.B(r1.b, java.lang.String):void");
    }

    public static c v(r1.c cVar) {
        return new e(cVar);
    }

    public abstract void A();

    final b0.b C(String str) throws b0.b {
        throw new b0.b(str + " at path " + o());
    }

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public final String o() {
        return d.a(this.f4592a, this.f4593b, this.f4594c, this.f4595d);
    }

    public abstract boolean p();

    public abstract boolean q();

    public abstract double r();

    public abstract int s();

    public abstract String t();

    public abstract String u();

    public abstract b w();

    final void x(int i2) {
        int i3 = this.f4592a;
        int[] iArr = this.f4593b;
        if (i3 == iArr.length) {
            if (i3 == 256) {
                throw new C0212a("Nesting too deep at " + o());
            }
            this.f4593b = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f4594c;
            this.f4594c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f4595d;
            this.f4595d = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f4593b;
        int i4 = this.f4592a;
        this.f4592a = i4 + 1;
        iArr3[i4] = i2;
    }

    public abstract int y(a aVar);

    public abstract void z();
}
