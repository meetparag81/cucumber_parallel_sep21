package DataManupulation.Constnts;

import java.util.HashMap;

public class BOTSF_CSF_RE_Constants {

	public static final HashMap<String, String> sheetMap;
	public static final HashMap<String, String> nationalidMap;
	public static final HashMap<String, String> homeAddressMap;
	public static final HashMap<String, String> csfPersonalInfoMap;
	public static final HashMap<String, String> jobInfoMap;
	
	static {
		sheetMap = new HashMap<String, String>();
		nationalidMap = new HashMap<String, String>();
		homeAddressMap = new HashMap<String, String>();
		csfPersonalInfoMap = new HashMap<String, String>();
		jobInfoMap = new HashMap<String, String>();
		
		sheetMap.put("nationalid", "National ID");
		sheetMap.put("homeaddress", "Home Address");
		sheetMap.put("globalinfo", "CSF Personal Info");
		sheetMap.put("jobinfo", "Job Info - Country Specific");
		
		nationalidMap.put("country", "Country");
		nationalidMap.put("format-group", "Format Group ID");
		nationalidMap.put("format", "National ID Type(Format)");
		nationalidMap.put("instruction", "National ID Description");
		nationalidMap.put("display-format", "Display Format");
		nationalidMap.put("reg-ex", "Regular Expression");
		
		homeAddressMap.put("hris-element", "HRIS Element ID");
		homeAddressMap.put("country", "Country");
		homeAddressMap.put("hris-field", "System Field Id");
		homeAddressMap.put("label", "SF Label");
		homeAddressMap.put("max-length", "Max Length");
		homeAddressMap.put("visibility", "Visibile(Yes/No)?");
		
	}
	
	public static final String ENABLED="Enabled";
	

	
}
	