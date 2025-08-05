package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.C0136d;
import androidx.appcompat.widget.C0138f;
import androidx.appcompat.widget.C0139g;
import androidx.appcompat.widget.C0140h;
import androidx.appcompat.widget.C0147o;
import androidx.appcompat.widget.C0149q;
import androidx.appcompat.widget.C0152u;
import androidx.appcompat.widget.C0153v;
import androidx.appcompat.widget.C0155x;
import androidx.appcompat.widget.C0157z;
import androidx.appcompat.widget.J;
import androidx.appcompat.widget.a0;
import androidx.core.view.M;
import defpackage.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class y {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private final Object[] mConstructorArgs = new Object[2];
    private static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private static final int[] sOnClickAttrs = {R.attr.onClick};
    private static final int[] sAccessibilityHeading = {R.attr.accessibilityHeading};
    private static final int[] sAccessibilityPaneTitle = {R.attr.accessibilityPaneTitle};
    private static final int[] sScreenReaderFocusable = {R.attr.screenReaderFocusable};
    private static final String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    private static final androidx.collection.g sConstructorMap = new androidx.collection.g();

    private static class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final View f1815a;

        /* renamed from: b, reason: collision with root package name */
        private final String f1816b;

        /* renamed from: c, reason: collision with root package name */
        private Method f1817c;

        /* renamed from: d, reason: collision with root package name */
        private Context f1818d;

        public a(View view, String str) {
            this.f1815a = view;
            this.f1816b = str;
        }

        private void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f1816b, View.class)) != null) {
                        this.f1817c = method;
                        this.f1818d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f1815a.getId();
            if (id == -1) {
                str = "";
            } else {
                str = " with id '" + this.f1815a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f1816b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f1815a.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (this.f1817c == null) {
                a(this.f1815a.getContext());
            }
            try {
                this.f1817c.invoke(this.f1818d, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    private void a(Context context, View view, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sAccessibilityHeading);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            M.g0(view, typedArrayObtainStyledAttributes.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, sAccessibilityPaneTitle);
        if (typedArrayObtainStyledAttributes2.hasValue(0)) {
            M.h0(view, typedArrayObtainStyledAttributes2.getString(0));
        }
        typedArrayObtainStyledAttributes2.recycle();
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, sScreenReaderFocusable);
        if (typedArrayObtainStyledAttributes3.hasValue(0)) {
            M.u0(view, typedArrayObtainStyledAttributes3.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes3.recycle();
    }

    private void b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && view.hasOnClickListeners()) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private View c(Context context, String str, String str2) throws NoSuchMethodException, SecurityException {
        String str3;
        androidx.collection.g gVar = sConstructorMap;
        Constructor constructor = (Constructor) gVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);
            gVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.mConstructorArgs);
    }

    private View d(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.mConstructorArgs;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return c(context, str, null);
            }
            int i2 = 0;
            while (true) {
                String[] strArr = sClassPrefixList;
                if (i2 >= strArr.length) {
                    return null;
                }
                View viewC = c(context, str, strArr[i2]);
                if (viewC != null) {
                    return viewC;
                }
                i2++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.mConstructorArgs;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context e(Context context, AttributeSet attributeSet, boolean z2, boolean z3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.m.e3, 0, 0);
        int resourceId = z2 ? typedArrayObtainStyledAttributes.getResourceId(e.m.f3, 0) : 0;
        if (z3 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(e.m.g3, 0)) != 0) {
            Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof androidx.appcompat.view.d) && ((androidx.appcompat.view.d) context).c() == resourceId) ? context : new androidx.appcompat.view.d(context, resourceId) : context;
    }

    private void f(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    protected C0136d createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new C0136d(context, attributeSet);
    }

    protected C0138f createButton(Context context, AttributeSet attributeSet) {
        return new C0138f(context, attributeSet);
    }

    protected C0139g createCheckBox(Context context, AttributeSet attributeSet) {
        return new C0139g(context, attributeSet);
    }

    protected C0140h createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new C0140h(context, attributeSet);
    }

    protected AppCompatEditText createEditText(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    protected C0147o createImageButton(Context context, AttributeSet attributeSet) {
        return new C0147o(context, attributeSet);
    }

    protected C0149q createImageView(Context context, AttributeSet attributeSet) {
        return new C0149q(context, attributeSet);
    }

    protected androidx.appcompat.widget.r createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.r(context, attributeSet);
    }

    protected C0152u createRadioButton(Context context, AttributeSet attributeSet) {
        return new C0152u(context, attributeSet);
    }

    protected C0153v createRatingBar(Context context, AttributeSet attributeSet) {
        return new C0153v(context, attributeSet);
    }

    protected C0155x createSeekBar(Context context, AttributeSet attributeSet) {
        return new C0155x(context, attributeSet);
    }

    protected C0157z createSpinner(Context context, AttributeSet attributeSet) {
        return new C0157z(context, attributeSet);
    }

    protected androidx.appcompat.widget.E createTextView(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.E(context, attributeSet);
    }

    protected J createToggleButton(Context context, AttributeSet attributeSet) {
        return new J(context, attributeSet);
    }

    protected View createView(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    public final View createView(View view, String str, Context context, AttributeSet attributeSet, boolean z2, boolean z3, boolean z4, boolean z5) {
        Context context2;
        View viewCreateRatingBar;
        context2 = (!z2 || view == null) ? context : view.getContext();
        if (z3 || z4) {
            context2 = e(context2, attributeSet, z3, z4);
        }
        if (z5) {
            context2 = a0.b(context2);
        }
        str.hashCode();
        switch (str) {
            case "RatingBar":
                viewCreateRatingBar = createRatingBar(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            case "CheckedTextView":
                viewCreateRatingBar = createCheckedTextView(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            case "MultiAutoCompleteTextView":
                viewCreateRatingBar = createMultiAutoCompleteTextView(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            case "TextView":
                viewCreateRatingBar = createTextView(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            case "ImageButton":
                viewCreateRatingBar = createImageButton(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            case "SeekBar":
                viewCreateRatingBar = createSeekBar(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            case "Spinner":
                viewCreateRatingBar = createSpinner(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            case "RadioButton":
                viewCreateRatingBar = createRadioButton(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            case "ToggleButton":
                viewCreateRatingBar = createToggleButton(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            case "ImageView":
                viewCreateRatingBar = createImageView(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            case "AutoCompleteTextView":
                viewCreateRatingBar = createAutoCompleteTextView(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            case "CheckBox":
                viewCreateRatingBar = createCheckBox(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            case "EditText":
                viewCreateRatingBar = createEditText(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            case "Button":
                viewCreateRatingBar = createButton(context2, attributeSet);
                f(viewCreateRatingBar, str);
                break;
            default:
                viewCreateRatingBar = createView(context2, str, attributeSet);
                break;
        }
        if (viewCreateRatingBar == null && context != context2) {
            viewCreateRatingBar = d(context2, str, attributeSet);
        }
        if (viewCreateRatingBar != null) {
            b(viewCreateRatingBar, attributeSet);
            a(context2, viewCreateRatingBar, attributeSet);
        }
        return viewCreateRatingBar;
    }
}
