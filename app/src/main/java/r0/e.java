package r0;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class e extends h {

    /* renamed from: c, reason: collision with root package name */
    private static final SimpleDateFormat f7353c;

    /* renamed from: d, reason: collision with root package name */
    private static final SimpleDateFormat f7354d;

    /* renamed from: b, reason: collision with root package name */
    private Date f7355b;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        f7353c = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        f7354d = simpleDateFormat2;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public e(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.f7355b = date;
    }

    @Override // r0.h
    public void b(C0323b c0323b) throws IOException {
        c0323b.f(51);
        c0323b.k((this.f7355b.getTime() - 978307200000L) / 1000.0d);
    }

    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && this.f7355b.equals(((e) obj).j());
    }

    public int hashCode() {
        return this.f7355b.hashCode();
    }

    public Date j() {
        return this.f7355b;
    }

    public String toString() {
        return this.f7355b.toString();
    }
}
