import org.junit.Test;

import java.util.Scanner;

public class ScannerTest {
    /**
     *在读取前我们一般需要 使用 hasNext 与 hasNextLine 判断是否还有输入的数据;
     * 遇到空格，next() 方法会自动将其后输入去掉
     */
    @Test
    public  void scanNext() {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }

    /**
     *在读取前我们一般需要 使用 hasNext 与 hasNextLine 判断是否还有输入的数据;
     * 遇到enter后才结束输入；
     * 在输入之前最好先使用 hasNextXxx() 方法进行验证，再使用 nextXxx() 来读取。
     */
    @Test
    public  void scanNextLine(){
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        int i = 0;
        float f = 0.0f;
        System.out.print("输入整数：");
        if (scan.hasNextInt()) {
            // 判断输入的是否是整数
            i = scan.nextInt();
            // 接收整数
            System.out.println("整数数据：" + i);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
        }
        System.out.print("输入小数：");
        if (scan.hasNextFloat()) {
            // 判断输入的是否是小数
            f = scan.nextFloat();
            // 接收小数
            System.out.println("小数数据：" + f);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是小数！");
        }
        scan.close();

    }


}
