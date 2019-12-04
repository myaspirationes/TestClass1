import org.junit.Test;
import sun.security.util.Resources;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class ReadFileInResource {

        //获取resource中文件--图片,存放到桌面
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
            outputStream = new FileOutputStream(new File("C:\\Users\\EDZ\\Desktop\\hell.docx"));
            outputStream.write(bytes);
            outputStream.flush();
        }

    //获取resource中文件--字符,存放到桌面的某个文件中
    @Test
    public void readTextFileInResource() throws IOException {
        String filePath = this.getClass().getClassLoader().getResource("redStar.txt").getPath();
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        int availble = inputStream.available();
        byte[] bytes = new byte[availble];
        inputStream.read(bytes);
        inputStream.close();

        ByteArrayInputStream bInput = new ByteArrayInputStream(bytes);
        int c;
        System.out.println("Converting characters to Upper case ");
        for (int y = 0; y < 1; y++) {
            while ((c = bInput.read()) != -1) {
                System.out.println((char)c);
            }
            bInput.reset();

            ByteArrayOutputStream bArray = new ByteArrayOutputStream(availble);
            byte b[] = bArray.toByteArray();
            System.out.println("Print the content");
            for (int x = 0; x < b.length; x++) {
                // 打印字符
                System.out.println((char) b[x] + " @@@@  ");
            }

            String str = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(str);
            OutputStream outputStream = null;
            outputStream = new FileOutputStream(new File("C:\\Users\\EDZ\\Desktop\\hell.txt"));
            outputStream.write(bytes);
            outputStream.flush();


        }

    }
    }


