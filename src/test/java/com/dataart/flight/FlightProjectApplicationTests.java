package com.dataart.flight;

import com.dataart.flight.dao.CityDAOImpl;
import com.dataart.flight.dao.TicketDAOImpl;
import com.dataart.flight.model.City;
import com.dataart.flight.model.Ticket;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Objects;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfile s("test")
class FlightProjectApplicationTests {

	protected MockMvc mvc;

	@Autowired
	protected WebApplicationContext wac;

	@Autowired
	private CityDAOImpl cityDAOImpl;

	@Autowired
	private TicketDAOImpl ticketDAOImpl;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	protected void before() {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
		insertCities();
	}


	private void insertCities(){
		insertCity("MAD", "Madrid");
		insertCity("BCN", "Barcelona");
		insertCity("BUE", "Buenos Aires");
		insertCity("MIA", "Miami");
		insertCity("NYC", "New York City");
	}

	private void insertCity(String id, String name){
		cityDAOImpl.save(City.builder()
				.id(id)
				.name(name)
				.build());
	}


	@Test
	void testTicket01() throws Exception {
		final String request = "{\n" +
				"    \"departureDate\": \"2020-05-04\",\n" +
				"    \"arrivalDate\": \"2020-05-04\",\n" +
				"    \"origin\": {\n" +
				"        \"id\": \"BUE\"\n" +
				"    },\n" +
				"    \"destination\": {\n" +
				"        \"id\": \"MAD\"\n" +
				"    },\n" +
				"    \"name\": \"Ignacio\",\n" +
				"    \"age\": 31,\n" +
				"    \"hasLuggage\": true,\n" +
				"    \"price\": \"123.32\",\n" +
				"    \"departureTime\": \"22:33\",\n" +
				"    \"arrivalTime\": \"22:34\"\n" +
				"}";

		final ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/ticket").contentType(MediaType.APPLICATION_JSON).content(request))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
		final MvcResult mvcResult = resultActions.andReturn();
		String contentAsString = mvcResult.getResponse().getContentAsString();

		final Ticket ticket = objectMapper.readValue(contentAsString, Ticket.class);
		ticketDAOImpl.delete(ticket);

	}




	@Test
	void testTicket02() throws Exception {
		final String request = "{\n" +
				"    \"departureDate\": \"2020-05-04\",\n" +
				"    \"arrivalDate\": \"2020-05-04\",\n" +
				"    \"origin\": {\n" +
				"        \"id\": \"BUE\"\n" +
				"    },\n" +
				"    \"destination\": {\n" +
				"        \"id\": \"MAD\"\n" +
				"    },\n" +
				"    \"name\": \"Ignacio\",\n" +
				"    \"age\": 31,\n" +
				"    \"hasLuggage\": true,\n" +
				"    \"price\": \"123.32\",\n" +
				"    \"departureTime\": \"22:33\",\n" +
				"    \"arrivalTime\": \"22:32\"\n" +
				"}";

		mvc.perform(MockMvcRequestBuilders.post("/ticket").contentType(MediaType.APPLICATION_JSON).content(request))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void testTicket03() throws Exception {
		final String request = "{\n" +
				"    \"departureDate\": \"2020-05-04\",\n" +
				"    \"arrivalDate\": \"2020-05-03\",\n" +
				"    \"origin\": {\n" +
				"        \"id\": \"BUE\"\n" +
				"    },\n" +
				"    \"destination\": {\n" +
				"        \"id\": \"MAD\"\n" +
				"    },\n" +
				"    \"name\": \"Ignacio\",\n" +
				"    \"age\": 31,\n" +
				"    \"hasLuggage\": true,\n" +
				"    \"price\": \"123.32\",\n" +
				"    \"departureTime\": \"22:33\",\n" +
				"    \"arrivalTime\": \"22:34\"\n" +
				"}";

		mvc.perform(MockMvcRequestBuilders.post("/ticket").contentType(MediaType.APPLICATION_JSON).content(request))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void testTicket04() throws Exception {
		final String request = "{\n" +
				"    \"departureDate\": \"2020-05-04\",\n" +
				"    \"arrivalDate\": \"2020-05-05\",\n" +
				"    \"origin\": {\n" +
				"        \"id\": \"ASD\"\n" +
				"    },\n" +
				"    \"destination\": {\n" +
				"        \"id\": \"MAD\"\n" +
				"    },\n" +
				"    \"name\": \"Ignacio\",\n" +
				"    \"age\": 31,\n" +
				"    \"hasLuggage\": true,\n" +
				"    \"price\": \"123.32\",\n" +
				"    \"departureTime\": \"22:33\",\n" +
				"    \"arrivalTime\": \"22:34\"\n" +
				"}";

		mvc.perform(MockMvcRequestBuilders.post("/ticket").contentType(MediaType.APPLICATION_JSON).content(request))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void testTicket05() throws Exception {
		final String request = "{\n" +
				"    \"departureDate\": \"2020-05-04\",\n" +
				"    \"arrivalDate\": \"2020-05-05\",\n" +
				"    \"origin\": {\n" +
				"        \"id\": \"MIA\"\n" +
				"    },\n" +
				"    \"destination\": {\n" +
				"        \"id\": \"ASD\"\n" +
				"    },\n" +
				"    \"name\": \"Ignacio\",\n" +
				"    \"age\": 31,\n" +
				"    \"hasLuggage\": true,\n" +
				"    \"price\": \"123.32\",\n" +
				"    \"departureTime\": \"22:33\",\n" +
				"    \"arrivalTime\": \"22:34\"\n" +
				"}";

		mvc.perform(MockMvcRequestBuilders.post("/ticket").contentType(MediaType.APPLICATION_JSON).content(request))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void testTicket06() throws Exception {
		final String request = "{\n" +
				"    \"departureDate\": \"2020-05-04\",\n" +
				"    \"arrivalDate\": \"2020-05-05\",\n" +
				"    \"origin\": {\n" +
				"    },\n" +
				"    \"destination\": {\n" +
				"        \"id\": \"MIA\"\n" +
				"    },\n" +
				"    \"name\": \"Ignacio\",\n" +
				"    \"age\": 31,\n" +
				"    \"hasLuggage\": true,\n" +
				"    \"price\": \"123.32\",\n" +
				"    \"departureTime\": \"22:33\",\n" +
				"    \"arrivalTime\": \"22:34\"\n" +
				"}";

		mvc.perform(MockMvcRequestBuilders.post("/ticket").contentType(MediaType.APPLICATION_JSON).content(request))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void testTicket07() throws Exception {
		final String request = "{\n" +
				"    \"departureDate\": \"2020-05-04\",\n" +
				"    \"arrivalDate\": \"2020-05-05\",\n" +
				"    \"origin\": {\n" +
				"        \"id\": \"MIA\"\n" +
				"    },\n" +
				"    \"destination\": {\n" +
				"    },\n" +
				"    \"name\": \"Ignacio\",\n" +
				"    \"age\": 31,\n" +
				"    \"hasLuggage\": true,\n" +
				"    \"price\": \"123.32\",\n" +
				"    \"departureTime\": \"22:33\",\n" +
				"    \"arrivalTime\": \"22:34\"\n" +
				"}";

		mvc.perform(MockMvcRequestBuilders.post("/ticket").contentType(MediaType.APPLICATION_JSON).content(request))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void testGetTicket01() throws Exception {
		final String request = "{\n" +
				"    \"departureDate\": \"2020-05-04\",\n" +
				"    \"arrivalDate\": \"2020-05-04\",\n" +
				"    \"origin\": {\n" +
				"        \"id\": \"BUE\"\n" +
				"    },\n" +
				"    \"destination\": {\n" +
				"        \"id\": \"MAD\"\n" +
				"    },\n" +
				"    \"name\": \"Ignacio\",\n" +
				"    \"age\": 31,\n" +
				"    \"hasLuggage\": true,\n" +
				"    \"price\": \"123.32\",\n" +
				"    \"departureTime\": \"22:33\",\n" +
				"    \"arrivalTime\": \"22:34\"\n" +
				"}";

		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/ticket").contentType(MediaType.APPLICATION_JSON).content(request))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
		MvcResult mvcResult = resultActions.andReturn();
		String contentAsString = mvcResult.getResponse().getContentAsString();

		final Ticket ticket = objectMapper.readValue(contentAsString, Ticket.class);

		final ResultActions resultActions2 = mvc.perform(MockMvcRequestBuilders.get("/ticket/"+ticket.getItineraryID()).contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());

		mvcResult = resultActions2.andReturn();
		contentAsString = mvcResult.getResponse().getContentAsString();

		final Ticket ticket2 = objectMapper.readValue(contentAsString, Ticket.class);

		assert Objects.equals(ticket,ticket2);

		ticketDAOImpl.delete(ticket);
		ticketDAOImpl.delete(ticket2);


	}

	@Test
	void testGetTicket02() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/ticket/-1").contentType(MediaType.APPLICATION_JSON))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isNotFound());
	}



}
