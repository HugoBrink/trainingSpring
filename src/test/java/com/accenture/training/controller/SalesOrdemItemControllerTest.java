package com.accenture.training.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.accenture.training.dto.SalesOrderItemTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@ActiveProfiles(profiles = { "test" })
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SalesOrdemItemControllerTest {
	
	@Autowired
	private SalesOrderItemController controller;
	
	// Mock testing variables
		private static MockMvc mockMvc;
		private static ObjectMapper mapper;
		private static SalesOrderItemTO salesOrderItem;

		private static void getSalesOrderItemTest() {
			SalesOrderItemTO salesOrderItemTO = new SalesOrderItemTO();
			salesOrderItemTO.setQuantity(51);
			salesOrderItemTO.setStatus("C");
			//salesOrderItemTO.setCreatedat("2020-10-10T10:00");
			//salesOrderItemTO.setProduct(product); // Criar objeto teste product
			salesOrderItem = salesOrderItemTO;
		}
		
		@BeforeClass
		public static void setUpBeforeClass() {
			mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			getSalesOrderItemTest();
		}
		
		@Before
		public void setUpBefore() {
			mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		}
		
		@Test
		public void aa_createSalesOrderItem() throws UnsupportedEncodingException, Exception {

			final byte[] salesOrdemItemAsByteArray = mapper.writeValueAsBytes(salesOrderItem);

			final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/SalesOrderItem")
					.characterEncoding(StandardCharsets.UTF_8.name()).contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON).content(salesOrdemItemAsByteArray);

			final String result = mockMvc.perform(request).andDo(print()).andExpect(status().is(HttpStatus.OK.value()))
					.andReturn().getResponse().getContentAsString();

			assertThat(result).isNotNull();
			assertThat(result).isNotEmpty();

			final SalesOrderItemTO objResult = mapper.readValue(result, SalesOrderItemTO.class);

			assertThat(objResult.getId()).isNotEmpty();
			salesOrderItem.setId(objResult.getId());
		}
		@Test
		public void ab_changeSalesOrderItem() throws UnsupportedEncodingException, Exception {

			Integer newQuantity = 190;
			String newStatus = "O";
			salesOrderItem.setQuantity(newQuantity);
			salesOrderItem.setStatus(newStatus);
			final byte[] salesOrdemItemAsByteArray = mapper.writeValueAsBytes(salesOrderItem);

			final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/SalesOrderItem/"+salesOrderItem.getId())
					.characterEncoding(StandardCharsets.UTF_8.name()).contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON).content(salesOrdemItemAsByteArray);

			final String result = mockMvc.perform(request).andDo(print()).andExpect(status().is(HttpStatus.OK.value()))
					.andReturn().getResponse().getContentAsString();

			assertThat(result).isNotNull();
			assertThat(result).isNotEmpty();

			final SalesOrderItemTO objResult = mapper.readValue(result, SalesOrderItemTO.class);

			assertThat(objResult.getId()).isEqualTo(salesOrderItem.getId());
			assertThat(objResult.getQuantity()).isEqualTo(newQuantity);
			assertThat(objResult.getStatus()).isEqualTo(newStatus);

		}
		@Test
		public void ac_getAllSalesOrderItems() throws UnsupportedEncodingException, Exception {

			
			final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/SalesOrderItem")
					.characterEncoding(StandardCharsets.UTF_8.name()).contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON);

			final String result = mockMvc.perform(request).andDo(print()).andExpect(status().is(HttpStatus.OK.value()))
					.andReturn().getResponse().getContentAsString();

			assertThat(result).isNotNull();
			assertThat(result).isNotEmpty();

			final List<SalesOrderItemTO> objResult = Arrays.asList(mapper.readValue(result, SalesOrderItemTO[].class));
			assertThat(objResult.size()).isGreaterThan(0);

		}
		
		@Test
		public void ad_getOneSalesOrderItem() throws UnsupportedEncodingException, Exception {

			
			final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/SalesOrderItem/"+salesOrderItem.getId())
					.characterEncoding(StandardCharsets.UTF_8.name()).contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON);

			final String result = mockMvc.perform(request).andDo(print()).andExpect(status().is(HttpStatus.OK.value()))
					.andReturn().getResponse().getContentAsString();

			assertThat(result).isNotNull();
			assertThat(result).isNotEmpty();

			final SalesOrderItemTO objResult = mapper.readValue(result, SalesOrderItemTO.class);
			assertThat(objResult.getId()).isEqualTo(salesOrderItem.getId());

		}
		@Test
		public void az_deleteSalesOrderItem() throws UnsupportedEncodingException, Exception {

			final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/SalesOrderItem/"+salesOrderItem.getId())
					.characterEncoding(StandardCharsets.UTF_8.name()).contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON);

			mockMvc.perform(request).andDo(print()).andExpect(status().is(HttpStatus.OK.value())).andReturn().getResponse()
					.getContentAsString();

		}

}
