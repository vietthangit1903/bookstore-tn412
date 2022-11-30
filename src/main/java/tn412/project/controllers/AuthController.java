package tn412.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tn412.project.dto.UserDto;
import tn412.project.models.User;
import tn412.project.repositories.UserRepository;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class AuthController {

	@Autowired
	private UserRepository repo;

	public AuthController() {
	}

	@GetMapping("/login")
    public String showLoginForm() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null || authentication instanceof AnonymousAuthenticationToken)
			return "/login";
		return "redirect:/";
    }

	

	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new UserDto());
		return "/register";
	}

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public ModelAndView handleRegister(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult){
		if(repo.findByEmail(userDto.getEmail()) != null){
			bindingResult.rejectValue("email" ,"error.user", "There is already a user registered with the email provided");
		}
		ModelAndView modelAndView = new ModelAndView();
		if(bindingResult.hasErrors()){
			modelAndView.setViewName("/register");
			return modelAndView;
		}
		else {
			User user = new User();
			user.setFullName(userDto.getFullName());
			user.setEmail(userDto.getEmail());
			String encodedPassword = passwordEncoder.encode(userDto.getPassword());
			user.setPassword(encodedPassword);
			user.setRole("Guest");
			repo.save(user);

			modelAndView.addObject("successMessage", "Your account with email, " + user.getEmail()
					+ " has been registered successfully");
			modelAndView.addObject("user", userDto);
			modelAndView.setViewName("/register");
			return modelAndView;
		}
	}


}
