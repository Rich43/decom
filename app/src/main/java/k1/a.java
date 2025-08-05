package k1;

import java.util.Random;

/* loaded from: classes.dex */
public abstract class a extends c {
    @Override // k1.c
    public int b(int i2) {
        return c().nextInt(i2);
    }

    public abstract Random c();
}
