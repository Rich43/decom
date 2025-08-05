package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import v.C0343f;
import v.InterfaceC0342e;

/* loaded from: classes.dex */
class p {

    /* renamed from: a, reason: collision with root package name */
    final androidx.collection.a f4288a = new androidx.collection.a();

    /* renamed from: b, reason: collision with root package name */
    final androidx.collection.d f4289b = new androidx.collection.d();

    static class a {

        /* renamed from: d, reason: collision with root package name */
        static InterfaceC0342e f4290d = new C0343f(20);

        /* renamed from: a, reason: collision with root package name */
        int f4291a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView.l.c f4292b;

        /* renamed from: c, reason: collision with root package name */
        RecyclerView.l.c f4293c;

        private a() {
        }

        static void a() {
            while (f4290d.acquire() != null) {
            }
        }

        static a b() {
            a aVar = (a) f4290d.acquire();
            return aVar == null ? new a() : aVar;
        }

        static void c(a aVar) {
            aVar.f4291a = 0;
            aVar.f4292b = null;
            aVar.f4293c = null;
            f4290d.release(aVar);
        }
    }

    interface b {
        void a(RecyclerView.C c2);

        void b(RecyclerView.C c2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.C c2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.C c2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    p() {
    }

    private RecyclerView.l.c l(RecyclerView.C c2, int i2) {
        a aVar;
        RecyclerView.l.c cVar;
        int iIndexOfKey = this.f4288a.indexOfKey(c2);
        if (iIndexOfKey >= 0 && (aVar = (a) this.f4288a.valueAt(iIndexOfKey)) != null) {
            int i3 = aVar.f4291a;
            if ((i3 & i2) != 0) {
                int i4 = (~i2) & i3;
                aVar.f4291a = i4;
                if (i2 == 4) {
                    cVar = aVar.f4292b;
                } else {
                    if (i2 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVar.f4293c;
                }
                if ((i4 & 12) == 0) {
                    this.f4288a.removeAt(iIndexOfKey);
                    a.c(aVar);
                }
                return cVar;
            }
        }
        return null;
    }

    void a(RecyclerView.C c2, RecyclerView.l.c cVar) {
        a aVarB = (a) this.f4288a.get(c2);
        if (aVarB == null) {
            aVarB = a.b();
            this.f4288a.put(c2, aVarB);
        }
        aVarB.f4291a |= 2;
        aVarB.f4292b = cVar;
    }

    void b(RecyclerView.C c2) {
        a aVarB = (a) this.f4288a.get(c2);
        if (aVarB == null) {
            aVarB = a.b();
            this.f4288a.put(c2, aVarB);
        }
        aVarB.f4291a |= 1;
    }

    void c(long j2, RecyclerView.C c2) {
        this.f4289b.j(j2, c2);
    }

    void d(RecyclerView.C c2, RecyclerView.l.c cVar) {
        a aVarB = (a) this.f4288a.get(c2);
        if (aVarB == null) {
            aVarB = a.b();
            this.f4288a.put(c2, aVarB);
        }
        aVarB.f4293c = cVar;
        aVarB.f4291a |= 8;
    }

    void e(RecyclerView.C c2, RecyclerView.l.c cVar) {
        a aVarB = (a) this.f4288a.get(c2);
        if (aVarB == null) {
            aVarB = a.b();
            this.f4288a.put(c2, aVarB);
        }
        aVarB.f4292b = cVar;
        aVarB.f4291a |= 4;
    }

    void f() {
        this.f4288a.clear();
        this.f4289b.b();
    }

    RecyclerView.C g(long j2) {
        return (RecyclerView.C) this.f4289b.f(j2);
    }

    boolean h(RecyclerView.C c2) {
        a aVar = (a) this.f4288a.get(c2);
        return (aVar == null || (aVar.f4291a & 1) == 0) ? false : true;
    }

    boolean i(RecyclerView.C c2) {
        a aVar = (a) this.f4288a.get(c2);
        return (aVar == null || (aVar.f4291a & 4) == 0) ? false : true;
    }

    void j() {
        a.a();
    }

    public void k(RecyclerView.C c2) {
        p(c2);
    }

    RecyclerView.l.c m(RecyclerView.C c2) {
        return l(c2, 8);
    }

    RecyclerView.l.c n(RecyclerView.C c2) {
        return l(c2, 4);
    }

    void o(b bVar) {
        for (int size = this.f4288a.size() - 1; size >= 0; size--) {
            RecyclerView.C c2 = (RecyclerView.C) this.f4288a.keyAt(size);
            a aVar = (a) this.f4288a.removeAt(size);
            int i2 = aVar.f4291a;
            if ((i2 & 3) == 3) {
                bVar.a(c2);
            } else if ((i2 & 1) != 0) {
                RecyclerView.l.c cVar = aVar.f4292b;
                if (cVar == null) {
                    bVar.a(c2);
                } else {
                    bVar.c(c2, cVar, aVar.f4293c);
                }
            } else if ((i2 & 14) == 14) {
                bVar.b(c2, aVar.f4292b, aVar.f4293c);
            } else if ((i2 & 12) == 12) {
                bVar.d(c2, aVar.f4292b, aVar.f4293c);
            } else if ((i2 & 4) != 0) {
                bVar.c(c2, aVar.f4292b, null);
            } else if ((i2 & 8) != 0) {
                bVar.b(c2, aVar.f4292b, aVar.f4293c);
            }
            a.c(aVar);
        }
    }

    void p(RecyclerView.C c2) {
        a aVar = (a) this.f4288a.get(c2);
        if (aVar == null) {
            return;
        }
        aVar.f4291a &= -2;
    }

    void q(RecyclerView.C c2) {
        int iM = this.f4289b.m() - 1;
        while (true) {
            if (iM < 0) {
                break;
            }
            if (c2 == this.f4289b.n(iM)) {
                this.f4289b.l(iM);
                break;
            }
            iM--;
        }
        a aVar = (a) this.f4288a.remove(c2);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
