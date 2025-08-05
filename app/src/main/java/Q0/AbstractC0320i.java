package q0;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: q0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0320i {
    public static String a(String str, String str2) throws Throwable {
        String line = "";
        BufferedReader bufferedReader = null;
        try {
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Charset", Key.STRING_CHARSET_NAME);
                httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                httpURLConnection.setRequestProperty("accept", "application/json");
                if (str != null && !TextUtils.isEmpty(str)) {
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str.getBytes().length));
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(str.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }
                if (httpURLConnection.getResponseCode() == 200) {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    try {
                        line = bufferedReader2.readLine();
                        bufferedReader = bufferedReader2;
                    } catch (Exception e2) {
                        bufferedReader = bufferedReader2;
                        e = e2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return line;
                    } catch (Throwable th) {
                        bufferedReader = bufferedReader2;
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return line;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
