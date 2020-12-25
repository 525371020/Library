package service;/*
 @autor AIPMAN
 @ 9:50
 文件说明：无
*/

import Tools.Base;
import io.ReadAndWrite;

import java.util.Scanner;

public class login extends Base {

    Scanner sc = new Scanner(System.in);
    ReadAndWrite readAndWrite = new ReadAndWrite();

    public boolean login1() throws Exception {
        System.out.println("请输入用户名");
        String name=sc.next();
        String sql = "select * from student where studentName=?";
        boolean flag=false;
        rs = this.query(sql,new Object[]{name});
            while (rs.next()) {
                String studentName = rs.getString("studentName");
                System.out.println("登陆成功");
                flag=true;

            }
        this.close();
        return flag;
    }

}
