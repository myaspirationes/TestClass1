import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class decodeAndEncode {
//%E4%B8%AD%E6%96%87%21

    public static String encodeURL(String arg )throws UnsupportedEncodingException {
        String encoded = URLEncoder.encode(arg, "utf-8");
        //System.out.println(encoded);
        return  encoded;
    }

    public static String decodeURL(String args) throws UnsupportedEncodingException{
        String decoded = URLDecoder.decode(args, "utf-8");
        //System.out.println(decoded);
        return  decoded;
    }
    public static String base64Encode (byte[] args) {
        //byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad };
        String b64encoded = Base64.getEncoder().encodeToString(args);
        System.out.println(b64encoded);
        return  b64encoded;
    }

    public static String base64Decode (String args) {
        byte[] output = Base64.getDecoder().decode("5Lit");
        String b64decoded = Arrays.toString(output);
        return  b64decoded;
    }

    public static void main(String[] args) throws Exception {
        // 创建一个MessageDigest实例:
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 反复调用update输入数据:
        String str="hello123";
        //md.update("Hello".getBytes("UTF-8"));
        //md.update("World".getBytes("UTF-8"));
        md.update(str.getBytes("UTF-8"));
        byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        //System.out.println( result.toString());

        System.out.println(new BigInteger(1, result).toString(16));
    }


}


