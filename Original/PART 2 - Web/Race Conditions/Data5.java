import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Data5 {
	private static final DateFormat FORMAT = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	public static Date parse(String str) throws ParseException{
			return FORMAT.parse(str);
	}
	
	public static void main(String[] args){
		try{
		Data5.parse("Jan 1,2014");
		}catch(ParseException e){}
	}
}
