package project.reviewsystem.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.reviewsystem.DAO.domain.PaperMapper;
import project.reviewsystem.domain.Paper;

@Component
public class PaperDAO {
	
	@Autowired
	PaperMapper paperMapper;
	
	public List<Paper> getPaperList(){
		List<Paper> paperList = new ArrayList<Paper>();
		
		paperList = paperMapper.getPaperList();
		
		return paperList;
	}
	
}
