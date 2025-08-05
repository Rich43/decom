package g;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import g.AbstractC0255b;
import java.lang.reflect.InvocationTargetException;

/* renamed from: g.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0257d extends AbstractC0255b {

    /* renamed from: m, reason: collision with root package name */
    private a f6250m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f6251n;

    /* renamed from: g.d$a */
    static class a extends AbstractC0255b.d {

        /* renamed from: J, reason: collision with root package name */
        int[][] f6252J;

        a(a aVar, AbstractC0257d abstractC0257d, Resources resources) {
            super(aVar, abstractC0257d, resources);
            if (aVar != null) {
                this.f6252J = aVar.f6252J;
            } else {
                this.f6252J = new int[f()][];
            }
        }

        int A(int[] iArr) {
            int[][] iArr2 = this.f6252J;
            int iH = h();
            for (int i2 = 0; i2 < iH; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // g.AbstractC0255b.d
        public void o(int i2, int i3) {
            super.o(i2, i3);
            int[][] iArr = new int[i3][];
            System.arraycopy(this.f6252J, 0, iArr, 0, i2);
            this.f6252J = iArr;
        }

        @Override // g.AbstractC0255b.d
        abstract void r();

        int z(int[] iArr, Drawable drawable) {
            int iA = a(drawable);
            this.f6252J[iA] = iArr;
            return iA;
        }
    }

    AbstractC0257d(a aVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (aVar != null) {
            h(aVar);
        }
    }

    @Override // g.AbstractC0255b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // g.AbstractC0255b
    void h(AbstractC0255b.d dVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.h(dVar);
        if (dVar instanceof a) {
            this.f6250m = (a) dVar;
        }
    }

    int[] j(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i2 = 0;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i3);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i4 = i2 + 1;
                if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i2] = attributeNameResource;
                i2 = i4;
            }
        }
        return StateSet.trimStateSet(iArr, i2);
    }

    @Override // g.AbstractC0255b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f6251n && super.mutate() == this) {
            this.f6250m.r();
            this.f6251n = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected abstract boolean onStateChange(int[] iArr);
}
