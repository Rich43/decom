package m0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.activity.MainActivity;

/* renamed from: m0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0287a extends Fragment implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (view.getId() == R.id.iv_luma_about_back && (getActivity() instanceof MainActivity)) {
            ((MainActivity) getActivity()).onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.luma_setting_about, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String str;
        view.findViewById(R.id.iv_luma_about_back).setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.tv_app_verison);
        try {
            str = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        textView.setText(str);
    }
}
