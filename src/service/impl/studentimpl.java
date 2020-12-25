package service.impl;/*
 @autor AIPMAN
 @ 19:13
 文件说明：无
*/

import Tools.Base;
import entity.book;
import io.ReadAndWrite;
import service.studentService;

import java.util.Scanner;

public class studentimpl extends Base implements studentService {
    Scanner sc = new Scanner(System.in);
    ReadAndWrite readAndWrite = new ReadAndWrite();
    book Book = new book();

    String name;
    int num;

    @Override
    public void Borrowbooks() throws Exception {
        System.out.println("请输入姓名");
        String studentName = sc.next();

        System.out.println("输入需要借阅的书籍名称");
        String sql = "select * from book where bookName=?";

        String bookName = sc.next();
        rs = this.query(sql, new Object[]{bookName});
        if (rs.next()) {
//            while (rs.next()) {
            name = rs.getString("bookName");
            num = rs.getInt("bookNum");


            if (num > 0) {
                System.out.println("库存里存在\"" + name + "\",");
                System.out.println("需要借阅几本?");
                int bookNum = sc.nextInt();
                String sql1 = "update book set bookNum=" + num + "-? where bookName=?";
                int u = this.update(sql1, new Object[]{bookNum, bookName});

                String sql2 = "INSERT INTO student set studentName=?,boorow=?,bookNum=" + num + "";
                int m = this.update(sql2, new Object[]{studentName, bookName});

                readAndWrite.writeTxt("E:\\book.txt", studentName + "  ");
                readAndWrite.writeTxt("E:\\book.txt", name + "  ");
                readAndWrite.writeTxt("E:\\book.txt", num + "  ");
                System.out.println("已经添加入‘E:\\book.txt’文本，并且也添加入数据库");
                System.out.println("借阅成功");
            } else {
                System.out.println("此书籍库存没有");
            }
//            }
        } else {
            System.out.println("没有该书籍");
        }
        this.close();
    }

    @Override
    public void studentList() throws Exception {
        System.out.println("姓名        借阅书籍      数量");
        String sql = "select * from student"; //简单的一句 sql语句
        rs = this.query(sql, null);
        while (rs.next()) {
            String bookName = rs.getString("studentName");
            String boorow = rs.getString("boorow");
            int bookNum = rs.getInt("bookNum");
            System.out.println(bookName + " " + boorow + " " + bookNum);

        }
        this.close(); //关闭资源
    }
}
