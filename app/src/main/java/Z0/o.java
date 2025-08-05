package z0;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final float f7816a;

    /* renamed from: b, reason: collision with root package name */
    private final float f7817b;

    public o(float f2, float f3) {
        this.f7816a = f2;
        this.f7817b = f3;
    }

    private static float a(o oVar, o oVar2, o oVar3) {
        float f2 = oVar2.f7816a;
        float f3 = oVar2.f7817b;
        return ((oVar3.f7816a - f2) * (oVar.f7817b - f3)) - ((oVar3.f7817b - f3) * (oVar.f7816a - f2));
    }

    public static float b(o oVar, o oVar2) {
        return E0.a.a(oVar.f7816a, oVar.f7817b, oVar2.f7816a, oVar2.f7817b);
    }

    public static void e(o[] oVarArr) {
        o oVar;
        o oVar2;
        o oVar3;
        float fB = b(oVarArr[0], oVarArr[1]);
        float fB2 = b(oVarArr[1], oVarArr[2]);
        float fB3 = b(oVarArr[0], oVarArr[2]);
        if (fB2 >= fB && fB2 >= fB3) {
            oVar = oVarArr[0];
            oVar2 = oVarArr[1];
            oVar3 = oVarArr[2];
        } else if (fB3 < fB2 || fB3 < fB) {
            oVar = oVarArr[2];
            oVar2 = oVarArr[0];
            oVar3 = oVarArr[1];
        } else {
            oVar = oVarArr[1];
            oVar2 = oVarArr[0];
            oVar3 = oVarArr[2];
        }
        if (a(oVar2, oVar, oVar3) < 0.0f) {
            o oVar4 = oVar3;
            oVar3 = oVar2;
            oVar2 = oVar4;
        }
        oVarArr[0] = oVar2;
        oVarArr[1] = oVar;
        oVarArr[2] = oVar3;
    }

    public final float c() {
        return this.f7816a;
    }

    public final float d() {
        return this.f7817b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f7816a == oVar.f7816a && this.f7817b == oVar.f7817b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f7816a) * 31) + Float.floatToIntBits(this.f7817b);
    }

    public final String toString() {
        return "(" + this.f7816a + ',' + this.f7817b + ')';
    }
}
