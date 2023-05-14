package dbutil;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	public static Date convertToDate(String sdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sqlDate = null;
		try {
			java.util.Date d = sdf.parse(sdate);
			sqlDate = new Date(d.getTime());
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}
}
