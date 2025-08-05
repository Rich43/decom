package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
final class J extends Writer {

    /* renamed from: a, reason: collision with root package name */
    private final String f3460a;

    /* renamed from: b, reason: collision with root package name */
    private StringBuilder f3461b = new StringBuilder(128);

    J(String str) {
        this.f3460a = str;
    }

    private void j() {
        if (this.f3461b.length() > 0) {
            Log.d(this.f3460a, this.f3461b.toString());
            StringBuilder sb = this.f3461b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        j();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        j();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == '\n') {
                j();
            } else {
                this.f3461b.append(c2);
            }
        }
    }
}
