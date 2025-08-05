package r1;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f7371a = Logger.getLogger(e.class.getName());

    final class a implements k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f7372a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ InputStream f7373b;

        a(l lVar, InputStream inputStream) {
            this.f7372a = lVar;
            this.f7373b = inputStream;
        }

        @Override // r1.k
        public long c(r1.a aVar, long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            if (j2 == 0) {
                return 0L;
            }
            try {
                this.f7372a.a();
                h hVarF = aVar.F(1);
                int i2 = this.f7373b.read(hVarF.f7379a, hVarF.f7381c, (int) Math.min(j2, 8192 - hVarF.f7381c));
                if (i2 == -1) {
                    return -1L;
                }
                hVarF.f7381c += i2;
                long j3 = i2;
                aVar.f7366b += j3;
                return j3;
            } catch (AssertionError e) {
                if (e.b(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }

        @Override // r1.k, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            this.f7373b.close();
        }

        public String toString() {
            return "source(" + this.f7373b + ")";
        }
    }

    public static c a(k kVar) {
        return new g(kVar);
    }

    static boolean b(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static k c(InputStream inputStream) {
        return d(inputStream, new l());
    }

    private static k d(InputStream inputStream, l lVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (lVar != null) {
            return new a(lVar, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }
}
