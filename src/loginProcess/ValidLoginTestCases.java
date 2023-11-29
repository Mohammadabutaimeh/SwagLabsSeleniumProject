package loginProcess;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidLoginTestCases extends Parameters {

	@BeforeTest
	public void Setup() {

		driver.manage().window().maximize();
		driver.get(MyURL);

	}

	@Test(priority = 1)
	public void loginTestUsingStandardUser() {

		WebElement UserNameInput = driver.findElement(By.id(UserNameInputID));
		WebElement PasswordInput = driver.findElement(By.id(PasswordInputID));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameInput.sendKeys(LoginUserName);
		PasswordInput.sendKeys(LoginPassword);
		LoginButton.click();

	}
	
	

	@Test(priority = 2, enabled = false)
	public void AddToCart() {
		WebElement FirstAddToCartBUtton = driver.findElement(By.id(FirstAddToCartButtonID));
		FirstAddToCartBUtton.click();
	}
	
	

	@Test(priority = 3)
	public void PrintNamesOfTheItems() {

		PrintItemsNamesAndPrice();
		
	}

	@AfterTest
	public void PostTesting() {
	}

}
