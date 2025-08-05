package com.caglobal.kodakluma.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.view.PinchImageView;
import com.eshare.api.EShareAPI;
import com.eshare.api.IMedia;
import h0.m;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p0.C0308c;
import q0.AbstractC0319h;

/* loaded from: classes.dex */
public class ImageActivity extends com.caglobal.kodakluma.activity.a {

    /* renamed from: W, reason: collision with root package name */
    private ViewPager f4858W;

    /* renamed from: X, reason: collision with root package name */
    private ViewGroup f4859X;

    /* renamed from: Y, reason: collision with root package name */
    private TextView f4860Y;

    /* renamed from: Z, reason: collision with root package name */
    private RelativeLayout f4861Z;

    /* renamed from: a0, reason: collision with root package name */
    private ImageButton f4862a0;

    /* renamed from: b0, reason: collision with root package name */
    private i f4863b0;

    /* renamed from: c0, reason: collision with root package name */
    private List f4864c0;

    /* renamed from: d0, reason: collision with root package name */
    private IMedia f4865d0;

    /* renamed from: e0, reason: collision with root package name */
    private ExecutorService f4866e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f4867f0;

    /* renamed from: g0, reason: collision with root package name */
    private Matrix f4868g0;

    /* renamed from: h0, reason: collision with root package name */
    private RectF f4869h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f4870i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f4871j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f4872k0;

    /* renamed from: T, reason: collision with root package name */
    private final int f4855T = 0;

    /* renamed from: U, reason: collision with root package name */
    private final int f4856U = 1;

    /* renamed from: V, reason: collision with root package name */
    private final long f4857V = 5000;

    /* renamed from: l0, reason: collision with root package name */
    private Handler f4873l0 = new a();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            int i2 = message.what;
            if (i2 == 0) {
                ImageActivity.this.f4867f0++;
                if (ImageActivity.this.f4867f0 > ImageActivity.this.f4864c0.size()) {
                    ImageActivity.this.f4867f0 = 0;
                }
                ImageActivity.this.f4858W.setCurrentItem(ImageActivity.this.f4867f0);
                ImageActivity.this.f4873l0.sendEmptyMessageDelayed(0, 5000L);
            } else if (i2 == 1) {
                ImageActivity.this.Z1();
            }
            super.handleMessage(message);
        }
    }

    class b extends ViewPager.l {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.l, androidx.viewpager.widget.ViewPager.i
        public void a(int i2, float f2, int i3) {
            View viewFindViewWithTag = ImageActivity.this.f4858W.findViewWithTag(Integer.valueOf(ImageActivity.this.f4867f0));
            if ((viewFindViewWithTag instanceof PinchImageView) && ImageActivity.this.f4870i0 > 0) {
                viewFindViewWithTag.setRotation(0.0f);
            }
            super.a(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.l, androidx.viewpager.widget.ViewPager.i
        public void b(int i2) {
            ImageActivity.this.f4871j0 = i2;
            super.b(i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void c(int i2) {
            View viewFindViewWithTag = ImageActivity.this.f4858W.findViewWithTag(Integer.valueOf(ImageActivity.this.f4867f0));
            if (viewFindViewWithTag instanceof PinchImageView) {
                ((PinchImageView) viewFindViewWithTag).t();
            }
            ImageActivity.this.f4867f0 = i2;
            ImageActivity.this.b2(i2);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageActivity.this.f4865d0.closeImage();
        }
    }

    class d implements FileFilter {
        d() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return AbstractC0319h.g(file);
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f4878a;

        e(File file) {
            this.f4878a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageActivity.this.f4860Y.setText(this.f4878a.getName());
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f4880a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f4881b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ File f4882c;

        f(File file, File file2, File file3) {
            this.f4880a = file;
            this.f4881b = file2;
            this.f4882c = file3;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageActivity.this.f4865d0.openImages(this.f4880a, this.f4881b, this.f4882c);
        }
    }

    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ImageActivity.this.f4861Z.setVisibility(4);
        }
    }

    class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ImageActivity.this.f4859X.setVisibility(4);
        }
    }

    class i extends androidx.viewpager.widget.a {

        /* renamed from: c, reason: collision with root package name */
        private PinchImageView f4886c;

        class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0 || !ImageActivity.this.f4873l0.hasMessages(0)) {
                    return true;
                }
                ImageActivity.this.f4873l0.removeCallbacksAndMessages(null);
                ImageActivity.this.f4862a0.setBackgroundResource(R.drawable.image_play);
                return true;
            }
        }

        i() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return ImageActivity.this.f4864c0.size();
        }

        @Override // androidx.viewpager.widget.a
        public Object g(ViewGroup viewGroup, int i2) {
            PinchImageView pinchImageView = (PinchImageView) View.inflate(ImageActivity.this, R.layout.item_image, null);
            this.f4886c = pinchImageView;
            pinchImageView.setTag(Integer.valueOf(i2));
            this.f4886c.setImageBitmap(AbstractC0319h.e(((m) ImageActivity.this.f4864c0.get(i2)).c(), 1280, 720));
            this.f4886c.setOnTouchListener(new a());
            viewGroup.addView(this.f4886c);
            return this.f4886c;
        }

        @Override // androidx.viewpager.widget.a
        public boolean h(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1() {
        if (this.f4861Z.getVisibility() == 0) {
            this.f4861Z.setAlpha(1.0f);
            this.f4861Z.animate().alpha(0.0f).setDuration(800L).setListener(new g());
            this.f4859X.setAlpha(1.0f);
            this.f4859X.animate().alpha(0.0f).setDuration(800L).setListener(new h());
            return;
        }
        this.f4861Z.setAlpha(1.0f);
        this.f4861Z.setVisibility(0);
        this.f4859X.setAlpha(1.0f);
        this.f4859X.setVisibility(0);
    }

    private void a2(File file) throws Throwable {
        File[] fileArrListFiles = file.listFiles(new d());
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                m mVar = new m(file2);
                mVar.i(this);
                this.f4864c0.add(mVar);
            }
        }
        Collections.sort(this.f4864c0, new C0308c());
        if (this.f4867f0 >= this.f4864c0.size()) {
            this.f4867f0 = 0;
        }
        v1("listPhotos", Integer.valueOf(this.f4864c0.size()), this.f4864c0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b2(int i2) {
        if (i2 < 0 || i2 >= this.f4864c0.size()) {
            return;
        }
        File fileA = ((m) this.f4864c0.get(i2)).a();
        File fileA2 = i2 > 0 ? ((m) this.f4864c0.get(i2 - 1)).a() : null;
        File fileA3 = i2 < this.f4864c0.size() + (-1) ? ((m) this.f4864c0.get(i2 + 1)).a() : null;
        this.f4870i0 = 0;
        c2(fileA, fileA2, fileA3);
        this.f4860Y.post(new e(fileA));
    }

    private void c2(File file, File file2, File file3) {
        this.f4866e0.execute(new f(file, file2, file3));
    }

    private void d2() {
        if (this.f4873l0.hasMessages(0)) {
            this.f4873l0.removeCallbacksAndMessages(null);
            this.f4862a0.setBackgroundResource(R.drawable.image_play);
        }
        this.f4865d0.rotateImage(0);
        int i2 = this.f4870i0;
        int i3 = i2 - 90;
        this.f4870i0 = i3;
        if (i3 <= 0) {
            this.f4870i0 = i2 + 270;
        }
        ViewPager viewPager = this.f4858W;
        PinchImageView pinchImageView = (PinchImageView) viewPager.findViewWithTag(Integer.valueOf(viewPager.getCurrentItem()));
        if (pinchImageView != null) {
            pinchImageView.setRotation(this.f4870i0);
        }
    }

    private void e2() {
        if (this.f4873l0.hasMessages(0)) {
            this.f4873l0.removeCallbacksAndMessages(null);
            this.f4862a0.setBackgroundResource(R.drawable.image_play);
        }
        this.f4865d0.rotateImage(1);
        int i2 = this.f4870i0;
        int i3 = i2 + 90;
        this.f4870i0 = i3;
        if (i3 >= 360) {
            this.f4870i0 = i2 - 270;
        }
        ViewPager viewPager = this.f4858W;
        PinchImageView pinchImageView = (PinchImageView) viewPager.findViewWithTag(Integer.valueOf(viewPager.getCurrentItem()));
        if (pinchImageView != null) {
            pinchImageView.setRotation(this.f4870i0);
        }
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        this.f4858W = (ViewPager) findViewById(R.id.vp_image);
        this.f4859X = (ViewGroup) findViewById(R.id.vg_image_toolbar);
        this.f4861Z = (RelativeLayout) findViewById(R.id.rl_image_bottom);
        this.f4860Y = (TextView) findViewById(R.id.tvTitle);
        ImageButton imageButton = (ImageButton) findViewById(R.id.ibtn_photo_play_pause);
        this.f4862a0 = imageButton;
        imageButton.setOnClickListener(this);
        findViewById(R.id.ibtn_photo_rotate_left).setOnClickListener(this);
        findViewById(R.id.ibtn_photo_rotate_right).setOnClickListener(this);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_image;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() throws Throwable {
        this.f5378D = 1;
        this.f4868g0 = new Matrix();
        this.f4869h0 = new RectF();
        this.f4864c0 = new ArrayList();
        a2(new File(getIntent().getStringExtra("com.eshare.optoma.extra.PHOTO_PATH")));
        this.f4867f0 = getIntent().getIntExtra("com.eshare.optoma.extra.PHOTO_INDEX", 0);
        this.f4863b0 = new i();
        this.f4866e0 = Executors.newSingleThreadExecutor();
        this.f4865d0 = EShareAPI.init(this).media();
        this.f4872k0 = ViewConfiguration.get(this).getScaledTouchSlop();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() throws Resources.NotFoundException {
        this.f4858W.setAdapter(this.f4863b0);
        this.f4858W.b(new b());
        this.f4858W.setCurrentItem(this.f4867f0);
        b2(this.f4867f0);
    }

    @Override // android.app.Activity
    public void finish() {
        this.f4873l0.removeCallbacksAndMessages(null);
        super.finish();
        this.f4866e0.execute(new c());
    }

    @s1.m
    public void finishSelf(h0.g gVar) {
        finish();
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ivLeft) {
            finish();
        }
        switch (id) {
            case R.id.ibtn_photo_play_pause /* 2131230942 */:
                if (!this.f4873l0.hasMessages(0)) {
                    this.f4873l0.sendEmptyMessage(0);
                    this.f4862a0.setBackgroundResource(R.drawable.image_stop);
                    break;
                } else {
                    this.f4873l0.removeCallbacksAndMessages(null);
                    this.f4862a0.setBackgroundResource(R.drawable.image_play);
                    break;
                }
            case R.id.ibtn_photo_rotate_left /* 2131230943 */:
                d2();
                break;
            case R.id.ibtn_photo_rotate_right /* 2131230944 */:
                e2();
                break;
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f4866e0.shutdown();
    }
}
