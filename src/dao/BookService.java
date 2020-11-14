package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Book;

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
	public List<Book> getAll() {
		List<Book> data=new ArrayList<Book>();
		String query="select * from book";
	    Connection con=getConnection();
	    try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
		    Book book=new Book();
		    book.setId(rs.getLong(1));
		    book.setName(rs.getString(2));
		    book.setDescription(rs.getString(3));
		    book.setUnitprice(rs.getInt(4));
		    //book.setAuthor(rs.getString(5));
			data.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
