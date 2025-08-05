package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.appcompat.widget.b */
/* loaded from: classes.dex */
class C0134b extends Drawable {

    /* renamed from: a */
    final ActionBarContainer f2379a;

    /* renamed from: androidx.appcompat.widget.b$a */
    private static class a {
        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public C0134b(ActionBarContainer actionBarContainer) {
        this.f2379a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f2379a;
        if (actionBarContainer.f2064h) {
            Drawable drawable = actionBarContainer.f2063g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f2379a;
        Drawable drawable3 = actionBarContainer2.f2062f;
        if (drawable3 == null || !actionBarContainer2.f2065i) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f2379a;
        if (actionBarContainer.f2064h) {
            if (actionBarContainer.f2063g != null) {
                a.a(actionBarContainer.e, outline);
            }
        } else {
            Drawable drawable = actionBarContainer.e;
            if (drawable != null) {
                a.a(drawable, outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
