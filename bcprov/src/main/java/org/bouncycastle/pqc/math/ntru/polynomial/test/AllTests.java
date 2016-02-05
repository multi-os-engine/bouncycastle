<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
=======
package org.bouncycastle.pqc.math.ntru.polynomial.test;

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
        TestSuite suite = new TestSuite("NTRU Polynomial Tests");
        
        suite.addTestSuite(BigDecimalPolynomialTest.class);
        suite.addTestSuite(BigIntPolynomialTest.class);
        suite.addTestSuite(IntegerPolynomialTest.class);
        suite.addTestSuite(LongPolynomial2Test.class);
        suite.addTestSuite(LongPolynomial5Test.class);
        suite.addTestSuite(ProductFormPolynomialTest.class);
        suite.addTestSuite(SparseTernaryPolynomialTest.class);

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

        }

        protected void tearDown()
        {

        }
    }
}
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
