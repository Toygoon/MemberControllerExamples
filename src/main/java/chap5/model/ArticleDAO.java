package chap5.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ArticleVO> getAllArticles() {
		String sql = "select article_no, writer, name, title, a.regdate, moddate, read_cnt " +
				"from article a, member m where a.writer = m.id";
		List<ArticleVO> articles = jdbcTemplate.query(sql, (rs, rowNum) -> 
			new ArticleVO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getInt(7)));
		
		return articles;
	}
}
