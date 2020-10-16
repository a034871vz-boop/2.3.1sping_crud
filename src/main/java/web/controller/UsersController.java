package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;


// Create
@GetMapping(value = "/createNewUser")
public String createNewUser(Model model){
    model.addAttribute("newUser", new User());
    return "newUser";
}

    @GetMapping(value = "/create")
    public String create(@ModelAttribute("user") User user){
        userService.createUser(user);
        return "redirect:/";
    }

//Read
    @GetMapping(value = {"/","users","allUsers"})
    public String allUsers(Model model){
        List<User> listUsers = userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "allUsers";
    }

//Update
    @GetMapping(value = "/editUser")
    public String editUser(ModelMap model, @RequestParam("id") Long id) {
        User user = userService.readUserById(id);
        model.addAttribute("user", user);
        return "/editUser";
    }
    @GetMapping(value = "/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

// Delete
    @GetMapping("/deleteUser")
    public String deleteUserById(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
