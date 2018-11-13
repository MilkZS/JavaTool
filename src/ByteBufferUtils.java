import java.nio.ByteBuffer;

public class ByteBufferUtils {

    /**
     * ByteBuffer transform to Integer
     *
     * @param byteBuffer input ByteBuffer data
     * @param off index that start to read data
     * @return Integer data
     */
    public static int byteBufferToInt(ByteBuffer byteBuffer,int off){
        byte[] bytes = new byte[byteBuffer.limit()];
        for(int i=0;i<byteBuffer.limit();i++){
            bytes[i] = byteBuffer.get(i);
        }

        int b0 = bytes[off] & 0xFF;
        int b1 = bytes[off + 1] & 0xFF;
        int b2 = bytes[off + 2] & 0xFF;
        int b3 = bytes[off + 3] & 0xFF;
        return (b0 << 24) | (b1 << 16) | (b2 << 8) | b3;
    }

    /**
     * Integer transform to ByteBuffer
     *
     * @param i input Integer data
     * @return ByteBuffer data
     */
    public static ByteBuffer intToByteBuffer(int i){
        byte[] targets = new byte[4];
        targets[3] = (byte) (i & 0xFF);
        targets[2] = (byte) (i >> 8 & 0xFF);
        targets[1] = (byte) (i >> 16 & 0xFF);
        targets[0] = (byte) (i >> 24 & 0xFF);
        return ByteBuffer.wrap(targets);
    }

}
