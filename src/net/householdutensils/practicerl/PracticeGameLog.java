package net.householdutensils.practicerl;

import java.util.ArrayList;
import java.util.List;

public class PracticeGameLog {

	List<String> logList = new ArrayList<String>();
	
	public PracticeGameLog(PracticeRougeLike practiceRougeLike) {
		
		logList.add("Welcome to PracticeRL :)");
	
		
	}
	
	public void addLogLine(String message) {
		
		logList.add(message);
		
	}
	
	public List<String> getLogList() {
		
		return logList;
		
	}
	
}
