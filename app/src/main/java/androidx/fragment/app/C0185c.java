package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0185c implements Parcelable {
    public static final Parcelable.Creator<C0185c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final List f3505a;

    /* renamed from: b, reason: collision with root package name */
    final List f3506b;

    /* renamed from: androidx.fragment.app.c$a */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0185c createFromParcel(Parcel parcel) {
            return new C0185c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0185c[] newArray(int i2) {
            return new C0185c[i2];
        }
    }

    C0185c(Parcel parcel) {
        this.f3505a = parcel.createStringArrayList();
        this.f3506b = parcel.createTypedArrayList(C0184b.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStringList(this.f3505a);
        parcel.writeTypedList(this.f3506b);
    }
}
