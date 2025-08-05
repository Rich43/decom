package O;

import O.l;
import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class p extends l {

    /* renamed from: L */
    int f493L;

    /* renamed from: J */
    private ArrayList f491J = new ArrayList();

    /* renamed from: K */
    private boolean f492K = true;

    /* renamed from: M */
    boolean f494M = false;

    /* renamed from: N */
    private int f495N = 0;

    class a extends m {

        /* renamed from: a */
        final /* synthetic */ l f496a;

        a(l lVar) {
            this.f496a = lVar;
        }

        @Override // O.l.f
        public void b(l lVar) {
            this.f496a.S();
            lVar.O(this);
        }
    }

    static class b extends m {

        /* renamed from: a */
        p f498a;

        b(p pVar) {
            this.f498a = pVar;
        }

        @Override // O.l.f
        public void b(l lVar) {
            p pVar = this.f498a;
            int i2 = pVar.f493L - 1;
            pVar.f493L = i2;
            if (i2 == 0) {
                pVar.f494M = false;
                pVar.o();
            }
            lVar.O(this);
        }

        @Override // O.m, O.l.f
        public void c(l lVar) {
            p pVar = this.f498a;
            if (pVar.f494M) {
                return;
            }
            pVar.Z();
            this.f498a.f494M = true;
        }
    }

    private void m0() {
        b bVar = new b(this);
        Iterator it = this.f491J.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(bVar);
        }
        this.f493L = this.f491J.size();
    }

    @Override // O.l
    public void M(View view) {
        super.M(view);
        int size = this.f491J.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((l) this.f491J.get(i2)).M(view);
        }
    }

    @Override // O.l
    public void Q(View view) {
        super.Q(view);
        int size = this.f491J.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((l) this.f491J.get(i2)).Q(view);
        }
    }

    @Override // O.l
    protected void S() {
        if (this.f491J.isEmpty()) {
            Z();
            o();
            return;
        }
        m0();
        if (this.f492K) {
            Iterator it = this.f491J.iterator();
            while (it.hasNext()) {
                ((l) it.next()).S();
            }
            return;
        }
        for (int i2 = 1; i2 < this.f491J.size(); i2++) {
            ((l) this.f491J.get(i2 - 1)).a(new a((l) this.f491J.get(i2)));
        }
        l lVar = (l) this.f491J.get(0);
        if (lVar != null) {
            lVar.S();
        }
    }

    @Override // O.l
    public void U(l.e eVar) {
        super.U(eVar);
        this.f495N |= 8;
        int size = this.f491J.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((l) this.f491J.get(i2)).U(eVar);
        }
    }

    @Override // O.l
    public void W(AbstractC0111g abstractC0111g) {
        super.W(abstractC0111g);
        this.f495N |= 4;
        for (int i2 = 0; i2 < this.f491J.size(); i2++) {
            ((l) this.f491J.get(i2)).W(abstractC0111g);
        }
    }

    @Override // O.l
    public void X(o oVar) {
        super.X(oVar);
        this.f495N |= 2;
        int size = this.f491J.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((l) this.f491J.get(i2)).X(oVar);
        }
    }

    @Override // O.l
    String a0(String str) {
        String strA0 = super.a0(str);
        for (int i2 = 0; i2 < this.f491J.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strA0);
            sb.append("\n");
            sb.append(((l) this.f491J.get(i2)).a0(str + "  "));
            strA0 = sb.toString();
        }
        return strA0;
    }

    @Override // O.l
    /* renamed from: b0 */
    public p a(l.f fVar) {
        return (p) super.a(fVar);
    }

    @Override // O.l
    /* renamed from: c0 */
    public p b(View view) {
        for (int i2 = 0; i2 < this.f491J.size(); i2++) {
            ((l) this.f491J.get(i2)).b(view);
        }
        return (p) super.b(view);
    }

    public p d0(l lVar) {
        this.f491J.add(lVar);
        lVar.r = this;
        long j2 = this.f457c;
        if (j2 >= 0) {
            lVar.T(j2);
        }
        if ((this.f495N & 1) != 0) {
            lVar.V(r());
        }
        if ((this.f495N & 2) != 0) {
            v();
            lVar.X(null);
        }
        if ((this.f495N & 4) != 0) {
            lVar.W(u());
        }
        if ((this.f495N & 8) != 0) {
            lVar.U(q());
        }
        return this;
    }

    public l e0(int i2) {
        if (i2 < 0 || i2 >= this.f491J.size()) {
            return null;
        }
        return (l) this.f491J.get(i2);
    }

    @Override // O.l
    public void f(s sVar) {
        if (F(sVar.f503b)) {
            Iterator it = this.f491J.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar.F(sVar.f503b)) {
                    lVar.f(sVar);
                    sVar.f504c.add(lVar);
                }
            }
        }
    }

    public int f0() {
        return this.f491J.size();
    }

    @Override // O.l
    /* renamed from: g0 */
    public p O(l.f fVar) {
        return (p) super.O(fVar);
    }

    @Override // O.l
    void h(s sVar) {
        super.h(sVar);
        int size = this.f491J.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((l) this.f491J.get(i2)).h(sVar);
        }
    }

    @Override // O.l
    /* renamed from: h0 */
    public p P(View view) {
        for (int i2 = 0; i2 < this.f491J.size(); i2++) {
            ((l) this.f491J.get(i2)).P(view);
        }
        return (p) super.P(view);
    }

    @Override // O.l
    public void i(s sVar) {
        if (F(sVar.f503b)) {
            Iterator it = this.f491J.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar.F(sVar.f503b)) {
                    lVar.i(sVar);
                    sVar.f504c.add(lVar);
                }
            }
        }
    }

    @Override // O.l
    /* renamed from: i0 */
    public p T(long j2) {
        super.T(j2);
        if (this.f457c >= 0) {
            int size = this.f491J.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((l) this.f491J.get(i2)).T(j2);
            }
        }
        return this;
    }

    @Override // O.l
    /* renamed from: j0 */
    public p V(TimeInterpolator timeInterpolator) {
        this.f495N |= 1;
        ArrayList arrayList = this.f491J;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((l) this.f491J.get(i2)).V(timeInterpolator);
            }
        }
        return (p) super.V(timeInterpolator);
    }

    public p k0(int i2) {
        if (i2 == 0) {
            this.f492K = true;
        } else {
            if (i2 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i2);
            }
            this.f492K = false;
        }
        return this;
    }

    @Override // O.l
    /* renamed from: l */
    public l clone() {
        p pVar = (p) super.clone();
        pVar.f491J = new ArrayList();
        int size = this.f491J.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.d0(((l) this.f491J.get(i2)).clone());
        }
        return pVar;
    }

    @Override // O.l
    /* renamed from: l0 */
    public p Y(long j2) {
        return (p) super.Y(j2);
    }

    @Override // O.l
    protected void n(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        long jX = x();
        int size = this.f491J.size();
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = (l) this.f491J.get(i2);
            if (jX > 0 && (this.f492K || i2 == 0)) {
                long jX2 = lVar.x();
                if (jX2 > 0) {
                    lVar.Y(jX2 + jX);
                } else {
                    lVar.Y(jX);
                }
            }
            lVar.n(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }
}
