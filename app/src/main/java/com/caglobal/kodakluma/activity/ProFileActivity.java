package com.caglobal.kodakluma.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.caglobal.kodakluma.CustomApplication;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.model.NpaGridLayoutManager;
import com.caglobal.kodakluma.service.MediaService;
import com.eshare.api.EShareAPI;
import com.eshare.api.IDevice;
import com.eshare.api.IMedia;
import g0.j;
import h0.C0260a;
import h0.C0262c;
import h0.C0264e;
import h0.l;
import h0.m;
import h0.n;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k0.DialogC0275a;
import l0.C0278b;
import l0.InterfaceC0280d;
import n0.C0296a;
import n0.C0298c;
import p0.C0308c;
import q0.AbstractC0319h;

/* loaded from: classes.dex */
public class ProFileActivity extends com.caglobal.kodakluma.activity.a implements C0296a.d, j0.e, C0298c.i, MediaService.e, C0298c.f, C0298c.g, j0.f {

    /* renamed from: A0 */
    private TextView f5235A0;

    /* renamed from: B0 */
    private TextView f5236B0;

    /* renamed from: C0 */
    private C0298c f5237C0;

    /* renamed from: E0 */
    private ProgressBar f5239E0;

    /* renamed from: Y */
    private RecyclerView f5245Y;

    /* renamed from: Z */
    private RecyclerView f5246Z;

    /* renamed from: a0 */
    private RecyclerView f5247a0;

    /* renamed from: b0 */
    private RecyclerView f5248b0;

    /* renamed from: c0 */
    private RecyclerView f5249c0;

    /* renamed from: d0 */
    private C0296a f5250d0;

    /* renamed from: e0 */
    private g0.i f5251e0;

    /* renamed from: f0 */
    private IDevice f5252f0;

    /* renamed from: g0 */
    private ExecutorService f5253g0;

    /* renamed from: h0 */
    private TextView f5254h0;

    /* renamed from: i0 */
    private ProgressBar f5255i0;

    /* renamed from: l0 */
    private g0.b f5258l0;

    /* renamed from: m0 */
    private int f5259m0;

    /* renamed from: n0 */
    private C0278b f5260n0;

    /* renamed from: o0 */
    private MediaService f5261o0;

    /* renamed from: p0 */
    private int f5262p0;

    /* renamed from: q0 */
    private RecyclerView f5263q0;

    /* renamed from: r0 */
    private j f5264r0;

    /* renamed from: s0 */
    private TextView f5265s0;

    /* renamed from: t0 */
    private TextView f5266t0;

    /* renamed from: u0 */
    private IMedia f5267u0;

    /* renamed from: v0 */
    private g0.g f5268v0;

    /* renamed from: w0 */
    private List f5269w0;

    /* renamed from: x0 */
    private g0.h f5270x0;

    /* renamed from: y0 */
    private DialogC0275a f5271y0;

    /* renamed from: z0 */
    private g0.d f5272z0;

    /* renamed from: T */
    private final int f5240T = 1;

    /* renamed from: U */
    private final int f5241U = 2;

    /* renamed from: V */
    private final int f5242V = 3;

    /* renamed from: W */
    private final int f5243W = 4;

    /* renamed from: X */
    private final int f5244X = 5;

    /* renamed from: j0 */
    private boolean f5256j0 = false;

    /* renamed from: k0 */
    private boolean f5257k0 = false;

    /* renamed from: D0 */
    private ServiceConnection f5238D0 = new c();

    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return AbstractC0319h.g(file);
        }
    }

    class b implements FileFilter {
        b() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return AbstractC0319h.g(file);
        }
    }

    class c implements ServiceConnection {
        c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ProFileActivity.this.f5261o0 = ((MediaService.f) iBinder).a();
            ProFileActivity.this.f5261o0.n(ProFileActivity.this);
            ProFileActivity proFileActivity = ProFileActivity.this;
            proFileActivity.h(proFileActivity.f5261o0.g());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ProFileActivity.this.f5261o0 = null;
        }
    }

    class d implements DialogC0275a.e {
        d() {
        }

        @Override // k0.DialogC0275a.e
        public void a() {
            ProFileActivity.this.finish();
        }
    }

    class e implements InterfaceC0280d {

        /* renamed from: a */
        final /* synthetic */ int f5277a;

        /* renamed from: b */
        final /* synthetic */ RecyclerView.g f5278b;

        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ n f5280a;

            a(n nVar) {
                this.f5280a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ProFileActivity.this.f5267u0.openFile(this.f5280a.a())) {
                    ProFileActivity.this.finish();
                }
            }
        }

        class b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0262c f5282a;

            b(C0262c c0262c) {
                this.f5282a = c0262c;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ProFileActivity.this.f5267u0.openFile(this.f5282a.a())) {
                    ProFileActivity.this.finish();
                }
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ProFileActivity.this.f5252f0.startApp(ProFileActivity.this.f5251e0.x(e.this.f5277a).c());
            }
        }

        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.clear();
                for (m mVar : ProFileActivity.this.f5269w0) {
                    if (!arrayList2.contains(mVar.a())) {
                        arrayList2.add(mVar.a());
                    }
                }
                String parent = ((File) arrayList2.get(0)).getParent();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((File) it.next()).getName());
                }
                ProFileActivity.this.f5267u0.openImagesFromFolder(parent, arrayList, e.this.f5277a);
                ProFileActivity.this.finish();
            }
        }

        e(int i2, RecyclerView.g gVar) {
            this.f5277a = i2;
            this.f5278b = gVar;
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() throws Throwable {
            C0264e c0264eY;
            if (ProFileActivity.this.f5261o0 != null) {
                ProFileActivity.this.f5261o0.o(null, true);
                ProFileActivity.this.f5261o0.l(this.f5277a);
            }
            if (this.f5278b == ProFileActivity.this.f5264r0) {
                n nVarW = ProFileActivity.this.f5264r0.w(this.f5277a);
                if (nVarW == null || ProFileActivity.this.f5261o0 == null) {
                    return;
                }
                ProFileActivity.this.f5264r0.x();
                ProFileActivity.this.f5253g0.execute(new a(nVarW));
                return;
            }
            if (this.f5278b == ProFileActivity.this.f5258l0) {
                C0262c c0262cW = ProFileActivity.this.f5258l0.w(this.f5277a);
                if (c0262cW == null || ProFileActivity.this.f5261o0 == null) {
                    return;
                }
                ProFileActivity.this.f5258l0.x();
                ProFileActivity.this.f5253g0.execute(new b(c0262cW));
                return;
            }
            if (this.f5278b == ProFileActivity.this.f5251e0) {
                ProFileActivity.this.f5253g0.execute(new c());
                return;
            }
            if (this.f5278b == ProFileActivity.this.f5270x0) {
                if (ProFileActivity.this.f5270x0.w(this.f5277a) == null) {
                    return;
                }
                ProFileActivity.this.f5253g0.execute(new d());
            } else if (this.f5278b == ProFileActivity.this.f5272z0 && (c0264eY = ProFileActivity.this.f5272z0.y(this.f5277a)) != null && ProFileActivity.this.f5267u0.openFile(c0264eY.a())) {
                ProFileActivity.this.finish();
            }
        }
    }

    class f implements InterfaceC0280d {

        /* renamed from: a */
        final /* synthetic */ int f5286a;

        /* renamed from: b */
        final /* synthetic */ RecyclerView.g f5287b;

        f(int i2, RecyclerView.g gVar) {
            this.f5286a = i2;
            this.f5287b = gVar;
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() throws Throwable {
            C0264e c0264eY;
            if (ProFileActivity.this.f5261o0 != null) {
                ProFileActivity.this.f5261o0.o(null, true);
                ProFileActivity.this.f5261o0.l(this.f5286a);
            }
            if (this.f5287b == ProFileActivity.this.f5264r0) {
                n nVarW = ProFileActivity.this.f5264r0.w(this.f5286a);
                if (nVarW == null) {
                    return;
                }
                ProFileActivity.this.A1(nVarW.a());
                return;
            }
            if (this.f5287b == ProFileActivity.this.f5258l0) {
                C0262c c0262cW = ProFileActivity.this.f5258l0.w(this.f5286a);
                if (c0262cW == null) {
                    return;
                }
                ProFileActivity.this.A1(c0262cW.a());
                return;
            }
            if (this.f5287b == ProFileActivity.this.f5270x0) {
                m mVarW = ProFileActivity.this.f5270x0.w(this.f5286a);
                if (mVarW == null) {
                    return;
                }
                ProFileActivity.this.A1(mVarW.a());
                return;
            }
            if (this.f5287b != ProFileActivity.this.f5272z0 || (c0264eY = ProFileActivity.this.f5272z0.y(this.f5286a)) == null) {
                return;
            }
            ProFileActivity.this.A1(c0264eY.a());
        }
    }

    class g extends GridLayoutManager.c {

        /* renamed from: c */
        final /* synthetic */ NpaGridLayoutManager f5289c;

        g(NpaGridLayoutManager npaGridLayoutManager) {
            this.f5289c = npaGridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i2) {
            if (ProFileActivity.this.f5264r0.e(i2) == 1) {
                return this.f5289c.Q2();
            }
            return 1;
        }
    }

    class h extends RecyclerView.t {

        /* renamed from: a */
        final /* synthetic */ NpaGridLayoutManager f5291a;

        h(NpaGridLayoutManager npaGridLayoutManager) {
            this.f5291a = npaGridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i2, int i3) {
            int iU1 = this.f5291a.U1();
            if (iU1 != ProFileActivity.this.f5259m0) {
                ProFileActivity.this.f5259m0 = iU1;
            }
        }
    }

    class i implements j0.e {

        /* renamed from: a */
        final /* synthetic */ List f5293a;

        i(List list) {
            this.f5293a = list;
        }

        @Override // j0.e
        public void p(RecyclerView.g gVar, int i2) {
            ProFileActivity.this.d2(false);
            ProFileActivity.this.c2((C0260a) this.f5293a.get(i2));
        }
    }

    private void a2(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0260a c0260a = (C0260a) it.next();
            File[] fileArrListFiles = c0260a.a().listFiles(new a());
            if (fileArrListFiles != null) {
                c0260a.k(fileArrListFiles.length);
            }
        }
    }

    private void b2(List list) {
        String str = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            m mVar = (m) list.get(i2);
            String strG = mVar.g();
            if (strG.equals(str)) {
                m mVar2 = (m) list.get(i2 - 1);
                mVar2.l(false);
                mVar.k(mVar2.h() + 1);
            } else {
                mVar.j(true);
                mVar.k(1);
                str = strG;
            }
        }
    }

    public void c2(C0260a c0260a) {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = c0260a.a().listFiles(new b());
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file : fileArrListFiles) {
                m mVar = new m(file);
                mVar.i(this);
                arrayList.add(mVar);
            }
        }
        Collections.sort(arrayList, new C0308c());
        b2(arrayList);
        this.f5269w0.clear();
        this.f5269w0.addAll(arrayList);
        this.f5270x0.g();
        this.f5268v0.g();
    }

    public void d2(boolean z2) {
        if (z2) {
            this.f5248b0.setVisibility(0);
            this.f5263q0.setVisibility(8);
        } else {
            this.f5248b0.setVisibility(8);
            this.f5263q0.setVisibility(0);
        }
    }

    private void e2() {
        if (!this.f5256j0) {
            this.f5255i0.setVisibility(0);
        }
        this.f5250d0.i(this);
    }

    private void f2() {
        this.f5249c0.setVisibility(8);
        this.f5263q0.setVisibility(8);
        this.f5246Z.setVisibility(8);
        this.f5245Y.setVisibility(8);
        this.f5247a0.setVisibility(8);
        this.f5248b0.setVisibility(8);
        this.f5254h0.setAlpha(0.6f);
        this.f5266t0.setAlpha(0.6f);
        this.f5265s0.setAlpha(0.6f);
        this.f5235A0.setAlpha(0.6f);
        this.f5236B0.setAlpha(0.6f);
        this.f5254h0.setTextSize(getResources().getDimension(R.dimen.size_16px));
        this.f5236B0.setTextSize(getResources().getDimension(R.dimen.size_16px));
        this.f5266t0.setTextSize(getResources().getDimension(R.dimen.size_16px));
        this.f5265s0.setTextSize(getResources().getDimension(R.dimen.size_16px));
        this.f5235A0.setTextSize(getResources().getDimension(R.dimen.size_16px));
        if (this.f5262p0 == 2) {
            this.f5265s0.setAlpha(1.0f);
            this.f5265s0.setTextSize(getResources().getDimension(R.dimen.size_20px));
            this.f5246Z.setVisibility(0);
        }
        if (this.f5262p0 == 3) {
            this.f5266t0.setAlpha(1.0f);
            this.f5266t0.setTextSize(getResources().getDimension(R.dimen.size_20px));
            this.f5247a0.setVisibility(0);
        }
        if (this.f5262p0 == 5) {
            this.f5254h0.setAlpha(1.0f);
            this.f5254h0.setTextSize(getResources().getDimension(R.dimen.size_20px));
            this.f5245Y.setVisibility(0);
        }
        if (this.f5262p0 == 1) {
            this.f5235A0.setAlpha(1.0f);
            this.f5235A0.setTextSize(getResources().getDimension(R.dimen.size_20px));
            d2(true);
        }
        if (this.f5262p0 == 4) {
            this.f5236B0.setAlpha(1.0f);
            this.f5236B0.setTextSize(getResources().getDimension(R.dimen.size_20px));
            this.f5249c0.setVisibility(0);
        }
        if (this.f5262p0 != 5 && this.f5255i0.getVisibility() == 0) {
            this.f5255i0.setVisibility(8);
        }
        if (this.f5262p0 != 4) {
            this.f5239E0.setVisibility(8);
        }
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        this.f5248b0 = (RecyclerView) findViewById(R.id.rv_photo_album);
        this.f5263q0 = (RecyclerView) findViewById(R.id.rv_photo_grid);
        this.f5245Y = (RecyclerView) findViewById(R.id.rv_program_apk);
        TextView textView = (TextView) findViewById(R.id.tv_file_apk);
        this.f5254h0 = textView;
        textView.setOnClickListener(this);
        this.f5255i0 = (ProgressBar) findViewById(R.id.pb_tools_loading);
        this.f5246Z = (RecyclerView) findViewById(R.id.rv_media_audio);
        this.f5247a0 = (RecyclerView) findViewById(R.id.rv_media_video_grid);
        TextView textView2 = (TextView) findViewById(R.id.tv_file_audio);
        this.f5265s0 = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) findViewById(R.id.tv_file_video);
        this.f5266t0 = textView3;
        textView3.setOnClickListener(this);
        TextView textView4 = (TextView) findViewById(R.id.tv_file_photo);
        this.f5235A0 = textView4;
        textView4.setOnClickListener(this);
        this.f5249c0 = (RecyclerView) findViewById(R.id.rv_documents);
        TextView textView5 = (TextView) findViewById(R.id.tv_file_document);
        this.f5236B0 = textView5;
        textView5.setOnClickListener(this);
        this.f5239E0 = (ProgressBar) findViewById(R.id.pb_doc_loading);
        onClick(this.f5235A0);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_pro_file;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f5260n0 = new C0278b();
        C0298c c0298cR = C0298c.r();
        this.f5237C0 = c0298cR;
        c0298cR.D(this);
        this.f5237C0.C(this);
        this.f5237C0.v(this);
        this.f5237C0.E(this);
        bindService(new Intent(this, (Class<?>) MediaService.class), this.f5238D0, 1);
        q0.n.c(getWindow());
        this.f5252f0 = EShareAPI.init(this).device();
        this.f5267u0 = EShareAPI.init(this).media();
        this.f5253g0 = Executors.newSingleThreadExecutor();
        C0296a c0296aH = C0296a.h();
        this.f5250d0 = c0296aH;
        c0296aH.l(this);
        ArrayList arrayList = new ArrayList();
        this.f5269w0 = arrayList;
        g0.h hVar = new g0.h(this, arrayList);
        this.f5270x0 = hVar;
        hVar.z(this);
        this.f5270x0.A(this);
        DialogC0275a dialogC0275a = new DialogC0275a(this, this.f5253g0);
        this.f5271y0 = dialogC0275a;
        dialogC0275a.g(new d());
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() throws Resources.NotFoundException {
        this.f5248b0.h(new com.caglobal.kodakluma.view.b(getResources().getDimensionPixelOffset(R.dimen.size_1dp)));
        this.f5263q0.setLayoutManager(new NpaGridLayoutManager(this, 3));
        this.f5263q0.setAdapter(this.f5270x0);
    }

    @Override // n0.C0296a.d
    public void F(boolean z2, List list) {
        if (!z2) {
            CustomApplication.f(R.string.program_list_failed);
            return;
        }
        this.f5256j0 = true;
        if (this.f5255i0.getVisibility() == 0) {
            this.f5255i0.setVisibility(8);
        }
        g0.i iVar = new g0.i(this, list, false);
        this.f5251e0 = iVar;
        iVar.A(this);
        this.f5251e0.B(this);
        this.f5245Y.setLayoutManager(new GridLayoutManager(this, 3));
        this.f5245Y.setAdapter(this.f5251e0);
    }

    @Override // j0.f
    public void Q(RecyclerView.g gVar, int i2) {
        if (this.f5252f0.isDeviceConnect()) {
            I1(gVar == this.f5258l0 ? 2 : 3, new f(i2, gVar));
        } else {
            CustomApplication.f(R.string.device_not_connected);
        }
    }

    @Override // n0.C0298c.i
    public void W(List list) {
        j jVar = new j(this, list);
        this.f5264r0 = jVar;
        jVar.C(this.f5260n0);
        this.f5264r0.A(this);
        this.f5264r0.B(this);
        NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(this, 3);
        npaGridLayoutManager.Y2(new g(npaGridLayoutManager));
        this.f5247a0.setLayoutManager(npaGridLayoutManager);
        this.f5247a0.setAdapter(this.f5264r0);
        this.f5264r0.g();
    }

    @s1.m
    public void finishSelf(h0.g gVar) {
        if (gVar.a() != h0.g.f6396c) {
            finish();
        }
    }

    @Override // n0.C0298c.i
    public void g(List list, List list2) {
        g0.b bVar = new g0.b(this, list, list2);
        this.f5258l0 = bVar;
        bVar.A(this);
        this.f5258l0.B(this);
        NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(this, 1);
        this.f5246Z.setLayoutManager(npaGridLayoutManager);
        this.f5246Z.setAdapter(this.f5258l0);
        this.f5258l0.g();
        this.f5246Z.l(new h(npaGridLayoutManager));
    }

    @Override // n0.C0298c.f
    public void o(List list) {
        g0.g gVar = new g0.g(this, list);
        this.f5268v0 = gVar;
        this.f5248b0.setAdapter(gVar);
        this.f5248b0.setLayoutManager(new GridLayoutManager(this, 2));
        a2(list);
        Iterator it = list.iterator();
        while (it.hasNext() && !((C0260a) it.next()).i()) {
        }
        this.f5268v0.y(new i(list));
        this.f5268v0.z(this);
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_file_apk /* 2131231313 */:
                if (this.f5262p0 != 5) {
                    this.f5262p0 = 5;
                    e2();
                    break;
                }
                break;
            case R.id.tv_file_audio /* 2131231314 */:
                if (this.f5262p0 != 2) {
                    this.f5237C0.p(this);
                    this.f5262p0 = 2;
                    break;
                }
                break;
            case R.id.tv_file_document /* 2131231315 */:
                if (this.f5262p0 != 4) {
                    this.f5237C0.z(this);
                    this.f5262p0 = 4;
                    if (!this.f5257k0) {
                        this.f5239E0.setVisibility(0);
                        break;
                    }
                }
                break;
            case R.id.tv_file_photo /* 2131231316 */:
                this.f5262p0 = 1;
                break;
            case R.id.tv_file_video /* 2131231317 */:
                if (this.f5262p0 != 3) {
                    this.f5237C0.u(this);
                    this.f5262p0 = 3;
                    break;
                }
                break;
        }
        f2();
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() throws Throwable {
        super.onDestroy();
        this.f5261o0.u();
        unbindService(this.f5238D0);
        this.f5260n0.c();
        this.f5253g0.shutdown();
    }

    @Override // j0.e
    public void p(RecyclerView.g gVar, int i2) {
        if (this.f5252f0.isDeviceConnect()) {
            I1(gVar == this.f5258l0 ? 2 : gVar == this.f5264r0 ? 3 : 1, new e(i2, gVar));
        } else {
            CustomApplication.f(R.string.device_not_connected);
        }
    }

    @Override // n0.C0298c.g
    public void x(List list) {
        this.f5257k0 = true;
        if (this.f5239E0.getVisibility() == 0) {
            this.f5239E0.setVisibility(8);
        }
        this.f5272z0 = new g0.d(this, list);
        this.f5249c0.setLayoutManager(new NpaGridLayoutManager(this, 1));
        this.f5249c0.setAdapter(this.f5272z0);
        this.f5272z0.B(this);
        this.f5272z0.C(this);
    }

    @Override // com.caglobal.kodakluma.service.MediaService.e
    public void h(l lVar) {
    }
}
