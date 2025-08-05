package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;

/* loaded from: classes.dex */
class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f4479d;
    private final Parcel e;

    /* renamed from: f, reason: collision with root package name */
    private final int f4480f;

    /* renamed from: g, reason: collision with root package name */
    private final int f4481g;

    /* renamed from: h, reason: collision with root package name */
    private final String f4482h;

    /* renamed from: i, reason: collision with root package name */
    private int f4483i;

    /* renamed from: j, reason: collision with root package name */
    private int f4484j;

    /* renamed from: k, reason: collision with root package name */
    private int f4485k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.e.writeInt(-1);
        } else {
            this.e.writeInt(bArr.length);
            this.e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i2) {
        this.e.writeInt(i2);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i2 = this.f4483i;
        if (i2 >= 0) {
            int i3 = this.f4479d.get(i2);
            int iDataPosition = this.e.dataPosition();
            this.e.setDataPosition(i3);
            this.e.writeInt(iDataPosition - i3);
            this.e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.e;
        int iDataPosition = parcel.dataPosition();
        int i2 = this.f4484j;
        if (i2 == this.f4480f) {
            i2 = this.f4481g;
        }
        return new b(parcel, iDataPosition, i2, this.f4482h + "  ", this.f4476a, this.f4477b, this.f4478c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int i2 = this.e.readInt();
        if (i2 < 0) {
            return null;
        }
        byte[] bArr = new byte[i2];
        this.e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i2) {
        while (this.f4484j < this.f4481g) {
            int i3 = this.f4485k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.e.setDataPosition(this.f4484j);
            int i4 = this.e.readInt();
            this.f4485k = this.e.readInt();
            this.f4484j += i4;
        }
        return this.f4485k == i2;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public Parcelable q() {
        return this.e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i2) {
        a();
        this.f4483i = i2;
        this.f4479d.put(i2, this.e.dataPosition());
        E(0);
        E(i2);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z2) {
        this.e.writeInt(z2 ? 1 : 0);
    }

    private b(Parcel parcel, int i2, int i3, String str, androidx.collection.a aVar, androidx.collection.a aVar2, androidx.collection.a aVar3) {
        super(aVar, aVar2, aVar3);
        this.f4479d = new SparseIntArray();
        this.f4483i = -1;
        this.f4485k = -1;
        this.e = parcel;
        this.f4480f = i2;
        this.f4481g = i3;
        this.f4484j = i2;
        this.f4482h = str;
    }
}
