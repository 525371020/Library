package service.impl;/*
 @autor AIPMAN
 @ 13:14
 文件说明：无
*/

import Tools.Base;
import entity.book;
import io.ReadAndWrite;
import service.bookService;

import java.util.List;
import java.util.Scanner;

public class bookimpl extends Base implements bookService  {

    Scanner sc = new Scanner(System.in);
    ReadAndWrite readAndWrite = new ReadAndWrite();
    book Book=new book();
    @Override
    public void select(book book) throws Exception {

        System.out.println("输入书籍进行查询");
        String sql = "select * from book where bookName like ?";
        String bookName=sc.next();
        rs = this.query(sql,new Object[]{"%"+bookName+"%"});

            while(rs.next()){
                String name = rs.getString("bookName");
                String num=rs.getString("bookNum");
                System.out.println("书籍:"+name+" 数量:"+num);
            }
        this.close();
    }
    @Override
    public void delete(book book1) throws Exception{
        System.out.println("输入要删除的书籍");
        System.out.println("请输入书名：");
        String bookName = sc.next();
        String sql = "delete from book where bookName=?";
        int i =this.update(sql, new Object[]{bookName});
        if(i==1){
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }
        this.close();
    }

    @Override
    public void add(List<book> book) throws Exception{
        System.out.println("请输入书名：");
        String bookName = sc.next();

        System.out.println("输入书籍数量");
        int bookNum = sc.nextInt();

        String sql = "insert into book values(?,?);";
        int i =this.update(sql, new Object[]{bookName,bookNum});
        if(i==1){
            System.out.println("添加成功");
//            readAndWrite.writeTxt("E:\\book.txt",bookName+"  ");
//            readAndWrite.writeTxt("E:\\book.txt",bookNum+"  ");
        }
        else {
            System.out.println("添加失败");
        }
        this.close();
/*        String  bookNum1=Integer.toString(bookNum);
        book.add(new book(bookName,bookNum));
        readAndWrite.writeTxt("E:\\book.txt",bookName+"  ");
        readAndWrite.writeTxt("E:\\book.txt",bookNum+"  ");
        System.out.println("添加成功");*/

    }

    @Override
    public List list(List<book> books)throws Exception {
        System.out.println("书名    数量");
        String sql = "select * from book"; //简单的一句 sql语句
        rs = this.query(sql, null);
        while(rs.next()){
            String bookName = rs.getString("bookName");
            int bookNum = rs.getInt("bookNum");	//遍历集合添加到List<Person>集合中
            System.out.println(bookName + "  " + bookNum);
            books.add(new book(bookName,bookNum));
        }
        this.close(); //关闭资源
/*        System.out.println("书名    数量");
        for(book i:books){
            if(i!=null) {
                System.out.println(i.getBookName() + "  " + i.getBookNum());
            }
        }*/
        return Book.getBookList();
    }
}
