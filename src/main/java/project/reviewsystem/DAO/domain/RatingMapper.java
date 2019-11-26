package project.reviewsystem.DAO.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import project.reviewsystem.domain.Rating;
import project.reviewsystem.domain.Paper;

@Mapper
public interface RatingMapper {
		
	@Select("SELECT PAPERID, TECHMERIT, READABILITY, ORIGINALITY, RELAVANCE, OVERALLRECOMM FROM REVIEWS")
	public List<Rating> getRatingList();

	@Select(
		"SELECT "
			+ "PAPERID, TECHMERIT, READABILITY, "
			+ "ORIGINALITY,RELAVANCE, OVERALLRECOMM "
		+ "FROM REVIEWS "
		+ "WHERE paperid = #{paperid}"
	)
	public List<Rating> getRatingListForPaper(Paper paper);
}
