
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDataBase {
    //JDBC驱动名以及数据库URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.1.20:3306/mysql_test";

    //数据库的用户名与密码
    static final String USER = "root";
    static final String PASSWORD = "123456";


    /**
     * select 查询语句
     * */

    public  static void selectMethond(String sql, String selectColumns) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        //创建连接
        Connection conn = DriverManager.getConnection
                ("jdbc:mysql://192.168.1.20:3306/mysql_test?useSSL=FALSE&serverTimezone=UTC", "root", "123456");
        //得到执行sql语句的Statement对象
        Statement stmt = conn.createStatement();
        //执行sql语句，并返回结果
        ResultSet rs = stmt.executeQuery(sql);
        // ResultSet columns=stmt.executeQuery("select count(*) from information_schema.COLUMNS where table_name= 'user'");

        Statement stmt2 = conn.createStatement();
        //执行sql语句，获取表列数
        ResultSet columns = stmt2.executeQuery(selectColumns);
        int columnCount = columns.getMetaData().getColumnCount();
        //System.out.println(columnCount);

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


    /**
     * 删除语句
     * "DELETE FROM feikongbao_provisioning.user WHERE account='hellp';"
     */

    public static void deleteMethond(String deleteSql) throws Exception {

        //Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://192.168.1.20:3306/mysql_test?useSSL=FALSE&serverTimezone=UTC", "root", "123456");
            //得到执行sql语句的Statement对象
            Statement stmt = conn.createStatement();
            //执行sql语句，并返受到影响的行数
            int rs = stmt.executeUpdate(deleteSql);
            if (rs > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    /**
     * 插入语句
     * "insert into user (username,password) values(hello,123456);"
     */

    public static void insertMethond(String insertSql) throws Exception {
        try {
            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://192.168.1.20:3306/mysql_test?useSSL=FALSE&serverTimezone=UTC", "123456", "123456");
            //得到执行sql语句的Statement对象
            Statement stmt = conn.createStatement();
            //执行sql语句，并返受到影响的行数
            int rs = stmt.executeUpdate(insertSql);
            if (rs > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    /**
     * 更新语句
     * "update  user set username='ssssss' WHERE account='hellp';"
     */

    public static void updateMethond(String updateSql) throws Exception {
        try {
            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://192.168.1.20:3306/mysql_test?useSSL=FALSE&serverTimezone=UTC", "root", "123456");
            //得到执行sql语句的Statement对象
            Statement stmt = conn.createStatement();
            //执行sql语句，并返受到影响的行数
            int rs = stmt.executeUpdate(updateSql);
            if (rs > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }



}
