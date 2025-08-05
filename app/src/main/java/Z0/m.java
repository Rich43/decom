package z0;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final String f7799a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f7800b;

    /* renamed from: c, reason: collision with root package name */
    private final int f7801c;

    /* renamed from: d, reason: collision with root package name */
    private o[] f7802d;
    private final EnumC0379a e;

    /* renamed from: f, reason: collision with root package name */
    private Map f7803f;

    /* renamed from: g, reason: collision with root package name */
    private final long f7804g;

    public m(String str, byte[] bArr, o[] oVarArr, EnumC0379a enumC0379a) {
        this(str, bArr, oVarArr, enumC0379a, System.currentTimeMillis());
    }

    public void a(o[] oVarArr) {
        o[] oVarArr2 = this.f7802d;
        if (oVarArr2 == null) {
            this.f7802d = oVarArr;
            return;
        }
        if (oVarArr == null || oVarArr.length <= 0) {
            return;
        }
        o[] oVarArr3 = new o[oVarArr2.length + oVarArr.length];
        System.arraycopy(oVarArr2, 0, oVarArr3, 0, oVarArr2.length);
        System.arraycopy(oVarArr, 0, oVarArr3, oVarArr2.length, oVarArr.length);
        this.f7802d = oVarArr3;
    }

    public EnumC0379a b() {
        return this.e;
    }

    public byte[] c() {
        return this.f7800b;
    }

    public Map d() {
        return this.f7803f;
    }

    public o[] e() {
        return this.f7802d;
    }

    public String f() {
        return this.f7799a;
    }

    public void g(Map map) {
        if (map != null) {
            Map map2 = this.f7803f;
            if (map2 == null) {
                this.f7803f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(n nVar, Object obj) {
        if (this.f7803f == null) {
            this.f7803f = new EnumMap(n.class);
        }
        this.f7803f.put(nVar, obj);
    }

    public String toString() {
        return this.f7799a;
    }

    public m(String str, byte[] bArr, o[] oVarArr, EnumC0379a enumC0379a, long j2) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, oVarArr, enumC0379a, j2);
    }

    public m(String str, byte[] bArr, int i2, o[] oVarArr, EnumC0379a enumC0379a, long j2) {
        this.f7799a = str;
        this.f7800b = bArr;
        this.f7801c = i2;
        this.f7802d = oVarArr;
        this.e = enumC0379a;
        this.f7803f = null;
        this.f7804g = j2;
    }
}
