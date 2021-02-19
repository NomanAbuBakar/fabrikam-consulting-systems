package fabrikam.consulting.utils;

import java.util.Collection;
import java.util.Map;

public class Utilities {
	public static boolean isNullOrEmptyCollection(final Collection<?> c) {
	    return c == null || c.isEmpty();
	}
	
	public static boolean isNullOrEmptyMap(final Map<?,?> c) {
	    return c == null || c.isEmpty();
	}
	
	public static boolean isNullOrEmptyString(String s) {
	    return s == null ||s.isEmpty() || s.trim().length() < 1;
	}
	
	public static boolean validateIfNullOrInvalidInteger(Integer number) {
		if (null == number || number < 0) {
			return true;
		}
		return false;
	}
	
	public static boolean validateIfNullOrInvalidDouble(Double number) {
		if (null == number) {
			return true;
		}
		return false;
	}
}
