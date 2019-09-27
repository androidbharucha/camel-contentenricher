package org.tiaa.training.camel.contentenricher.controller;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tiaa.training.camel.contentenricher.model.User;

@RestController
@RequestMapping(path = "/user")
public class UserController  {
	
	@Autowired
	private CamelContext camelContext;
	
	
	@RequestMapping(value = "/{userid}/", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String userid) {
		
		System.out.println(camelContext.getRoutes());
		
		User userinfo = camelContext.createProducerTemplate().requestBody("direct:addressenricherbean",userid,User.class);
		
		
		System.out.println(userinfo);
		return new ResponseEntity<User>(userinfo,HttpStatus.OK);
	}

	
}
