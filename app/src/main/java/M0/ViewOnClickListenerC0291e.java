package m0;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.activity.ScreenTutorialActivity;

/* renamed from: m0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0291e extends Fragment implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private FrameLayout f6622a;

    /* renamed from: b, reason: collision with root package name */
    private RelativeLayout f6623b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f6624c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f6625d;
    private b e;

    /* renamed from: m0.e$a */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewOnClickListenerC0291e.this.e != null) {
                ViewOnClickListenerC0291e.this.e.c0();
            }
        }
    }

    /* renamed from: m0.e$b */
    public interface b {
        void C();

        void c0();

        void w();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.e = (b) getActivity();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.help_one /* 2131230928 */:
                b bVar = this.e;
                if (bVar != null) {
                    bVar.w();
                    break;
                }
                break;
            case R.id.help_three /* 2131230929 */:
                startActivityForResult(new Intent(getContext(), (Class<?>) ScreenTutorialActivity.class), 10000);
                break;
            case R.id.help_two /* 2131230930 */:
                b bVar2 = this.e;
                if (bVar2 != null) {
                    bVar2.C();
                    break;
                }
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.luma_setting_help, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.f6622a = (FrameLayout) view.findViewById(R.id.help_luma_setting_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.help_one);
        this.f6623b = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.help_two);
        this.f6624c = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.help_three);
        this.f6625d = relativeLayout3;
        relativeLayout3.setOnClickListener(this);
        view.findViewById(R.id.iv_help_back).setOnClickListener(new a());
    }
}
