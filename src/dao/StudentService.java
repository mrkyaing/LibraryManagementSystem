package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Student;
import java.sql.*;
public class StudentService extends DBUtilitity implements IStudentDAO{

	@Override
	public boolean save(Student entity) {		
		Connection con=getConnection();
		String sql="insert into student values(default,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,entity.getNo());
			pstmt.setString(2, entity.getName());
			pstmt.setString(3, entity.getGender());
			pstmt.setString(4,entity.getEmail());
			pstmt.setString(5, entity.getPhone());
			pstmt.setString(6, entity.getAddress());
			int insertedrowcount=pstmt.executeUpdate();
			if(insertedrowcount>0) {
				System.out.println("insert Student success");
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public List<Student> getAllStudent() {	
		List<Student> list=new ArrayList<Student>();
		try {
			Connection con=this.getConnection();
			String sql="select * from student";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Student student=new Student(rs.getLong(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));
			    list.add(student);
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}	
		return list;
	}

	@Override
	public Student getStudentById(Long id) {		
		return null;
	}

	@Override
	public boolean update(Student entity) {		
		return false;
	}

	@Override
	public boolean delete(Long id) {		
		return false;
	}

}
