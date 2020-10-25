package dao;



import entity.Author;

public interface IAuthorDAO {
//Has-A Relationship(Composition in UML)
boolean save(Author author);//will save data.
void getAllAuthor();//will get all data.
}
