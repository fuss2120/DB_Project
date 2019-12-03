package project.reviewsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.reviewsystem.DAO.PaperDAO;
import project.reviewsystem.domain.Paper;

@Component
public class PaperService {
	
	@Autowired
	PaperDAO paperDAO;
	
	public List<Paper> getPaperList(){
		List<Paper> paperList = new ArrayList<Paper>();
		
		paperList = paperDAO.getPaperList();
		
		return paperList;
	}

	public void uploadPaper(Paper paper) {
		paperDAO.uploadPaper(paper);
	}
	
}
