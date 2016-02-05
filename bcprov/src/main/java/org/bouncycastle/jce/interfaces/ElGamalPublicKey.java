<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
=======
package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;

import javax.crypto.interfaces.DHPublicKey;

public interface ElGamalPublicKey
    extends ElGamalKey, DHPublicKey
{
    public BigInteger getY();
}
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
