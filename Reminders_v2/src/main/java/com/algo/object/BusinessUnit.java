package com.algo.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessUnit {
	public String BURIENSHNA;
	public String MNBUFL;
	public String getBURIENSHNA() {
		return BURIENSHNA;
	}
	public void setBURIENSHNA(String bURIENSHNA) {
		BURIENSHNA = bURIENSHNA;
	}
	public String getMNBUFL() {
		return MNBUFL;
	}
	public void setMNBUFL(String mNBUFL) {
		MNBUFL = mNBUFL;
	}
}
