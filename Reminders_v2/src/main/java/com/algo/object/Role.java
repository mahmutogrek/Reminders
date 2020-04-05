package com.algo.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {
	public String RIENSHNA;
	public String PPDIRIROFL;
	
	public String getRIENSHNA() {
		return RIENSHNA;
	}
	public void setRIENSHNA(String rIENSHNA) {
		RIENSHNA = rIENSHNA;
	}
	public String getPPDIRIROFL() {
		return PPDIRIROFL;
	}
	public void setPPDIRIROFL(String pPDIRIROFL) {
		PPDIRIROFL = pPDIRIROFL;
	}
	
}
