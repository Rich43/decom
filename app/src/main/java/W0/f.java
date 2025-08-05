package W0;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import z0.EnumC0379a;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f1069a = Pattern.compile(",");

    /* renamed from: b, reason: collision with root package name */
    public static final Set f1070b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set f1071c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set f1072d;
    public static final Set e;

    /* renamed from: f, reason: collision with root package name */
    public static final Set f1073f;

    /* renamed from: g, reason: collision with root package name */
    public static final Set f1074g;

    /* renamed from: h, reason: collision with root package name */
    public static final Set f1075h;

    /* renamed from: i, reason: collision with root package name */
    private static final Map f1076i;

    static {
        EnumSet enumSetOf = EnumSet.of(EnumC0379a.QR_CODE);
        e = enumSetOf;
        EnumSet enumSetOf2 = EnumSet.of(EnumC0379a.DATA_MATRIX);
        f1073f = enumSetOf2;
        EnumSet enumSetOf3 = EnumSet.of(EnumC0379a.AZTEC);
        f1074g = enumSetOf3;
        EnumSet enumSetOf4 = EnumSet.of(EnumC0379a.PDF_417);
        f1075h = enumSetOf4;
        EnumSet enumSetOf5 = EnumSet.of(EnumC0379a.UPC_A, EnumC0379a.UPC_E, EnumC0379a.EAN_13, EnumC0379a.EAN_8, EnumC0379a.RSS_14, EnumC0379a.RSS_EXPANDED);
        f1070b = enumSetOf5;
        EnumSet enumSetOf6 = EnumSet.of(EnumC0379a.CODE_39, EnumC0379a.CODE_93, EnumC0379a.CODE_128, EnumC0379a.ITF, EnumC0379a.CODABAR);
        f1071c = enumSetOf6;
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) enumSetOf5);
        f1072d = enumSetCopyOf;
        enumSetCopyOf.addAll(enumSetOf6);
        HashMap map = new HashMap();
        f1076i = map;
        map.put("ONE_D_MODE", enumSetCopyOf);
        map.put("PRODUCT_MODE", enumSetOf5);
        map.put("QR_CODE_MODE", enumSetOf);
        map.put("DATA_MATRIX_MODE", enumSetOf2);
        map.put("AZTEC_MODE", enumSetOf3);
        map.put("PDF417_MODE", enumSetOf4);
    }
}
