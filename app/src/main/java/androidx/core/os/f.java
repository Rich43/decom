package androidx.core.os;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes.dex */
final class f implements g {

    /* renamed from: c */
    private static final Locale[] f3062c = new Locale[0];

    /* renamed from: d */
    private static final Locale f3063d = new Locale("en", "XA");
    private static final Locale e = new Locale("ar", "XB");

    /* renamed from: f */
    private static final Locale f3064f = e.b("en-Latn");

    /* renamed from: a */
    private final Locale[] f3065a;

    /* renamed from: b */
    private final String f3066b;

    f(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f3065a = f3062c;
            this.f3066b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < localeArr.length; i2++) {
            Locale locale = localeArr[i2];
            if (locale == null) {
                throw new NullPointerException("list[" + i2 + "] is null");
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                c(sb, locale2);
                if (i2 < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.f3065a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f3066b = sb.toString();
    }

    static void c(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append('-');
        sb.append(locale.getCountry());
    }

    @Override // androidx.core.os.g
    public Object a() {
        return null;
    }

    @Override // androidx.core.os.g
    public String b() {
        return this.f3066b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        Locale[] localeArr = ((f) obj).f3065a;
        if (this.f3065a.length != localeArr.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Locale[] localeArr2 = this.f3065a;
            if (i2 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i2].equals(localeArr[i2])) {
                return false;
            }
            i2++;
        }
    }

    @Override // androidx.core.os.g
    public Locale get(int i2) {
        if (i2 >= 0) {
            Locale[] localeArr = this.f3065a;
            if (i2 < localeArr.length) {
                return localeArr[i2];
            }
        }
        return null;
    }

    public int hashCode() {
        int iHashCode = 1;
        for (Locale locale : this.f3065a) {
            iHashCode = (iHashCode * 31) + locale.hashCode();
        }
        return iHashCode;
    }

    @Override // androidx.core.os.g
    public boolean isEmpty() {
        return this.f3065a.length == 0;
    }

    @Override // androidx.core.os.g
    public int size() {
        return this.f3065a.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f3065a;
            if (i2 >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i2]);
            if (i2 < this.f3065a.length - 1) {
                sb.append(',');
            }
            i2++;
        }
    }
}
