package c;

import android.content.Context;
import android.content.Intent;
import b.C0211a;
import i1.g;
import i1.k;

/* renamed from: c.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0226c extends AbstractC0224a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4631a = new a(null);

    /* renamed from: c.c$a */
    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    @Override // c.AbstractC0224a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent intent) {
        k.e(context, "context");
        k.e(intent, "input");
        return intent;
    }

    @Override // c.AbstractC0224a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0211a c(int i2, Intent intent) {
        return new C0211a(i2, intent);
    }
}
