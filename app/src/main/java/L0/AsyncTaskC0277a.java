package l0;

import android.os.AsyncTask;
import h0.C0264e;
import java.io.File;
import java.util.ArrayList;

/* renamed from: l0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class AsyncTaskC0277a extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    private j0.d f6523a;

    /* renamed from: b, reason: collision with root package name */
    private String f6524b;

    public AsyncTaskC0277a(String str, j0.d dVar) {
        this.f6523a = dVar;
        this.f6524b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ArrayList doInBackground(Void... voidArr) {
        if (isCancelled()) {
            return null;
        }
        File file = new File(this.f6524b);
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                C0264e c0264e = new C0264e(file2);
                if (file2.isDirectory()) {
                    c0264e.m(true);
                } else {
                    c0264e.m(false);
                }
                if (file2.getName().indexOf(46) != 0) {
                    arrayList.add(c0264e);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(ArrayList arrayList) {
        super.onPostExecute(arrayList);
        this.f6523a.a(arrayList);
    }
}
