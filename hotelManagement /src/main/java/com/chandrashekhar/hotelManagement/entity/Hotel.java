package com.chandrashekhar.hotelManagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "hotel_name")
    private String name;

    @Column(name = "hotel_location")
    private String location;

    private  String about;


}
