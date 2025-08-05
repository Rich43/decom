package m0;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.activity.MainActivity;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: m0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0290d extends Fragment implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private RecyclerView f6607a;

    /* renamed from: b, reason: collision with root package name */
    private MainActivity f6608b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f6609c;

    /* renamed from: d, reason: collision with root package name */
    private e f6610d;
    private TextView e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f6611f;

    /* renamed from: g, reason: collision with root package name */
    Boolean f6612g = Boolean.FALSE;

    /* renamed from: h, reason: collision with root package name */
    public Handler f6613h = new a();

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f6614i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f6615j;

    /* renamed from: m0.d$a */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 != 101) {
                    return;
                }
                ViewOnClickListenerC0290d.this.s();
                return;
            }
            if (!ViewOnClickListenerC0290d.this.o() || ViewOnClickListenerC0290d.this.f6608b.f4934U.isEmpty()) {
                ViewOnClickListenerC0290d.this.f6607a.setVisibility(8);
                if (!ViewOnClickListenerC0290d.this.f6612g.booleanValue()) {
                    ViewOnClickListenerC0290d viewOnClickListenerC0290d = ViewOnClickListenerC0290d.this;
                    viewOnClickListenerC0290d.f6612g = Boolean.TRUE;
                    viewOnClickListenerC0290d.f6613h.sendEmptyMessageDelayed(101, 10000L);
                }
                ViewOnClickListenerC0290d.this.f6611f.setVisibility(0);
                ViewOnClickListenerC0290d.this.f6615j.setVisibility(0);
            } else {
                ViewOnClickListenerC0290d viewOnClickListenerC0290d2 = ViewOnClickListenerC0290d.this;
                viewOnClickListenerC0290d2.f6612g = Boolean.FALSE;
                viewOnClickListenerC0290d2.f6613h.removeMessages(101);
                ViewOnClickListenerC0290d.this.f6611f.setVisibility(8);
                ViewOnClickListenerC0290d.this.f6607a.setVisibility(0);
                ViewOnClickListenerC0290d.this.f6615j.setVisibility(8);
            }
            ViewOnClickListenerC0290d.this.f6613h.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    /* renamed from: m0.d$b */
    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AlertDialog f6617a;

        b(AlertDialog alertDialog) {
            this.f6617a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewOnClickListenerC0290d.this.f6610d != null) {
                ViewOnClickListenerC0290d.this.f6610d.B();
                this.f6617a.dismiss();
            }
        }
    }

    /* renamed from: m0.d$c */
    class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AlertDialog f6619a;

        c(AlertDialog alertDialog) {
            this.f6619a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewOnClickListenerC0290d.this.f6612g = Boolean.FALSE;
            this.f6619a.dismiss();
        }
    }

    /* renamed from: m0.d$e */
    public interface e {
        void B();

        void S();

        void X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f6615j, "rotation", 0.0f, 360.0f);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.addListener(new C0092d());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.start();
    }

    private void r(Dialog dialog) {
        Window window = dialog.getWindow();
        Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (defaultDisplay.getWidth() * 0.85d);
        window.setAttributes(attributes);
    }

    public boolean o() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f6608b = (MainActivity) getActivity();
        this.f6607a.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f6607a.setAdapter(this.f6608b.f4932T);
        this.f6609c.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f6613h.sendEmptyMessage(1);
        e eVar = this.f6610d;
        if (eVar != null) {
            eVar.X();
        }
        q();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f6610d = (e) getActivity();
        if (s1.c.c().j(this)) {
            return;
        }
        s1.c.c().p(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_luma_about_back) {
            e eVar = this.f6610d;
            if (eVar != null) {
                eVar.S();
                return;
            }
            return;
        }
        if (id != R.id.tv_find_scan) {
            return;
        }
        this.f6607a.setVisibility(8);
        this.f6611f.setVisibility(0);
        this.f6615j.setVisibility(0);
        this.f6613h.removeMessages(1);
        this.f6613h.sendEmptyMessageDelayed(1, 3000L);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.device_find_layout, viewGroup, false);
        this.f6607a = (RecyclerView) viewInflate.findViewById(R.id.rv_find_devices);
        this.f6609c = (ImageView) viewInflate.findViewById(R.id.iv_luma_about_back);
        this.e = (TextView) viewInflate.findViewById(R.id.tv_find_scan);
        this.f6614i = (RelativeLayout) viewInflate.findViewById(R.id.rl_devices_connect);
        this.f6611f = (TextView) viewInflate.findViewById(R.id.tv_find_tips);
        this.f6615j = (ImageView) viewInflate.findViewById(R.id.iv_loading);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f6613h.removeMessages(1);
        s1.c.c().r(this);
    }

    @s1.m(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(q0.m mVar) {
        if (mVar.f7217a.booleanValue()) {
            this.f6614i.setVisibility(0);
        } else {
            this.f6614i.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    public void s() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View viewInflate = View.inflate(getContext(), R.layout.dialog_device_empty, null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_empty_cancel);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_empty_ok);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
        r(alertDialogCreate);
        textView2.setOnClickListener(new b(alertDialogCreate));
        textView.setOnClickListener(new c(alertDialogCreate));
    }

    /* renamed from: m0.d$d, reason: collision with other inner class name */
    class C0092d implements Animator.AnimatorListener {
        C0092d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewOnClickListenerC0290d.this.q();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
