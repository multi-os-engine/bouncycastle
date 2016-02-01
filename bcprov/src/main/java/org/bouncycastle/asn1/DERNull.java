package org.bouncycastle.asn1;

import java.io.IOException;

/**
 * A NULL object.
 */
public class DERNull
    extends ASN1Null
{
    public static final DERNull INSTANCE = new DERNull();

    private static final byte[]  zeroBytes = new byte[0];

    /**
     * @deprecated use DERNull.INSTANCE
     */
<<<<<<< HEAD   (9b30eb Merge "Add core-oj to the list of dependencies")
    // BEGIN android-changed
    protected DERNull()
    // END android-changed
=======
    public DERNull()
>>>>>>> BRANCH (6d876f Merge "Update elements in android tree as in aosp and goog T)
    {
    }

    boolean isConstructed()
    {
        return false;
    }

    int encodedLength()
    {
        return 2;
    }

    void encode(
        ASN1OutputStream out)
        throws IOException
    {
        out.writeEncoded(BERTags.NULL, zeroBytes);
    }
}
