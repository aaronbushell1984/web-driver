package functions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableHandler {

	public static List<WebElement> getTRs(WebElement tableBody) {
		return tableBody.findElements(By.tagName("tr"));
	}
	
	public static List<WebElement> getTDs(WebElement element) {
		return element.findElements(By.tagName("td"));
	}
	
	public static WebElement getTDbyIndex(WebElement element, int index) {
		return element.findElements(By.tagName("td")).get(index);
	}

	public static WebElement getRow(List<WebElement> tableRows, int rowNumber) {
		return tableRows.get(rowNumber);
	}

	public static List<WebElement> getColumnTDs(WebElement tableBody, boolean hasHeader, int columnNumber) {
		
		List<WebElement> trs = getTRs(tableBody);
		List<WebElement> tds = new ArrayList<WebElement>();	
		for (WebElement row : trs) {
			tds.add(getTDbyIndex(row, columnNumber));
		}
		if (hasHeader) {
			tds.remove(0);
		}
		return tds;
		
	}

}
