//MutableStatics

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Data5 {
	private static final DateFormat FORMAT = DateFormat.getDateInstance(DateFormat.MEDIUM);
	private static int flag = 0;
	
	public static Date parse(String str) throws ParseException{
		Date myDate = otherMethod(str);
		return myDate;
	}
	
	private static Date otherMethod(String myString) throws ParseException{
		return FORMAT.parse(myString);
	}
	public static void main(String[] args){
		try{
		Data5.parse("Jan 1,2014");
		}catch(ParseException e){}
	}
}
