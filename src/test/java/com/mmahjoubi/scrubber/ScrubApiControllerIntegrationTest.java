package com.mmahjoubi.scrubber;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ScrubApiControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldReturnTheSameJson() throws Exception {
		ResponseEntity<InputForm> response = this.restTemplate.postForEntity(
				"http://localhost:" + this.port + "/api/scrub",
				new InputForm("test"),
				InputForm.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(response.getBody().getTextField(), equalTo("test"));
	}

}
