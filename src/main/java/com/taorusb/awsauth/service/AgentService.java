package com.taorusb.awsauth.service;

import com.taorusb.awsauth.domain.Agent;
import com.taorusb.awsauth.dto.AgentDto;
import com.taorusb.awsauth.repository.AgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
@Service
public class AgentService {

	private final AgentRepository agentRepository;

	public Flux<AgentDto> findAll() {
		return agentRepository.findAll()
				.map(this::mapToDto);
	}

	public Mono<AgentDto> findById(String id) {
		return agentRepository.findById(id)
				.map(this::mapToDto);
	}

	private AgentDto mapToDto(Agent agent) {
		return new AgentDto(agent.getId());
	}
}
