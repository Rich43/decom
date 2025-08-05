package h0;

import android.content.Context;
import com.caglobal.kodakluma.R;
import java.io.File;
import q0.AbstractC0313b;

/* loaded from: classes.dex */
public class m extends l {

    /* renamed from: f, reason: collision with root package name */
    private final long f6412f;

    /* renamed from: g, reason: collision with root package name */
    private String f6413g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6414h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6415i;

    /* renamed from: j, reason: collision with root package name */
    private int f6416j;

    public m(File file) {
        super(file);
        this.f6415i = true;
        this.f6412f = file.length();
    }

    public String g() {
        return this.f6413g;
    }

    public int h() {
        return this.f6416j;
    }

    public void i(Context context) {
        if (AbstractC0313b.l(this.f6411d)) {
            this.f6413g = context.getString(R.string.media_today);
        } else if (AbstractC0313b.n(this.f6411d)) {
            this.f6413g = context.getString(R.string.media_yesterday);
        } else {
            this.f6413g = AbstractC0313b.f(context.getString(R.string.media_date), this.f6411d);
        }
    }

    public void j(boolean z2) {
        this.f6414h = z2;
    }

    public void k(int i2) {
        this.f6416j = i2;
    }

    public void l(boolean z2) {
        this.f6415i = z2;
    }

    public String toString() {
        return "PhotoItem <" + this.f6409b + " - " + this.f6413g + " - " + this.f6416j + '>';
    }
}
