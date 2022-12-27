package com.taorusb.awsauth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "agents")
public class Agent {
	@Id
	@Column(name = "agent_id")
	private String id;
	@JsonIgnore
	@OneToMany(mappedBy = "agent", fetch = FetchType.LAZY)
	private List<Telemetry> telemetries;

	@Override
	public String toString() {
		return "Agent{" +
				"id='" + id + '\'' +
				", telemetries=" + telemetries +
				'}';
	}
}
