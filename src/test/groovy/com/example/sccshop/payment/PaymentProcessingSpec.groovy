package com.example.sccshop.payment

import spock.lang.Specification
import spock.lang.Subject

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.StubTrigger
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties

/**
 * @author Olga Maciaszek-Sharma
 */
@SpringBootTest
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.example:scc-payment")
class PaymentProcessingSpec extends Specification {

	@Subject
	@Autowired
	AccountingService accountingService

	@Autowired
	StubTrigger stubTrigger

	def 'should handle successful payment'() {
		when:
			stubTrigger.trigger('payment_successful')
		then:
			accountingService.successfulPayments.size() == 1
	}

	def 'should handle failed payment'() {
		when:
			stubTrigger.trigger('payment_failed')
		then:
			accountingService.failedPayments.size() == 1
	}
}
