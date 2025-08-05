package com.caglobal.kodakluma.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AbstractActivityC0128c;
import androidx.appcompat.app.DialogInterfaceC0127b;
import com.caglobal.kodakluma.R;
import com.eshare.api.EShareAPI;
import com.eshare.api.IDevice;
import com.eshare.api.utils.LogHelper;
import j0.InterfaceC0272a;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k0.DialogC0275a;
import l0.InterfaceC0280d;
import org.greenrobot.eventbus.ThreadMode;
import q0.AbstractC0314c;
import q0.C0315d;
import q0.C0317f;
import s1.m;

/* loaded from: classes.dex */
public abstract class a extends AbstractActivityC0128c implements View.OnClickListener, InterfaceC0272a, C0315d.b {

    /* renamed from: D */
    public int f5378D;

    /* renamed from: E */
    protected boolean f5379E;

    /* renamed from: F */
    protected int f5380F;

    /* renamed from: G */
    protected int f5381G;

    /* renamed from: H */
    protected int f5382H;

    /* renamed from: J */
    private InterfaceC0280d f5384J;

    /* renamed from: K */
    private DialogInterfaceC0127b f5385K;

    /* renamed from: L */
    private DialogInterfaceC0127b f5386L;

    /* renamed from: M */
    private IDevice f5387M;

    /* renamed from: N */
    private int f5388N;

    /* renamed from: O */
    private C0315d f5389O;

    /* renamed from: P */
    private Dialog f5390P;

    /* renamed from: Q */
    private ExecutorService f5391Q;

    /* renamed from: R */
    private DialogC0275a f5392R;

    /* renamed from: I */
    private int f5383I = -1;

    /* renamed from: S */
    private Handler f5393S = new c(Looper.getMainLooper());

    /* renamed from: com.caglobal.kodakluma.activity.a$a */
    class DialogInterfaceOnClickListenerC0067a implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC0067a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
        }
    }

    class b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ File f5395a;

        b(File file) {
            this.f5395a = file;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            a.this.f5392R.h(this.f5395a);
        }
    }

    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            switch (message.what) {
                case 1:
                    a.this.F1();
                    break;
                case 2:
                    boolean zX1 = a.this.x1();
                    int iIntValue = ((Integer) message.obj).intValue();
                    if (iIntValue == 1 && a.this.f5384J != null) {
                        a.this.f5384J.onSuccess();
                    }
                    if (!zX1) {
                        a.this.G1(iIntValue);
                        break;
                    }
                    break;
                case 3:
                    if (!a.this.x1()) {
                        a.this.G1(3);
                        break;
                    }
                    break;
                case 4:
                    a.this.z1();
                    break;
                case 5:
                    a aVar = a.this;
                    if (aVar.f5378D != 0) {
                        aVar.K1();
                        break;
                    }
                    break;
                case 6:
                    if (a.this.f5385K.isShowing()) {
                        a.this.f5385K.dismiss();
                        break;
                    }
                    break;
            }
        }
    }

    class d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f5398a;

        d(int i2) {
            this.f5398a = i2;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a aVar = a.this;
            aVar.J1(this.f5398a, aVar.f5384J);
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f5387M != null) {
                a.this.f5387M.sendCastRequest(a.this.f5388N);
            }
        }
    }

    class f implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ EditText f5401a;

        /* renamed from: b */
        final /* synthetic */ TextView f5402b;

        /* renamed from: c */
        final /* synthetic */ Runnable f5403c;

        f(EditText editText, TextView textView, Runnable runnable) {
            this.f5401a = editText;
            this.f5402b = textView;
            this.f5403c = runnable;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            String strTrim = this.f5401a.getText().toString().trim();
            if (TextUtils.isEmpty(strTrim)) {
                this.f5402b.setVisibility(0);
                return;
            }
            AbstractC0314c.c(a.this, strTrim);
            if (a.this.f5387M == null) {
                a aVar = a.this;
                aVar.f5387M = EShareAPI.init(aVar).device();
            }
            a.this.f5387M.setClientName(strTrim);
            Runnable runnable = this.f5403c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    class g implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Runnable f5405a;

        g(Runnable runnable) {
            this.f5405a = runnable;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Runnable runnable = this.f5405a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    class h implements DialogInterface.OnCancelListener {

        /* renamed from: a */
        final /* synthetic */ Runnable f5407a;

        h(Runnable runnable) {
            this.f5407a = runnable;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Runnable runnable = this.f5407a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    class i implements TextWatcher {

        /* renamed from: a */
        final /* synthetic */ DialogInterfaceC0127b f5409a;

        /* renamed from: b */
        final /* synthetic */ TextView f5410b;

        i(DialogInterfaceC0127b dialogInterfaceC0127b, TextView textView) {
            this.f5409a = dialogInterfaceC0127b;
            this.f5410b = textView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().isEmpty()) {
                this.f5409a.j(-1).setEnabled(false);
                this.f5410b.setVisibility(0);
            } else {
                this.f5409a.j(-1).setEnabled(true);
                this.f5410b.setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    class j implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ String f5412a;

        j(String str) {
            this.f5412a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            a.this.f5387M.allowCast(true, this.f5412a);
        }
    }

    class k implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ String f5414a;

        k(String str) {
            this.f5414a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            a.this.f5387M.allowCast(false, this.f5414a);
        }
    }

    public void F1() throws Throwable {
        Dialog dialog = this.f5390P;
        if (dialog == null || !dialog.isShowing()) {
            if (!this.f5379E) {
                q0.k.a("showConfirmDialog isStarted false");
                return;
            }
            if (this.f5390P != null) {
                this.f5390P = null;
            }
            this.f5393S.removeMessages(3);
            Dialog dialogF = C0315d.f(this, R.string.confirm_loading_title, R.string.confirm_loading_cancel);
            this.f5390P = dialogF;
            dialogF.show();
            this.f5390P.setCanceledOnTouchOutside(false);
            this.f5390P.setCancelable(false);
            this.f5393S.sendEmptyMessageDelayed(3, 10000L);
        }
    }

    public void G1(int i2) {
        if (this.f5379E) {
            if (i2 == 2) {
                C0315d.g(this, R.string.confirm_error_message_deny, R.string.confirm_error_ok);
            } else if (i2 == 3) {
                C0315d.g(this, R.string.confirm_error_message_timeout, R.string.confirm_error_ok);
            } else {
                if (i2 != 5) {
                    return;
                }
                C0315d.g(this, R.string.confirm_error_message_error, R.string.confirm_error_ok);
            }
        }
    }

    public void K1() {
        Z0.e.h(this, getString(R.string.host_function_disabled), null, getResources().getColor(R.color.c_666666), getResources().getColor(R.color.white), 0, false, true).show();
    }

    public boolean x1() {
        Dialog dialog = this.f5390P;
        if (dialog == null || !dialog.isShowing()) {
            return true;
        }
        this.f5390P.cancel();
        this.f5390P = null;
        return false;
    }

    private void y1() {
        this.f5393S.removeMessages(3, this.f5393S.obtainMessage(3));
        if (this.f5387M == null) {
            this.f5387M = EShareAPI.init(this).device();
        }
        this.f5387M.cancelCastRequest();
    }

    public void z1() {
        DialogInterfaceC0127b dialogInterfaceC0127b;
        if (this.f5379E && (dialogInterfaceC0127b = this.f5386L) != null && dialogInterfaceC0127b.isShowing()) {
            this.f5386L.dismiss();
        }
    }

    public void A1(File file) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.tips).setMessage(getString(R.string.save_file) + " " + file.getName() + "?").setCancelable(false).setPositiveButton(R.string.host_assign_ok_btn, new b(file)).setNegativeButton(R.string.setting_rename_cancel, new DialogInterfaceOnClickListenerC0067a());
        builder.create().show();
    }

    protected abstract void B1();

    protected abstract int C1();

    protected abstract void D1();

    protected abstract void E1();

    protected void H1(Runnable runnable) {
        DialogInterfaceC0127b.a aVar = new DialogInterfaceC0127b.a(this);
        aVar.l(R.string.setting_rename_title);
        View viewInflate = View.inflate(this, R.layout.dialog_rename, null);
        EditText editText = (EditText) viewInflate.findViewById(R.id.et_rename);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_dialog_error);
        String strA = AbstractC0314c.a(this);
        if (!TextUtils.isEmpty(strA)) {
            if (strA.length() > 13) {
                strA = strA.substring(0, 13);
            }
            editText.setText(strA);
            editText.setSelection(strA.length());
        }
        aVar.n(viewInflate);
        aVar.j(R.string.setting_rename_save, new f(editText, textView, runnable));
        aVar.g(R.string.setting_rename_cancel, new g(runnable));
        aVar.h(new h(runnable));
        DialogInterfaceC0127b dialogInterfaceC0127bA = aVar.a();
        editText.addTextChangedListener(new i(dialogInterfaceC0127bA, textView));
        dialogInterfaceC0127bA.show();
    }

    protected void I1(int i2, InterfaceC0280d interfaceC0280d) {
        this.f5387M = EShareAPI.init(this).device();
        this.f5384J = interfaceC0280d;
        if (!AbstractC0314c.b(this)) {
            J1(i2, this.f5384J);
        } else {
            H1(new d(i2));
            AbstractC0314c.d(this, false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:95:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void J1(int r4, l0.InterfaceC0280d r5) throws java.lang.Throwable {
        /*
            r3 = this;
            r0 = 0
            r1 = 1
            boolean r2 = r3.f5379E
            if (r2 != 0) goto L10
            java.lang.Object[] r4 = new java.lang.Object[r1]
            java.lang.String r5 = "startRequest isStarted false"
            r4[r0] = r5
            q0.k.a(r4)
            return
        L10:
            com.eshare.api.IDevice r2 = r3.f5387M
            boolean r2 = r2.isProDevice()
            if (r2 != 0) goto L1e
            l0.d r4 = r3.f5384J
            r4.onSuccess()
            return
        L1e:
            r3.f5388N = r4
            r3.f5384J = r5
            r2 = 2
            switch(r4) {
                case 0: goto L56;
                case 1: goto L56;
                case 2: goto L56;
                case 3: goto L56;
                case 4: goto L45;
                case 5: goto L26;
                case 6: goto L56;
                case 7: goto L56;
                case 8: goto L37;
                case 9: goto L27;
                default: goto L26;
            }
        L26:
            goto L64
        L27:
            int r4 = r3.f5381G
            if (r4 != 0) goto L2f
            r3.K1()
            return
        L2f:
            if (r4 == r1) goto L33
            if (r4 != r2) goto L64
        L33:
            r5.onSuccess()
            return
        L37:
            int r4 = r3.f5383I
            if (r4 != r1) goto L3f
            r5.onSuccess()
            goto L65
        L3f:
            if (r4 != 0) goto L64
            r3.K1()
            return
        L45:
            int r4 = r3.f5381G
            if (r4 == 0) goto L52
            if (r4 != r2) goto L4c
            goto L52
        L4c:
            if (r4 != r1) goto L64
            r5.onSuccess()
            return
        L52:
            r3.K1()
            return
        L56:
            int r4 = r3.f5383I
            if (r4 != r1) goto L5e
            r5.onSuccess()
            return
        L5e:
            if (r4 != 0) goto L64
            r3.K1()
            return
        L64:
            r0 = 1
        L65:
            com.caglobal.kodakluma.activity.a$e r4 = new com.caglobal.kodakluma.activity.a$e
            r4.<init>()
            r4.run()
            if (r0 == 0) goto L74
            android.os.Handler r4 = r3.f5393S
            r4.sendEmptyMessage(r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caglobal.kodakluma.activity.a.J1(int, l0.d):void");
    }

    @Override // q0.C0315d.b
    public void a() {
        y1();
    }

    @m(threadMode = ThreadMode.MAIN)
    public void cancelPeerCastDialog(h0.j jVar) {
        z1();
    }

    @m(threadMode = ThreadMode.MAIN)
    public void castRequestReceive(h0.f fVar) {
        if (this.f5390P == null) {
            return;
        }
        x1();
        if (fVar.a() == 1) {
            if (this.f5379E) {
                this.f5384J.onSuccess();
            }
        } else if (fVar.a() == 0) {
            G1(2);
        } else {
            G1(3);
        }
    }

    @m
    public void heartbeatInfoUpdate(h0.h hVar) {
        if (this.f5383I != hVar.a() && hVar.a() == 0) {
            this.f5383I = hVar.a();
            h0.g gVar = new h0.g();
            gVar.b(h0.g.f6396c);
            s1.c.c().l(gVar);
        }
        if (this.f5381G != hVar.c() && hVar.c() == 0) {
            this.f5381G = hVar.c();
            this.f5393S.sendEmptyMessage(5);
            h0.g gVar2 = new h0.g();
            gVar2.b(h0.g.f6397d);
            s1.c.c().l(gVar2);
        }
        this.f5383I = hVar.a();
        this.f5381G = hVar.c();
        this.f5380F = hVar.d();
        this.f5382H = hVar.b();
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if ((this instanceof MainActivity) || MainActivity.Y2() == null) {
            return;
        }
        MainActivity.Y2().e3(i2, i3, intent);
    }

    public void onClick(View view) {
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1());
        new q0.k(this);
        new LogHelper(this);
        B1();
        D1();
        E1();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        s1.c.c().p(this);
        C0315d c0315d = new C0315d();
        this.f5389O = c0315d;
        c0315d.e(this);
    }

    @Override // androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        DialogInterfaceC0127b dialogInterfaceC0127b = this.f5386L;
        if (dialogInterfaceC0127b != null && dialogInterfaceC0127b.isShowing()) {
            this.f5386L.dismiss();
            this.f5386L = null;
        }
        s1.c.c().r(this);
    }

    @m(threadMode = ThreadMode.MAIN)
    public void onEventMain(C0317f c0317f) {
        if (this.f5379E) {
            int iB = c0317f.b();
            c0317f.a();
            if (iB == 1000) {
                MainActivity.Y2().M3(false, MainActivity.Y2());
            } else {
                if (iB != 1001) {
                    return;
                }
                this.f5393S.removeMessages(6);
                if (this.f5385K.isShowing()) {
                    this.f5385K.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f5379E = true;
        MainActivity mainActivityY2 = MainActivity.Y2();
        if (!"MainActivity".equals(getClass().getSimpleName()) && mainActivityY2 != null) {
            mainActivityY2.p3(this);
        }
        this.f5391Q = Executors.newSingleThreadExecutor();
        this.f5392R = new DialogC0275a(this, this.f5391Q);
    }

    @Override // androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f5379E = false;
    }

    @m(threadMode = ThreadMode.MAIN)
    public void peerCastRequestHandle(h0.i iVar) {
        String str;
        if (!MainActivity.J1 && this.f5379E) {
            z1();
            this.f5393S.removeMessages(4);
            DialogInterfaceC0127b.a aVar = new DialogInterfaceC0127b.a(this);
            switch (iVar.a()) {
                case 0:
                    str = String.format(getString(R.string.host_cast_request_doc), iVar.b());
                    break;
                case 1:
                    str = String.format(getString(R.string.host_cast_request_pics), iVar.b());
                    break;
                case 2:
                    str = String.format(getString(R.string.host_cast_request_audio_video), iVar.b());
                    break;
                case 3:
                case 9:
                default:
                    str = String.format(getString(R.string.host_cast_request_mirror), iVar.b());
                    break;
                case 4:
                    str = String.format(getString(R.string.host_cast_request_remote), iVar.b());
                    break;
                case 5:
                    str = String.format(getString(R.string.host_cast_request_apk), iVar.b());
                    break;
                case 6:
                    str = String.format(getString(R.string.host_cast_request_camera), iVar.b());
                    break;
                case 7:
                    str = String.format(getString(R.string.host_cast_request_mirror), iVar.b());
                    break;
                case 8:
                    str = String.format(getString(R.string.host_cast_full_request_content), iVar.b());
                    break;
                case 10:
                    str = String.format(getString(R.string.host_cast_request_cancel_fullcast), iVar.b());
                    break;
            }
            aVar.f(str);
            if (this.f5387M == null) {
                this.f5387M = EShareAPI.init(this).device();
            }
            String strC = iVar.c();
            aVar.j(R.string.host_cast_request_ok_btn, new j(strC));
            aVar.g(android.R.string.cancel, new k(strC));
            DialogInterfaceC0127b dialogInterfaceC0127bA = aVar.a();
            this.f5386L = dialogInterfaceC0127bA;
            dialogInterfaceC0127bA.show();
            this.f5393S.sendEmptyMessageDelayed(4, 10000L);
        }
    }

    public void v1(Object... objArr) throws Throwable {
        q0.k.a(objArr);
    }

    public void w1(Object... objArr) throws Throwable {
        q0.k.b(objArr);
    }
}
