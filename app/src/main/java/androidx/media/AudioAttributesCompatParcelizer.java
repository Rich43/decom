package androidx.media;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(androidx.versionedparcelable.a aVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f3769a = (AudioAttributesImpl) aVar.v(audioAttributesCompat.f3769a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, androidx.versionedparcelable.a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        aVar.x(false, false);
        aVar.M(audioAttributesCompat.f3769a, 1);
    }
}
