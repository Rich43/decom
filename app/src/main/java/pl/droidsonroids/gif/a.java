package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.MediaController;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class a extends Drawable implements Animatable, MediaController.MediaPlayerControl {

    /* renamed from: a */
    final ScheduledThreadPoolExecutor f7137a;

    /* renamed from: b */
    volatile boolean f7138b;

    /* renamed from: c */
    long f7139c;

    /* renamed from: d */
    private final Rect f7140d;
    protected final Paint e;

    /* renamed from: f */
    final Bitmap f7141f;

    /* renamed from: g */
    final GifInfoHandle f7142g;

    /* renamed from: h */
    final ConcurrentLinkedQueue f7143h;

    /* renamed from: i */
    private ColorStateList f7144i;

    /* renamed from: j */
    private PorterDuffColorFilter f7145j;

    /* renamed from: k */
    private PorterDuff.Mode f7146k;

    /* renamed from: l */
    final boolean f7147l;

    /* renamed from: m */
    final f f7148m;

    /* renamed from: n */
    private final i f7149n;
    private final Rect o;

    /* renamed from: p */
    ScheduledFuture f7150p;

    /* renamed from: q */
    private int f7151q;
    private int r;

    /* renamed from: pl.droidsonroids.gif.a$a */
    class C0099a extends j {
        C0099a(a aVar) {
            super(aVar);
        }

        @Override // pl.droidsonroids.gif.j
        public void a() {
            if (a.this.f7142g.p()) {
                a.this.start();
            }
        }
    }

    class b extends j {

        /* renamed from: b */
        final /* synthetic */ int f7153b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a aVar, int i2) {
            super(aVar);
            this.f7153b = i2;
        }

        @Override // pl.droidsonroids.gif.j
        public void a() {
            a aVar = a.this;
            aVar.f7142g.t(this.f7153b, aVar.f7141f);
            this.f7185a.f7148m.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    public a(Resources resources, int i2) {
        this(resources.openRawResourceFd(i2));
        float fA = e.a(resources, i2);
        this.r = (int) (this.f7142g.e() * fA);
        this.f7151q = (int) (this.f7142g.j() * fA);
    }

    private void a() {
        ScheduledFuture scheduledFuture = this.f7150p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f7148m.removeMessages(-1);
    }

    private void g() {
        this.f7138b = false;
        this.f7148m.removeMessages(-1);
        this.f7142g.n();
    }

    private PorterDuffColorFilter i(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public int b() {
        return this.f7142g.a();
    }

    public int c() {
        int iB = this.f7142g.b();
        return (iB == 0 || iB < this.f7142g.f()) ? iB : iB - 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return d() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return d() > 1;
    }

    public int d() {
        return this.f7142g.h();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z2;
        if (this.f7145j == null || this.e.getColorFilter() != null) {
            z2 = false;
        } else {
            this.e.setColorFilter(this.f7145j);
            z2 = true;
        }
        canvas.drawBitmap(this.f7141f, this.o, this.f7140d, this.e);
        if (z2) {
            this.e.setColorFilter(null);
        }
        if (this.f7147l && this.f7138b) {
            long j2 = this.f7139c;
            if (j2 != Long.MIN_VALUE) {
                long jMax = Math.max(0L, j2 - SystemClock.uptimeMillis());
                this.f7139c = Long.MIN_VALUE;
                this.f7137a.remove(this.f7149n);
                this.f7150p = this.f7137a.schedule(this.f7149n, jMax, TimeUnit.MILLISECONDS);
            }
        }
    }

    public boolean e() {
        return this.f7142g.l();
    }

    public void f() {
        this.f7137a.execute(new C0099a(this));
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.e.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.f7142g.c();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.f7142g.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f7151q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (!this.f7142g.k() || this.e.getAlpha() < 255) ? -2 : -1;
    }

    void h(long j2) {
        if (this.f7147l) {
            this.f7139c = 0L;
            this.f7148m.sendEmptyMessageAtTime(-1, 0L);
        } else {
            a();
            this.f7150p = this.f7137a.schedule(this.f7149n, Math.max(j2, 0L), TimeUnit.MILLISECONDS);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.f7138b;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f7138b;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        return super.isStateful() || ((colorStateList = this.f7144i) != null && colorStateList.isStateful());
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f7140d.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f7144i;
        if (colorStateList == null || (mode = this.f7146k) == null) {
            return false;
        }
        this.f7145j = i(colorStateList, mode);
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        this.f7137a.execute(new b(this, i2));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.e.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.e.setDither(z2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.e.setFilterBitmap(z2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f7144i = colorStateList;
        this.f7145j = i(colorStateList, this.f7146k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f7146k = mode;
        this.f7145j = i(this.f7144i, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (!this.f7147l) {
            if (z2) {
                if (z3) {
                    f();
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public void start() {
        synchronized (this) {
            try {
                if (this.f7138b) {
                    return;
                }
                this.f7138b = true;
                h(this.f7142g.q());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this) {
            try {
                if (this.f7138b) {
                    this.f7138b = false;
                    a();
                    this.f7142g.s();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.f7142g.j()), Integer.valueOf(this.f7142g.e()), Integer.valueOf(this.f7142g.h()), Integer.valueOf(this.f7142g.g()));
    }

    public a(AssetFileDescriptor assetFileDescriptor) {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public a(ContentResolver contentResolver, Uri uri) {
        this(GifInfoHandle.m(contentResolver, uri), null, null, true);
    }

    a(GifInfoHandle gifInfoHandle, a aVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z2) {
        this.f7138b = true;
        this.f7139c = Long.MIN_VALUE;
        this.f7140d = new Rect();
        this.e = new Paint(6);
        this.f7143h = new ConcurrentLinkedQueue();
        i iVar = new i(this);
        this.f7149n = iVar;
        this.f7147l = z2;
        this.f7137a = scheduledThreadPoolExecutor == null ? c.c() : scheduledThreadPoolExecutor;
        this.f7142g = gifInfoHandle;
        Bitmap bitmap = null;
        if (aVar != null) {
            synchronized (aVar.f7142g) {
                try {
                    if (!aVar.f7142g.l() && aVar.f7142g.e() >= gifInfoHandle.e() && aVar.f7142g.j() >= gifInfoHandle.j()) {
                        aVar.g();
                        bitmap = aVar.f7141f;
                        bitmap.eraseColor(0);
                    }
                } finally {
                }
            }
        }
        if (bitmap == null) {
            this.f7141f = Bitmap.createBitmap(gifInfoHandle.j(), gifInfoHandle.e(), Bitmap.Config.ARGB_8888);
        } else {
            this.f7141f = bitmap;
        }
        this.f7141f.setHasAlpha(!gifInfoHandle.k());
        this.o = new Rect(0, 0, gifInfoHandle.j(), gifInfoHandle.e());
        this.f7148m = new f(this);
        iVar.a();
        this.f7151q = gifInfoHandle.j();
        this.r = gifInfoHandle.e();
    }
}
