package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.E;
import androidx.fragment.app.w;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a */
/* loaded from: classes.dex */
final class C0183a extends E implements w.l {

    /* renamed from: t */
    final w f3488t;

    /* renamed from: u */
    boolean f3489u;

    /* renamed from: v */
    int f3490v;

    /* renamed from: w */
    boolean f3491w;

    C0183a(w wVar) {
        super(wVar.s0(), wVar.u0() != null ? wVar.u0().h().getClassLoader() : null);
        this.f3490v = -1;
        this.f3491w = false;
        this.f3488t = wVar;
    }

    @Override // androidx.fragment.app.w.l
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (w.H0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f3381i) {
            return true;
        }
        this.f3488t.i(this);
        return true;
    }

    @Override // androidx.fragment.app.E
    public int g() {
        return q(false);
    }

    @Override // androidx.fragment.app.E
    public int h() {
        return q(true);
    }

    @Override // androidx.fragment.app.E
    public void i() {
        j();
        this.f3488t.c0(this, true);
    }

    @Override // androidx.fragment.app.E
    void k(int i2, Fragment fragment, String str, int i3) {
        super.k(i2, fragment, str, i3);
        fragment.mFragmentManager = this.f3488t;
    }

    @Override // androidx.fragment.app.E
    public E l(Fragment fragment) {
        w wVar = fragment.mFragmentManager;
        if (wVar == null || wVar == this.f3488t) {
            return super.l(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.E
    public E m(Fragment fragment) {
        w wVar = fragment.mFragmentManager;
        if (wVar == null || wVar == this.f3488t) {
            return super.m(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.E
    public E o(Fragment fragment) {
        w wVar = fragment.mFragmentManager;
        if (wVar == null || wVar == this.f3488t) {
            return super.o(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    void p(int i2) {
        if (this.f3381i) {
            if (w.H0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f3376c.size();
            for (int i3 = 0; i3 < size; i3++) {
                E.a aVar = (E.a) this.f3376c.get(i3);
                Fragment fragment = aVar.f3390b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i2;
                    if (w.H0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f3390b + " to " + aVar.f3390b.mBackStackNesting);
                    }
                }
            }
        }
    }

    int q(boolean z2) {
        if (this.f3489u) {
            throw new IllegalStateException("commit already called");
        }
        if (w.H0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new J("FragmentManager"));
            r("  ", printWriter);
            printWriter.close();
        }
        this.f3489u = true;
        if (this.f3381i) {
            this.f3490v = this.f3488t.m();
        } else {
            this.f3490v = -1;
        }
        this.f3488t.Z(this, z2);
        return this.f3490v;
    }

    public void r(String str, PrintWriter printWriter) {
        s(str, printWriter, true);
    }

    public void s(String str, PrintWriter printWriter, boolean z2) {
        String str2;
        if (z2) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f3383k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3490v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3489u);
            if (this.f3380h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3380h));
            }
            if (this.f3377d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3377d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.f3378f != 0 || this.f3379g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3378f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3379g));
            }
            if (this.f3384l != 0 || this.f3385m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3384l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3385m);
            }
            if (this.f3386n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3386n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.o);
            }
        }
        if (this.f3376c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f3376c.size();
        for (int i2 = 0; i2 < size; i2++) {
            E.a aVar = (E.a) this.f3376c.get(i2);
            switch (aVar.f3389a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f3389a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f3390b);
            if (z2) {
                if (aVar.f3392d != 0 || aVar.e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f3392d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.e));
                }
                if (aVar.f3393f != 0 || aVar.f3394g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f3393f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f3394g));
                }
            }
        }
    }

    void t() {
        int size = this.f3376c.size();
        for (int i2 = 0; i2 < size; i2++) {
            E.a aVar = (E.a) this.f3376c.get(i2);
            Fragment fragment = aVar.f3390b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f3491w;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f3380h);
                fragment.setSharedElementNames(this.f3387p, this.f3388q);
            }
            switch (aVar.f3389a) {
                case 1:
                    fragment.setAnimations(aVar.f3392d, aVar.e, aVar.f3393f, aVar.f3394g);
                    this.f3488t.m1(fragment, false);
                    this.f3488t.j(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3389a);
                case 3:
                    fragment.setAnimations(aVar.f3392d, aVar.e, aVar.f3393f, aVar.f3394g);
                    this.f3488t.e1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f3392d, aVar.e, aVar.f3393f, aVar.f3394g);
                    this.f3488t.E0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f3392d, aVar.e, aVar.f3393f, aVar.f3394g);
                    this.f3488t.m1(fragment, false);
                    this.f3488t.q1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f3392d, aVar.e, aVar.f3393f, aVar.f3394g);
                    this.f3488t.x(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f3392d, aVar.e, aVar.f3393f, aVar.f3394g);
                    this.f3488t.m1(fragment, false);
                    this.f3488t.o(fragment);
                    break;
                case 8:
                    this.f3488t.o1(fragment);
                    break;
                case 9:
                    this.f3488t.o1(null);
                    break;
                case 10:
                    this.f3488t.n1(fragment, aVar.f3396i);
                    break;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3490v >= 0) {
            sb.append(" #");
            sb.append(this.f3490v);
        }
        if (this.f3383k != null) {
            sb.append(" ");
            sb.append(this.f3383k);
        }
        sb.append("}");
        return sb.toString();
    }

    void u() {
        for (int size = this.f3376c.size() - 1; size >= 0; size--) {
            E.a aVar = (E.a) this.f3376c.get(size);
            Fragment fragment = aVar.f3390b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f3491w;
                fragment.setPopDirection(true);
                fragment.setNextTransition(w.j1(this.f3380h));
                fragment.setSharedElementNames(this.f3388q, this.f3387p);
            }
            switch (aVar.f3389a) {
                case 1:
                    fragment.setAnimations(aVar.f3392d, aVar.e, aVar.f3393f, aVar.f3394g);
                    this.f3488t.m1(fragment, true);
                    this.f3488t.e1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3389a);
                case 3:
                    fragment.setAnimations(aVar.f3392d, aVar.e, aVar.f3393f, aVar.f3394g);
                    this.f3488t.j(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f3392d, aVar.e, aVar.f3393f, aVar.f3394g);
                    this.f3488t.q1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f3392d, aVar.e, aVar.f3393f, aVar.f3394g);
                    this.f3488t.m1(fragment, true);
                    this.f3488t.E0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f3392d, aVar.e, aVar.f3393f, aVar.f3394g);
                    this.f3488t.o(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f3392d, aVar.e, aVar.f3393f, aVar.f3394g);
                    this.f3488t.m1(fragment, true);
                    this.f3488t.x(fragment);
                    break;
                case 8:
                    this.f3488t.o1(null);
                    break;
                case 9:
                    this.f3488t.o1(fragment);
                    break;
                case 10:
                    this.f3488t.n1(fragment, aVar.f3395h);
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.fragment.app.Fragment v(java.util.ArrayList r17, androidx.fragment.app.Fragment r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList r5 = r0.f3376c
            int r5 = r5.size()
            if (r4 >= r5) goto Lbe
            java.util.ArrayList r5 = r0.f3376c
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.E$a r5 = (androidx.fragment.app.E.a) r5
            int r6 = r5.f3389a
            r7 = 1
            if (r6 == r7) goto Lb6
            r8 = 2
            r9 = 0
            r10 = 3
            r11 = 9
            if (r6 == r8) goto L5a
            if (r6 == r10) goto L43
            r8 = 6
            if (r6 == r8) goto L43
            r8 = 7
            if (r6 == r8) goto Lb6
            r8 = 8
            if (r6 == r8) goto L31
            goto Lbb
        L31:
            java.util.ArrayList r6 = r0.f3376c
            androidx.fragment.app.E$a r8 = new androidx.fragment.app.E$a
            r8.<init>(r11, r3, r7)
            r6.add(r4, r8)
            r5.f3391c = r7
            int r4 = r4 + 1
            androidx.fragment.app.Fragment r3 = r5.f3390b
            goto Lbb
        L43:
            androidx.fragment.app.Fragment r6 = r5.f3390b
            r1.remove(r6)
            androidx.fragment.app.Fragment r5 = r5.f3390b
            if (r5 != r3) goto Lbb
            java.util.ArrayList r3 = r0.f3376c
            androidx.fragment.app.E$a r6 = new androidx.fragment.app.E$a
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r9
            goto Lbb
        L5a:
            androidx.fragment.app.Fragment r6 = r5.f3390b
            int r8 = r6.mContainerId
            int r12 = r17.size()
            int r12 = r12 - r7
            r13 = 0
        L64:
            if (r12 < 0) goto La4
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.Fragment r14 = (androidx.fragment.app.Fragment) r14
            int r15 = r14.mContainerId
            if (r15 != r8) goto La1
            if (r14 != r6) goto L74
            r13 = 1
            goto La1
        L74:
            if (r14 != r3) goto L83
            java.util.ArrayList r3 = r0.f3376c
            androidx.fragment.app.E$a r15 = new androidx.fragment.app.E$a
            r15.<init>(r11, r14, r7)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r9
        L83:
            androidx.fragment.app.E$a r15 = new androidx.fragment.app.E$a
            r15.<init>(r10, r14, r7)
            int r2 = r5.f3392d
            r15.f3392d = r2
            int r2 = r5.f3393f
            r15.f3393f = r2
            int r2 = r5.e
            r15.e = r2
            int r2 = r5.f3394g
            r15.f3394g = r2
            java.util.ArrayList r2 = r0.f3376c
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r7
        La1:
            int r12 = r12 + (-1)
            goto L64
        La4:
            if (r13 == 0) goto Lae
            java.util.ArrayList r2 = r0.f3376c
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lbb
        Lae:
            r5.f3389a = r7
            r5.f3391c = r7
            r1.add(r6)
            goto Lbb
        Lb6:
            androidx.fragment.app.Fragment r2 = r5.f3390b
            r1.add(r2)
        Lbb:
            int r4 = r4 + r7
            goto L7
        Lbe:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0183a.v(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    public String w() {
        return this.f3383k;
    }

    public void x() {
        if (this.s != null) {
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                ((Runnable) this.s.get(i2)).run();
            }
            this.s = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.fragment.app.Fragment y(java.util.ArrayList r6, androidx.fragment.app.Fragment r7) {
        /*
            r5 = this;
            java.util.ArrayList r0 = r5.f3376c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList r2 = r5.f3376c
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.E$a r2 = (androidx.fragment.app.E.a) r2
            int r3 = r2.f3389a
            if (r3 == r1) goto L2d
            r4 = 3
            if (r3 == r4) goto L27
            switch(r3) {
                case 6: goto L27;
                case 7: goto L2d;
                case 8: goto L25;
                case 9: goto L22;
                case 10: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L32
        L1d:
            androidx.lifecycle.h$b r3 = r2.f3395h
            r2.f3396i = r3
            goto L32
        L22:
            androidx.fragment.app.Fragment r7 = r2.f3390b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.Fragment r2 = r2.f3390b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.Fragment r2 = r2.f3390b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0183a.y(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }
}
