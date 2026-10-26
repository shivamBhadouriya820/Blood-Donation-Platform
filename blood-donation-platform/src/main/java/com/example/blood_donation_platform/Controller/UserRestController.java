package com.example.blood_donation_platform.Controller;

import com.example.blood_donation_platform.model.DonorPost;
import com.example.blood_donation_platform.model.UserPost;
import com.example.blood_donation_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserService service ;

    // Get all user posts
    @GetMapping("/userPosts")
    public List<UserPost> getAllUser() { return service.getAllUser(); }

    // Get a user post by ID
    @GetMapping("/userPost/{userPostId}")
    public UserPost getUser(@PathVariable("userPostId") int userPostId) { return service.getUser(userPostId); }


    // Search user posts by keyword
    @GetMapping("/userPosts/keyword/{keyword}")
    public List<UserPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return service.search(keyword);
    }


    // Add a new user post
    @PostMapping("/userPost")
    public UserPost addUser(@RequestBody UserPost userPost) {
        service.adduser(userPost);
        return service.getUser(userPost.getUserPostId());
    }

    // Update an existing user post
    @PutMapping("/userPost")
    public UserPost updateUser(@RequestBody UserPost userPost) {
        service.updateUser(userPost);
        return service.getUser(userPost.getUserPostId());
    }

    // Delete a user post
    @DeleteMapping("/userPost/{postId}")
    public String deleteUser(@PathVariable("postId") int postId) {
        service.deleteUser(postId);
        return "Deleted";
    }

    // Load sample data
    @GetMapping("/loadUsers"
    )
    public String loadData() {
        service.load();
        return "Success";
    }
}
