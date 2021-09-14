package com.botsftool.dsg.utilities;

import java.util.ArrayList;

public class Constants {

	public static final int webdriverTimeout = 60;
    public static final String TASKLIST = "tasklist";
    public static final String KILL = "taskkill /F /IM ";
    public static final ArrayList<String> LabelHeader=new ArrayList<String>();
    public static final ArrayList<String> LabelValue=new ArrayList<String>();
    public static ArrayList<String> GeneratedFiles=new ArrayList<String>();
    public static String overallResult="";
   	public static int totaloverallPassed=0;
   	public static int totaloverallFailed=0;
}
