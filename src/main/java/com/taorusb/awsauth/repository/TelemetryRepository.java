package com.taorusb.awsauth.repository;

import com.taorusb.awsauth.domain.Agent;
import com.taorusb.awsauth.domain.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {

	List<Telemetry> getTelemetriesByAgent(Agent agent);
}
