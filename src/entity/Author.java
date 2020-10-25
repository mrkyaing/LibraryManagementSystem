package entity;

public class Author {
private Long id;//primary key 
private String name;
private String email;
private String gender;
private String phone;
private String address;

public Author(String name, String email, String gender, String phone, String address) {
	this.name = name;
	this.email = email;
	this.gender = gender;
	this.phone = phone;
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
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
