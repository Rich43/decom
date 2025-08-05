package k0;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.caglobal.kodakluma.CustomApplication;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.view.ProgressCircle;
import com.eshare.api.EShareAPI;
import com.eshare.api.IMedia;
import java.io.File;
import java.util.concurrent.ExecutorService;
import q0.k;

/* renamed from: k0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class DialogC0275a extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private ProgressCircle f6506a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f6507b;

    /* renamed from: c, reason: collision with root package name */
    private ExecutorService f6508c;

    /* renamed from: d, reason: collision with root package name */
    private IMedia f6509d;
    private e e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f6510f;

    /* renamed from: k0.a$a, reason: collision with other inner class name */
    class HandlerC0087a extends Handler {

        /* renamed from: k0.a$a$a, reason: collision with other inner class name */
        class RunnableC0088a implements Runnable {
            RunnableC0088a() {
            }

            @Override // java.lang.Runnable
            public void run() throws Throwable {
                int uploadProgress = DialogC0275a.this.f6509d.getUploadProgress();
                DialogC0275a.this.f("getUploadProgress", Integer.valueOf(uploadProgress));
                switch (uploadProgress) {
                    case -105:
                        HandlerC0087a handlerC0087a = HandlerC0087a.this;
                        handlerC0087a.sendMessageDelayed(handlerC0087a.obtainMessage(2), 100L);
                        break;
                    case -104:
                    case -103:
                        HandlerC0087a handlerC0087a2 = HandlerC0087a.this;
                        handlerC0087a2.sendMessage(handlerC0087a2.obtainMessage(1));
                        break;
                    case -102:
                        HandlerC0087a handlerC0087a3 = HandlerC0087a.this;
                        handlerC0087a3.sendMessage(handlerC0087a3.obtainMessage(3));
                        break;
                    default:
                        if (uploadProgress < 0) {
                            HandlerC0087a handlerC0087a4 = HandlerC0087a.this;
                            handlerC0087a4.sendMessage(handlerC0087a4.obtainMessage(1));
                            break;
                        } else {
                            DialogC0275a.this.f6506a.setProgress(uploadProgress);
                            HandlerC0087a handlerC0087a5 = HandlerC0087a.this;
                            handlerC0087a5.sendMessageDelayed(handlerC0087a5.obtainMessage(2), 100L);
                            break;
                        }
                }
            }
        }

        HandlerC0087a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                DialogC0275a.this.cancel();
                CustomApplication.f(R.string.document_upload_failed);
            } else {
                if (i2 == 2) {
                    DialogC0275a.this.f6508c.execute(new RunnableC0088a());
                    return;
                }
                if (i2 != 3) {
                    return;
                }
                DialogC0275a.this.f6506a.setProgress(100);
                DialogC0275a.this.cancel();
                if (DialogC0275a.this.e != null) {
                    DialogC0275a.this.e.a();
                }
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j2) {
            return !DialogC0275a.this.isShowing() || super.sendMessageAtTime(message, j2);
        }
    }

    /* renamed from: k0.a$b */
    class b implements DialogInterface.OnShowListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            DialogC0275a.this.f6506a.setProgress(0);
        }
    }

    /* renamed from: k0.a$c */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DialogC0275a.this.f6509d.cancelUpload();
        }
    }

    /* renamed from: k0.a$d */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f6515a;

        d(File file) {
            this.f6515a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DialogC0275a.this.f6509d.uploadFile(this.f6515a)) {
                DialogC0275a.this.f6510f.sendMessageDelayed(DialogC0275a.this.f6510f.obtainMessage(2), 100L);
            } else {
                DialogC0275a.this.f6510f.sendMessage(DialogC0275a.this.f6510f.obtainMessage(1));
            }
        }
    }

    /* renamed from: k0.a$e */
    public interface e {
        void a();
    }

    public DialogC0275a(Context context, ExecutorService executorService) {
        super(context, R.style.UploadDialog);
        this.f6510f = new HandlerC0087a();
        this.f6508c = executorService;
        this.f6509d = EShareAPI.init(context).media();
    }

    public void f(Object... objArr) throws Throwable {
        k.a(objArr);
    }

    public void g(e eVar) {
        this.e = eVar;
    }

    public void h(File file) {
        show();
        this.f6508c.execute(new d(file));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.tv_document_cancel) {
            return;
        }
        this.f6510f.removeMessages(2);
        this.f6508c.execute(new c());
        cancel();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        setOnShowListener(new b());
        setContentView(R.layout.dialog_upload);
        this.f6506a = (ProgressCircle) findViewById(R.id.pc_upload);
        TextView textView = (TextView) findViewById(R.id.tv_document_cancel);
        this.f6507b = textView;
        textView.setOnClickListener(this);
    }
}
