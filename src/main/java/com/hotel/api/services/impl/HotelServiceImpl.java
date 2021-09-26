package com.hotel.api.services.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.api.entities.HotelEntity;
import com.hotel.api.entities.MenuEntity;
import com.hotel.api.exceptions.HotelNotFoundException;
import com.hotel.api.exceptions.IdNotFoundException;
import com.hotel.api.repositories.HotelRepository;
import com.hotel.api.repositories.MenuRepository;
import com.hotel.api.services.HotelService;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private MenuRepository menuRepository;

	@Override
	@Transactional
	public HotelEntity addHotel(HotelEntity hotel) {
		for(MenuEntity menuEntity: hotel.getMenuList())
			this.menuRepository.save(menuEntity);
		
		HotelEntity hotelEntity = this.hotelRepository.save(hotel);
		return hotelEntity;
	}

	@Override
	@Transactional
	public HotelEntity updateHotel(HotelEntity hotel) {
		HotelEntity hotelEntity = this.hotelRepository.save(hotel);
		return hotelEntity;
	}

	@Override
	@Transactional
	public HotelEntity deleteHotel(Integer hotelId) {
		Optional<HotelEntity> hotel = this.hotelRepository.findById(hotelId);
		if (hotel.isEmpty()) {
			throw new IdNotFoundException("Hotel with id:"+hotelId+" not found");
		}
		this.hotelRepository.delete(hotel.get());
		return hotel.get();
	}

	@Override
	public HotelEntity getHotelById(Integer hotelId) {
		return this.hotelRepository.findById(hotelId).orElseThrow(()->new IdNotFoundException("Id not found. Hotel with id: "+hotelId+" does not exist."));
		
	}

	@Override
	public List<HotelEntity> getHotelsByCity(String city) {
		List<HotelEntity> list = this.hotelRepository.findByAddressCity(city);
		if (list.isEmpty()) {
			throw new HotelNotFoundException("Hotels with city: "+city+" not found.");
		}
		return list;
	}

	@Override
	public List<HotelEntity> getHotelsByMenu(String menu) {
		List<HotelEntity> list = this.hotelRepository.getHotelsByMenu(menu);
		if (list.isEmpty()) {
			throw new HotelNotFoundException("Hotels with menu: "+menu+" not found.");
		}
		return list;
	}

	@Override
	public List<HotelEntity> getHotelsByDelivery(String partnerName) {
		List<HotelEntity> list = this.hotelRepository.getHotelsByDelivery(partnerName);
		if (list.isEmpty()) {
			throw new HotelNotFoundException("Hotels with partner: "+partnerName+" not found.");
		}
		return list;
	}

	@Override
	public List<HotelEntity> getHotelsByLocation(String street) {
		List<HotelEntity> list = this.hotelRepository.findByAddressStreet(street);
		if (list.isEmpty()) {
			throw new HotelNotFoundException("Hotels with address: "+street+" not found.");
		}
		return list;
	}

	@Override
	public List<HotelEntity> getHotelsByLocationAndMenu(String location, String menu) {
		// TODO Auto-generated method stub
		return this.getHotelsByLocationAndMenu(location, menu);
	}
	
	
}
