package com.hotel.api.services;

import java.util.List;

import com.hotel.api.entities.HotelEntity;

public interface HotelService {
	public HotelEntity addHotel(HotelEntity hotel);
	public HotelEntity updateHotel(HotelEntity hotel);
	public HotelEntity deleteHotel(Integer hotelId);
	public HotelEntity getHotelById(Integer hotelId);
	
	public List<HotelEntity> getHotelsByCity(String city);
	public List<HotelEntity> getHotelsByMenu(String menu);
	public List<HotelEntity> getHotelsByDelivery(String partnerName);
	public List<HotelEntity> getHotelsByLocation(String street);
	public List<HotelEntity> getHotelsByLocationAndMenu(String location, String menu);
}
