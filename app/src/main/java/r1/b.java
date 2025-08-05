package r1;

import java.io.Closeable;
import java.io.Flushable;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface b extends Closeable, Flushable, WritableByteChannel {
    b a(String str, int i2, int i3);

    b e(String str);

    b h(int i2);
}
