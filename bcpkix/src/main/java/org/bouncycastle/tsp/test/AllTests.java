<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
=======
package org.bouncycastle.tsp.test;

import java.security.Security;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests
    extends TestCase
{
    public static void main (String[] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite()
    {
        TestSuite suite = new TestSuite("TSP Tests");
        
        suite.addTestSuite(ParseTest.class);
        suite.addTestSuite(NewTSPTest.class);
        suite.addTestSuite(CMSTimeStampedDataTest.class);
        suite.addTestSuite(CMSTimeStampedDataParserTest.class);
        suite.addTestSuite(CMSTimeStampedDataGeneratorTest.class);
        suite.addTestSuite(GenTimeAccuracyUnitTest.class);
        suite.addTestSuite(TimeStampTokenInfoUnitTest.class);

        return new BCTestSetup(suite);
    }

    static class BCTestSetup
        extends TestSetup
    {
        public BCTestSetup(Test test)
        {
            super(test);
        }

        protected void setUp()
        {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        }

        protected void tearDown()
        {
            Security.removeProvider("BC");
        }
    }
}
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
