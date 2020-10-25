package entity;

public class Book {
private Long id;
private String name,description;
private int unitprice;
private Author author;


public Book(String name, String description, int unitprice, Author author) {
	this.name = name;
	this.description = description;
	this.unitprice = unitprice;
	this.author = author;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getUnitprice() {
	return unitprice;
}
public void setUnitprice(int unitprice) {
	this.unitprice = unitprice;
}
public Author getAuthor() {
	return author;
}
public void setAuthor(Author author) {
	this.author = author;
}



}
