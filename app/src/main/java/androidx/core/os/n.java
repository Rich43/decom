package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
final class n implements g {

    /* renamed from: a */
    private final LocaleList f3067a;

    n(Object obj) {
        this.f3067a = m.a(obj);
    }

    @Override // androidx.core.os.g
    public Object a() {
        return this.f3067a;
    }

    @Override // androidx.core.os.g
    public String b() {
        return this.f3067a.toLanguageTags();
    }

    public boolean equals(Object obj) {
        return this.f3067a.equals(((g) obj).a());
    }

    @Override // androidx.core.os.g
    public Locale get(int i2) {
        return this.f3067a.get(i2);
    }

    public int hashCode() {
        return this.f3067a.hashCode();
    }

    @Override // androidx.core.os.g
    public boolean isEmpty() {
        return this.f3067a.isEmpty();
    }

    @Override // androidx.core.os.g
    public int size() {
        return this.f3067a.size();
    }

    public String toString() {
        return this.f3067a.toString();
    }
}
