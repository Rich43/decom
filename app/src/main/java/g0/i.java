package g0;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.caglobal.kodakluma.R;
import h0.C0261b;
import java.util.List;

/* loaded from: classes.dex */
public class i extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private Context f6328c;

    /* renamed from: d, reason: collision with root package name */
    private List f6329d;
    private j0.e e;

    /* renamed from: f, reason: collision with root package name */
    private j0.f f6330f;

    /* renamed from: g, reason: collision with root package name */
    Boolean f6331g;

    class a extends RecyclerView.C {

        /* renamed from: t, reason: collision with root package name */
        ImageView f6332t;

        /* renamed from: u, reason: collision with root package name */
        TextView f6333u;

        /* renamed from: g0.i$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0083a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f6335a;

            ViewOnClickListenerC0083a(i iVar) {
                this.f6335a = iVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j0.e eVar = i.this.e;
                a aVar = a.this;
                eVar.p(i.this, aVar.m());
            }
        }

        class b implements View.OnLongClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f6337a;

            b(i iVar) {
                this.f6337a = iVar;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                j0.f fVar = i.this.f6330f;
                a aVar = a.this;
                fVar.Q(i.this, aVar.m());
                return true;
            }
        }

        public a(View view) {
            super(view);
            if (i.this.e != null) {
                view.setOnClickListener(new ViewOnClickListenerC0083a(i.this));
            }
            if (i.this.f6330f != null) {
                view.setOnLongClickListener(new b(i.this));
            }
            this.f6332t = (ImageView) view.findViewById(R.id.iv_item_program);
            this.f6333u = (TextView) view.findViewById(R.id.tv_item_program);
            if (i.this.f6331g.booleanValue()) {
                this.f6333u.setTextColor(-1);
            } else {
                this.f6333u.setTextColor(i.this.f6328c.getResources().getColor(R.color.c_666666));
            }
        }
    }

    public i(Context context, List list, boolean z2) {
        this.f6331g = Boolean.FALSE;
        this.f6328c = context;
        this.f6329d = list;
        this.f6331g = Boolean.valueOf(z2);
    }

    public void A(j0.e eVar) {
        this.e = eVar;
    }

    public void B(j0.f fVar) {
        this.f6330f = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f6329d.size();
    }

    public C0261b x(int i2) {
        if (i2 >= this.f6329d.size()) {
            return null;
        }
        return (C0261b) this.f6329d.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void k(a aVar, int i2) {
        C0261b c0261b = (C0261b) this.f6329d.get(i2);
        aVar.f6332t.setImageBitmap(BitmapFactory.decodeByteArray(c0261b.a(), 0, c0261b.a().length));
        aVar.f6333u.setText(c0261b.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public a m(ViewGroup viewGroup, int i2) {
        return new a(View.inflate(this.f6328c, R.layout.item_program, null));
    }
}
