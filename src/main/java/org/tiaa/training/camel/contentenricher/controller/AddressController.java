package org.tiaa.training.camel.contentenricher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tiaa.training.camel.contentenricher.model.Address;
import org.tiaa.training.camel.contentenricher.service.AddressService;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/{userid}/", method = RequestMethod.GET)
	public ResponseEntity<Address> getAddressForUserId(@PathVariable String userid) {

		return new ResponseEntity<Address>(addressService.getAddressForUserId(userid), HttpStatus.OK);
	}
}
