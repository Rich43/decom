package g0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.caglobal.kodakluma.R;
import h0.C0262c;
import java.util.List;

/* loaded from: classes.dex */
public class b extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private Context f6261c;

    /* renamed from: d, reason: collision with root package name */
    private List f6262d;
    private List e;

    /* renamed from: f, reason: collision with root package name */
    private j0.e f6263f;

    /* renamed from: g, reason: collision with root package name */
    private j0.f f6264g;

    class a extends RecyclerView.C {

        /* renamed from: t, reason: collision with root package name */
        RelativeLayout f6265t;

        /* renamed from: u, reason: collision with root package name */
        TextView f6266u;

        /* renamed from: g0.b$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0077a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f6268a;

            ViewOnClickListenerC0077a(b bVar) {
                this.f6268a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j0.e eVar = b.this.f6263f;
                a aVar = a.this;
                eVar.p(b.this, aVar.m());
            }
        }

        /* renamed from: g0.b$a$b, reason: collision with other inner class name */
        class ViewOnLongClickListenerC0078b implements View.OnLongClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f6270a;

            ViewOnLongClickListenerC0078b(b bVar) {
                this.f6270a = bVar;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                j0.f fVar = b.this.f6264g;
                a aVar = a.this;
                fVar.Q(b.this, aVar.m());
                return true;
            }
        }

        public a(View view) {
            super(view);
            this.f6265t = (RelativeLayout) view.findViewById(R.id.rl_item_audio);
            if (b.this.f6263f != null) {
                this.f6265t.setOnClickListener(new ViewOnClickListenerC0077a(b.this));
            }
            if (b.this.f6264g != null) {
                view.setOnLongClickListener(new ViewOnLongClickListenerC0078b(b.this));
            }
            this.f6266u = (TextView) view.findViewById(R.id.tv_item_audio_name);
        }
    }

    public b(Context context, List list, List list2) {
        this.f6261c = context;
        this.f6262d = list;
        this.e = list2;
    }

    public void A(j0.e eVar) {
        this.f6263f = eVar;
    }

    public void B(j0.f fVar) {
        this.f6264g = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f6262d.size();
    }

    public C0262c w(int i2) {
        if (i2 >= this.f6262d.size()) {
            return null;
        }
        return (C0262c) this.f6262d.get(i2);
    }

    public List x() {
        return this.f6262d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void k(a aVar, int i2) {
        aVar.f6266u.setText(((C0262c) this.f6262d.get(i2)).d());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public a m(ViewGroup viewGroup, int i2) {
        return new a(View.inflate(this.f6261c, R.layout.item_audio, null));
    }
}
