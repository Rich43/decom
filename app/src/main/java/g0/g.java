package g0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.caglobal.kodakluma.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import h0.C0260a;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public class g extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private List f6305c;

    /* renamed from: d, reason: collision with root package name */
    private Picasso f6306d;
    private Context e;

    /* renamed from: f, reason: collision with root package name */
    private j0.e f6307f;

    /* renamed from: g, reason: collision with root package name */
    private int f6308g;

    /* renamed from: h, reason: collision with root package name */
    private j0.f f6309h;

    class a extends RecyclerView.C {

        /* renamed from: t, reason: collision with root package name */
        RelativeLayout f6310t;

        /* renamed from: u, reason: collision with root package name */
        ImageView f6311u;

        /* renamed from: v, reason: collision with root package name */
        TextView f6312v;

        /* renamed from: g0.g$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0081a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f6314a;

            ViewOnClickListenerC0081a(g gVar) {
                this.f6314a = gVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j0.e eVar = g.this.f6307f;
                a aVar = a.this;
                eVar.p(g.this, aVar.m());
            }
        }

        class b implements View.OnLongClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f6316a;

            b(g gVar) {
                this.f6316a = gVar;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                j0.f fVar = g.this.f6309h;
                a aVar = a.this;
                fVar.Q(g.this, aVar.m());
                return true;
            }
        }

        public a(View view) {
            super(view);
            this.f6310t = (RelativeLayout) view.findViewById(R.id.rl_item_photo_list);
            if (g.this.f6307f != null) {
                this.f6310t.setOnClickListener(new ViewOnClickListenerC0081a(g.this));
            }
            if (g.this.f6309h != null) {
                view.setOnLongClickListener(new b(g.this));
            }
            this.f6311u = (ImageView) view.findViewById(R.id.iv_bg_album);
            this.f6312v = (TextView) view.findViewById(R.id.tv_item_album_name);
        }
    }

    public g(Context context, List list) {
        this.e = context;
        this.f6305c = list;
        this.f6306d = Picasso.with(context);
        this.f6308g = this.e.getResources().getDimensionPixelSize(R.dimen.size_120dp);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f6305c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void k(a aVar, int i2) {
        C0260a c0260a = (C0260a) this.f6305c.get(i2);
        RequestCreator requestCreatorError = this.f6306d.load(new File(c0260a.g())).placeholder(R.drawable.ic_thumb_image).error(R.drawable.ic_thumb_image);
        int i3 = this.f6308g;
        requestCreatorError.resize(i3, i3).centerCrop().into(aVar.f6311u);
        aVar.f6312v.setText(c0260a.h());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public a m(ViewGroup viewGroup, int i2) {
        return new a(View.inflate(this.e, R.layout.item_photo_list, null));
    }

    public void y(j0.e eVar) {
        this.f6307f = eVar;
    }

    public void z(j0.f fVar) {
        this.f6309h = fVar;
    }
}
