package m0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.fragment.app.Fragment;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.activity.MainActivity;
import com.eshare.api.EShareAPI;
import com.eshare.api.IMedia;

/* loaded from: classes.dex */
public class k extends Fragment implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public static int f6677c = 10;

    /* renamed from: a, reason: collision with root package name */
    private SeekBar f6678a;

    /* renamed from: b, reason: collision with root package name */
    private IMedia f6679b;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (k.this.getActivity() instanceof MainActivity) {
                ((MainActivity) k.this.getActivity()).onBackPressed();
            }
        }
    }

    private void i() {
        this.f6679b = EShareAPI.init(getContext()).media();
        this.f6678a.setProgress(f6677c);
        this.f6678a.setOnSeekBarChangeListener(this);
    }

    public void j(int i2) {
        this.f6679b.setVolume(i2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.luma_setting_sound, viewGroup, false);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        if (f6677c == 0) {
            j(1);
        }
        int progress = seekBar.getProgress();
        f6677c = progress;
        j(progress);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.iv_luma_sound_back).setOnClickListener(new a());
        this.f6678a = (SeekBar) view.findViewById(R.id.skb_luma_setting_sound);
        i();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
