package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class c {
    public static final Bundle a(a1.e... eVarArr) {
        Bundle bundle = new Bundle(eVarArr.length);
        for (a1.e eVar : eVarArr) {
            String str = (String) eVar.a();
            Object objB = eVar.b();
            if (objB == null) {
                bundle.putString(str, null);
            } else if (objB instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) objB).booleanValue());
            } else if (objB instanceof Byte) {
                bundle.putByte(str, ((Number) objB).byteValue());
            } else if (objB instanceof Character) {
                bundle.putChar(str, ((Character) objB).charValue());
            } else if (objB instanceof Double) {
                bundle.putDouble(str, ((Number) objB).doubleValue());
            } else if (objB instanceof Float) {
                bundle.putFloat(str, ((Number) objB).floatValue());
            } else if (objB instanceof Integer) {
                bundle.putInt(str, ((Number) objB).intValue());
            } else if (objB instanceof Long) {
                bundle.putLong(str, ((Number) objB).longValue());
            } else if (objB instanceof Short) {
                bundle.putShort(str, ((Number) objB).shortValue());
            } else if (objB instanceof Bundle) {
                bundle.putBundle(str, (Bundle) objB);
            } else if (objB instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) objB);
            } else if (objB instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) objB);
            } else if (objB instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) objB);
            } else if (objB instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) objB);
            } else if (objB instanceof char[]) {
                bundle.putCharArray(str, (char[]) objB);
            } else if (objB instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) objB);
            } else if (objB instanceof float[]) {
                bundle.putFloatArray(str, (float[]) objB);
            } else if (objB instanceof int[]) {
                bundle.putIntArray(str, (int[]) objB);
            } else if (objB instanceof long[]) {
                bundle.putLongArray(str, (long[]) objB);
            } else if (objB instanceof short[]) {
                bundle.putShortArray(str, (short[]) objB);
            } else if (objB instanceof Object[]) {
                Class<?> componentType = objB.getClass().getComponentType();
                i1.k.b(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    i1.k.c(objB, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    bundle.putParcelableArray(str, (Parcelable[]) objB);
                } else if (String.class.isAssignableFrom(componentType)) {
                    i1.k.c(objB, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    bundle.putStringArray(str, (String[]) objB);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    i1.k.c(objB, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    bundle.putCharSequenceArray(str, (CharSequence[]) objB);
                } else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str + '\"');
                    }
                    bundle.putSerializable(str, (Serializable) objB);
                }
            } else if (objB instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) objB);
            } else if (objB instanceof IBinder) {
                bundle.putBinder(str, (IBinder) objB);
            } else if (objB instanceof Size) {
                a.a(bundle, str, (Size) objB);
            } else {
                if (!(objB instanceof SizeF)) {
                    throw new IllegalArgumentException("Illegal value type " + objB.getClass().getCanonicalName() + " for key \"" + str + '\"');
                }
                a.b(bundle, str, (SizeF) objB);
            }
        }
        return bundle;
    }
}
