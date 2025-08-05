package b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import i1.k;

/* renamed from: b.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0211a implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    private final int f4559a;

    /* renamed from: b, reason: collision with root package name */
    private final Intent f4560b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f4558c = new b(null);
    public static final Parcelable.Creator<C0211a> CREATOR = new C0060a();

    /* renamed from: b.a$a, reason: collision with other inner class name */
    public static final class C0060a implements Parcelable.Creator {
        C0060a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0211a createFromParcel(Parcel parcel) {
            k.e(parcel, "parcel");
            return new C0211a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0211a[] newArray(int i2) {
            return new C0211a[i2];
        }
    }

    /* renamed from: b.a$b */
    public static final class b {
        public /* synthetic */ b(i1.g gVar) {
            this();
        }

        public final String a(int i2) {
            return i2 != -1 ? i2 != 0 ? String.valueOf(i2) : "RESULT_CANCELED" : "RESULT_OK";
        }

        private b() {
        }
    }

    public C0211a(int i2, Intent intent) {
        this.f4559a = i2;
        this.f4560b = intent;
    }

    public final Intent a() {
        return this.f4560b;
    }

    public final int b() {
        return this.f4559a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + f4558c.a(this.f4559a) + ", data=" + this.f4560b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        k.e(parcel, "dest");
        parcel.writeInt(this.f4559a);
        parcel.writeInt(this.f4560b == null ? 0 : 1);
        Intent intent = this.f4560b;
        if (intent != null) {
            intent.writeToParcel(parcel, i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0211a(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel));
        k.e(parcel, "parcel");
    }
}
