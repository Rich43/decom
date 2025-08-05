package g0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.caglobal.kodakluma.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import h0.C0260a;
import java.io.File;
import java.util.List;

/* renamed from: g0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0258a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Context f6253a;

    /* renamed from: b, reason: collision with root package name */
    private List f6254b;

    /* renamed from: c, reason: collision with root package name */
    private int f6255c;

    /* renamed from: d, reason: collision with root package name */
    private Picasso f6256d;
    private int e;

    /* renamed from: g0.a$a, reason: collision with other inner class name */
    class C0076a {

        /* renamed from: a, reason: collision with root package name */
        ImageView f6257a;

        /* renamed from: b, reason: collision with root package name */
        TextView f6258b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f6259c;

        C0076a() {
        }
    }

    public C0258a(Context context, List list) {
        this.f6253a = context;
        this.f6254b = list;
        this.f6256d = Picasso.with(context);
        this.e = this.f6253a.getResources().getDimensionPixelSize(R.dimen.size_50dp);
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0260a getItem(int i2) {
        return (C0260a) this.f6254b.get(i2);
    }

    public void b(int i2) {
        this.f6255c = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6254b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View viewInflate;
        C0076a c0076a;
        C0260a c0260a = (C0260a) this.f6254b.get(i2);
        if (view == null) {
            c0076a = new C0076a();
            viewInflate = View.inflate(this.f6253a, R.layout.item_album, null);
            c0076a.f6257a = (ImageView) viewInflate.findViewById(R.id.iv_photo_cover);
            c0076a.f6258b = (TextView) viewInflate.findViewById(R.id.tv_item_album_name);
            c0076a.f6259c = (ImageView) viewInflate.findViewById(R.id.iv_item_album_select);
            viewInflate.setTag(c0076a);
            RequestCreator requestCreatorError = this.f6256d.load(new File(c0260a.g())).placeholder(R.drawable.ic_thumb_image).error(R.drawable.ic_thumb_image);
            int i3 = this.e;
            requestCreatorError.resize(i3, i3).centerCrop().into(c0076a.f6257a);
        } else {
            viewInflate = view;
            c0076a = (C0076a) view.getTag();
        }
        c0076a.f6258b.setText(c0260a.h());
        c0076a.f6259c.setSelected(this.f6255c == i2);
        return viewInflate;
    }
}
