package DataManupulation.Constnts;

public class BOTSF_PropertiesForRCM {

	public static final String CONFIG_PROPERTIES_LOC="/com/botsftool/resources/config.properties";
	public static final String ROLES_PROPERTIES_LOC="/com/botsftool/resources/roles.properties";
	public static final String DATA_VALIDATION_GLOBAL_SETUP_PROPERTIES_LOC="/com/botsftool/resources/DataValidationGlobalSetup.properties";
	
	public static final String REFERENCES_PROPERTIES_COLUMNS="Country,Code,Display Format";
	public static final String PICKLIST_PROPERTIES_COLUMNS="id,values.label.en_US,values.status";
	
	public static final String REFERENCES_PROPERTIES_COMBI_COLUMNS="Country,Code";
	public static final String REFERENCES_PROPERTIES_Value="Display Format";
	
	public static final String Parent_CascadPickList_PROPERTIES_COLUMNS="id,values.externalCode,values.label.en_US,values.status";
	public static final String Parent_CascadPickList_PROPERTIES_COMBI_COLUMNS="id,values.label.en_US";
	public static final String Parent_CascadPickList_PROPERTIES_Value="values.externalCode";
	public static final String Parent_CascadPickList_PROPERTIES_Status="values.status";
	
	public static final String Validate_CascadPickList_PROPERTIES_COLUMNS="id,values.parentPickListValue.externalCode,values.label.en_US,values.status";
	public static final String Validate_CascadPickList_PROPERTIES_COMBI_COLUMNS="id,values.parentPickListValue.externalCode";
	public static final String Validate_CascadPickList_PROPERTIES_Value="values.label.en_US";
	public static final String Validate_CascadPickList_PROPERTIES_Status="values.status";
	
	public static final String PicklistColumns="id,values.externalCode,values.parentPickListValue.externalCode,values.label.en_US,values.status";
}
