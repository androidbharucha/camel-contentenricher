package org.tiaa.training.camel.contentenricher.service;

import org.tiaa.training.camel.contentenricher.model.Address;
import org.tiaa.training.camel.contentenricher.model.User;

public interface AddressService {
	public Address getAddressForUser(User user) ;
	
	public Address getAddressForUserId(String userId);
}
