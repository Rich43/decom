package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.DialogInterfaceC0127b;
import androidx.appcompat.view.menu.j;
import defpackage.e;

/* loaded from: classes.dex */
class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a {

    /* renamed from: a, reason: collision with root package name */
    private e f1992a;

    /* renamed from: b, reason: collision with root package name */
    private DialogInterfaceC0127b f1993b;

    /* renamed from: c, reason: collision with root package name */
    c f1994c;

    /* renamed from: d, reason: collision with root package name */
    private j.a f1995d;

    public f(e eVar) {
        this.f1992a = eVar;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void a(e eVar, boolean z2) {
        if (z2 || eVar == this.f1992a) {
            c();
        }
        j.a aVar = this.f1995d;
        if (aVar != null) {
            aVar.a(eVar, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean b(e eVar) {
        j.a aVar = this.f1995d;
        if (aVar != null) {
            return aVar.b(eVar);
        }
        return false;
    }

    public void c() {
        DialogInterfaceC0127b dialogInterfaceC0127b = this.f1993b;
        if (dialogInterfaceC0127b != null) {
            dialogInterfaceC0127b.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        e eVar = this.f1992a;
        DialogInterfaceC0127b.a aVar = new DialogInterfaceC0127b.a(eVar.u());
        c cVar = new c(aVar.b(), e.j.f5951j);
        this.f1994c = cVar;
        cVar.h(this);
        this.f1992a.b(this.f1994c);
        aVar.c(this.f1994c.b(), this);
        View viewY = eVar.y();
        if (viewY != null) {
            aVar.d(viewY);
        } else {
            aVar.e(eVar.w()).m(eVar.x());
        }
        aVar.i(this);
        DialogInterfaceC0127b dialogInterfaceC0127bA = aVar.a();
        this.f1993b = dialogInterfaceC0127bA;
        dialogInterfaceC0127bA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1993b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1993b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f1992a.M((g) this.f1994c.b().getItem(i2), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1994c.a(this.f1992a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1993b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1993b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1992a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1992a.performShortcut(i2, keyEvent, 0);
    }
}
