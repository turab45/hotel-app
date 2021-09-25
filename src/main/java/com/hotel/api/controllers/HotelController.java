package com.hotel.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.api.entities.HotelEntity;
import com.hotel.api.services.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/api/hotels")
	public ResponseEntity<?> addHotel(@RequestBody HotelEntity hotelEntity) throws Exception{
		if (hotelEntity == null) {
			throw new Exception("Request body not found.");
		}
		HotelEntity savedHotel = this.hotelService.addHotel(hotelEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
	}
	
	@GetMapping("/api/hotels/{hotelId}")
	public ResponseEntity<HotelEntity> getHotel(@PathVariable Integer hotelId){
		HotelEntity hotel = this.hotelService.getHotelById(hotelId);
		
		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
}
