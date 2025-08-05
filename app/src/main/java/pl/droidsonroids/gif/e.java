package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
abstract class e {

    /* renamed from: a, reason: collision with root package name */
    static final List f7177a = Arrays.asList("raw", "drawable", "mipmap");

    static class a {

        /* renamed from: a, reason: collision with root package name */
        final int f7178a;

        /* renamed from: b, reason: collision with root package name */
        final int f7179b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f7180c;

        a(int i2, int i3, boolean z2) {
            this.f7178a = i2;
            this.f7179b = i3;
            this.f7180c = z2;
        }
    }

    static float a(Resources resources, int i2) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i2, typedValue, true);
        int i3 = typedValue.density;
        if (i3 == 0) {
            i3 = 160;
        } else if (i3 == 65535) {
            i3 = 0;
        }
        int i4 = resources.getDisplayMetrics().densityDpi;
        if (i3 <= 0 || i4 <= 0) {
            return 1.0f;
        }
        return i4 / i3;
    }

    private static int b(ImageView imageView, AttributeSet attributeSet, boolean z2) {
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z2 ? "src" : "background", 0);
        if (attributeResourceValue > 0) {
            if (f7177a.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !f(imageView, z2, attributeResourceValue)) {
                return attributeResourceValue;
            }
        }
        return 0;
    }

    static a c(ImageView imageView, AttributeSet attributeSet, int i2, int i3) {
        return (attributeSet == null || imageView.isInEditMode()) ? new a(0, 0, false) : new a(b(imageView, attributeSet, true), b(imageView, attributeSet, false), d(imageView, attributeSet, i2, i3));
    }

    static boolean d(View view, AttributeSet attributeSet, int i2, int i3) {
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, u1.a.f7669b, i2, i3);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(u1.a.f7670c, false);
        typedArrayObtainStyledAttributes.recycle();
        return z2;
    }

    static boolean e(ImageView imageView, Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            imageView.setImageDrawable(new pl.droidsonroids.gif.a(imageView.getContext().getContentResolver(), uri));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    static boolean f(ImageView imageView, boolean z2, int i2) {
        Resources resources = imageView.getResources();
        if (resources == null) {
            return false;
        }
        try {
            pl.droidsonroids.gif.a aVar = new pl.droidsonroids.gif.a(resources, i2);
            if (z2) {
                imageView.setImageDrawable(aVar);
                return true;
            }
            imageView.setBackground(aVar);
            return true;
        } catch (Resources.NotFoundException | IOException unused) {
            return false;
        }
    }
}
