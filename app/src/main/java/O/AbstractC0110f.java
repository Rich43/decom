package O;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.util.Property;

/* renamed from: O.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0110f {
    static ObjectAnimator a(Object obj, Property property, Path path) {
        return ObjectAnimator.ofObject(obj, (Property<Object, V>) property, (TypeConverter) null, path);
    }
}
