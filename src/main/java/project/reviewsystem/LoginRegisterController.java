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

import project.reviewsystem.domain.Participator;
import project.reviewsystem.service.ParticipatorService;



@Controller
public class LoginRegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginRegisterController.class);

    @Autowired
    private ParticipatorService participatorService;
    
    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public String registration(Model model) {
        return "registration";
    }

    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String register(@ModelAttribute Participator participator, Model model, HttpSession session) {
        participatorService.registerParticipator(participator);
        session.setAttribute("user", participator);
        return "redirect:/";
    }
    
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginHandle(@ModelAttribute Participator participator, Model model, HttpSession session) {
        Participator user = participatorService.getParticipatorFromData(participator);
        if (user == null)
            return "login";
        session.setAttribute("user", user);
        return "redirect:/";
    }
    
    @GetMapping("/")
    public String homepage(Model model, HttpSession session) {
        Participator user = (Participator)session.getAttribute("user");
        model.addAttribute("user", user);
        return "homepage";
    }
}