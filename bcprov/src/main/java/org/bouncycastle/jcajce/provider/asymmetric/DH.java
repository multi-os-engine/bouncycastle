package org.bouncycastle.jcajce.provider.asymmetric;

import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.dh.KeyFactorySpi;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class DH
{
    private static final String PREFIX = "org.bouncycastle.jcajce.provider.asymmetric" + ".dh.";

    public static class Mappings
        extends AsymmetricAlgorithmProvider
    {
        public Mappings()
        {
        }

        public void configure(ConfigurableProvider provider)
        {
            provider.addAlgorithm("KeyPairGenerator.DH", PREFIX + "KeyPairGeneratorSpi");
            provider.addAlgorithm("Alg.Alias.KeyPairGenerator.DIFFIEHELLMAN", "DH");

            provider.addAlgorithm("KeyAgreement.DH", PREFIX + "KeyAgreementSpi");
            // BEGIN android-added
            provider.addAlgorithm("KeyAgreement.DH SupportedKeyClasses",
                    "javax.crypto.interfaces.DHPrivateKey");
            // END android-added
            provider.addAlgorithm("Alg.Alias.KeyAgreement.DIFFIEHELLMAN", "DH");

            provider.addAlgorithm("KeyFactory.DH", PREFIX + "KeyFactorySpi");
            provider.addAlgorithm("Alg.Alias.KeyFactory.DIFFIEHELLMAN", "DH");

            provider.addAlgorithm("AlgorithmParameters.DH", PREFIX + "AlgorithmParametersSpi");
            provider.addAlgorithm("Alg.Alias.AlgorithmParameters.DIFFIEHELLMAN", "DH");

            provider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.DIFFIEHELLMAN", "DH");

            provider.addAlgorithm("AlgorithmParameterGenerator.DH", PREFIX + "AlgorithmParameterGeneratorSpi");
            
            // BEGIN android-removed
            // provider.addAlgorithm("Cipher.DHIES", PREFIX + "IESCipher$IES");
            // provider.addAlgorithm("Cipher.DHIESwithAES", PREFIX + "IESCipher$IESwithAES");
            // provider.addAlgorithm("Cipher.DHIESWITHAES", PREFIX + "IESCipher$IESwithAES");
            // provider.addAlgorithm("Cipher.DHIESWITHDESEDE", PREFIX + "IESCipher$IESwithDESede");
            // END android-removed

            registerOid(provider, PKCSObjectIdentifiers.dhKeyAgreement, "DH", new KeyFactorySpi());
            registerOid(provider, X9ObjectIdentifiers.dhpublicnumber, "DH", new KeyFactorySpi());
        }
    }
}
