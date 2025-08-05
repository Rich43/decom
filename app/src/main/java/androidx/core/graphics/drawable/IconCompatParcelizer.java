package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(androidx.versionedparcelable.a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f3002a = aVar.p(iconCompat.f3002a, 1);
        iconCompat.f3004c = aVar.j(iconCompat.f3004c, 2);
        iconCompat.f3005d = aVar.r(iconCompat.f3005d, 3);
        iconCompat.e = aVar.p(iconCompat.e, 4);
        iconCompat.f3006f = aVar.p(iconCompat.f3006f, 5);
        iconCompat.f3007g = (ColorStateList) aVar.r(iconCompat.f3007g, 6);
        iconCompat.f3009i = aVar.t(iconCompat.f3009i, 7);
        iconCompat.f3010j = aVar.t(iconCompat.f3010j, 8);
        iconCompat.h();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(true, true);
        iconCompat.i(aVar.f());
        int i2 = iconCompat.f3002a;
        if (-1 != i2) {
            aVar.F(i2, 1);
        }
        byte[] bArr = iconCompat.f3004c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f3005d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i3 = iconCompat.e;
        if (i3 != 0) {
            aVar.F(i3, 4);
        }
        int i4 = iconCompat.f3006f;
        if (i4 != 0) {
            aVar.F(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f3007g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f3009i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f3010j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
