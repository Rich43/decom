package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
abstract class m {

    private static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f3330a;

        a(ByteBuffer byteBuffer) {
            this.f3330a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.m.c
        public long a() {
            return m.c(this.f3330a.getInt());
        }

        @Override // androidx.emoji2.text.m.c
        public void b(int i2) {
            ByteBuffer byteBuffer = this.f3330a;
            byteBuffer.position(byteBuffer.position() + i2);
        }

        @Override // androidx.emoji2.text.m.c
        public int c() {
            return m.d(this.f3330a.getShort());
        }

        @Override // androidx.emoji2.text.m.c
        public int d() {
            return this.f3330a.getInt();
        }

        @Override // androidx.emoji2.text.m.c
        public long e() {
            return this.f3330a.position();
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f3331a;

        /* renamed from: b, reason: collision with root package name */
        private final long f3332b;

        b(long j2, long j3) {
            this.f3331a = j2;
            this.f3332b = j3;
        }

        long a() {
            return this.f3331a;
        }
    }

    private interface c {
        long a();

        void b(int i2);

        int c();

        int d();

        long e();
    }

    private static b a(c cVar) throws IOException {
        long jA;
        cVar.b(4);
        int iC = cVar.c();
        if (iC > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.b(6);
        int i2 = 0;
        while (true) {
            if (i2 >= iC) {
                jA = -1;
                break;
            }
            int iD = cVar.d();
            cVar.b(4);
            jA = cVar.a();
            cVar.b(4);
            if (1835365473 == iD) {
                break;
            }
            i2++;
        }
        if (jA != -1) {
            cVar.b((int) (jA - cVar.e()));
            cVar.b(12);
            long jA2 = cVar.a();
            for (int i3 = 0; i3 < jA2; i3++) {
                int iD2 = cVar.d();
                long jA3 = cVar.a();
                long jA4 = cVar.a();
                if (1164798569 == iD2 || 1701669481 == iD2) {
                    return new b(jA3 + jA, jA4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    static C.b b(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new a(byteBufferDuplicate)).a());
        return C.b.h(byteBufferDuplicate);
    }

    static long c(int i2) {
        return i2 & 4294967295L;
    }

    static int d(short s) {
        return s & 65535;
    }
}
