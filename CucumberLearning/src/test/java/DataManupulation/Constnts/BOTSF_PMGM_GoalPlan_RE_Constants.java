package DataManupulation.Constnts;

import java.util.HashMap;

public class BOTSF_PMGM_GoalPlan_RE_Constants {

	public static final HashMap<String, String> nameMap;
	static {
		nameMap = new HashMap<String, String>();
		nameMap.put("name", "Name");
		nameMap.put("metric", "Metric");
		nameMap.put("weight", "Weight");
		nameMap.put("targets", "Targets");
		nameMap.put("done", "% Complete");
		nameMap.put("start", "Start date");
		nameMap.put("due", "Due date");
		nameMap.put("state", "Status");
		nameMap.put("metriclookuptable", "Achievement Lookup Table");
		nameMap.put("bizxactual", "Actual");
		nameMap.put("bizxtarget", "Target");
		nameMap.put("bizxpos", "Probability of Success");
		nameMap.put("bizxstrategic", "Strategic Goal");
		nameMap.put("bizxeffortspent", "Effort Spent");
		nameMap.put("bizxstatuscomments", "Comments");
		nameMap.put("bizxstatusreports", "Reports");
		nameMap.put("milestones", "Milestones");
		nameMap.put("privateaccess", "Private Access");
		nameMap.put("cascadepull", "Cascade Pull");
		nameMap.put("cascadepush", "Cascade Push");
		nameMap.put("cascadealign", "Cascade Align");
		nameMap.put("create", "Create");
		nameMap.put("delete", "Delete");
		nameMap.put("unalignparent", "Unalign Parent Link");
		nameMap.put("unalignchild", "Unalign Child Link");
		nameMap.put("move", "Move Objective");
		nameMap.put("share", "Share Objective");
		nameMap.put("createrow", "Create Row");
		nameMap.put("deleterow", "Delete Row");
		nameMap.put("moverow", "Move Row");
		nameMap.put("importgoal", "Import Goal");
		nameMap.put("status", "Status");
		nameMap.put("read", "Read");
		nameMap.put("write", "Read/Write");
	}
}
