import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;


/**
 * 测试实例：假如我有一个IStudent接口类和StudentApplication类，StudentApplication类中
 * 用到了IStudent中的没实现的方法，而我想测试StudentApplication，
 * 这时用EasyMock构造一个IStudent的Mock对象，
 * 并给要用到的的未实现的方法设定已知返回值。
 */

public class testStudentApplication {
    IStudent student;
    StudentApplication application;
    @Test
    public void testdoMethod(){
        //•使用 EasyMock 生成 Mock 对象；
        student= EasyMock.createMock(IStudent.class);
        //设定 Mock 对象的预期行为和输出
        EasyMock.expect(student.doMethod1()).andReturn("a").times(1);
        EasyMock.expect(student.doMethod2()).andReturn("b").times(1);
        EasyMock.expect(student.doMethod3()).andReturn("c").times(1);
        //将 Mock 对象切换到 Replay 状态
        EasyMock.replay(student);
        //调用 Mock 对象方法进行单元测试
        StudentApplication application=new StudentApplication(student);
        System.out.println("Print: "+ application.getStudent().toString());
        String getStr=application.doMethod();
        //对 Mock 对象的行为进行验证
        String cstr="abc";//正确的字符串
        Assert.assertEquals(getStr, cstr);
        EasyMock.verify(student);

    }

}
