package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Book;
import viewmodel.bookviewmodel;

public class BookService extends DBUtilitity implements IBookDAO {


	@Override
	public boolean create(Book book) {
		try {
			Connection con=getConnection();
			if(con!=null) {
				System.out.println("db connection is ok.");
			}
			String sql="insert into book(name,description,unitprice,authorid) values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,book.getName());
			pstmt.setString(2, book.getDescription());
			pstmt.setDouble(3,book.getUnitprice());
			pstmt.setLong(4, book.getAuthor().getId());
			int insertedrowcount=pstmt.executeUpdate();
			if(insertedrowcount>0) {
				System.out.println("insert book success");
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
	public List<bookviewmodel> getAll() {
		List<bookviewmodel> data=new ArrayList<bookviewmodel>();
		String query="select book.id,book.name,book.description,book.unitprice,author.name from book inner join author on book.authorid=author.id";
	    Connection con=getConnection();
	    try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
			bookviewmodel book=new bookviewmodel();
		    book.setId(rs.getLong(1));
		    book.setName(rs.getString(2));
		    book.setDescription(rs.getString(3));
		    book.setUnitprice(rs.getInt(4));
		    book.setAuthorName(rs.getString(5));
			data.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
