package defpackage;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: classes.dex */
public class t {

    /* renamed from: k, reason: collision with root package name */
    private static final float[] f7502k;

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f7503l;

    /* renamed from: m, reason: collision with root package name */
    private static final FloatBuffer f7504m;

    /* renamed from: n, reason: collision with root package name */
    private static final FloatBuffer f7505n;

    /* renamed from: a, reason: collision with root package name */
    private float[] f7506a;

    /* renamed from: b, reason: collision with root package name */
    private float[] f7507b;

    /* renamed from: c, reason: collision with root package name */
    private int f7508c;

    /* renamed from: d, reason: collision with root package name */
    private int f7509d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private int f7510f;

    /* renamed from: g, reason: collision with root package name */
    private int f7511g;

    /* renamed from: h, reason: collision with root package name */
    private int f7512h;

    /* renamed from: i, reason: collision with root package name */
    private int f7513i;

    /* renamed from: j, reason: collision with root package name */
    private int f7514j;

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        f7502k = fArr;
        float[] fArr2 = {0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        f7503l = fArr2;
        f7504m = h.c(fArr);
        f7505n = h.c(fArr2);
    }

    public t(int i2, int i3) {
        this();
        this.f7513i = i2;
        this.f7514j = i3;
    }

    public static int c() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLES20.glTexParameteri(36197, 10241, 9728);
        GLES20.glTexParameteri(36197, 10240, 9728);
        return iArr[0];
    }

    public void a() {
        GLES20.glUseProgram(this.f7508c);
        GLES20.glEnableVertexAttribArray(this.f7511g);
        GLES20.glVertexAttribPointer(this.f7511g, 3, 5126, false, 12, (Buffer) f7504m);
        GLES20.glEnableVertexAttribArray(this.f7512h);
        GLES20.glVertexAttribPointer(this.f7512h, 4, 5126, false, 16, (Buffer) f7505n);
        Matrix.setIdentityM(this.f7506a, 0);
        GLES20.glUniformMatrix4fv(this.e, 1, false, this.f7506a, 0);
        GLES20.glUniformMatrix4fv(this.f7510f, 1, false, this.f7507b, 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f7511g);
        GLES20.glDisableVertexAttribArray(this.f7512h);
        GLES20.glUseProgram(0);
    }

    public int b() {
        return this.f7509d;
    }

    public void d() {
        int iB = h.b("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec4 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = uSTMatrix * aTextureCoord;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec4 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord.xy/vTextureCoord.z);}\n");
        this.f7508c = iB;
        if (iB == 0) {
            throw new RuntimeException("failed creating program");
        }
        this.f7511g = GLES20.glGetAttribLocation(iB, "aPosition");
        this.f7512h = GLES20.glGetAttribLocation(this.f7508c, "aTextureCoord");
        this.e = GLES20.glGetUniformLocation(this.f7508c, "uMVPMatrix");
        this.f7510f = GLES20.glGetUniformLocation(this.f7508c, "uSTMatrix");
        this.f7509d = c();
    }

    public t() {
        this.f7506a = new float[16];
        float[] fArr = new float[16];
        this.f7507b = fArr;
        this.f7509d = -12345;
        Matrix.setIdentityM(fArr, 0);
    }
}
