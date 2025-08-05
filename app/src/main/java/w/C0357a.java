package w;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* renamed from: w.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0357a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    private final int f7734a;

    /* renamed from: b, reason: collision with root package name */
    private final C0353E f7735b;

    /* renamed from: c, reason: collision with root package name */
    private final int f7736c;

    public C0357a(int i2, C0353E c0353e, int i3) {
        this.f7734a = i2;
        this.f7735b = c0353e;
        this.f7736c = i3;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f7734a);
        this.f7735b.T(this.f7736c, bundle);
    }
}
