package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Q;
import androidx.core.view.M;
import androidx.core.widget.NestedScrollView;
import defpackage.e;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class AlertController {

    /* renamed from: A, reason: collision with root package name */
    NestedScrollView f1543A;

    /* renamed from: C, reason: collision with root package name */
    private Drawable f1545C;

    /* renamed from: D, reason: collision with root package name */
    private ImageView f1546D;

    /* renamed from: E, reason: collision with root package name */
    private TextView f1547E;

    /* renamed from: F, reason: collision with root package name */
    private TextView f1548F;

    /* renamed from: G, reason: collision with root package name */
    private View f1549G;

    /* renamed from: H, reason: collision with root package name */
    ListAdapter f1550H;

    /* renamed from: J, reason: collision with root package name */
    private int f1552J;

    /* renamed from: K, reason: collision with root package name */
    private int f1553K;

    /* renamed from: L, reason: collision with root package name */
    int f1554L;

    /* renamed from: M, reason: collision with root package name */
    int f1555M;

    /* renamed from: N, reason: collision with root package name */
    int f1556N;

    /* renamed from: O, reason: collision with root package name */
    int f1557O;

    /* renamed from: P, reason: collision with root package name */
    private boolean f1558P;

    /* renamed from: R, reason: collision with root package name */
    Handler f1560R;

    /* renamed from: a, reason: collision with root package name */
    private final Context f1562a;

    /* renamed from: b, reason: collision with root package name */
    final x f1563b;

    /* renamed from: c, reason: collision with root package name */
    private final Window f1564c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1565d;
    private CharSequence e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f1566f;

    /* renamed from: g, reason: collision with root package name */
    ListView f1567g;

    /* renamed from: h, reason: collision with root package name */
    private View f1568h;

    /* renamed from: i, reason: collision with root package name */
    private int f1569i;

    /* renamed from: j, reason: collision with root package name */
    private int f1570j;

    /* renamed from: k, reason: collision with root package name */
    private int f1571k;

    /* renamed from: l, reason: collision with root package name */
    private int f1572l;

    /* renamed from: m, reason: collision with root package name */
    private int f1573m;
    Button o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f1575p;

    /* renamed from: q, reason: collision with root package name */
    Message f1576q;
    private Drawable r;
    Button s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f1577t;

    /* renamed from: u, reason: collision with root package name */
    Message f1578u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f1579v;

    /* renamed from: w, reason: collision with root package name */
    Button f1580w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f1581x;

    /* renamed from: y, reason: collision with root package name */
    Message f1582y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f1583z;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1574n = false;

    /* renamed from: B, reason: collision with root package name */
    private int f1544B = 0;

    /* renamed from: I, reason: collision with root package name */
    int f1551I = -1;

    /* renamed from: Q, reason: collision with root package name */
    private int f1559Q = 0;

    /* renamed from: S, reason: collision with root package name */
    private final View.OnClickListener f1561S = new a();

    public static class RecycleListView extends ListView {

        /* renamed from: a, reason: collision with root package name */
        private final int f1584a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1585b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.m.c2);
            this.f1585b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(e.m.d2, -1);
            this.f1584a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(e.m.e2, -1);
        }

        public void a(boolean z2, boolean z3) {
            if (z3 && z2) {
                return;
            }
            setPadding(getPaddingLeft(), z2 ? getPaddingTop() : this.f1584a, getPaddingRight(), z3 ? getPaddingBottom() : this.f1585b);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message messageObtain = (view != alertController.o || (message3 = alertController.f1576q) == null) ? (view != alertController.s || (message2 = alertController.f1578u) == null) ? (view != alertController.f1580w || (message = alertController.f1582y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f1560R.obtainMessage(1, alertController2.f1563b).sendToTarget();
        }
    }

    class b implements NestedScrollView.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f1587a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1588b;

        b(View view, View view2) {
            this.f1587a = view;
            this.f1588b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.d
        public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            AlertController.g(nestedScrollView, this.f1587a, this.f1588b);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f1590a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1591b;

        c(View view, View view2) {
            this.f1590a = view;
            this.f1591b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.f1543A, this.f1590a, this.f1591b);
        }
    }

    class d implements AbsListView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f1593a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1594b;

        d(View view, View view2) {
            this.f1593a = view;
            this.f1594b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AlertController.g(absListView, this.f1593a, this.f1594b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f1596a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1597b;

        e(View view, View view2) {
            this.f1596a = view;
            this.f1597b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.f1567g, this.f1596a, this.f1597b);
        }
    }

    public static class f {

        /* renamed from: A, reason: collision with root package name */
        public int f1599A;

        /* renamed from: B, reason: collision with root package name */
        public int f1600B;

        /* renamed from: C, reason: collision with root package name */
        public int f1601C;

        /* renamed from: D, reason: collision with root package name */
        public int f1602D;

        /* renamed from: F, reason: collision with root package name */
        public boolean[] f1604F;

        /* renamed from: G, reason: collision with root package name */
        public boolean f1605G;

        /* renamed from: H, reason: collision with root package name */
        public boolean f1606H;

        /* renamed from: J, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f1608J;

        /* renamed from: K, reason: collision with root package name */
        public Cursor f1609K;

        /* renamed from: L, reason: collision with root package name */
        public String f1610L;

        /* renamed from: M, reason: collision with root package name */
        public String f1611M;

        /* renamed from: N, reason: collision with root package name */
        public AdapterView.OnItemSelectedListener f1612N;

        /* renamed from: a, reason: collision with root package name */
        public final Context f1614a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f1615b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f1617d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f1618f;

        /* renamed from: g, reason: collision with root package name */
        public View f1619g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f1620h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f1621i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f1622j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f1623k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f1624l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f1625m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f1626n;
        public CharSequence o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f1627p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f1628q;
        public DialogInterface.OnCancelListener s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f1629t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f1630u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f1631v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f1632w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f1633x;

        /* renamed from: y, reason: collision with root package name */
        public int f1634y;

        /* renamed from: z, reason: collision with root package name */
        public View f1635z;

        /* renamed from: c, reason: collision with root package name */
        public int f1616c = 0;
        public int e = 0;

        /* renamed from: E, reason: collision with root package name */
        public boolean f1603E = false;

        /* renamed from: I, reason: collision with root package name */
        public int f1607I = -1;

        /* renamed from: O, reason: collision with root package name */
        public boolean f1613O = true;
        public boolean r = true;

        class a extends ArrayAdapter {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f1636a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i2, int i3, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i2, i3, charSequenceArr);
                this.f1636a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i2, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i2, view, viewGroup);
                boolean[] zArr = f.this.f1604F;
                if (zArr != null && zArr[i2]) {
                    this.f1636a.setItemChecked(i2, true);
                }
                return view2;
            }
        }

        class b extends CursorAdapter {

            /* renamed from: a, reason: collision with root package name */
            private final int f1638a;

            /* renamed from: b, reason: collision with root package name */
            private final int f1639b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ RecycleListView f1640c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AlertController f1641d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z2, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z2);
                this.f1640c = recycleListView;
                this.f1641d = alertController;
                Cursor cursor2 = getCursor();
                this.f1638a = cursor2.getColumnIndexOrThrow(f.this.f1610L);
                this.f1639b = cursor2.getColumnIndexOrThrow(f.this.f1611M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f1638a));
                this.f1640c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f1639b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f1615b.inflate(this.f1641d.f1555M, viewGroup, false);
            }
        }

        class c implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AlertController f1642a;

            c(AlertController alertController) {
                this.f1642a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                f.this.f1633x.onClick(this.f1642a.f1563b, i2);
                if (f.this.f1606H) {
                    return;
                }
                this.f1642a.f1563b.dismiss();
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f1644a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AlertController f1645b;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f1644a = recycleListView;
                this.f1645b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                boolean[] zArr = f.this.f1604F;
                if (zArr != null) {
                    zArr[i2] = this.f1644a.isItemChecked(i2);
                }
                f.this.f1608J.onClick(this.f1645b.f1563b, i2, this.f1644a.isItemChecked(i2));
            }
        }

        public f(Context context) {
            this.f1614a = context;
            this.f1615b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            ListAdapter hVar;
            RecycleListView recycleListView = (RecycleListView) this.f1615b.inflate(alertController.f1554L, (ViewGroup) null);
            if (this.f1605G) {
                hVar = this.f1609K == null ? new a(this.f1614a, alertController.f1555M, R.id.text1, this.f1631v, recycleListView) : new b(this.f1614a, this.f1609K, false, recycleListView, alertController);
            } else {
                int i2 = this.f1606H ? alertController.f1556N : alertController.f1557O;
                if (this.f1609K != null) {
                    hVar = new SimpleCursorAdapter(this.f1614a, i2, this.f1609K, new String[]{this.f1610L}, new int[]{R.id.text1});
                } else {
                    hVar = this.f1632w;
                    if (hVar == null) {
                        hVar = new h(this.f1614a, i2, R.id.text1, this.f1631v);
                    }
                }
            }
            alertController.f1550H = hVar;
            alertController.f1551I = this.f1607I;
            if (this.f1633x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.f1608J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f1612N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.f1606H) {
                recycleListView.setChoiceMode(1);
            } else if (this.f1605G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f1567g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f1619g;
            if (view != null) {
                alertController.m(view);
            } else {
                CharSequence charSequence = this.f1618f;
                if (charSequence != null) {
                    alertController.r(charSequence);
                }
                Drawable drawable = this.f1617d;
                if (drawable != null) {
                    alertController.o(drawable);
                }
                int i2 = this.f1616c;
                if (i2 != 0) {
                    alertController.n(i2);
                }
                int i3 = this.e;
                if (i3 != 0) {
                    alertController.n(alertController.d(i3));
                }
            }
            CharSequence charSequence2 = this.f1620h;
            if (charSequence2 != null) {
                alertController.p(charSequence2);
            }
            CharSequence charSequence3 = this.f1621i;
            if (charSequence3 != null || this.f1622j != null) {
                alertController.l(-1, charSequence3, this.f1623k, null, this.f1622j);
            }
            CharSequence charSequence4 = this.f1624l;
            if (charSequence4 != null || this.f1625m != null) {
                alertController.l(-2, charSequence4, this.f1626n, null, this.f1625m);
            }
            CharSequence charSequence5 = this.o;
            if (charSequence5 != null || this.f1627p != null) {
                alertController.l(-3, charSequence5, this.f1628q, null, this.f1627p);
            }
            if (this.f1631v != null || this.f1609K != null || this.f1632w != null) {
                b(alertController);
            }
            View view2 = this.f1635z;
            if (view2 != null) {
                if (this.f1603E) {
                    alertController.u(view2, this.f1599A, this.f1600B, this.f1601C, this.f1602D);
                    return;
                } else {
                    alertController.t(view2);
                    return;
                }
            }
            int i4 = this.f1634y;
            if (i4 != 0) {
                alertController.s(i4);
            }
        }
    }

    private static final class g extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference f1647a;

        public g(DialogInterface dialogInterface) {
            this.f1647a = new WeakReference(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f1647a.get(), message.what);
            } else {
                if (i2 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class h extends ArrayAdapter {
        public h(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, x xVar, Window window) {
        this.f1562a = context;
        this.f1563b = xVar;
        this.f1564c = window;
        this.f1560R = new g(xVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, e.m.f5982F, e.d.f5845k, 0);
        this.f1552J = typedArrayObtainStyledAttributes.getResourceId(e.m.f5984G, 0);
        this.f1553K = typedArrayObtainStyledAttributes.getResourceId(e.m.f5988I, 0);
        this.f1554L = typedArrayObtainStyledAttributes.getResourceId(e.m.f5992K, 0);
        this.f1555M = typedArrayObtainStyledAttributes.getResourceId(e.m.f5994L, 0);
        this.f1556N = typedArrayObtainStyledAttributes.getResourceId(e.m.f5998N, 0);
        this.f1557O = typedArrayObtainStyledAttributes.getResourceId(e.m.f5990J, 0);
        this.f1558P = typedArrayObtainStyledAttributes.getBoolean(e.m.f5996M, true);
        this.f1565d = typedArrayObtainStyledAttributes.getDimensionPixelSize(e.m.f5986H, 0);
        typedArrayObtainStyledAttributes.recycle();
        xVar.i(1);
    }

    private static boolean A(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(e.d.f5844j, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void g(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private ViewGroup j(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int k() {
        int i2 = this.f1553K;
        return i2 == 0 ? this.f1552J : this.f1559Q == 1 ? i2 : this.f1552J;
    }

    private void q(ViewGroup viewGroup, View view, int i2, int i3) {
        View viewFindViewById = this.f1564c.findViewById(e.i.f5937u);
        View viewFindViewById2 = this.f1564c.findViewById(e.i.f5936t);
        if (Build.VERSION.SDK_INT >= 23) {
            M.v0(view, i2, i3);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        if (viewFindViewById != null && (i2 & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 != null && (i2 & 2) == 0) {
            viewGroup.removeView(viewFindViewById2);
            viewFindViewById2 = null;
        }
        if (viewFindViewById == null && viewFindViewById2 == null) {
            return;
        }
        if (this.f1566f != null) {
            this.f1543A.setOnScrollChangeListener(new b(viewFindViewById, viewFindViewById2));
            this.f1543A.post(new c(viewFindViewById, viewFindViewById2));
            return;
        }
        ListView listView = this.f1567g;
        if (listView != null) {
            listView.setOnScrollListener(new d(viewFindViewById, viewFindViewById2));
            this.f1567g.post(new e(viewFindViewById, viewFindViewById2));
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    private void v(ViewGroup viewGroup) {
        int i2;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.o = button;
        button.setOnClickListener(this.f1561S);
        if (TextUtils.isEmpty(this.f1575p) && this.r == null) {
            this.o.setVisibility(8);
            i2 = 0;
        } else {
            this.o.setText(this.f1575p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i3 = this.f1565d;
                drawable.setBounds(0, 0, i3, i3);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.o.setVisibility(0);
            i2 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.s = button2;
        button2.setOnClickListener(this.f1561S);
        if (TextUtils.isEmpty(this.f1577t) && this.f1579v == null) {
            this.s.setVisibility(8);
        } else {
            this.s.setText(this.f1577t);
            Drawable drawable2 = this.f1579v;
            if (drawable2 != null) {
                int i4 = this.f1565d;
                drawable2.setBounds(0, 0, i4, i4);
                this.s.setCompoundDrawables(this.f1579v, null, null, null);
            }
            this.s.setVisibility(0);
            i2 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f1580w = button3;
        button3.setOnClickListener(this.f1561S);
        if (TextUtils.isEmpty(this.f1581x) && this.f1583z == null) {
            this.f1580w.setVisibility(8);
        } else {
            this.f1580w.setText(this.f1581x);
            Drawable drawable3 = this.f1583z;
            if (drawable3 != null) {
                int i5 = this.f1565d;
                drawable3.setBounds(0, 0, i5, i5);
                this.f1580w.setCompoundDrawables(this.f1583z, null, null, null);
            }
            this.f1580w.setVisibility(0);
            i2 |= 4;
        }
        if (A(this.f1562a)) {
            if (i2 == 1) {
                b(this.o);
            } else if (i2 == 2) {
                b(this.s);
            } else if (i2 == 4) {
                b(this.f1580w);
            }
        }
        if (i2 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void w(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f1564c.findViewById(e.i.f5938v);
        this.f1543A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f1543A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.f1548F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f1566f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f1543A.removeView(this.f1548F);
        if (this.f1567g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f1543A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.f1543A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f1567g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void x(ViewGroup viewGroup) {
        View viewInflate = this.f1568h;
        if (viewInflate == null) {
            viewInflate = this.f1569i != 0 ? LayoutInflater.from(this.f1562a).inflate(this.f1569i, viewGroup, false) : null;
        }
        boolean z2 = viewInflate != null;
        if (!z2 || !a(viewInflate)) {
            this.f1564c.setFlags(131072, 131072);
        }
        if (!z2) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f1564c.findViewById(e.i.f5933n);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f1574n) {
            frameLayout.setPadding(this.f1570j, this.f1571k, this.f1572l, this.f1573m);
        }
        if (this.f1567g != null) {
            ((LinearLayout.LayoutParams) ((Q.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    private void y(ViewGroup viewGroup) {
        if (this.f1549G != null) {
            viewGroup.addView(this.f1549G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f1564c.findViewById(e.i.f5919E).setVisibility(8);
            return;
        }
        this.f1546D = (ImageView) this.f1564c.findViewById(R.id.icon);
        if (TextUtils.isEmpty(this.e) || !this.f1558P) {
            this.f1564c.findViewById(e.i.f5919E).setVisibility(8);
            this.f1546D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f1564c.findViewById(e.i.f5929j);
        this.f1547E = textView;
        textView.setText(this.e);
        int i2 = this.f1544B;
        if (i2 != 0) {
            this.f1546D.setImageResource(i2);
            return;
        }
        Drawable drawable = this.f1545C;
        if (drawable != null) {
            this.f1546D.setImageDrawable(drawable);
        } else {
            this.f1547E.setPadding(this.f1546D.getPaddingLeft(), this.f1546D.getPaddingTop(), this.f1546D.getPaddingRight(), this.f1546D.getPaddingBottom());
            this.f1546D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f1564c.findViewById(e.i.s);
        int i2 = e.i.f5920F;
        View viewFindViewById4 = viewFindViewById3.findViewById(i2);
        int i3 = e.i.f5932m;
        View viewFindViewById5 = viewFindViewById3.findViewById(i3);
        int i4 = e.i.f5930k;
        View viewFindViewById6 = viewFindViewById3.findViewById(i4);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(e.i.o);
        x(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i2);
        View viewFindViewById8 = viewGroup.findViewById(i3);
        View viewFindViewById9 = viewGroup.findViewById(i4);
        ViewGroup viewGroupJ = j(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupJ2 = j(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupJ3 = j(viewFindViewById9, viewFindViewById6);
        w(viewGroupJ2);
        v(viewGroupJ3);
        y(viewGroupJ);
        boolean z2 = viewGroup.getVisibility() != 8;
        boolean z3 = (viewGroupJ == null || viewGroupJ.getVisibility() == 8) ? 0 : 1;
        boolean z4 = (viewGroupJ3 == null || viewGroupJ3.getVisibility() == 8) ? false : true;
        if (!z4 && viewGroupJ2 != null && (viewFindViewById2 = viewGroupJ2.findViewById(e.i.f5915A)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z3 != 0) {
            NestedScrollView nestedScrollView = this.f1543A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f1566f == null && this.f1567g == null) ? null : viewGroupJ.findViewById(e.i.f5918D);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupJ2 != null && (viewFindViewById = viewGroupJ2.findViewById(e.i.f5916B)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f1567g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z3, z4);
        }
        if (!z2) {
            View view = this.f1567g;
            if (view == null) {
                view = this.f1543A;
            }
            if (view != null) {
                q(viewGroupJ2, view, z3 | (z4 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f1567g;
        if (listView2 == null || (listAdapter = this.f1550H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i5 = this.f1551I;
        if (i5 > -1) {
            listView2.setItemChecked(i5, true);
            listView2.setSelection(i5);
        }
    }

    public Button c(int i2) {
        if (i2 == -3) {
            return this.f1580w;
        }
        if (i2 == -2) {
            return this.s;
        }
        if (i2 != -1) {
            return null;
        }
        return this.o;
    }

    public int d(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f1562a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f1567g;
    }

    public void f() {
        this.f1563b.setContentView(k());
        z();
    }

    public boolean h(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f1543A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public boolean i(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f1543A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public void l(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f1560R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.f1581x = charSequence;
            this.f1582y = message;
            this.f1583z = drawable;
        } else if (i2 == -2) {
            this.f1577t = charSequence;
            this.f1578u = message;
            this.f1579v = drawable;
        } else {
            if (i2 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f1575p = charSequence;
            this.f1576q = message;
            this.r = drawable;
        }
    }

    public void m(View view) {
        this.f1549G = view;
    }

    public void n(int i2) {
        this.f1545C = null;
        this.f1544B = i2;
        ImageView imageView = this.f1546D;
        if (imageView != null) {
            if (i2 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f1546D.setImageResource(this.f1544B);
            }
        }
    }

    public void o(Drawable drawable) {
        this.f1545C = drawable;
        this.f1544B = 0;
        ImageView imageView = this.f1546D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f1546D.setImageDrawable(drawable);
            }
        }
    }

    public void p(CharSequence charSequence) {
        this.f1566f = charSequence;
        TextView textView = this.f1548F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(CharSequence charSequence) {
        this.e = charSequence;
        TextView textView = this.f1547E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void s(int i2) {
        this.f1568h = null;
        this.f1569i = i2;
        this.f1574n = false;
    }

    public void t(View view) {
        this.f1568h = view;
        this.f1569i = 0;
        this.f1574n = false;
    }

    public void u(View view, int i2, int i3, int i4, int i5) {
        this.f1568h = view;
        this.f1569i = 0;
        this.f1574n = true;
        this.f1570j = i2;
        this.f1571k = i3;
        this.f1572l = i4;
        this.f1573m = i5;
    }
}
