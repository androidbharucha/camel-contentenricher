package org.tiaa.training.camel.contentenricher.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tiaa.training.camel.contentenricher.model.Transaction;
import org.tiaa.training.camel.contentenricher.model.User;

@RestController
@RequestMapping(path = "/transaction", consumes = "application/json", produces = "application/json")
public class TransactionController {

	@RequestMapping(value = "/usertrans/", method = RequestMethod.POST)
	public ResponseEntity<User> getTransactionsForUser(@RequestBody User user) {

		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(new Transaction("AUDSD123b81", 120.87));
		transactions.add(new Transaction("CTDSD183b66", 870.01));

		user.setTransactions(transactions);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
