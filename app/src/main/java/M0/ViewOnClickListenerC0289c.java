package m0;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.caglobal.kodakluma.R;

/* renamed from: m0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0289c extends Fragment implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private TextView f6605a;

    /* renamed from: b, reason: collision with root package name */
    private a f6606b;

    /* renamed from: m0.c$a */
    public interface a {
        void u();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f6605a.setOnClickListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f6606b = (a) getActivity();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.getId() == R.id.tv_connect_go && (aVar = this.f6606b) != null) {
            aVar.u();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_connect, viewGroup, false);
        this.f6605a = (TextView) viewInflate.findViewById(R.id.tv_connect_go);
        return viewInflate;
    }
}
