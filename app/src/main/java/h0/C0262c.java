package h0;

import android.text.TextUtils;
import com.github.promeg.pinyinhelper.Pinyin;
import java.io.File;

/* renamed from: h0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0262c extends l {

    /* renamed from: f, reason: collision with root package name */
    private long f6378f;

    /* renamed from: g, reason: collision with root package name */
    private String f6379g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6380h;

    public C0262c(File file) {
        super(file);
    }

    private void h() {
        if (TextUtils.isEmpty(this.f6410c)) {
            this.f6379g = "#";
        }
        char cCharAt = this.f6410c.charAt(0);
        if (Pinyin.isChinese(cCharAt)) {
            this.f6379g = Pinyin.toPinyin(cCharAt).substring(0, 1);
            return;
        }
        if (cCharAt >= 'A' && cCharAt <= 'Z') {
            this.f6379g = this.f6410c.substring(0, 1);
        } else if (cCharAt < 'a' || cCharAt > 'z') {
            this.f6379g = "#";
        } else {
            this.f6379g = this.f6410c.substring(0, 1).toUpperCase();
        }
    }

    @Override // h0.l
    public void f(String str) {
        super.f(str);
        h();
    }

    public String g() {
        return this.f6379g;
    }

    public void i(long j2) {
        this.f6378f = j2;
    }

    public void j(boolean z2) {
        this.f6380h = z2;
    }

    public String toString() {
        return "VideoItem <" + this.f6409b + " - " + this.f6410c + " - " + this.f6378f + '>';
    }

    public C0262c(String str) {
        super(str);
    }
}
