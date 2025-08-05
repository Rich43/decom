package com.github.promeg.pinyinhelper;

/* loaded from: classes.dex */
public final class Pinyin {
    private Pinyin() {
    }

    private static short decodeIndex(byte[] bArr, byte[] bArr2, int i2) {
        int i3 = i2 % 8;
        short s = (short) (bArr2[i2] & 255);
        return (bArr[i2 / 8] & PinyinData.BIT_MASKS[i3]) != 0 ? (short) (s | 256) : s;
    }

    private static int getPinyinCode(char c2) {
        int i2 = c2 - 19968;
        return (i2 < 0 || i2 >= 7000) ? (7000 > i2 || i2 >= 14000) ? decodeIndex(PinyinCode3.PINYIN_CODE_PADDING, PinyinCode3.PINYIN_CODE, c2 - 33968) : decodeIndex(PinyinCode2.PINYIN_CODE_PADDING, PinyinCode2.PINYIN_CODE, c2 - 26968) : decodeIndex(PinyinCode1.PINYIN_CODE_PADDING, PinyinCode1.PINYIN_CODE, i2);
    }

    public static boolean isChinese(char c2) {
        return (19968 <= c2 && c2 <= 40869 && getPinyinCode(c2) > 0) || 12295 == c2;
    }

    public static String toPinyin(char c2) {
        return isChinese(c2) ? c2 == 12295 ? "LING" : PinyinData.PINYIN_TABLE[getPinyinCode(c2)] : String.valueOf(c2);
    }
}
