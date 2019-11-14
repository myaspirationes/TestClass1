import org.junit.Test;

import java.io.File;
import java.io.*;
import java.util.Date;
//D:\TestClass\src\main\resources\M1.jpg

public class ReadAndWrite {
    @Test
    public void readTest(){
        String path = this.getClass().getClassLoader().getResource("./M1.jpg").getPath();
        System.out.println(path);
        File directory = new File("./M1.jpg");//参数为空
        try{
            String courseFile = directory.getCanonicalPath();
            System.out.println(courseFile);
        }catch (Exception E){
            System.out.println(E);
        }
        //标准的路径 ;
        String author =directory.getAbsolutePath();
        System.out.println(author);
        String property =System.getProperty("M1.jpg");
        System.out.println(property);
    }


}
