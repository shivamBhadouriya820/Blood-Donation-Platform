package com.example.blood_donation_platform.service;

import com.example.blood_donation_platform.model.DonorPost;
import com.example.blood_donation_platform.model.UserPost;
import com.example.blood_donation_platform.model.UserPost;
import com.example.blood_donation_platform.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void adduser(UserPost userPost){
        userRepo.save(userPost);
    }


    public List<UserPost>getAllUser(){
        return userRepo.findAll();
    }



    public UserPost getUser(int UserpostId) {
        return userRepo.findById(UserpostId).orElse(new UserPost());
    }

    public void updateUser(UserPost user) {
        userRepo.save(user);
    }

    public void deleteUser(int UserPostId) {
        userRepo.deleteById(UserPostId);
    }

    public void load(){
        List<UserPost> User = new ArrayList<>(Arrays.asList(
                new UserPost(1,"Jay",21,"Male","A Positve","Donor","B-","Goa"),
                new UserPost(2,"Naveen",25,"Male","B Negative","Admin","A+","Delhi"),
                new UserPost(3,"nilesh",42,"Male","AB Positive","Requester","B+","Bharuch"),
                new UserPost(4,"Kishor",24,"MAle","O Positive","Requester","O+","Mumbai")
        ));

        userRepo.saveAll(User);
    }

    public List<UserPost> search(String keyword) {
        return userRepo.findByUserNameContainingOrUserBloodGroupContaining(keyword,keyword);
    }
}
