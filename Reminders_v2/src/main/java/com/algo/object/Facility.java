package com.algo.object;

import com.algo.reminders.RemindersV2Application;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Facility {

	public String PRCD;
	public String TKRIENSHNA;
	public String BURIENSHNA;
	public String QPRTYCD;
	public String TKRIENNA;
	public String EDDA;
	public String BAAPID;
	public String FACILITY_TYPE;

	@JsonProperty("Role")
	public Role[] roleList;


	public String getBAAPID() {
		return BAAPID;
	}

	public void setBAAPID(String bAAPID) {
		BAAPID = bAAPID;
	}

	public String getPRCD() {
		return PRCD;
	}

	public void setPRCD(String pRCD) {
		PRCD = pRCD;
	}

	public String getTKRIENSHNA() {
		for (Role role : roleList) {
			if (role.PPDIRIROFL.equals("Y")) {
				TKRIENSHNA = role.RIENSHNA;
			}
		}

		return TKRIENSHNA;
	}

	public void setTKRIENSHNA(String tKRIENSHNA) {
		TKRIENSHNA = tKRIENSHNA;
	}

	public void setBURIENSHNA(String bURIENSHNA) {
		BURIENSHNA = bURIENSHNA;
	}

	public String getQPRTYCD() {
		return QPRTYCD;
	}

	public void setQPRTYCD(String qPRTYCD) {
		QPRTYCD = qPRTYCD;
	}

	public String getTKRIENNA() {
		return TKRIENNA;
	}

	public void setTKRIENNA(String tKRIENNA) {
		TKRIENNA = tKRIENNA;
	}

	public String getEDDA() {
		return EDDA;
	}

	public void setEDDA(String eDDA) {
		EDDA = eDDA;
	}

	public String getBURIENSHNA() {
		for (Role role : roleList) {
			if (role.PPDIRIROFL.equals("T")) {
				BURIENSHNA = role.RIENSHNA;
			}
		}
		return BURIENSHNA;
	}

	public String prepareEmail(String mainString) {
		String[] replaceStringArr = { "PRCD", "TKRIENSHNA", "BURIENSHNA", "FACILITY_TYPE", "TKRIENNA", "END_DATE" };
		for (String replaceString : replaceStringArr) {
			if (mainString.contains(replaceString)) {
				switch (replaceString) {
				case "PRCD":
					mainString = mainString.replace(replaceString, this.BAAPID + " " + this.PRCD);
					break;
				case "TKRIENSHNA":
					mainString = mainString.replace(replaceString, getTKRIENSHNA());
					break;
				case "BURIENSHNA":
					mainString = mainString.replace(replaceString, getBURIENSHNA());
					break;
				case "FACILITY_TYPE":
					mainString = mainString.replace(replaceString, this.FACILITY_TYPE);
					break;
				case "TKRIENNA":
					mainString = mainString.replace(replaceString, "TKRIENNA");
					break;
				case "END_DATE":
					mainString = mainString.replace(replaceString, this.EDDA);
					break;
				}
			}

		}
		RemindersV2Application.getLogger().info("FACILITY EMAIL: " + mainString);
		return mainString;
	}
}
