package com.maxxton.daterange;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainClass {

	public static void main(String[] args) throws ParseException {
		
		 SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		 dateFormat.setLenient(false);
		 
		 DateRange daterange1=new DateRange();
		 daterange1.setStartDate(dateFormat.parse("01/01/2020"));
		 daterange1.setEndDate(dateFormat.parse("30/01/2020"));
		 
		 DateRange daterange2=new DateRange();
		 daterange2.setStartDate(dateFormat.parse("15/01/2020"));
		 daterange2.setEndDate(dateFormat.parse("20/03/2020"));
		 
		 DateRange daterange3=new DateRange();
		 daterange3.setStartDate(dateFormat.parse("10/03/2020"));
		 daterange3.setEndDate(dateFormat.parse("15/04/2020"));
		 
		 DateRange daterange4=new DateRange();
		 daterange4.setStartDate(dateFormat.parse("10/04/2020"));
		 daterange4.setEndDate(dateFormat.parse("15/05/2020"));
		 
		 //date ranges should not be merged
		 DateRange daterange21=new DateRange();
		 daterange21.setStartDate(dateFormat.parse("01/01/2020"));
		 daterange21.setEndDate(dateFormat.parse("30/01/2020"));
		 
		 DateRange daterange22=new DateRange();
		 daterange22.setStartDate(dateFormat.parse("02/01/2020"));
		 daterange22.setEndDate(dateFormat.parse("20/03/2020"));
		 
		 //date ranges should be merged
		 DateRange daterange31=new DateRange();
		 daterange31.setStartDate(dateFormat.parse("10/03/2020"));
		 daterange31.setEndDate(dateFormat.parse("15/04/2020"));
		 
		 DateRange daterange32=new DateRange();
		 daterange32.setStartDate(dateFormat.parse("15/04/2020"));
		 daterange32.setEndDate(dateFormat.parse("15/05/2020"));

		 List<DateRange> dateRanges=new ArrayList<DateRange>();
		 dateRanges.add(daterange1);
		 dateRanges.add(daterange2);
		 dateRanges.add(daterange3);
		 dateRanges.add(daterange4);
		 dateRanges.add(daterange21);
		 dateRanges.add(daterange22);
		 dateRanges.add(daterange31);
		 dateRanges.add(daterange32);
		 
		 SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
		 DateMarger dateMarger=new DateMarger();
		 
		 System.out.println("\tMarged Dates");
		 for(DateRange range:dateMarger.mergeDates(dateRanges)){
			 System.out.println(formatter.format(range.getStartDate())+" - "+formatter.format(range.getEndDate()));
		 }
	}

}
