package com.tutorialsninja_utilities;

import java.util.Date;

public class Utilities {
	
	public static String generateEmailWithDateTimeStamp() {
		
		Date date=new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "Akter1122344" + timeStamp + "@gmail.com";
	}
	
	public static final int IMPLICIT_WAIT = 20;
	public static final int PAGE_LOAD_TIME = 100;
	public static final int SCRIPT_TIME = 1000;
	

}
