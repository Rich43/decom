package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import v.AbstractC0345h;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a */
    private final C.b f3333a;

    /* renamed from: b */
    private final char[] f3334b;

    /* renamed from: c */
    private final a f3335c = new a(1024);

    /* renamed from: d */
    private final Typeface f3336d;

    static class a {

        /* renamed from: a */
        private final SparseArray f3337a;

        /* renamed from: b */
        private p f3338b;

        private a() {
            this(1);
        }

        a a(int i2) {
            SparseArray sparseArray = this.f3337a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i2);
        }

        final p b() {
            return this.f3338b;
        }

        void c(p pVar, int i2, int i3) {
            a aVarA = a(pVar.b(i2));
            if (aVarA == null) {
                aVarA = new a();
                this.f3337a.put(pVar.b(i2), aVarA);
            }
            if (i3 > i2) {
                aVarA.c(pVar, i2 + 1, i3);
            } else {
                aVarA.f3338b = pVar;
            }
        }

        a(int i2) {
            this.f3337a = new SparseArray(i2);
        }
    }

    private n(Typeface typeface, C.b bVar) {
        this.f3336d = typeface;
        this.f3333a = bVar;
        this.f3334b = new char[bVar.k() * 2];
        a(bVar);
    }

    private void a(C.b bVar) {
        int iK = bVar.k();
        for (int i2 = 0; i2 < iK; i2++) {
            p pVar = new p(this, i2);
            Character.toChars(pVar.f(), this.f3334b, i2 * 2);
            h(pVar);
        }
    }

    public static n b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            androidx.core.os.o.a("EmojiCompat.MetadataRepo.create");
            return new n(typeface, m.b(byteBuffer));
        } finally {
            androidx.core.os.o.b();
        }
    }

    public char[] c() {
        return this.f3334b;
    }

    public C.b d() {
        return this.f3333a;
    }

    int e() {
        return this.f3333a.l();
    }

    a f() {
        return this.f3335c;
    }

    Typeface g() {
        return this.f3336d;
    }

    void h(p pVar) {
        AbstractC0345h.g(pVar, "emoji metadata cannot be null");
        AbstractC0345h.a(pVar.c() > 0, "invalid metadata codepoint length");
        this.f3335c.c(pVar, 0, pVar.c() - 1);
    }
}
