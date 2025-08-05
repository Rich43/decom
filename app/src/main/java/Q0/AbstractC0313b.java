package q0;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Patterns;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* renamed from: q0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0313b {
    public static String a(String str) {
        ArrayList arrayListD = d();
        ArrayList arrayList = new ArrayList();
        String upperCase = str.toUpperCase();
        int length = upperCase.length();
        for (int i2 = 0; i2 < length; i2++) {
            int iIndexOf = arrayListD.indexOf(String.valueOf(upperCase.charAt(i2)));
            if (iIndexOf == -1) {
                return "error";
            }
            arrayList.add(Integer.valueOf(iIndexOf));
        }
        int size = arrayList.size();
        long jIntValue = 0;
        for (int i3 = 0; i3 < size; i3++) {
            jIntValue += ((Integer) arrayList.get(i3)).intValue() * c(size - i3);
        }
        long j2 = (208827064575L - jIntValue) % 4294967296L;
        return String.format("%d.%d.%d.%d", Long.valueOf(j2 / 16777216), Long.valueOf((j2 % 16777216) / PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH), Long.valueOf((j2 % PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) / 256), Long.valueOf(j2 % 256));
    }

    public static String b(long j2) {
        if (j2 < 0) {
            return "00:00";
        }
        SimpleDateFormat simpleDateFormat = j2 >= 3600000 ? new SimpleDateFormat("H:mm:ss") : new SimpleDateFormat("m:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(Long.valueOf(j2));
    }

    static long c(int i2) {
        long j2 = 1;
        for (int i3 = 1; i3 < i2; i3++) {
            j2 *= 26;
        }
        return j2;
    }

    public static ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 26; i2++) {
            arrayList.add(String.valueOf((char) (i2 + 65)));
        }
        return arrayList;
    }

    public static String e(String str) {
        return f(str, System.currentTimeMillis());
    }

    public static String f(String str, long j2) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(Long.valueOf(j2));
    }

    public static String g(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        int ipAddress = connectionInfo.getIpAddress();
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (ipAddress & 255), (byte) ((ipAddress >> 8) & 255), (byte) ((ipAddress >> 16) & 255), (byte) ((ipAddress >> 24) & 255)}).getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map h(android.content.Context r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            r0 = 0
            boolean r1 = android.text.TextUtils.isDigitsOnly(r6)
            java.lang.String r2 = ""
            r3 = 1
            if (r1 == 0) goto L19
            int r1 = r6.length()
            r4 = 6
            if (r1 != r4) goto L17
            java.lang.String r5 = i(r5, r6)
        L15:
            r6 = 1
            goto L31
        L17:
            r5 = r2
            goto L15
        L19:
            boolean r5 = j(r6)
            if (r5 == 0) goto L24
            java.lang.String r5 = a(r6)
            goto L15
        L24:
            java.lang.String r5 = "http://"
            java.lang.String r5 = r6.replace(r5, r2)
            java.lang.String r6 = "https://"
            java.lang.String r5 = r5.replace(r6, r2)
            r6 = 0
        L31:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "decode ip="
            r1.append(r4)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r0] = r1
            q0.k.a(r3)
            boolean r0 = m(r5)
            if (r0 != 0) goto L50
            goto L51
        L50:
            r2 = r5
        L51:
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r0 = "key_decode_ip"
            r5.put(r0, r2)
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.String r0 = "key_decode_is_pin"
            r5.put(r0, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.AbstractC0313b.h(android.content.Context, java.lang.String):java.util.Map");
    }

    public static String i(Context context, String str) throws Throwable {
        int iIntValue = 999999 - Integer.valueOf(str).intValue();
        int i2 = (iIntValue % ArrayPool.STANDARD_BUFFER_SIZE_BYTES) / 256;
        int i3 = iIntValue % 256;
        int ipAddress = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress();
        int i4 = ipAddress & 255;
        int i5 = (ipAddress >> 8) & 255;
        k.a("ipDecode", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3));
        return String.format("%d.%d.%d.%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static boolean j(String str) {
        return Pattern.matches("[a-zA-Z]+", str);
    }

    public static boolean k(Context context, String str) {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningServices(50).iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean l(long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())).equals(simpleDateFormat.format(Long.valueOf(j2)));
    }

    public static boolean m(String str) {
        return Patterns.IP_ADDRESS.matcher(str).matches();
    }

    public static boolean n(long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            long time = simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()))).getTime();
            return time > j2 && time - j2 < 86400000;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Map o(String str) {
        HashMap map = new HashMap();
        int i2 = 0;
        if (!str.startsWith("http://")) {
            map.put("key_qr_type", 0);
        } else if (m(str.replace("http://", ""))) {
            map.put("key_qr_type", 1);
            map.put("key_qr_ip", str.replace("http://", ""));
        } else {
            String strReplace = str.replace("http://", "");
            String[] strArrSplit = strReplace.split(":");
            if (strArrSplit.length < 1) {
                map.put("key_qr_type", 0);
            } else if (m(strArrSplit[0])) {
                map.put("key_qr_ip", strArrSplit[0]);
                if (strArrSplit[1].length() == 4) {
                    map.put("key_qr_type", 1);
                } else if (strArrSplit[1].contains("wifi_password=")) {
                    map.put("key_qr_type", 3);
                    String str2 = strArrSplit[1];
                    map.put("key_qr_wifi_psw", str2.substring(str2.indexOf("wifi_password=") + 14));
                    String[] strArrSplit2 = strArrSplit[1].split("&");
                    int length = strArrSplit2.length;
                    while (i2 < length) {
                        String str3 = strArrSplit2[i2];
                        if (str3.contains("ssid=")) {
                            map.put("key_qr_wifi_ssid", str3.substring(str3.indexOf("ssid=") + 5));
                        } else if (str3.contains("pincode=")) {
                            map.put("key_qr_pin", str3.substring(str3.indexOf("pincode=") + 8));
                        }
                        i2++;
                    }
                } else if (strArrSplit[1].contains("pincode=")) {
                    map.put("key_qr_type", 2);
                    String str4 = strArrSplit[1];
                    map.put("key_qr_pin", str4.substring(str4.indexOf("pinCode=") + 8));
                } else {
                    map.put("key_qr_type", 0);
                }
            } else {
                String strSubstring = strReplace.substring(strReplace.indexOf("?") + 1);
                if (TextUtils.isEmpty(strSubstring)) {
                    map.put("key_qr_type", 0);
                } else {
                    String[] strArrSplit3 = strSubstring.split(":");
                    if (m(strArrSplit3[0])) {
                        map.put("key_qr_type", 2);
                        map.put("key_qr_ip", strArrSplit3[0]);
                        String[] strArrSplit4 = strArrSplit3[1].split("&");
                        int length2 = strArrSplit4.length;
                        while (true) {
                            if (i2 >= length2) {
                                break;
                            }
                            String str5 = strArrSplit4[i2];
                            if (str5.contains("pincode=")) {
                                map.put("key_qr_pin", str5.substring(str5.indexOf("pincode=") + 8));
                                break;
                            }
                            i2++;
                        }
                    } else {
                        map.put("key_qr_type", 0);
                    }
                }
            }
        }
        return map;
    }
}
