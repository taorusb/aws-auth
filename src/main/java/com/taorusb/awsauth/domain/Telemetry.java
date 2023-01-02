package com.taorusb.awsauth.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "telemetries")
public class Telemetry {
	@Id
	private Long id;

	private Agent agent;
	@Column("active_service")
	private String activeService;
	@Column("quality_score")
	private Integer qualityScore;

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"id = " + id + ", " +
				"activeService = " + activeService + ", " +
				"qualityScore = " + qualityScore + ")";
	}
}
