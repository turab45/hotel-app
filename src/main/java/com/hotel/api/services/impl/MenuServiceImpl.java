package com.hotel.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.api.entities.MenuEntity;
import com.hotel.api.repositories.MenuRepository;
import com.hotel.api.services.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<MenuEntity> getMenusByHotel(String hotel) {
		// TODO Auto-generated method stub
		return null;
	}

}
