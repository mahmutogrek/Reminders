package com.algo.object;

import com.algo.reminders.RemindersV2Application;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Entity {
	public String RIENSHNA;
	public String RIENNA;
	public String RIENRVDANX;
	public String BURIENSHNA;
	
	@JsonProperty("BusinessUnit")
	public BusinessUnit[] businessUnit;
	
	public String getRIENSHNA() {
		return RIENSHNA;
	}
	public void setRIENSHNA(String rIENSHNA) {
		RIENSHNA = rIENSHNA;
	}
	public String getRIENNA() {
		return RIENNA;
	}
	public void setRIENNA(String rIENNA) {
		RIENNA = rIENNA;
	}
	public String getRIENRVDANX() {
		return RIENRVDANX;
	}
	public void setRIENRVDANX(String rIENRVDANX) {
		RIENRVDANX = rIENRVDANX;
	}
	
	public String getBURIENSHNA() {
		for(BusinessUnit bu:businessUnit) {
			if(bu.MNBUFL.equals("Y")) {
				BURIENSHNA=bu.BURIENSHNA;
			}
		}
		return BURIENSHNA;
	}
	
	public String prepareEmail(String mainString) {
		String[] replaceStringArr = {"RIENSHNA","RIENNA","NEXT_REVIEW_DATE","BUSINESS_UNIT"};
		for(String replaceString:replaceStringArr) {
            if(mainString.contains(replaceString)){
            	RemindersV2Application.getLogger().debug("RIENSHNA= " + this.RIENSHNA);
        		RemindersV2Application.getLogger().debug("RIENNA= " + this.RIENNA);
                    switch(replaceString){
                            case "RIENSHNA":
                                    mainString=mainString.replace(replaceString,this.RIENSHNA);
                                    break;
                            case "RIENNA":
                                    mainString=mainString.replace(replaceString,this.RIENNA);
                                    break;
                            case "NEXT_REVIEW_DATE":
                                    mainString=mainString.replace(replaceString,this.RIENRVDANX);
                                    break;
                            case "BUSINESS_UNIT":
                                    mainString=mainString.replace(replaceString,getBURIENSHNA());
                                    break;
                    }
            }
		}
		RemindersV2Application.getLogger().info("Entity Email: " + mainString);
        return mainString;
	}
	
	
}
