package Utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ByteArrayUtils {
    /**
     * int transform to byte array
     *
     * @param i input Integer
     * @return byte array
     */
    public static byte[] intToByte4(int i) {
        byte[] targets = new byte[4];
        targets[3] = (byte) (i & 0xFF);
        targets[2] = (byte) (i >> 8 & 0xFF);
        targets[1] = (byte) (i >> 16 & 0xFF);
        targets[0] = (byte) (i >> 24 & 0xFF);
        return targets;
    }

    /**
     * byte array transform to Integer
     *
     * @param bytes input byte array
     * @param off index that started to read byte
     * @return Integer data
     */
    public static int byte4ToInt(byte[] bytes, int off) {
        int b0 = bytes[off] & 0xFF;
        int b1 = bytes[off + 1] & 0xFF;
        int b2 = bytes[off + 2] & 0xFF;
        int b3 = bytes[off + 3] & 0xFF;
        return (b0 << 24) | (b1 << 16) | (b2 << 8) | b3;
    }

    /**
     * byte array transform to InputStream
     *
     * @param bytes input byte array
     * @return InputStream
     */
    public static InputStream byteToInputStream(byte[] bytes){
        return new ByteArrayInputStream(bytes);
    }

}
