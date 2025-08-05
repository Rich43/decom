package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.InterfaceC0206k;

/* loaded from: classes.dex */
class FragmentManager$6 implements InterfaceC0206k {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3433a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC0203h f3434b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ w f3435c;

    @Override // androidx.lifecycle.InterfaceC0206k
    public void d(androidx.lifecycle.m mVar, AbstractC0203h.a aVar) {
        if (aVar == AbstractC0203h.a.ON_START && ((Bundle) this.f3435c.f3612k.get(this.f3433a)) != null) {
            throw null;
        }
        if (aVar == AbstractC0203h.a.ON_DESTROY) {
            this.f3434b.c(this);
            this.f3435c.f3613l.remove(this.f3433a);
        }
    }
}
