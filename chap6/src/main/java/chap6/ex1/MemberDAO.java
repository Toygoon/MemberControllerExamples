package chap6.ex1;

import java.util.List;

public interface MemberDAO {
	public List<MemberVO> listMembers();

	public MemberVO getMember(Integer id);

	public int updateMember(MemberVO member);

	public int addMember(MemberVO member);

	public int deleteMember(Integer id);
}
