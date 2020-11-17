package dao;

import java.util.List;

import entity.Book;
import viewmodel.bookviewmodel;

public interface IBookDAO {
boolean create(Book book);
List<bookviewmodel> getAll();
}
