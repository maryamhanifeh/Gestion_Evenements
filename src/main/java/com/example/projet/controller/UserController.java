package com.example.projet.controller;

import com.example.projet.model.User;
import com.example.projet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
    @GetMapping("/profile")
    public String userProfile(Model model) {
        // در اینجا اطلاعات کاربر از سرویس گرفته می‌شود و به مدل اضافه می‌شود
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        return "profile";
    }

    @GetMapping("/edit-profile")
    public String editProfileForm(Model model) {
        // درخواست برای نمایش فرم ویرایش پروفایل
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        return "editProfile";
    }

    private User getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return userService.getUserByUsername(username);
    }
}
