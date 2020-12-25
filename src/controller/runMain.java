package controller;

import entity.book;
import service.bookService;
import service.impl.bookimpl;
import service.impl.studentimpl;
import service.studentService;

import java.util.Scanner;

public class runMain {



    public static void main(String[] args) throws Exception {

        book Book=new book();
        for(int i=0;i<Book.getBookList().size();i++){
            System.out.println(Book.getBookList().get(i).getBookName());
        }
        Scanner sc = new Scanner(System.in);
        bookService bookService=new bookimpl();
        studentService studentService=new studentimpl();

//        JFrameMain jFrameMain = new JFrameMain();

        System.out.println("===============图书管理系统===============");
                    while (true) {
                        System.out.println("请输入数字：1.查询所有书籍 2.查询书籍 3.借阅书籍 4.查询所有借阅 5.书籍管理  6.退出系统");
                        String n = sc.next();
                        switch (n) {
                            case "1":
                                System.out.println("===============查询书籍===============");
                                bookService.list(Book.getBookList());
                                break;
                            case "2":
                                System.out.println("===============查询书籍===============");
                                bookService.select(Book);
                                break;
                            case "3":
                                System.out.println("===============借阅书籍===============");
                                studentService.Borrowbooks();
                                break;
                            case "4":
                                System.out.println("===============查询所有借阅===============");
                                studentService.studentList();
                                break;
                            case "5":
                                System.out.println("===============书籍管理===============");
                                System.out.println("请输入数字：1.添加书籍 2.删除书籍 ");
                                int m = sc.nextInt();
                                switch (m) {
                                    case 1:
                                        System.out.println("===============添加书籍===============");
                                        bookService.add(Book.getBookList());
                                        break;
                                    case 2:
                                        System.out.println("===============删除书籍===============");
                                        bookService.delete(Book);
                                        break;
                                    default:
                                        System.out.println("非法输入");
                                        break;

                                }
                                break;
                            case "6":
                                System.out.println("===============退出系统===============");
                                return;
                            default:
                                System.out.println("非法输入");
                                break;

                        }
                    }
    }

}
