package com.algo.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmailAddress {
	public String EMAIL;

	public List<String> getEMAILList() {
		List<String> emailList = new ArrayList<String> ();
		if (this.EMAIL != null) {
			if (!this.EMAIL.equals("[]") && !this.EMAIL.equals("")) {
				if (this.EMAIL.contains(";")) {
					emailList = Arrays.asList(this.EMAIL.split(":"));
				} else {
					emailList.add(this.EMAIL);
				}
			}
		}
		return emailList;
	}

	public String getEMAIL() {
		return this.EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	
	@Override
	public String toString() {
		return EMAIL;
	}

}
