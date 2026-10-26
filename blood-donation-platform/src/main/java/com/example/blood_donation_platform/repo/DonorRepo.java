package com.example.blood_donation_platform.repo;

import com.example.blood_donation_platform.model.DonorPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public interface DonorRepo extends JpaRepository<DonorPost,Integer> {
    List<DonorPost> findByPostProfileContainingOrPostDescContaining(String postProfile , String postDesc);
    List<DonorPost> findByBloodGroup(String bloodGroup);
    List<DonorPost> findBylocation(String location);

}

//List<DonorPost> donors = new ArrayList<>(Arrays.asList(
//        new DonorPost(1,"Shivam","Must have B positive",6),
//        new DonorPost(2,"Chetan","Must have A positive",7),
//        new DonorPost(3,"Jaidep","Must have AB positive",8),
//        new DonorPost(4,"Ankit","Must have B negative",9)    ));
//
//public List<DonorPost> getAllDonors(){
//    return donors;
//}
//
//public void adddonor(DonorPost donor){
//
//    donors.add(donor);
//    System.out.println(donors);
//}
//
//public DonorPost getDonor(int postId) {
//    for(DonorPost donor : donors){
//        if(donor.getPostId() == postId){
//            return donor;
//        }
//    }
//    return null;
//}
//
//public void updateDonor(DonorPost donorPost) {
//    for (DonorPost donorPost1: donors){
//        if(donorPost1.getPostId() == donorPost.getPostId()){
//            donorPost1.setPostProfile(donorPost.getPostProfile());
//            donorPost1.setPostDesc(donorPost.getPostDesc());
//            donorPost1.setReqExperience(donorPost.getReqExperience());
//        }
//    }
//}
//
//public void deleteDonor(int postId) {
//    for(DonorPost donorPost : donors){
//        if(donorPost.getPostId() == postId)
//            donors.remove(donorPost);
//    }
//}