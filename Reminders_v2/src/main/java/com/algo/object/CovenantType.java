package com.algo.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CovenantType {
	public String CVTYDE;

	public String getCVTYDE() {
		return CVTYDE;
	}

	public void setCVTYDE(String cVTYDE) {
		CVTYDE = cVTYDE;
	}
	
}
