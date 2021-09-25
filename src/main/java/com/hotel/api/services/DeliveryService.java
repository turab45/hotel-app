package com.hotel.api.services;

import java.util.List;

import com.hotel.api.entities.DeliveryEntity;

public interface DeliveryService {
	public DeliveryEntity addDelivery(DeliveryEntity deliveryEntity);
	public DeliveryEntity updateDelivery(DeliveryEntity deliveryEntity);
	public DeliveryEntity deleteDelivery(Integer deleveryId);
	public DeliveryEntity getDeliveryById(Integer deliveryId);
	public List<DeliveryEntity> getAllDeliveries();
	public DeliveryEntity getDeliveryByPartner(String partnerName);

}
