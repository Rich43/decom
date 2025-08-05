package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.DialogInterfaceC0127b;
import defpackage.e;
import f.AbstractC0250a;
import i.InterfaceC0269e;
import java.lang.reflect.InvocationTargetException;
import v.AbstractC0340c;

/* renamed from: androidx.appcompat.widget.z */
/* loaded from: classes.dex */
public class C0157z extends Spinner {

    /* renamed from: i */
    private static final int[] f2533i = {R.attr.spinnerMode};

    /* renamed from: a */
    private final C0137e f2534a;

    /* renamed from: b */
    private final Context f2535b;

    /* renamed from: c */
    private P f2536c;

    /* renamed from: d */
    private SpinnerAdapter f2537d;
    private final boolean e;

    /* renamed from: f */
    private h f2538f;

    /* renamed from: g */
    int f2539g;

    /* renamed from: h */
    final Rect f2540h;

    /* renamed from: androidx.appcompat.widget.z$a */
    class a extends P {

        /* renamed from: j */
        final /* synthetic */ f f2541j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, f fVar) {
            super(view);
            this.f2541j = fVar;
        }

        @Override // androidx.appcompat.widget.P
        public InterfaceC0269e b() {
            return this.f2541j;
        }

        @Override // androidx.appcompat.widget.P
        public boolean c() {
            if (C0157z.this.getInternalPopup().b()) {
                return true;
            }
            C0157z.this.b();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.z$b */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!C0157z.this.getInternalPopup().b()) {
                C0157z.this.b();
            }
            ViewTreeObserver viewTreeObserver = C0157z.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.z$c */
    private static final class c {
        static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (AbstractC0340c.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                return;
            }
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    /* renamed from: androidx.appcompat.widget.z$d */
    class d implements h, DialogInterface.OnClickListener {

        /* renamed from: a */
        DialogInterfaceC0127b f2544a;

        /* renamed from: b */
        private ListAdapter f2545b;

        /* renamed from: c */
        private CharSequence f2546c;

        d() {
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public boolean b() {
            DialogInterfaceC0127b dialogInterfaceC0127b = this.f2544a;
            if (dialogInterfaceC0127b != null) {
                return dialogInterfaceC0127b.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public void c(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public int d() {
            return 0;
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public void dismiss() {
            DialogInterfaceC0127b dialogInterfaceC0127b = this.f2544a;
            if (dialogInterfaceC0127b != null) {
                dialogInterfaceC0127b.dismiss();
                this.f2544a = null;
            }
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public void e(int i2, int i3) {
            if (this.f2545b == null) {
                return;
            }
            DialogInterfaceC0127b.a aVar = new DialogInterfaceC0127b.a(C0157z.this.getPopupContext());
            CharSequence charSequence = this.f2546c;
            if (charSequence != null) {
                aVar.m(charSequence);
            }
            DialogInterfaceC0127b dialogInterfaceC0127bA = aVar.k(this.f2545b, C0157z.this.getSelectedItemPosition(), this).a();
            this.f2544a = dialogInterfaceC0127bA;
            ListView listViewK = dialogInterfaceC0127bA.k();
            listViewK.setTextDirection(i2);
            listViewK.setTextAlignment(i3);
            this.f2544a.show();
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public int g() {
            return 0;
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public Drawable i() {
            return null;
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public CharSequence j() {
            return this.f2546c;
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public void l(CharSequence charSequence) {
            this.f2546c = charSequence;
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public void m(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public void n(int i2) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public void o(ListAdapter listAdapter) {
            this.f2545b = listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            C0157z.this.setSelection(i2);
            if (C0157z.this.getOnItemClickListener() != null) {
                C0157z.this.performItemClick(null, i2, this.f2545b.getItemId(i2));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public void p(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

    /* renamed from: androidx.appcompat.widget.z$e */
    private static class e implements ListAdapter, SpinnerAdapter {

        /* renamed from: a */
        private SpinnerAdapter f2548a;

        /* renamed from: b */
        private ListAdapter f2549b;

        public e(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f2548a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2549b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null || Build.VERSION.SDK_INT < 23 || !A.a(spinnerAdapter)) {
                return;
            }
            c.a(B.a(spinnerAdapter), theme);
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2549b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f2548a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f2548a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f2548a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f2548a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f2548a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f2549b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2548a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2548a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.z$f */
    class f extends S implements h {

        /* renamed from: J */
        private CharSequence f2550J;

        /* renamed from: K */
        ListAdapter f2551K;

        /* renamed from: L */
        private final Rect f2552L;

        /* renamed from: M */
        private int f2553M;

        /* renamed from: androidx.appcompat.widget.z$f$a */
        class a implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            final /* synthetic */ C0157z f2555a;

            a(C0157z c0157z) {
                this.f2555a = c0157z;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                C0157z.this.setSelection(i2);
                if (C0157z.this.getOnItemClickListener() != null) {
                    f fVar = f.this;
                    C0157z.this.performItemClick(view, i2, fVar.f2551K.getItemId(i2));
                }
                f.this.dismiss();
            }
        }

        /* renamed from: androidx.appcompat.widget.z$f$b */
        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                f fVar = f.this;
                if (!fVar.Q(C0157z.this)) {
                    f.this.dismiss();
                } else {
                    f.this.O();
                    f.super.f();
                }
            }
        }

        /* renamed from: androidx.appcompat.widget.z$f$c */
        class c implements PopupWindow.OnDismissListener {

            /* renamed from: a */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f2558a;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f2558a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = C0157z.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f2558a);
                }
            }
        }

        public f(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f2552L = new Rect();
            z(C0157z.this);
            F(true);
            K(0);
            H(new a(C0157z.this));
        }

        void O() {
            int i2;
            Drawable drawableI = i();
            if (drawableI != null) {
                drawableI.getPadding(C0157z.this.f2540h);
                i2 = o0.b(C0157z.this) ? C0157z.this.f2540h.right : -C0157z.this.f2540h.left;
            } else {
                Rect rect = C0157z.this.f2540h;
                rect.right = 0;
                rect.left = 0;
                i2 = 0;
            }
            int paddingLeft = C0157z.this.getPaddingLeft();
            int paddingRight = C0157z.this.getPaddingRight();
            int width = C0157z.this.getWidth();
            C0157z c0157z = C0157z.this;
            int i3 = c0157z.f2539g;
            if (i3 == -2) {
                int iA = c0157z.a((SpinnerAdapter) this.f2551K, i());
                int i4 = C0157z.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = C0157z.this.f2540h;
                int i5 = (i4 - rect2.left) - rect2.right;
                if (iA > i5) {
                    iA = i5;
                }
                B(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (i3 == -1) {
                B((width - paddingLeft) - paddingRight);
            } else {
                B(i3);
            }
            c(o0.b(C0157z.this) ? i2 + (((width - paddingRight) - v()) - P()) : i2 + paddingLeft + P());
        }

        public int P() {
            return this.f2553M;
        }

        boolean Q(View view) {
            return view.isAttachedToWindow() && view.getGlobalVisibleRect(this.f2552L);
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public void e(int i2, int i3) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            ViewTreeObserver viewTreeObserver;
            boolean zB = b();
            O();
            E(2);
            super.f();
            ListView listViewK = k();
            listViewK.setChoiceMode(1);
            listViewK.setTextDirection(i2);
            listViewK.setTextAlignment(i3);
            L(C0157z.this.getSelectedItemPosition());
            if (zB || (viewTreeObserver = C0157z.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            G(new c(bVar));
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public CharSequence j() {
            return this.f2550J;
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public void l(CharSequence charSequence) {
            this.f2550J = charSequence;
        }

        @Override // androidx.appcompat.widget.S, androidx.appcompat.widget.C0157z.h
        public void o(ListAdapter listAdapter) {
            super.o(listAdapter);
            this.f2551K = listAdapter;
        }

        @Override // androidx.appcompat.widget.C0157z.h
        public void p(int i2) {
            this.f2553M = i2;
        }
    }

    /* renamed from: androidx.appcompat.widget.z$g */
    static class g extends View.BaseSavedState {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: a */
        boolean f2560a;

        /* renamed from: androidx.appcompat.widget.z$g$a */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public g[] newArray(int i2) {
                return new g[i2];
            }
        }

        g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f2560a ? (byte) 1 : (byte) 0);
        }

        g(Parcel parcel) {
            super(parcel);
            this.f2560a = parcel.readByte() != 0;
        }
    }

    /* renamed from: androidx.appcompat.widget.z$h */
    interface h {
        boolean b();

        void c(int i2);

        int d();

        void dismiss();

        void e(int i2, int i3);

        int g();

        Drawable i();

        CharSequence j();

        void l(CharSequence charSequence);

        void m(Drawable drawable);

        void n(int i2);

        void o(ListAdapter listAdapter);

        void p(int i2);
    }

    public C0157z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.d.f5833F);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.f2540h);
        Rect rect = this.f2540h;
        return iMax2 + rect.left + rect.right;
    }

    void b() {
        this.f2538f.e(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0137e c0137e = this.f2534a;
        if (c0137e != null) {
            c0137e.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        h hVar = this.f2538f;
        return hVar != null ? hVar.d() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        h hVar = this.f2538f;
        return hVar != null ? hVar.g() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f2538f != null ? this.f2539g : super.getDropDownWidth();
    }

    final h getInternalPopup() {
        return this.f2538f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        h hVar = this.f2538f;
        return hVar != null ? hVar.i() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f2535b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        h hVar = this.f2538f;
        return hVar != null ? hVar.j() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0137e c0137e = this.f2534a;
        if (c0137e != null) {
            return c0137e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0137e c0137e = this.f2534a;
        if (c0137e != null) {
            return c0137e.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h hVar = this.f2538f;
        if (hVar == null || !hVar.b()) {
            return;
        }
        this.f2538f.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f2538f == null || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        if (!gVar.f2560a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        g gVar = new g(super.onSaveInstanceState());
        h hVar = this.f2538f;
        gVar.f2560a = hVar != null && hVar.b();
        return gVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        P p2 = this.f2536c;
        if (p2 == null || !p2.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        h hVar = this.f2538f;
        if (hVar == null) {
            return super.performClick();
        }
        if (hVar.b()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0137e c0137e = this.f2534a;
        if (c0137e != null) {
            c0137e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0137e c0137e = this.f2534a;
        if (c0137e != null) {
            c0137e.g(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i2) {
        h hVar = this.f2538f;
        if (hVar == null) {
            super.setDropDownHorizontalOffset(i2);
        } else {
            hVar.p(i2);
            this.f2538f.c(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i2) {
        h hVar = this.f2538f;
        if (hVar != null) {
            hVar.n(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i2) {
        if (this.f2538f != null) {
            this.f2539g = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        h hVar = this.f2538f;
        if (hVar != null) {
            hVar.m(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(AbstractC0250a.b(getPopupContext(), i2));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        h hVar = this.f2538f;
        if (hVar != null) {
            hVar.l(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0137e c0137e = this.f2534a;
        if (c0137e != null) {
            c0137e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0137e c0137e = this.f2534a;
        if (c0137e != null) {
            c0137e.j(mode);
        }
    }

    public C0157z(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.e) {
            this.f2537d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f2538f != null) {
            Context context = this.f2535b;
            if (context == null) {
                context = getContext();
            }
            this.f2538f.o(new e(spinnerAdapter, context.getTheme()));
        }
    }

    public C0157z(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00db  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, androidx.appcompat.widget.z] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0157z(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0157z.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
