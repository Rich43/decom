package androidx.loader.app;

import androidx.lifecycle.J;
import androidx.lifecycle.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class a {
    public static a b(m mVar) {
        return new b(mVar, ((J) mVar).getViewModelStore());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
