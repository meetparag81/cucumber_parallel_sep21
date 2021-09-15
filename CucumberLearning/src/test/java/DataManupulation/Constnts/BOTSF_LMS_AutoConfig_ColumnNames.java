package DataManupulation.Constnts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOTSF_LMS_AutoConfig_ColumnNames {
	
	public  Map<String,String> getSecurityCoulmnNamesMap(){
		Map<String,String> securityTablesMap=new HashMap<String,String>();
		securityTablesMap.put("Security Domains","Domain ID(30 Char)");
		securityTablesMap.put("Security Domain Groups","Security Domain Group ID(30 Char)");
		return securityTablesMap;
	}
	
	
	public  Map<String,String> getReferenceTableCoulmnNamesMap(){
		Map<String,String> referenceTablesMap=new HashMap<String,String>();
		referenceTablesMap.put("Approval Role","Approval Role ID(30 Char)");
		referenceTablesMap.put("Assignment Type","Assignment Type ID(30 char)");
		referenceTablesMap.put("Cohort Statuses","Cohort Status ID(30 char)");
		referenceTablesMap.put("Completion Status","Completion Status ID (30 char)");
		referenceTablesMap.put("Country","Country ID(100 Char)");
		referenceTablesMap.put("Curriculum Type", "Curriculum Type ID(30 char)");
		referenceTablesMap.put("Custom Resource", "Custom Resource ID(30 Char)");
		referenceTablesMap.put("Delivery Methods", "Delivery Method ID(30 Char)");
		referenceTablesMap.put("Document Type", "Document Link Type ID(30 char)");
		referenceTablesMap.put("Employee Status", "Employee Status ID(30 Char)");
		referenceTablesMap.put("Employee Type", "Employee Type ID(30 Char)");
		referenceTablesMap.put("Equipment Type", "Equipment Type ID(30 char)");
		referenceTablesMap.put("Facility", "Facility ID(30 Char)");
		referenceTablesMap.put("Holidays", "Holiday ID(30 Char)");
		referenceTablesMap.put("Holiday Profile", "Holiday Profile ID(30 Char)");
		referenceTablesMap.put("Sources", "Source ID(30 char)");
		referenceTablesMap.put("Item Type", "Item Type ID(30 char)");
		referenceTablesMap.put("Job Location", "Job Location ID(30 Char)");
		referenceTablesMap.put("Location", "Location ID(30 Char)");
		referenceTablesMap.put("Location Type", "Location Type ID(30 Char)");
		referenceTablesMap.put("Organization Type", "Example Organization Type ID(30 Char)");
		referenceTablesMap.put("Registration Status", "Registration Status ID(30 Char)");
		referenceTablesMap.put("Categories", "Category ID(30 char)");
		referenceTablesMap.put("Materials", "Material ID(30 Char)");
		referenceTablesMap.put("Equipment Status", "Equipment Status ID(30 char)");
		referenceTablesMap.put("Equipment", "Equipment ID(30 Char)");
		referenceTablesMap.put("Work Week Profile", "Work Week Profile ID(30 Char)");
		return referenceTablesMap;
	}
	
	public  Map<String,String> getUserManagementCoulmnNamesMap(){
		Map<String,String> userManagementTablesMap=new HashMap<String,String>();
		userManagementTablesMap.put("Assignment Profiles","Assignment Profile ID ");
		
		return userManagementTablesMap;
	}
	
	
	public  Map<String,String> getLearningManagementCoulmnNamesMap(){
		Map<String,String> learningManagementTablesMap=new HashMap<String,String>();
		learningManagementTablesMap.put("Libraries","Library ID(30 Char)");
		learningManagementTablesMap.put("Approval process","Approval Process ID(30 Char)");
		learningManagementTablesMap.put("Surveys","Survey ID(30 Char)");
		learningManagementTablesMap.put("Program","Locale");
		learningManagementTablesMap.put("Rating Scale","Rating Scale ID(30 char)");
		return learningManagementTablesMap;
	}
	
	public List<String> getReferenceTemplateSheetNames(){
		List<String> sheetNamesList=new ArrayList<String>();
		sheetNamesList.add("Approval Role");
		sheetNamesList.add("Assignment Type");
		sheetNamesList.add("Cohort Statuses");
		sheetNamesList.add("Completion Status");
		sheetNamesList.add("Country");
		sheetNamesList.add("Curriculum Type");
		sheetNamesList.add("Custom Resource");
		sheetNamesList.add("Delivery Methods");
		sheetNamesList.add("Document Type");
		sheetNamesList.add("Employee Status");
		sheetNamesList.add("Employee Type");
		sheetNamesList.add("Facility");
		sheetNamesList.add("Holidays");
		sheetNamesList.add("Holiday Profile");
		sheetNamesList.add("Sources");
		sheetNamesList.add("Item Type");
		sheetNamesList.add("Job Location");
		sheetNamesList.add("Location");
		sheetNamesList.add("Location Type");
		sheetNamesList.add("Organization Type");
		sheetNamesList.add("Registration Status");
		sheetNamesList.add("Categories");
		sheetNamesList.add("Materials");
		sheetNamesList.add("Equipment Status");
		sheetNamesList.add("Equipment");
		sheetNamesList.add("Work Week Profile");
		sheetNamesList.add("Equipment Type");
		return sheetNamesList;
	}
	
	public  Map<String,String> getSystemConfigurationSettingsMap(){
		Map<String,String> systemConfigSettingsTablesMap=new HashMap<String,String>();
		systemConfigSettingsTablesMap.put("Registration Settings", "Registration Settings");
		systemConfigSettingsTablesMap.put("User Settings", "User Settings");
		systemConfigSettingsTablesMap.put("General Settings", "General Settings");
		systemConfigSettingsTablesMap.put("AICC Wrapper Settings", "AICC Wrapper Settings");
		systemConfigSettingsTablesMap.put("Approval Process Setting", "Approval Process Setting");
		systemConfigSettingsTablesMap.put("Password Settings", "Password Setting");
		systemConfigSettingsTablesMap.put("Login Lockout Settings","Login Lockout Settings");
		systemConfigSettingsTablesMap.put("Delegate Settings","Delegate Settings");
		systemConfigSettingsTablesMap.put("Mail Settings","Mail Settings");
		systemConfigSettingsTablesMap.put("Landing Page Settings","Landing Page Settings");
		systemConfigSettingsTablesMap.put("LearningPlanEmailNotification","Learning Plan Email Notification Settings");
		systemConfigSettingsTablesMap.put("User Security Question Settings","User Security Question Settings");
		return systemConfigSettingsTablesMap;
	}
	
	public  Map<String,String> getAPMSettingsMap(){
		Map<String,String> apmSettingsTablesMap=new HashMap<String,String>();
		apmSettingsTablesMap.put("LearningPlan Email Notification", "Learning Plan Notification APM");
		apmSettingsTablesMap.put("AssignmentProfileExecuteUpdate", "Assignment Profile Execute Updates APM");
		apmSettingsTablesMap.put("Course Evaluation and Follow-Up", "Course Evaluation and Follow-Up Surveys Email Notification APM");
	    apmSettingsTablesMap.put("RecommendationsNewsletter", "Recommendations Newsletter APM");
	    apmSettingsTablesMap.put("Move Users from Waitlist to Req", "Move Users from Waitlist to Request List APM");
	    apmSettingsTablesMap.put("Requested Class Availability Em", "Requested Class Availability Email Notification APM");
		apmSettingsTablesMap.put("Purge Class Requests APM","Purge Class Requests APM");
		apmSettingsTablesMap.put("Class Request Demand Met Email","Class Request Demand Met Email Notification APM");
		apmSettingsTablesMap.put("Learning Expiration Email Not","Learning Expiration Email Notification APM");
		apmSettingsTablesMap.put("Upcoming Class Reminder Email","Upcoming Class Reminder Email Notification APM");
		return apmSettingsTablesMap;
	}
	
}
