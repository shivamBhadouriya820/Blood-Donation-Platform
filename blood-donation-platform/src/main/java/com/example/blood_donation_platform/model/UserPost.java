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
public class UserPost {
    @Id
    private int UserPostId;
    private String UserName;
    private int UserAge;
    private String UserGender;
    private String UserBloodGroup;
    private String role;
    private String bloodGroup;
    private String location;

}
