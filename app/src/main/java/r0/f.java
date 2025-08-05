package r0;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class f extends h implements Map {

    /* renamed from: b */
    private HashMap f7356b = new LinkedHashMap();

    @Override // r0.h
    void a(C0323b c0323b) {
        super.a(c0323b);
        for (Map.Entry entry : this.f7356b.entrySet()) {
            new i((String) entry.getKey()).a(c0323b);
            ((h) entry.getValue()).a(c0323b);
        }
    }

    @Override // r0.h
    void b(C0323b c0323b) throws IOException {
        c0323b.m(13, this.f7356b.size());
        Set setEntrySet = this.f7356b.entrySet();
        Iterator it = setEntrySet.iterator();
        while (it.hasNext()) {
            c0323b.l(c0323b.d(new i((String) ((Map.Entry) it.next()).getKey())));
        }
        Iterator it2 = setEntrySet.iterator();
        while (it2.hasNext()) {
            c0323b.l(c0323b.d((h) ((Map.Entry) it2.next()).getValue()));
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.f7356b.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f7356b.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f7356b.containsValue(h.h(obj));
    }

    @Override // java.util.Map
    public Set entrySet() {
        return this.f7356b.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && ((f) obj).f7356b.equals(this.f7356b);
    }

    @Override // java.util.Map
    public int hashCode() {
        HashMap map = this.f7356b;
        return 581 + (map != null ? map.hashCode() : 0);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f7356b.isEmpty();
    }

    @Override // java.util.Map
    /* renamed from: j */
    public h get(Object obj) {
        return (h) this.f7356b.get(obj);
    }

    public HashMap k() {
        return this.f7356b;
    }

    @Override // java.util.Map
    public Set keySet() {
        return this.f7356b.keySet();
    }

    public h l(String str, long j2) {
        return put(str, new g(j2));
    }

    @Override // java.util.Map
    /* renamed from: m */
    public h put(String str, h hVar) {
        return (h) this.f7356b.put(str, hVar);
    }

    public h n(String str, boolean z2) {
        return put(str, new g(z2));
    }

    @Override // java.util.Map
    /* renamed from: o */
    public h remove(Object obj) {
        return (h) this.f7356b.remove(obj);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put((String) entry.getKey(), (h) entry.getValue());
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.f7356b.size();
    }

    @Override // java.util.Map
    public Collection values() {
        return this.f7356b.values();
    }
}
