package com.example.blood_donation_platform.Controller;


import com.example.blood_donation_platform.model.DonorPost;
import com.example.blood_donation_platform.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonorRestController {

    @Autowired
    private DonorService service;
    @GetMapping("donorPosts")
    public List<DonorPost> getAllDonors() {
        return service.getAllDonors();
    }

    @GetMapping("donorPost/{postId}")
    public DonorPost getDonor(@PathVariable("postId") int postId){
        return service.getDonor(postId);
    }

    @GetMapping("donorPosts/keyword/{keyword}")
    public List<DonorPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }

    @PostMapping("donorPost")
    public DonorPost addDonor(@RequestBody DonorPost donorPost){
        service.adddonor(donorPost);
        return service.getDonor(donorPost.getPostId());
    }

    @PutMapping("donorPost")
    public DonorPost updateDonor(@RequestBody DonorPost donorPost){
        service.updateDonor(donorPost);
        return service.getDonor(donorPost.getPostId());
    }

    @DeleteMapping("donorPost/{postId}")
    public String deleteDonor(@PathVariable int postId){
        service.deleteDonor(postId);
        return "Deleted";
    }

    //find by bloodgroup
    @GetMapping("donorPosts/blood-group/{bloodGroup}")
    public List<DonorPost> getDonorsByBloodGroup(
            @PathVariable String bloodGroup) {

        return service.getDonorsByBloodGroup(bloodGroup);
    }

    //find by City
    @GetMapping("donorPosts/{location}")
    public List<DonorPost>getDonorsByLocation(@PathVariable String location){
        return service.getDonorsByLocation(location);
    }

    @GetMapping("loadDonor")
    public String loadData(){

        service.load();

        return "Success";
    }
}
