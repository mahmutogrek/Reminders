package com.algo.reminders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.algo.object.EmailAddress;
import com.algo.object.EmailText;
import com.algo.object.Reminders;

//@PropertySource("file:/Users/mahmutogrek/Documents/ADIB/Reminders_v2/system.properties")
@Component
public class RestCalls {

	@Value("${URL}")
	private String vURL;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpEntity entity;

	private final static String entityEndpoint = "/resource/Counterparty;RIENGEID=";
	private final static String facilityEndpoint = "/resource/Facility;ISGEID=";
	private final static String checklistEndpoint = "/resource/Checklist;CKGEID=";
	private final static String checklistTypeEndpoint = "/resource/ChecklistType;CKTY=";
	private final static String covenantEndpoint = "/resource/Covenant;CVGEID=";
	private final static String remindersEndpoint = "/query/execution/SelectReminders";
	private final static String checklistItemEndpoint = "/query/execution/getChecklistItemsForReminders";
	private final static String emailTextEndpoint = "/query/execution/getReminderEmailText?v_ReminderGroup=";
	private final static String emailAddressEndpoint = "/query/execution/getReminderEmail?v_ReminderGroup=";
	private final static String facilityTypeEndpoint = "/query/execution/GetFacilityType?vQPRTYCD=";
	private final static String covenantTypeEndpoint = "/resource/CovenantType;CVTY=";

	public String callRest(String... vars) {
		String ret = "";
		switch (vars[0]) {
		case ("REX"):
			ret = restTemplate.exchange(vURL + entityEndpoint + vars[1] + "?_details=BusinessUnit", HttpMethod.GET,
					entity, String.class).getBody();
			break;
		case ("FCPR"):
			ret = restTemplate.exchange(vURL + facilityEndpoint + vars[1] + "?_details=Role,RiskOnRole", HttpMethod.GET,
					entity, String.class).getBody();
			break;
		case ("CKCK"):
			ret = restTemplate.exchange(vURL + checklistEndpoint + vars[1], HttpMethod.GET, entity, String.class)
					.getBody();
			break;
		case ("CVCV"):
			ret = restTemplate.exchange(vURL + covenantEndpoint + vars[1] + "?_details=QuantitativeCovenantHistory",
					HttpMethod.GET, entity, String.class).getBody();
			break;
		case ("CKIM"):
			ret = restTemplate.exchange(vURL + checklistItemEndpoint, HttpMethod.GET, entity, String.class)
					.getBody();
			RemindersV2Application.getLogger().info("CKIM OBJECT: " + ret);
			break;

		case ("EMAILTEXT"):
			EmailText[] retText = restTemplate.exchange(vURL + emailTextEndpoint + vars[1] + "&vBU_CODE=" + vars[2],
					HttpMethod.GET, entity, EmailText[].class).getBody();
			ret = retText[0].toString();
			break;
		case ("EMAILADDRESS"):
			EmailAddress[] retAddress = restTemplate
					.exchange(vURL + emailAddressEndpoint + vars[1] + "&vBU_CODE=" + vars[2], HttpMethod.GET, entity,
							EmailAddress[].class)
					.getBody();
			ret = retAddress[0].toString();
			break;
		case ("FACILITY_TYPE"):
			ret = restTemplate.exchange(vURL + facilityTypeEndpoint + vars[1], HttpMethod.GET, entity, String.class)
					.getBody();
			break;
		case ("COVENANT_TYPE"):
			ret = restTemplate.exchange(vURL + covenantTypeEndpoint + vars[1], HttpMethod.GET, entity, String.class)
					.getBody();
			break;
		case ("CHECKLIST_TYPE"):
			ret = restTemplate.exchange(vURL + checklistTypeEndpoint + vars[1], HttpMethod.GET, entity, String.class)
					.getBody();
			break;
		}
		return ret;
	}

	public Reminders[] getReminderList() {
		return restTemplate.exchange(vURL + remindersEndpoint, HttpMethod.GET, entity, Reminders[].class).getBody();
	}
}
