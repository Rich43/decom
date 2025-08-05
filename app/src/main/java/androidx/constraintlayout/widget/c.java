package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class c extends View {
    public c(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i2) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        aVar.f2688a = i2;
        setLayoutParams(aVar);
    }

    public void setGuidelineEnd(int i2) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        aVar.f2690b = i2;
        setLayoutParams(aVar);
    }

    public void setGuidelinePercent(float f2) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        aVar.f2692c = f2;
        setLayoutParams(aVar);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
    }
}
