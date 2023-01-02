package com.taorusb.awsauth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "agents")
public class Agent {
	@Id
	private String id;

	@Override
	public String toString() {
		return "Agent{" +
				"id='" + id + '\'' +
				'}';
	}
}
