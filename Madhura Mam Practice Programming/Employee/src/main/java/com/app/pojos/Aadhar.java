package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class Aadhar {
	@Column(name="card_number",length=20)
	private String cardNumber;
	@Column(length=20)
	private String location;
	@Column(name="issue_date")
	private LocalDate issueDate;
	public Aadhar(String cardNumber, String location, LocalDate issueDate) {
		super();
		this.cardNumber = cardNumber;
		this.location = location;
		this.issueDate = issueDate;
	}
	public Aadhar() {
		super();
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	@Override
	public String toString() {
		return "Aadhar [cardNumber=" + cardNumber + ", location=" + location + ", issueDate=" + issueDate + "]";
	}
	
	
}
