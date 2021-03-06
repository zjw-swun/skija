package org.jetbrains.skija;

public class SkFont extends Managed {
    public final SkTypeface typeface;
    public SkFont(SkTypeface typeface, float size) {
        super(nInit(typeface.nativeInstance, size), nativeFinalizer);
        Native.onNativeCall(); 
        this.typeface = typeface;
    }

    public TextBlob shape(String str, float width) {
        return new TextBlob(nShape(nativeInstance, str, width));
    }

    private static final long nativeFinalizer = nGetNativeFinalizer();
    private static native long nInit(long typefacePtr, float size);
    private static native long nGetNativeFinalizer();
    private static native long nShape(long ptr, String str, float width);
}