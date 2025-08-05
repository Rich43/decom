package W0;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes.dex */
public final class b implements MediaPlayer.OnErrorListener, Closeable {
    private static final String e = "b";

    /* renamed from: a, reason: collision with root package name */
    private final Activity f1024a;

    /* renamed from: b, reason: collision with root package name */
    private MediaPlayer f1025b = null;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1026c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1027d;

    b(Activity activity) {
        this.f1024a = activity;
        o();
    }

    private MediaPlayer j(Context context) throws Resources.NotFoundException, IOException {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = context.getResources().openRawResourceFd(n.f1105a);
            try {
                mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                mediaPlayer.setOnErrorListener(this);
                mediaPlayer.setAudioStreamType(3);
                mediaPlayer.setLooping(false);
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                assetFileDescriptorOpenRawResourceFd.close();
                return mediaPlayer;
            } finally {
            }
        } catch (IOException e2) {
            Log.w(e, e2);
            mediaPlayer.release();
            return null;
        }
    }

    private static boolean n(SharedPreferences sharedPreferences, Context context) {
        boolean z2 = sharedPreferences.getBoolean("preferences_play_beep", false);
        if (!z2 || ((AudioManager) context.getSystemService("audio")).getRingerMode() == 2) {
            return z2;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        MediaPlayer mediaPlayer = this.f1025b;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f1025b = null;
        }
    }

    synchronized void k() {
        MediaPlayer mediaPlayer;
        try {
            if (this.f1026c && (mediaPlayer = this.f1025b) != null) {
                mediaPlayer.start();
            }
            if (this.f1027d) {
                ((Vibrator) this.f1024a.getSystemService("vibrator")).vibrate(200L);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void l(boolean z2) {
        this.f1026c = z2;
    }

    public void m(boolean z2) {
        this.f1027d = z2;
    }

    synchronized void o() {
        n(PreferenceManager.getDefaultSharedPreferences(this.f1024a), this.f1024a);
        if (this.f1026c && this.f1025b == null) {
            this.f1024a.setVolumeControlStream(3);
            this.f1025b = j(this.f1024a);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public synchronized boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        try {
            if (i2 == 100) {
                this.f1024a.finish();
            } else {
                close();
                o();
            }
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }
}
