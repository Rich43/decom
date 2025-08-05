package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.InterfaceC0206k;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class ImmLeaksCleaner implements InterfaceC0206k {

    /* renamed from: b, reason: collision with root package name */
    public static final c f1470b = new c(null);

    /* renamed from: c, reason: collision with root package name */
    private static final a1.a f1471c = a1.b.a(b.f1473b);

    /* renamed from: a, reason: collision with root package name */
    private final Activity f1472a;

    public static abstract class a {
        public /* synthetic */ a(i1.g gVar) {
            this();
        }

        public abstract boolean a(InputMethodManager inputMethodManager);

        public abstract Object b(InputMethodManager inputMethodManager);

        public abstract View c(InputMethodManager inputMethodManager);

        private a() {
        }
    }

    static final class b extends i1.l implements h1.a {

        /* renamed from: b, reason: collision with root package name */
        public static final b f1473b = new b();

        b() {
            super(0);
        }

        @Override // h1.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final a a() throws NoSuchFieldException, SecurityException {
            try {
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                declaredField3.setAccessible(true);
                i1.k.d(declaredField3, "hField");
                i1.k.d(declaredField, "servedViewField");
                i1.k.d(declaredField2, "nextServedViewField");
                return new e(declaredField3, declaredField, declaredField2);
            } catch (NoSuchFieldException unused) {
                return d.f1474a;
            }
        }
    }

    public static final class c {
        public /* synthetic */ c(i1.g gVar) {
            this();
        }

        public final a a() {
            return (a) ImmLeaksCleaner.f1471c.getValue();
        }

        private c() {
        }
    }

    public static final class d extends a {

        /* renamed from: a, reason: collision with root package name */
        public static final d f1474a = new d();

        private d() {
            super(null);
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public boolean a(InputMethodManager inputMethodManager) {
            i1.k.e(inputMethodManager, "<this>");
            return false;
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public Object b(InputMethodManager inputMethodManager) {
            i1.k.e(inputMethodManager, "<this>");
            return null;
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public View c(InputMethodManager inputMethodManager) {
            i1.k.e(inputMethodManager, "<this>");
            return null;
        }
    }

    public static final class e extends a {

        /* renamed from: a, reason: collision with root package name */
        private final Field f1475a;

        /* renamed from: b, reason: collision with root package name */
        private final Field f1476b;

        /* renamed from: c, reason: collision with root package name */
        private final Field f1477c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Field field, Field field2, Field field3) {
            super(null);
            i1.k.e(field, "hField");
            i1.k.e(field2, "servedViewField");
            i1.k.e(field3, "nextServedViewField");
            this.f1475a = field;
            this.f1476b = field2;
            this.f1477c = field3;
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public boolean a(InputMethodManager inputMethodManager) throws IllegalAccessException, IllegalArgumentException {
            i1.k.e(inputMethodManager, "<this>");
            try {
                this.f1477c.set(inputMethodManager, null);
                return true;
            } catch (IllegalAccessException unused) {
                return false;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public Object b(InputMethodManager inputMethodManager) {
            i1.k.e(inputMethodManager, "<this>");
            try {
                return this.f1475a.get(inputMethodManager);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public View c(InputMethodManager inputMethodManager) {
            i1.k.e(inputMethodManager, "<this>");
            try {
                return (View) this.f1476b.get(inputMethodManager);
            } catch (ClassCastException | IllegalAccessException unused) {
                return null;
            }
        }
    }

    public ImmLeaksCleaner(Activity activity) {
        i1.k.e(activity, "activity");
        this.f1472a = activity;
    }

    @Override // androidx.lifecycle.InterfaceC0206k
    public void d(androidx.lifecycle.m mVar, AbstractC0203h.a aVar) {
        i1.k.e(mVar, "source");
        i1.k.e(aVar, "event");
        if (aVar != AbstractC0203h.a.ON_DESTROY) {
            return;
        }
        Object systemService = this.f1472a.getSystemService("input_method");
        i1.k.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        a aVarA = f1470b.a();
        Object objB = aVarA.b(inputMethodManager);
        if (objB == null) {
            return;
        }
        synchronized (objB) {
            View viewC = aVarA.c(inputMethodManager);
            if (viewC == null) {
                return;
            }
            if (viewC.isAttachedToWindow()) {
                return;
            }
            boolean zA = aVarA.a(inputMethodManager);
            if (zA) {
                inputMethodManager.isActive();
            }
        }
    }
}
