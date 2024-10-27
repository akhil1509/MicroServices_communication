package com.user.User_Details.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Car {


    private Long id;
    @NotBlank

    private String model;
    @NotBlank

    private String type;


}