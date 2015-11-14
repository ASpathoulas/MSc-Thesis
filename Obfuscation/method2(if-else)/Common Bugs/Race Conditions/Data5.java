//MutableStatics


import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Data5 {
	private static final DateFormat FORMAT = DateFormat.getDateInstance(DateFormat.MEDIUM);
	private static int flag = 0;
	
	public static Date parse(String str) throws ParseException{
		if(flag==0){
			return FORMAT.parse(str);
		}
		else{
			return FORMAT.parse(str);
		}
	}
	
//	private static Date kati(DateFormat ferma,String kati) throws ParseException{
//		return ferma.parse(kati);
//	}
	public static void main(String[] args){
		try{
		Data5.parse("Jan 1,2014");
		}catch(ParseException e){}
	}
}
