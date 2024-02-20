package proj_package.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import proj_package.Utilities.WaitUtility;

public class HomePage extends WaitUtility{
	
	
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//div[@class='no-results'] //h2")
	WebElement noProductAvailableMsgElement;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchBox;
	
	@FindBy(xpath="//h4[@class='product-name']")
	List<WebElement> productsList;
	
	@FindBy(xpath="//div[@class='product-action'] //button")
	List<WebElement> addToCartButtonLocator;
	
	
	
	public void searchItem(String itemname) {	
		
		waitForElement(searchBox);
		searchBox.sendKeys(itemname);
	
	}
	
	
	public List<WebElement> getListOfProducts()
	{     
		try {
		waitForElements(productsList);
		return productsList;
		}
		catch(Exception e){
			
			return new ArrayList<>();
		}
		
	}
	
	public String noProductAvailableErrorMsg()
	{
		waitForElement(noProductAvailableMsgElement);
		String msg=noProductAvailableMsgElement.getText();
		return msg;
	}
	
	
	
}