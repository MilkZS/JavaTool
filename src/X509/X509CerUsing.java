package X509;

import com.sun.org.apache.xml.internal.security.algorithms.Algorithm;
import sun.misc.BASE64Decoder;
import sun.security.util.Pem;
import sun.security.x509.X509Key;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Base64.Decoder;

import static java.util.Base64.*;

public class X509CerUsing {

    public static void main(String[] args) {
        new X509CerUsing();
    }

    public X509CerUsing() {
//        try {
//            InputStream fis = new FileInputStream(new File("C:/Users/AAA/Desktop/2.cer"));
//
//            CertificateFactory certificateFactory = null;
//            try {
//                certificateFactory = CertificateFactory.getInstance("X.509");
//                X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(fis);
//            } catch (CertificateException e) {
//                e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        String sss = "MIIDVDCCAjygAwIBAgIDAjRWMA0GCSqGSIb3DQEBBQUAMEIxCzAJBgNVBAYTAlVT" +
                "MRYwFAYDVQQKEw1HZW9UcnVzdCBJbmMuMRswGQYDVQQDExJHZW9UcnVzdCBHbG9i" +
                "YWwgQ0EwHhcNMDIwNTIxMDQwMDAwWhcNMjIwNTIxMDQwMDAwWjBCMQswCQYDVQQG" +
                "EwJVUzEWMBQGA1UEChMNR2VvVHJ1c3QgSW5jLjEbMBkGA1UEAxMSR2VvVHJ1c3Qg" +
                "R2xvYmFsIENBMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2swYYzD9" +
                "9BcjGlZ+W988bDjkcbd4kdS8odhM+KhDtgPpTSEHCIjaWC9mOSm9BXiLnTjoBbdq" +
                "fnGk5sRgprDvgOSJKA+eJdbtg/OtppHHmMlCGDUUna2YRpIuT8rxh0PBFpVXLVDv" +
                "iS2Aelet8u5fa9IAjbkU+BQVNdnARqN7csiRv8lVK83Qlz6cJmTM386DGXHKTubU" +
                "1XupGc1V3sjs0l44U+VcT4wt/lAjNvxm5suOpDkZALeVAjmRCw7+OC7RHQWa9k0+" +
                "bw8HHa8sHo9gOeL6NlMTOdReJivbPagUvTLrGAMoUgRx5aszPeE4uwc2hGKceeoW" +
                "MPRfwCvocWvk+QIDAQABo1MwUTAPBgNVHRMBAf8EBTADAQH/MB0GA1UdDgQWBBTA" +
                "ephojYn7qwVkDBF9qn1luMrMTjAfBgNVHSMEGDAWgBTAephojYn7qwVkDBF9qn1l" +
                "uMrMTjANBgkqhkiG9w0BAQUFAAOCAQEANeMpauUvXVSOKVCUn5kaFOSPeCpilKIn" +
                "Z57QzxpeR+nBsqTP3UEaBU6bS+5Kb1VSsyShNwrrZHYqLizz/Tt1kL/6cdjHPTfS" +
                "tQWVYrmm3ok9Nns4d0iXrKYgjy6myQzCsplFAMfOEVEiIuCl6rYVSAlk6l5PdPcF" +
                "PseKUgzbFbS9bZvlxrFUaKnjaZC2mqUPuLk/IH2uSrW4nOQdtqvmlKXBx4Ot2/Un" +
                "hw4EbNX/3aBd7YdStysVAq45pmp06drE57xNNB6pXE0zX5IJL4hmXXeXxx12E6nV" +
                "5fEWCRE11azbJHFwLJhWC9kXtNHjUStedejV0NxPNO3CBWaAocvmMw==";

        System.out.println(" str len = " + sss.length());
        byte[] v = Base64.getDecoder().decode(sss);
        X509Certificate x509Certificate = analyseCer(v);
        System.out.println("" + x509Certificate.getIssuerDN().getName());
        System.out.println("" + x509Certificate.getSigAlgName());
    }

    /**
     * 返回具有证书内容的对象
     *
     * @param cerValues 证书内容
     * @return 具有证书内容的对象
     */
    public X509Certificate analyseCer(byte[] cerValues) {
        try {
            ByteArrayInputStream is = new ByteArrayInputStream(cerValues);
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            return (X509Certificate) certificateFactory.generateCertificate(is);
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
