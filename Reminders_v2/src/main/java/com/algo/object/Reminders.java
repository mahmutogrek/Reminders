package com.algo.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reminders {
	public String RIENSHNA;
	public String FKTAID;
	public int FKGEID;
	public String RMDA;
	public String RMSUB;

	public String getRIENSHNA() {
		return RIENSHNA;
	}

	public void setRIENSHNA(String rIENSHNA) {
		RIENSHNA = rIENSHNA;
	}

	public String getFKTAID() {
		// return getObjectName(this.FKTAID);
		return this.FKTAID;
	}

	public void setFKTAID(String fKTAID) {
		FKTAID = fKTAID;
	}

	public int getFKGEID() {
		return FKGEID;
	}

	public void setFKGEID(int fKGEID) {
		FKGEID = fKGEID;
	}

	public String getRMDA() {
		return RMDA;
	}

	public void setRMDA(String rMDA) {
		RMDA = rMDA;
	}

	public String getRMSUB() {
		return RMSUB;
	}

	public void setRMSUB(String rMSUB) {
		RMSUB = rMSUB;
	}


	public String getBU() {
		String vBU = this.RIENSHNA;
		if (vBU.contains("BASIC")) {
			return "BASIC";
		} else if (vBU.contains("EES")) {
			return "EES";
		} else if (vBU.contains("EXT")) {
			return "EXT";
		} else if (vBU.contains("P AND G")) {
			return "P AND G S";
		} else if (vBU.contains("SOPH")) {
			return "SOPH CEN";
		} else if (vBU.contains("INVT")) {
			return "INVT";
		} else if (vBU.contains("LDN")) {
			return "LDN";
		} else if (vBU.contains("LRD")) {
			return "LRD";
		} else if (vBU.contains("ONLINE TAKER")) {
			return "ONLINE TAKER";
		} else {
			return "HERE";
		}
	}

	@Override
	public String toString() {
		return "RIENSHNA: " +RIENSHNA + " FKTAID: " + FKTAID + " FKGEID: " + FKGEID+ " RMDA: " + RMDA+ " RMSUB: " +RMSUB;
	}

}
