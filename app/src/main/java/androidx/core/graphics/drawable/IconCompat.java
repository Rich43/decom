package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import v.AbstractC0340c;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f3001k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f3002a;

    /* renamed from: b, reason: collision with root package name */
    Object f3003b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f3004c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f3005d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f3006f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f3007g;

    /* renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f3008h;

    /* renamed from: i, reason: collision with root package name */
    public String f3009i;

    /* renamed from: j, reason: collision with root package name */
    public String f3010j;

    static class a {
        static int a(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e) {
                Log.e("IconCompat", "Unable to get icon resource", e);
                return 0;
            } catch (NoSuchMethodException e2) {
                Log.e("IconCompat", "Unable to get icon resource", e2);
                return 0;
            } catch (InvocationTargetException e3) {
                Log.e("IconCompat", "Unable to get icon resource", e3);
                return 0;
            }
        }

        static String b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
            } catch (IllegalAccessException e) {
                Log.e("IconCompat", "Unable to get icon package", e);
                return null;
            } catch (NoSuchMethodException e2) {
                Log.e("IconCompat", "Unable to get icon package", e2);
                return null;
            } catch (InvocationTargetException e3) {
                Log.e("IconCompat", "Unable to get icon package", e3);
                return null;
            }
        }

        static Uri c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException e) {
                Log.e("IconCompat", "Unable to get icon uri", e);
                return null;
            } catch (NoSuchMethodException e2) {
                Log.e("IconCompat", "Unable to get icon uri", e2);
                return null;
            } catch (InvocationTargetException e3) {
                Log.e("IconCompat", "Unable to get icon uri", e3);
                return null;
            }
        }

        static Drawable d(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        static Icon e(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f3002a) {
                case -1:
                    return (Icon) iconCompat.f3003b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f3003b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.e(), iconCompat.e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f3003b, iconCompat.e, iconCompat.f3006f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f3003b);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT < 26) {
                        iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.a((Bitmap) iconCompat.f3003b, false));
                        break;
                    } else {
                        iconCreateWithBitmap = b.b((Bitmap) iconCompat.f3003b);
                        break;
                    }
                case 6:
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 30) {
                        iconCreateWithBitmap = d.a(iconCompat.f());
                        break;
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.f());
                        }
                        InputStream inputStreamG = iconCompat.g(context);
                        if (inputStreamG == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.f());
                        }
                        if (i2 < 26) {
                            iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.a(BitmapFactory.decodeStream(inputStreamG), false));
                            break;
                        } else {
                            iconCreateWithBitmap = b.b(BitmapFactory.decodeStream(inputStreamG));
                            break;
                        }
                    }
            }
            ColorStateList colorStateList = iconCompat.f3007g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f3008h;
            if (mode != IconCompat.f3001k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    static class b {
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    static class c {
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    static class d {
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f3002a = -1;
        this.f3004c = null;
        this.f3005d = null;
        this.e = 0;
        this.f3006f = 0;
        this.f3007g = null;
        this.f3008h = f3001k;
        this.f3009i = null;
    }

    static Bitmap a(Bitmap bitmap, boolean z2) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f2 = iMin;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z2) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat b(Bitmap bitmap) {
        AbstractC0340c.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f3003b = bitmap;
        return iconCompat;
    }

    private static String k(int i2) {
        switch (i2) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap c() {
        int i2 = this.f3002a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f3003b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i2 == 1) {
            return (Bitmap) this.f3003b;
        }
        if (i2 == 5) {
            return a((Bitmap) this.f3003b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int d() {
        int i2 = this.f3002a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.a(this.f3003b);
        }
        if (i2 == 2) {
            return this.e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String e() {
        int i2 = this.f3002a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.f3003b);
        }
        if (i2 == 2) {
            String str = this.f3010j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f3003b).split(":", -1)[0] : this.f3010j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public Uri f() {
        int i2 = this.f3002a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.c(this.f3003b);
        }
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.f3003b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream g(Context context) {
        Uri uriF = f();
        String scheme = uriF.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriF);
            } catch (Exception e) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriF, e);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f3003b));
        } catch (FileNotFoundException e2) {
            Log.w("IconCompat", "Unable to load image from path: " + uriF, e2);
            return null;
        }
    }

    public void h() {
        this.f3008h = PorterDuff.Mode.valueOf(this.f3009i);
        switch (this.f3002a) {
            case -1:
                Parcelable parcelable = this.f3005d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f3003b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f3005d;
                if (parcelable2 != null) {
                    this.f3003b = parcelable2;
                    return;
                }
                byte[] bArr = this.f3004c;
                this.f3003b = bArr;
                this.f3002a = 3;
                this.e = 0;
                this.f3006f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f3004c, Charset.forName("UTF-16"));
                this.f3003b = str;
                if (this.f3002a == 2 && this.f3010j == null) {
                    this.f3010j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f3003b = this.f3004c;
                return;
        }
    }

    public void i(boolean z2) {
        this.f3009i = this.f3008h.name();
        switch (this.f3002a) {
            case -1:
                if (z2) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f3005d = (Parcelable) this.f3003b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z2) {
                    this.f3005d = (Parcelable) this.f3003b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f3003b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f3004c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f3004c = ((String) this.f3003b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f3004c = (byte[]) this.f3003b;
                return;
            case 4:
            case 6:
                this.f3004c = this.f3003b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public Icon j(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.e(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public String toString() {
        if (this.f3002a == -1) {
            return String.valueOf(this.f3003b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(k(this.f3002a));
        switch (this.f3002a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f3003b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f3003b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f3010j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(d())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.e);
                if (this.f3006f != 0) {
                    sb.append(" off=");
                    sb.append(this.f3006f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f3003b);
                break;
        }
        if (this.f3007g != null) {
            sb.append(" tint=");
            sb.append(this.f3007g);
        }
        if (this.f3008h != f3001k) {
            sb.append(" mode=");
            sb.append(this.f3008h);
        }
        sb.append(")");
        return sb.toString();
    }

    IconCompat(int i2) {
        this.f3004c = null;
        this.f3005d = null;
        this.e = 0;
        this.f3006f = 0;
        this.f3007g = null;
        this.f3008h = f3001k;
        this.f3009i = null;
        this.f3002a = i2;
    }
}
