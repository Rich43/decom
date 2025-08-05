package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
abstract class W extends Resources {

    /* renamed from: a */
    private final Resources f2348a;

    public W(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2348a = resources;
    }

    final Drawable a(int i2) {
        return super.getDrawable(i2);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i2) {
        return this.f2348a.getAnimation(i2);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i2) {
        return this.f2348a.getBoolean(i2);
    }

    @Override // android.content.res.Resources
    public int getColor(int i2) {
        return this.f2348a.getColor(i2);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2) {
        return this.f2348a.getColorStateList(i2);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f2348a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i2) {
        return this.f2348a.getDimension(i2);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i2) {
        return this.f2348a.getDimensionPixelOffset(i2);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i2) {
        return this.f2348a.getDimensionPixelSize(i2);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f2348a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2, Resources.Theme theme) {
        return androidx.core.content.res.h.d(this.f2348a, i2, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i2, int i3) {
        return androidx.core.content.res.h.e(this.f2348a, i2, i3, null);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i2, int i3, int i4) {
        return this.f2348a.getFraction(i2, i3, i4);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f2348a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i2) {
        return this.f2348a.getIntArray(i2);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i2) {
        return this.f2348a.getInteger(i2);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i2) {
        return this.f2348a.getLayout(i2);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i2) {
        return this.f2348a.getMovie(i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3, Object... objArr) {
        return this.f2348a.getQuantityString(i2, i3, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i2, int i3) {
        return this.f2348a.getQuantityText(i2, i3);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i2) {
        return this.f2348a.getResourceEntryName(i2);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i2) {
        return this.f2348a.getResourceName(i2);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i2) {
        return this.f2348a.getResourcePackageName(i2);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i2) {
        return this.f2348a.getResourceTypeName(i2);
    }

    @Override // android.content.res.Resources
    public String getString(int i2) {
        return this.f2348a.getString(i2);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i2) {
        return this.f2348a.getStringArray(i2);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2) {
        return this.f2348a.getText(i2);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i2) {
        return this.f2348a.getTextArray(i2);
    }

    @Override // android.content.res.Resources
    public void getValue(int i2, TypedValue typedValue, boolean z2) throws Resources.NotFoundException {
        this.f2348a.getValue(i2, typedValue, z2);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z2) throws Resources.NotFoundException {
        this.f2348a.getValueForDensity(i2, i3, typedValue, z2);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i2) {
        return this.f2348a.getXml(i2);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f2348a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i2) {
        return this.f2348a.obtainTypedArray(i2);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2) {
        return this.f2348a.openRawResource(i2);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i2) {
        return this.f2348a.openRawResourceFd(i2);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f2348a.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f2348a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f2348a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
        return androidx.core.content.res.h.e(this.f2348a, i2, i3, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3) {
        return this.f2348a.getQuantityString(i2, i3);
    }

    @Override // android.content.res.Resources
    public String getString(int i2, Object... objArr) {
        return this.f2348a.getString(i2, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2, CharSequence charSequence) {
        return this.f2348a.getText(i2, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z2) throws Resources.NotFoundException {
        this.f2348a.getValue(str, typedValue, z2);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2, TypedValue typedValue) {
        return this.f2348a.openRawResource(i2, typedValue);
    }
}
