package loginProcess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	static WebDriver driver = new ChromeDriver();
	static String MyURL = "https://www.saucedemo.com/";
	static String UserNameInputID = "user-name";
	static String PasswordInputID = "password";
	static String LoginUserName = "standard_user";
	static String LoginPassword = "secret_sauce";
	static String FirstAddToCartButtonID = "add-to-cart-sauce-labs-backpack";
	static String AddToCartButtonClassName = "btn";
	static String ItemsNameClassName = "inventory_item_name";
	static String ItemsPricesClassName = "inventory_item_price";
	
	
	static public void PrintItemsNamesAndPrice() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className(AddToCartButtonClassName));
		List<WebElement> ItemsNames = driver.findElements(By.className(ItemsNameClassName));
		List<WebElement> ItemsPrices = driver.findElements(By.className(ItemsPricesClassName));

		for (int i = 0; i < AddToCartButtons.size(); i++) {
			String PriceWithOutSymbol = ItemsPrices.get(i).getText().replace("$", "");
			double PriceAsDouble = Double.parseDouble(PriceWithOutSymbol);
			double TaxValue = 0.10;
			double FinalPrice = PriceAsDouble * TaxValue + PriceAsDouble;
			int intPrice = (int) FinalPrice;
			   
			if (ItemsNames.get(i).getText().contains("Backpack") || ItemsNames.get(i).getText().contains("Fleece")
					|| ItemsNames.get(i).getText().contains("Onesie")) {

				AddToCartButtons.get(i).click();
				
				System.out.println("This Item " + ItemsNames.get(i).getText() + " Was Added!! And The Price Of This Item Is : "
								+ ItemsPrices.get(i).getText() + " And The Price After Tax Is : " + FinalPrice);
				
				if (intPrice % 2 == 0) {
					
		            System.out.println("The Price After Tax Of This Item Is an Even Number");
		   
		        } else {

		            System.out.println("The Price After Tax Of This Item Is an Odd Number");
		        }
			
				
			} else {
				System.out.println("This Item " + ItemsNames.get(i).getText() + " Was Not Added!! And The Price Of This Item Is "
								+ ItemsPrices.get(i).getText() + " And The Price After Tax Is : " + FinalPrice);
				
				if (intPrice % 2 == 0) {

		            System.out.println("The Price After Tax Of This Item Is an Even Number");
		        } else {
				
		            System.out.println("The Price After Tax Of This Item Is an Odd Number");
		        }
				continue;
			}
			
			
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
