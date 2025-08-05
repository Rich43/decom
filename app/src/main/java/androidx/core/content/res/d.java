package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    private final Shader f2960a;

    /* renamed from: b */
    private final ColorStateList f2961b;

    /* renamed from: c */
    private int f2962c;

    private d(Shader shader, ColorStateList colorStateList, int i2) {
        this.f2960a = shader;
        this.f2961b = colorStateList;
        this.f2962c = i2;
    }

    private static d a(Resources resources, int i2, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i2);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.hashCode();
        if (name.equals("gradient")) {
            return d(f.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return c(c.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    static d b(int i2) {
        return new d(null, null, i2);
    }

    static d c(ColorStateList colorStateList) {
        return new d(null, colorStateList, colorStateList.getDefaultColor());
    }

    static d d(Shader shader) {
        return new d(shader, null, 0);
    }

    public static d g(Resources resources, int i2, Resources.Theme theme) {
        try {
            return a(resources, i2, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    public int e() {
        return this.f2962c;
    }

    public Shader f() {
        return this.f2960a;
    }

    public boolean h() {
        return this.f2960a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f2960a == null && (colorStateList = this.f2961b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f2961b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f2962c) {
                this.f2962c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(int i2) {
        this.f2962c = i2;
    }

    public boolean l() {
        return h() || this.f2962c != 0;
    }
}
