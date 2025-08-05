package androidx.core.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import v.AbstractC0340c;

/* loaded from: classes.dex */
public abstract class m implements Spannable {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final TextPaint f3073a;

        /* renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f3074b;

        /* renamed from: c, reason: collision with root package name */
        private final int f3075c;

        /* renamed from: d, reason: collision with root package name */
        private final int f3076d;
        final PrecomputedText.Params e;

        /* renamed from: androidx.core.text.m$a$a, reason: collision with other inner class name */
        public static class C0031a {

            /* renamed from: a, reason: collision with root package name */
            private final TextPaint f3077a;

            /* renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f3078b;

            /* renamed from: c, reason: collision with root package name */
            private int f3079c;

            /* renamed from: d, reason: collision with root package name */
            private int f3080d;

            public C0031a(TextPaint textPaint) {
                this.f3077a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f3079c = 1;
                    this.f3080d = 1;
                } else {
                    this.f3080d = 0;
                    this.f3079c = 0;
                }
                this.f3078b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public a a() {
                return new a(this.f3077a, this.f3078b, this.f3079c, this.f3080d);
            }

            public C0031a b(int i2) {
                this.f3079c = i2;
                return this;
            }

            public C0031a c(int i2) {
                this.f3080d = i2;
                return this;
            }

            public C0031a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f3078b = textDirectionHeuristic;
                return this;
            }
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.e = c.a(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.e = null;
            }
            this.f3073a = textPaint;
            this.f3074b = textDirectionHeuristic;
            this.f3075c = i2;
            this.f3076d = i3;
        }

        public boolean a(a aVar) {
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 >= 23 && (this.f3075c != aVar.b() || this.f3076d != aVar.c())) || this.f3073a.getTextSize() != aVar.e().getTextSize() || this.f3073a.getTextScaleX() != aVar.e().getTextScaleX() || this.f3073a.getTextSkewX() != aVar.e().getTextSkewX() || this.f3073a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f3073a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) || this.f3073a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i2 >= 24) {
                if (!this.f3073a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (!this.f3073a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            return this.f3073a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f3073a.getTypeface().equals(aVar.e().getTypeface());
        }

        public int b() {
            return this.f3075c;
        }

        public int c() {
            return this.f3076d;
        }

        public TextDirectionHeuristic d() {
            return this.f3074b;
        }

        public TextPaint e() {
            return this.f3073a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f3074b == aVar.d();
        }

        public int hashCode() {
            return Build.VERSION.SDK_INT >= 24 ? AbstractC0340c.b(Float.valueOf(this.f3073a.getTextSize()), Float.valueOf(this.f3073a.getTextScaleX()), Float.valueOf(this.f3073a.getTextSkewX()), Float.valueOf(this.f3073a.getLetterSpacing()), Integer.valueOf(this.f3073a.getFlags()), this.f3073a.getTextLocales(), this.f3073a.getTypeface(), Boolean.valueOf(this.f3073a.isElegantTextHeight()), this.f3074b, Integer.valueOf(this.f3075c), Integer.valueOf(this.f3076d)) : AbstractC0340c.b(Float.valueOf(this.f3073a.getTextSize()), Float.valueOf(this.f3073a.getTextScaleX()), Float.valueOf(this.f3073a.getTextSkewX()), Float.valueOf(this.f3073a.getLetterSpacing()), Integer.valueOf(this.f3073a.getFlags()), this.f3073a.getTextLocale(), this.f3073a.getTypeface(), Boolean.valueOf(this.f3073a.isElegantTextHeight()), this.f3074b, Integer.valueOf(this.f3075c), Integer.valueOf(this.f3076d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f3073a.getTextSize());
            sb.append(", textScaleX=" + this.f3073a.getTextScaleX());
            sb.append(", textSkewX=" + this.f3073a.getTextSkewX());
            int i2 = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + this.f3073a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f3073a.isElegantTextHeight());
            if (i2 >= 24) {
                sb.append(", textLocale=" + this.f3073a.getTextLocales());
            } else {
                sb.append(", textLocale=" + this.f3073a.getTextLocale());
            }
            sb.append(", typeface=" + this.f3073a.getTypeface());
            if (i2 >= 26) {
                sb.append(", variationSettings=" + this.f3073a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f3074b);
            sb.append(", breakStrategy=" + this.f3075c);
            sb.append(", hyphenationFrequency=" + this.f3076d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f3073a = params.getTextPaint();
            this.f3074b = params.getTextDirection();
            this.f3075c = params.getBreakStrategy();
            this.f3076d = params.getHyphenationFrequency();
            this.e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
