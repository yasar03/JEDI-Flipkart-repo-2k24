/**
 * 
 */
package com.flipfit.bean;

/**
 * 
 */
public class Payment {
	public String PaymentId;
	public String CardNumber;
	public String CardPIN;
	public String CardExpiry;
	public String upiId;
	
	public String getPaymentId() {
		return PaymentId;
	}
	
	public String getCardNumber() {
		return CardNumber;
	}
	
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
	
	public void setPaymentId(String paymentId) {
		PaymentId = paymentId;
	}
	
	public String getCardPIN() {
		return CardPIN;
	}
	
	public void setCardPIN(String cardPIN) {
		CardPIN = cardPIN;
	}
	
	public String getCardExpiry() {
		return CardExpiry;
	}
	
	public void setCardExpiry(String cardExpiry) {
		CardExpiry = cardExpiry;
	}
	
	public String getUpiId() {
		return upiId;
	}
	
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
}
