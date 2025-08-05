package g0;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.caglobal.kodakluma.R;
import h0.n;
import java.util.List;
import l0.C0278b;

/* loaded from: classes.dex */
public class j extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private Context f6339c;

    /* renamed from: d, reason: collision with root package name */
    private List f6340d;
    private j0.e e;

    /* renamed from: f, reason: collision with root package name */
    private C0278b f6341f;

    /* renamed from: g, reason: collision with root package name */
    private j0.f f6342g;

    class b extends RecyclerView.C {

        /* renamed from: t, reason: collision with root package name */
        CardView f6345t;

        /* renamed from: u, reason: collision with root package name */
        ImageView f6346u;

        /* renamed from: v, reason: collision with root package name */
        TextView f6347v;

        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ j f6349a;

            a(j jVar) {
                this.f6349a = jVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j0.e eVar = j.this.e;
                b bVar = b.this;
                eVar.p(j.this, bVar.m());
            }
        }

        /* renamed from: g0.j$b$b, reason: collision with other inner class name */
        class ViewOnLongClickListenerC0084b implements View.OnLongClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ j f6351a;

            ViewOnLongClickListenerC0084b(j jVar) {
                this.f6351a = jVar;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                j0.f fVar = j.this.f6342g;
                b bVar = b.this;
                fVar.Q(j.this, bVar.m());
                return true;
            }
        }

        public b(View view) {
            super(view);
            this.f6345t = (CardView) view.findViewById(R.id.rl_item_video_grid);
            if (j.this.e != null) {
                this.f6345t.setOnClickListener(new a(j.this));
            }
            if (j.this.f6342g != null) {
                view.setOnLongClickListener(new ViewOnLongClickListenerC0084b(j.this));
            }
            this.f6346u = (ImageView) view.findViewById(R.id.iv_item_video_grid_icon);
            this.f6347v = (TextView) view.findViewById(R.id.tv_item_video_grid_duration);
        }
    }

    public j(Context context, List list) {
        this.f6339c = context;
        this.f6340d = list;
    }

    public void A(j0.e eVar) {
        this.e = eVar;
    }

    public void B(j0.f fVar) {
        this.f6342g = fVar;
    }

    public void C(C0278b c0278b) {
        this.f6341f = c0278b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f6340d.size();
    }

    public n w(int i2) {
        if (i2 >= this.f6340d.size()) {
            return null;
        }
        return (n) this.f6340d.get(i2);
    }

    public List x() {
        return this.f6340d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void k(b bVar, int i2) {
        n nVar = (n) this.f6340d.get(i2);
        bVar.f6346u.setTag(nVar.c());
        bVar.f6346u.setImageResource(R.drawable.ic_thumb_video);
        this.f6341f.e(nVar, new a(bVar));
        bVar.f6347v.setText(nVar.h());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public b m(ViewGroup viewGroup, int i2) {
        return new b(View.inflate(this.f6339c, R.layout.item_video_grid, null));
    }

    class a implements C0278b.InterfaceC0090b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f6343a;

        a(b bVar) {
            this.f6343a = bVar;
        }

        @Override // l0.C0278b.InterfaceC0090b
        public void a(Bitmap bitmap, String str) {
            if (str.equals(this.f6343a.f6346u.getTag())) {
                this.f6343a.f6346u.setImageBitmap(bitmap);
            }
        }

        @Override // l0.C0278b.InterfaceC0090b
        public void onError(String str) {
        }
    }
}
