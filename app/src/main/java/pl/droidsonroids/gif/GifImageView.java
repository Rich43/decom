package pl.droidsonroids.gif;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import pl.droidsonroids.gif.e;

/* loaded from: classes.dex */
public class GifImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7135a;

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(e.c(this, attributeSet, 0, 0));
    }

    private void a(e.a aVar) {
        this.f7135a = aVar.f7180c;
        int i2 = aVar.f7178a;
        if (i2 > 0) {
            super.setImageResource(i2);
        }
        int i3 = aVar.f7179b;
        if (i3 > 0) {
            super.setBackgroundResource(i3);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        dVar.a(getDrawable(), 0);
        dVar.a(getBackground(), 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new d(super.onSaveInstanceState(), this.f7135a ? getDrawable() : null, this.f7135a ? getBackground() : null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        if (e.f(this, false, i2)) {
            return;
        }
        super.setBackgroundResource(i2);
    }

    public void setFreezesAnimation(boolean z2) {
        this.f7135a = z2;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        if (e.f(this, true, i2)) {
            return;
        }
        super.setImageResource(i2);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (e.e(this, uri)) {
            return;
        }
        super.setImageURI(uri);
    }
}
