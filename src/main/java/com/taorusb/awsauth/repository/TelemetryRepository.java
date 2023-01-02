package com.taorusb.awsauth.repository;

import com.taorusb.awsauth.domain.Telemetry;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TelemetryRepository extends ReactiveCrudRepository<Telemetry, Long> {

	Flux<Telemetry> findAllByAgentId(String agentId);
}
