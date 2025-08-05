package O0;

/* loaded from: classes.dex */
final class e extends i {

    /* renamed from: c, reason: collision with root package name */
    private final String f513c;

    /* renamed from: d, reason: collision with root package name */
    private final String f514d;

    e(D0.a aVar, String str, String str2) {
        super(aVar);
        this.f513c = str2;
        this.f514d = str;
    }

    private void k(StringBuilder sb, int i2) {
        int iF = b().f(i2, 16);
        if (iF == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f513c);
        sb.append(')');
        int i3 = iF % 32;
        int i4 = iF / 32;
        int i5 = (i4 % 12) + 1;
        int i6 = i4 / 12;
        if (i6 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i6);
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i3 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i3);
    }

    @Override // O0.j
    public String d() throws z0.i {
        if (c().g() != 84) {
            throw z0.i.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        j(sb, 48, 20);
        k(sb, 68);
        return sb.toString();
    }

    @Override // O0.i
    protected void h(StringBuilder sb, int i2) {
        sb.append('(');
        sb.append(this.f514d);
        sb.append(i2 / 100000);
        sb.append(')');
    }

    @Override // O0.i
    protected int i(int i2) {
        return i2 % 100000;
    }
}
