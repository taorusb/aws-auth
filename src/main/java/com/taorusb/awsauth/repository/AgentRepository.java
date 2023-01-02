package com.taorusb.awsauth.repository;

import com.taorusb.awsauth.domain.Agent;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends ReactiveCrudRepository<Agent, String> {

}
