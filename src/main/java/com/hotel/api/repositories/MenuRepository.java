package com.hotel.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.api.entities.MenuEntity;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Integer>{
	
	// Derived queries
	List<MenuEntity> findByHotelName(String hotel);
	
	// @Query() with JPQL
	
//	@Query("FROM MenuEntity m INNER JOIN m.hotel mn WHERE mn.name=?1")
//	List<MenuEntity> findByHotel(String hotel);
	
//	@Query(value = "select * from menus m inner join hotels h on h.hotel_id=m.hotel_id where h.name=?1", nativeQuery = true)
//	List<MenuEntity> findByHotel(String hotel);
}
