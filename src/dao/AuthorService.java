package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Author;

public class AuthorService extends DBUtilitity implements IAuthorDAO{
   
	@Override
	public boolean save(Author author) {
		try {
			Connection con=getConnection();
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
	public List<Author> getAllAuthor() {
		List<Author> list=new ArrayList<Author>();
		try {
			Connection con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("db connection is ok.");
			}
			String sql="select * from author";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Author author=new Author(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			    list.add(author);
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}	
		return list;
	}
	@Override
	public Author getAuthorById(Long id) {
		Author author=null;
		try {
			Connection con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("db connection is ok.");
			}
			String sql="select * from author where id= '"+id+"'";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
			author=new Author(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));		    
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return author;
	}
	@Override
	public boolean update(Author author) {
		
		try {
			Connection con=getConnection();			
			String sql="update author set name=?,email=?,gender=?,phone=?,address=? where id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,author.getName());
			pstmt.setString(2, author.getEmail());
			pstmt.setString(3,author.getGender());
			pstmt.setString(4, author.getPhone());
			pstmt.setString(5, author.getAddress());
			pstmt.setLong(6,author.getId());
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
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
