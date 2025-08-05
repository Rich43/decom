package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class i extends j {
    i(a aVar) {
        super(aVar);
    }

    @Override // pl.droidsonroids.gif.j
    public void a() {
        a aVar = this.f7185a;
        long jO = aVar.f7142g.o(aVar.f7141f);
        if (jO >= 0) {
            this.f7185a.f7139c = SystemClock.uptimeMillis() + jO;
            if (this.f7185a.isVisible() && this.f7185a.f7138b) {
                a aVar2 = this.f7185a;
                if (!aVar2.f7147l) {
                    aVar2.f7137a.remove(this);
                    a aVar3 = this.f7185a;
                    aVar3.f7150p = aVar3.f7137a.schedule(this, jO, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.f7185a.f7143h.isEmpty() && this.f7185a.b() == this.f7185a.f7142g.h() - 1) {
                a aVar4 = this.f7185a;
                aVar4.f7148m.sendEmptyMessageAtTime(aVar4.c(), this.f7185a.f7139c);
            }
        } else {
            a aVar5 = this.f7185a;
            aVar5.f7139c = Long.MIN_VALUE;
            aVar5.f7138b = false;
        }
        if (!this.f7185a.isVisible() || this.f7185a.f7148m.hasMessages(-1)) {
            return;
        }
        this.f7185a.f7148m.sendEmptyMessageAtTime(-1, 0L);
    }
}
