package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
class d extends View.BaseSavedState {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final long[][] f7176a;

    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i2) {
            return new d[i2];
        }
    }

    /* synthetic */ d(Parcel parcel, a aVar) {
        this(parcel);
    }

    void a(Drawable drawable, int i2) {
        if (this.f7176a[i2] == null || !(drawable instanceof pl.droidsonroids.gif.a)) {
            return;
        }
        ((pl.droidsonroids.gif.a) drawable).h(r3.f7142g.r(r4, r3.f7141f));
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f7176a.length);
        for (long[] jArr : this.f7176a) {
            parcel.writeLongArray(jArr);
        }
    }

    d(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f7176a = new long[drawableArr.length][];
        for (int i2 = 0; i2 < drawableArr.length; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable instanceof pl.droidsonroids.gif.a) {
                this.f7176a[i2] = ((pl.droidsonroids.gif.a) drawable).f7142g.i();
            } else {
                this.f7176a[i2] = null;
            }
        }
    }

    private d(Parcel parcel) {
        super(parcel);
        this.f7176a = new long[parcel.readInt()][];
        int i2 = 0;
        while (true) {
            long[][] jArr = this.f7176a;
            if (i2 >= jArr.length) {
                return;
            }
            jArr[i2] = parcel.createLongArray();
            i2++;
        }
    }
}
