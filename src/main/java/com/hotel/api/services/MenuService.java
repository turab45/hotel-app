package com.hotel.api.services;

import java.util.List;

import com.hotel.api.entities.MenuEntity;

public interface MenuService {
	List<MenuEntity> getMenusByHotel(String hotel);
}
