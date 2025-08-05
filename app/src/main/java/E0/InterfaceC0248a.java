package e0;

import android.os.Environment;

/* renamed from: e0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0248a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6093a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f6094b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f6095c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f6096d;
    public static final String e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f6097f;

    static {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        f6093a = absolutePath;
        f6094b = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
        String str = absolutePath + "/.esharecache/video";
        f6095c = str;
        f6096d = str + "/%s.png";
        e = absolutePath + "/.esharecache/appList";
        f6097f = absolutePath + "/EShare";
    }
}
