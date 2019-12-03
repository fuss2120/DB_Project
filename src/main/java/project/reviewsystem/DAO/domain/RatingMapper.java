package project.reviewsystem.DAO.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;

import project.reviewsystem.domain.Rating;
import project.reviewsystem.domain.Paper;

@Mapper
public interface RatingMapper {
		
	@Select("SELECT REVEMAIL, PAPERID, TECHMERIT, READABILITY, ORIGINALITY, RELAVANCE, OVERALLRECOMM FROM REVIEWS")
	public List<Rating> getRatingList();

	@Select(
		"SELECT "
			+ "REVEMAIL, PAPERID, TECHMERIT, READABILITY, "
			+ "ORIGINALITY, RELAVANCE, OVERALLRECOMM "
		+ "FROM REVIEWS "
		+ "WHERE paperid = #{paperid}"
	)
	public List<Rating> getRatingListForPaper(Paper paper);

	@Insert(
		"INSERT INTO "
			+ "reviews(revemail, paperid, techmerit, readability, originality, relavance, overallrecomm) "
		+ "Values "
			+ "(#{revemail}, #{paperid}, #{techmerit}, #{readability}, #{originality}, #{relavance}, #{overallrecomm})"
	)
	public void uploadRating(Rating rating);
}
