package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import v.AbstractC0345h;

/* renamed from: androidx.fragment.app.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0195m {

    /* renamed from: a, reason: collision with root package name */
    private final o f3568a;

    private C0195m(o oVar) {
        this.f3568a = oVar;
    }

    public static C0195m b(o oVar) {
        return new C0195m((o) AbstractC0345h.g(oVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        o oVar = this.f3568a;
        oVar.e.n(oVar, oVar, fragment);
    }

    public void c() {
        this.f3568a.e.y();
    }

    public boolean d(MenuItem menuItem) {
        return this.f3568a.e.B(menuItem);
    }

    public void e() {
        this.f3568a.e.C();
    }

    public void f() {
        this.f3568a.e.E();
    }

    public void g() {
        this.f3568a.e.N();
    }

    public void h() {
        this.f3568a.e.R();
    }

    public void i() {
        this.f3568a.e.S();
    }

    public void j() {
        this.f3568a.e.U();
    }

    public boolean k() {
        return this.f3568a.e.b0(true);
    }

    public w l() {
        return this.f3568a.e;
    }

    public void m() {
        this.f3568a.e.Y0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f3568a.e.v0().onCreateView(view, str, context, attributeSet);
    }
}
