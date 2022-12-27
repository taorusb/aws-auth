package com.taorusb.awsauth;

import com.taorusb.awsauth.domain.Agent;
import com.taorusb.awsauth.domain.Telemetry;
import com.taorusb.awsauth.repository.AgentRepository;
import com.taorusb.awsauth.repository.TelemetryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(classes = AwsAuthApplication.class)
@ContextConfiguration(initializers = AwsAuthApplicationITTest.Initializer.class)
class AwsAuthApplicationITTest {

	@Container
	public static PostgreSQLContainer postgreSQLContainer =
			new PostgreSQLContainer("postgres:12.13-alpine3.17")
			.withDatabaseName("it-test-db")
			.withUsername("user")
			.withPassword("password");

	static class Initializer
			implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			TestPropertyValues.of(
					"spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
					"spring.datasource.username=" + postgreSQLContainer.getUsername(),
					"spring.datasource.password=" + postgreSQLContainer.getPassword()
			).applyTo(configurableApplicationContext.getEnvironment());
		}
	}

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private TelemetryRepository telemetryRepository;


	@WithMockUser(value = "spring")
	@Test
	void testGetAgents() throws Exception {
		Agent agent = new Agent("PC", Collections.emptyList());
		agentRepository.save(agent);

		mockMvc.perform(get("/agents")
						.contentType("application/json"))
				.andExpect(status().isOk());
	}

	@WithMockUser(value = "spring")
	@Test
	void testGetSpecificAgent() throws Exception {
		Agent agent = new Agent("PC", Collections.emptyList());
		agentRepository.save(agent);

		mockMvc.perform(get("/agents/PC")
						.contentType("application/json"))
				.andExpect(status().isOk());
	}

	@WithMockUser(value = "spring")
	@Test
	void testGetTelemetries() throws Exception {
		Agent agent = new Agent("PC", Collections.emptyList());
		agentRepository.save(agent);
		Telemetry telemetry = new Telemetry();
		telemetry.setAgent(agent);
		telemetry.setActiveService("youtube");
		telemetry.setQualityScore(5);
		telemetryRepository.save(telemetry);

		mockMvc.perform(get("/agents/PC/telemetries")
						.contentType("application/json"))
				.andExpect(status().isOk());
	}
}
