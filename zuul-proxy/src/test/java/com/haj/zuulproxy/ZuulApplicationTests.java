package com.haj.zuulproxy;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ZuulApplicationTests {

	@LocalServerPort
	int randomServerPort;

	@Test
	public void whenSendRequestDirectlyToFooResource_thenOk() {
		Response response = RestAssured.get("http://localhost:8081/foos/1");
		assertEquals(200, response.getStatusCode());
	}

	@Test
	public void whenSendRequestDirectlyToBarResource_thenOk() {
		Response response = RestAssured.get("http://localhost:8082/bars/1");
		assertEquals(200, response.getStatusCode());
	}

	@Test
	public void whenSendRequestThroughProxyToFooResource_thenOk() {
		RestAssured.get("http://localhost:" + randomServerPort + "/foos/1")
		.then()
		.statusCode(equalTo(200))
		.body("id", equalTo(1))
		.body("name", equalTo("Created by findById"));
	}

	@Test
	public void whenSendRequestThroughProxyToBarResource_thenOk() {
		RestAssured.get("http://localhost:" + randomServerPort + "/bars/1")
		.then()
		.statusCode(equalTo(200))
		.body("barId", equalTo(1))
		.body("powerValue", equalTo(2));
	}

}
