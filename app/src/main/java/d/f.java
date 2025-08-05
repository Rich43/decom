package D;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import v.AbstractC0345h;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final b f65a;

    private static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f66a;

        /* renamed from: b, reason: collision with root package name */
        private final d f67b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f68c = true;

        a(TextView textView) {
            this.f66a = textView;
            this.f67b = new d(textView);
        }

        private InputFilter[] d(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f67b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f67b;
            return inputFilterArr2;
        }

        private SparseArray e(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
                InputFilter inputFilter = inputFilterArr[i2];
                if (inputFilter instanceof d) {
                    sparseArray.put(i2, inputFilter);
                }
            }
            return sparseArray;
        }

        private InputFilter[] f(InputFilter[] inputFilterArr) {
            SparseArray sparseArrayE = e(inputFilterArr);
            if (sparseArrayE.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayE.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (sparseArrayE.indexOfKey(i3) < 0) {
                    inputFilterArr2[i2] = inputFilterArr[i3];
                    i2++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod h(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        private void i() {
            this.f66a.setFilters(a(this.f66a.getFilters()));
        }

        private TransformationMethod k(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }

        @Override // D.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f68c ? f(inputFilterArr) : d(inputFilterArr);
        }

        @Override // D.f.b
        void b(boolean z2) {
            if (z2) {
                j();
            }
        }

        @Override // D.f.b
        void c(boolean z2) {
            this.f68c = z2;
            j();
            i();
        }

        void g(boolean z2) {
            this.f68c = z2;
        }

        void j() {
            this.f66a.setTransformationMethod(l(this.f66a.getTransformationMethod()));
        }

        TransformationMethod l(TransformationMethod transformationMethod) {
            return this.f68c ? k(transformationMethod) : h(transformationMethod);
        }
    }

    static class b {
        b() {
        }

        abstract InputFilter[] a(InputFilter[] inputFilterArr);

        abstract void b(boolean z2);

        abstract void c(boolean z2);
    }

    private static class c extends b {

        /* renamed from: a, reason: collision with root package name */
        private final a f69a;

        c(TextView textView) {
            this.f69a = new a(textView);
        }

        private boolean d() {
            return !androidx.emoji2.text.f.i();
        }

        @Override // D.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return d() ? inputFilterArr : this.f69a.a(inputFilterArr);
        }

        @Override // D.f.b
        void b(boolean z2) {
            if (d()) {
                return;
            }
            this.f69a.b(z2);
        }

        @Override // D.f.b
        void c(boolean z2) {
            if (d()) {
                this.f69a.g(z2);
            } else {
                this.f69a.c(z2);
            }
        }
    }

    public f(TextView textView, boolean z2) {
        AbstractC0345h.g(textView, "textView cannot be null");
        if (z2) {
            this.f65a = new a(textView);
        } else {
            this.f65a = new c(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f65a.a(inputFilterArr);
    }

    public void b(boolean z2) {
        this.f65a.b(z2);
    }

    public void c(boolean z2) {
        this.f65a.c(z2);
    }
}
