package com.algo.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChecklistType {
	public String CKTYDE;

	public String getCKTYDE() {
		return CKTYDE;
	}

	public void setCKTYDE(String cKTYDE) {
		CKTYDE = cKTYDE;
	}
}
