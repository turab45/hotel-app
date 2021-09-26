package com.hotel.api.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="deliveries")
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_id")
	private Integer id;
	
	private String partnerName;
	private double charges;
	@ManyToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<HotelEntity> hotels;
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getPartnerName() {
		return partnerName;
	}



	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}



	public double getCharges() {
		return charges;
	}



	public void setCharges(double charges) {
		this.charges = charges;
	}



	public Set<HotelEntity> getHotels() {
		return hotels;
	}



	public void setHotels(Set<HotelEntity> hotels) {
		this.hotels = hotels;
	}



	@Override
	public String toString() {
		return "DeliveryEntity [id=" + id + ", partnerName=" + partnerName + ", charges=" + charges + ", hotels="
				+ hotels + "]";
	}
	
	
	
}
