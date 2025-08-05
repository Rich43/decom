package h0;

import android.content.Context;
import android.text.TextUtils;
import com.caglobal.kodakluma.R;
import e0.InterfaceC0248a;
import java.io.File;
import java.util.regex.Pattern;
import q0.AbstractC0313b;

/* loaded from: classes.dex */
public class n extends l {

    /* renamed from: f, reason: collision with root package name */
    private long f6417f;

    /* renamed from: g, reason: collision with root package name */
    private final String f6418g;

    /* renamed from: h, reason: collision with root package name */
    private String f6419h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6420i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6421j;

    /* renamed from: k, reason: collision with root package name */
    private int f6422k;

    public n(File file) {
        super(file);
        this.f6421j = true;
        this.f6418g = String.format(InterfaceC0248a.f6096d, this.f6409b.replace(InterfaceC0248a.f6093a, "").replaceAll("/", Pattern.quote("$")));
    }

    public String g() {
        return this.f6419h;
    }

    public String h() {
        return AbstractC0313b.b(this.f6417f);
    }

    public int i() {
        return this.f6422k;
    }

    public String j() {
        return this.f6418g;
    }

    public boolean k() {
        return !TextUtils.isEmpty(this.f6418g) && new File(this.f6418g).exists();
    }

    public void l(Context context) {
        if (AbstractC0313b.l(this.f6411d)) {
            this.f6419h = context.getString(R.string.media_today);
        } else if (AbstractC0313b.n(this.f6411d)) {
            this.f6419h = context.getString(R.string.media_yesterday);
        } else {
            this.f6419h = AbstractC0313b.f(context.getString(R.string.media_date), this.f6411d);
        }
    }

    public void m(long j2) {
        this.f6417f = j2;
    }

    public void n(boolean z2) {
        this.f6420i = z2;
    }

    public void o(int i2) {
        this.f6422k = i2;
    }

    public void p(boolean z2) {
        this.f6421j = z2;
    }

    public String toString() {
        return "VideoItem <" + this.f6409b + " - " + this.f6410c + " - " + this.f6417f + '>';
    }

    public n(String str) {
        this(new File(str));
    }
}
