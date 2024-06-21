package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtilty {
	
	public int getRandomNumber() {
		Random r=new Random();
		int random = r.nextInt(1000);
		return random;
		
	}
	
	public String getSystemDateYYYYMMDD() {
		
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateobj);
		return date;
	}
		public String getSystemDateYYYYMMDD(int days) {
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
			
			//Calendar cal=sim.getCalendar();
			Calendar cal = Calendar.getInstance();  //
			cal.add(Calendar.DAY_OF_MONTH,days);
			String reqDate=sim.format(cal.getTime());
			return reqDate;
		}
		
	}


