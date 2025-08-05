package U;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import c0.f;
import c0.j;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static final Object f895d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Context f896a;

    /* renamed from: b, reason: collision with root package name */
    private String f897b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f898c;

    public b(Drawable.Callback callback, String str, Q.b bVar, Map map) {
        this.f897b = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f897b.charAt(r4.length() - 1) != '/') {
                this.f897b += '/';
            }
        }
        if (callback instanceof View) {
            this.f896a = ((View) callback).getContext();
            this.f898c = map;
            d(bVar);
        } else {
            f.b("LottieDrawable must be inside of a view for images to work.");
            this.f898c = new HashMap();
            this.f896a = null;
        }
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (f895d) {
            ((Q.f) this.f898c.get(str)).f(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        Q.f fVar = (Q.f) this.f898c.get(str);
        if (fVar == null) {
            return null;
        }
        Bitmap bitmapA = fVar.a();
        if (bitmapA != null) {
            return bitmapA;
        }
        String strB = fVar.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strB.startsWith("data:") && strB.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strB.substring(strB.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e) {
                f.c("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.f897b)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            return c(str, j.k(BitmapFactory.decodeStream(this.f896a.getAssets().open(this.f897b + strB), null, options), fVar.e(), fVar.c()));
        } catch (IOException e2) {
            f.c("Unable to open asset.", e2);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f896a == null) || this.f896a.equals(context);
    }

    public void d(Q.b bVar) {
    }
}
