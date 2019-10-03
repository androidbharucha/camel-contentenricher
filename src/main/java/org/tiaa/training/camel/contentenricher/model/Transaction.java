package org.tiaa.training.camel.contentenricher.model;

public class Transaction {
	
	private String transactionID;
	
	private double transcatoinAmount;
	
	

	public Transaction() {
		super();
	}

	public Transaction(String transactionID, double transcatoinAmount) {
		super();
		this.transactionID = transactionID;
		this.transcatoinAmount = transcatoinAmount;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public double getTranscatoinAmount() {
		return transcatoinAmount;
	}

	public void setTranscatoinAmount(double transcatoinAmount) {
		this.transcatoinAmount = transcatoinAmount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", transcatoinAmount=" + transcatoinAmount + "]";
	}

	
	
}
