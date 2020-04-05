package com.algo.object;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

import com.algo.email.EmailHtmlSender;
import com.algo.email.EmailStatus;
import com.algo.reminders.RemindersV2Application;
import com.algo.reminders.RestCalls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ConfigureReminders {
	private String object = "";
	private String objectArea = "";
	private String emailText = "";
	private String emailAddressList = "";
	private String finalEmailText = "";
	public boolean sendEmails = false;

	@Autowired
	private RestCalls rest;

	@Autowired
	private EmailHtmlSender emailHtmlSender;

	@Bean
	public int configure() {
		Reminders[] reminders = rest.getReminderList();
		for (Reminders reminder : reminders) {
			emailText = rest.callRest("EMAILTEXT", reminder.FKTAID, reminder.getBU());
			emailAddressList = rest.callRest("EMAILADDRESS", reminder.FKTAID, reminder.getBU());
			object = rest.callRest(reminder.FKTAID, String.valueOf(reminder.FKGEID));
			this.objectArea = reminder.FKTAID;
			RemindersV2Application.getLogger().debug("emailText: " + emailText);
			RemindersV2Application.getLogger().debug("emailAddress: " + emailAddressList);
			RemindersV2Application.getLogger().debug("object: " + object);
			RemindersV2Application.getLogger().debug("FKTAID: " + reminder.FKTAID);
			RemindersV2Application.getLogger().debug("BU: " + reminder.getBU());
			prepareEmail();
			if (sendEmails) {
				Context context = new Context();
				RemindersV2Application.getLogger().info("FINAL EMAIL TEXT: " + finalEmailText);
				context.setVariable("MessageBody", finalEmailText);
				if (emailAddressList.contains(";")) {
					String[] recipientList = emailAddressList.split(";");
					for (String recipient : recipientList) {
						EmailStatus emailStatus = emailHtmlSender.send(recipient, "ACM REMINDER", "emailTemplate",
								context);
					}
				} else {
					EmailStatus emailStatus = emailHtmlSender.send(emailAddressList, "ACM REMINDER", "emailTemplate",
							context);
				}
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			String checklistItemReminderList = rest.callRest("CKIM");
			RemindersV2Application.getLogger().info("checklistItemReminderList: " + checklistItemReminderList);
			
			ChecklistItem[] checklistItems = mapper.readValue(checklistItemReminderList, ChecklistItem[].class);
			objectArea = "CKIM";
			for (ChecklistItem checklistItem : checklistItems) {
				RemindersV2Application.getLogger().info("checklistItem: " + checklistItem.CKIMTY);
				RemindersV2Application.getLogger().info("RIENGEID: " + checklistItem.RIENGEID);
				String entRet = rest.callRest("REX", String.valueOf(checklistItem.RIENGEID));
				RemindersV2Application.getLogger().info("entRet: " + entRet);
				Entity entObj = mapper.readValue(entRet,Entity.class);
				checklistItem.BURIENSHNA = entObj.getBURIENSHNA();
				checklistItem.RIENNA = entObj.RIENNA;
				emailText = rest.callRest("EMAILTEXT", "CKIM", checklistItem.getBU());
				RemindersV2Application.getLogger().info("RIENNA: " + checklistItem.RIENNA);
				emailAddressList = rest.callRest("EMAILADDRESS", "CKIM", checklistItem.getBU());
				RemindersV2Application.getLogger().info("EMAIL TEXT: " +checklistItem.prepareEmail(emailText));
				if (sendEmails) {
					Context context = new Context();
					RemindersV2Application.getLogger().info("FINAL EMAIL TEXT: " + finalEmailText);
					context.setVariable("MessageBody", finalEmailText);
					if (emailAddressList.contains(";")) {
						String[] recipientList = emailAddressList.split(";");
						for (String recipient : recipientList) {
							EmailStatus emailStatus = emailHtmlSender.send(recipient, "ACM REMINDER", "emailTemplate",
									context);
						}
					} else {
						EmailStatus emailStatus = emailHtmlSender.send(emailAddressList, "ACM REMINDER",
								"emailTemplate", context);
					}
				}
			}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Bean
	private void prepareEmail() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			switch (objectArea) {
			case "CVCV":
				Covenant cov = mapper.readValue(this.object, Covenant.class);
				Entity ent = mapper.readValue(rest.callRest("REX", String.valueOf(cov.RIENGEID)), Entity.class);
				CovenantType covType = mapper.readValue(rest.callRest("COVENANT_TYPE", cov.CVTY), CovenantType.class);
				cov.CovenantType = covType.CVTYDE;
				cov.RIENNA = ent.getRIENNA();
				finalEmailText = cov.prepareEmail(emailText);
				break;
			case "REX":
				Entity entObj = mapper.readValue(this.object, Entity.class);
				RemindersV2Application.getLogger().info("RIENNA: " + entObj.RIENNA);
				finalEmailText = entObj.prepareEmail(emailText);
				break;
			case "FCPR":
				Facility facObj = mapper.readValue(this.object, Facility.class);
				FacilityType[] facTypeObj = mapper.readValue(rest.callRest("FACILITY_TYPE", facObj.QPRTYCD),
						FacilityType[].class);
				facObj.FACILITY_TYPE = facTypeObj[0].PRTYDE;
				// RemindersV2Application.getLogger().info("PRCD: " + facObj.PRCD);
				// RemindersV2Application.getLogger().info("BURIENSHNA: " +
				// facObj.getBURIENSHNA());
				// RemindersV2Application.getLogger().info("TKRIENSHNA: " +
				// facObj.getTKRIENSHNA());
				finalEmailText = facObj.prepareEmail(emailText);
				break;
			case "CKCK":
				Checklist checkObj = mapper.readValue(this.object, Checklist.class);
				ChecklistType checklistTypeObj = mapper.readValue(rest.callRest("CHECKLIST_TYPE", checkObj.CKTY),
						ChecklistType.class);
				checkObj.CKTYDE = checklistTypeObj.CKTYDE;
				RemindersV2Application.getLogger().info("CKSUB: " + checkObj.CKSUB);
				RemindersV2Application.getLogger().info("RIENSHNA: " + checkObj.RIENSHNA);
				RemindersV2Application.getLogger().info("CKTY: " + checkObj.CKTY);
				finalEmailText = checkObj.prepareEmail(emailText);
				break;
			}

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getEmailText() {
		return emailText;
	}

	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}

	public String getEmailAddress() {
		return emailAddressList;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddressList = emailAddress;
	}

}
