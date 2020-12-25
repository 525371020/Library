package entity;

import java.util.ArrayList;
import java.util.List;

public class student {
    private int studenNo;
    private String studentName;

    List<student> studentList=new ArrayList<student>();

    List  borrowList=new ArrayList<>();


    public void addstudent(student student){
        this.studentList.add(student);
    }
    
    public void borrowbook(int bookName,String studentName){
        this.borrowList.add(bookName,studentName);
    }

    public int getStudenNo() {
        return studenNo;
    }

    public void setStudenNo(int studenNo) {
        this.studenNo = studenNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public student() {
    }

    public student(int studenNo, String studentName) {
        this.studenNo = studenNo;
        this.studentName = studentName;
    }

    public student(int studenNo, String studentName, List<student> studentList, List borrowList) {
        this.studenNo = studenNo;
        this.studentName = studentName;
        this.studentList = studentList;
        this.borrowList = borrowList;
    }
}
