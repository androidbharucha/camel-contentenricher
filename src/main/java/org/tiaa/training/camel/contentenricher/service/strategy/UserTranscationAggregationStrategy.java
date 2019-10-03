package org.tiaa.training.camel.contentenricher.service.strategy;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.tiaa.training.camel.contentenricher.model.Address;
import org.tiaa.training.camel.contentenricher.model.Transaction;
import org.tiaa.training.camel.contentenricher.model.User;

public class UserTranscationAggregationStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange original, Exchange resource) {
		
		
		
		    User user = (User) original.getIn().getBody();
		    User userwithTransation = (User) resource.getIn().getBody();
	        
		    
//	        info.setCustomerName(recd.getCustomerName());
//	        info.setOrderTotal(recd.getOrderTotal());
	        if (original.getPattern().isOutCapable()) {
	            original.getOut().setBody(userwithTransation);
	        }
	        
	        System.out.println("original completed "+original);
	        return original;
	}

}
