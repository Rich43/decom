package u;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import u.h;

/* loaded from: classes.dex */
abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator f7523a = new Comparator() { // from class: u.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return e.g((byte[]) obj, (byte[]) obj2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    interface a {
        Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        private final ContentProviderClient f7524a;

        b(Context context, Uri uri) {
            this.f7524a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // u.e.a
        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f7524a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        @Override // u.e.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f7524a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements a {

        /* renamed from: a, reason: collision with root package name */
        private final ContentProviderClient f7525a;

        c(Context context, Uri uri) {
            this.f7525a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // u.e.a
        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f7525a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        @Override // u.e.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f7525a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    private static List b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals((byte[]) list.get(i2), (byte[]) list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private static List d(f fVar, Resources resources) {
        return fVar.b() != null ? fVar.b() : androidx.core.content.res.e.c(resources, fVar.c());
    }

    static h.a e(Context context, f fVar, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoF = f(context.getPackageManager(), fVar, context.getResources());
        return providerInfoF == null ? h.a.a(1, null) : h.a.a(0, h(context, fVar, providerInfoF.authority, cancellationSignal));
    }

    static ProviderInfo f(PackageManager packageManager, f fVar, Resources resources) throws PackageManager.NameNotFoundException {
        String strE = fVar.e();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strE, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strE);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(fVar.f())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strE + ", but package was not " + fVar.f());
        }
        List listB = b(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listB, f7523a);
        List listD = d(fVar, resources);
        for (int i2 = 0; i2 < listD.size(); i2++) {
            ArrayList arrayList = new ArrayList((Collection) listD.get(i2));
            Collections.sort(arrayList, f7523a);
            if (c(listB, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            byte b3 = bArr2[i2];
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static u.h.b[] h(android.content.Context r16, u.f r17, java.lang.String r18, android.os.CancellationSignal r19) {
        /*
            r0 = r18
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            java.lang.String r3 = "content"
            android.net.Uri$Builder r2 = r2.scheme(r3)
            android.net.Uri$Builder r2 = r2.authority(r0)
            android.net.Uri r2 = r2.build()
            android.net.Uri$Builder r4 = new android.net.Uri$Builder
            r4.<init>()
            android.net.Uri$Builder r3 = r4.scheme(r3)
            android.net.Uri$Builder r0 = r3.authority(r0)
            java.lang.String r3 = "file"
            android.net.Uri$Builder r0 = r0.appendPath(r3)
            android.net.Uri r0 = r0.build()
            r3 = r16
            u.e$a r3 = u.d.a(r3, r2)
            r11 = 0
            java.lang.String r4 = "_id"
            java.lang.String r5 = "file_id"
            java.lang.String r6 = "font_ttc_index"
            java.lang.String r7 = "font_variation_settings"
            java.lang.String r8 = "font_weight"
            java.lang.String r9 = "font_italic"
            java.lang.String r10 = "result_code"
            java.lang.String[] r6 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10}     // Catch: java.lang.Throwable -> L9c
            java.lang.String r7 = "query = ?"
            java.lang.String r4 = r17.g()     // Catch: java.lang.Throwable -> L9c
            java.lang.String[] r8 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L9c
            r9 = 0
            r4 = r3
            r5 = r2
            r10 = r19
            android.database.Cursor r11 = r4.a(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L9c
            if (r11 == 0) goto Ldd
            int r5 = r11.getCount()     // Catch: java.lang.Throwable -> L9c
            if (r5 <= 0) goto Ldd
            java.lang.String r1 = "result_code"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L9c
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L9c
            r5.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r6 = "_id"
            int r6 = r11.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r7 = "file_id"
            int r7 = r11.getColumnIndex(r7)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r8 = "font_ttc_index"
            int r8 = r11.getColumnIndex(r8)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r9 = "font_weight"
            int r9 = r11.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r10 = "font_italic"
            int r10 = r11.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L9c
        L8e:
            boolean r12 = r11.moveToNext()     // Catch: java.lang.Throwable -> L9c
            if (r12 == 0) goto Ldc
            r12 = -1
            if (r1 == r12) goto L9e
            int r13 = r11.getInt(r1)     // Catch: java.lang.Throwable -> L9c
            goto L9f
        L9c:
            r0 = move-exception
            goto Lef
        L9e:
            r13 = 0
        L9f:
            if (r8 == r12) goto La6
            int r14 = r11.getInt(r8)     // Catch: java.lang.Throwable -> L9c
            goto La7
        La6:
            r14 = 0
        La7:
            if (r7 != r12) goto Lb4
            r17 = r5
            long r4 = r11.getLong(r6)     // Catch: java.lang.Throwable -> L9c
            android.net.Uri r4 = android.content.ContentUris.withAppendedId(r2, r4)     // Catch: java.lang.Throwable -> L9c
            goto Lbe
        Lb4:
            r17 = r5
            long r4 = r11.getLong(r7)     // Catch: java.lang.Throwable -> L9c
            android.net.Uri r4 = android.content.ContentUris.withAppendedId(r0, r4)     // Catch: java.lang.Throwable -> L9c
        Lbe:
            if (r9 == r12) goto Lc5
            int r5 = r11.getInt(r9)     // Catch: java.lang.Throwable -> L9c
            goto Lc7
        Lc5:
            r5 = 400(0x190, float:5.6E-43)
        Lc7:
            if (r10 == r12) goto Ld1
            int r12 = r11.getInt(r10)     // Catch: java.lang.Throwable -> L9c
            r15 = 1
            if (r12 != r15) goto Ld1
            goto Ld2
        Ld1:
            r15 = 0
        Ld2:
            u.h$b r4 = u.h.b.a(r4, r14, r5, r15, r13)     // Catch: java.lang.Throwable -> L9c
            r5 = r17
            r5.add(r4)     // Catch: java.lang.Throwable -> L9c
            goto L8e
        Ldc:
            r1 = r5
        Ldd:
            if (r11 == 0) goto Le2
            r11.close()
        Le2:
            r3.close()
            r0 = 0
            u.h$b[] r0 = new u.h.b[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            u.h$b[] r0 = (u.h.b[]) r0
            return r0
        Lef:
            if (r11 == 0) goto Lf4
            r11.close()
        Lf4:
            r3.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u.e.h(android.content.Context, u.f, java.lang.String, android.os.CancellationSignal):u.h$b[]");
    }
}
