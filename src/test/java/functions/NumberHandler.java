package functions;

public class NumberHandler {

	public static Double getDoubleFromCurrency(String currencyText) {
		return Double.valueOf(currencyText.replaceAll("[^\\.0123456789]", ""));
	}

	public static boolean checkPositiveNumberString(String number) {
		
		if (number.startsWith("+")) {
			return true;
		}
		return false;
		
	}

	public static boolean checkNegativeNumberString(String number) {
		
		if (number.startsWith("-")) {
			return true;
		}
		return false;
	}

}
