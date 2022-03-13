package test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class mail1 
{
	public RemoteWebDriver driver;
	
	@Given("open {string} browser")
	public void open_browser(String bn) throws Exception
	{
		if (bn.contentEquals("chrome"))
	
	  {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 Thread.sleep(5000);
	  }
	}
	@Given("lunch the site using {string}")
	public void lunch_the_site_using(String url) throws Exception 
	{
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
	}

	@When("do login with using {string} and {string}")
	public void do_login_with_using_and(String un, String pw) throws Exception
	{
		driver.findElement(By.id("identifierId")).sendKeys("pnrsir258");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Next']/..")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("8500692837");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button/span[text()='Next']")).click();
		Thread.sleep(5000);
	}

	@Then("Compose is displayed")
	public void compose_is_displayed() throws Exception 
	{
	Thread.sleep(2000);
	{
	if(driver.findElement(By.xpath("//div[text()='Compose']")).isDisplayed())
		
	  {
		System.out.println("Compose is displayed");
	  }
	  else
	  {
		System.out.println("Compose is not displayed");  
		Thread.sleep(3000);
		System.exit(0);
	  }
	Thread.sleep(6000);
	}
	}

	@When("click on compose")
	public void click_on_compose() throws Exception 
	{
		driver.findElement(By.xpath("//div[text()='Compose']/.")).click();
		Thread.sleep(5000);
	}

	/*@When("New message filed is displayed")
	public void new_message_filed_is_displayed() throws Exception
	{
		if(driver.findElement(By.xpath("//span[text()='New Message']")).isDisplayed())
		
		{
			System.out.println("Compose");
		}
		else
		{
			System.out.println("Compose");
			System.exit(0);
		}
		Thread.sleep(5000);
	}*/

	@When("filed fill with {string},{string},{string},{string}")
	public void filed_fill_with(String to, String sub, String body, String attach) throws Exception 
	{
		driver.findElement(By.name("to")).sendKeys(to);
		Thread.sleep(5000);
		driver.findElement(By.name("subjectbox")).sendKeys(sub);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys(body);
		Thread.sleep(5000);
		driver.findElement(By.name("Filedata")).sendKeys(attach);
		Thread.sleep(5000);
	}

	@When("send is enabled")
	public void send_is_enabled() throws InterruptedException
	{
		if(driver.findElement(By.xpath("//div[text()='Send']")).isEnabled())
		{
		System.out.println("send key ok");
		}
		else
		{
			System.out.println("send key not ok");
			System.exit(0);
		
		}
		Thread.sleep(5000);
	
	}
	@Then("click on send")
	public void click_on_send() throws Exception
	{
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		Thread.sleep(5000);
	}
	@Then("{string} should be displayed")
	public void should_be_displayed(String s) throws Exception {
		String act=driver.findElement(By.xpath("//span[text()='Message sent']/..")).getText();
		Thread.sleep(5000);
		if (act.contains("Message"))
		{
			System.out.println("ok");
		}
		
		else
		{
			System.out.println("not ok");
			Thread.sleep(5000);
			System.exit(0);
		}
		Thread.sleep(5000);
	}

	@When("do logout")
	public void do_logout() throws Exception {
		driver.findElement(By.xpath("//div//a[starts-with(@aria-label,'Google')]/img")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		Thread.sleep(5000);
	}

	@Then("login page should displayed")
	public void login_page_should_displayed() throws Exception {
		String lo=driver.findElement(By.xpath("//span[starts-with(text(),'Choose an account')]")).getText();
		Thread.sleep(4000);
		if (lo.contains("Choose"))
		{
			System.out.println("yes");
		}
		else
		
		{
			System.out.println("no");
			
		}
		Thread.sleep(4000);
	}

	@When("do close site")
	public void do_close_site() throws Exception
	{
		driver.close();
		Thread.sleep(4000);
	}
 
}
