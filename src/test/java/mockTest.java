import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

//@RunWith(PowerMockRunner.class)
public class mockTest {


    @Test
    public void verify_behaviour() {
        //模拟创建一个List对象
        List mock = mock(List.class);
        //使用mock的对象
        mock.add(1);
        mock.clear();
        //验证add(1)和clear()行为是否发生
        verify(mock).add(1);
        verify(mock).clear();
    }

    @Test
    public void when_thenReturn() {
        //mock一个Iterator类
        Iterator iterator = mock(Iterator.class);
        //预设当iterator调用next()时第一次返回hello，第n次都返回world
        Mockito.when(iterator.next()).thenReturn("hello").thenReturn("world");
        //使用mock的对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
        //验证结果
        assertEquals("hello world world", result);
    }

    @Test(expected = IOException.class)
    public void when_thenThrow() throws IOException {
        OutputStream outputStream = mock(OutputStream.class);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        //预设当流关闭时抛出异常
        doThrow(new IOException()).when(outputStream).close();
        outputStream.close();
    }

    @Test
    public void returnsSmartNullsTest() {
        List mock = mock(List.class, RETURNS_SMART_NULLS);
        mock.add("df");
        //verify(mock).add("6df");
        System.out.println("==========>" + mock.size());

        System.out.println(mock.get(0));

        //使用RETURNS_SMART_NULLS参数创建的mock对象，不会抛出NullPointerException异常。另外控制台窗口会提示信息“SmartNull returned by unstubbed get() method on mock”
        System.out.println(mock.toArray().length);
    }


    @Test
    public void with_arguments() {
        Comparable comparable = mock(Comparable.class);
        //预设根据不同的参数返回不同的结果
        when(comparable.compareTo("Test")).thenReturn(1);
        when(comparable.compareTo("Omg")).thenReturn(2);
        assertEquals(1, comparable.compareTo("Test"));
        assertEquals(2, comparable.compareTo("Omg"));
        //对于没有预设的情况会返回默认值
        assertEquals(0, comparable.compareTo("Not stub"));
    }

    //@Ignore("disabled until bug #100 is fixed")
    @Test
    public void with_unspecified_arguments() {
        List list = mock(List.class);
        list.add("s");
        list.add("233");//交互(interaction)操作不会执行在mock对象上

        System.out.println(list);
        list.clear();
        verify(list).clear();
        System.out.println(list);
        //匹配任意参数
        when(list.get(anyInt())).thenReturn(1);
        when(list.contains(1)).thenReturn(true);
        assertEquals(1, list.get(1));
        assertEquals(1, list.get(999));
        assertTrue(list.contains(1));
        //assertTrue(!list.contains(1));
    }

    @Test
    public void all_arguments_provided_by_matchers() {
        Comparator comparator = mock(Comparator.class);
        comparator.compare("nihao", "hello");
        //如果你使用了参数匹配，那么所有的参数都必须通过matchers来匹配
        verify(comparator).compare(anyString(), eq("hello"));
        //下面的为无效的参数匹配使用
        verify(comparator).compare("nihao", "hello");
    }


    @Test
    public void test() {
        // 创建Mock对象，参数可以是类或者接口
        List<String> list = mock(List.class);

        //设置方法的预期返回值
        when(list.get(0)).thenReturn("zuozewei");
        when(list.get(1)).thenThrow(new RuntimeException("test exception"));

        String result = list.get(0);

        //验证方法调用
        verify(list).get(0);

        //断言，list的第一个元素是否是"zuozwei"
        assertEquals(result, "zuozewei");

    }


    @Test
    public void testCallArgumentInstance() {

        File file = PowerMockito.mock(File.class);

        ClassUnderTest underTest = new ClassUnderTest();

        PowerMockito.when(file.exists()).thenReturn(true);

        Assert.assertTrue(underTest.callArgumentInstance(file));
    }

    @Test
    //@PrepareForTest(ClassUnderTest.class)
    public void testCallInternalInstance() throws Exception {

        File file = PowerMockito.mock(File.class);

        ClassUnderTest underTest = new ClassUnderTest();

        PowerMockito.whenNew(File.class).withArguments("bbb").thenReturn(file);

        PowerMockito.when(file.exists()).thenReturn(true);

        Assert.assertTrue(!underTest.callInternalInstance("bbb"));
    }


    @Test(expected = RuntimeException.class)
    public void when_thenReturn2() {
        // 你可以mock具体的类型,不仅只是接口
        LinkedList mockedList = mock(LinkedList.class);
        //stubbing
        // 测试桩
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        //following prints "first"
        // 输出“first”
        System.out.println(mockedList.get(0));
        //following prints "null" because get(999) was not stubbed
        // 因为get(999) 没有打桩，因此输出null
        System.out.println(mockedList.get(999));
        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns then something else breaks (often before even verify() gets executed).
        //If your code doesn't care what get(0) returns then it should not be stubbed. Not convinced? See here.
        // 验证get(0)被调用的次数
        verify(mockedList).get(0);
        verify(mockedList).get(999);
        System.out.println("执行了。。。");
        //following throws runtime exception
        // 抛出异常
        System.out.println(mockedList.get(1));
    }


    @Test
    public void shareNewMethon() {
        int[] listPage = {1, 2, 3, 4, 5};
        for (int i : listPage) {
            System.out.print(i);
            System.out.println(",");
            if (i == 3) {
                System.out.println("跳出");
                break;
            }
        }


    }

    @Test
    public void teist() {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("jsonrpc", "2.0");

        jsonObject.put("method", "query");

        //jsonObject.put("params", "{'chaincodeID':{'name':'fscs'},'ctorMsg': {'args':['query','Bob']}}");

        jsonObject.put("id", 5);

        String transJson = jsonObject.toString();

        System.out.println(transJson);

    }





}