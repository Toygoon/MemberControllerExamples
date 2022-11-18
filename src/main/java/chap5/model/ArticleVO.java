package chap5.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleVO {
	int aid;
	int writer;
	String name;
	String title;
	String regdate;
	String moddate;
	int readcnt;
}
