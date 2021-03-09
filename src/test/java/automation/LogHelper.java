package automation;

import java.util.Calendar;

import com.relevantcodes.extentreports.LogStatus;

public class LogHelper {

	public void log(String text) {
		Calendar calendar = Calendar.getInstance();
		String log = calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR) + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + "> " + text;
		System.out.println(log);
		if (MainTest.extentTest != null) {
			MainTest.extentTest.log(LogStatus.INFO, log);
		}
	}

}
