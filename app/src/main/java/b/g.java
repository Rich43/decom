package b;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import i1.k;

/* loaded from: classes.dex */
public final class g implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    private final IntentSender f4583a;

    /* renamed from: b, reason: collision with root package name */
    private final Intent f4584b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4585c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4586d;
    public static final c e = new c(null);
    public static final Parcelable.Creator<g> CREATOR = new b();

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final IntentSender f4587a;

        /* renamed from: b, reason: collision with root package name */
        private Intent f4588b;

        /* renamed from: c, reason: collision with root package name */
        private int f4589c;

        /* renamed from: d, reason: collision with root package name */
        private int f4590d;

        public a(IntentSender intentSender) {
            k.e(intentSender, "intentSender");
            this.f4587a = intentSender;
        }

        public final g a() {
            return new g(this.f4587a, this.f4588b, this.f4589c, this.f4590d);
        }

        public final a b(Intent intent) {
            this.f4588b = intent;
            return this;
        }

        public final a c(int i2, int i3) {
            this.f4590d = i2;
            this.f4589c = i3;
            return this;
        }
    }

    public static final class b implements Parcelable.Creator {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            k.e(parcel, "inParcel");
            return new g(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i2) {
            return new g[i2];
        }
    }

    public static final class c {
        public /* synthetic */ c(i1.g gVar) {
            this();
        }

        private c() {
        }
    }

    public g(IntentSender intentSender, Intent intent, int i2, int i3) {
        k.e(intentSender, "intentSender");
        this.f4583a = intentSender;
        this.f4584b = intent;
        this.f4585c = i2;
        this.f4586d = i3;
    }

    public final Intent a() {
        return this.f4584b;
    }

    public final int b() {
        return this.f4585c;
    }

    public final int c() {
        return this.f4586d;
    }

    public final IntentSender d() {
        return this.f4583a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        k.e(parcel, "dest");
        parcel.writeParcelable(this.f4583a, i2);
        parcel.writeParcelable(this.f4584b, i2);
        parcel.writeInt(this.f4585c);
        parcel.writeInt(this.f4586d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public g(Parcel parcel) {
        k.e(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        k.b(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
