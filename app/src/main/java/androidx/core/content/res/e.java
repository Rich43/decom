package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import defpackage.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class e {

    static class a {
        static int a(TypedArray typedArray, int i2) {
            return typedArray.getType(i2);
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* renamed from: a */
        private final d[] f2963a;

        public c(d[] dVarArr) {
            this.f2963a = dVarArr;
        }

        public d[] a() {
            return this.f2963a;
        }
    }

    public static final class d {

        /* renamed from: a */
        private final String f2964a;

        /* renamed from: b */
        private final int f2965b;

        /* renamed from: c */
        private final boolean f2966c;

        /* renamed from: d */
        private final String f2967d;
        private final int e;

        /* renamed from: f */
        private final int f2968f;

        public d(String str, int i2, boolean z2, String str2, int i3, int i4) {
            this.f2964a = str;
            this.f2965b = i2;
            this.f2966c = z2;
            this.f2967d = str2;
            this.e = i3;
            this.f2968f = i4;
        }

        public String a() {
            return this.f2964a;
        }

        public int b() {
            return this.f2968f;
        }

        public int c() {
            return this.e;
        }

        public String d() {
            return this.f2967d;
        }

        public int e() {
            return this.f2965b;
        }

        public boolean f() {
            return this.f2966c;
        }
    }

    /* renamed from: androidx.core.content.res.e$e */
    public static final class C0028e implements b {

        /* renamed from: a */
        private final u.f f2969a;

        /* renamed from: b */
        private final int f2970b;

        /* renamed from: c */
        private final int f2971c;

        /* renamed from: d */
        private final String f2972d;

        public C0028e(u.f fVar, int i2, int i3, String str) {
            this.f2969a = fVar;
            this.f2971c = i2;
            this.f2970b = i3;
            this.f2972d = str;
        }

        public int a() {
            return this.f2971c;
        }

        public u.f b() {
            return this.f2969a;
        }

        public String c() {
            return this.f2972d;
        }

        public int d() {
            return this.f2970b;
        }
    }

    private static int a(TypedArray typedArray, int i2) {
        return a.a(typedArray, i2);
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources resources, int i2) throws Resources.NotFoundException {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i3 = 0; i3 < typedArrayObtainTypedArray.length(); i3++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i2)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), r.f.f7317h);
        String string = typedArrayObtainAttributes.getString(r.f.f7318i);
        String string2 = typedArrayObtainAttributes.getString(r.f.f7322m);
        String string3 = typedArrayObtainAttributes.getString(r.f.f7323n);
        int resourceId = typedArrayObtainAttributes.getResourceId(r.f.f7319j, 0);
        int integer = typedArrayObtainAttributes.getInteger(r.f.f7320k, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(r.f.f7321l, 500);
        String string4 = typedArrayObtainAttributes.getString(r.f.o);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new C0028e(new u.f(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((d[]) arrayList.toArray(new d[0]));
    }

    private static d f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), r.f.f7324p);
        int i2 = r.f.f7331y;
        if (!typedArrayObtainAttributes.hasValue(i2)) {
            i2 = r.f.r;
        }
        int i3 = typedArrayObtainAttributes.getInt(i2, 400);
        int i4 = r.f.f7329w;
        if (!typedArrayObtainAttributes.hasValue(i4)) {
            i4 = r.f.s;
        }
        boolean z2 = 1 == typedArrayObtainAttributes.getInt(i4, 0);
        int i5 = r.f.f7332z;
        if (!typedArrayObtainAttributes.hasValue(i5)) {
            i5 = r.f.f7326t;
        }
        int i6 = r.f.f7330x;
        if (!typedArrayObtainAttributes.hasValue(i6)) {
            i6 = r.f.f7327u;
        }
        String string = typedArrayObtainAttributes.getString(i6);
        int i7 = typedArrayObtainAttributes.getInt(i5, 0);
        int i8 = r.f.f7328v;
        if (!typedArrayObtainAttributes.hasValue(i8)) {
            i8 = r.f.f7325q;
        }
        int resourceId = typedArrayObtainAttributes.getResourceId(i8, 0);
        String string2 = typedArrayObtainAttributes.getString(i8);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i3, z2, string, i7, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    private static List h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
