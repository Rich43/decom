package Y;

import Q.i;
import T.n;
import V.b;
import W.k;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import c0.j;
import d0.C0246c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class h extends Y.a {

    /* renamed from: A, reason: collision with root package name */
    private final Paint f1332A;

    /* renamed from: B, reason: collision with root package name */
    private final Map f1333B;

    /* renamed from: C, reason: collision with root package name */
    private final androidx.collection.d f1334C;

    /* renamed from: D, reason: collision with root package name */
    private final n f1335D;

    /* renamed from: E, reason: collision with root package name */
    private final com.airbnb.lottie.a f1336E;

    /* renamed from: F, reason: collision with root package name */
    private final Q.d f1337F;

    /* renamed from: G, reason: collision with root package name */
    private T.a f1338G;

    /* renamed from: H, reason: collision with root package name */
    private T.a f1339H;

    /* renamed from: I, reason: collision with root package name */
    private T.a f1340I;

    /* renamed from: J, reason: collision with root package name */
    private T.a f1341J;

    /* renamed from: w, reason: collision with root package name */
    private final StringBuilder f1342w;

    /* renamed from: x, reason: collision with root package name */
    private final RectF f1343x;

    /* renamed from: y, reason: collision with root package name */
    private final Matrix f1344y;

    /* renamed from: z, reason: collision with root package name */
    private final Paint f1345z;

    class a extends Paint {
        a(int i2) {
            super(i2);
            setStyle(Paint.Style.FILL);
        }
    }

    class b extends Paint {
        b(int i2) {
            super(i2);
            setStyle(Paint.Style.STROKE);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1348a;

        static {
            int[] iArr = new int[b.a.values().length];
            f1348a = iArr;
            try {
                iArr[b.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1348a[b.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1348a[b.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    h(com.airbnb.lottie.a aVar, d dVar) {
        W.b bVar;
        W.b bVar2;
        W.a aVar2;
        W.a aVar3;
        super(aVar, dVar);
        this.f1342w = new StringBuilder(2);
        this.f1343x = new RectF();
        this.f1344y = new Matrix();
        this.f1345z = new a(1);
        this.f1332A = new b(1);
        this.f1333B = new HashMap();
        this.f1334C = new androidx.collection.d();
        this.f1336E = aVar;
        this.f1337F = dVar.a();
        n nVarA = dVar.q().a();
        this.f1335D = nVarA;
        nVarA.a(this);
        j(nVarA);
        k kVarR = dVar.r();
        if (kVarR != null && (aVar3 = kVarR.f1008a) != null) {
            T.a aVarA = aVar3.a();
            this.f1338G = aVarA;
            aVarA.a(this);
            j(this.f1338G);
        }
        if (kVarR != null && (aVar2 = kVarR.f1009b) != null) {
            T.a aVarA2 = aVar2.a();
            this.f1339H = aVarA2;
            aVarA2.a(this);
            j(this.f1339H);
        }
        if (kVarR != null && (bVar2 = kVarR.f1010c) != null) {
            T.a aVarA3 = bVar2.a();
            this.f1340I = aVarA3;
            aVarA3.a(this);
            j(this.f1340I);
        }
        if (kVarR == null || (bVar = kVarR.f1011d) == null) {
            return;
        }
        T.a aVarA4 = bVar.a();
        this.f1341J = aVarA4;
        aVarA4.a(this);
        j(this.f1341J);
    }

    private void K(b.a aVar, Canvas canvas, float f2) {
        int i2 = c.f1348a[aVar.ordinal()];
        if (i2 == 2) {
            canvas.translate(-f2, 0.0f);
        } else {
            if (i2 != 3) {
                return;
            }
            canvas.translate((-f2) / 2.0f, 0.0f);
        }
    }

    private String L(String str, int i2) {
        int iCodePointAt = str.codePointAt(i2);
        int iCharCount = Character.charCount(iCodePointAt) + i2;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!X(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j2 = iCodePointAt;
        if (this.f1334C.d(j2)) {
            return (String) this.f1334C.f(j2);
        }
        this.f1342w.setLength(0);
        while (i2 < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i2);
            this.f1342w.appendCodePoint(iCodePointAt3);
            i2 += Character.charCount(iCodePointAt3);
        }
        String string = this.f1342w.toString();
        this.f1334C.j(j2, string);
        return string;
    }

    private void M(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void N(V.d dVar, Matrix matrix, float f2, V.b bVar, Canvas canvas) {
        List listU = U(dVar);
        for (int i2 = 0; i2 < listU.size(); i2++) {
            Path pathH = ((S.d) listU.get(i2)).h();
            pathH.computeBounds(this.f1343x, false);
            this.f1344y.set(matrix);
            this.f1344y.preTranslate(0.0f, ((float) (-bVar.f955g)) * j.e());
            this.f1344y.preScale(f2, f2);
            pathH.transform(this.f1344y);
            if (bVar.f959k) {
                Q(pathH, this.f1345z, canvas);
                Q(pathH, this.f1332A, canvas);
            } else {
                Q(pathH, this.f1332A, canvas);
                Q(pathH, this.f1345z, canvas);
            }
        }
    }

    private void O(String str, V.b bVar, Canvas canvas) {
        if (bVar.f959k) {
            M(str, this.f1345z, canvas);
            M(str, this.f1332A, canvas);
        } else {
            M(str, this.f1332A, canvas);
            M(str, this.f1345z, canvas);
        }
    }

    private void P(String str, V.b bVar, Canvas canvas, float f2) {
        int length = 0;
        while (length < str.length()) {
            String strL = L(str, length);
            length += strL.length();
            O(strL, bVar, canvas);
            float fMeasureText = this.f1345z.measureText(strL, 0, 1);
            float fFloatValue = bVar.e / 10.0f;
            T.a aVar = this.f1341J;
            if (aVar != null) {
                fFloatValue += ((Float) aVar.h()).floatValue();
            }
            canvas.translate(fMeasureText + (fFloatValue * f2), 0.0f);
        }
    }

    private void Q(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void R(String str, V.b bVar, Matrix matrix, V.c cVar, Canvas canvas, float f2, float f3) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            V.d dVar = (V.d) this.f1337F.c().e(V.d.c(str.charAt(i2), cVar.a(), cVar.c()));
            if (dVar != null) {
                N(dVar, matrix, f3, bVar, canvas);
                float fB = ((float) dVar.b()) * f3 * j.e() * f2;
                float fFloatValue = bVar.e / 10.0f;
                T.a aVar = this.f1341J;
                if (aVar != null) {
                    fFloatValue += ((Float) aVar.h()).floatValue();
                }
                canvas.translate(fB + (fFloatValue * f2), 0.0f);
            }
        }
    }

    private void S(V.b bVar, Matrix matrix, V.c cVar, Canvas canvas) {
        float f2 = ((float) bVar.f952c) / 100.0f;
        float fG = j.g(matrix);
        String str = bVar.f950a;
        float fE = ((float) bVar.f954f) * j.e();
        List listW = W(str);
        int size = listW.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = (String) listW.get(i2);
            float fV = V(str2, cVar, f2, fG);
            canvas.save();
            K(bVar.f953d, canvas, fV);
            canvas.translate(0.0f, (i2 * fE) - (((size - 1) * fE) / 2.0f));
            R(str2, bVar, matrix, cVar, canvas, fG, f2);
            canvas.restore();
        }
    }

    private void T(V.b bVar, V.c cVar, Matrix matrix, Canvas canvas) {
        float fG = j.g(matrix);
        Typeface typefaceB = this.f1336E.B(cVar.a(), cVar.c());
        if (typefaceB == null) {
            return;
        }
        String str = bVar.f950a;
        this.f1336E.A();
        this.f1345z.setTypeface(typefaceB);
        this.f1345z.setTextSize((float) (bVar.f952c * j.e()));
        this.f1332A.setTypeface(this.f1345z.getTypeface());
        this.f1332A.setTextSize(this.f1345z.getTextSize());
        float fE = ((float) bVar.f954f) * j.e();
        List listW = W(str);
        int size = listW.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = (String) listW.get(i2);
            K(bVar.f953d, canvas, this.f1332A.measureText(str2));
            canvas.translate(0.0f, (i2 * fE) - (((size - 1) * fE) / 2.0f));
            P(str2, bVar, canvas, fG);
            canvas.setMatrix(matrix);
        }
    }

    private List U(V.d dVar) {
        if (this.f1333B.containsKey(dVar)) {
            return (List) this.f1333B.get(dVar);
        }
        List listA = dVar.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new S.d(this.f1336E, this, (X.n) listA.get(i2)));
        }
        this.f1333B.put(dVar, arrayList);
        return arrayList;
    }

    private float V(String str, V.c cVar, float f2, float f3) {
        float fB = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            V.d dVar = (V.d) this.f1337F.c().e(V.d.c(str.charAt(i2), cVar.a(), cVar.c()));
            if (dVar != null) {
                fB = (float) (fB + (dVar.b() * f2 * j.e() * f3));
            }
        }
        return fB;
    }

    private List W(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private boolean X(int i2) {
        return Character.getType(i2) == 16 || Character.getType(i2) == 27 || Character.getType(i2) == 6 || Character.getType(i2) == 28 || Character.getType(i2) == 19;
    }

    @Override // Y.a, S.e
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        super.a(rectF, matrix, z2);
        rectF.set(0.0f, 0.0f, this.f1337F.b().width(), this.f1337F.b().height());
    }

    @Override // Y.a, V.f
    public void c(Object obj, C0246c c0246c) {
        T.a aVar;
        T.a aVar2;
        T.a aVar3;
        T.a aVar4;
        super.c(obj, c0246c);
        if (obj == i.f590a && (aVar4 = this.f1338G) != null) {
            aVar4.m(c0246c);
            return;
        }
        if (obj == i.f591b && (aVar3 = this.f1339H) != null) {
            aVar3.m(c0246c);
            return;
        }
        if (obj == i.o && (aVar2 = this.f1340I) != null) {
            aVar2.m(c0246c);
        } else {
            if (obj != i.f603p || (aVar = this.f1341J) == null) {
                return;
            }
            aVar.m(c0246c);
        }
    }

    @Override // Y.a
    void t(Canvas canvas, Matrix matrix, int i2) {
        canvas.save();
        if (!this.f1336E.d0()) {
            canvas.setMatrix(matrix);
        }
        V.b bVar = (V.b) this.f1335D.h();
        V.c cVar = (V.c) this.f1337F.g().get(bVar.f951b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        T.a aVar = this.f1338G;
        if (aVar != null) {
            this.f1345z.setColor(((Integer) aVar.h()).intValue());
        } else {
            this.f1345z.setColor(bVar.f956h);
        }
        T.a aVar2 = this.f1339H;
        if (aVar2 != null) {
            this.f1332A.setColor(((Integer) aVar2.h()).intValue());
        } else {
            this.f1332A.setColor(bVar.f957i);
        }
        int iIntValue = ((this.f1281u.h() == null ? 100 : ((Integer) this.f1281u.h().h()).intValue()) * 255) / 100;
        this.f1345z.setAlpha(iIntValue);
        this.f1332A.setAlpha(iIntValue);
        T.a aVar3 = this.f1340I;
        if (aVar3 != null) {
            this.f1332A.setStrokeWidth(((Float) aVar3.h()).floatValue());
        } else {
            this.f1332A.setStrokeWidth((float) (bVar.f958j * j.e() * j.g(matrix)));
        }
        if (this.f1336E.d0()) {
            S(bVar, matrix, cVar, canvas);
        } else {
            T(bVar, cVar, matrix, canvas);
        }
        canvas.restore();
    }
}
