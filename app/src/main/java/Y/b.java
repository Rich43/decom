package Y;

import Q.i;
import T.p;
import Y.d;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import d0.C0246c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b extends Y.a {

    /* renamed from: w, reason: collision with root package name */
    private T.a f1287w;

    /* renamed from: x, reason: collision with root package name */
    private final List f1288x;

    /* renamed from: y, reason: collision with root package name */
    private final RectF f1289y;

    /* renamed from: z, reason: collision with root package name */
    private final RectF f1290z;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1291a;

        static {
            int[] iArr = new int[d.b.values().length];
            f1291a = iArr;
            try {
                iArr[d.b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1291a[d.b.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(com.airbnb.lottie.a aVar, d dVar, List list, Q.d dVar2) {
        int i2;
        Y.a aVar2;
        super(aVar, dVar);
        this.f1288x = new ArrayList();
        this.f1289y = new RectF();
        this.f1290z = new RectF();
        W.b bVarS = dVar.s();
        if (bVarS != null) {
            T.a aVarA = bVarS.a();
            this.f1287w = aVarA;
            j(aVarA);
            this.f1287w.a(this);
        } else {
            this.f1287w = null;
        }
        androidx.collection.d dVar3 = new androidx.collection.d(dVar2.j().size());
        int size = list.size() - 1;
        Y.a aVar3 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            d dVar4 = (d) list.get(size);
            Y.a aVarU = Y.a.u(dVar4, aVar, dVar2);
            if (aVarU != null) {
                dVar3.j(aVarU.v().b(), aVarU);
                if (aVar3 != null) {
                    aVar3.F(aVarU);
                    aVar3 = null;
                } else {
                    this.f1288x.add(0, aVarU);
                    int i3 = a.f1291a[dVar4.f().ordinal()];
                    if (i3 == 1 || i3 == 2) {
                        aVar3 = aVarU;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < dVar3.m(); i2++) {
            Y.a aVar4 = (Y.a) dVar3.f(dVar3.i(i2));
            if (aVar4 != null && (aVar2 = (Y.a) dVar3.f(aVar4.v().h())) != null) {
                aVar4.G(aVar2);
            }
        }
    }

    @Override // Y.a
    protected void D(V.e eVar, int i2, List list, V.e eVar2) {
        for (int i3 = 0; i3 < this.f1288x.size(); i3++) {
            ((Y.a) this.f1288x.get(i3)).f(eVar, i2, list, eVar2);
        }
    }

    @Override // Y.a
    public void H(float f2) {
        super.H(f2);
        if (this.f1287w != null) {
            f2 = ((long) (((Float) this.f1287w.h()).floatValue() * 1000.0f)) / this.f1277n.k().d();
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        float fP = f2 - this.o.p();
        for (int size = this.f1288x.size() - 1; size >= 0; size--) {
            ((Y.a) this.f1288x.get(size)).H(fP);
        }
    }

    @Override // Y.a, S.e
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        super.a(rectF, matrix, z2);
        for (int size = this.f1288x.size() - 1; size >= 0; size--) {
            this.f1289y.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((Y.a) this.f1288x.get(size)).a(this.f1289y, this.f1276m, true);
            rectF.union(this.f1289y);
        }
    }

    @Override // Y.a, V.f
    public void c(Object obj, C0246c c0246c) {
        super.c(obj, c0246c);
        if (obj == i.f587A) {
            if (c0246c == null) {
                this.f1287w = null;
                return;
            }
            p pVar = new p(c0246c);
            this.f1287w = pVar;
            j(pVar);
        }
    }

    @Override // Y.a
    void t(Canvas canvas, Matrix matrix, int i2) {
        Q.c.a("CompositionLayer#draw");
        canvas.save();
        this.f1290z.set(0.0f, 0.0f, this.o.j(), this.o.i());
        matrix.mapRect(this.f1290z);
        for (int size = this.f1288x.size() - 1; size >= 0; size--) {
            if (!this.f1290z.isEmpty() ? canvas.clipRect(this.f1290z) : true) {
                ((Y.a) this.f1288x.get(size)).g(canvas, matrix, i2);
            }
        }
        canvas.restore();
        Q.c.b("CompositionLayer#draw");
    }
}
