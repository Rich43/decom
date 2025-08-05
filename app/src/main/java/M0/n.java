package m0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.caglobal.kodakluma.R;

/* loaded from: classes.dex */
public class n extends Fragment implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f6687a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f6688b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f6689c;

    /* renamed from: d, reason: collision with root package name */
    private a f6690d;

    public interface a {
        void D();

        void N();

        void k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_update_above /* 2131231027 */:
                a aVar = this.f6690d;
                if (aVar != null) {
                    aVar.k();
                    break;
                }
                break;
            case R.id.iv_update_back /* 2131231028 */:
                a aVar2 = this.f6690d;
                if (aVar2 != null) {
                    aVar2.N();
                    break;
                }
                break;
            case R.id.iv_update_below /* 2131231029 */:
                a aVar3 = this.f6690d;
                if (aVar3 != null) {
                    aVar3.D();
                    break;
                }
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.tips_update, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.f6690d = (a) getActivity();
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_update_back);
        this.f6687a = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_update_above);
        this.f6688b = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_update_below);
        this.f6689c = imageView3;
        imageView3.setOnClickListener(this);
    }
}
