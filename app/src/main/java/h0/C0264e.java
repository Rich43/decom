package h0;

import android.content.Context;
import android.text.format.Formatter;
import com.caglobal.kodakluma.R;
import java.io.File;
import q0.AbstractC0313b;

/* renamed from: h0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0264e extends l {

    /* renamed from: f, reason: collision with root package name */
    private final long f6387f;

    /* renamed from: g, reason: collision with root package name */
    private String f6388g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6389h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6390i;

    /* renamed from: j, reason: collision with root package name */
    private int f6391j;

    /* renamed from: k, reason: collision with root package name */
    private final int f6392k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6393l;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0264e(java.io.File r6) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.C0264e.<init>(java.io.File):void");
    }

    public String g() {
        return this.f6388g;
    }

    public int h() {
        return this.f6391j;
    }

    public int i() {
        return this.f6392k;
    }

    public String j(Context context) {
        return Formatter.formatFileSize(context, this.f6387f);
    }

    public boolean k() {
        return this.f6393l;
    }

    public void l(Context context) {
        if (AbstractC0313b.l(this.f6411d)) {
            this.f6388g = context.getString(R.string.media_today);
        } else if (AbstractC0313b.n(this.f6411d)) {
            this.f6388g = context.getString(R.string.media_yesterday);
        } else {
            this.f6388g = AbstractC0313b.f(context.getString(R.string.media_date), this.f6411d);
        }
    }

    public void m(boolean z2) {
        this.f6393l = z2;
    }

    public void n(boolean z2) {
        this.f6389h = z2;
    }

    public void o(int i2) {
        this.f6391j = i2;
    }

    public void p(boolean z2) {
        this.f6390i = z2;
    }

    public String toString() {
        return "DocumentItem <" + this.f6409b + " - " + this.f6388g + '>';
    }

    public C0264e(String str) {
        this(new File(str));
    }
}
