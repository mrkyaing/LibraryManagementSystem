package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Author;

public class AuthorService implements IAuthorDAO{
    String url="jdbc:mysql://localhost:3306/libmgtdb";
    String user="root";
    String password="root@123";    
	@Override
	public boolean save(Author author) {
		try {
			Connection con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("db connection is ok.");
			}
			String sql="insert into author(name,email,gender,phone,address) values(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,author.getName());
			pstmt.setString(2, author.getEmail());
			pstmt.setString(3,author.getGender());
			pstmt.setString(4, author.getPhone());
			pstmt.setString(5, author.getAddress());
			int insertedrowcount=pstmt.executeUpdate();
			if(insertedrowcount>0) {
				System.out.println("insert author success");
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		return true;
	}
	@Override
	public void getAllAuthor() {
		
	}
}
