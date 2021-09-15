package DataManupulation.Constnts;

public class BOTSF_Properties {

	public static final String CONFIG_PROPERTIES_LOC="/com/botsftool/resources/config.properties";
	public static final String ROLES_PROPERTIES_LOC="/com/botsftool/resources/roles.properties";
	public static final String DATA_VALIDATION_GLOBAL_SETUP_PROPERTIES_LOC="/com/botsftool/resources/DataValidationGlobalSetup.properties";
	
	public static final String LMSDATA_VALIDATION_GLOBAL_SETUP_PROPERTIES_LOC="/com/botsftool/resources/LMSDataValidationGlobalSetup.properties";
	
	public static final String REFERENCES_PROPERTIES_COLUMNS="Country,Code,Display Format";
	public static final String PICKLIST_PROPERTIES_COLUMNS="picklistId,en_US,status";
	
	public static final String REFERENCES_PROPERTIES_COMBI_COLUMNS="Country,Code";
	public static final String REFERENCES_PROPERTIES_Value="Display Format";
	
	public static final String Parent_CascadPickList_PROPERTIES_COLUMNS="picklistId,OptionId,en_US,status";
	public static final String Parent_CascadPickList_PROPERTIES_COMBI_COLUMNS="picklistId,en_US";
	public static final String Parent_CascadPickList_PROPERTIES_Value="OptionId";
	public static final String Parent_CascadPickList_PROPERTIES_Status="status";
	
	public static final String Validate_CascadPickList_PROPERTIES_COLUMNS="picklistId,parentOptionId,en_US,status";
	public static final String Validate_CascadPickList_PROPERTIES_COMBI_COLUMNS="picklistId,parentOptionId";
	public static final String Validate_CascadPickList_PROPERTIES_Value="en_US";
	public static final String Validate_CascadPickList_PROPERTIES_Status="status";
}
