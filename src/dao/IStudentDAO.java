package dao;

import java.util.List;

import entity.Student;

public interface IStudentDAO {
	//Has-A Relationship(Composition in UML)
	boolean save(Student entity);//will save data.
	List<Student> getAllStudent();//will get all data.
	Student getStudentById(Long id);
	boolean update(Student entity);
	boolean delete(Long id);
}
