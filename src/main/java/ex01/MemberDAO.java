package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	private String jdbc = "com.mysql.cj.jdbc.Driver", url = "jdbc:mysql://localhost/spring4fs";
	private Connection conn = null;
	private PreparedStatement ps = null;
	
	public void connect() {
		try {
			Class.forName(jdbc);
			conn = DriverManager.getConnection(url, "spring4", "spring4");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<MemberVO> getMembersList() {
		this.connect();
		
		ArrayList<MemberVO> list = new ArrayList<>();
		String sql = "select * from member order by id;";
		
		ResultSet rs = null;
		MemberVO member = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				member = new MemberVO();
				member.setId(rs.getInt("id"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setRegdate(rs.getString("regdate"));
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}
	
	public void insertMember(MemberVO memberVO) {
		this.connect();
		
		String sql = "insert into member(email, name, password, regdate) value (?, ?, ?, ?);";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberVO.getEmail());
			ps.setString(2, memberVO.getName());
			ps.setString(3, memberVO.getPassword());
			ps.setString(4, memberVO.getRegdate());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public MemberVO getMemberById(int id) {
		this.connect();
		
		String sql = "select * from member where id = ?;";
		MemberVO member = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				member = new MemberVO();
				member.setId(rs.getInt("id"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setRegdate(rs.getString("regdate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return member;
	}

	public void updateMember(MemberVO memberVO) {
		this.connect();
		
		String sql = "update member set email = ?, name = ?, password = ?, regdate = ? where id = ?;";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberVO.getEmail());
			ps.setString(2, memberVO.getName());
			ps.setString(3, memberVO.getPassword());
			ps.setString(4, memberVO.getRegdate());
			ps.setInt(5, memberVO.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void deleteMember(int id) {
		this.connect();
		
		String sql = "delete from member where id = ?;";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public MemberVO getMemberByEmail(String email) {
		// TODO Auto-generated method stub
		this.connect();
		
		String sql = "select * from member where email = ?";
		MemberVO memberVO = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setId(rs.getInt("id"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setName(rs.getString("name"));
				memberVO.setPassword(rs.getString("password"));
				memberVO.setRegdate(rs.getString("regdate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memberVO;
	}
}
