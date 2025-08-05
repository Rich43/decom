package y0;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.StateSet;

/* renamed from: y0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0375a {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f7738a = true;

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f7739b = {R.attr.state_pressed};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f7740c = {R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f7741d = {R.attr.state_focused};
    private static final int[] e = {R.attr.state_hovered};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f7742f = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f7743g = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f7744h = {R.attr.state_selected, R.attr.state_focused};

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f7745i = {R.attr.state_selected, R.attr.state_hovered};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f7746j = {R.attr.state_selected};

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f7738a) {
            return new ColorStateList(new int[][]{f7746j, StateSet.NOTHING}, new int[]{c(colorStateList, f7742f), c(colorStateList, f7739b)});
        }
        int[] iArr = f7742f;
        int[] iArr2 = f7743g;
        int[] iArr3 = f7744h;
        int[] iArr4 = f7745i;
        int[] iArr5 = f7739b;
        int[] iArr6 = f7740c;
        int[] iArr7 = f7741d;
        int[] iArr8 = e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f7746j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    private static int b(int i2) {
        return androidx.core.graphics.a.f(i2, Math.min(Color.alpha(i2) * 2, 255));
    }

    private static int c(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f7738a ? b(colorForState) : colorForState;
    }
}
