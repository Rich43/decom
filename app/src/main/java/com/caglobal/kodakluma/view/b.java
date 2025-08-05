package com.caglobal.kodakluma.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class b extends RecyclerView.n {

    /* renamed from: a, reason: collision with root package name */
    private final int f5518a;

    public b(int i2) {
        this.f5518a = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        rect.bottom = this.f5518a;
    }
}
