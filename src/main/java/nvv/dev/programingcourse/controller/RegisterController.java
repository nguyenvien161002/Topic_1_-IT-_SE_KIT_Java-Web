package nvv.dev.programingcourse.controller;

import nvv.dev.programingcourse.model.User;
import nvv.dev.programingcourse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showFormRegister(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("pageTitle", "Register Form");
        return "register";
    }

    @PostMapping("/user/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes) {
        userService.save(user);
        redirectAttributes.addFlashAttribute("messages", "Successfully!");
        return "redirect:/";
    }
}
