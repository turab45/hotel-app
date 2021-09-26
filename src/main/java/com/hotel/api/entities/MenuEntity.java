package com.hotel.api.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="menus")
@NoArgsConstructor
@AllArgsConstructor
public class MenuEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private Integer id;
	
	private String name;
	private Float price;
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	@JsonIgnore
	private HotelEntity hotel;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public HotelEntity getHotel() {
		return hotel;
	}


	public void setHotel(HotelEntity hotel) {
		this.hotel = hotel;
	}


	@Override
	public String toString() {
		return "MenuEntity [id=" + id + ", name=" + name + ", price=" + price + ", hotel=" + hotel + "]";
	}
	
	
	
}
