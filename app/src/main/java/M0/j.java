package m0;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.fragment.app.Fragment;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.activity.KeyboardActivity;
import com.caglobal.kodakluma.view.FadingTextView;
import com.caglobal.kodakluma.view.KeysButton;
import com.eshare.api.EShareAPI;
import com.eshare.api.IDevice;
import com.eshare.api.IEvent;
import com.eshare.api.IMedia;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class j extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public static int s = 10;

    /* renamed from: a, reason: collision with root package name */
    private ImageView f6651a;

    /* renamed from: b, reason: collision with root package name */
    private IEvent f6652b;

    /* renamed from: c, reason: collision with root package name */
    private KeysButton f6653c;

    /* renamed from: d, reason: collision with root package name */
    private ExecutorService f6654d;
    private ImageView e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f6655f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f6656g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f6657h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f6658i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f6659j;

    /* renamed from: k, reason: collision with root package name */
    private IDevice f6660k;

    /* renamed from: l, reason: collision with root package name */
    private h f6661l;

    /* renamed from: m, reason: collision with root package name */
    private SeekBar f6662m;

    /* renamed from: n, reason: collision with root package name */
    private FadingTextView f6663n;
    private IMedia o;

    /* renamed from: q, reason: collision with root package name */
    private IDevice f6665q;

    /* renamed from: p, reason: collision with root package name */
    public Handler f6664p = new a();
    private View.OnKeyListener r = new g();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                j.this.q(19);
                j.this.f6664p.sendEmptyMessageDelayed(1, 1000L);
            } else if (i2 == 2) {
                j.this.q(20);
                j.this.f6664p.sendEmptyMessageDelayed(2, 1000L);
            } else if (i2 == 3) {
                j.this.q(21);
                j.this.f6664p.sendEmptyMessageDelayed(3, 1000L);
            } else if (i2 == 4) {
                j.this.q(22);
                j.this.f6664p.sendEmptyMessageDelayed(4, 1000L);
            }
            super.handleMessage(message);
        }
    }

    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            j jVar = j.this;
            jVar.r(motionEvent, jVar.f6651a.getMeasuredWidth(), j.this.f6651a.getMeasuredHeight());
            return false;
        }
    }

    class c implements KeysButton.a {
        c() {
        }

        @Override // com.caglobal.kodakluma.view.KeysButton.a
        public void a(int i2) {
            if (i2 == 0) {
                j.this.f6664p.removeMessages(4);
                j.this.f6664p.removeMessages(3);
                j.this.f6664p.removeMessages(1);
                j.this.f6664p.removeMessages(2);
                return;
            }
            if (i2 == 1) {
                j.this.f6664p.removeMessages(1);
                return;
            }
            if (i2 == 2) {
                j.this.f6664p.removeMessages(2);
                return;
            }
            if (i2 == 3) {
                j.this.f6664p.removeMessages(3);
            } else if (i2 == 4) {
                j.this.f6664p.removeMessages(4);
            } else {
                if (i2 != 5) {
                    return;
                }
                j.this.q(66);
            }
        }

        @Override // com.caglobal.kodakluma.view.KeysButton.a
        public void b(int i2) {
            if (i2 == 1) {
                j.this.f6664p.sendEmptyMessage(1);
                return;
            }
            if (i2 == 2) {
                j.this.f6664p.sendEmptyMessage(2);
            } else if (i2 == 3) {
                j.this.f6664p.sendEmptyMessage(3);
            } else {
                if (i2 != 4) {
                    return;
                }
                j.this.f6664p.sendEmptyMessage(4);
            }
        }
    }

    class d implements FadingTextView.b {
        d() {
        }

        @Override // com.caglobal.kodakluma.view.FadingTextView.b
        public boolean a(int i2, KeyEvent keyEvent) {
            keyEvent.getAction();
            return false;
        }

        @Override // com.caglobal.kodakluma.view.FadingTextView.b
        public boolean b(CharSequence charSequence) {
            j.this.o(1, 0, charSequence.toString());
            return false;
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6670a;

        e(int i2) {
            this.f6670a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f6652b.sendKeyEvent(this.f6670a);
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6672a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f6673b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f6674c;

        f(int i2, int i3, String str) {
            this.f6672a = i2;
            this.f6673b = i3;
            this.f6674c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f6652b.sendInputText(this.f6672a, this.f6673b, this.f6674c);
        }
    }

    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            if (j.this.f6661l == null) {
                return true;
            }
            j.this.f6661l.J();
            return true;
        }
    }

    public interface h {
        void J();

        void Y();

        void i();

        void v();
    }

    private void m() {
        this.f6651a.setOnTouchListener(new b());
        this.f6653c.setButtonClickListener(new c());
        this.f6663n.setInterceptor(new d());
    }

    private void n() {
        this.f6660k = EShareAPI.init(getActivity()).device();
        this.f6663n.setOnKeyListener(this.r);
        this.e.setOnClickListener(this);
        this.f6656g.setOnClickListener(this);
        this.f6655f.setOnClickListener(this);
        this.f6658i.setOnClickListener(this);
        this.f6657h.setOnClickListener(this);
        this.f6659j.setOnClickListener(this);
        this.o = EShareAPI.init(getContext()).media();
        this.f6665q = EShareAPI.init(getContext()).device();
        this.f6654d = Executors.newSingleThreadExecutor();
        this.f6652b = EShareAPI.init(getContext()).event();
        if (this.f6665q.isDeviceConnect()) {
            int volume = this.o.getVolume();
            if (volume >= 0) {
                this.f6662m.setProgress(volume);
            }
        } else {
            this.f6662m.setProgress(s);
        }
        this.f6662m.setOnSeekBarChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i2, int i3, String str) {
        this.f6654d.execute(new f(i2, i3, str));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        n();
        m();
        h hVar = this.f6661l;
        if (hVar != null) {
            hVar.i();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f6661l = (h) getActivity();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_remote_back /* 2131231019 */:
                q(4);
                break;
            case R.id.iv_remote_connect /* 2131231020 */:
                h hVar = this.f6661l;
                if (hVar != null) {
                    hVar.v();
                    break;
                }
                break;
            case R.id.iv_remote_home /* 2131231021 */:
                q(3);
                break;
            case R.id.iv_remote_keyboard /* 2131231022 */:
                t(KeyboardActivity.class);
                break;
            case R.id.iv_remote_menu /* 2131231023 */:
                q(82);
                break;
            case R.id.iv_remote_power /* 2131231025 */:
                if (this.f6661l != null && this.f6660k.isDeviceConnect()) {
                    this.f6661l.Y();
                    break;
                }
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.remote_layout, viewGroup, false);
        this.f6651a = (ImageView) viewInflate.findViewById(R.id.iv_remote_mouse);
        this.f6653c = (KeysButton) viewInflate.findViewById(R.id.kb_control_keys);
        this.e = (ImageView) viewInflate.findViewById(R.id.iv_remote_back);
        this.f6655f = (ImageView) viewInflate.findViewById(R.id.iv_remote_power);
        this.f6656g = (ImageView) viewInflate.findViewById(R.id.iv_remote_home);
        this.f6657h = (ImageView) viewInflate.findViewById(R.id.iv_remote_menu);
        this.f6658i = (ImageView) viewInflate.findViewById(R.id.iv_remote_keyboard);
        this.f6659j = (ImageView) viewInflate.findViewById(R.id.iv_remote_connect);
        this.f6662m = (SeekBar) viewInflate.findViewById(R.id.sb_remout_volume);
        FadingTextView fadingTextView = (FadingTextView) viewInflate.findViewById(R.id.text_feedback_chars);
        this.f6663n = fadingTextView;
        fadingTextView.requestFocus();
        return viewInflate;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        if (s == 0) {
            s(1);
        }
        int progress = seekBar.getProgress();
        s = progress;
        s(progress);
    }

    public void q(int i2) {
        this.f6654d.execute(new e(i2));
    }

    public void r(MotionEvent motionEvent, int i2, int i3) {
        this.f6652b.sendMouseEvent(motionEvent, i2, i3, 1.5f);
    }

    public void s(int i2) {
        this.o.setVolume(i2);
    }

    public void t(Class cls) {
        Intent intent = new Intent(getContext(), (Class<?>) cls);
        intent.addFlags(67108864);
        startActivity(intent);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
