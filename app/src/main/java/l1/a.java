package l1;

import i1.k;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: classes.dex */
public final class a extends k1.a {
    @Override // k1.a
    public Random c() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        k.d(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
