package com.algo.object;

import com.algo.reminders.RemindersV2Application;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Covenant {
	
	public String RIENNA;
	public String RIENSHNA;
	public String CVSUB;
	public String BURIENSHNA;
	public String BURIENALTYNA;
	public String BURIENALID;
	public String TKRIENSHNA;
	public String TKRIENALTYNA;
	public String TKRIENALID;
	public String CVTY;
	public String CVTYGR;
	public String CVDE;	
	public String CVFY;
	public int DUEDY;
	public String EXPDA;
	public String RMDY;
	public String DCFL;
	public String RPDA;
	public String COIN;
	public String NNCORSCM;
	public String MFTS;
	public String MFURID;
	public int TESTVA;
	public String TESTVACUCD;
	public String MNMAFL;
	public String URID;
	public String URRO;
	public String CovenantType;
	public int RIENGEID;

	public String getRIENSHNA() {
		return RIENSHNA;
	}
	public void setRIENSHNA(String rIENSHNA) {
		RIENSHNA = rIENSHNA;
	}
	
	public String getCVSUB() {
		return CVSUB;
	}
	public void setCVSUB(String cVSUB) {
		CVSUB = cVSUB;
	}
	public String getBURIENSHNA() {
		return BURIENSHNA;
	}
	public void setBURIENSHNA(String bURIENSHNA) {
		BURIENSHNA = bURIENSHNA;
	}
	public String getBURIENALTYNA() {
		return BURIENALTYNA;
	}
	public void setBURIENALTYNA(String bURIENALTYNA) {
		BURIENALTYNA = bURIENALTYNA;
	}
	public String getBURIENALID() {
		return BURIENALID;
	}
	public void setBURIENALID(String bURIENALID) {
		BURIENALID = bURIENALID;
	}
	public String getTKRIENSHNA() {
		return TKRIENSHNA;
	}
	public void setTKRIENSHNA(String tKRIENSHNA) {
		TKRIENSHNA = tKRIENSHNA;
	}
	public String getTKRIENALTYNA() {
		return TKRIENALTYNA;
	}
	public void setTKRIENALTYNA(String tKRIENALTYNA) {
		TKRIENALTYNA = tKRIENALTYNA;
	}
	public String getTKRIENALID() {
		return TKRIENALID;
	}
	public void setTKRIENALID(String tKRIENALID) {
		TKRIENALID = tKRIENALID;
	}
	public String getCVTY() {
		return CVTY;
	}
	public void setCVTY(String cVTY) {
		CVTY = cVTY;
	}
	public String getCVTYGR() {
		return CVTYGR;
	}
	public void setCVTYGR(String cVTYGR) {
		CVTYGR = cVTYGR;
	}
	public String getCVDE() {
		return CVDE;
	}
	public void setCVDE(String cVDE) {
		CVDE = cVDE;
	}
	public String getCVFY() {
		return CVFY;
	}
	public void setCVFY(String cVFY) {
		CVFY = cVFY;
	}
	public int getDUEDY() {
		return DUEDY;
	}
	public void setDUEDY(int dUEDY) {
		DUEDY = dUEDY;
	}
	public String getEXPDA() {
		return EXPDA;
	}
	public void setEXPDA(String eXPDA) {
		EXPDA = eXPDA;
	}
	public String getRMDY() {
		return RMDY;
	}
	public void setRMDY(String rMDY) {
		RMDY = rMDY;
	}
	public String getDCFL() {
		return DCFL;
	}
	public void setDCFL(String dCFL) {
		DCFL = dCFL;
	}
	public String getRPDA() {
		return RPDA;
	}
	public void setRPDA(String rPDA) {
		RPDA = rPDA;
	}
	public String getCOIN() {
		return COIN;
	}
	public void setCOIN(String cOIN) {
		COIN = cOIN;
	}
	public String getNNCORSCM() {
		return NNCORSCM;
	}
	public void setNNCORSCM(String nNCORSCM) {
		NNCORSCM = nNCORSCM;
	}
	public String getMFTS() {
		return MFTS;
	}
	public void setMFTS(String mFTS) {
		MFTS = mFTS;
	}
	public String getMFURID() {
		return MFURID;
	}
	public void setMFURID(String mFURID) {
		MFURID = mFURID;
	}
	public int getTESTVA() {
		return TESTVA;
	}
	public void setTESTVA(int tESTVA) {
		TESTVA = tESTVA;
	}
	public String getTESTVACUCD() {
		return TESTVACUCD;
	}
	public void setTESTVACUCD(String tESTVACUCD) {
		TESTVACUCD = tESTVACUCD;
	}
	public String getMNMAFL() {
		return MNMAFL;
	}
	public void setMNMAFL(String mNMAFL) {
		MNMAFL = mNMAFL;
	}
	public String getURID() {
		return URID;
	}
	public void setURID(String uRID) {
		URID = uRID;
	}
	public String getURRO() {
		return URRO;
	}
	public void setURRO(String uRRO) {
		URRO = uRRO;
	}
	

	
	
	
	public String prepareEmail(String mainString) {
        String[] replaceStringArr = {"RIENSHNA","RIENNA","CVSUB","CVTY","CVDE","TESTVA","TESTVACUCD","EXPDA","ACTVA","ACTVACUCD","COIN"};
               for(String replaceString:replaceStringArr){
                       if(mainString.contains(replaceString)){
                               switch(replaceString){
                                       case "RIENSHNA":
                                               mainString=mainString.replace(replaceString,RIENSHNA);
                                               break;
                                       case "RIENNA":
                                               mainString=mainString.replace(replaceString,RIENNA);
                                               break;
                                       case "CVDE":
                                               mainString=mainString.replace(replaceString,CVDE);
                                               break;
                                       case "CVSUB":
                                               mainString=mainString.replace(replaceString,CVSUB);
                                               break;
                                       case "TESTVA":
                                               mainString=mainString.replace(replaceString,TESTVA + " " +TESTVACUCD);
                                               break;
                                               /*
                                       case "ACTVA":
                                               if(covenantObj.QuantitativeCovenantHistory!=null){
                                               mainString=mainString.replace(replaceString,covenantObj.QuantitativeCovenantHistory.ACTVA.toString()+" " + replaceString,covenantObj.QuantitativeCovenantHistory.ACTVACUCD.toString())
                                               }
                                               break;
                                               */
                                       case "EXPDA":
                                               mainString=mainString.replace(replaceString,EXPDA);
                                               break;
                                       case "COIN":
                                               mainString=mainString.replace(replaceString,COIN);
                                               break;
                                       case "CVTY":
                                               mainString=mainString.replace(replaceString, CVTY + "("+CovenantType+")");
                                               break;
                                               
                               }        
                       
                       }
               }
               RemindersV2Application.getLogger().info("COVENANT EMAIL: " + mainString);
               return mainString;

	}
	
}
