package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Objects;
import v.AbstractC0345h;

/* renamed from: androidx.core.view.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0161d {

    /* renamed from: a, reason: collision with root package name */
    private final f f3160a;

    /* renamed from: androidx.core.view.d$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final c f3161a;

        public a(ClipData clipData, int i2) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f3161a = new b(clipData, i2);
            } else {
                this.f3161a = new C0035d(clipData, i2);
            }
        }

        public C0161d a() {
            return this.f3161a.build();
        }

        public a b(Bundle bundle) {
            this.f3161a.setExtras(bundle);
            return this;
        }

        public a c(int i2) {
            this.f3161a.setFlags(i2);
            return this;
        }

        public a d(Uri uri) {
            this.f3161a.a(uri);
            return this;
        }
    }

    /* renamed from: androidx.core.view.d$b */
    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ContentInfo.Builder f3162a;

        b(ClipData clipData, int i2) {
            this.f3162a = AbstractC0166i.a(clipData, i2);
        }

        @Override // androidx.core.view.C0161d.c
        public void a(Uri uri) {
            this.f3162a.setLinkUri(uri);
        }

        @Override // androidx.core.view.C0161d.c
        public C0161d build() {
            return new C0161d(new e(this.f3162a.build()));
        }

        @Override // androidx.core.view.C0161d.c
        public void setExtras(Bundle bundle) {
            this.f3162a.setExtras(bundle);
        }

        @Override // androidx.core.view.C0161d.c
        public void setFlags(int i2) {
            this.f3162a.setFlags(i2);
        }
    }

    /* renamed from: androidx.core.view.d$c */
    private interface c {
        void a(Uri uri);

        C0161d build();

        void setExtras(Bundle bundle);

        void setFlags(int i2);
    }

    /* renamed from: androidx.core.view.d$d, reason: collision with other inner class name */
    private static final class C0035d implements c {

        /* renamed from: a, reason: collision with root package name */
        ClipData f3163a;

        /* renamed from: b, reason: collision with root package name */
        int f3164b;

        /* renamed from: c, reason: collision with root package name */
        int f3165c;

        /* renamed from: d, reason: collision with root package name */
        Uri f3166d;
        Bundle e;

        C0035d(ClipData clipData, int i2) {
            this.f3163a = clipData;
            this.f3164b = i2;
        }

        @Override // androidx.core.view.C0161d.c
        public void a(Uri uri) {
            this.f3166d = uri;
        }

        @Override // androidx.core.view.C0161d.c
        public C0161d build() {
            return new C0161d(new g(this));
        }

        @Override // androidx.core.view.C0161d.c
        public void setExtras(Bundle bundle) {
            this.e = bundle;
        }

        @Override // androidx.core.view.C0161d.c
        public void setFlags(int i2) {
            this.f3165c = i2;
        }
    }

    /* renamed from: androidx.core.view.d$e */
    private static final class e implements f {

        /* renamed from: a, reason: collision with root package name */
        private final ContentInfo f3167a;

        e(ContentInfo contentInfo) {
            this.f3167a = AbstractC0160c.a(AbstractC0345h.f(contentInfo));
        }

        @Override // androidx.core.view.C0161d.f
        public ClipData a() {
            return this.f3167a.getClip();
        }

        @Override // androidx.core.view.C0161d.f
        public ContentInfo b() {
            return this.f3167a;
        }

        @Override // androidx.core.view.C0161d.f
        public int c() {
            return this.f3167a.getSource();
        }

        @Override // androidx.core.view.C0161d.f
        public int getFlags() {
            return this.f3167a.getFlags();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f3167a + "}";
        }
    }

    /* renamed from: androidx.core.view.d$f */
    private interface f {
        ClipData a();

        ContentInfo b();

        int c();

        int getFlags();
    }

    /* renamed from: androidx.core.view.d$g */
    private static final class g implements f {

        /* renamed from: a, reason: collision with root package name */
        private final ClipData f3168a;

        /* renamed from: b, reason: collision with root package name */
        private final int f3169b;

        /* renamed from: c, reason: collision with root package name */
        private final int f3170c;

        /* renamed from: d, reason: collision with root package name */
        private final Uri f3171d;
        private final Bundle e;

        g(C0035d c0035d) {
            this.f3168a = (ClipData) AbstractC0345h.f(c0035d.f3163a);
            this.f3169b = AbstractC0345h.b(c0035d.f3164b, 0, 5, "source");
            this.f3170c = AbstractC0345h.e(c0035d.f3165c, 1);
            this.f3171d = c0035d.f3166d;
            this.e = c0035d.e;
        }

        @Override // androidx.core.view.C0161d.f
        public ClipData a() {
            return this.f3168a;
        }

        @Override // androidx.core.view.C0161d.f
        public ContentInfo b() {
            return null;
        }

        @Override // androidx.core.view.C0161d.f
        public int c() {
            return this.f3169b;
        }

        @Override // androidx.core.view.C0161d.f
        public int getFlags() {
            return this.f3170c;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f3168a.getDescription());
            sb.append(", source=");
            sb.append(C0161d.e(this.f3169b));
            sb.append(", flags=");
            sb.append(C0161d.a(this.f3170c));
            if (this.f3171d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f3171d.toString().length() + ")";
            }
            sb.append(str);
            sb.append(this.e != null ? ", hasExtras" : "");
            sb.append("}");
            return sb.toString();
        }
    }

    C0161d(f fVar) {
        this.f3160a = fVar;
    }

    static String a(int i2) {
        return (i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2);
    }

    static String e(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? String.valueOf(i2) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public static C0161d g(ContentInfo contentInfo) {
        return new C0161d(new e(contentInfo));
    }

    public ClipData b() {
        return this.f3160a.a();
    }

    public int c() {
        return this.f3160a.getFlags();
    }

    public int d() {
        return this.f3160a.c();
    }

    public ContentInfo f() {
        ContentInfo contentInfoB = this.f3160a.b();
        Objects.requireNonNull(contentInfoB);
        return AbstractC0160c.a(contentInfoB);
    }

    public String toString() {
        return this.f3160a.toString();
    }
}
