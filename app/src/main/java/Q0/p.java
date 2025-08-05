package q0;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private View f7219a;

    /* renamed from: b, reason: collision with root package name */
    int f7220b;

    /* renamed from: c, reason: collision with root package name */
    private b f7221c;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            p.this.f7219a.getWindowVisibleDisplayFrame(rect);
            int iHeight = rect.height();
            System.out.println("" + iHeight);
            p pVar = p.this;
            int i2 = pVar.f7220b;
            if (i2 == 0) {
                pVar.f7220b = iHeight;
                return;
            }
            if (i2 == iHeight) {
                return;
            }
            if (i2 - iHeight > 200) {
                if (pVar.f7221c != null) {
                    p.this.f7221c.b(p.this.f7220b - iHeight);
                }
                p.this.f7220b = iHeight;
            } else if (iHeight - i2 > 200) {
                if (pVar.f7221c != null) {
                    p.this.f7221c.a(iHeight - p.this.f7220b);
                }
                p.this.f7220b = iHeight;
            }
        }
    }

    public interface b {
        void a(int i2);

        void b(int i2);
    }

    public p(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f7219a = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public static void c(Activity activity, b bVar) {
        new p(activity).d(bVar);
    }

    private void d(b bVar) {
        this.f7221c = bVar;
    }
}
