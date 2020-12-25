package Tools;/*
 @autor AIPMAN
 @ 16:28
 文件说明：无
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Base {
    //创建jdbc要用到的类属性
    public Connection con; //连接对象
    public PreparedStatement pstmt; //预编译通道
    public ResultSet rs;	//查询信息的集合

    //1.加载驱动 建立连接 创建一个预编译通道
    public Connection looding() throws Exception{

        Class.forName("com.mysql.jdbc.Driver"); //加载驱动
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","gaoqi07757630089"); //创建连接
//        System.out.println("连接Mysql成功");
        return con;	//返回一个连接
    }


    //创建一个通用的查询方法 传递一条String sql语句 和一个Object[]数组，  返回一个查询结果的集合
    public ResultSet query(String sql,Object[] object) throws Exception{
        con = this.looding(); //调用加载方法 进行加载驱动和建立连接
        pstmt = con.prepareStatement(sql); //创建一个预编译通道 对象
        if(object==null){ //判断一下 object 是否为空 如果为空直接执行sql语句
            rs = pstmt.executeQuery();
            return rs;
        }else{			//如果不为空  循环给所有的  ‘？’赋值（‘？’的下标是从 1 开始的）
            for(int i=0;i<object.length;i++){
                pstmt.setObject(i+1,object[i]);
            }
            rs = pstmt.executeQuery(); //最后执行executeQuery()方法 执行sql语句
            return rs;		//返回 查询信息的集合
        }


    }



    //以下方法原理相同

    //创建一个通用的增、删、改的方法 传递一条String sql语句 和一个Object[] 数组，  返回受影响行数
    public int update(String sql,Object[] object) throws Exception{
        con = this.looding();
        pstmt = con.prepareStatement(sql);
        if(object==null||object.equals("")){
            int count = pstmt.executeUpdate();
            return count;
        }else{
            for(int i=0;i<object.length;i++){
                pstmt.setObject(i+1,object[i]);
            }
            int count = pstmt.executeUpdate();
            return count;
        }
    }
    //关闭资源方法 使用完记得关闭 不然会占用资源
    public void close() throws Exception{
        if(rs!=null){
            rs.close();
        }
        if(pstmt!=null){
            pstmt.close();
        }
        if(con!=null){
            con.close();
        }
    }
}
