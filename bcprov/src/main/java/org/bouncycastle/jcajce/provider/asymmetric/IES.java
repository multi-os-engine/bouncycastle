<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
=======
package org.bouncycastle.jcajce.provider.asymmetric;

import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class IES
{
    private static final String PREFIX = "org.bouncycastle.jcajce.provider.asymmetric" + ".ies.";

    public static class Mappings
        extends AsymmetricAlgorithmProvider
    {
        public Mappings()
        {
        }

        public void configure(ConfigurableProvider provider)
        {
            provider.addAlgorithm("AlgorithmParameters.IES", PREFIX + "AlgorithmParametersSpi");
            provider.addAlgorithm("AlgorithmParameters.ECIES", PREFIX + "AlgorithmParametersSpi");
        }
    }
}
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
