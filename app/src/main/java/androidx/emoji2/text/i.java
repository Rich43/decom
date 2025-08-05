package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.f;
import androidx.emoji2.text.n;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    private final f.j f3301a;

    /* renamed from: b, reason: collision with root package name */
    private final n f3302b;

    /* renamed from: c, reason: collision with root package name */
    private f.e f3303c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f3304d;
    private final int[] e;

    private static final class a {
        static int a(CharSequence charSequence, int i2, int i3) {
            int length = charSequence.length();
            if (i2 < 0 || length < i2 || i3 < 0) {
                return -1;
            }
            while (true) {
                boolean z2 = false;
                while (i3 != 0) {
                    i2--;
                    if (i2 < 0) {
                        return z2 ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i2);
                    if (z2) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i3--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i3--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z2 = true;
                    }
                }
                return i2;
            }
        }

        static int b(CharSequence charSequence, int i2, int i3) {
            int length = charSequence.length();
            if (i2 < 0 || length < i2 || i3 < 0) {
                return -1;
            }
            while (true) {
                boolean z2 = false;
                while (i3 != 0) {
                    if (i2 >= length) {
                        if (z2) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i2);
                    if (z2) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i3--;
                        i2++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i3--;
                        i2++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i2++;
                        z2 = true;
                    }
                }
                return i2;
            }
        }
    }

    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public t f3305a;

        /* renamed from: b, reason: collision with root package name */
        private final f.j f3306b;

        b(t tVar, f.j jVar) {
            this.f3305a = tVar;
            this.f3306b = jVar;
        }

        @Override // androidx.emoji2.text.i.c
        public boolean b(CharSequence charSequence, int i2, int i3, p pVar) {
            if (pVar.k()) {
                return true;
            }
            if (this.f3305a == null) {
                this.f3305a = new t(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.f3305a.setSpan(this.f3306b.a(pVar), i2, i3, 33);
            return true;
        }

        @Override // androidx.emoji2.text.i.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public t a() {
            return this.f3305a;
        }
    }

    private interface c {
        Object a();

        boolean b(CharSequence charSequence, int i2, int i3, p pVar);
    }

    private static class d implements c {

        /* renamed from: a, reason: collision with root package name */
        private final String f3307a;

        d(String str) {
            this.f3307a = str;
        }

        @Override // androidx.emoji2.text.i.c
        public boolean b(CharSequence charSequence, int i2, int i3, p pVar) {
            if (!TextUtils.equals(charSequence.subSequence(i2, i3), this.f3307a)) {
                return true;
            }
            pVar.l(true);
            return false;
        }

        @Override // androidx.emoji2.text.i.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d a() {
            return this;
        }
    }

    static final class e {

        /* renamed from: a, reason: collision with root package name */
        private int f3308a = 1;

        /* renamed from: b, reason: collision with root package name */
        private final n.a f3309b;

        /* renamed from: c, reason: collision with root package name */
        private n.a f3310c;

        /* renamed from: d, reason: collision with root package name */
        private n.a f3311d;
        private int e;

        /* renamed from: f, reason: collision with root package name */
        private int f3312f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f3313g;

        /* renamed from: h, reason: collision with root package name */
        private final int[] f3314h;

        e(n.a aVar, boolean z2, int[] iArr) {
            this.f3309b = aVar;
            this.f3310c = aVar;
            this.f3313g = z2;
            this.f3314h = iArr;
        }

        private static boolean d(int i2) {
            return i2 == 65039;
        }

        private static boolean f(int i2) {
            return i2 == 65038;
        }

        private int g() {
            this.f3308a = 1;
            this.f3310c = this.f3309b;
            this.f3312f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f3310c.b().j() || d(this.e)) {
                return true;
            }
            if (this.f3313g) {
                if (this.f3314h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f3314h, this.f3310c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i2) {
            n.a aVarA = this.f3310c.a(i2);
            int iG = 2;
            if (this.f3308a != 2) {
                if (aVarA == null) {
                    iG = g();
                } else {
                    this.f3308a = 2;
                    this.f3310c = aVarA;
                    this.f3312f = 1;
                }
            } else if (aVarA != null) {
                this.f3310c = aVarA;
                this.f3312f++;
            } else if (f(i2)) {
                iG = g();
            } else if (!d(i2)) {
                if (this.f3310c.b() != null) {
                    iG = 3;
                    if (this.f3312f != 1 || h()) {
                        this.f3311d = this.f3310c;
                        g();
                    } else {
                        iG = g();
                    }
                } else {
                    iG = g();
                }
            }
            this.e = i2;
            return iG;
        }

        p b() {
            return this.f3310c.b();
        }

        p c() {
            return this.f3311d.b();
        }

        boolean e() {
            return this.f3308a == 2 && this.f3310c.b() != null && (this.f3312f > 1 || h());
        }
    }

    i(n nVar, f.j jVar, f.e eVar, boolean z2, int[] iArr, Set set) {
        this.f3301a = jVar;
        this.f3302b = nVar;
        this.f3303c = eVar;
        this.f3304d = z2;
        this.e = iArr;
        g(set);
    }

    private static boolean a(Editable editable, KeyEvent keyEvent, boolean z2) {
        j[] jVarArr;
        if (f(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!e(selectionStart, selectionEnd) && (jVarArr = (j[]) editable.getSpans(selectionStart, selectionEnd, j.class)) != null && jVarArr.length > 0) {
            for (j jVar : jVarArr) {
                int spanStart = editable.getSpanStart(jVar);
                int spanEnd = editable.getSpanEnd(jVar);
                if ((z2 && spanStart == selectionStart) || ((!z2 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean b(InputConnection inputConnection, Editable editable, int i2, int i3, boolean z2) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i2 >= 0 && i3 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (e(selectionStart, selectionEnd)) {
                return false;
            }
            if (z2) {
                iMax = a.a(editable, selectionStart, Math.max(i2, 0));
                iMin = a.b(editable, selectionEnd, Math.max(i3, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i2, 0);
                iMin = Math.min(selectionEnd + i3, editable.length());
            }
            j[] jVarArr = (j[]) editable.getSpans(iMax, iMin, j.class);
            if (jVarArr != null && jVarArr.length > 0) {
                for (j jVar : jVarArr) {
                    int spanStart = editable.getSpanStart(jVar);
                    int spanEnd = editable.getSpanEnd(jVar);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean c(Editable editable, int i2, KeyEvent keyEvent) {
        if (!(i2 != 67 ? i2 != 112 ? false : a(editable, keyEvent, true) : a(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean d(CharSequence charSequence, int i2, int i3, p pVar) {
        if (pVar.d() == 0) {
            pVar.m(this.f3303c.a(charSequence, i2, i3, pVar.h()));
        }
        return pVar.d() == 2;
    }

    private static boolean e(int i2, int i3) {
        return i2 == -1 || i3 == -1 || i2 != i3;
    }

    private static boolean f(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    private void g(Set set) {
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            i(str, 0, str.length(), 1, true, new d(str));
        }
    }

    private Object i(CharSequence charSequence, int i2, int i3, int i4, boolean z2, c cVar) {
        int iCharCount;
        e eVar = new e(this.f3302b.f(), this.f3304d, this.e);
        int iCodePointAt = Character.codePointAt(charSequence, i2);
        int i5 = 0;
        boolean zB = true;
        loop0: while (true) {
            iCharCount = i2;
            while (i2 < i3 && i5 < i4 && zB) {
                int iA = eVar.a(iCodePointAt);
                if (iA == 1) {
                    iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                    if (iCharCount < i3) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                    i2 = iCharCount;
                } else if (iA == 2) {
                    i2 += Character.charCount(iCodePointAt);
                    if (i2 < i3) {
                        iCodePointAt = Character.codePointAt(charSequence, i2);
                    }
                } else if (iA == 3) {
                    if (z2 || !d(charSequence, iCharCount, i2, eVar.c())) {
                        zB = cVar.b(charSequence, iCharCount, i2, eVar.c());
                        i5++;
                    }
                }
            }
            break loop0;
        }
        if (eVar.e() && i5 < i4 && zB && (z2 || !d(charSequence, iCharCount, i2, eVar.b()))) {
            cVar.b(charSequence, iCharCount, i2, eVar.b());
        }
        return cVar.a();
    }

    CharSequence h(CharSequence charSequence, int i2, int i3, int i4, boolean z2) {
        t tVar;
        j[] jVarArr;
        boolean z3 = charSequence instanceof o;
        if (z3) {
            ((o) charSequence).a();
        }
        if (!z3) {
            try {
                tVar = charSequence instanceof Spannable ? new t((Spannable) charSequence) : (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i2 + (-1), i3 + 1, j.class) > i3) ? null : new t(charSequence);
            } finally {
                if (z3) {
                    ((o) charSequence).d();
                }
            }
        }
        if (tVar != null && (jVarArr = (j[]) tVar.getSpans(i2, i3, j.class)) != null && jVarArr.length > 0) {
            for (j jVar : jVarArr) {
                int spanStart = tVar.getSpanStart(jVar);
                int spanEnd = tVar.getSpanEnd(jVar);
                if (spanStart != i3) {
                    tVar.removeSpan(jVar);
                }
                i2 = Math.min(spanStart, i2);
                i3 = Math.max(spanEnd, i3);
            }
        }
        int i5 = i3;
        if (i2 != i5 && i2 < charSequence.length()) {
            if (i4 != Integer.MAX_VALUE && tVar != null) {
                i4 -= ((j[]) tVar.getSpans(0, tVar.length(), j.class)).length;
            }
            t tVar2 = (t) i(charSequence, i2, i5, i4, z2, new b(tVar, this.f3301a));
            if (tVar2 == null) {
                if (z3) {
                    ((o) charSequence).d();
                }
                return charSequence;
            }
            Spannable spannableB = tVar2.b();
            if (z3) {
                ((o) charSequence).d();
            }
            return spannableB;
        }
        return charSequence;
    }
}
