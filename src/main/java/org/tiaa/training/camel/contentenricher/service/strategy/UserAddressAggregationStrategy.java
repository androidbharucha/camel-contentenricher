package org.tiaa.training.camel.contentenricher.service.strategy;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.tiaa.training.camel.contentenricher.model.Address;
import org.tiaa.training.camel.contentenricher.model.User;

public class UserAddressAggregationStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange original, Exchange resource) {

		User user = (User) original.getIn().getBody();
		Address address = (Address) resource.getIn().getBody();

		user.setAddress(address);

		if (original.getPattern().isOutCapable()) {
			original.getOut().setBody(user);
		}

		return original;
	}

}
