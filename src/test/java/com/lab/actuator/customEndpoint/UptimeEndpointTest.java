package com.lab.actuator.customEndpoint;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UptimeEndpointTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Value("${local.management.port}")
	private int mgt;
	
	private static final String CUSTOM_ACTUATOR_ENDPOINT = "/actuator/uptime";
	
	@Test
	public void shouldReturn200WhenSendingRequestToManagementEndpoint() {
		
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.mgt + CUSTOM_ACTUATOR_ENDPOINT, Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
