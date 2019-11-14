import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Scanner;
import java.util.SortedMap;

public class FileIO {

    @Test
    public void fileName() {
        File file = new File(".");
        // 使用Lambda表达式（目标类型为FilenameFilter）实现文件过滤器。
        // 如果文件名以.java结尾，或者文件对应一个路径，返回true
        String[] nameList = file.list((dir, name) -> name.endsWith(".java") || new File(name).isDirectory());
        for (String name : nameList) {
            System.out.println(name);
        }
    }

    @Test
    public void fileNameAndPath() throws IOException {
        // 以当前路径来创建一个File对象
        File file = new File(".");
        // 直接获取文件名，输出一点
        System.out.println(file.getName());
        // 获取相对路径的父路径可能出错，下面代码输出null
        System.out.println(file.getParent());
        // 获取绝对路径
        System.out.println(file.getAbsoluteFile());
        // 获取上一级路径
        System.out.println(file.getAbsoluteFile().getParent());
        // 在当前路径下创建一个临时文件
        File tmpFile = File.createTempFile("aaa", ".txt", file);
        // 指定当JVM退出时删除该文件
        tmpFile.deleteOnExit();
        // 以系统当前时间作为新文件名来创建新文件
        File newFile = new File(System.currentTimeMillis() + "");
        System.out.println("newFile对象是否存在：" + newFile.exists());
        // 以指定newFile对象来创建一个文件
        //newFile.createNewFile();
        // 以newFile对象来创建一个目录，因为newFile已经存在，
        // 所以下面方法返回false，即无法创建该目录
        newFile.mkdir();
        // 使用list()方法来列出当前路径下的所有文件和路径
        String[] fileList = file.list();
        System.out.println("====当前路径下所有文件和路径如下====");
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
        // listRoots()静态方法列出所有的磁盘根路径。
        File[] roots = File.listRoots();
        System.out.println("====系统所有根路径如下====");
        for (File root : roots) {
            System.out.println(root);
        }
    }

    /**
     *
     */
    @Test
    public void FileInputStreamTest() throws IOException {
        // 创建字节输入流
        FileInputStream fis = new FileInputStream("D:\\TestClass\\src\\main\\java\\Calculator.java");
        // 创建一个长度为1024的“竹筒”
        byte[] bbuf = new byte[1024];
        // 用于保存实际读取的字节数
        int hasRead = 0;
        // 使用循环来重复“取水”过程
        while ((hasRead = fis.read(bbuf)) > 0) {
            // 取出“竹筒”中水滴（字节），将字节数组转换成字符串输入！
            System.out.print(new String(bbuf, 0, hasRead));
        }
        // 关闭文件输入流，放在finally块里更安全
        fis.close();
    }

    @Test
    public void FileOutputStreamTest() {
        try (
                // 创建字节输入流
                FileInputStream fis = new FileInputStream("D:\\TestClass\\src\\main\\resources\\M1.jpg");
                // 创建字节输出流
                FileOutputStream fos = new FileOutputStream("newFile.jpg")) {
            byte[] bbuf = new byte[32];
            int hasRead = 0;
            // 循环从输入流中取出数据
            while ((hasRead = fis.read(bbuf)) > 0) {
                // 每读取一次，即写入文件输出流，读了多少，就写多少。
                fos.write(bbuf, 0, hasRead);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Test
    public void FileReaderTest() {
        try (
                // 创建字符输入流
                FileReader fr = new FileReader("D:\\TestClass\\src\\main\\java\\Calculator.java")) {
            // 创建一个长度为32的“竹筒”
            char[] cbuf = new char[32];
            // 用于保存实际读取的字符数
            int hasRead = 0;
            // 使用循环来重复“取水”过程
            while ((hasRead = fr.read(cbuf)) > 0) {
                // 取出“竹筒”中水滴（字符），将字符数组转换成字符串输入！
                System.out.print(new String(cbuf, 0, hasRead));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 输出内容到文件
     */
    @Test
    public void FileWriterTest() {
        try (
                FileWriter fw = new FileWriter("poem.txt")) {
            fw.write("锦瑟 - 李商隐\r\n");
            fw.write("锦瑟无端五十弦，一弦一柱思华年。\r\n");
            fw.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。\r\n");
            fw.write("沧海月明珠有泪，蓝田日暖玉生烟。\r\n");
            fw.write("此情可待成追忆，只是当时已惘然。\r\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //输入写进文件里
    @Test
    public void KeyinTest() {
        try (
                // 将System.in对象转换成Reader对象
                InputStreamReader reader = new InputStreamReader(System.in);
                // 将普通Reader包装成BufferedReader
                BufferedReader br = new BufferedReader(reader)) {
            String line = null;
            System.out.println("请输入内容(输入exit，程序退出)");
            // 采用循环方式来一行一行的读取
            while ((line = br.readLine()) != null) {
                // 如果读取的字符串为"exit"，程序退出
                if (line.equals("exit") || line.equals("EXIT")) {
                    System.exit(1);
                }
                // 打印读取的内容
                System.out.println("输入内容为:" + line);
                //内容写进文件
                try (
                        FileWriter fw = new FileWriter("poem2.txt")) {
                    fw.write(line + "\r");

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Test
    public void PrintStreamTest() {
        try (
                FileOutputStream fos = new FileOutputStream("test.txt");
                PrintStream ps = new PrintStream(fos)) {
            // 使用PrintStream执行输出
            ps.println("普通字符串");
            // 直接使用PrintStream输出对象
            ps.println(new FileIO());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Test
    public void PushbackTest() {
        try (
                // 创建一个PushbackReader对象，指定推回缓冲区的长度为64
                PushbackReader pr = new PushbackReader(new FileReader("D:\\TestClass\\src\\test\\java\\FileIO.java"), 64)) {
            char[] buf = new char[32];
            // 用以保存上次读取的字符串内容
            String lastContent = "";
            int hasRead = 0;
            // 循环读取文件内容
            while ((hasRead = pr.read(buf)) > 0) {
                // 将读取的内容转换成字符串
                String content = new String(buf, 0, hasRead);
                int targetIndex = 0;
                // 将上次读取的字符串和本次读取的字符串拼起来，
                // 查看是否包含目标字符串, 如果包含目标字符串
                if ((targetIndex = (lastContent + content).indexOf("new PushbackReader")) > 0) {
                    // 将本次内容和上次内容一起推回缓冲区
                    pr.unread((lastContent + content).toCharArray());
                    // 重新定义一个长度为targetIndex的char数组
                    if (targetIndex > 32) {
                        buf = new char[targetIndex];
                    }
                    // 再次读取指定长度的内容（就是目标字符串之前的内容）
                    pr.read(buf, 0, targetIndex);
                    // 打印读取的内容
                    System.out.print(new String(buf, 0, targetIndex));
                    System.exit(0);
                } else {
                    // 打印上次读取的内容
                    System.out.print(lastContent);
                    // 将本次内容设为上次读取的内容
                    lastContent = content;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Test
    public void StringNodeTest() {
        String src = "从明天起，做一个幸福的人\n"
                + "喂马，劈柴，周游世界\n"
                + "从明天起，关心粮食和蔬菜\n"
                + "我有一所房子，面朝大海，春暖花开\n"
                + "从明天起，和每一个亲人通信\n"
                + "告诉他们我的幸福\n";
        char[] buffer = new char[32];
        int hasRead = 0;
        try (
                StringReader sr = new StringReader(src)) {
            // 采用循环读取的访问读取字符串
            while ((hasRead = sr.read(buffer)) > 0) {
                System.out.print(new String(buffer, 0, hasRead));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        try (
                // 创建StringWriter时，实际上以一个StringBuffer作为输出节点
                // 下面指定的20就是StringBuffer的初始长度
                StringWriter sw = new StringWriter(20)) {
            // 调用StringWriter的方法执行输出
            sw.write("有一个美丽的新世界，\n");
            sw.write("她在远方等我,\n");
            sw.write("那里有天真的孩子，\n");
            sw.write("还有姑娘的酒窝\n");
            System.out.println("----下面是sw的字符串节点里的内容----");
            // 使用toString()方法返回StringWriter的字符串节点的内容
            System.out.println(sw.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void RedirectIn() {
        try (
                FileInputStream fis = new FileInputStream("D:\\TestClass\\src\\test\\java\\FileIO.java")) {
            // 将标准输入重定向到fis输入流
            System.setIn(fis);
            // 使用System.in创建Scanner对象，用于获取标准输入
            Scanner sc = new Scanner(System.in);
            // 增加下面一行将只把回车作为分隔符
            sc.useDelimiter("\n");
            // 判断是否还有下一个输入项
            while (sc.hasNext()) {
                // 输出输入项
                System.out.println("键盘输入的内容是：" + sc.next());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void RedirectOut() {
        try (
                // 一次性创建PrintStream输出流
                PrintStream ps = new PrintStream(new FileOutputStream("poem.txt"))) {
            // 将标准输出重定向到ps输出流
            System.setOut(ps);
            // 向标准输出输出一个字符串
            System.out.println("普通字符串");
            // 向标准输出输出一个对象
            System.out.println(new FileIO());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void ReadFromProcess() throws IOException {
        // 运行javac命令，返回运行该命令的子进程
        Process p = Runtime.getRuntime().exec("javac");
        try (
                // 以p进程的错误流创建BufferedReader对象
                // 这个错误流对本程序是输入流，对p进程则是输出流
                BufferedReader br = new BufferedReader(new
                        InputStreamReader(p.getInputStream()))) {
            String buff = null;
            // 采取循环方式来读取p进程的错误输出
            while ((buff = br.readLine()) != null) {
                System.out.println(buff);
            }
        }
    }

    @Test
    public void AppendContent() {
        try (
                //以读、写方式打开一个RandomAccessFile对象
                RandomAccessFile raf = new RandomAccessFile("out.txt", "rw")) {
            //将记录指针移动到out.txt文件的最后
            raf.seek(raf.length());
            raf.write("追加的内容！\r\n".getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void insert(String fileName, long pos,
                               String insertContent) throws IOException {
        File tmp = File.createTempFile("tmp", null);
        tmp.deleteOnExit();
        try (
                RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
                // 使用临时文件来保存插入点后的数据
                FileOutputStream tmpOut = new FileOutputStream(tmp);
                FileInputStream tmpIn = new FileInputStream(tmp)) {
            raf.seek(pos);
            // ------下面代码将插入点后的内容读入临时文件中保存------
            byte[] bbuf = new byte[64];
            // 用于保存实际读取的字节数
            int hasRead = 0;
            // 使用循环方式读取插入点后的数据
            while ((hasRead = raf.read(bbuf)) > 0) {
                // 将读取的数据写入临时文件
                tmpOut.write(bbuf, 0, hasRead);
            }
            // ----------下面代码插入内容----------
            // 把文件记录指针重新定位到pos位置
            raf.seek(pos);
            // 追加需要插入的内容
            raf.write(insertContent.getBytes());
            // 追加临时文件中的内容
            while ((hasRead = tmpIn.read(bbuf)) > 0) {
                raf.write(bbuf, 0, hasRead);
            }
        }
    }

    @Test
    public void insertTest() throws IOException {
        insert("out.txt", 45, "插入的内容\r\n");
    }

    @Test
    public void RandomAccessFileTest() {
        try (
                RandomAccessFile raf = new RandomAccessFile("out.txt", "r")) {
            // 获取RandomAccessFile对象文件指针的位置，初始位置是0
            System.out.println("RandomAccessFile的文件指针的初始位置："
                    + raf.getFilePointer());
            // 移动raf的文件记录指针的位置
            raf.seek(300);
            byte[] bbuf = new byte[1024];
            // 用于保存实际读取的字节数
            int hasRead = 0;
            // 使用循环来重复“取水”过程
            while ((hasRead = raf.read(bbuf)) > 0) {
                // 取出“竹筒”中水滴（字节），将字节数组转换成字符串输入！
                System.out.print(new String(bbuf, 0, hasRead));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void BufferTest() {
        // 创建Buffer
        CharBuffer buff = CharBuffer.allocate(8);    // ①
        System.out.println("capacity: " + buff.capacity());
        System.out.println("limit: " + buff.limit());
        System.out.println("position: " + buff.position());
        // 放入元素
        buff.put('a');
        buff.put('b');
        buff.put('c');      // ②
        System.out.println("加入三个元素后，position = "
                + buff.position());
        // 调用flip()方法
        buff.flip();      // ③
        System.out.println("执行flip()后，limit = " + buff.limit());
        System.out.println("position = " + buff.position());
        // 取出第一个元素
        System.out.println("第一个元素(position=0)：" + buff.get());  // ④
        System.out.println("取出一个元素后，position = "
                + buff.position());
        // 调用clear方法
        buff.clear();     // ⑤
        System.out.println("执行clear()后，limit = " + buff.limit());
        System.out.println("执行clear()后，position = "
                + buff.position());
        System.out.println("执行clear()后，缓冲区内容并没有被清除："
                + "第三个元素为：" + buff.get(2));    // ⑥
        System.out.println("执行绝对读取后，position = "
                + buff.position());
    }

    @Test
    public void charsetTest() {
        // 获取Java支持的全部字符集
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (String alias : map.keySet()) {
            // 输出字符集的别名和对应的Charset对象
            System.out.println(alias + "----->"
                    + map.get(alias));
        }
    }

    @Test
    public void CharsetTransform() throws Exception {
        // 创建简体中文对应的Charset
        Charset cn = Charset.forName("GBK");
        // 获取cn对象对应的编码器和解码器
        CharsetEncoder cnEncoder = cn.newEncoder();
        CharsetDecoder cnDecoder = cn.newDecoder();
        // 创建一个CharBuffer对象
        CharBuffer cbuff = CharBuffer.allocate(8);
        cbuff.put('孙');
        cbuff.put('悟');
        cbuff.put('空');
        cbuff.flip();
        // 将CharBuffer中的字符序列转换成字节序列
        ByteBuffer bbuff = cnEncoder.encode(cbuff);
        // 循环访问ByteBuffer中的每个字节
        for (int i = 0; i < bbuff.capacity(); i++) {
            System.out.print(bbuff.get(i) + " ");
        }
        // 将ByteBuffer的数据解码成字符序列
        System.out.println("\n" + cnDecoder.decode(bbuff));
    }

    @Test
    public   void FileChannelTest( )
    {
        File f = new File("poem.txt");
        try (
                // 创建FileInputStream，以该文件输入流创建FileChannel
                FileChannel inChannel = new FileInputStream(f).getChannel();
                // 以文件输出流创建FileBuffer，用以控制输出
                FileChannel outChannel = new FileOutputStream("a.txt").getChannel())
        {
            // 将FileChannel里的全部数据映射成ByteBuffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());   // ①
            // 使用GBK的字符集来创建解码器
            Charset charset = Charset.forName("GBK");
            // 直接将buffer里的数据全部输出
            outChannel.write(buffer);     // ②
            // 再次调用buffer的clear()方法，复原limit、position的位置
            buffer.clear();
            // 创建解码器(CharsetDecoder)对象
            CharsetDecoder decoder = charset.newDecoder();
            // 使用解码器将ByteBuffer转换成CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            // CharBuffer的toString方法可以获取对应的字符串
            System.out.println(charBuffer);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    @Test
    public   void FileChannel3Test3( )
    {
        File f = new File("poem.txt");
        try (
                // 创建FileInputStream，以该文件输入流创建FileChannel
                FileChannel inChannel = new FileInputStream(f).getChannel();
                // 以文件输出流创建FileBuffer，用以控制输出
                FileChannel outChannel = new FileOutputStream("a.txt").getChannel())
        {
            // 将FileChannel里的全部数据映射成ByteBuffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());   // ①
            // 使用GBK的字符集来创建解码器
            Charset charset = Charset.forName("GBK");
            // 直接将buffer里的数据全部输出
            outChannel.write(buffer);     // ②
            // 再次调用buffer的clear()方法，复原limit、position的位置
            buffer.clear();
            // 创建解码器(CharsetDecoder)对象
            CharsetDecoder decoder = charset.newDecoder();
            // 使用解码器将ByteBuffer转换成CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            // CharBuffer的toString方法可以获取对应的字符串
            System.out.println(charBuffer);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }





}