package com.hotel.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.api.entities.DeliveryEntity;
import com.hotel.api.repositories.DeliveryRepository;
import com.hotel.api.services.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService{
	
	@Autowired
	private DeliveryRepository deliveryRepository;

	@Override
	public DeliveryEntity addDelivery(DeliveryEntity deliveryEntity) {
		
		return this.deliveryRepository.save(deliveryEntity);
	}

	@Override
	public DeliveryEntity updateDelivery(DeliveryEntity deliveryEntity) {
		// TODO Auto-generated method stub
		return this.deliveryRepository.save(deliveryEntity);
	}

	@Override
	public DeliveryEntity deleteDelivery(Integer deleveryId) {
		// TODO Auto-generated method stub
		DeliveryEntity delivery = this.deliveryRepository.findById(deleveryId).get();
		this.deliveryRepository.delete(delivery);
		return delivery;
	}

	@Override
	public DeliveryEntity getDeliveryById(Integer deliveryId) {
		// TODO Auto-generated method stub
		return this.deliveryRepository.findById(deliveryId).get();
	}

	@Override
	public List<DeliveryEntity> getAllDeliveries() {
		// TODO Auto-generated method stub
		return this.deliveryRepository.findAll();
	}

	@Override
	public DeliveryEntity getDeliveryByPartner(String partnerName) {
		// TODO Auto-generated method stub
		return this.deliveryRepository.findByPartnerName(partnerName);
	}

}
