package service;/*
 @autor AIPMAN
 @ 13:08
 文件说明：无
*/

import entity.book;

import java.util.List;

public interface bookService  {
    void select(book book) throws Exception;
    void delete(book book) throws Exception;
    void add(List<book> book) throws Exception;
    List list(List<book> book) throws Exception;

}
