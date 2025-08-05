package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: f */
    public static final a f3753f = new a(null);

    /* renamed from: g */
    private static final Class[] f3754g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a */
    private final Map f3755a;

    /* renamed from: b */
    private final Map f3756b;

    /* renamed from: c */
    private final Map f3757c;

    /* renamed from: d */
    private final Map f3758d;
    private final a.c e;

    public static final class a {
        public /* synthetic */ a(i1.g gVar) {
            this();
        }

        public final y a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new y();
                }
                HashMap map = new HashMap();
                for (String str : bundle2.keySet()) {
                    i1.k.d(str, "key");
                    map.put(str, bundle2.get(str));
                }
                return new y(map);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = parcelableArrayList.get(i2);
                i1.k.c(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i2));
            }
            return new y(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : y.f3754g) {
                i1.k.b(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        private a() {
        }
    }

    public y(Map map) {
        i1.k.e(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f3755a = linkedHashMap;
        this.f3756b = new LinkedHashMap();
        this.f3757c = new LinkedHashMap();
        this.f3758d = new LinkedHashMap();
        this.e = new a.c() { // from class: androidx.lifecycle.x
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                return y.d(this.f3752a);
            }
        };
        linkedHashMap.putAll(map);
    }

    public static final Bundle d(y yVar) {
        i1.k.e(yVar, "this$0");
        for (Map.Entry entry : b1.B.i(yVar.f3756b).entrySet()) {
            yVar.e((String) entry.getKey(), ((a.c) entry.getValue()).a());
        }
        Set<String> setKeySet = yVar.f3755a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(yVar.f3755a.get(str));
        }
        return androidx.core.os.c.a(a1.g.a("keys", arrayList), a1.g.a("values", arrayList2));
    }

    public final a.c c() {
        return this.e;
    }

    public final void e(String str, Object obj) {
        i1.k.e(str, "key");
        if (!f3753f.b(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't put value with type ");
            i1.k.b(obj);
            sb.append(obj.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString());
        }
        Object obj2 = this.f3757c.get(str);
        q qVar = obj2 instanceof q ? (q) obj2 : null;
        if (qVar != null) {
            qVar.h(obj);
        } else {
            this.f3755a.put(str, obj);
        }
        androidx.appcompat.app.F.a(this.f3758d.get(str));
    }

    public y() {
        this.f3755a = new LinkedHashMap();
        this.f3756b = new LinkedHashMap();
        this.f3757c = new LinkedHashMap();
        this.f3758d = new LinkedHashMap();
        this.e = new a.c() { // from class: androidx.lifecycle.x
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                return y.d(this.f3752a);
            }
        };
    }
}
