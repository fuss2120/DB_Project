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
    
    @GetMapping("/reviewpage")
    public String reviewpage(Model model, HttpSession session) {
        Participator user = (Participator)session.getAttribute("user");
        model.addAttribute("user", user);
        return "reviewpage";
    }
	
    @GetMapping("/createpaper")
    public String createpage(Model model) {
        return "createpaper";
    }
}