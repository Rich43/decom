package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
import defpackage.e;

/* renamed from: androidx.appcompat.app.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class DialogInterfaceC0127b extends x implements DialogInterface {

    /* renamed from: f, reason: collision with root package name */
    final AlertController f1700f;

    /* renamed from: androidx.appcompat.app.b$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final AlertController.f f1701a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1702b;

        public a(Context context) {
            this(context, DialogInterfaceC0127b.l(context, 0));
        }

        public DialogInterfaceC0127b a() {
            DialogInterfaceC0127b dialogInterfaceC0127b = new DialogInterfaceC0127b(this.f1701a.f1614a, this.f1702b);
            this.f1701a.a(dialogInterfaceC0127b.f1700f);
            dialogInterfaceC0127b.setCancelable(this.f1701a.r);
            if (this.f1701a.r) {
                dialogInterfaceC0127b.setCanceledOnTouchOutside(true);
            }
            dialogInterfaceC0127b.setOnCancelListener(this.f1701a.s);
            dialogInterfaceC0127b.setOnDismissListener(this.f1701a.f1629t);
            DialogInterface.OnKeyListener onKeyListener = this.f1701a.f1630u;
            if (onKeyListener != null) {
                dialogInterfaceC0127b.setOnKeyListener(onKeyListener);
            }
            return dialogInterfaceC0127b;
        }

        public Context b() {
            return this.f1701a.f1614a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1701a;
            fVar.f1632w = listAdapter;
            fVar.f1633x = onClickListener;
            return this;
        }

        public a d(View view) {
            this.f1701a.f1619g = view;
            return this;
        }

        public a e(Drawable drawable) {
            this.f1701a.f1617d = drawable;
            return this;
        }

        public a f(CharSequence charSequence) {
            this.f1701a.f1620h = charSequence;
            return this;
        }

        public a g(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1701a;
            fVar.f1624l = fVar.f1614a.getText(i2);
            this.f1701a.f1626n = onClickListener;
            return this;
        }

        public a h(DialogInterface.OnCancelListener onCancelListener) {
            this.f1701a.s = onCancelListener;
            return this;
        }

        public a i(DialogInterface.OnKeyListener onKeyListener) {
            this.f1701a.f1630u = onKeyListener;
            return this;
        }

        public a j(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1701a;
            fVar.f1621i = fVar.f1614a.getText(i2);
            this.f1701a.f1623k = onClickListener;
            return this;
        }

        public a k(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1701a;
            fVar.f1632w = listAdapter;
            fVar.f1633x = onClickListener;
            fVar.f1607I = i2;
            fVar.f1606H = true;
            return this;
        }

        public a l(int i2) {
            AlertController.f fVar = this.f1701a;
            fVar.f1618f = fVar.f1614a.getText(i2);
            return this;
        }

        public a m(CharSequence charSequence) {
            this.f1701a.f1618f = charSequence;
            return this;
        }

        public a n(View view) {
            AlertController.f fVar = this.f1701a;
            fVar.f1635z = view;
            fVar.f1634y = 0;
            fVar.f1603E = false;
            return this;
        }

        public a(Context context, int i2) {
            this.f1701a = new AlertController.f(new ContextThemeWrapper(context, DialogInterfaceC0127b.l(context, i2)));
            this.f1702b = i2;
        }
    }

    protected DialogInterfaceC0127b(Context context, int i2) {
        super(context, l(context, i2));
        this.f1700f = new AlertController(getContext(), this, getWindow());
    }

    static int l(Context context, int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(e.d.f5846l, typedValue, true);
        return typedValue.resourceId;
    }

    public Button j(int i2) {
        return this.f1700f.c(i2);
    }

    public ListView k() {
        return this.f1700f.e();
    }

    @Override // androidx.appcompat.app.x, androidx.activity.q, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1700f.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.f1700f.h(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.f1700f.i(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // androidx.appcompat.app.x, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1700f.r(charSequence);
    }
}
