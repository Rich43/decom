package androidx.media;

import android.text.TextUtils;
import v.AbstractC0340c;

/* loaded from: classes.dex */
class g implements c {

    /* renamed from: a, reason: collision with root package name */
    private String f3778a;

    /* renamed from: b, reason: collision with root package name */
    private int f3779b;

    /* renamed from: c, reason: collision with root package name */
    private int f3780c;

    g(String str, int i2, int i3) {
        this.f3778a = str;
        this.f3779b = i2;
        this.f3780c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return TextUtils.equals(this.f3778a, gVar.f3778a) && this.f3779b == gVar.f3779b && this.f3780c == gVar.f3780c;
    }

    public int hashCode() {
        return AbstractC0340c.b(this.f3778a, Integer.valueOf(this.f3779b), Integer.valueOf(this.f3780c));
    }
}
