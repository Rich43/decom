package A;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class a implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    private final Parcelable f1a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f0b = new C0000a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* renamed from: A.a$a, reason: collision with other inner class name */
    static class C0000a extends a {
        C0000a() {
            super((C0000a) null);
        }
    }

    static class b implements Parcelable.ClassLoaderCreator {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f0b;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    /* synthetic */ a(C0000a c0000a) {
        this();
    }

    public final Parcelable a() {
        return this.f1a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f1a, i2);
    }

    private a() {
        this.f1a = null;
    }

    protected a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f1a = parcelable == f0b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected a(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f1a = parcelable == null ? f0b : parcelable;
    }
}
