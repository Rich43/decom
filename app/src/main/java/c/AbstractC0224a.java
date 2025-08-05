package c;

import android.content.Context;
import android.content.Intent;
import i1.k;

/* renamed from: c.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0224a {

    /* renamed from: c.a$a, reason: collision with other inner class name */
    public static final class C0062a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f4629a;

        public C0062a(Object obj) {
            this.f4629a = obj;
        }

        public final Object a() {
            return this.f4629a;
        }
    }

    public abstract Intent a(Context context, Object obj);

    public C0062a b(Context context, Object obj) {
        k.e(context, "context");
        return null;
    }

    public abstract Object c(int i2, Intent intent);
}
