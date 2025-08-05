package i1;

/* loaded from: classes.dex */
public class o {
    public n1.b b(Class cls) {
        return new e(cls);
    }

    public n1.c c(Class cls, String str) {
        return new m(cls, str);
    }

    public String d(h hVar) {
        String string = hVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String e(l lVar) {
        return d(lVar);
    }

    public n1.d a(i iVar) {
        return iVar;
    }
}
