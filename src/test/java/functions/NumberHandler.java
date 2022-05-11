package functions;

public class NumberHandler {

	public static Float getFloatFromCurrency(String currencyText) {
		return Float.valueOf(currencyText.replaceAll("[^\\.0123456789]", ""));
	}

	public static boolean checkPositiveNumberString(String number) {
		
		if (number.startsWith("+")) {
			return true;
		}
		return false;
	}

}
