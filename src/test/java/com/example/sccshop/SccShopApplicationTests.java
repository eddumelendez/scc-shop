package com.example.sccshop;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = "com.example:scc-warehouse:+:8080", stubsMode = StubsMode.LOCAL)
public class SccShopApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnFunkoItems() throws Exception {
		this.mockMvc.perform(
				get("/dashboard").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.products.size()", is(3)))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

}
