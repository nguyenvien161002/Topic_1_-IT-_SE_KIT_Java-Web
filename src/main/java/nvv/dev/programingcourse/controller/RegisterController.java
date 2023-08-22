package nvv.dev.programingcourse.controller;

import nvv.dev.programingcourse.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String showFormRegister(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "register";
    }
}
