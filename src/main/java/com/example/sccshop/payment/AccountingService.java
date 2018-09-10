package com.example.sccshop.payment;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

/**
 * @author Olga Maciaszek-Sharma
 */
@Service
public class AccountingService {

	private static final Logger LOG = LoggerFactory.getLogger(AccountingService.class);

	private final Set<String> successfulPayments = new HashSet<>();
	private final Set<String> failedPayments = new HashSet<>();

	void processSuccessfulPayment(String paymentUuid) {
		LOG.info("Successful payment registered with uuid {}", paymentUuid);
		// Business logic goes here
		successfulPayments.add(paymentUuid);
	}

	void processFailedPayment(String paymentUuid) {
		LOG.info("Unsuccessful payment registered with uuid: {}", paymentUuid);
		// Business logic goes here
		failedPayments.add(paymentUuid);
	}

	public Set<String> getSuccessfulPayments() {
		return successfulPayments;
	}

	public Set<String> getFailedPayments() {
		return failedPayments;
	}
}
