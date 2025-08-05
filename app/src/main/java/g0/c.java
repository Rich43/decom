package g0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.caglobal.kodakluma.R;
import com.eshare.api.EShareAPI;
import com.eshare.api.bean.Device;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class c extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private final List f6272c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final EShareAPI f6273d;
    private Context e;

    /* renamed from: f, reason: collision with root package name */
    private j0.e f6274f;

    class a extends RecyclerView.C {

        /* renamed from: t, reason: collision with root package name */
        TextView f6275t;

        /* renamed from: u, reason: collision with root package name */
        TextView f6276u;

        /* renamed from: v, reason: collision with root package name */
        ImageView f6277v;

        /* renamed from: g0.c$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0079a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f6279a;

            ViewOnClickListenerC0079a(c cVar) {
                this.f6279a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j0.e eVar = c.this.f6274f;
                a aVar = a.this;
                eVar.p(c.this, aVar.m());
            }
        }

        a(View view) {
            super(view);
            if (c.this.f6274f != null) {
                view.setOnClickListener(new ViewOnClickListenerC0079a(c.this));
            }
            this.f6275t = (TextView) view.findViewById(R.id.tv_item_device_name);
            this.f6277v = (ImageView) view.findViewById(R.id.iv_device_select);
            this.f6276u = (TextView) view.findViewById(R.id.tv_item_device_info);
        }
    }

    public c(Context context) {
        this.e = context;
        this.f6273d = EShareAPI.init(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f6272c.size();
    }

    public Device v(int i2) {
        if (i2 >= this.f6272c.size()) {
            return null;
        }
        return (Device) this.f6272c.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void k(a aVar, int i2) {
        Device device = (Device) this.f6272c.get(i2);
        aVar.f6275t.setText(device.getName());
        aVar.f6276u.setText(device.getIpAddress());
        if (device.getName().equals(this.f6273d.getDeviceName())) {
            aVar.f6277v.setVisibility(0);
        } else {
            aVar.f6277v.setVisibility(4);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public a m(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_device, viewGroup, false));
    }

    public void y(j0.e eVar) {
        this.f6274f = eVar;
    }
}
