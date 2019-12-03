package project.reviewsystem.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.reviewsystem.DAO.domain.RatingMapper;
import project.reviewsystem.domain.Rating;
import project.reviewsystem.domain.Paper;

@Component
public class RatingDAO {

	@Autowired
	private RatingMapper ratingMapper;
	
	public List<Rating> getRatingList() {
		List<Rating> ratingList = new ArrayList<Rating>();

		ratingList = ratingMapper.getRatingList();
		
		return ratingList;
	}

	public List<Rating> getRatingListForPaper(Paper paper) {
		List<Rating> ratingList = new ArrayList<Rating>();
		ratingList = ratingMapper.getRatingListForPaper(paper);
		return ratingList;
	}

	public void uploadRating(Rating rating) {
		ratingMapper.uploadRating(rating);
	}
}
