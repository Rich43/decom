package l0;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.eshare.api.IDevice;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import h0.C0263d;
import h0.h;
import h0.i;
import h0.j;
import h0.k;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import q0.C0317f;
import q0.C0318g;

/* renamed from: l0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0281e extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public long f6538a;

    /* renamed from: b, reason: collision with root package name */
    public long f6539b;

    /* renamed from: c, reason: collision with root package name */
    public long f6540c;

    /* renamed from: d, reason: collision with root package name */
    public long f6541d;
    public long e;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f6546j;

    /* renamed from: k, reason: collision with root package name */
    private a f6547k;

    /* renamed from: l, reason: collision with root package name */
    private IDevice f6548l;

    /* renamed from: f, reason: collision with root package name */
    public long f6542f = 350;

    /* renamed from: g, reason: collision with root package name */
    private int f6543g = -2;

    /* renamed from: h, reason: collision with root package name */
    private int f6544h = -2;

    /* renamed from: i, reason: collision with root package name */
    private int f6545i = 0;

    /* renamed from: m, reason: collision with root package name */
    private Gson f6549m = new Gson();

    /* renamed from: l0.e$a */
    public interface a {
        void a();

        void b();

        void c();

        void d(int i2);

        void e(String str);

        void f(boolean z2);

        void g(List list);
    }

    public C0281e(IDevice iDevice, a aVar) {
        this.f6548l = iDevice;
        this.f6547k = aVar;
    }

    private void a(String str) {
        for (String str2 : new String(str.getBytes(Key.STRING_CHARSET_NAME), Key.STRING_CHARSET_NAME).split(System.lineSeparator())) {
            JsonObject asJsonObject = new JsonParser().parse(str2.trim()).getAsJsonObject();
            C0318g.a().b("obj： " + asJsonObject);
            if (asJsonObject.has("replyHeartbeat")) {
                c(asJsonObject);
            } else if (asJsonObject.has("disconnectClient")) {
                if (System.currentTimeMillis() - this.f6539b < this.f6542f) {
                    return;
                } else {
                    b();
                }
            } else if (asJsonObject.has("replyCastRequest")) {
                s1.c.c().l(new h0.f(asJsonObject.get("replyCastRequest").getAsInt()));
            } else if (asJsonObject.has("addModerator")) {
                if (System.currentTimeMillis() - this.f6540c < this.f6542f) {
                    return;
                }
                this.f6540c = System.currentTimeMillis();
                this.f6547k.f(true);
            } else if (asJsonObject.has("removeModerator")) {
                if (System.currentTimeMillis() - this.f6540c < this.f6542f) {
                    return;
                }
                this.f6540c = System.currentTimeMillis();
                this.f6547k.f(false);
            } else if (asJsonObject.has("inviteCast")) {
                if (System.currentTimeMillis() - this.e < this.f6542f) {
                    return;
                }
                this.e = System.currentTimeMillis();
                this.f6547k.e(asJsonObject.get("inviteCast").getAsString());
                s1.c.c().l(new C0317f(1000, asJsonObject.get("inviteCast").getAsString()));
            } else if (asJsonObject.has("cancelCastInvite")) {
                this.f6547k.c();
                s1.c.c().l(new C0317f(1001, null));
            } else if (asJsonObject.has("reportInfo")) {
                k kVar = new k();
                if (asJsonObject.has("deviceName")) {
                    kVar.b(asJsonObject.get("deviceName").getAsString());
                }
                if (asJsonObject.has("features")) {
                    kVar.c(asJsonObject.get("features").getAsString());
                }
                s1.c.c().l(kVar);
                this.f6548l.reportInfo();
            } else if (asJsonObject.has("clientList")) {
                if (System.currentTimeMillis() - this.f6538a >= this.f6542f) {
                    this.f6538a = System.currentTimeMillis();
                    this.f6547k.g(Arrays.asList((C0263d[]) this.f6549m.fromJson(asJsonObject.get("clientList"), C0263d[].class)));
                }
            } else if (asJsonObject.has("transferHost")) {
                if (System.currentTimeMillis() - this.f6541d < this.f6542f) {
                    return;
                }
                this.f6541d = System.currentTimeMillis();
                this.f6547k.b();
            } else if (asJsonObject.has("requestCastClient")) {
                String asString = asJsonObject.get("requestCastClient").getAsString();
                String asString2 = asJsonObject.get("clientIP").getAsString();
                s1.c.c().l(asJsonObject.has("castType") ? new i(asString, asString2, asJsonObject.get("castType").getAsInt()) : new i(asString, asString2, 0));
            } else if (asJsonObject.has("allowClientCast")) {
                s1.c.c().l(new j());
            }
        }
    }

    private void b() {
        this.f6539b = System.currentTimeMillis();
        h0.g gVar = new h0.g();
        gVar.b(h0.g.f6395b);
        s1.c.c().l(gVar);
    }

    private void c(JsonObject jsonObject) {
        h hVar = new h();
        if (jsonObject.has("castMode")) {
            hVar.e(jsonObject.get("castMode").getAsInt());
        }
        if (jsonObject.has("mirrorMode")) {
            hVar.g(jsonObject.get("mirrorMode").getAsInt());
        }
        boolean z2 = false;
        if (jsonObject.has("multiScreen")) {
            int asInt = jsonObject.get("multiScreen").getAsInt();
            if (this.f6544h != asInt) {
                this.f6544h = asInt;
                z2 = true;
            }
            hVar.h(asInt);
        }
        if (jsonObject.has("castState")) {
            int asInt2 = jsonObject.get("castState").getAsInt();
            if (this.f6543g != asInt2 || z2) {
                this.f6543g = asInt2;
                this.f6547k.d(asInt2);
            }
            hVar.f(asInt2);
        }
        s1.c.c().l(hVar);
    }

    public void d() {
        this.f6546j = true;
        start();
    }

    public void e() {
        this.f6546j = false;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException {
        a aVar;
        C0318g.a().b("HostHeartBeatThread  running...  isRunning:" + this.f6546j + " hostHeartbeatCount:" + this.f6545i);
        long jCurrentTimeMillis = 0;
        while (true) {
            int i2 = 0;
            while (this.f6546j) {
                if (System.currentTimeMillis() - jCurrentTimeMillis >= 1000) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    int i3 = this.f6545i;
                    if (i3 < Integer.MAX_VALUE) {
                        this.f6545i = i3 + 1;
                    } else {
                        this.f6545i = 0;
                    }
                    String strHostHeartBeat = this.f6548l.hostHeartBeat(this.f6545i);
                    C0318g.a().b("result： " + strHostHeartBeat);
                    if (TextUtils.isEmpty(strHostHeartBeat)) {
                        i2++;
                        if (i2 == 20 && (aVar = this.f6547k) != null) {
                            aVar.a();
                        }
                    } else {
                        try {
                            a(strHostHeartBeat);
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return;
        }
    }
}
