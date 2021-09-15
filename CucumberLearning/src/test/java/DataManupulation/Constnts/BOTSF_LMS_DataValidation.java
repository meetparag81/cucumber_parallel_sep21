package DataManupulation.Constnts;

import java.util.*;

public class BOTSF_LMS_DataValidation {
	public static final List<String> rangeList;
	static {
		rangeList = new ArrayList<String>();
		rangeList.add("--");
	for(int i=0;i<=100;i++)
	{
		rangeList.add(Integer.toString(i));
	}	
		
	}
	
	public static final String MESSAGE="Min Value cannot be greater than or equal to Max value";
}
