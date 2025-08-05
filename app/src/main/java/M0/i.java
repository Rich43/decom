package m0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import com.caglobal.kodakluma.R;
import com.caglobal.kodakluma.activity.MainActivity;

/* loaded from: classes.dex */
public class i extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private String[] f6642a;

    /* renamed from: b, reason: collision with root package name */
    private ListView f6643b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f6644c;

    /* renamed from: d, reason: collision with root package name */
    private w f6645d;
    private ViewOnClickListenerC0291e e;

    /* renamed from: f, reason: collision with root package name */
    private d f6646f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f6647g;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.f6646f != null) {
                i.this.f6646f.O();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MainActivity.L1.booleanValue()) {
                i.this.getActivity().onBackPressed();
            } else if (i.this.f6646f != null) {
                i.this.f6646f.K();
            }
        }
    }

    class c extends BaseAdapter {
        c() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return i.this.f6642a.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return i.this.f6642a[i2];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            View viewInflate = View.inflate(i.this.getContext(), R.layout.item_luma_help, null);
            ((TextView) viewInflate.findViewById(R.id.tv_title)).setText(i.this.f6642a[i2]);
            return viewInflate;
        }
    }

    public interface d {
        void K();

        void O();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.projector_helper, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6643b = (ListView) view.findViewById(R.id.lv_help_project_tips);
        this.f6644c = (ImageView) view.findViewById(R.id.iv_help_back);
        TextView textView = (TextView) view.findViewById(R.id.tv_need_help);
        this.f6647g = textView;
        textView.setOnClickListener(new a());
        this.f6645d = getActivity().N0();
        this.e = new ViewOnClickListenerC0291e();
        this.f6646f = (d) getActivity();
        this.f6644c.setOnClickListener(new b());
        this.f6642a = new String[]{getString(R.string.tv_project_one), getString(R.string.tv_project_two), getString(R.string.tv_project_three), getString(R.string.tv_project_ffour), getString(R.string.tv_project_five), getString(R.string.tv_project_six)};
        this.f6643b.setAdapter((ListAdapter) new c());
    }
}
