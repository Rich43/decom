package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import v.AbstractC0345h;

/* loaded from: classes.dex */
public class f {
    private static final Object o = new Object();

    /* renamed from: p */
    private static final Object f3267p = new Object();

    /* renamed from: q */
    private static volatile f f3268q;

    /* renamed from: b */
    private final Set f3270b;
    private final b e;

    /* renamed from: f */
    final h f3273f;

    /* renamed from: g */
    private final j f3274g;

    /* renamed from: h */
    final boolean f3275h;

    /* renamed from: i */
    final boolean f3276i;

    /* renamed from: j */
    final int[] f3277j;

    /* renamed from: k */
    private final boolean f3278k;

    /* renamed from: l */
    private final int f3279l;

    /* renamed from: m */
    private final int f3280m;

    /* renamed from: n */
    private final e f3281n;

    /* renamed from: a */
    private final ReadWriteLock f3269a = new ReentrantReadWriteLock();

    /* renamed from: c */
    private volatile int f3271c = 3;

    /* renamed from: d */
    private final Handler f3272d = new Handler(Looper.getMainLooper());

    private static final class a extends b {

        /* renamed from: b */
        private volatile androidx.emoji2.text.i f3282b;

        /* renamed from: c */
        private volatile n f3283c;

        /* renamed from: androidx.emoji2.text.f$a$a */
        class C0038a extends i {
            C0038a() {
            }

            @Override // androidx.emoji2.text.f.i
            public void a(Throwable th) {
                a.this.f3285a.n(th);
            }

            @Override // androidx.emoji2.text.f.i
            public void b(n nVar) {
                a.this.d(nVar);
            }
        }

        a(f fVar) {
            super(fVar);
        }

        @Override // androidx.emoji2.text.f.b
        void a() {
            try {
                this.f3285a.f3273f.a(new C0038a());
            } catch (Throwable th) {
                this.f3285a.n(th);
            }
        }

        @Override // androidx.emoji2.text.f.b
        CharSequence b(CharSequence charSequence, int i2, int i3, int i4, boolean z2) {
            return this.f3282b.h(charSequence, i2, i3, i4, z2);
        }

        @Override // androidx.emoji2.text.f.b
        void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f3283c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f3285a.f3275h);
        }

        void d(n nVar) {
            if (nVar == null) {
                this.f3285a.n(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f3283c = nVar;
            n nVar2 = this.f3283c;
            j jVar = this.f3285a.f3274g;
            e eVar = this.f3285a.f3281n;
            f fVar = this.f3285a;
            this.f3282b = new androidx.emoji2.text.i(nVar2, jVar, eVar, fVar.f3276i, fVar.f3277j, androidx.emoji2.text.h.a());
            this.f3285a.o();
        }
    }

    private static class b {

        /* renamed from: a */
        final f f3285a;

        b(f fVar) {
            this.f3285a = fVar;
        }

        abstract void a();

        abstract CharSequence b(CharSequence charSequence, int i2, int i3, int i4, boolean z2);

        abstract void c(EditorInfo editorInfo);
    }

    public static abstract class c {

        /* renamed from: a */
        final h f3286a;

        /* renamed from: b */
        j f3287b;

        /* renamed from: c */
        boolean f3288c;

        /* renamed from: d */
        boolean f3289d;
        int[] e;

        /* renamed from: f */
        Set f3290f;

        /* renamed from: g */
        boolean f3291g;

        /* renamed from: h */
        int f3292h = -16711936;

        /* renamed from: i */
        int f3293i = 0;

        /* renamed from: j */
        e f3294j = new androidx.emoji2.text.e();

        protected c(h hVar) {
            AbstractC0345h.g(hVar, "metadataLoader cannot be null.");
            this.f3286a = hVar;
        }

        protected final h a() {
            return this.f3286a;
        }

        public c b(int i2) {
            this.f3293i = i2;
            return this;
        }
    }

    public static class d implements j {
        @Override // androidx.emoji2.text.f.j
        public androidx.emoji2.text.j a(p pVar) {
            return new q(pVar);
        }
    }

    public interface e {
        boolean a(CharSequence charSequence, int i2, int i3, int i4);
    }

    /* renamed from: androidx.emoji2.text.f$f */
    public static abstract class AbstractC0039f {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    private static class g implements Runnable {

        /* renamed from: a */
        private final List f3295a;

        /* renamed from: b */
        private final Throwable f3296b;

        /* renamed from: c */
        private final int f3297c;

        g(AbstractC0039f abstractC0039f, int i2) {
            this(Arrays.asList((AbstractC0039f) AbstractC0345h.g(abstractC0039f, "initCallback cannot be null")), i2, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f3295a.size();
            int i2 = 0;
            if (this.f3297c != 1) {
                while (i2 < size) {
                    ((AbstractC0039f) this.f3295a.get(i2)).a(this.f3296b);
                    i2++;
                }
            } else {
                while (i2 < size) {
                    ((AbstractC0039f) this.f3295a.get(i2)).b();
                    i2++;
                }
            }
        }

        g(Collection collection, int i2) {
            this(collection, i2, null);
        }

        g(Collection collection, int i2, Throwable th) {
            AbstractC0345h.g(collection, "initCallbacks cannot be null");
            this.f3295a = new ArrayList(collection);
            this.f3297c = i2;
            this.f3296b = th;
        }
    }

    public interface h {
        void a(i iVar);
    }

    public static abstract class i {
        public abstract void a(Throwable th);

        public abstract void b(n nVar);
    }

    public interface j {
        androidx.emoji2.text.j a(p pVar);
    }

    private f(c cVar) {
        this.f3275h = cVar.f3288c;
        this.f3276i = cVar.f3289d;
        this.f3277j = cVar.e;
        this.f3278k = cVar.f3291g;
        this.f3279l = cVar.f3292h;
        this.f3273f = cVar.f3286a;
        this.f3280m = cVar.f3293i;
        this.f3281n = cVar.f3294j;
        androidx.collection.b bVar = new androidx.collection.b();
        this.f3270b = bVar;
        j jVar = cVar.f3287b;
        this.f3274g = jVar == null ? new d() : jVar;
        Set set = cVar.f3290f;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(cVar.f3290f);
        }
        this.e = new a(this);
        m();
    }

    public static f c() {
        f fVar;
        synchronized (o) {
            fVar = f3268q;
            AbstractC0345h.h(fVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return fVar;
    }

    public static boolean f(InputConnection inputConnection, Editable editable, int i2, int i3, boolean z2) {
        return androidx.emoji2.text.i.b(inputConnection, editable, i2, i3, z2);
    }

    public static boolean g(Editable editable, int i2, KeyEvent keyEvent) {
        return androidx.emoji2.text.i.c(editable, i2, keyEvent);
    }

    public static f h(c cVar) {
        f fVar = f3268q;
        if (fVar == null) {
            synchronized (o) {
                try {
                    fVar = f3268q;
                    if (fVar == null) {
                        fVar = new f(cVar);
                        f3268q = fVar;
                    }
                } finally {
                }
            }
        }
        return fVar;
    }

    public static boolean i() {
        return f3268q != null;
    }

    private boolean k() {
        return e() == 1;
    }

    private void m() {
        this.f3269a.writeLock().lock();
        try {
            if (this.f3280m == 0) {
                this.f3271c = 0;
            }
            this.f3269a.writeLock().unlock();
            if (e() == 0) {
                this.e.a();
            }
        } catch (Throwable th) {
            this.f3269a.writeLock().unlock();
            throw th;
        }
    }

    public int d() {
        return this.f3279l;
    }

    public int e() {
        this.f3269a.readLock().lock();
        try {
            return this.f3271c;
        } finally {
            this.f3269a.readLock().unlock();
        }
    }

    public boolean j() {
        return this.f3278k;
    }

    public void l() {
        AbstractC0345h.h(this.f3280m == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (k()) {
            return;
        }
        this.f3269a.writeLock().lock();
        try {
            if (this.f3271c == 0) {
                return;
            }
            this.f3271c = 0;
            this.f3269a.writeLock().unlock();
            this.e.a();
        } finally {
            this.f3269a.writeLock().unlock();
        }
    }

    void n(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f3269a.writeLock().lock();
        try {
            this.f3271c = 2;
            arrayList.addAll(this.f3270b);
            this.f3270b.clear();
            this.f3269a.writeLock().unlock();
            this.f3272d.post(new g(arrayList, this.f3271c, th));
        } catch (Throwable th2) {
            this.f3269a.writeLock().unlock();
            throw th2;
        }
    }

    void o() {
        ArrayList arrayList = new ArrayList();
        this.f3269a.writeLock().lock();
        try {
            this.f3271c = 1;
            arrayList.addAll(this.f3270b);
            this.f3270b.clear();
            this.f3269a.writeLock().unlock();
            this.f3272d.post(new g(arrayList, this.f3271c));
        } catch (Throwable th) {
            this.f3269a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence p(CharSequence charSequence) {
        return q(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence q(CharSequence charSequence, int i2, int i3) {
        return r(charSequence, i2, i3, Integer.MAX_VALUE);
    }

    public CharSequence r(CharSequence charSequence, int i2, int i3, int i4) {
        return s(charSequence, i2, i3, i4, 0);
    }

    public CharSequence s(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        AbstractC0345h.h(k(), "Not initialized yet");
        AbstractC0345h.d(i2, "start cannot be negative");
        AbstractC0345h.d(i3, "end cannot be negative");
        AbstractC0345h.d(i4, "maxEmojiCount cannot be negative");
        AbstractC0345h.a(i2 <= i3, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        AbstractC0345h.a(i2 <= charSequence.length(), "start should be < than charSequence length");
        AbstractC0345h.a(i3 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i2 == i3) {
            return charSequence;
        }
        return this.e.b(charSequence, i2, i3, i4, i5 != 1 ? i5 != 2 ? this.f3275h : false : true);
    }

    public void t(AbstractC0039f abstractC0039f) {
        AbstractC0345h.g(abstractC0039f, "initCallback cannot be null");
        this.f3269a.writeLock().lock();
        try {
            if (this.f3271c == 1 || this.f3271c == 2) {
                this.f3272d.post(new g(abstractC0039f, this.f3271c));
            } else {
                this.f3270b.add(abstractC0039f);
            }
            this.f3269a.writeLock().unlock();
        } catch (Throwable th) {
            this.f3269a.writeLock().unlock();
            throw th;
        }
    }

    public void u(AbstractC0039f abstractC0039f) {
        AbstractC0345h.g(abstractC0039f, "initCallback cannot be null");
        this.f3269a.writeLock().lock();
        try {
            this.f3270b.remove(abstractC0039f);
        } finally {
            this.f3269a.writeLock().unlock();
        }
    }

    public void v(EditorInfo editorInfo) {
        if (!k() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.e.c(editorInfo);
    }
}
