package com.caglobal.kodakluma.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.caglobal.kodakluma.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class AnimActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f4732a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f4733b = new a();

    /* renamed from: c, reason: collision with root package name */
    private RequestListener f4734c = new b();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            AnimActivity.this.setResult(1001, new Intent(AnimActivity.this, (Class<?>) MainActivity.class));
            AnimActivity.this.finish();
        }
    }

    class b implements RequestListener {
        b() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z2) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException {
            AnimActivity.this.d(drawable);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z2) {
            return false;
        }
    }

    private void b() {
        this.f4732a = (ImageView) findViewById(R.id.iv_anim_gif);
    }

    private void c() {
        Glide.with((Activity) this).load(Integer.valueOf(R.drawable.luma_anim)).apply(new RequestOptions().skipMemoryCache(true)).listener(this.f4734c).into(this.f4732a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Drawable drawable) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = GifDrawable.class.getDeclaredField("state");
            declaredField.setAccessible(true);
            Field declaredField2 = Class.forName("com.bumptech.glide.load.resource.gif.GifDrawable$GifState").getDeclaredField("frameLoader");
            declaredField2.setAccessible(true);
            Field declaredField3 = Class.forName("com.bumptech.glide.load.resource.gif.GifFrameLoader").getDeclaredField("gifDecoder");
            declaredField3.setAccessible(true);
            Object obj = declaredField3.get(declaredField2.get(declaredField.get(drawable)));
            Method declaredMethod = GifDecoder.class.getDeclaredMethod("getDelay", Integer.TYPE);
            declaredMethod.setAccessible(true);
            GifDrawable gifDrawable = (GifDrawable) drawable;
            gifDrawable.setLoopCount(1);
            int frameCount = gifDrawable.getFrameCount();
            int iIntValue = 0;
            for (int i2 = 0; i2 < frameCount; i2++) {
                iIntValue += ((Integer) declaredMethod.invoke(obj, Integer.valueOf(i2))).intValue();
            }
            this.f4733b.sendEmptyMessageDelayed(1, iIntValue + 1000);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_anim);
        b();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f4733b.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        c();
    }
}
