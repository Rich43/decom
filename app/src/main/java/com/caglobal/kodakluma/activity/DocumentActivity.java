package com.caglobal.kodakluma.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.caglobal.kodakluma.CustomApplication;
import com.caglobal.kodakluma.R;
import com.eshare.api.EShareAPI;
import com.eshare.api.IDevice;
import com.eshare.api.IMedia;
import h0.C0264e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k0.DialogC0275a;
import l0.AsyncTaskC0277a;
import l0.InterfaceC0280d;
import n0.C0298c;
import q0.C0315d;
import s1.m;

/* loaded from: classes.dex */
public class DocumentActivity extends com.caglobal.kodakluma.activity.a implements j0.e, C0298c.g, j0.f {

    /* renamed from: T, reason: collision with root package name */
    private RecyclerView f4830T;

    /* renamed from: U, reason: collision with root package name */
    private SwipeRefreshLayout f4831U;

    /* renamed from: V, reason: collision with root package name */
    private g0.d f4832V;

    /* renamed from: W, reason: collision with root package name */
    private IDevice f4833W;

    /* renamed from: X, reason: collision with root package name */
    private IMedia f4834X;

    /* renamed from: Y, reason: collision with root package name */
    private ExecutorService f4835Y;

    /* renamed from: Z, reason: collision with root package name */
    private ProgressDialog f4836Z;

    /* renamed from: a0, reason: collision with root package name */
    private DialogC0275a f4837a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f4838b0;

    /* renamed from: c0, reason: collision with root package name */
    private ArrayList f4839c0 = new ArrayList();

    /* renamed from: d0, reason: collision with root package name */
    private ArrayList f4840d0 = new ArrayList();

    /* renamed from: e0, reason: collision with root package name */
    private TextView f4841e0;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f4842f0;

    /* renamed from: g0, reason: collision with root package name */
    private AsyncTaskC0277a f4843g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f4844h0;

    class a implements DialogC0275a.e {
        a() {
        }

        @Override // k0.DialogC0275a.e
        public void a() {
            DocumentActivity.this.startActivity(new Intent(DocumentActivity.this, (Class<?>) RemoteControlActivity.class));
        }
    }

    class b implements SwipeRefreshLayout.j {
        b() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
        public void a() {
            DocumentActivity documentActivity = DocumentActivity.this;
            documentActivity.V1(documentActivity.f4838b0);
        }
    }

    class c implements InterfaceC0280d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C0264e f4847a;

        c(C0264e c0264e) {
            this.f4847a = c0264e;
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() {
            if (DocumentActivity.this.f4834X.openFile(this.f4847a.a())) {
                DocumentActivity.this.startActivity(new Intent(DocumentActivity.this, (Class<?>) RemoteControlActivity.class));
            }
        }
    }

    class d implements InterfaceC0280d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C0264e f4849a;

        d(C0264e c0264e) {
            this.f4849a = c0264e;
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() {
            DocumentActivity.this.A1(this.f4849a.a());
        }
    }

    class e implements j0.d {
        e() {
        }

        @Override // j0.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ArrayList arrayList) {
            if (arrayList != null) {
                DocumentActivity.this.f4831U.setRefreshing(false);
                DocumentActivity.this.f4839c0.addAll(arrayList);
                DocumentActivity.this.f4832V.x();
                DocumentActivity.this.f4832V.w(arrayList);
                DocumentActivity.this.f4830T.i1(DocumentActivity.this.f4844h0);
                DocumentActivity.this.W1();
            }
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4852a;

        f(String str) {
            this.f4852a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = DocumentActivity.this.f4842f0;
            String str = this.f4852a;
            textView.setText(str.substring(str.lastIndexOf("/") + 1));
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DocumentActivity.this.f4842f0.setText(R.string.document_title);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V1(String str) {
        this.f4831U.setRefreshing(true);
        AsyncTaskC0277a asyncTaskC0277a = this.f4843g0;
        if (asyncTaskC0277a != null && asyncTaskC0277a.getStatus() == AsyncTask.Status.RUNNING) {
            this.f4843g0.cancel(true);
        }
        this.f4838b0 = str;
        X1(str);
        AsyncTaskC0277a asyncTaskC0277a2 = new AsyncTaskC0277a(str, new e());
        this.f4843g0 = asyncTaskC0277a2;
        asyncTaskC0277a2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1() {
        if (this.f4839c0.size() != 0) {
            this.f4831U.setVisibility(0);
            this.f4830T.setVisibility(0);
            this.f4841e0.setVisibility(8);
        } else {
            this.f4831U.setRefreshing(false);
            this.f4841e0.setVisibility(0);
            this.f4831U.setVisibility(4);
            this.f4830T.setVisibility(8);
        }
    }

    private void X1(String str) {
        if (this.f4840d0.size() >= 2) {
            this.f4842f0.post(new f(str));
        } else {
            this.f4842f0.post(new g());
        }
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() throws Resources.NotFoundException {
        this.f4830T = (RecyclerView) findViewById(R.id.rv_document);
        this.f4830T.h(new com.caglobal.kodakluma.view.b(getResources().getDimensionPixelOffset(R.dimen.size_15dp)));
        this.f4831U = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        this.f4841e0 = (TextView) findViewById(R.id.tv_doc_empty);
        this.f4842f0 = (TextView) findViewById(R.id.tv_doc_title);
        findViewById(R.id.iv_document_back).setOnClickListener(this);
        findViewById(R.id.tv_enable_http_server).setOnClickListener(this);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_document;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        C0298c.r().D(this);
        this.f4836Z = C0315d.b(this);
        this.f4835Y = Executors.newSingleThreadExecutor();
        this.f4833W = EShareAPI.init(this).device();
        this.f4834X = EShareAPI.init(this).media();
        DialogC0275a dialogC0275a = new DialogC0275a(this, this.f4835Y);
        this.f4837a0 = dialogC0275a;
        dialogC0275a.g(new a());
        C0264e c0264e = new C0264e(Environment.getExternalStorageDirectory());
        this.f4838b0 = c0264e.c();
        this.f4839c0.add(c0264e);
        this.f4840d0.add(this.f4838b0);
        g0.d dVar = new g0.d(this, this.f4839c0);
        this.f4832V = dVar;
        dVar.B(this);
        this.f4832V.C(this);
        this.f4830T.setLayoutManager(new LinearLayoutManager(this));
        this.f4830T.setAdapter(this.f4832V);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
        this.f4831U.setOnRefreshListener(new b());
    }

    @Override // j0.f
    public void Q(RecyclerView.g gVar, int i2) {
        C0264e c0264eY;
        if (!this.f4833W.isDeviceConnect()) {
            CustomApplication.f(R.string.device_not_connected);
            return;
        }
        g0.d dVar = this.f4832V;
        if (gVar != dVar || (c0264eY = dVar.y(i2)) == null) {
            return;
        }
        if (!c0264eY.a().isDirectory()) {
            I1(0, new d(c0264eY));
            return;
        }
        if (!c0264eY.a().canRead()) {
            CustomApplication.f(R.string.document_access_denied);
            return;
        }
        this.f4844h0 = i2;
        this.f4840d0.add(c0264eY.c());
        this.f4839c0.clear();
        V1(c0264eY.c());
        this.f4832V.g();
    }

    @m
    public void finishSelf(h0.g gVar) {
        if (gVar.a() != h0.g.f6397d) {
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f4840d0.size() == 1) {
            finish();
        }
        if (this.f4840d0.size() == 0) {
            finish();
            return;
        }
        if (this.f4840d0.size() > 2) {
            this.f4839c0.clear();
            ArrayList arrayList = this.f4840d0;
            V1((String) arrayList.get(arrayList.size() - 2));
        } else {
            this.f4842f0.setText(R.string.document_title);
            this.f4839c0.clear();
            C0264e c0264e = new C0264e(Environment.getExternalStorageDirectory());
            this.f4838b0 = c0264e.c();
            this.f4839c0.add(c0264e);
            this.f4832V.g();
        }
        ArrayList arrayList2 = this.f4840d0;
        arrayList2.remove(arrayList2.size() - 1);
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_document_back) {
            onBackPressed();
        } else {
            if (id != R.id.tv_enable_http_server) {
                return;
            }
            startActivity(new Intent(this, (Class<?>) WirelessStorageSettingActivity.class));
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f4835Y.shutdown();
    }

    @Override // j0.e
    public void p(RecyclerView.g gVar, int i2) {
        C0264e c0264eY;
        if (!this.f4833W.isDeviceConnect()) {
            CustomApplication.f(R.string.device_not_connected);
            return;
        }
        g0.d dVar = this.f4832V;
        if (gVar != dVar || (c0264eY = dVar.y(i2)) == null) {
            return;
        }
        if (!c0264eY.a().isDirectory()) {
            I1(0, new c(c0264eY));
            return;
        }
        if (!c0264eY.a().canRead()) {
            CustomApplication.f(R.string.document_access_denied);
            return;
        }
        this.f4844h0 = i2;
        this.f4840d0.add(c0264eY.c());
        this.f4839c0.clear();
        V1(c0264eY.c());
        this.f4832V.g();
    }

    @Override // n0.C0298c.g
    public void x(List list) {
        g0.d dVar = new g0.d(this, list);
        this.f4832V = dVar;
        dVar.B(this);
        this.f4830T.setLayoutManager(new LinearLayoutManager(this));
        this.f4830T.setAdapter(this.f4832V);
        this.f4836Z.cancel();
    }
}
