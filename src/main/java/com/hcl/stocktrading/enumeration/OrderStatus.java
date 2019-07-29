package com.hcl.stocktrading.enumeration;

public enum OrderStatus {

	PENDING(0), EXECUTED(1);

	private final Integer statusCode;

	OrderStatus(Integer status) {
		this.statusCode = status;
	}

	public Integer getStatus() {
		return this.statusCode;
	}

}
