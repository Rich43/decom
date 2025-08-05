package r1;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class g implements c {

    /* renamed from: a, reason: collision with root package name */
    public final a f7376a = new a();

    /* renamed from: b, reason: collision with root package name */
    public final k f7377b;

    /* renamed from: c, reason: collision with root package name */
    boolean f7378c;

    g(k kVar) {
        if (kVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f7377b = kVar;
    }

    @Override // r1.c
    public long b(d dVar) {
        return k(dVar, 0L);
    }

    @Override // r1.k
    public long c(a aVar, long j2) {
        if (aVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        if (this.f7378c) {
            throw new IllegalStateException("closed");
        }
        a aVar2 = this.f7376a;
        if (aVar2.f7366b == 0 && this.f7377b.c(aVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.f7376a.c(aVar, Math.min(j2, this.f7376a.f7366b));
    }

    @Override // r1.k, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        if (this.f7378c) {
            return;
        }
        this.f7378c = true;
        this.f7377b.close();
        this.f7376a.j();
    }

    @Override // r1.c
    public boolean d(long j2) {
        a aVar;
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        if (this.f7378c) {
            throw new IllegalStateException("closed");
        }
        do {
            aVar = this.f7376a;
            if (aVar.f7366b >= j2) {
                return true;
            }
        } while (this.f7377b.c(aVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    @Override // r1.c
    public a f() {
        return this.f7376a;
    }

    @Override // r1.c
    public long g(d dVar) {
        return j(dVar, 0L);
    }

    @Override // r1.c
    public int i(f fVar) throws EOFException {
        if (this.f7378c) {
            throw new IllegalStateException("closed");
        }
        do {
            int iA = this.f7376a.A(fVar, true);
            if (iA == -1) {
                return -1;
            }
            if (iA != -2) {
                this.f7376a.C(fVar.f7374a[iA].j());
                return iA;
            }
        } while (this.f7377b.c(this.f7376a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return -1;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f7378c;
    }

    public long j(d dVar, long j2) {
        if (this.f7378c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jN = this.f7376a.n(dVar, j2);
            if (jN != -1) {
                return jN;
            }
            a aVar = this.f7376a;
            long j3 = aVar.f7366b;
            if (this.f7377b.c(aVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, (j3 - dVar.j()) + 1);
        }
    }

    public long k(d dVar, long j2) {
        if (this.f7378c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jO = this.f7376a.o(dVar, j2);
            if (jO != -1) {
                return jO;
            }
            a aVar = this.f7376a;
            long j3 = aVar.f7366b;
            if (this.f7377b.c(aVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, j3);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        a aVar = this.f7376a;
        if (aVar.f7366b == 0 && this.f7377b.c(aVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f7376a.read(byteBuffer);
    }

    public String toString() {
        return "buffer(" + this.f7377b + ")";
    }
}
