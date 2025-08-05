package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.AbstractC0203h;

/* loaded from: classes.dex */
final class B implements Parcelable {
    public static final Parcelable.Creator<B> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final String f3351a;

    /* renamed from: b, reason: collision with root package name */
    final String f3352b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f3353c;

    /* renamed from: d, reason: collision with root package name */
    final int f3354d;
    final int e;

    /* renamed from: f, reason: collision with root package name */
    final String f3355f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f3356g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f3357h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f3358i;

    /* renamed from: j, reason: collision with root package name */
    final Bundle f3359j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f3360k;

    /* renamed from: l, reason: collision with root package name */
    final int f3361l;

    /* renamed from: m, reason: collision with root package name */
    Bundle f3362m;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public B createFromParcel(Parcel parcel) {
            return new B(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public B[] newArray(int i2) {
            return new B[i2];
        }
    }

    B(Fragment fragment) {
        this.f3351a = fragment.getClass().getName();
        this.f3352b = fragment.mWho;
        this.f3353c = fragment.mFromLayout;
        this.f3354d = fragment.mFragmentId;
        this.e = fragment.mContainerId;
        this.f3355f = fragment.mTag;
        this.f3356g = fragment.mRetainInstance;
        this.f3357h = fragment.mRemoving;
        this.f3358i = fragment.mDetached;
        this.f3359j = fragment.mArguments;
        this.f3360k = fragment.mHidden;
        this.f3361l = fragment.mMaxState.ordinal();
    }

    Fragment a(n nVar, ClassLoader classLoader) {
        Fragment fragmentA = nVar.a(classLoader, this.f3351a);
        Bundle bundle = this.f3359j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentA.setArguments(this.f3359j);
        fragmentA.mWho = this.f3352b;
        fragmentA.mFromLayout = this.f3353c;
        fragmentA.mRestored = true;
        fragmentA.mFragmentId = this.f3354d;
        fragmentA.mContainerId = this.e;
        fragmentA.mTag = this.f3355f;
        fragmentA.mRetainInstance = this.f3356g;
        fragmentA.mRemoving = this.f3357h;
        fragmentA.mDetached = this.f3358i;
        fragmentA.mHidden = this.f3360k;
        fragmentA.mMaxState = AbstractC0203h.b.values()[this.f3361l];
        Bundle bundle2 = this.f3362m;
        if (bundle2 != null) {
            fragmentA.mSavedFragmentState = bundle2;
        } else {
            fragmentA.mSavedFragmentState = new Bundle();
        }
        return fragmentA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f3351a);
        sb.append(" (");
        sb.append(this.f3352b);
        sb.append(")}:");
        if (this.f3353c) {
            sb.append(" fromLayout");
        }
        if (this.e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.e));
        }
        String str = this.f3355f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f3355f);
        }
        if (this.f3356g) {
            sb.append(" retainInstance");
        }
        if (this.f3357h) {
            sb.append(" removing");
        }
        if (this.f3358i) {
            sb.append(" detached");
        }
        if (this.f3360k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f3351a);
        parcel.writeString(this.f3352b);
        parcel.writeInt(this.f3353c ? 1 : 0);
        parcel.writeInt(this.f3354d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f3355f);
        parcel.writeInt(this.f3356g ? 1 : 0);
        parcel.writeInt(this.f3357h ? 1 : 0);
        parcel.writeInt(this.f3358i ? 1 : 0);
        parcel.writeBundle(this.f3359j);
        parcel.writeInt(this.f3360k ? 1 : 0);
        parcel.writeBundle(this.f3362m);
        parcel.writeInt(this.f3361l);
    }

    B(Parcel parcel) {
        this.f3351a = parcel.readString();
        this.f3352b = parcel.readString();
        this.f3353c = parcel.readInt() != 0;
        this.f3354d = parcel.readInt();
        this.e = parcel.readInt();
        this.f3355f = parcel.readString();
        this.f3356g = parcel.readInt() != 0;
        this.f3357h = parcel.readInt() != 0;
        this.f3358i = parcel.readInt() != 0;
        this.f3359j = parcel.readBundle();
        this.f3360k = parcel.readInt() != 0;
        this.f3362m = parcel.readBundle();
        this.f3361l = parcel.readInt();
    }
}
