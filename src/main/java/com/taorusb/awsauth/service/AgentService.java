package com.taorusb.awsauth.service;

import com.taorusb.awsauth.domain.Agent;
import com.taorusb.awsauth.repository.AgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AgentService {

	private final AgentRepository agentRepository;

	public Optional<Agent> getAgentById(String id) {
		return agentRepository.getAgentById(id);
	}

	public Optional<List<Agent>> getAgents() {
		return Optional.of(agentRepository.findAll());
	}
}
