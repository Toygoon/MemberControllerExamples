package ex01;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	int id;
	String email;
	String name;
	String password;
	String regdate;
}
