package U;

import V.i;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import c0.f;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private final AssetManager f894d;

    /* renamed from: a, reason: collision with root package name */
    private final i f891a = new i();

    /* renamed from: b, reason: collision with root package name */
    private final Map f892b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map f893c = new HashMap();
    private String e = ".ttf";

    public a(Drawable.Callback callback, Q.a aVar) {
        if (callback instanceof View) {
            this.f894d = ((View) callback).getContext().getAssets();
        } else {
            f.b("LottieDrawable must be inside of a view for images to work.");
            this.f894d = null;
        }
    }

    private Typeface a(String str) {
        Typeface typeface = (Typeface) this.f893c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(this.f894d, "fonts/" + str + this.e);
        this.f893c.put(str, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface d(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i2 = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
    }

    public Typeface b(String str, String str2) {
        this.f891a.b(str, str2);
        Typeface typeface = (Typeface) this.f892b.get(this.f891a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceD = d(a(str), str2);
        this.f892b.put(this.f891a, typefaceD);
        return typefaceD;
    }

    public void c(Q.a aVar) {
    }
}
