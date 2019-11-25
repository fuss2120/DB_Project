package project.reviewsystem.DAO.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import project.reviewsystem.domain.Paper;

@Mapper
public interface PaperMapper {

	@Select("SELECT TITLE, PAPERID FROM PAPER")
	public List<Paper> getPaperList();
}
