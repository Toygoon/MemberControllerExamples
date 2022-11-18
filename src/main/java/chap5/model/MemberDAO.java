package chap5.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private JdbcTemplate template;

	public List<MemberVO> listMembers() {
		String sql = "select * from member order by id";
		List<MemberVO> list = template.query(sql, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
		return list;
	}

	public MemberVO getMember(Integer id) {
		String query = "select * from member where id = ?";
		return (MemberVO) template.queryForObject(query, new Object[] { id },
				new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
	}

	public int updateMember(MemberVO member) {
		String query = "update member set name = ?, password = ?, email = ?, regdate = ? where id = ?";
		return template.update(query, member.getName(), member.getPassword(), member.getEmail(), member.getRegdate(),
				member.getId());
	}

	public int addMember(MemberVO member) {
		String query = "insert into member(name, password, email, regdate) values (?, ?, ?, ?)";
		return template.update(query, member.getName(), member.getPassword(), member.getEmail(), member.getRegdate());
	}

	public int deleteMember(Integer id) {
		String query = "delete from member where id = ?";
		return template.update(query, id);
	}
	
	public MemberVO getMemberByEmail(String email) {
		String query = "select * from member where email = ?";
		
		try {
			MemberVO member = (MemberVO) template.queryForObject(query, new Object[] {email}, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
			
			return member;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
