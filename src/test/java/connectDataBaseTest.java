import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connectDataBaseTest {

 @Test
    public void testUpdateSql() {
        //String sql="delete FROM feikongbao_provisioning.`user` WHERE account = 'YODOO_TEST_24'";
        String sql = "update  user set username='ssssss' WHERE id=1;";
        //String sql2="select * from user";
        try {
            ConnectDataBase.updateMethond(sql);
        } catch (Exception e) {
            System.out.println(e);

        }
    }


    @Test
    public void testInserSql() {
        //String sql="delete FROM feikongbao_provisioning.`user` WHERE account = 'YODOO_TEST_24'";
        String sql = "insert into  mysql_test.user(account,name,password,sex,status,created_by,last_modified_by) value('test_wang_1','xiaom','123456','0','1','13','13');";
        //String sql2="select * from user";
        try {
            ConnectDataBase.insertMethond(sql);
        } catch (Exception e) {
            System.out.println(e);

        }
    }





    @Test
    public void selectMethond() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        //创建连接
        Connection conn = DriverManager.getConnection
                ("jdbc:mysql://192.168.1.20:3306/mysql_test?useSSL=FALSE&serverTimezone=UTC", "root", "123456");
        //得到执行sql语句的Statement对象
        Statement stmt = conn.createStatement();
        //执行sql语句，并返回结果
        ResultSet rs = stmt.executeQuery("select * from user");
        // ResultSet columns=stmt.executeQuery("select count(*) from information_schema.COLUMNS where table_name= 'user'");
        Statement stmt2 = conn.createStatement();
        //执行sql语句，获取表列数
        ResultSet columns = stmt2.executeQuery("select * from   user");
        int columnCount = columns.getMetaData().getColumnCount();
        System.out.println(columnCount);
        //处理结果  rs.next()：光标放置于第一行
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        //关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }


    @Test
    public void testdeleteSql() {
        //String sql="delete FROM feikongbao_provisioning.`user` WHERE account = 'YODOO_TEST_24'";
        String sql = "DELETE FROM mysql_test.user WHERE account='hellp';";
        //String sql2="select * from user";
        try {
            ConnectDataBase.deleteMethond(sql);
        } catch (Exception e) {
            System.out.println(e);

        }
    }


    @Test
    public void testSelectMethond() {
        //String sql="delete FROM feikongbao_provisioning.`user` WHERE account = 'YODOO_TEST_24'";
        String sql = "SELECT * FROM mysql_test.`user` WHERE account LIKE 'YODOO%'";
        String sql2 = "select * from user";
        try {
            ConnectDataBase.selectMethond(sql, sql2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
