package com.example.sccshop.payment;

/**
 * @author Olga Maciaszek-Sharma
 */
public class PaymentResult {

	private String uuid;
	private PaymentStatus status;

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	String getUuid() {
		return uuid;
	}

	boolean successful() {
		return PaymentStatus.SUCCESS.equals(status);
	}

	enum PaymentStatus {
		SUCCESS, FAILED
	}
}