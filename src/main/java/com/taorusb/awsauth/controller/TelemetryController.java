package com.taorusb.awsauth.controller;

import com.taorusb.awsauth.domain.Telemetry;
import com.taorusb.awsauth.service.TelemetryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TelemetryController {

	private final TelemetryService telemetryService;

	@GetMapping(value = "/agents/{agentId}/telemetries", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Telemetry>> getTelemetriesByAgent(@PathVariable String agentId) {
		return ResponseEntity.of(telemetryService.getAllByAgent(agentId));
	}

}
