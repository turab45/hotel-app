package com.hotel.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.api.entities.HotelEntity;
import com.hotel.api.repositories.HotelRepository;
import com.hotel.api.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public HotelEntity addHotel(HotelEntity hotel) {
		HotelEntity hotelEntity = this.hotelRepository.save(hotel);
		return hotelEntity;
	}

	@Override
	public HotelEntity updateHotel(HotelEntity hotel) {
		HotelEntity hotelEntity = this.hotelRepository.save(hotel);
		return hotelEntity;
	}

	@Override
	public HotelEntity deleteHotel(Integer hotelId) {
		HotelEntity findById = this.hotelRepository.findById(hotelId).get();
		this.hotelRepository.delete(findById);
		return findById;
	}

	@Override
	public HotelEntity getHotelById(Integer hotelId) {
		HotelEntity hotel = this.hotelRepository.findById(hotelId).get();
		return hotel;
	}

	@Override
	public List<HotelEntity> getHotelsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelEntity> getHotelsByMenu(String menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelEntity> getHotelsByPartnerName(String partnerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelEntity> getHotelsByLocation(String street) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelEntity> getHotelsByLocationAndMenu(String location, String menu) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
