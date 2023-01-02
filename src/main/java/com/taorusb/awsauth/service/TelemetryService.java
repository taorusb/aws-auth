package com.taorusb.awsauth.service;

import com.taorusb.awsauth.domain.Telemetry;
import com.taorusb.awsauth.dto.TelemetryDto;
import com.taorusb.awsauth.repository.TelemetryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class TelemetryService {

	private final TelemetryRepository telemetryRepository;

	public Flux<TelemetryDto> findAllByAgentId(String agentId) {
		return telemetryRepository.findAllByAgentId(agentId)
				.map(this::mapToDto);
	}

	private TelemetryDto mapToDto(Telemetry telemetry) {
		return new TelemetryDto(telemetry.getId(), telemetry.getActiveService(), telemetry.getQualityScore());
	}
}
