package com.caglobal.kodakluma.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.caglobal.kodakluma.R;
import g0.e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ScreenTutorialActivity extends Activity implements View.OnClickListener {

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f5357l = {R.layout.guide_view1, R.layout.guide_view2, R.layout.guide_view3};

    /* renamed from: a, reason: collision with root package name */
    private ViewPager f5358a;

    /* renamed from: b, reason: collision with root package name */
    private e f5359b;

    /* renamed from: c, reason: collision with root package name */
    private List f5360c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5361d = true;
    private boolean e = false;

    /* renamed from: f, reason: collision with root package name */
    private ImageView[] f5362f;

    /* renamed from: g, reason: collision with root package name */
    private int f5363g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f5364h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f5365i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f5366j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f5367k;

    class a implements ViewPager.i {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i2, float f2, int i3) {
            if (ScreenTutorialActivity.this.f5361d && ScreenTutorialActivity.this.e && i3 == 0) {
                ScreenTutorialActivity.this.finish();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i2) {
            ScreenTutorialActivity.this.e = i2 == 1;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void c(int i2) {
            ScreenTutorialActivity.this.g(i2);
            ScreenTutorialActivity.this.f5361d = i2 == 0;
        }
    }

    private void f() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);
        this.f5362f = new ImageView[f5357l.length];
        for (int i2 = 0; i2 < f5357l.length; i2++) {
            this.f5362f[i2] = (ImageView) linearLayout.getChildAt(i2);
            this.f5362f[i2].setEnabled(false);
            this.f5362f[i2].setOnClickListener(this);
            this.f5362f[i2].setTag(Integer.valueOf(i2));
        }
        this.f5363g = 0;
        this.f5362f[0].setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i2) {
        if (i2 < 0 || i2 > f5357l.length || this.f5363g == i2) {
            return;
        }
        this.f5362f[i2].setEnabled(true);
        this.f5362f[this.f5363g].setEnabled(false);
        this.f5363g = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_one_skip) {
            setResult(90000, new Intent(getApplicationContext(), (Class<?>) MainActivity.class));
            finish();
        } else if (id == R.id.tv_three_skip) {
            setResult(90000, new Intent(getApplicationContext(), (Class<?>) MainActivity.class));
            finish();
        } else {
            if (id != R.id.tv_two_skip) {
                return;
            }
            setResult(90000, new Intent(getApplicationContext(), (Class<?>) MainActivity.class));
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.screen_tutorial);
        this.f5360c = new ArrayList();
        int i2 = 0;
        while (true) {
            int[] iArr = f5357l;
            if (i2 >= iArr.length) {
                this.f5358a = (ViewPager) findViewById(R.id.vp_guide);
                TextView textView = (TextView) findViewById(R.id.tv_luma_title);
                this.f5364h = textView;
                textView.setText(Html.fromHtml(getString(R.string.tv_welcome_to) + "<font color=\"#FF0000\">KODAK</font> <font color=\"#FFFFFF\">LUMA</font>" + getString(R.string.tv_app)));
                e eVar = new e(this.f5360c);
                this.f5359b = eVar;
                this.f5358a.setAdapter(eVar);
                this.f5358a.b(new a());
                f();
                return;
            }
            View viewInflate = LayoutInflater.from(this).inflate(iArr[i2], (ViewGroup) null);
            if (i2 == 0) {
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_one_skip);
                this.f5365i = textView2;
                textView2.setOnClickListener(this);
            } else if (i2 == 1) {
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_two_skip);
                this.f5367k = textView3;
                textView3.setOnClickListener(this);
            } else if (i2 == iArr.length - 1) {
                TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_three_skip);
                this.f5366j = textView4;
                textView4.setOnClickListener(this);
            }
            this.f5360c.add(viewInflate);
            i2++;
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }
}
