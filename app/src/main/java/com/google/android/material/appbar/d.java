package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.M;

/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final View f5637a;

    /* renamed from: b, reason: collision with root package name */
    private int f5638b;

    /* renamed from: c, reason: collision with root package name */
    private int f5639c;

    /* renamed from: d, reason: collision with root package name */
    private int f5640d;
    private int e;

    public d(View view) {
        this.f5637a = view;
    }

    private void e() {
        View view = this.f5637a;
        M.V(view, this.f5640d - (view.getTop() - this.f5638b));
        View view2 = this.f5637a;
        M.U(view2, this.e - (view2.getLeft() - this.f5639c));
    }

    public int a() {
        return this.f5640d;
    }

    public void b() {
        this.f5638b = this.f5637a.getTop();
        this.f5639c = this.f5637a.getLeft();
        e();
    }

    public boolean c(int i2) {
        if (this.e == i2) {
            return false;
        }
        this.e = i2;
        e();
        return true;
    }

    public boolean d(int i2) {
        if (this.f5640d == i2) {
            return false;
        }
        this.f5640d = i2;
        e();
        return true;
    }
}
