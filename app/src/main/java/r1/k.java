package r1;

import java.io.Closeable;

/* loaded from: classes.dex */
public interface k extends Closeable {
    long c(a aVar, long j2);

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    void close();
}
