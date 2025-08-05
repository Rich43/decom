package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b {

    static class a {
        static <T> T a(Bundle bundle, String str, Class<T> cls) {
            return (T) bundle.getParcelable(str, cls);
        }

        static <T> T[] b(Bundle bundle, String str, Class<T> cls) {
            return (T[]) bundle.getParcelableArray(str, cls);
        }

        static <T> ArrayList<T> c(Bundle bundle, String str, Class<? extends T> cls) {
            return bundle.getParcelableArrayList(str, cls);
        }

        static <T extends Serializable> T d(Bundle bundle, String str, Class<T> cls) {
            return (T) bundle.getSerializable(str, cls);
        }

        static <T> SparseArray<T> e(Bundle bundle, String str, Class<? extends T> cls) {
            return bundle.getSparseParcelableArray(str, cls);
        }
    }

    public static Object a(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(bundle, str, cls);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (cls.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }
}
