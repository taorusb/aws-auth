package com.taorusb.awsauth.repository;

import com.taorusb.awsauth.domain.Agent;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<Agent, String> {
	Optional<Agent> getAgentById(String id);
}
