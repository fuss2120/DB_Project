package project.reviewsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.reviewsystem.DAO.RatingDAO;
import project.reviewsystem.domain.Rating;
import project.reviewsystem.domain.Paper;

@Component
public class RatingService {
	
	@Autowired
	RatingDAO ratingDAO;
	
	public List<Rating> getRatingList(){
		List<Rating> ratingList = new ArrayList<Rating>();

		ratingList = ratingDAO.getRatingList();
		
		return ratingList;
	}

	public List<Rating> getRatingListForPaper(Paper paper) {
		List<Rating> ratingList = new ArrayList<Rating>();
		ratingList = ratingDAO.getRatingListForPaper(paper);
		return ratingList;
	}

	public void uploadRating(Rating rating) {
		ratingDAO.uploadRating(rating);
	}
}
