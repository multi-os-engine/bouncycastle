<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
=======
package org.bouncycastle.cert.jcajce;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509ExtensionUtils;
import org.bouncycastle.operator.DigestCalculator;

public class JcaX509ExtensionUtils
    extends X509ExtensionUtils
{
    /**
     * Create a utility class pre-configured with a SHA-1 digest calculator based on the
     * default implementation.
     *
     * @throws NoSuchAlgorithmException
     */
    public JcaX509ExtensionUtils()
        throws NoSuchAlgorithmException
    {
        super(new SHA1DigestCalculator(MessageDigest.getInstance("SHA1")));
    }

    public JcaX509ExtensionUtils(DigestCalculator calculator)
    {
        super(calculator);
    }

    public AuthorityKeyIdentifier createAuthorityKeyIdentifier(
        X509Certificate cert)
        throws CertificateEncodingException
    {
        return super.createAuthorityKeyIdentifier(new JcaX509CertificateHolder(cert));
    }

    public AuthorityKeyIdentifier createAuthorityKeyIdentifier(
        PublicKey pubKey)
    {
        return super.createAuthorityKeyIdentifier(SubjectPublicKeyInfo.getInstance(pubKey.getEncoded()));
    }

    public AuthorityKeyIdentifier createAuthorityKeyIdentifier(PublicKey pubKey, X500Principal name, BigInteger serial)
    {
        return super.createAuthorityKeyIdentifier(SubjectPublicKeyInfo.getInstance(pubKey.getEncoded()), new GeneralNames(new GeneralName(X500Name.getInstance(name.getEncoded()))), serial);
    }

    public AuthorityKeyIdentifier createAuthorityKeyIdentifier(PublicKey pubKey, GeneralNames generalNames, BigInteger serial)
    {
        return super.createAuthorityKeyIdentifier(SubjectPublicKeyInfo.getInstance(pubKey.getEncoded()), generalNames, serial);
    }

    /**
     * Return a RFC 3280 type 1 key identifier. As in:
     * <pre>
     * (1) The keyIdentifier is composed of the 160-bit SHA-1 hash of the
     * value of the BIT STRING subjectPublicKey (excluding the tag,
     * length, and number of unused bits).
     * </pre>
     * @param publicKey the key object containing the key identifier is to be based on.
     * @return the key identifier.
     */
    public SubjectKeyIdentifier createSubjectKeyIdentifier(
        PublicKey publicKey)
    {
        return super.createSubjectKeyIdentifier(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
    }

    /**
     * Return a RFC 3280 type 2 key identifier. As in:
     * <pre>
     * (2) The keyIdentifier is composed of a four bit type field with
     * the value 0100 followed by the least significant 60 bits of the
     * SHA-1 hash of the value of the BIT STRING subjectPublicKey.
     * </pre>
     * @param publicKey the key object of interest.
     * @return the key identifier.
     */
    public SubjectKeyIdentifier createTruncatedSubjectKeyIdentifier(PublicKey publicKey)
    {
       return super.createTruncatedSubjectKeyIdentifier(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
    }

    /**
     * Return the ASN.1 object contained in a byte[] returned by a getExtensionValue() call.
     *
     * @param encExtValue DER encoded OCTET STRING containing the DER encoded extension object.
     * @return an ASN.1 object
     * @throws java.io.IOException on a parsing error.
     */
    public static ASN1Primitive parseExtensionValue(byte[] encExtValue)
        throws IOException
    {
        return ASN1Primitive.fromByteArray(ASN1OctetString.getInstance(encExtValue).getOctets());
    }

    private static class SHA1DigestCalculator
        implements DigestCalculator
    {
        private ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        private MessageDigest digest;

        public SHA1DigestCalculator(MessageDigest digest)
        {
            this.digest = digest;
        }

        public AlgorithmIdentifier getAlgorithmIdentifier()
        {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1);
        }

        public OutputStream getOutputStream()
        {
            return bOut;
        }

        public byte[] getDigest()
        {
            byte[] bytes = digest.digest(bOut.toByteArray());

            bOut.reset();

            return bytes;
        }
    }
}
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
