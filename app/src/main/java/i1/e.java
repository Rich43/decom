package i1;

import b1.B;
import h1.q;
import h1.r;
import h1.s;
import h1.t;
import h1.u;
import h1.v;
import h1.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e implements n1.b, d {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6465b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Map f6466c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap f6467d;
    private static final HashMap e;

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap f6468f;

    /* renamed from: g, reason: collision with root package name */
    private static final Map f6469g;

    /* renamed from: a, reason: collision with root package name */
    private final Class f6470a;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    static {
        int i2 = 0;
        List listG = b1.l.g(h1.a.class, h1.l.class, h1.p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, h1.b.class, h1.c.class, h1.d.class, h1.e.class, h1.f.class, h1.g.class, h1.h.class, h1.i.class, h1.j.class, h1.k.class, h1.m.class, h1.n.class, h1.o.class);
        ArrayList arrayList = new ArrayList(b1.l.i(listG, 10));
        for (Object obj : listG) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                b1.l.h();
            }
            arrayList.add(a1.g.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        f6466c = B.g(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f6467d = map;
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        e = map2;
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        k.d(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            k.b(str);
            sb.append(p1.c.m(str, '.', null, 2, null));
            sb.append("CompanionObject");
            a1.e eVarA = a1.g.a(sb.toString(), str + ".Companion");
            map3.put(eVarA.c(), eVarA.d());
        }
        for (Map.Entry entry : f6466c.entrySet()) {
            map3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + ((Number) entry.getValue()).intValue());
        }
        f6468f = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(B.a(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), p1.c.m((String) entry2.getValue(), '.', null, 2, null));
        }
        f6469g = linkedHashMap;
    }

    public e(Class cls) {
        k.e(cls, "jClass");
        this.f6470a = cls;
    }

    @Override // i1.d
    public Class a() {
        return this.f6470a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && k.a(g1.a.b(this), g1.a.b((n1.b) obj));
    }

    public int hashCode() {
        return g1.a.b(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
