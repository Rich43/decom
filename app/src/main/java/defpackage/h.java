package defpackage;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final float[] f6353a;

    static {
        float[] fArr = new float[16];
        f6353a = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public static int a(int i2, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i2);
        d("glCreateShader type=" + i2);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        Log.e("EncodeDecodeSurface", "Could not compile shader " + i2 + ":");
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(GLES20.glGetShaderInfoLog(iGlCreateShader));
        Log.e("EncodeDecodeSurface", sb.toString());
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static int b(String str, String str2) {
        int iA;
        int iA2 = a(35633, str);
        if (iA2 == 0 || (iA = a(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        d("glCreateProgram");
        if (iGlCreateProgram == 0) {
            Log.e("EncodeDecodeSurface", "Could not create program");
        }
        GLES20.glAttachShader(iGlCreateProgram, iA2);
        d("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iA);
        d("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        Log.e("EncodeDecodeSurface", "Could not link program: ");
        Log.e("EncodeDecodeSurface", GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    public static FloatBuffer c(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    public static void d(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        String str2 = str + ": glError 0x" + Integer.toHexString(iGlGetError);
        Log.e("EncodeDecodeSurface", str2);
        throw new RuntimeException(str2);
    }
}
