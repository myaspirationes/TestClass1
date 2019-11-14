import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class decodeAndEncodeTest {

    @Test
    public void encodeTest()throws UnsupportedEncodingException {
        String zhongWen="商河";
        String encodedString= decodeAndEncode.encodeURL(zhongWen);
        System.out.println(encodedString);
    }

    @Test
    public void decodeTest()throws UnsupportedEncodingException {
        String zhongWen="%E5%95%86%E6%B2%B3";
        String decodedString= decodeAndEncode.decodeURL(zhongWen);
        System.out.println(decodedString);
    }
    @Test
    public void base64encodeTest()throws UnsupportedEncodingException {
        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad };
        String encodedString= decodeAndEncode.base64Encode(input);
        System.out.println(encodedString);
    }

    @Test
    public void base64decodeTest()throws UnsupportedEncodingException {
         String input = "5lit";
        String encodedString= decodeAndEncode.base64Decode(input);
        System.out.println(encodedString);
    }


}
