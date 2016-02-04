<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
=======
package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;

import javax.crypto.interfaces.DHPrivateKey;

public interface ElGamalPrivateKey
    extends ElGamalKey, DHPrivateKey
{
    public BigInteger getX();
}
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
