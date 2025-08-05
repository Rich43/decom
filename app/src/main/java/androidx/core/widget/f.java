package androidx.core.widget;

import android.widget.ListView;

/* loaded from: classes.dex */
public class f extends a {
    private final ListView s;

    public f(ListView listView) {
        super(listView);
        this.s = listView;
    }

    @Override // androidx.core.widget.a
    public boolean a(int i2) {
        return false;
    }

    @Override // androidx.core.widget.a
    public boolean b(int i2) {
        ListView listView = this.s;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i3 = firstVisiblePosition + childCount;
        if (i2 > 0) {
            if (i3 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i2 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.widget.a
    public void j(int i2, int i3) {
        this.s.scrollListBy(i3);
    }
}
