package com.prismamp.api.coupons.mastercard;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MastercardApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MastercardApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	
	@Test
	void contextLoads() throws Exception {
		
		String accountNumber = "959144107";
		String cardNumber = "4546428002467302";

		this.mvc.perform(get("/mastercard").param("accountNumber", accountNumber).param("cardNumber", cardNumber))
				.andDo(print()).andExpect(status().is(200)).andExpect(content().contentType("application/json"))
				.andReturn();

		this.mvc.perform(get("/mastercard").param("accountNumber", accountNumber)).andDo(print()).andExpect(status().is(200))
				.andExpect(content().contentType("application/json")).andReturn();

		this.mvc.perform(get("/mastercard").param("cardNumber", cardNumber)).andDo(print()).andExpect(status().is(200))
				.andExpect(content().contentType("application/json")).andReturn();

		this.mvc.perform(get("/mastercard")).andDo(print()).andExpect(status().is(400))
				.andExpect(content().contentType("application/json")).andReturn();
		
		
		this.mvc.perform(get("/mastercard").param("accountNumber", accountNumber).param("orderBy", "PRESENTATION_DATE").param("typeOrder", "DESC").param("cardNumber", cardNumber))
		.andDo(print()).andExpect(status().is(200)).andExpect(content().contentType("application/json"))
		.andReturn();
		
		this.mvc.perform(get("/mastercard").param("accountNumber", accountNumber).param("orderBy", "MOVEMENT_DATE").param("typeOrder", "DESC").param("cardNumber", cardNumber))
		.andDo(print()).andExpect(status().is(200)).andExpect(content().contentType("application/json"))
		.andReturn();
		
		
	}

}
