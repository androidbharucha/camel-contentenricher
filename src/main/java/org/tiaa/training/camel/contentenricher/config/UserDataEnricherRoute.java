package org.tiaa.training.camel.contentenricher.config;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;
import org.tiaa.training.camel.contentenricher.model.Address;
import org.tiaa.training.camel.contentenricher.model.User;
import org.tiaa.training.camel.contentenricher.service.UserServiceImpl;
import org.tiaa.training.camel.contentenricher.service.strategy.UserAddressAggregationStrategy;
import org.tiaa.training.camel.contentenricher.service.strategy.UserTranscationAggregationStrategy;


@Component
public class UserDataEnricherRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		 
		 from("direct:userEnrichment").bean(new UserServiceImpl(), "findUser").inputType(Integer.class)
         .enrich("direct:addressenricher", new UserAddressAggregationStrategy())
         .enrich("direct:transactionenricher" , new UserTranscationAggregationStrategy());
		 
		 
		 
//		 from("direct:addressenricherbean")
//		 .bean(new AddressServiceImpl(), "getAddressForUser")
//		 .transform().simple("${null}").unmarshal().json(JsonLibrary.Jackson, Address.class).log("${body}");
		 
		 
		 
		 from("direct:addressenricher")
         .setHeader(Exchange.HTTP_URI, simple("http://localhost:8090/address/1/")) // TODO : replace hardcoded parameter with user id 
         .transform().simple("${null}").to("http://ignored").unmarshal().json(JsonLibrary.Jackson, Address.class);
		 
		 from("direct:transactionenricher")
		 .marshal().json(JsonLibrary.Jackson)
         .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))  /// TODO : how to pass parameter other than User clas before calling this route 
         .enrich("http://localhost:8090/transaction/usertrans/").unmarshal().json(JsonLibrary.Jackson, User.class);
		 
		
	}

}
