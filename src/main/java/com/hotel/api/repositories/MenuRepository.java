package com.hotel.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.api.entities.MenuEntity;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Integer>{

}
