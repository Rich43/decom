package h0;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* renamed from: h0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0263d implements Parcelable {
    public static final Parcelable.Creator<C0263d> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f6381a;

    /* renamed from: b, reason: collision with root package name */
    public String f6382b;

    /* renamed from: c, reason: collision with root package name */
    public String f6383c;

    /* renamed from: d, reason: collision with root package name */
    public int f6384d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f6385f;

    /* renamed from: g, reason: collision with root package name */
    public int f6386g;

    /* renamed from: h0.d$a */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0263d createFromParcel(Parcel parcel) {
            return new C0263d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0263d[] newArray(int i2) {
            return new C0263d[i2];
        }
    }

    protected C0263d(Parcel parcel) {
        g(parcel);
    }

    public String a() {
        return this.f6383c;
    }

    public String b() {
        return this.f6382b;
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.f6384d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f6386g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0263d c0263d = (C0263d) obj;
        String str = this.f6383c;
        if (str == null) {
            if (c0263d.f6383c != null) {
                return false;
            }
        } else if (!str.equals(c0263d.f6383c)) {
            return false;
        }
        return true;
    }

    public int f() {
        return this.f6385f;
    }

    public void g(Parcel parcel) {
        try {
            this.f6381a = parcel.readInt();
            this.f6382b = parcel.readString();
            this.f6383c = parcel.readString();
            this.f6384d = parcel.readInt();
            this.e = parcel.readInt();
            this.f6385f = parcel.readInt();
            this.f6386g = parcel.readInt();
        } catch (Throwable th) {
            Log.e("Lee", "readFromParcel Crash----" + Log.getStackTraceString(th));
        }
    }

    public int hashCode() {
        String str = this.f6383c;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ClientInfo [device_os=" + this.f6381a + ", ClientModel=" + this.f6382b + ", ClientIp=" + this.f6383c + ", mastercontrol=" + this.f6384d + ", fullScreen=" + this.e + ", screening=" + this.f6385f + ", requestCasting=" + this.f6386g + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6381a);
        parcel.writeString(this.f6382b);
        parcel.writeString(this.f6383c);
        parcel.writeInt(this.f6384d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f6385f);
        parcel.writeInt(this.f6386g);
    }
}
