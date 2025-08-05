package Z;

import Q.d;
import Q.e;
import Q.j;
import android.content.Context;
import c0.f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.zip.ZipInputStream;
import v.C0341d;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private final Context f1363a;

    /* renamed from: b */
    private final String f1364b;

    /* renamed from: c */
    private final b f1365c;

    private c(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f1363a = applicationContext;
        this.f1364b = str;
        this.f1365c = new b(applicationContext, str);
    }

    private d a() {
        C0341d c0341dA = this.f1365c.a();
        if (c0341dA == null) {
            return null;
        }
        a aVar = (a) c0341dA.f7671a;
        InputStream inputStream = (InputStream) c0341dA.f7672b;
        j jVarN = aVar == a.ZIP ? e.n(new ZipInputStream(inputStream), this.f1364b) : e.f(inputStream, this.f1364b);
        if (jVarN.b() != null) {
            return (d) jVarN.b();
        }
        return null;
    }

    private j b() {
        try {
            return c();
        } catch (IOException e) {
            return new j((Throwable) e);
        }
    }

    private j c() throws ProtocolException {
        f.a("Fetching " + this.f1364b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1364b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                j jVarG = g(httpURLConnection);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(jVarG.b() != null);
                f.a(sb.toString());
                return jVarG;
            }
            return new j((Throwable) new IllegalArgumentException("Unable to fetch " + this.f1364b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + f(httpURLConnection)));
        } catch (Exception e) {
            return new j((Throwable) e);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static j e(Context context, String str) {
        return new c(context, str).d();
    }

    private String f(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private Q.j g(java.net.HttpURLConnection r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getContentType()
            java.lang.String r1 = "application/json"
            if (r0 != 0) goto L9
            r0 = r1
        L9:
            int r2 = r0.hashCode()
            r3 = -1248325150(0xffffffffb59811e2, float:-1.1330087E-6)
            if (r2 == r3) goto L1d
            r3 = -43840953(0xfffffffffd630a47, float:-1.8861757E37)
            if (r2 == r3) goto L18
            goto L47
        L18:
            boolean r0 = r0.equals(r1)
            goto L47
        L1d:
            java.lang.String r1 = "application/zip"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L47
            java.lang.String r0 = "Handling zip response."
            c0.f.a(r0)
            Z.a r0 = Z.a.ZIP
            Z.b r1 = r4.f1365c
            java.io.InputStream r5 = r5.getInputStream()
            java.io.File r5 = r1.e(r5, r0)
            java.util.zip.ZipInputStream r1 = new java.util.zip.ZipInputStream
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r2.<init>(r5)
            r1.<init>(r2)
            java.lang.String r5 = r4.f1364b
            Q.j r5 = Q.e.n(r1, r5)
            goto L6c
        L47:
            java.lang.String r0 = "Received json response."
            c0.f.a(r0)
            Z.a r0 = Z.a.JSON
            Z.b r1 = r4.f1365c
            java.io.InputStream r5 = r5.getInputStream()
            java.io.File r5 = r1.e(r5, r0)
            java.io.FileInputStream r1 = new java.io.FileInputStream
            java.io.File r2 = new java.io.File
            java.lang.String r5 = r5.getAbsolutePath()
            r2.<init>(r5)
            r1.<init>(r2)
            java.lang.String r5 = r4.f1364b
            Q.j r5 = Q.e.f(r1, r5)
        L6c:
            java.lang.Object r1 = r5.b()
            if (r1 == 0) goto L77
            Z.b r1 = r4.f1365c
            r1.d(r0)
        L77:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: Z.c.g(java.net.HttpURLConnection):Q.j");
    }

    public j d() {
        d dVarA = a();
        if (dVarA != null) {
            return new j(dVarA);
        }
        f.a("Animation for " + this.f1364b + " not found in cache. Fetching from network.");
        return b();
    }
}
