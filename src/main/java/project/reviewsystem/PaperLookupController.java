package project.reviewsystem;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.reviewsystem.domain.Paper;
import project.reviewsystem.domain.Rating;
import project.reviewsystem.service.PaperService;
import project.reviewsystem.service.RatingService;



@Controller
public class PaperLookupController {
	
	private static final Logger logger = LoggerFactory.getLogger(PaperLookupController.class);
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private PaperService paperService;

	@GetMapping("/searchpapers")
    public String searchPapers(
			@RequestParam(name="paperId", required=false) String paperId,
			@ModelAttribute Paper paper,
			Model model
		) {
		List<Rating> ratingList = new ArrayList<Rating>();

		System.out.println(paperId);
		if (paperId == null || paperId.equals(""))
    		ratingList = ratingService.getRatingList();
		else {
			paper = new Paper("", paperId);
			ratingList = ratingService.getRatingListForPaper(paper);
		}

    	model.addAttribute("ratingList", ratingList);
        return "searchpapers";
    }
	
	@GetMapping("/browsepapers")
    public String browsePapers(Model model) {
		List<Paper> paperList = new ArrayList<Paper>();

		paperList = paperService.getPaperList();

    	model.addAttribute("paperList", paperList);
        return "browsepapers";
    }
}