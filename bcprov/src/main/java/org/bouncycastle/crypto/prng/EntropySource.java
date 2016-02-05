<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
=======
package org.bouncycastle.crypto.prng;

/**
 * Base interface describing an entropy source for a DRBG.
 */
public interface EntropySource
{
    /**
     * Return whether or not this entropy source is regarded as prediction resistant.
     *
     * @return true if it is, false otherwise.
     */
    boolean isPredictionResistant();

    /**
     * Return a byte array of entropy.
     *
     * @return  entropy bytes.
     */
    byte[] getEntropy();

    /**
     * Return the number of bits of entropy this source can produce.
     *
     * @return size in bits of the return value of getEntropy.
     */
    int entropySize();
}
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
