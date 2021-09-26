package com.hotel.api.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="hotels")
@NoArgsConstructor
@AllArgsConstructor
public class HotelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hotel_id")
	private Integer id;
	
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private AddressEntity address;
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "hotel_id")
	private Set<MenuEntity> menuList;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "hotel_delivery", joinColumns = @JoinColumn(name="hotel_id"),inverseJoinColumns = @JoinColumn(name="delivery_id"))
	private Set<DeliveryEntity> delivery;
	
	
	
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



	public AddressEntity getAddress() {
		return address;
	}



	public void setAddress(AddressEntity address) {
		this.address = address;
	}



	public Set<MenuEntity> getMenuList() {
		return menuList;
	}



	public void setMenuList(Set<MenuEntity> menuList) {
		this.menuList = menuList;
	}



	public Set<DeliveryEntity> getDelivery() {
		return delivery;
	}



	public void setDelivery(Set<DeliveryEntity> delivery) {
		this.delivery = delivery;
	}



	@Override
	public String toString() {
		return "HotelEntity [id=" + id + ", name=" + name + ", address=" + address + ", menuList=" + menuList
				+ ", delivery=" + delivery + "]";
	}
	
	
	
}
