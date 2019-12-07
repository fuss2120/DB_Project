package project.reviewsystem;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import project.reviewsystem.domain.Participator;
import project.reviewsystem.service.PaperService;
import project.reviewsystem.service.RatingService;



@Controller
public class ReviewCreateController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewCreateController.class);

    @Autowired
    private RatingService ratingService;

    @Autowired
    private PaperService paperService;
    
    @GetMapping("/reviewpage")
    public String reviewpage(Model model, HttpSession session) {
	    Participator user = (Participator)session.getAttribute("user");
        if (user == null)
            return "redirect:/login";
        model.addAttribute("user", user);
        return "reviewpage";
    }

    @RequestMapping(value="/reviewpage", method=RequestMethod.POST)
    public String reviewHandle(@ModelAttribute Rating rating, Model model, HttpSession session) {
        try {
            ratingService.uploadRating(rating);
        }
        catch (Exception e) {
            if (e.getMessage().contains("integrity constraint")) {
                Participator user = (Participator)session.getAttribute("user");
                model.addAttribute("user", user);
                model.addAttribute("errorMessage", "Paper ID does not exist");
            }
            else if (e.getMessage().contains("unique constraint")) {
                Participator user = (Participator)session.getAttribute("user");
                model.addAttribute("user", user);
                model.addAttribute("errorMessage", "You already reviewed this paper");
            }
            return "reviewpage";
        }
        return "redirect:/";
    }
	
    @GetMapping("/createpaper")
    public String createpage(Model model, HttpSession session) {
	    Participator user = (Participator)session.getAttribute("user");
        if (user == null)
            return "redirect:/login";
        model.addAttribute("user", user);
        return "createpaper";
    }

    @RequestMapping(value="/createpaper", method=RequestMethod.POST)
    public String uploadPaper(@ModelAttribute Paper paper, Model model, HttpSession session) {
        paperService.uploadPaper(paper);
        return "redirect:/";
    }
}