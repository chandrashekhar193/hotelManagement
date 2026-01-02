package com.chandrashekhar.hotelManagement.repository;

import com.chandrashekhar.hotelManagement.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel , Long> {
    boolean existsByName(String name);

    Optional<Hotel> findByName(String name);

}
