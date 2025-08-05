package com.caglobal.kodakluma.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.caglobal.kodakluma.CustomApplication;
import com.caglobal.kodakluma.R;
import com.eshare.api.EShareAPI;
import com.eshare.api.IDevice;
import g0.C0258a;
import g0.h;
import h0.C0260a;
import h0.g;
import h0.m;
import j0.f;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import l0.InterfaceC0280d;
import n0.C0298c;
import p0.C0308c;
import q0.AbstractC0319h;

/* loaded from: classes.dex */
public class PhotoActivity extends com.caglobal.kodakluma.activity.a implements C0298c.f, j0.e, AdapterView.OnItemLongClickListener, f {

    /* renamed from: T, reason: collision with root package name */
    private TextView f5169T;

    /* renamed from: U, reason: collision with root package name */
    private RecyclerView f5170U;

    /* renamed from: V, reason: collision with root package name */
    private ListView f5171V;

    /* renamed from: W, reason: collision with root package name */
    private LinearLayout f5172W;

    /* renamed from: X, reason: collision with root package name */
    private LinearLayout f5173X;

    /* renamed from: Y, reason: collision with root package name */
    private List f5174Y;

    /* renamed from: Z, reason: collision with root package name */
    private h f5175Z;

    /* renamed from: a0, reason: collision with root package name */
    private C0258a f5176a0;

    /* renamed from: b0, reason: collision with root package name */
    private IDevice f5177b0;

    /* renamed from: c0, reason: collision with root package name */
    private C0298c f5178c0;

    class a implements InterfaceC0280d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.g f5179a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f5180b;

        a(RecyclerView.g gVar, int i2) {
            this.f5179a = gVar;
            this.f5180b = i2;
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() {
            m mVarW;
            if (this.f5179a != PhotoActivity.this.f5175Z || (mVarW = PhotoActivity.this.f5175Z.w(this.f5180b)) == null) {
                return;
            }
            Intent intent = new Intent(PhotoActivity.this, (Class<?>) ImageActivity.class);
            intent.putExtra("com.eshare.optoma.extra.PHOTO_PATH", mVarW.a().getParent());
            intent.putExtra("com.eshare.optoma.extra.PHOTO_INDEX", this.f5180b);
            PhotoActivity.this.startActivity(intent);
        }
    }

    class b implements InterfaceC0280d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.g f5182a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f5183b;

        b(RecyclerView.g gVar, int i2) {
            this.f5182a = gVar;
            this.f5183b = i2;
        }

        @Override // l0.InterfaceC0280d
        public void onSuccess() {
            m mVarW;
            if (this.f5182a != PhotoActivity.this.f5175Z || (mVarW = PhotoActivity.this.f5175Z.w(this.f5183b)) == null) {
                return;
            }
            PhotoActivity.this.A1(mVarW.a());
        }
    }

    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
            PhotoActivity.this.S1(false);
            C0260a item = PhotoActivity.this.f5176a0.getItem(i2);
            PhotoActivity.this.f5176a0.b(i2);
            PhotoActivity.this.R1(item);
        }
    }

    class d implements FileFilter {
        d() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return AbstractC0319h.g(file);
        }
    }

    class e implements FileFilter {
        e() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return AbstractC0319h.g(file);
        }
    }

    private void P1(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0260a c0260a = (C0260a) it.next();
            File[] fileArrListFiles = c0260a.a().listFiles(new d());
            if (fileArrListFiles != null) {
                c0260a.k(fileArrListFiles.length);
            }
        }
    }

    private void Q1(List list) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void R1(C0260a c0260a) {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = c0260a.a().listFiles(new e());
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file : fileArrListFiles) {
                m mVar = new m(file);
                mVar.i(this);
                arrayList.add(mVar);
            }
        }
        Collections.sort(arrayList, new C0308c());
        Q1(arrayList);
        this.f5174Y.clear();
        this.f5174Y.addAll(arrayList);
        this.f5175Z.g();
        if (this.f5169T.isSelected()) {
            this.f5169T.setText(c0260a.h());
        } else {
            this.f5169T.setText(R.string.main_item_photo);
        }
        this.f5176a0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1(boolean z2) {
        if (!z2) {
            this.f5172W.setVisibility(0);
            this.f5173X.setVisibility(8);
            this.f5169T.setSelected(true);
        } else {
            this.f5173X.setVisibility(0);
            this.f5169T.setText(R.string.main_item_photo);
            this.f5169T.setSelected(false);
            this.f5172W.setVisibility(8);
        }
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        this.f5169T = (TextView) findViewById(R.id.tv_photo_title);
        this.f5170U = (RecyclerView) findViewById(R.id.rv_photo_grid);
        ListView listView = (ListView) findViewById(R.id.lv_photo_album);
        this.f5171V = listView;
        listView.setOnItemLongClickListener(this);
        this.f5172W = (LinearLayout) findViewById(R.id.ll_photo_grid);
        this.f5173X = (LinearLayout) findViewById(R.id.ll_photo_album);
        findViewById(R.id.iv_photo_back).setOnClickListener(this);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_photo;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        C0298c c0298cR = C0298c.r();
        this.f5178c0 = c0298cR;
        c0298cR.C(this);
        this.f5178c0.v(this);
        this.f5177b0 = EShareAPI.init(this).device();
        ArrayList arrayList = new ArrayList();
        this.f5174Y = arrayList;
        h hVar = new h(this, arrayList);
        this.f5175Z = hVar;
        hVar.z(this);
        this.f5175Z.A(this);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
        this.f5169T.setOnClickListener(this);
        this.f5173X.setOnClickListener(this);
        this.f5170U.setLayoutManager(new GridLayoutManager(this, 3));
        this.f5170U.setAdapter(this.f5175Z);
    }

    @Override // j0.f
    public void Q(RecyclerView.g gVar, int i2) {
        I1(1, new b(gVar, i2));
    }

    @s1.m
    public void finishSelf(g gVar) {
        if (gVar.a() == g.f6395b) {
            finish();
        }
    }

    @Override // n0.C0298c.f
    public void o(List list) {
        C0258a c0258a = new C0258a(this, list);
        this.f5176a0 = c0258a;
        this.f5171V.setAdapter((ListAdapter) c0258a);
        P1(list);
        this.f5171V.setOnItemClickListener(new c());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f5172W.getVisibility() == 0) {
            S1(true);
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.iv_photo_back) {
            return;
        }
        if (this.f5172W.getVisibility() == 0) {
            S1(true);
        } else {
            finish();
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i2, long j2) {
        C0260a item = this.f5176a0.getItem(i2);
        if (item == null) {
            return true;
        }
        A1(item.a());
        return true;
    }

    @Override // j0.e
    public void p(RecyclerView.g gVar, int i2) {
        if (this.f5177b0.isDeviceConnect()) {
            I1(1, new a(gVar, i2));
        } else {
            CustomApplication.f(R.string.device_not_connected);
        }
    }
}
