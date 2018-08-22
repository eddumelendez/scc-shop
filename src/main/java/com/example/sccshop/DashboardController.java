package com.example.sccshop;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Eddú Meléndez
 */
@RestController
public class DashboardController {

	private final RestTemplate restTemplate;

	private String warehouseUrl;

	public DashboardController(RestTemplate restTemplate, @Value("${warehouse.url}") String warehouseUrl) {
		this.restTemplate = restTemplate;
		this.warehouseUrl = warehouseUrl;
	}

	@GetMapping("/dashboard")
	public ResponseEntity dashboard() {
		RequestEntity<Void> requestEntity = RequestEntity.get(URI.create(this.warehouseUrl + "/products")).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE).build();
		ResponseEntity<ProductListResponse> response = this.restTemplate.exchange(requestEntity, ProductListResponse.class);
		if (CollectionUtils.isEmpty(response.getBody().getProducts())) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(response.getBody());
	}
}
