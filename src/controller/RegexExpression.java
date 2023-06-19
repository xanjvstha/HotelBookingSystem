package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExpression {
	
	public boolean Name(String fullname) {
		boolean result = false;

		String regex = "^^[A-Z][a-z]{2,10} [A-Z][a-z]{2,10}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(fullname);
		result = m.matches();

		return result;
	}	
	
	public boolean Mobile(String mobile) {
		boolean result = false;
		
		String regex = "^[9]{1}[678]{1}[0-9]{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobile);
		result = m.matches();

		return result;
	}

	public boolean Email(String st) {
		boolean result = false;
		
		String regex = "^[a-z]{1}[a-z0-9_.]{2,10}[@]{1}[a-z]{2,10}[.]{1}[com]{2,3}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	public boolean Username(String st) {
		boolean result = false;
		
		String regex = "^[a-z]{5,10}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}	
	
	public boolean Password(String st) {
		boolean result = false;
		
		String regex = "^[A-Za-z0-9@%$!#]{4,10}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
}