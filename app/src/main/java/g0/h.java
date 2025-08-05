package g0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.caglobal.kodakluma.R;
import com.squareup.picasso.Picasso;
import h0.m;
import java.util.List;

/* loaded from: classes.dex */
public class h extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private Context f6318c;

    /* renamed from: d, reason: collision with root package name */
    private List f6319d;
    private j0.e e;

    /* renamed from: f, reason: collision with root package name */
    private Picasso f6320f;

    /* renamed from: g, reason: collision with root package name */
    private j0.f f6321g;

    class a extends RecyclerView.C {

        /* renamed from: t, reason: collision with root package name */
        ImageView f6322t;

        /* renamed from: g0.h$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0082a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ h f6324a;

            ViewOnClickListenerC0082a(h hVar) {
                this.f6324a = hVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j0.e eVar = h.this.e;
                a aVar = a.this;
                eVar.p(h.this, aVar.m());
            }
        }

        class b implements View.OnLongClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ h f6326a;

            b(h hVar) {
                this.f6326a = hVar;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                j0.f fVar = h.this.f6321g;
                a aVar = a.this;
                fVar.Q(h.this, aVar.m());
                return true;
            }
        }

        public a(View view) {
            super(view);
            if (h.this.e != null) {
                view.setOnClickListener(new ViewOnClickListenerC0082a(h.this));
            }
            if (h.this.f6321g != null) {
                view.setOnLongClickListener(new b(h.this));
            }
            this.f6322t = (ImageView) view.findViewById(R.id.iv_item_photo_grid);
        }
    }

    public h(Context context, List list) {
        this.f6318c = context;
        this.f6319d = list;
        this.f6320f = Picasso.with(context);
    }

    public void A(j0.f fVar) {
        this.f6321g = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f6319d.size();
    }

    public m w(int i2) {
        if (i2 >= this.f6319d.size()) {
            return null;
        }
        return (m) this.f6319d.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void k(a aVar, int i2) {
        this.f6320f.load(((m) this.f6319d.get(i2)).a()).resize(320, 320).placeholder(R.drawable.ic_thumb_image).error(R.drawable.ic_thumb_image).centerCrop().into(aVar.f6322t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public a m(ViewGroup viewGroup, int i2) {
        return new a(View.inflate(this.f6318c, R.layout.item_photo_grid, null));
    }

    public void z(j0.e eVar) {
        this.e = eVar;
    }
}
