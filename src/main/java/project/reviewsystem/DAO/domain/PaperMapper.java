package project.reviewsystem.DAO.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import project.reviewsystem.domain.Paper;

@Mapper
public interface PaperMapper {

	@Select("SELECT TITLE, PAPERID FROM PAPER")
	public List<Paper> getPaperList();

	@Insert(
		"INSERT INTO "
			+ "paper(paperid, title, filename, contactauthoremail, abstract) "
		+ "VALUES "
			+ "((select max(paperid)+1 from paper), #{title}, #{filename}, #{contactauthoremail}, #{abstractval})"
	)
	public void uploadPaper(Paper paper);
}
