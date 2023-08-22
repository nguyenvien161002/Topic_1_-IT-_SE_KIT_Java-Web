package nvv.dev.programingcourse.controller;

import nvv.dev.programingcourse.model.User;
import nvv.dev.programingcourse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showUserList(ModelMap modelMap) {
        List<User> userList = userService.listAll();
        modelMap.addAttribute("userList", userList);
        return "index";
    }

}
