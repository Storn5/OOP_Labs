package ua.lpnuai.oop.mokryk07;

public class PatternMatcher {
	public static boolean checkDate(String str) {
		if (str.matches("[0-9][0-9].[0-9][0-9].[0-9][0-9][0-9][0-9]"))
			return true;
		return false;
	}
	public static boolean checkTime(String str) {
		if (str.matches("[0-9][0-9]:[0-9][0-9]"))
			return true;
		return false;
	}
	public static boolean checkLength(String str) {
		if (str.matches("[0-9]+"))
			return true;
		return false;
	}
	public static boolean checkPerson(String str) {
		if (str.matches("[A-Z][a-z]+ [A-Z][a-z]+"))
			return true;
		return false;
	}
}