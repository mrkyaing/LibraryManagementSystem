package dao;



import java.util.List;

import entity.Author;

public interface IAuthorDAO {
//Has-A Relationship(Composition in UML)
boolean save(Author author);//will save data.
List<Author> getAllAuthor();//will get all data.
Author getAuthorById(Long id);
boolean update(Author author);
boolean delete(Long id);
}
