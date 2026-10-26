package com.example.blood_donation_platform.repo;

import com.example.blood_donation_platform.model.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserPost,Integer> {
    List<UserPost> findByUserNameContainingOrUserBloodGroupContaining(String UserName , String UserBloodGroup);

}

