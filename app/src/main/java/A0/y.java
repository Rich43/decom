package a0;

import android.graphics.PointF;
import b0.c;

/* loaded from: classes.dex */
public class y implements J {

    /* renamed from: a, reason: collision with root package name */
    public static final y f1432a = new y();

    private y() {
    }

    @Override // a0.J
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(b0.c cVar, float f2) {
        c.b bVarW = cVar.w();
        if (bVarW == c.b.BEGIN_ARRAY) {
            return p.e(cVar, f2);
        }
        if (bVarW == c.b.BEGIN_OBJECT) {
            return p.e(cVar, f2);
        }
        if (bVarW == c.b.NUMBER) {
            PointF pointF = new PointF(((float) cVar.r()) * f2, ((float) cVar.r()) * f2);
            while (cVar.p()) {
                cVar.A();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + bVarW);
    }
}
