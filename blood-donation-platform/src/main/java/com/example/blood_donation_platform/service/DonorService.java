package com.example.blood_donation_platform.service;

import com.example.blood_donation_platform.model.DonorPost;
import com.example.blood_donation_platform.repo.DonorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DonorService {

    @Autowired
    private DonorRepo repo;

    public void adddonor(DonorPost donorPost){
        repo.save(donorPost);
    }

    public List<DonorPost>getAllDonors(){
        return repo.findAll();
    }

    public DonorPost getDonor(int postId) {
        return repo.findById(postId).orElse(new DonorPost());
    }

    public void updateDonor(DonorPost donorPost) {
            repo.save(donorPost);
    }

    public void deleteDonor(int postId) {
            repo.deleteById(postId);
    }

    public void load(){
        List<DonorPost> donors = new ArrayList<>(Arrays.asList(
                new DonorPost(1,"Shivam","Must have B positive","B+","Mumbai"),
                new DonorPost(2,"Chetan","Must have A positive","A+","Delhi"),
                new DonorPost(3,"Jaidep","Must have AB positive","AB+","Patna"),
                new DonorPost(4,"Ankit","Must have B negative","B-","Goa")
        ));

    repo.saveAll(donors);
    }

    public List<DonorPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }

    public List<DonorPost> getDonorsByBloodGroup(String bloodGroup) {
        return repo.findByBloodGroup(bloodGroup);
    }

    public List<DonorPost> getDonorsByLocation(String location){
        return repo.findBylocation(location);
    }
}
