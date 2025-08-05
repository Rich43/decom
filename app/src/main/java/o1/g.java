package o1;

import i1.k;
import i1.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class g extends f {

    static final class a extends l implements h1.l {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h1.a f7005b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(h1.a aVar) {
            super(1);
            this.f7005b = aVar;
        }

        @Override // h1.l
        public final Object b(Object obj) {
            k.e(obj, "it");
            return this.f7005b.a();
        }
    }

    public static final c a(c cVar) {
        k.e(cVar, "<this>");
        return cVar instanceof o1.a ? cVar : new o1.a(cVar);
    }

    public static c b(h1.a aVar) {
        k.e(aVar, "nextFunction");
        return a(new b(aVar, new a(aVar)));
    }
}
