package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.E;
import androidx.lifecycle.AbstractC0203h;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0184b implements Parcelable {
    public static final Parcelable.Creator<C0184b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final int[] f3492a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f3493b;

    /* renamed from: c, reason: collision with root package name */
    final int[] f3494c;

    /* renamed from: d, reason: collision with root package name */
    final int[] f3495d;
    final int e;

    /* renamed from: f, reason: collision with root package name */
    final String f3496f;

    /* renamed from: g, reason: collision with root package name */
    final int f3497g;

    /* renamed from: h, reason: collision with root package name */
    final int f3498h;

    /* renamed from: i, reason: collision with root package name */
    final CharSequence f3499i;

    /* renamed from: j, reason: collision with root package name */
    final int f3500j;

    /* renamed from: k, reason: collision with root package name */
    final CharSequence f3501k;

    /* renamed from: l, reason: collision with root package name */
    final ArrayList f3502l;

    /* renamed from: m, reason: collision with root package name */
    final ArrayList f3503m;

    /* renamed from: n, reason: collision with root package name */
    final boolean f3504n;

    /* renamed from: androidx.fragment.app.b$a */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0184b createFromParcel(Parcel parcel) {
            return new C0184b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0184b[] newArray(int i2) {
            return new C0184b[i2];
        }
    }

    C0184b(C0183a c0183a) {
        int size = c0183a.f3376c.size();
        this.f3492a = new int[size * 6];
        if (!c0183a.f3381i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f3493b = new ArrayList(size);
        this.f3494c = new int[size];
        this.f3495d = new int[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            E.a aVar = (E.a) c0183a.f3376c.get(i3);
            int i4 = i2 + 1;
            this.f3492a[i2] = aVar.f3389a;
            ArrayList arrayList = this.f3493b;
            Fragment fragment = aVar.f3390b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f3492a;
            iArr[i4] = aVar.f3391c ? 1 : 0;
            iArr[i2 + 2] = aVar.f3392d;
            iArr[i2 + 3] = aVar.e;
            int i5 = i2 + 5;
            iArr[i2 + 4] = aVar.f3393f;
            i2 += 6;
            iArr[i5] = aVar.f3394g;
            this.f3494c[i3] = aVar.f3395h.ordinal();
            this.f3495d[i3] = aVar.f3396i.ordinal();
        }
        this.e = c0183a.f3380h;
        this.f3496f = c0183a.f3383k;
        this.f3497g = c0183a.f3490v;
        this.f3498h = c0183a.f3384l;
        this.f3499i = c0183a.f3385m;
        this.f3500j = c0183a.f3386n;
        this.f3501k = c0183a.o;
        this.f3502l = c0183a.f3387p;
        this.f3503m = c0183a.f3388q;
        this.f3504n = c0183a.r;
    }

    private void a(C0183a c0183a) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= this.f3492a.length) {
                c0183a.f3380h = this.e;
                c0183a.f3383k = this.f3496f;
                c0183a.f3381i = true;
                c0183a.f3384l = this.f3498h;
                c0183a.f3385m = this.f3499i;
                c0183a.f3386n = this.f3500j;
                c0183a.o = this.f3501k;
                c0183a.f3387p = this.f3502l;
                c0183a.f3388q = this.f3503m;
                c0183a.r = this.f3504n;
                return;
            }
            E.a aVar = new E.a();
            int i4 = i2 + 1;
            aVar.f3389a = this.f3492a[i2];
            if (w.H0(2)) {
                Log.v("FragmentManager", "Instantiate " + c0183a + " op #" + i3 + " base fragment #" + this.f3492a[i4]);
            }
            aVar.f3395h = AbstractC0203h.b.values()[this.f3494c[i3]];
            aVar.f3396i = AbstractC0203h.b.values()[this.f3495d[i3]];
            int[] iArr = this.f3492a;
            int i5 = i2 + 2;
            if (iArr[i4] == 0) {
                z2 = false;
            }
            aVar.f3391c = z2;
            int i6 = iArr[i5];
            aVar.f3392d = i6;
            int i7 = iArr[i2 + 3];
            aVar.e = i7;
            int i8 = i2 + 5;
            int i9 = iArr[i2 + 4];
            aVar.f3393f = i9;
            i2 += 6;
            int i10 = iArr[i8];
            aVar.f3394g = i10;
            c0183a.f3377d = i6;
            c0183a.e = i7;
            c0183a.f3378f = i9;
            c0183a.f3379g = i10;
            c0183a.f(aVar);
            i3++;
        }
    }

    public C0183a b(w wVar) {
        C0183a c0183a = new C0183a(wVar);
        a(c0183a);
        c0183a.f3490v = this.f3497g;
        for (int i2 = 0; i2 < this.f3493b.size(); i2++) {
            String str = (String) this.f3493b.get(i2);
            if (str != null) {
                ((E.a) c0183a.f3376c.get(i2)).f3390b = wVar.f0(str);
            }
        }
        c0183a.p(1);
        return c0183a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f3492a);
        parcel.writeStringList(this.f3493b);
        parcel.writeIntArray(this.f3494c);
        parcel.writeIntArray(this.f3495d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f3496f);
        parcel.writeInt(this.f3497g);
        parcel.writeInt(this.f3498h);
        TextUtils.writeToParcel(this.f3499i, parcel, 0);
        parcel.writeInt(this.f3500j);
        TextUtils.writeToParcel(this.f3501k, parcel, 0);
        parcel.writeStringList(this.f3502l);
        parcel.writeStringList(this.f3503m);
        parcel.writeInt(this.f3504n ? 1 : 0);
    }

    C0184b(Parcel parcel) {
        this.f3492a = parcel.createIntArray();
        this.f3493b = parcel.createStringArrayList();
        this.f3494c = parcel.createIntArray();
        this.f3495d = parcel.createIntArray();
        this.e = parcel.readInt();
        this.f3496f = parcel.readString();
        this.f3497g = parcel.readInt();
        this.f3498h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f3499i = (CharSequence) creator.createFromParcel(parcel);
        this.f3500j = parcel.readInt();
        this.f3501k = (CharSequence) creator.createFromParcel(parcel);
        this.f3502l = parcel.createStringArrayList();
        this.f3503m = parcel.createStringArrayList();
        this.f3504n = parcel.readInt() != 0;
    }
}
