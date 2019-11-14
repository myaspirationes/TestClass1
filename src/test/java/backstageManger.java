import net.sf.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;


public class backstageManger {

    /**
     * 定义页面初始化
     * Page Init Controller
     */
    @Test
    public void pageInit() {
        String uri = "http://192.168.1.18:5001/pageInit/initDefinitionPage";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            JSONObject response = JSONObject.fromObject(result.toString());
            System.out.println(response);
            String message = response.getString("messageValue");
            //JSONArray aa=new JSONArray();

            //获取json中嵌套的json的列表(list)
            JSONArray messagwe = response.getJSONObject("data").getJSONObject("dropdownOptions").getJSONArray("searchObjectTypeDropdownList");
            //列表中的json
            String labl = messagwe.getJSONObject(0).getString("label");

            System.out.println(labl);
            Assert.assertEquals("请求成功", message);
            Assert.assertEquals("通用对象定义", labl);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);

        }
    }

    /**
     * 查询所有--对象定义
     * go Definition
     */
    @Test
    public void goDefinition() {
        String link = "http://192.168.1.18:5001/goDefinition/allGoDefinition";
        String param = "dd";
        String uri = link + "/" + param;
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            JSONObject response = JSONObject.fromObject(result.toString());
            System.out.println(response);
            String message = response.getString("messageValue");
            Assert.assertEquals("请求成功", message);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);

        }
    }

    /**
     * 通过id查询--对象定义
     * go Definition by id
     */
    @Test
    public void goDefinitionById() {
        String link = "http://192.168.1.18:5001/goDefinition/goDefinitionById";
        String param = "22";
        String uri = link + "/" + param;
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            JSONObject response = JSONObject.fromObject(result.toString());
            System.out.println(response);
            String message = response.getString("messageValue");
            String code = response.getJSONObject("data").getString("code");

            Assert.assertEquals("请求成功", message);
            Assert.assertEquals("null", code);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);

        }
    }

    /**
     * 添加对象定义--对象定义
     * insertGoDefinition
     */
    @Test
    public void insertGoDefinition() {
        String uri = "http://192.168.1.18:5001/goDefinition/insertGoDefinition/DD";

        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write(" {\"goDefinitionId\":0}");
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }
    }

///////////////////////////////////////////////////////////////////////////

    /**
     * 获取所有表单列表--表单对象
     * formObject
     */
    @Test
    public void allFormObject() {
        String link = "http://192.168.1.18:5001/formObject/allFormObject/";
        String param = "A";
        String uri = link + "/" + param;
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            JSONObject response = JSONObject.fromObject(result.toString());
            System.out.println(response);
            String message = response.getString("messageValue");
            String data = response.getString("data");

            Assert.assertEquals("请求成功", message);
            Assert.assertEquals("null", data);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);

        }
    }

    /**
     * 删除表单对象--表单对象
     */
    @Test
    public void deleteFormObject() {
        String link = "http://192.168.1.18:5001/formObject/deleteFormObject/";
        String param = "100";
        String uri = link + "/" + param;
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("DELETE"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            JSONObject response = JSONObject.fromObject(result.toString());
            System.out.println(response);
            String message = response.getString("messageValue");
            String data = response.getString("data");

            Assert.assertEquals("请求成功", message);
            Assert.assertEquals("null", data);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }
    }

    /**
     * 通过主键查询表单对象--表单对象
     */
    @Test
    public void selectFormObjectByID() {
        String link = "http://192.168.1.18:5001/formObject/formObjectById/";
        String param = "100";
        String uri = link + "/" + param;
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            JSONObject response = JSONObject.fromObject(result.toString());
            System.out.println(response);
            String message = response.getString("messageValue");
            String data = response.getString("data");

            Assert.assertEquals("请求成功", message);
            Assert.assertEquals("null", data);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }
    }

    /**
     * 添加表单对象--表单对象
     */
    @Test
    public void insertFormObject() {
        String uri = "http://192.168.1.18:5001/formObject/insertFormObject";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "shanghai");
        jsonObject.put("id", "100");


        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStreamWriter pw = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            //pw.write("{\"jsonrpc\":\"2.0\",\"method\":\"query\",\"id\":5}");
            pw.write(jsonObject.toString());
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }
    }

    /**
     * 更新表单对象--表单对象
     */
    @Test
    public void updateFormObject() {
        String uri = "http://192.168.1.18:5001/formObject/updateFormObject/";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("PUT"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write("{\"jsonrpc\":\"2.0\",\"method\":\"query\",\"id\":5}");
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }

    }
////////////////////////////////////////////////////////////////////////////

    /**
     * 查询所有--业务对象
     */

    @Test
    public void allGenericObject() {
        String link = "http://192.168.1.18:5001/genericObject/allGenericObject";
        String param = "A";
        String uri = link + "/" + param;
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            JSONObject response = JSONObject.fromObject(result.toString());
            System.out.println(response);
            String message = response.getString("messageValue");
            String data = response.getString("data");

            Assert.assertEquals("请求成功", message);
            Assert.assertEquals("null", data);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);

        }
    }

    /**
     * 删除表单对象--业务对象
     */
    @Test
    public void deleteGenericObject() {
        String link = "http://192.168.1.18:5001/genericObject/deleteGenericObjectById";
        String param = "100";
        String uri = link + "/" + param;
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("DELETE"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            JSONObject response = JSONObject.fromObject(result.toString());
            System.out.println(response);
            String message = response.getString("messageValue");
            String data = response.getString("data");

            Assert.assertEquals("请求成功", message);
            Assert.assertEquals("null", data);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }
    }

    /**
     * 通过主键查询表单对象--业务对象
     */
    @Test
    public void selectGenericObjectByID() {
        String link = "http://192.168.1.18:5001/genericObject/genericObjectById";
        String param = "100";
        String uri = link + "/" + param;
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            JSONObject response = JSONObject.fromObject(result.toString());
            System.out.println(response);
            String message = response.getString("messageValue");
            String data = response.getString("data");

            Assert.assertEquals("请求成功", message);
            Assert.assertEquals("null", data);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }
    }

    /**
     * 添加表单对象--业务对象
     */
    @Test
    public void insertGenericObject() {
        String uri = "http://192.168.1.18:5001/genericObject/insertGenericObject/ss";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "shanghai");
        jsonObject.put("id", "100");

        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStreamWriter pw = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            //pw.write("{\"jsonrpc\":\"2.0\",\"method\":\"query\",\"id\":5}");
            pw.write(jsonObject.toString());
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }
    }

    /**
     * 更新表单对象--业务对象
     */
    @Test
    public void updateGenericObject() {
        String uri = "http://192.168.1.18:5001/genericObject/updateGenericObject/";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("PUT"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write("{\"jsonrpc\":\"2.0\",\"method\":\"query\",\"id\":5}");
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }

    }

    /////////////////////////////////////////////////////////////////

    /**
     * 字段定义：通过id查询字段定义
     */
    @Test
    public void goFileDefineSelectAll() {
        String link = "http://192.168.1.18:5001/goFieldDefinition/";
        String param = "12";
        String uri = link + "/" + param;
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            JSONObject response = JSONObject.fromObject(result.toString());
            System.out.println(response);
            String message = response.getString("messageValue");
            String data = response.getString("data");

            Assert.assertEquals("请求成功", message);
            Assert.assertEquals("null", data);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);

        }


    }

    /**
     * 字段定义：更新
     */
    @Test
    public void goFileDefineUpdate() {

        String uri = "http://192.168.1.18:5001/goFieldDefinition/12";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("PUT"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write("{ \"goDefinitionId\":0, \"newAssociationList\":[ { \"association\":\"AGGREGATION\", \"code\":\"string\", \"customField\":\"CUSTOM_FIELD_1\", \"displayFormat\":\"string\", \"displayOrder\":0, \"fieldValueDataType\":\"BOOLEAN\", \"goDefinition\":{ \"code\":\"string\", \"fieldDefinitionIdList\":[ 0 ], \"fieldDefinitionList\":[ null ], \"id\":0, \"label\":{ \"dft\":\"string\", \"en\":\"string\", \"es\":\"string\", \"id\":0, \"ja\":\"string\", \"pt\":\"string\", \"ru\":\"string\", \"zh_CN\":\"string\", \"zh_TW\":\"string\" }, \"labelId\":0, \"objectType\":\"GENERIC_OBJECT\" } } ]}");
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }

    }

    /**
     * 语言定义：查询
     */
    @Test
    public void languageLocalized() {
        String link = "http://192.168.1.18:5001/goLocalizedData";
        String param = "12";
        String uri = link + "/" + param;
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            JSONObject response = JSONObject.fromObject(result.toString());
            System.out.println(response);
            String message = response.getString("messageValue");
            String data = response.getString("data");

            Assert.assertEquals("请求成功", message);
            //Assert.assertEquals("null", data);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);

        }
    }

    /**
     * 语言定义：更新
     */
    @Test
    public void languageLocalizedUpdate() {
        String uri = "http://192.168.1.18:5001/goLocalizedData/12";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("PUT"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write("{ \"goDefinitionId\":0}");
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }


    }

    /**
     * 列表值定义：查询
     */
    @Test
    public void pickListValueSelect() {
        String link = "http://192.168.1.18:5001/pickListValue";
        String param = "12";
        String uri = link + "/" + param;
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            JSONObject response = JSONObject.fromObject(result.toString());
            System.out.println(response);
            String message = response.getString("messageValue");
            String data = response.getString("data");

            Assert.assertEquals("请求成功", message);
            //Assert.assertEquals("null", data);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);

        }
    }

    /**
     * 列表值定义：更新
     */
    @Test
    public void pickListValueUpdate() {
        String uri = "http://192.168.1.18:5001/pickListValue/12";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("PUT"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write("{ \"goDefinitionId\":0}");
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }


    }

    /**
     * 列表定义:添加
     */
    @Test
    public void pickListDefinition() {
        String uri = "http://192.168.1.18:5001/pickListDefinition/";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write("{\"jsonrpc\":\"2.0\",\"method\":\"query\",\"id\":5}");
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }

    }

    /**
     * 列表定义: 通过 id 查询
     */
    @Test
    public void pickListDefinitionSelectByID() {
        String uri = "http://192.168.1.18:5001/pickListDefinition/12";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }

    }

    /**
     * 列表定义:更新
     */
    @Test
    public void pickListDefinitionUpdate() {
        String uri = "http://192.168.1.18:5001/pickListDefinition/12";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("PUT"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write("{\"jsonrpc\":\"2.0\",\"method\":\"query\",\"id\":5}");
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }

    }

    /**
     * 列表定义:  查询所有列表定义数据
     */
    @Test
    public void pickListDefinitionSelectAll() {
        String uri = "http://192.168.1.18:5001/pickListDefinition/allPickListDefinition/ss";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }
    }

    /**
     * 用户对象定义：  查询所有
     */
    @Test
    public void userObjectSelectAll() {
        String uri = "http://192.168.1.18:5001/userObject/allUserObject";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("ERROR !! Please Check!", 1 == 2);
        }
    }

}


