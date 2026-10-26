package com.example.blood_donation_platform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class DonorPost {
    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private String bloodGroup;
    private String location;
}
