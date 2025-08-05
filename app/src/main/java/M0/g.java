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
import com.caglobal.kodakluma.R;

/* loaded from: classes.dex */
public class g extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f6630a;

    /* renamed from: b, reason: collision with root package name */
    private ListView f6631b;

    /* renamed from: c, reason: collision with root package name */
    private String[] f6632c;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.getActivity().onBackPressed();
        }
    }

    class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return g.this.f6632c.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return g.this.f6632c[i2];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            View viewInflate = View.inflate(g.this.getContext(), R.layout.item_luma_mirror, null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
            textView.setText(g.this.f6632c[i2]);
            if (i2 != 0 && i2 != 1 && i2 != 4) {
                textView.setPadding(30, 0, 0, 0);
            } else if (i2 == 1 || i2 == 4) {
                textView.setTextColor(g.this.getResources().getColor(R.color.color_e5));
            }
            return viewInflate;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.luma_setting_mirror, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6630a = (ImageView) view.findViewById(R.id.iv_mirror_back);
        this.f6632c = new String[]{getString(R.string.tv_mirror_one), getString(R.string.tv_mirror_two), getString(R.string.tv_mirror_three), getString(R.string.tv_mirror_four), getString(R.string.tv_mirror_five), getString(R.string.tv_mirror_six), getString(R.string.tv_mirror_seven), getString(R.string.tv_mirror_eight), getString(R.string.tv_mirror_nine)};
        this.f6630a.setOnClickListener(new a());
        ListView listView = (ListView) view.findViewById(R.id.lv_help_mirror_tips);
        this.f6631b = listView;
        listView.setAdapter((ListAdapter) new b());
    }
}
