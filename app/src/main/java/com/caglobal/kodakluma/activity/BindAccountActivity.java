package com.caglobal.kodakluma.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.caglobal.kodakluma.CustomApplication;
import com.caglobal.kodakluma.R;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
import q0.AbstractC0320i;
import q0.q;

/* loaded from: classes.dex */
public class BindAccountActivity extends com.caglobal.kodakluma.activity.a {

    /* renamed from: T, reason: collision with root package name */
    private LinearLayout f4737T;

    /* renamed from: U, reason: collision with root package name */
    private TextView f4738U;

    /* renamed from: V, reason: collision with root package name */
    private ExecutorService f4739V;

    /* renamed from: W, reason: collision with root package name */
    private LinearLayout f4740W;

    /* renamed from: X, reason: collision with root package name */
    private LinearLayout f4741X;

    /* renamed from: Y, reason: collision with root package name */
    private TextView f4742Y;

    /* renamed from: Z, reason: collision with root package name */
    private TextView f4743Z;

    /* renamed from: a0, reason: collision with root package name */
    private View f4744a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f4745b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f4746c0;

    /* renamed from: d0, reason: collision with root package name */
    private EditText f4747d0;

    /* renamed from: e0, reason: collision with root package name */
    private EditText f4748e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f4749f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    private Handler f4750g0 = new a();

    /* renamed from: h0, reason: collision with root package name */
    private LinearLayout f4751h0;

    /* renamed from: i0, reason: collision with root package name */
    private LinearLayout f4752i0;

    /* renamed from: j0, reason: collision with root package name */
    private ImageView f4753j0;

    /* renamed from: k0, reason: collision with root package name */
    private LinearLayout f4754k0;

    /* renamed from: l0, reason: collision with root package name */
    private TextView f4755l0;

    /* renamed from: m0, reason: collision with root package name */
    private ImageView f4756m0;

    /* renamed from: n0, reason: collision with root package name */
    private RelativeLayout f4757n0;

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    BindAccountActivity.this.f4757n0.setVisibility(8);
                    CustomApplication.f(R.string.server_error_login);
                    break;
                case 1:
                    BindAccountActivity.this.setResult(5, new Intent(BindAccountActivity.this, (Class<?>) MainActivity.class));
                    BindAccountActivity.this.finish();
                    q.d(BindAccountActivity.this.getApplicationContext(), "LogSuccess", true);
                    BindAccountActivity.this.f4757n0.setVisibility(8);
                    break;
                case 2:
                    BindAccountActivity.this.setResult(5, new Intent(BindAccountActivity.this, (Class<?>) MainActivity.class));
                    BindAccountActivity.this.finish();
                    q.d(BindAccountActivity.this.getApplicationContext(), "LogSuccess", true);
                    BindAccountActivity.this.f4757n0.setVisibility(8);
                    break;
                case 3:
                    CustomApplication.f(R.string.invalid_account);
                    BindAccountActivity.this.f4742Y.setTextColor(BindAccountActivity.this.getResources().getColor(R.color.white_gray));
                    BindAccountActivity.this.f4744a0.setVisibility(8);
                    BindAccountActivity.this.f4743Z.setTextColor(BindAccountActivity.this.getResources().getColor(R.color.white));
                    BindAccountActivity.this.f4745b0.setVisibility(0);
                    BindAccountActivity.this.f4746c0.setText(BindAccountActivity.this.getString(R.string.tv_create));
                    BindAccountActivity.this.f4757n0.setVisibility(8);
                    break;
                case 4:
                    CustomApplication.f(R.string.password_error);
                    BindAccountActivity.this.f4757n0.setVisibility(8);
                    break;
                case 5:
                    BindAccountActivity.this.setResult(5, new Intent(BindAccountActivity.this, (Class<?>) MainActivity.class));
                    BindAccountActivity.this.finish();
                    q.d(BindAccountActivity.this.getApplicationContext(), "LogSuccess", true);
                    BindAccountActivity.this.f4757n0.setVisibility(8);
                    break;
                case 6:
                    CustomApplication.f(R.string.server_error_create);
                    BindAccountActivity.this.f4757n0.setVisibility(8);
                    break;
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4759a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4760b;

        b(String str, String str2) {
            this.f4759a = str;
            this.f4760b = str2;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.f4759a);
                jSONObject.put("password", " ");
                jSONObject.put("email", this.f4760b);
                jSONObject.put("dob", "1 jan 2019");
                jSONObject.put("login_with", "social");
                jSONObject.put("app_version_number", "1.0");
                jSONObject.put("platform", "platform");
                String strA = AbstractC0320i.a(jSONObject.toString(), "http://projector.smilecdn.site/kodak-api/Projector/register");
                if (TextUtils.isEmpty(strA)) {
                    BindAccountActivity.this.f4750g0.sendEmptyMessage(1);
                    return;
                }
                String string = new JSONObject(strA).getString("message");
                if (string != null && string.equals("Data insert successfully.")) {
                    BindAccountActivity.this.f4750g0.sendEmptyMessage(1);
                    q.d(BindAccountActivity.this, "isRegistered", true);
                    return;
                }
                if (string != null && string.equals("login successfully.")) {
                    BindAccountActivity.this.f4750g0.sendEmptyMessage(1);
                    return;
                }
                if (string != null && string.equals("You have entered an invalid email id or password")) {
                    BindAccountActivity.this.f4750g0.sendEmptyMessage(1);
                    return;
                }
                if (string != null && string.equals("Wrong password.")) {
                    BindAccountActivity.this.f4750g0.sendEmptyMessage(1);
                } else if (string == null || !string.equals("You are already registered.")) {
                    BindAccountActivity.this.f4750g0.sendEmptyMessage(1);
                } else {
                    q.d(BindAccountActivity.this, "isRegistered", true);
                    BindAccountActivity.this.f4750g0.sendEmptyMessage(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BindAccountActivity.this.U1();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    private void T1() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.kodakphotoplus.com/pages/privacy"));
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f4756m0, "rotation", 0.0f, 360.0f);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.addListener(new c());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.start();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void B1() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_bind_login);
        this.f4737T = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ll_bind_in);
        this.f4740W = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.ll_bind_create);
        this.f4741X = linearLayout3;
        linearLayout3.setOnClickListener(this);
        this.f4742Y = (TextView) findViewById(R.id.tv_bind_login);
        this.f4743Z = (TextView) findViewById(R.id.tv_bind_create);
        this.f4744a0 = findViewById(R.id.view_bind_login);
        this.f4745b0 = findViewById(R.id.view_bind_create);
        this.f4746c0 = (TextView) findViewById(R.id.tv_bind_way);
        this.f4751h0 = (LinearLayout) findViewById(R.id.ll_full_name);
        this.f4754k0 = (LinearLayout) findViewById(R.id.ll_checkbox);
        ImageView imageView = (ImageView) findViewById(R.id.iv_check_box);
        this.f4753j0 = imageView;
        imageView.setOnClickListener(this);
        this.f4756m0 = (ImageView) findViewById(R.id.iv_loading_bind);
        this.f4757n0 = (RelativeLayout) findViewById(R.id.rl_bind_loading);
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected int C1() {
        return R.layout.activity_account_bind;
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void D1() {
        this.f4739V = Executors.newSingleThreadExecutor();
        U1();
    }

    @Override // com.caglobal.kodakluma.activity.a
    protected void E1() {
        TextView textView = (TextView) findViewById(R.id.tv_bind_web);
        this.f4738U = textView;
        textView.setText(Html.fromHtml(getString(R.string.tv_help) + "<br /><u><font color=\"#008DE3\">kodak@caglobal.com</font></u>"));
        this.f4747d0 = (EditText) findViewById(R.id.et_bind_email);
        this.f4748e0 = (EditText) findViewById(R.id.et_bind_password);
        this.f4752i0 = (LinearLayout) findViewById(R.id.ll_email_number);
        TextView textView2 = (TextView) findViewById(R.id.tv_protocol);
        this.f4755l0 = textView2;
        textView2.setOnClickListener(this);
        this.f4755l0.setText(Html.fromHtml(getString(R.string.tv_agree_by) + "<u><font color=\"#008DE3\">Terms & Conditions and Privacy Policy</font></u>"));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // com.caglobal.kodakluma.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.iv_check_box) {
            if (this.f4749f0) {
                this.f4753j0.setImageResource(2131165339);
                this.f4749f0 = false;
                return;
            } else {
                this.f4753j0.setImageResource(2131165340);
                this.f4754k0.setVisibility(4);
                this.f4749f0 = true;
                return;
            }
        }
        if (id == R.id.tv_protocol) {
            T1();
            return;
        }
        switch (id) {
            case R.id.ll_bind_create /* 2131231054 */:
                this.f4742Y.setTextColor(getResources().getColor(R.color.white_gray));
                this.f4744a0.setVisibility(8);
                this.f4743Z.setTextColor(getResources().getColor(R.color.white));
                this.f4745b0.setVisibility(0);
                this.f4746c0.setText(getString(R.string.tv_create));
                break;
            case R.id.ll_bind_in /* 2131231055 */:
                this.f4742Y.setTextColor(getResources().getColor(R.color.white));
                this.f4744a0.setVisibility(0);
                this.f4743Z.setTextColor(getResources().getColor(R.color.white_gray));
                this.f4745b0.setVisibility(8);
                this.f4746c0.setText(getString(R.string.tv_login));
                break;
            case R.id.ll_bind_login /* 2131231056 */:
                String string = this.f4747d0.getText().toString();
                String string2 = this.f4748e0.getText().toString();
                q.f(this, "email", string);
                q.f(this, "fullname", string2);
                if (!TextUtils.isEmpty(string2) && !string2.startsWith(" ") && string2.contains(" ")) {
                    this.f4751h0.setVisibility(4);
                    if (!TextUtils.isEmpty(string) && Patterns.EMAIL_ADDRESS.matcher(string).matches()) {
                        this.f4752i0.setVisibility(4);
                        if (!this.f4749f0) {
                            this.f4754k0.setVisibility(0);
                            break;
                        } else {
                            this.f4757n0.setVisibility(0);
                            this.f4739V.execute(new b(string2, string));
                            break;
                        }
                    } else {
                        this.f4752i0.setVisibility(0);
                        break;
                    }
                } else {
                    this.f4751h0.setVisibility(0);
                    break;
                }
                break;
        }
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFinishOnTouchOutside(false);
    }

    @Override // com.caglobal.kodakluma.activity.a, androidx.appcompat.app.AbstractActivityC0128c, androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f4739V.shutdown();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return getCurrentFocus() != null ? ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0) : super.onTouchEvent(motionEvent);
    }
}
