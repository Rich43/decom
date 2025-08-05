package m0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.E;
import androidx.fragment.app.Fragment;
import com.caglobal.kodakluma.R;

/* renamed from: m0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0292f extends Fragment implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private FrameLayout f6627a;

    /* renamed from: b, reason: collision with root package name */
    private a f6628b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f6629c;

    /* renamed from: m0.f$a */
    public interface a {
        void q();

        void t();

        void z();
    }

    private void j() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.kodakphotoplus.com/collections/projectors/products/kodak-luma-350-projector"));
        startActivity(intent);
    }

    private void k() {
        this.f6627a.setVisibility(0);
        E eP = getChildFragmentManager().p();
        Fragment fragmentI0 = getChildFragmentManager().i0("lumaSettingAbout");
        if (fragmentI0 == null) {
            eP.c(R.id.fl_luma_setting_content, new ViewOnClickListenerC0287a(), "lumaSettingAbout").g();
        } else {
            eP.o(fragmentI0);
        }
        for (Fragment fragment : getChildFragmentManager().t0()) {
            if (!(fragment instanceof ViewOnClickListenerC0287a)) {
                eP.m(fragment);
            }
        }
    }

    private void l() {
        this.f6627a.setVisibility(0);
        E eP = getChildFragmentManager().p();
        Fragment fragmentI0 = getChildFragmentManager().i0("lumaSettingSound");
        if (fragmentI0 == null) {
            eP.c(R.id.fl_luma_setting_content, new k(), "lumaSettingSound").g();
        } else {
            eP.o(fragmentI0);
        }
        for (Fragment fragment : getChildFragmentManager().t0()) {
            if (!(fragment instanceof k)) {
                eP.m(fragment);
            }
        }
    }

    public boolean i() {
        if (this.f6627a.getVisibility() != 0) {
            return false;
        }
        this.f6627a.setVisibility(8);
        this.f6629c.setVisibility(0);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f6628b = (a) getActivity();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_luma_about /* 2131231062 */:
                k();
                break;
            case R.id.ll_luma_buy /* 2131231063 */:
                j();
                break;
            case R.id.ll_luma_devices /* 2131231064 */:
                a aVar = this.f6628b;
                if (aVar != null) {
                    aVar.t();
                    break;
                }
                break;
            case R.id.ll_luma_help /* 2131231065 */:
                this.f6629c.setVisibility(8);
                a aVar2 = this.f6628b;
                if (aVar2 != null) {
                    aVar2.q();
                    break;
                }
                break;
            case R.id.ll_luma_log_out /* 2131231066 */:
                a aVar3 = this.f6628b;
                if (aVar3 != null) {
                    aVar3.z();
                    break;
                }
                break;
            case R.id.ll_luma_sound /* 2131231067 */:
                this.f6629c.setVisibility(8);
                l();
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.luma_setting, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.ll_luma_devices).setOnClickListener(this);
        view.findViewById(R.id.ll_luma_sound).setOnClickListener(this);
        view.findViewById(R.id.ll_luma_buy).setOnClickListener(this);
        view.findViewById(R.id.ll_luma_about).setOnClickListener(this);
        view.findViewById(R.id.ll_luma_help).setOnClickListener(this);
        view.findViewById(R.id.ll_luma_log_out).setOnClickListener(this);
        this.f6629c = (TextView) view.findViewById(R.id.tv_setting_verison);
        this.f6627a = (FrameLayout) view.findViewById(R.id.fl_luma_setting_content);
    }
}
