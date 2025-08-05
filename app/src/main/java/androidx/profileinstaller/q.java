package androidx.profileinstaller;

import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f3831a = {48, 49, 53, 0};

    /* renamed from: b, reason: collision with root package name */
    static final byte[] f3832b = {48, 49, 48, 0};

    /* renamed from: c, reason: collision with root package name */
    static final byte[] f3833c = {48, 48, 57, 0};

    /* renamed from: d, reason: collision with root package name */
    static final byte[] f3834d = {48, 48, 53, 0};
    static final byte[] e = {48, 48, 49, 0};

    /* renamed from: f, reason: collision with root package name */
    static final byte[] f3835f = {48, 48, 49, 0};

    /* renamed from: g, reason: collision with root package name */
    static final byte[] f3836g = {48, 48, 50, 0};

    static String a(byte[] bArr) {
        return (Arrays.equals(bArr, e) || Arrays.equals(bArr, f3834d)) ? ":" : "!";
    }
}
