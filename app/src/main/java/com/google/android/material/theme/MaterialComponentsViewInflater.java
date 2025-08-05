package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.y;
import androidx.appcompat.widget.C0138f;
import com.google.android.material.button.a;
import d.InterfaceC0243a;

@InterfaceC0243a
/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends y {
    @Override // androidx.appcompat.app.y
    protected C0138f createButton(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }
}
