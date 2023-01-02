package com.taorusb.awsauth.controller;

import com.taorusb.awsauth.dto.AgentDto;
import com.taorusb.awsauth.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class AgentControllerV2 {

	private final AgentService agentService;

	@GetMapping("/api/v2/agents/{id}")
	public Mono<ResponseEntity<AgentDto>> getById(@PathVariable String id) {
		return agentService.findById(id)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@GetMapping("/api/v2/agents")
	public Flux<AgentDto> getAll() {
		return agentService.findAll();
	}
}
