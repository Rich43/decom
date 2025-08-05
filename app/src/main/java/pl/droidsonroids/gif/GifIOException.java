package pl.droidsonroids.gif;

import java.io.IOException;

/* loaded from: classes.dex */
public class GifIOException extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final b f7133a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7134b;

    private GifIOException(int i2, String str) {
        this.f7133a = b.a(i2);
        this.f7134b = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.f7134b == null) {
            return this.f7133a.b();
        }
        return this.f7133a.b() + ": " + this.f7134b;
    }
}
