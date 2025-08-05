package m0;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.caglobal.kodakluma.R;

/* loaded from: classes.dex */
public class h extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private TextView f6635a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f6636b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f6637c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f6638d;
    private TextView e;

    /* renamed from: f, reason: collision with root package name */
    private c f6639f;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.f6639f != null) {
                h.this.f6639f.E();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.f6639f != null) {
                h.this.f6639f.U();
            }
        }
    }

    public interface c {
        void E();

        void U();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.tips_pair, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.tv_pair_power);
        this.f6635a = textView;
        textView.setText(Html.fromHtml("<big><font color=\"#E5FFFC\"><b>1. Power<b/></font></big><br>Is the projector turned on?"));
        TextView textView2 = (TextView) view.findViewById(R.id.tv_pair_wifi);
        this.f6637c = textView2;
        textView2.setText(Html.fromHtml("<big><font color=\"#E5FFFC\"><b>2. Wi-Fi<b/></font></big><br>Is the projector and your phone<br>connected to the same network?"));
        TextView textView3 = (TextView) view.findViewById(R.id.tv_pair_firmware);
        this.f6636b = textView3;
        textView3.setText(Html.fromHtml("<big><font color=\"#E5FFFC\"><b>3. Firmware<b/></font></big><br>Is the projector up-to-date?"));
        this.f6638d = (ImageView) view.findViewById(R.id.iv_pair_back);
        this.e = (TextView) view.findViewById(R.id.tv_pair_update);
        this.f6639f = (c) getActivity();
        this.e.setOnClickListener(new a());
        this.f6638d.setOnClickListener(new b());
    }
}
