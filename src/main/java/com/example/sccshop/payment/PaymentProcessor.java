package com.example.sccshop.payment;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * @author Olga Maciaszek-Sharma
 */
@Service
public class PaymentProcessor {

	private final AccountingService accountingService;

	public PaymentProcessor(AccountingService accountingService) {
		this.accountingService = accountingService;
	}

	@StreamListener(Sink.INPUT)
	public void processPaymentResult(PaymentResult paymentResult) {
		if (paymentResult.successful()) {
			accountingService.processSuccessfulPayment(paymentResult.getUuid());
		} else {
			accountingService.processFailedPayment(paymentResult.getUuid());
		}
	}
}
