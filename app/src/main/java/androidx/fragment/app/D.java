package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class D {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f3370a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap f3371b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f3372c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private z f3373d;

    D() {
    }

    void A(z zVar) {
        this.f3373d = zVar;
    }

    B B(String str, B b2) {
        return b2 != null ? (B) this.f3372c.put(str, b2) : (B) this.f3372c.remove(str);
    }

    void a(Fragment fragment) {
        if (this.f3370a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f3370a) {
            this.f3370a.add(fragment);
        }
        fragment.mAdded = true;
    }

    void b() {
        this.f3371b.values().removeAll(Collections.singleton(null));
    }

    boolean c(String str) {
        return this.f3371b.get(str) != null;
    }

    void d(int i2) {
        for (C c2 : this.f3371b.values()) {
            if (c2 != null) {
                c2.t(i2);
            }
        }
    }

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f3371b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (C c2 : this.f3371b.values()) {
                printWriter.print(str);
                if (c2 != null) {
                    Fragment fragmentK = c2.k();
                    printWriter.println(fragmentK);
                    fragmentK.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f3370a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = (Fragment) this.f3370a.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    Fragment f(String str) {
        C c2 = (C) this.f3371b.get(str);
        if (c2 != null) {
            return c2.k();
        }
        return null;
    }

    Fragment g(int i2) {
        for (int size = this.f3370a.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f3370a.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (C c2 : this.f3371b.values()) {
            if (c2 != null) {
                Fragment fragmentK = c2.k();
                if (fragmentK.mFragmentId == i2) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    Fragment h(String str) {
        if (str != null) {
            for (int size = this.f3370a.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f3370a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (C c2 : this.f3371b.values()) {
            if (c2 != null) {
                Fragment fragmentK = c2.k();
                if (str.equals(fragmentK.mTag)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    Fragment i(String str) {
        Fragment fragmentFindFragmentByWho;
        for (C c2 : this.f3371b.values()) {
            if (c2 != null && (fragmentFindFragmentByWho = c2.k().findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f3370a.indexOf(fragment);
        for (int i2 = iIndexOf - 1; i2 >= 0; i2--) {
            Fragment fragment2 = (Fragment) this.f3370a.get(i2);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f3370a.size()) {
                return -1;
            }
            Fragment fragment3 = (Fragment) this.f3370a.get(iIndexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    List k() {
        ArrayList arrayList = new ArrayList();
        for (C c2 : this.f3371b.values()) {
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        return arrayList;
    }

    List l() {
        ArrayList arrayList = new ArrayList();
        for (C c2 : this.f3371b.values()) {
            if (c2 != null) {
                arrayList.add(c2.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    ArrayList m() {
        return new ArrayList(this.f3372c.values());
    }

    C n(String str) {
        return (C) this.f3371b.get(str);
    }

    List o() {
        ArrayList arrayList;
        if (this.f3370a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f3370a) {
            arrayList = new ArrayList(this.f3370a);
        }
        return arrayList;
    }

    z p() {
        return this.f3373d;
    }

    B q(String str) {
        return (B) this.f3372c.get(str);
    }

    void r(C c2) {
        Fragment fragmentK = c2.k();
        if (c(fragmentK.mWho)) {
            return;
        }
        this.f3371b.put(fragmentK.mWho, c2);
        if (fragmentK.mRetainInstanceChangedWhileDetached) {
            if (fragmentK.mRetainInstance) {
                this.f3373d.f(fragmentK);
            } else {
                this.f3373d.p(fragmentK);
            }
            fragmentK.mRetainInstanceChangedWhileDetached = false;
        }
        if (w.H0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragmentK);
        }
    }

    void s(C c2) {
        Fragment fragmentK = c2.k();
        if (fragmentK.mRetainInstance) {
            this.f3373d.p(fragmentK);
        }
        if (((C) this.f3371b.put(fragmentK.mWho, null)) != null && w.H0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragmentK);
        }
    }

    void t() {
        Iterator it = this.f3370a.iterator();
        while (it.hasNext()) {
            C c2 = (C) this.f3371b.get(((Fragment) it.next()).mWho);
            if (c2 != null) {
                c2.m();
            }
        }
        for (C c3 : this.f3371b.values()) {
            if (c3 != null) {
                c3.m();
                Fragment fragmentK = c3.k();
                if (fragmentK.mRemoving && !fragmentK.isInBackStack()) {
                    if (fragmentK.mBeingSaved && !this.f3372c.containsKey(fragmentK.mWho)) {
                        c3.r();
                    }
                    s(c3);
                }
            }
        }
    }

    void u(Fragment fragment) {
        synchronized (this.f3370a) {
            this.f3370a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    void v() {
        this.f3371b.clear();
    }

    void w(List list) {
        this.f3370a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (w.H0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    void x(ArrayList arrayList) {
        this.f3372c.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            B b2 = (B) it.next();
            this.f3372c.put(b2.f3352b, b2);
        }
    }

    ArrayList y() {
        ArrayList arrayList = new ArrayList(this.f3371b.size());
        for (C c2 : this.f3371b.values()) {
            if (c2 != null) {
                Fragment fragmentK = c2.k();
                c2.r();
                arrayList.add(fragmentK.mWho);
                if (w.H0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragmentK + ": " + fragmentK.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }

    ArrayList z() {
        synchronized (this.f3370a) {
            try {
                if (this.f3370a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.f3370a.size());
                Iterator it = this.f3370a.iterator();
                while (it.hasNext()) {
                    Fragment fragment = (Fragment) it.next();
                    arrayList.add(fragment.mWho);
                    if (w.H0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment.mWho + "): " + fragment);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
