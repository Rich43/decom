package com.caglobal.kodakluma.model;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class NpaGridLayoutManager extends GridLayoutManager {
    public NpaGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView.v vVar, RecyclerView.z zVar) {
        try {
            super.W0(vVar, zVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NpaGridLayoutManager(Context context, int i2) {
        super(context, i2);
    }
}
