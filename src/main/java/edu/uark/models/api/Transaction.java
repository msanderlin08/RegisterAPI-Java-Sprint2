package edu.uark.models.api;

import edu.uark.models.entities.TransactionEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Transaction setId(UUID id) {
		this.id = id;
		return this;
	}

	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public Transaction setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}

	private int count;
	public int getCount() {
		return this.count;
	}
	public Transaction setCount(int count) {
		this.count = count;
		return this;
	}

	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Transaction setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	public Transaction() {
		this.count = -1;
		this.lookupCode = "";
		this.id = new UUID(0, 0);
		this.createdOn = LocalDateTime.now();
	}

	public Transaction(TransactionEntity productEntity) {
		this.id = productEntity.getId();
		this.count = productEntity.getCount();
		this.createdOn = productEntity.getCreatedOn();
		this.lookupCode = productEntity.getLookupCode();
	}
}
