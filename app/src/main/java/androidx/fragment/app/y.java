package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.w;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class y implements Parcelable {
    public static final Parcelable.Creator<y> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    ArrayList f3637a;

    /* renamed from: b, reason: collision with root package name */
    ArrayList f3638b;

    /* renamed from: c, reason: collision with root package name */
    C0184b[] f3639c;

    /* renamed from: d, reason: collision with root package name */
    int f3640d;
    String e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList f3641f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList f3642g;

    /* renamed from: h, reason: collision with root package name */
    ArrayList f3643h;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public y createFromParcel(Parcel parcel) {
            return new y(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public y[] newArray(int i2) {
            return new y[i2];
        }
    }

    public y() {
        this.e = null;
        this.f3641f = new ArrayList();
        this.f3642g = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStringList(this.f3637a);
        parcel.writeStringList(this.f3638b);
        parcel.writeTypedArray(this.f3639c, i2);
        parcel.writeInt(this.f3640d);
        parcel.writeString(this.e);
        parcel.writeStringList(this.f3641f);
        parcel.writeTypedList(this.f3642g);
        parcel.writeTypedList(this.f3643h);
    }

    public y(Parcel parcel) {
        this.e = null;
        this.f3641f = new ArrayList();
        this.f3642g = new ArrayList();
        this.f3637a = parcel.createStringArrayList();
        this.f3638b = parcel.createStringArrayList();
        this.f3639c = (C0184b[]) parcel.createTypedArray(C0184b.CREATOR);
        this.f3640d = parcel.readInt();
        this.e = parcel.readString();
        this.f3641f = parcel.createStringArrayList();
        this.f3642g = parcel.createTypedArrayList(C0185c.CREATOR);
        this.f3643h = parcel.createTypedArrayList(w.k.CREATOR);
    }
}
