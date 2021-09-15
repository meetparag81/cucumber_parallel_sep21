package DataManupulation.Constnts;

import java.util.HashMap;

public class BOTSF_EC_RE_Constants {

	public static final HashMap<String, String> sheetMap;
	static {
		sheetMap = new HashMap<String, String>();
		sheetMap.put("personInfo", "Biographical Info");
		sheetMap.put("personalInfo", "Personal Info");
		sheetMap.put("nationalIdCard", "National ID");
		sheetMap.put("homeAddress", "Home Address");
		sheetMap.put("phoneInfo", "Phone Info");
		sheetMap.put("emailInfo", "Email Info");
		sheetMap.put("imInfo", "im info");
		sheetMap.put("emergencyContactPrimary", "Emergency Contact");
		sheetMap.put("personRelationshipInfo", "Personal Relationship Info");
		sheetMap.put("employmentInfo", "Employment Info");
		sheetMap.put("userAccountInfo", "User Account Info");
		sheetMap.put("jobInfo", "Job Info");
		sheetMap.put("compInfo", "Comp Info");
		sheetMap.put("payComponentRecurring", "Recurring Pay Components");
		sheetMap.put("payComponentNonRecurring", "Non Recurring Pay Components");
		sheetMap.put("paymentInfo", "Payment Info");
		sheetMap.put("jobRelationsInfo", "Job Relationships");
		sheetMap.put("workPermitInfo", "Work Permit");
		sheetMap.put("globalAssignmentInfo", "Global Assignment Info");
		sheetMap.put("pensionPayoutsInfo", "Pension Payout");
	}
}
