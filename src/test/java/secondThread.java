public class secondThread implements Runnable
{
    private int i;
    // run方法同样是线程执行体
    public void run()
    {
        for ( ; i < 100; i++)
        {
            // 当线程类实现Runnable接口时，
            // 如果想获取当前线程，只能用Thread.currentThread()方法。
            System.out.println(Thread.currentThread().getName()
                    + " " + i);
        }
    }

    public static void main(String[] args)
    {
        for (int i = 0; i <25; i++)
        {
            System.out.println(Thread.currentThread().getName()
                    + " " + i);
            if (i == 20)
            {
                // 通过new Thread(target, name)方法创建新线程
                new Thread(new secondThread(), "新线程1").start();
                new Thread(new secondThread(), "新线程2").start();
            }
        }
    }
}
