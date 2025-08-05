package g0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.caglobal.kodakluma.R;
import h0.C0263d;
import java.util.List;

/* loaded from: classes.dex */
public class f extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    public List f6295c;

    /* renamed from: d, reason: collision with root package name */
    private View.OnClickListener f6296d;

    class a extends RecyclerView.C {

        /* renamed from: t, reason: collision with root package name */
        ImageView f6298t;

        /* renamed from: u, reason: collision with root package name */
        ImageView f6299u;

        /* renamed from: v, reason: collision with root package name */
        ImageView f6300v;

        /* renamed from: w, reason: collision with root package name */
        ImageView f6301w;

        /* renamed from: x, reason: collision with root package name */
        ImageView f6302x;

        /* renamed from: y, reason: collision with root package name */
        ImageView f6303y;

        /* renamed from: z, reason: collision with root package name */
        TextView f6304z;

        public a(View view) {
            super(view);
            this.f6298t = (ImageView) view.findViewById(R.id.iv_item_peer_device_type);
            this.f6304z = (TextView) view.findViewById(R.id.tv_item_peer_device_name);
            this.f6299u = (ImageView) view.findViewById(R.id.iv_item_peer_device_host);
            this.f6300v = (ImageView) view.findViewById(R.id.iv_item_peer_device_fullscreen);
            this.f6301w = (ImageView) view.findViewById(R.id.iv_item_peer_device_cast);
            this.f6302x = (ImageView) view.findViewById(R.id.iv_item_peer_device_allow);
            this.f6303y = (ImageView) view.findViewById(R.id.iv_item_peer_device_deny);
            this.f6301w.setTag(this);
            this.f6300v.setTag(this);
            this.f6299u.setTag(this);
            this.f6302x.setTag(this);
            this.f6303y.setTag(this);
            this.f6302x.setOnClickListener(f.this.f6296d);
            this.f6303y.setOnClickListener(f.this.f6296d);
            this.f6299u.setOnClickListener(f.this.f6296d);
            this.f6300v.setOnClickListener(f.this.f6296d);
            this.f6301w.setOnClickListener(f.this.f6296d);
        }
    }

    public f(List list, View.OnClickListener onClickListener) {
        this.f6295c = list;
        this.f6296d = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f6295c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void k(a aVar, int i2) {
        C0263d c0263d = (C0263d) this.f6295c.get(i2);
        int i3 = c0263d.f6381a;
        if (i3 == 5 || i3 == 0) {
            aVar.f6298t.setBackgroundResource(R.drawable.ic_laptop);
        } else {
            aVar.f6298t.setBackgroundResource(R.drawable.ic_mobile);
        }
        aVar.f6304z.setText(c0263d.f6382b);
        if (c0263d.e() == 1) {
            aVar.f6299u.setVisibility(8);
            aVar.f6300v.setVisibility(8);
            aVar.f6301w.setVisibility(8);
            aVar.f6302x.setVisibility(0);
            aVar.f6303y.setVisibility(0);
            return;
        }
        aVar.f6302x.setVisibility(8);
        aVar.f6303y.setVisibility(8);
        aVar.f6301w.setVisibility(0);
        aVar.f6300v.setVisibility(0);
        aVar.f6299u.setVisibility(0);
        if (c0263d.d() == 1) {
            aVar.f6299u.setBackgroundResource(R.drawable.ic_host_enabled_selected);
        } else {
            aVar.f6299u.setBackgroundResource(R.drawable.ic_host_enabled_normal);
        }
        if (c0263d.f() == 1) {
            aVar.f6301w.setSelected(true);
        } else {
            aVar.f6301w.setSelected(false);
        }
        if (c0263d.c() == 1) {
            aVar.f6300v.setBackgroundResource(R.drawable.ic_full_02_selected);
        } else if (c0263d.c() == 0) {
            aVar.f6300v.setBackgroundResource(R.drawable.ic_full_01_normal);
        } else if (c0263d.c() == -1) {
            aVar.f6300v.setBackgroundResource(R.drawable.ic_full_disabled);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public a m(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_peer_device, viewGroup, false));
    }
}
