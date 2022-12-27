package com.taorusb.awsauth.service;

import com.taorusb.awsauth.domain.Telemetry;
import com.taorusb.awsauth.repository.AgentRepository;
import com.taorusb.awsauth.repository.TelemetryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TelemetryService {

	private final AgentRepository agentRepository;
	private final TelemetryRepository telemetryRepository;

	public Optional<List<Telemetry>> getAllByAgent(String agentId) {
		return agentRepository.getAgentById(agentId)
				.map(telemetryRepository::getTelemetriesByAgent);
	}
}
