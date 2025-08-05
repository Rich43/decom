package androidx.media;

/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(androidx.versionedparcelable.a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f3772a = aVar.p(audioAttributesImplBase.f3772a, 1);
        audioAttributesImplBase.f3773b = aVar.p(audioAttributesImplBase.f3773b, 2);
        audioAttributesImplBase.f3774c = aVar.p(audioAttributesImplBase.f3774c, 3);
        audioAttributesImplBase.f3775d = aVar.p(audioAttributesImplBase.f3775d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.F(audioAttributesImplBase.f3772a, 1);
        aVar.F(audioAttributesImplBase.f3773b, 2);
        aVar.F(audioAttributesImplBase.f3774c, 3);
        aVar.F(audioAttributesImplBase.f3775d, 4);
    }
}
