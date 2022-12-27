package com.taorusb.awsauth.controller;

import com.taorusb.awsauth.domain.Agent;
import com.taorusb.awsauth.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AgentController {

	private final AgentService agentService;

	@GetMapping(value = "/agents", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Agent>> getAgents() {
		return ResponseEntity.of(agentService.getAgents());
	}

	@GetMapping(value = "/agents/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Agent> getAgentById(@PathVariable String id) {
		return ResponseEntity.of(agentService.getAgentById(id));
	}
}
