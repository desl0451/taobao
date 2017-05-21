package cn.jbit.easybuy.util;

public class Validator {

	public static boolean isEmpty(String condition) {
		boolean bl = true;
		if (condition == null || condition.length() == 0) {
			bl = false;
		}
		return bl;
	}
	
}
