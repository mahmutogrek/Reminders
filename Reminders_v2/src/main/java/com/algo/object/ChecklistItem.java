package com.algo.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChecklistItem {
	public String CKIMTY;
	public String DUEDA;
	public String CKSUB;
	public String RIENSHNA;
	public String RIENNA;
	public int RIENGEID;
	public String BURIENSHNA;
	public String CKIMCM;

	public int getRIENGEID() {
		return RIENGEID;
	}

	public void setRIENGEID(int rIENGEID) {
		RIENGEID = rIENGEID;
	}

	public String getCKIMTY() {
		return CKIMTY;
	}

	public void setCKIMTY(String cKIMTY) {
		CKIMTY = cKIMTY;
	}

	public String getDUEDA() {
		return DUEDA;
	}

	public void setDUEDA(String dUEDA) {
		DUEDA = dUEDA;
	}

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

	public String getBU() {
		String vBU = this.BURIENSHNA;
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

	
	
	
	public String prepareEmail(String mainString) {
               String[] replaceStringArr = {"CKSUB","CKIMTY","RIENSHNA","RIENNA","CONDITIOM","DOC_GROUP","DOC_TYPE"};
               for(String replaceString :replaceStringArr){
                               if(mainString.contains(replaceString)){
                                       switch(replaceString){
                                               case "RIENSHNA":
                                                       mainString=mainString.replace(replaceString,this.RIENSHNA);
                                                       break;
                                               case "RIENNA":
                                                       mainString=mainString.replace(replaceString,this.RIENNA);
                                                       break;
                                               case "CKIMTY":
                                                       mainString=mainString.replace(replaceString,this.CKIMTY);
                                                       break;
                                               case "CKSUB":
                                                       mainString=mainString.replace(replaceString,this.CKSUB);
                                                       break;
                                               case "CONDITION":
                                                       mainString=mainString.replace(replaceString,this.CKIMCM);
                                                       break;
                                       }
                               }
               }
       return mainString;
       }

	
	
}
