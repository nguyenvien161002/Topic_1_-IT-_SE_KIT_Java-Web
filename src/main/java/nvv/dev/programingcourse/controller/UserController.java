package nvv.dev.programingcourse.controller;

import nvv.dev.programingcourse.exception.UserNotFoundException;
import nvv.dev.programingcourse.model.User;
import nvv.dev.programingcourse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/user/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        try {
            User user = userService.get(id);
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("pageTitle", "Edit Form User (ID: " + id + ")");
            return "register";
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return "redirect:/";
        }
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            userService.delete(id);
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("messages", e.getMessage());
        }
        return "redirect:/";
    }

}
