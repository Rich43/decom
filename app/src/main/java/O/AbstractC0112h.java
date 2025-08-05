package O;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.util.Property;

/* renamed from: O.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0112h {
    static PropertyValuesHolder a(Property property, Path path) {
        return PropertyValuesHolder.ofObject(property, (TypeConverter) null, path);
    }
}
