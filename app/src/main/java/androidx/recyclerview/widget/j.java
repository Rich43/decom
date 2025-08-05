package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* loaded from: classes.dex */
class j {

    /* renamed from: a */
    final a f4275a;

    interface a {
        void a(a.b bVar);

        a.b b(int i2, int i3, int i4, Object obj);
    }

    j(a aVar) {
        this.f4275a = aVar;
    }

    private int a(List list) {
        boolean z2 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((a.b) list.get(size)).f4115a != 8) {
                z2 = true;
            } else if (z2) {
                return size;
            }
        }
        return -1;
    }

    private void c(List list, int i2, a.b bVar, int i3, a.b bVar2) {
        int i4 = bVar.f4118d;
        int i5 = bVar2.f4116b;
        int i6 = i4 < i5 ? -1 : 0;
        int i7 = bVar.f4116b;
        if (i7 < i5) {
            i6++;
        }
        if (i5 <= i7) {
            bVar.f4116b = i7 + bVar2.f4118d;
        }
        int i8 = bVar2.f4116b;
        if (i8 <= i4) {
            bVar.f4118d = i4 + bVar2.f4118d;
        }
        bVar2.f4116b = i8 + i6;
        list.set(i2, bVar2);
        list.set(i3, bVar);
    }

    private void d(List list, int i2, int i3) {
        a.b bVar = (a.b) list.get(i2);
        a.b bVar2 = (a.b) list.get(i3);
        int i4 = bVar2.f4115a;
        if (i4 == 1) {
            c(list, i2, bVar, i3, bVar2);
        } else if (i4 == 2) {
            e(list, i2, bVar, i3, bVar2);
        } else {
            if (i4 != 4) {
                return;
            }
            f(list, i2, bVar, i3, bVar2);
        }
    }

    void b(List list) {
        while (true) {
            int iA = a(list);
            if (iA == -1) {
                return;
            } else {
                d(list, iA, iA + 1);
            }
        }
    }

    void e(List list, int i2, a.b bVar, int i3, a.b bVar2) {
        boolean z2;
        int i4 = bVar.f4116b;
        int i5 = bVar.f4118d;
        boolean z3 = false;
        if (i4 < i5) {
            if (bVar2.f4116b == i4 && bVar2.f4118d == i5 - i4) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
            }
        } else if (bVar2.f4116b == i5 + 1 && bVar2.f4118d == i4 - i5) {
            z2 = true;
            z3 = true;
        } else {
            z2 = true;
        }
        int i6 = bVar2.f4116b;
        if (i5 < i6) {
            bVar2.f4116b = i6 - 1;
        } else {
            int i7 = bVar2.f4118d;
            if (i5 < i6 + i7) {
                bVar2.f4118d = i7 - 1;
                bVar.f4115a = 2;
                bVar.f4118d = 1;
                if (bVar2.f4118d == 0) {
                    list.remove(i3);
                    this.f4275a.a(bVar2);
                    return;
                }
                return;
            }
        }
        int i8 = bVar.f4116b;
        int i9 = bVar2.f4116b;
        a.b bVarB = null;
        if (i8 <= i9) {
            bVar2.f4116b = i9 + 1;
        } else {
            int i10 = bVar2.f4118d;
            if (i8 < i9 + i10) {
                bVarB = this.f4275a.b(2, i8 + 1, (i9 + i10) - i8, null);
                bVar2.f4118d = bVar.f4116b - bVar2.f4116b;
            }
        }
        if (z3) {
            list.set(i2, bVar2);
            list.remove(i3);
            this.f4275a.a(bVar);
            return;
        }
        if (z2) {
            if (bVarB != null) {
                int i11 = bVar.f4116b;
                if (i11 > bVarB.f4116b) {
                    bVar.f4116b = i11 - bVarB.f4118d;
                }
                int i12 = bVar.f4118d;
                if (i12 > bVarB.f4116b) {
                    bVar.f4118d = i12 - bVarB.f4118d;
                }
            }
            int i13 = bVar.f4116b;
            if (i13 > bVar2.f4116b) {
                bVar.f4116b = i13 - bVar2.f4118d;
            }
            int i14 = bVar.f4118d;
            if (i14 > bVar2.f4116b) {
                bVar.f4118d = i14 - bVar2.f4118d;
            }
        } else {
            if (bVarB != null) {
                int i15 = bVar.f4116b;
                if (i15 >= bVarB.f4116b) {
                    bVar.f4116b = i15 - bVarB.f4118d;
                }
                int i16 = bVar.f4118d;
                if (i16 >= bVarB.f4116b) {
                    bVar.f4118d = i16 - bVarB.f4118d;
                }
            }
            int i17 = bVar.f4116b;
            if (i17 >= bVar2.f4116b) {
                bVar.f4116b = i17 - bVar2.f4118d;
            }
            int i18 = bVar.f4118d;
            if (i18 >= bVar2.f4116b) {
                bVar.f4118d = i18 - bVar2.f4118d;
            }
        }
        list.set(i2, bVar2);
        if (bVar.f4116b != bVar.f4118d) {
            list.set(i3, bVar);
        } else {
            list.remove(i3);
        }
        if (bVarB != null) {
            list.add(i2, bVarB);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void f(java.util.List r9, int r10, androidx.recyclerview.widget.a.b r11, int r12, androidx.recyclerview.widget.a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f4118d
            int r1 = r13.f4116b
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Ld
            int r1 = r1 - r3
            r13.f4116b = r1
            goto L20
        Ld:
            int r5 = r13.f4118d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r3
            r13.f4118d = r5
            androidx.recyclerview.widget.j$a r0 = r8.f4275a
            int r1 = r11.f4116b
            java.lang.Object r5 = r13.f4117c
            androidx.recyclerview.widget.a$b r0 = r0.b(r2, r1, r3, r5)
            goto L21
        L20:
            r0 = r4
        L21:
            int r1 = r11.f4116b
            int r5 = r13.f4116b
            if (r1 > r5) goto L2b
            int r5 = r5 + r3
            r13.f4116b = r5
            goto L41
        L2b:
            int r6 = r13.f4118d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.j$a r4 = r8.f4275a
            int r1 = r1 + r3
            java.lang.Object r3 = r13.f4117c
            androidx.recyclerview.widget.a$b r4 = r4.b(r2, r1, r5, r3)
            int r1 = r13.f4118d
            int r1 = r1 - r5
            r13.f4118d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f4118d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.j$a r11 = r8.f4275a
            r11.a(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r4 == 0) goto L5e
            r9.add(r10, r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.j.f(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }
}
