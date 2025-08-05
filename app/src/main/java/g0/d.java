package g0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.caglobal.kodakluma.R;
import h0.C0264e;
import java.util.List;

/* loaded from: classes.dex */
public class d extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private Context f6281c;

    /* renamed from: d, reason: collision with root package name */
    private float f6282d;
    private List e;

    /* renamed from: f, reason: collision with root package name */
    private j0.e f6283f;

    /* renamed from: g, reason: collision with root package name */
    private j0.f f6284g;

    class a extends RecyclerView.C {

        /* renamed from: t, reason: collision with root package name */
        RelativeLayout f6285t;

        /* renamed from: u, reason: collision with root package name */
        ImageView f6286u;

        /* renamed from: v, reason: collision with root package name */
        TextView f6287v;

        /* renamed from: w, reason: collision with root package name */
        TextView f6288w;

        /* renamed from: g0.d$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0080a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f6290a;

            ViewOnClickListenerC0080a(d dVar) {
                this.f6290a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j0.e eVar = d.this.f6283f;
                a aVar = a.this;
                eVar.p(d.this, aVar.m());
            }
        }

        class b implements View.OnLongClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f6292a;

            b(d dVar) {
                this.f6292a = dVar;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                j0.f fVar = d.this.f6284g;
                a aVar = a.this;
                fVar.Q(d.this, aVar.m());
                return true;
            }
        }

        public a(View view) {
            super(view);
            this.f6285t = (RelativeLayout) view.findViewById(R.id.rl_item_document);
            if (d.this.f6283f != null) {
                this.f6285t.setOnClickListener(new ViewOnClickListenerC0080a(d.this));
            }
            if (d.this.f6284g != null) {
                view.setOnLongClickListener(new b(d.this));
            }
            this.f6286u = (ImageView) view.findViewById(R.id.iv_item_document_icon);
            this.f6287v = (TextView) view.findViewById(R.id.tv_item_document_name);
            this.f6288w = (TextView) view.findViewById(R.id.tv_item_document_size);
        }
    }

    public d(Context context, List list) {
        this.f6281c = context;
        this.f6282d = context.getResources().getDisplayMetrics().density;
        this.e = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public a m(ViewGroup viewGroup, int i2) {
        return new a(View.inflate(this.f6281c, R.layout.item_document, null));
    }

    public void B(j0.e eVar) {
        this.f6283f = eVar;
    }

    public void C(j0.f fVar) {
        this.f6284g = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.e.size();
    }

    public void w(List list) {
        this.e.addAll(list);
        g();
    }

    public void x() {
        this.e.clear();
        g();
    }

    public C0264e y(int i2) {
        if (i2 >= this.e.size()) {
            return null;
        }
        return (C0264e) this.e.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void k(a aVar, int i2) {
        C0264e c0264e = (C0264e) this.e.get(i2);
        aVar.f6286u.setImageResource(c0264e.i());
        aVar.f6287v.setText(c0264e.d());
        if (c0264e.k()) {
            return;
        }
        aVar.f6288w.setText(c0264e.j(this.f6281c));
    }
}
