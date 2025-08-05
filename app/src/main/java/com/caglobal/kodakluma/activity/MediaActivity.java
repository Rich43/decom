package com.caglobal.kodakluma.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.caglobal.kodakluma.CustomApplication;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.service.MediaService;
import com.eshare.api.EShareAPI;
import com.eshare.api.IDevice;
import g0.j;
import h0.C0262c;
import h0.l;
import h0.n;
import java.util.List;
import l0.C0278b;
import l0.InterfaceC0280d;
import n0.C0298c;
import q0.AbstractC0316e;
import s1.m;

/* loaded from: classes.dex */
public class MediaActivity extends com.caglobal.kodakluma.activity.a implements j0.e, C0298c.i, MediaService.e, j0.f {

    /* renamed from: U, reason: collision with root package name */
    private TextView f5077U;

    /* renamed from: V, reason: collision with root package name */
    private TextView f5078V;

    /* renamed from: W, reason: collision with root package name */
    private TextView f5079W;

    /* renamed from: X, reason: collision with root package name */
    private RecyclerView f5080X;

    /* renamed from: Y, reason: collision with root package name */
    private RecyclerView f5081Y;

    /* renamed from: Z, reason: collision with root package name */
    private TextView f5082Z;

    /* renamed from: a0, reason: collision with root package name */
    private ViewPager f5083a0;

    /* renamed from: b0, reason: collision with root package name */
    private j f5084b0;

    /* renamed from: c0, reason: collision with root package name */
    private g0.b f5085c0;

    /* renamed from: d0, reason: collision with root package name */
    private C0278b f5086d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f5087e0;

    /* renamed from: f0, reason: collision with root package name */
    private IDevice f5088f0;

    /* renamed from: g0, reason: collision with root package name */
    private MediaService f5089g0;

    /* renamed from: T, reason: collision with root package name */
    private final Handler f5076T = new a();

    /* renamed from: h0, reason: collision with root package name */
    private ServiceConnection f5090h0 = new b();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
        }
    }

    class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws Throwable {
            MediaActivity.this.v1("MediaActivity", "onServiceConnected");
            MediaActivity.this.f5089g0 = ((MediaService.f) iBinder).a();
            MediaActivity.this.f5089g0.n(MediaActivity.this);
            MediaActivity mediaActivity = MediaActivity.this;
            mediaActivity.h(mediaActivity.f5089g0.g());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) throws Throwable {
            MediaActivity.this.v1("MediaActivity", "onServiceDisconnected");
            MediaActivity.this.f5089g0 = null;
        }
    }

    class c extends androidx.viewpager.widget.a {
        c() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return 2;
        }

        @Override // androidx.viewpager.widget.a
        public Object g(ViewGroup viewGroup, int i2) {
            return viewGroup.getChildAt(i2);
        }

        @Override // androidx.viewpager.widget.a
        public boolean h(View view, Object obj) {
            return view == obj;
        }
    }

    class d extends ViewPager.l {
        d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void c(int i2) {
            MediaActivity.this.S1(i2 == 0);
        }
    }

    class e implements InterfaceC0280d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5095a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView.g f5096b;

        e(int i2, RecyclerView.g gVar) {
            this.f5095a = i2;
            this.f5096b = gVar;
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() throws Throwable {
            C0262c c0262cW;
            if (MediaActivity.this.f5089g0 != null) {
                MediaActivity.this.f5089g0.o(null, true);
                MediaActivity.this.f5089g0.l(this.f5095a);
            }
            if (this.f5096b == MediaActivity.this.f5084b0) {
                n nVarW = MediaActivity.this.f5084b0.w(this.f5095a);
                if (nVarW == null) {
                    return;
                }
                if (MediaActivity.this.f5089g0 != null) {
                    MediaActivity.this.f5089g0.s(MediaActivity.this.f5084b0.x());
                    MediaActivity.this.f5089g0.q(null);
                }
                Intent intent = new Intent(MediaActivity.this, (Class<?>) PlayerActivity.class);
                intent.putExtra("com.eshare.optoma.extra.MEDIA_IS_VIDEO", true);
                intent.putExtra("com.eshare.optoma.extra.MEDIA_PATH", nVarW.c());
                intent.putExtra("com.eshare.optoma.extra.MEDIA_TITLE", nVarW.d());
                MediaActivity.this.startActivity(intent);
                return;
            }
            if (this.f5096b != MediaActivity.this.f5085c0 || (c0262cW = MediaActivity.this.f5085c0.w(this.f5095a)) == null) {
                return;
            }
            if (MediaActivity.this.f5089g0 != null) {
                List listX = MediaActivity.this.f5085c0.x();
                MediaActivity.this.f5089g0.s(null);
                MediaActivity.this.f5089g0.q(listX);
            }
            Intent intent2 = new Intent(MediaActivity.this, (Class<?>) PlayerActivity.class);
            intent2.putExtra("com.eshare.optoma.extra.MEDIA_IS_VIDEO", false);
            intent2.putExtra("com.eshare.optoma.extra.MEDIA_PATH", c0262cW.c());
            intent2.putExtra("com.eshare.optoma.extra.MEDIA_TITLE", c0262cW.d());
            MediaActivity.this.startActivity(intent2);
        }
    }

    class f implements InterfaceC0280d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5098a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView.g f5099b;

        f(int i2, RecyclerView.g gVar) {
            this.f5098a = i2;
            this.f5099b = gVar;
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() throws Throwable {
            C0262c c0262cW;
            if (MediaActivity.this.f5089g0 != null) {
                MediaActivity.this.f5089g0.o(null, true);
                MediaActivity.this.f5089g0.l(this.f5098a);
            }
            if (this.f5099b == MediaActivity.this.f5084b0) {
                n nVarW = MediaActivity.this.f5084b0.w(this.f5098a);
                if (nVarW == null) {
                    return;
                }
                MediaActivity.this.A1(nVarW.a());
                return;
            }
            if (this.f5099b != MediaActivity.this.f5085c0 || (c0262cW = MediaActivity.this.f5085c0.w(this.f5098a)) == null) {
                return;
            }
            MediaActivity.this.A1(c0262cW.a());
        }
    }

    class g extends RecyclerView.t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f5101a;

        g(LinearLayoutManager linearLayoutManager) {
            this.f5101a = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i2, int i3) {
            int iU1 = this.f5101a.U1();
            if (iU1 != MediaActivity.this.f5087e0) {
                MediaActivity.this.f5087e0 = iU1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1(boolean z2) {
        this.f5077U.setSelected(z2);
        this.f5078V.setSelected(!z2);
        if (z2) {
            this.f5077U.setTextSize(getResources().getDimensionPixelSize(R.dimen.size_6sp));
            this.f5078V.setTextSize(getResources().getDimensionPixelSize(R.dimen.size_4sp));
        } else {
            this.f5078V.setTextSize(getResources().getDimensionPixelSize(R.dimen.size_6sp));
            this.f5077U.setTextSize(getResources().getDimensionPixelSize(R.dimen.size_4sp));
        }
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        this.f5077U = (TextView) findViewById(R.id.tv_media_video);
        this.f5078V = (TextView) findViewById(R.id.tv_media_audio);
        this.f5079W = (TextView) findViewById(R.id.tv_media_video_placeholder);
        this.f5080X = (RecyclerView) findViewById(R.id.rv_media_video_grid);
        this.f5081Y = (RecyclerView) findViewById(R.id.rv_media_audio);
        this.f5082Z = (TextView) findViewById(R.id.tv_media_playing);
        this.f5083a0 = (ViewPager) findViewById(R.id.vp_media);
        findViewById(R.id.iv_media_back).setOnClickListener(this);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_media;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f5086d0 = new C0278b();
        C0298c c0298cR = C0298c.r();
        c0298cR.E(this);
        c0298cR.A(this);
        this.f5088f0 = EShareAPI.init(this).device();
        bindService(new Intent(this, (Class<?>) MediaService.class), this.f5090h0, 1);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() throws Resources.NotFoundException {
        this.f5077U.setOnClickListener(this);
        this.f5078V.setOnClickListener(this);
        this.f5082Z.setOnClickListener(this);
        this.f5083a0.setAdapter(new c());
        this.f5083a0.b(new d());
        this.f5081Y.h(new com.caglobal.kodakluma.view.b(getResources().getDimensionPixelOffset(R.dimen.size_15dp)));
    }

    @Override // j0.f
    public void Q(RecyclerView.g gVar, int i2) {
        if (this.f5088f0.isDeviceConnect()) {
            I1(gVar == this.f5085c0 ? 2 : 3, new f(i2, gVar));
        } else {
            CustomApplication.f(R.string.device_not_connected);
        }
    }

    @Override // n0.C0298c.i
    public void W(List list) {
        if (this.f5077U.isSelected()) {
            if (list.size() > 1) {
                this.f5079W.setVisibility(8);
            } else {
                this.f5080X.setVisibility(8);
                this.f5079W.setVisibility(0);
            }
        }
        j jVar = new j(this, list);
        this.f5084b0 = jVar;
        jVar.C(this.f5086d0);
        this.f5084b0.A(this);
        this.f5084b0.B(this);
        this.f5080X.setLayoutManager(new GridLayoutManager(this, AbstractC0316e.a(this, 120.0f)));
        this.f5080X.setAdapter(this.f5084b0);
    }

    @m
    public void finishSelf(h0.g gVar) {
        if (gVar.a() == h0.g.f6395b) {
            finish();
        }
    }

    @Override // n0.C0298c.i
    public void g(List list, List list2) {
        if (this.f5078V.isSelected()) {
            if (list.size() > 1) {
                this.f5081Y.setVisibility(0);
                this.f5079W.setVisibility(8);
            } else {
                this.f5079W.setVisibility(0);
                this.f5081Y.setVisibility(8);
            }
        }
        g0.b bVar = new g0.b(this, list, list2);
        this.f5085c0 = bVar;
        bVar.A(this);
        this.f5085c0.B(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f5081Y.setLayoutManager(linearLayoutManager);
        this.f5081Y.setAdapter(this.f5085c0);
        this.f5081Y.l(new g(linearLayoutManager));
    }

    @Override // com.caglobal.kodakluma.service.MediaService.e
    public void h(l lVar) {
        if (lVar == null) {
            this.f5082Z.setVisibility(8);
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        l lVarG;
        int id = view.getId();
        if (id == R.id.iv_media_back) {
            finish();
            return;
        }
        switch (id) {
            case R.id.tv_media_audio /* 2131231352 */:
                this.f5083a0.setCurrentItem(1);
                break;
            case R.id.tv_media_playing /* 2131231353 */:
                MediaService mediaService = this.f5089g0;
                if (mediaService != null && (lVarG = mediaService.g()) != null) {
                    Intent intent = new Intent(this, (Class<?>) PlayerActivity.class);
                    intent.putExtra("com.eshare.optoma.extra.MEDIA_IS_VIDEO", lVarG instanceof n);
                    intent.putExtra("com.eshare.optoma.extra.MEDIA_PATH", lVarG.c());
                    intent.putExtra("com.eshare.optoma.extra.MEDIA_TITLE", lVarG.d());
                    intent.putExtra("com.eshare.optoma.extra.MEDIA_PLAYING", true);
                    startActivity(intent);
                    break;
                }
                break;
            case R.id.tv_media_video /* 2131231354 */:
                this.f5083a0.setCurrentItem(0);
                break;
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        S1(true);
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() throws Throwable {
        super.onDestroy();
        this.f5089g0.u();
        unbindService(this.f5090h0);
        this.f5086d0.c();
    }

    @Override // j0.e
    public void p(RecyclerView.g gVar, int i2) {
        if (this.f5088f0.isDeviceConnect()) {
            I1(gVar == this.f5085c0 ? 2 : 3, new e(i2, gVar));
        } else {
            CustomApplication.f(R.string.device_not_connected);
        }
    }
}
