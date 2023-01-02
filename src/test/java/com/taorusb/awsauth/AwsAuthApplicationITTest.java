package com.taorusb.awsauth;

import com.taorusb.awsauth.controller.AgentControllerV2;
import com.taorusb.awsauth.controller.TelemetryControllerV2;
import com.taorusb.awsauth.dto.AgentDto;
import com.taorusb.awsauth.dto.TelemetryDto;
import com.taorusb.awsauth.service.AgentService;
import com.taorusb.awsauth.service.TelemetryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebFluxTest(controllers = {AgentControllerV2.class, TelemetryControllerV2.class})
class AwsAuthApplicationITTest {

	@MockBean
	private AgentService agentService;
	@MockBean
	private TelemetryService telemetryService;
	@Autowired
	private WebTestClient webTestClient;


	@WithMockUser(value = "spring")
	@Test
	void testGetAgents() throws Exception {
		AgentDto agent = new AgentDto("PC");
		Flux<AgentDto> agents = Flux.just(agent);
		Mockito.when(agentService.findAll()).thenReturn(agents);

		webTestClient.get()
				.uri("/api/v2/agents")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(AgentDto[].class);
	}

	@WithMockUser(value = "spring")
	@Test
	void testGetSpecificAgent() throws Exception {
		AgentDto agent = new AgentDto("PC");
		Mono<AgentDto> agentMono = Mono.just(agent);
		Mockito.when(agentService.findById("PC")).thenReturn(agentMono);

		webTestClient.get()
				.uri("/api/v2/agents/PC")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(AgentDto.class);
	}

	@WithMockUser(value = "spring")
	@Test
	void testGetTelemetries() throws Exception {
		TelemetryDto telemetry = new TelemetryDto(1L, "youtube", 5);
		Flux<TelemetryDto> telemetryFlux = Flux.just(telemetry);
		Mockito.when(telemetryService.findAllByAgentId("PC")).thenReturn(telemetryFlux);

		webTestClient.get()
				.uri("/api/v2/agents/PC/telemetries")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(TelemetryDto[].class);
	}
}
