package entity;

import java.util.ArrayList;
import java.util.List;

public class book {
    private int bookNo;
    private String bookName;  //书名
    private int bookNum;  //数量

    List<book>  bookList=new ArrayList<book>();

    public void addbook(book book){
        this.bookList.add(book);
    }

    public void deletebook(book book){
        this.bookList.remove(book);
    }

    public void addBook(book addBook){
        bookList.add(addBook);
    }
    public void deleteBook(book deleteBook)
    {
        bookList.remove(deleteBook);
    }

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public List<book> getBookList() {
        return bookList;
    }

    public void setBookList(List<book> bookList) {
        this.bookList = bookList;
    }

    public book() {
    }


    public book(String bookName,int bookNum) {
        this.bookName = bookName;
        this.bookNum = bookNum;
    }

    public book(int bookNo, String bookName, int bookNum) {
        this.bookNo = bookNo;
        this.bookName = bookName;
        this.bookNum = bookNum;
    }
}
