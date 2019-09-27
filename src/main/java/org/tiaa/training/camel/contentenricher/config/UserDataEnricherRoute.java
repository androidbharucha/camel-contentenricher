package org.tiaa.training.camel.contentenricher.config;

import static org.apache.camel.model.rest.RestParamType.path;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;
import org.tiaa.training.camel.contentenricher.model.Address;
import org.tiaa.training.camel.contentenricher.model.User;
import org.tiaa.training.camel.contentenricher.service.UserServiceImpl;
import org.tiaa.training.camel.contentenricher.service.strategy.UserAddressAggregationStrategy;
@Component
public class UserDataEnricherRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		 System.out.println(">>>>>>>>>>>>> calling user data enricher route ");
		
//		 from("timer://userdataEnricher?fixedRate=true&period=60000").bean(new UserServiceImpl(), "findUser")
//         .enrich("direct:addressenricher", new UserAddressAggregationStrategy()).marshal().json(JsonLibrary.Jackson)
//         .log("${body}");
//		 
		 
		 from("direct:addressenricherbean").bean(new UserServiceImpl(), "findUser").inputType(Integer.class)
         .enrich("direct:addressenricher", new UserAddressAggregationStrategy());
		 
		 
		 from("direct:addressenricherbean1").bean(new UserServiceImpl(), "findUser")
         .enrich("direct:addressenricher", new UserAddressAggregationStrategy()).marshal().json(JsonLibrary.Jackson , User.class)
         .log("${body}");
		 
		 
//		 from("direct:addressenricherbean")
//		 .bean(new AddressServiceImpl(), "getAddressForUser")
//		 .transform().simple("${null}").unmarshal().json(JsonLibrary.Jackson, Address.class).log("${body}");
		 
		 
		 
		 from("direct:addressenricher")
         .setHeader(Exchange.HTTP_URI, simple("http://localhost:8090/address/1/"))
         .transform().simple("${null}").to("http://ignored").unmarshal().json(JsonLibrary.Jackson, Address.class);
		 
		 
		 
		
		
	}

}
