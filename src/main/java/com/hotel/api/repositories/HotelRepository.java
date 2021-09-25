package com.hotel.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.api.entities.HotelEntity;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer>{

}
