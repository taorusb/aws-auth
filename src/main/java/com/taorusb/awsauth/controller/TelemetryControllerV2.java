package com.taorusb.awsauth.controller;

import com.taorusb.awsauth.dto.TelemetryDto;
import com.taorusb.awsauth.service.TelemetryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
public class TelemetryControllerV2 {

	private final TelemetryService telemetryService;

	@GetMapping("/api/v2/agents/{id}/telemetries")
	public Flux<TelemetryDto> getByAgentId(@PathVariable String id) {
		return telemetryService.findAllByAgentId(id);
	}
}
