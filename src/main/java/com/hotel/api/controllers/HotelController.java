package com.hotel.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.api.entities.HotelEntity;
import com.hotel.api.services.HotelService;

@RestController
@RequestMapping("/api")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/hotels")
	public ResponseEntity<?> addHotel(@RequestBody HotelEntity hotelEntity) throws Exception{
		if (hotelEntity == null) {
			throw new Exception("Request body not found.");
		}
		HotelEntity savedHotel = this.hotelService.addHotel(hotelEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
	}
	
	@PutMapping("/hotels")
	public ResponseEntity<?> updateHotel(@RequestBody HotelEntity hotelEntity) throws Exception{
		if (hotelEntity == null) {
			throw new Exception("Request body not found.");
		}
		HotelEntity updatedHotel = this.hotelService.updateHotel(hotelEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedHotel);
	}
	
	@DeleteMapping("/hotels/{hotelId}")
	public ResponseEntity<String> deleteHotel(@PathVariable Integer hotelId){
		this.hotelService.deleteHotel(hotelId);
		return new ResponseEntity<>("Deleted Successfully.", HttpStatus.OK);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<HotelEntity> getHotel(@PathVariable Integer hotelId){
		HotelEntity hotel = this.hotelService.getHotelById(hotelId);
		
		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
	
	@GetMapping("/hotels/city/{city}")
	public ResponseEntity<List<HotelEntity>> getHotelsByCity(@PathVariable String city){
		List<HotelEntity> hotelsByCity = this.hotelService.getHotelsByCity(city);
		
		return ResponseEntity.ok(hotelsByCity);
	}
	
	@GetMapping("/hotels/menu/{menu}")
	public ResponseEntity<List<HotelEntity>> getHotelsByMenu(@PathVariable String menu){
		List<HotelEntity> hotelsByMenu = this.hotelService.getHotelsByMenu(menu);
		return ResponseEntity.ok(hotelsByMenu);
	}
	@GetMapping("/hotels/partner/{partnerName}")
	public ResponseEntity<List<HotelEntity>> getHotelsByDelivery(@PathVariable String partnerName){
		List<HotelEntity> hotelsByDelivery = this.hotelService.getHotelsByDelivery(partnerName);
		return ResponseEntity.ok(hotelsByDelivery);
	}
	
	@GetMapping("/hotels/location/{location}")
	public ResponseEntity<List<HotelEntity>> getHotelsByLocation(@PathVariable("location") String street){
		List<HotelEntity> hotelsByLocation = this.hotelService.getHotelsByLocation(street);
		return ResponseEntity.ok(hotelsByLocation);
	}
	
	@GetMapping("/hotels/{location}/{menu}")
	public ResponseEntity<List<HotelEntity>> getHotelsByLocationAndMenu(@PathVariable String location,@PathVariable String menu){
		List<HotelEntity> hotelsByLocationAndMenu = this.hotelService.getHotelsByLocationAndMenu(location, menu);
		return ResponseEntity.ok(hotelsByLocationAndMenu);
	}
}
