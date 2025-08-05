package m0;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.caglobal.kodakluma.CustomApplication;
import com.caglobal.kodakluma.R;
import com.eshare.api.EShareAPI;
import com.eshare.api.IDevice;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import n0.C0296a;
import q0.C0315d;

/* renamed from: m0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0288b extends Fragment implements C0296a.d, j0.e {

    /* renamed from: a, reason: collision with root package name */
    private g0.i f6596a;

    /* renamed from: b, reason: collision with root package name */
    private RecyclerView f6597b;

    /* renamed from: c, reason: collision with root package name */
    private ProgressDialog f6598c;

    /* renamed from: d, reason: collision with root package name */
    private C0296a f6599d;
    private ExecutorService e;

    /* renamed from: f, reason: collision with root package name */
    private IDevice f6600f;

    /* renamed from: g, reason: collision with root package name */
    public InterfaceC0091b f6601g;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f6602h = Boolean.FALSE;

    /* renamed from: m0.b$a */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6603a;

        a(int i2) {
            this.f6603a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0288b.this.f6600f.startApp(C0288b.this.f6596a.x(this.f6603a).c());
            InterfaceC0091b interfaceC0091b = C0288b.this.f6601g;
            if (interfaceC0091b != null) {
                interfaceC0091b.H();
            }
        }
    }

    /* renamed from: m0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0091b {
        void H();
    }

    @Override // n0.C0296a.d
    public void F(boolean z2, List list) {
        this.f6598c.cancel();
        if (!z2) {
            if (this.f6602h.booleanValue()) {
                CustomApplication.f(R.string.program_list_failed);
                return;
            }
            this.f6602h = Boolean.TRUE;
            this.f6598c = C0315d.b(getContext());
            k();
            return;
        }
        g0.i iVar = new g0.i(getContext(), list, true);
        this.f6596a = iVar;
        iVar.A(this);
        RecyclerView recyclerView = this.f6597b;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
            this.f6597b.setAdapter(this.f6596a);
        }
    }

    public void k() {
        this.f6599d.i(getContext());
        this.f6598c.show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C0296a c0296aH = C0296a.h();
        this.f6599d = c0296aH;
        c0296aH.l(this);
        this.f6598c = C0315d.b(getContext());
        this.e = Executors.newSingleThreadExecutor();
        this.f6600f = EShareAPI.init(getContext()).device();
        k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f6601g = (InterfaceC0091b) getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.apps_layout, viewGroup, false);
        this.f6597b = (RecyclerView) viewInflate.findViewById(R.id.rv_app);
        return viewInflate;
    }

    @Override // j0.e
    public void p(RecyclerView.g gVar, int i2) {
        if (gVar == this.f6596a) {
            this.e.execute(new a(i2));
        }
    }
}
