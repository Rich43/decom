package Z0;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Typeface f1373a;

    /* renamed from: b, reason: collision with root package name */
    private static Typeface f1374b;

    /* renamed from: c, reason: collision with root package name */
    private static int f1375c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f1376d;
    private static boolean e;

    /* renamed from: f, reason: collision with root package name */
    private static Toast f1377f;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Typeface f1378a = e.f1374b;

        /* renamed from: b, reason: collision with root package name */
        private int f1379b = e.f1375c;

        /* renamed from: c, reason: collision with root package name */
        private boolean f1380c = e.f1376d;

        /* renamed from: d, reason: collision with root package name */
        private boolean f1381d = true;

        private a() {
        }

        public static a c() {
            return new a();
        }

        public a a(boolean z2) {
            this.f1381d = z2;
            return this;
        }

        public void b() {
            Typeface unused = e.f1374b = this.f1378a;
            int unused2 = e.f1375c = this.f1379b;
            boolean unused3 = e.f1376d = this.f1380c;
            boolean unused4 = e.e = this.f1381d;
        }
    }

    static {
        Typeface typefaceCreate = Typeface.create("sans-serif-condensed", 0);
        f1373a = typefaceCreate;
        f1374b = typefaceCreate;
        f1375c = 16;
        f1376d = true;
        e = true;
        f1377f = null;
    }

    public static Toast h(Context context, CharSequence charSequence, Drawable drawable, int i2, int i3, int i4, boolean z2, boolean z3) {
        Toast toastMakeText = Toast.makeText(context, "", i4);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.f1372a, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(c.f1370a);
        TextView textView = (TextView) viewInflate.findViewById(c.f1371b);
        f.c(viewInflate, z3 ? f.d(context, i2) : f.b(context, b.f1369b));
        if (!z2) {
            imageView.setVisibility(8);
        } else {
            if (drawable == null) {
                throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
            }
            if (f1376d) {
                drawable = f.e(drawable, i3);
            }
            f.c(imageView, drawable);
        }
        textView.setText(charSequence);
        textView.setTextColor(i3);
        textView.setTypeface(f1374b);
        textView.setTextSize(2, f1375c);
        toastMakeText.setView(viewInflate);
        if (!e) {
            Toast toast = f1377f;
            if (toast != null) {
                toast.cancel();
            }
            f1377f = toastMakeText;
        }
        return toastMakeText;
    }

    public static Toast i(Context context, int i2) {
        return j(context, context.getString(i2), 0, true);
    }

    public static Toast j(Context context, CharSequence charSequence, int i2, boolean z2) {
        return h(context, charSequence, f.b(context, b.f1368a), f.a(context, Z0.a.f1367b), f.a(context, Z0.a.f1366a), i2, z2, true);
    }
}
