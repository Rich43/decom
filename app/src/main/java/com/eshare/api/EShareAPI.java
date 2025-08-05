package com.eshare.api;

import android.content.Context;

/* loaded from: classes.dex */
public final class EShareAPI {

    /* renamed from: c, reason: collision with root package name */
    private static EShareAPI f5519c;

    /* renamed from: a, reason: collision with root package name */
    private final a f5520a;

    /* renamed from: b, reason: collision with root package name */
    private final b f5521b;

    private EShareAPI(Context context) {
        a aVar = new a(context);
        this.f5520a = aVar;
        this.f5521b = new b(context, aVar);
    }

    public static EShareAPI a(Context context) {
        if (f5519c == null) {
            synchronized (EShareAPI.class) {
                try {
                    if (f5519c == null) {
                        f5519c = new EShareAPI(context);
                    }
                } finally {
                }
            }
        }
        return f5519c;
    }

    public IEvent b() {
        return this.f5520a;
    }

    public String c() {
        this.f5520a.c();
        return null;
    }
}
