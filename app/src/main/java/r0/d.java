package r0;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class d extends h {

    /* renamed from: b, reason: collision with root package name */
    private byte[] f7352b;

    public d(byte[] bArr) {
        this.f7352b = bArr;
    }

    @Override // r0.h
    void b(C0323b c0323b) throws IOException {
        c0323b.m(4, this.f7352b.length);
        c0323b.i(this.f7352b);
    }

    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && Arrays.equals(((d) obj).f7352b, this.f7352b);
    }

    public int hashCode() {
        return 335 + Arrays.hashCode(this.f7352b);
    }

    public d(String str) {
        this.f7352b = AbstractC0322a.d(str.replaceAll("\\s+", ""));
    }
}
