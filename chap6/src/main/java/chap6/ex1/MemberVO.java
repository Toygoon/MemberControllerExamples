package chap6.ex1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	int id;
	String email;
	String password;
	String name;
	String regdate;
}
