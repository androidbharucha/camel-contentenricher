/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tiaa.training.camel.contentenricher.service;

import org.springframework.stereotype.Service;
import org.tiaa.training.camel.contentenricher.model.Address;
import org.tiaa.training.camel.contentenricher.model.User;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

 
    public Address getAddressForUser(User userId) {
    	System.out.println(" user id passed is "+userId);
    	Address address = new Address();
    	address.setAddressLine1("TIAA INDIA " );
    	address.setAddressLine2("TIAA INDIA 2 " );
        return address;
    }

	@Override
	public Address getAddressForUserId(String userId) {
		System.out.println(" user id passed is "+userId);
    	Address address = new Address();
    	address.setAddressLine1("TIAA INDIA " );
    	address.setAddressLine2("TIAA INDIA 2 " );
        return address;
	}

  
	

}
