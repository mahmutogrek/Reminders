package com.algo.object;

import com.algo.reminders.RemindersV2Application;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Checklist {
	public String CKSUB;
	public String RIENSHNA;
	public String RIENNA;
	public String DUEDA;
	public String CKTY;
	public String CKTYDE;

	public String getCKSUB() {
		return CKSUB;
	}

	public void setCKSUB(String cKSUB) {
		CKSUB = cKSUB;
	}

	public String getRIENSHNA() {
		return RIENSHNA;
	}

	public void setRIENSHNA(String rIENSHNA) {
		RIENSHNA = rIENSHNA;
	}

	public String getDUEDA() {
		return DUEDA;
	}

	public void setDUEDA(String dUEDA) {
		DUEDA = dUEDA;
	}

	public String getCKTY() {
		return CKTY;
	}

	public void setCKTY(String cKTY) {
		CKTY = cKTY;
	}

	public String prepareEmail(String mainString) {
		String[] replaceStringArr = { "RIENSHNA", "RIENNA", "CKSUB", "CKTY", "CKTYDE", "DUEDA" };
		for (String replaceString : replaceStringArr) {
			if (mainString.contains(replaceString)) {
				switch (replaceString) {
				case "RIENSHNA":
					mainString = mainString.replace(replaceString, this.RIENSHNA);
					break;
				case "RIENNA":
					mainString = mainString.replace(replaceString, this.RIENNA);
					break;
				case "CKSUB":
					mainString = mainString.replace(replaceString, this.CKSUB);
					break;
				case "CKTY":
					mainString = mainString.replace(replaceString, this.CKTY);
					break;
				case "DUEDA":
					mainString = mainString.replace(replaceString, this.DUEDA);
					break;
				case "CKTYDE":
					mainString = mainString.replace(replaceString, this.CKTYDE);
					break;
				}
			}
		}
		RemindersV2Application.getLogger().info("Checklist Message: " +mainString);
  		return mainString;
	}
}
