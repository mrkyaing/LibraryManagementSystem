package dao;

import java.util.List;

import entity.Book;

public interface IBookDAO {
boolean create(Book book);
List<Book> getAll();
}
