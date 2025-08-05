package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.widget.C0147o;
import androidx.core.view.C0158a;
import androidx.core.view.M;
import defpackage.e;
import w.C0353E;

/* loaded from: classes.dex */
public class CheckableImageButton extends C0147o implements Checkable {
    private static final int[] e = {R.attr.state_checked};

    /* renamed from: d, reason: collision with root package name */
    private boolean f5714d;

    class a extends C0158a {
        a() {
        }

        @Override // androidx.core.view.C0158a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // androidx.core.view.C0158a
        public void g(View view, C0353E c0353e) {
            super.g(view, c0353e);
            c0353e.W(true);
            c0353e.X(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.d.f5857z);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f5714d;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        if (!this.f5714d) {
            return super.onCreateDrawableState(i2);
        }
        int[] iArr = e;
        return View.mergeDrawableStates(super.onCreateDrawableState(i2 + iArr.length), iArr);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (this.f5714d != z2) {
            this.f5714d = z2;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f5714d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        M.f0(this, new a());
    }
}
