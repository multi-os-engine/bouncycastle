<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
=======
package org.bouncycastle.pqc.jcajce.provider.test;

import java.security.KeyPairGenerator;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;

import org.bouncycastle.pqc.jcajce.spec.ECCKeyGenParameterSpec;


public class McElieceKobaraImaiCipherTest
    extends AsymmetricHybridCipherTest
{

    protected void setUp()
    {
        super.setUp();
        try
        {
            kpg = KeyPairGenerator.getInstance("McElieceKobaraImai");
            cipher = Cipher.getInstance("McElieceKobaraImaiWithSHA256");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Test encryption and decryption performance for SHA256 message digest and parameters
     * m=11, t=50.
     */
    public void testEnDecryption_SHA256_11_50()
        throws Exception
    {
        // initialize key pair generator
        AlgorithmParameterSpec kpgParams = new ECCKeyGenParameterSpec(11, 50);
        kpg.initialize(kpgParams);

        performEnDecryptionTest(0, 10, 32, null);       // TODO:  McElieceKobaraImai is broken
    }

}
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)