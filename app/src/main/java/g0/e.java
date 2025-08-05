package g0;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import java.util.List;

/* loaded from: classes.dex */
public class e extends androidx.viewpager.widget.a {

    /* renamed from: c, reason: collision with root package name */
    private List f6294c;

    public e(List list) {
        this.f6294c = list;
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i2, Object obj) {
        ((ViewPager) viewGroup).removeView((View) this.f6294c.get(i2));
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        List list = this.f6294c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.a
    public Object g(ViewGroup viewGroup, int i2) {
        ((ViewPager) viewGroup).addView((View) this.f6294c.get(i2), 0);
        return this.f6294c.get(i2);
    }

    @Override // androidx.viewpager.widget.a
    public boolean h(View view, Object obj) {
        return view == ((View) obj);
    }
}
