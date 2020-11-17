package entity;

public class Student {
private Long id;
private String no,name,email,phone,address,gender;
public Student(Long id, String no, String name,String gender, String email, String phone, String address) {
	this.id = id;
	this.no = no;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.address = address;
	this.gender=gender;
}
public Student(String no, String name,String gender, String email, String phone, String address) {
	this.no = no;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.address = address;
	this.gender=gender;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNo() {
	return no;
}
public void setNo(String no) {
	this.no = no;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

}
