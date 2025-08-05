package m0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.caglobal.kodakluma.R;

/* loaded from: classes.dex */
public class m extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f6684a;

    /* renamed from: b, reason: collision with root package name */
    private b f6685b;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.f6685b != null) {
                m.this.f6685b.j();
            }
        }
    }

    public interface b {
        void j();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.update_note, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6685b = (b) getActivity();
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_note_back);
        this.f6684a = imageView;
        imageView.setOnClickListener(new a());
    }
}
