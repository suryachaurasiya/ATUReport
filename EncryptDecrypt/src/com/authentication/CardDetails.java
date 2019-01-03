package com.authentication;

public class CardDetails {

	private String cardNumber;
	private int cvv;
    private String cardHolderName;
    private String password;
    private int expiryMonth;
    private int expiryYear;
    private String cardNumber1;

	public void setCardNumber(String cardNumber) {
	    this.cardNumber = cardNumber;
	}
	public String getCardNumber() {
	    return cardNumber;
	}
	public void setCVV(int cvv) {
	    this.cvv = cvv;
	}
	public int getCvv() {
	    return cvv;
	}
	public void setCardHolderName(String cardHolderName) {
	    this.cardHolderName = cardHolderName;
	}
	public String getCardHolderName() {
	    return cardHolderName;
	}
	public void setPassword(String password) {
	    this.password = password;
	}
	public String getPassword() {
	    return password;
	}
	public void setExpiryMonth(int expiryMonth) {
	    this.expiryMonth = expiryMonth;
	}
	public int getExpiryMonth() {
	    return expiryMonth;
	}
	public void setExpiryYear(int expiryYear) {
	    this.expiryYear = expiryYear;
	}
	public int getExpiryYear() {
	    return expiryYear;
	}
	public void setCardNumber1(String cardNumber1) {
	    this.cardNumber1 = cardNumber1;
	}
	public String getCardNumber1() {
	    return cardNumber1;
	}
}
