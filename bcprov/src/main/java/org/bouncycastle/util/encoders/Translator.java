<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
=======
package org.bouncycastle.util.encoders;

/**
 * General interface for a translator.
 */
public interface Translator
{
    /**
     * size of the output block on encoding produced by getDecodedBlockSize()
     * bytes.
     */
    public int getEncodedBlockSize();

    public int encode(byte[] in, int inOff, int length, byte[] out, int outOff);

    /**
     * size of the output block on decoding produced by getEncodedBlockSize()
     * bytes.
     */
    public int getDecodedBlockSize();

    public int decode(byte[] in, int inOff, int length, byte[] out, int outOff);
}
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
