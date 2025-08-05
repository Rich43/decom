package q0;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.caglobal.kodakluma.R;

/* renamed from: q0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0315d {

    /* renamed from: a, reason: collision with root package name */
    private static b f7204a;

    /* renamed from: b, reason: collision with root package name */
    private static AlertDialog f7205b;

    /* renamed from: q0.d$a */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            C0315d.f7204a.a();
        }
    }

    /* renamed from: q0.d$b */
    public interface b {
        void a();
    }

    public static ProgressDialog b(Context context) {
        return c(context, R.string.loading_title, R.string.loading_msg);
    }

    public static ProgressDialog c(Context context, int i2, int i3) {
        return d(context, context.getString(i2), i3 != -1 ? context.getString(i3) : "");
    }

    public static ProgressDialog d(Context context, String str, String str2) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(str);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(true);
        return progressDialog;
    }

    public static Dialog f(Context context, int i2, int i3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(i2);
        builder.setPositiveButton(i3, new a());
        AlertDialog alertDialogCreate = builder.create();
        f7205b = alertDialogCreate;
        return alertDialogCreate;
    }

    public static void g(Context context, int i2, int i3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(i2);
        builder.setPositiveButton(i3, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void e(b bVar) {
        f7204a = bVar;
    }
}
