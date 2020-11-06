package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		return null;
	}

}
