import org.junit.Test;
import sun.security.util.Resources;

import java.io.*;
import java.net.URISyntaxException;

public class ReadFileInResource {

        //获取resource中文件,存放到桌面
        @Test
        public void readFileInResource()throws  IOException{
            //获取resource中文件路径
            String filePath = this.getClass().getClassLoader().getResource("M1.jpg").getPath();
            System.out.println(filePath);
            //创建输入流和输出流，并初始化
            OutputStream outputStream = null;
            InputStream  inputStream =null;
            File file = new File(filePath);
            inputStream = new FileInputStream(file);
            int available = inputStream.available();//这个方法可以在读写操作前先得知数据流里有多少个字节可以读取
            byte[] bytes = new byte[available];
            inputStream.read(bytes, 0, available);//在数组的第一个位置写入availble个字节到数组bytes中
            outputStream = new FileOutputStream(new File("C:\\Users\\EDZ\\Desktop\\boyyom.jpg"));
            outputStream.write(bytes);
            outputStream.flush();
        }

}
