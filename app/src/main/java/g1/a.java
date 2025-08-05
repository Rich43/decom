package g1;

import i1.d;
import i1.k;
import n1.b;

/* loaded from: classes.dex */
public abstract class a {
    public static final Class a(b bVar) {
        k.e(bVar, "<this>");
        Class clsA = ((d) bVar).a();
        k.c(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return clsA;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class b(b bVar) {
        k.e(bVar, "<this>");
        Class clsA = ((d) bVar).a();
        if (!clsA.isPrimitive()) {
            k.c(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return clsA;
        }
        String name = clsA.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    clsA = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    clsA = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    clsA = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    clsA = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    clsA = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    clsA = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    clsA = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    clsA = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    clsA = Short.class;
                    break;
                }
                break;
        }
        k.c(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return clsA;
    }
}
