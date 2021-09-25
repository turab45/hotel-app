package com.hotel.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.api.entities.HotelEntity;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer>{
	
	List<HotelEntity> findByAddressCity(String city);
	List<HotelEntity> findByAddressStreet(String street);
	
	@Query("FROM HotelEntity h INNER JOIN h.menuList mn WHERE mn.name=?1")
	List<HotelEntity> getHotelsByMenu(String menu);
	
	@Query("FROM HotelEntity h INNER JOIN h.delivery hd WHERE hd.partnerName=?1")
	List<HotelEntity> getHotelsByDelivery(String delivery);
	
	@Query("FROM HotelEntity h INNER JOIN h.address a ON h.menuList mn WHERE a.street=?1 AND mn.name=?2")
	List<HotelEntity> getHotelsByLocationAndMenu(String location, String menu);
}
