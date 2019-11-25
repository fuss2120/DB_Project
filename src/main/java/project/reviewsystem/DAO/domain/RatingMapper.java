package project.reviewsystem.DAO.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import project.reviewsystem.domain.Rating;

@Mapper
public interface RatingMapper {
		
	@Select("SELECT PAPERID, TECHMERIT, READABILITY, ORIGINALITY, RELAVANCE, OVERALLRECOMM FROM REVIEWS")
	public List<Rating> getRatingList();
}
