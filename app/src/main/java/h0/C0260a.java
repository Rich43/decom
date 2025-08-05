package h0;

import android.text.TextUtils;
import e0.InterfaceC0248a;
import java.io.File;

/* renamed from: h0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0260a extends l {

    /* renamed from: f, reason: collision with root package name */
    private int f6370f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f6371g;

    /* renamed from: h, reason: collision with root package name */
    private String f6372h;

    /* renamed from: i, reason: collision with root package name */
    private String f6373i;

    public C0260a(File file) {
        this(file.getAbsolutePath());
    }

    @Override // h0.l
    public boolean equals(Object obj) {
        return TextUtils.equals(c(), ((C0260a) obj).c());
    }

    public String g() {
        return this.f6373i;
    }

    public String h() {
        return this.f6410c + '(' + this.f6370f + ')';
    }

    public boolean i() {
        return this.f6371g;
    }

    public void j(String str) {
        this.f6373i = str;
    }

    public void k(int i2) {
        this.f6370f = i2;
    }

    public String toString() {
        return "AlbumItem <" + this.f6372h + " - " + this.f6370f + '>';
    }

    public C0260a(String str) {
        super(str);
        this.f6371g = str.contains(InterfaceC0248a.f6094b);
        this.f6372h = str;
    }
}
