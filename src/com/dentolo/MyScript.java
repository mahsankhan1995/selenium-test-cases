package com.dentolo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.primitives.Bytes;


public class MyScript {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://s3.eu-central-1.amazonaws.com/faircare-registration-beta/beta12/index.html?flow=schema_da_direkt_bas_qa_challenge&showDaTheme=true#name");
		driver.manage().window().maximize();

//------------- Page 1 of 6 "Tarifauswahl"-----------------------------------------------------------------------------------------------------------------
		
		
		driver.findElement(By.xpath("/html/body/div[1]/div/a\r\n" + "")).click();

		WebElement elementTarfiffe =  driver.findElement(By.id("policy_category"));{
		Select sel = new Select(elementTarfiffe);
		sel.selectByVisibleText("Zahnschutz Premium");//for selection of "Ausgewählter Tarfiffe"
		}
		
		//for selection of Date
		WebElement elementDate =  driver.findElement(By.name("day"));{
		Select sel = new Select(elementDate);
		sel.selectByVisibleText("31.");
		}
		//for selection of Day
		WebElement elementDay =  driver.findElement(By.name("month"));{
		Select sel = new Select(elementDay);
		sel.selectByVisibleText("April");
		}
		//for selection of Year
		WebElement elementYear =  driver.findElement(By.name("year"));{
		Select sel = new Select(elementYear);
		sel.selectByVisibleText("1995");
		}
		//for button "Weiter"
		driver.findElement(By.xpath("/html/body/div[2]/div/main/div/div/div/div/div/form/div/div[6]/button/span\r\n" + "")).click();
		
//------------- Page 2 of 6 "Vertragsangaben" -----------------------------------------------------------------------------------------------------------------
		
		WebElement elementStartDate =  driver.findElement(By.id("starting_at"));{
		Select sel = new Select(elementStartDate);
		sel.selectByVisibleText("1. Mai 2021");
		}
		
		//for radio buttons
		driver.findElement(By.id("yes")).click();
		driver.findElement(By.id("another")).click();
		driver.findElement(By.id("male")).click();
		
		//Enter first and last name
		driver.findElement(By.id("first_name")).sendKeys("first");
		driver.findElement(By.id("last_name")).sendKeys("last");
		
		//for button "Weiter"
		driver.findElement(By.xpath("/html/body/div[2]/div/main/div/div/div/div/div/form/div/div[7]/button/span\r\n" + "")).click();

//------------- Page 3 of 6 "Angaben zum Versicherungsnehmer" -----------------------------------------------------------------------------------------------------------------
		
		// perform Double click action on "Anrede" redio button, because single click is not working for "Herr" 
		Thread.sleep(3000);
		Actions act = new Actions(driver);{
			WebElement elemAnrede =  driver.findElement(By.xpath("/html/body/div[2]/div/main/div/div/div/div/div/form/div/div[5]/div[1]/div/label[1]/div\r\n" + ""));
			act.doubleClick(elemAnrede).perform();
		}
		
		//Enter first and last name
		driver.findElement(By.id("first_name")).sendKeys("first");
		driver.findElement(By.id("last_name")).sendKeys("last");
		
		//for selection of Date
		WebElement elementDate2 =  driver.findElement(By.name("day"));{
		Select sel = new Select(elementDate2);
		sel.selectByVisibleText("31.");
		}
		//for selection of Day
		WebElement elementDay2 =  driver.findElement(By.name("month"));{
		Select sel = new Select(elementDay2);
		sel.selectByVisibleText("April");
		}
		//for selection of Year
		WebElement elementYear2 =  driver.findElement(By.name("year"));{
		Select sel = new Select(elementYear2);
		sel.selectByVisibleText("1995");
		}
		
		driver.findElement(By.id("email")).sendKeys("example@gmail.com");
		
		driver.findElement(By.id("phone_number")).sendKeys("17612345678");
		
		driver.findElement(By.id("street_name")).sendKeys("ssonnenstr");
		
		driver.findElement(By.name("house-number")).sendKeys("5");
		
		driver.findElement(By.id("postal_code_input")).sendKeys("12345");
		
		driver.findElement(By.id("city_input")).sendKeys("sun city");
				
		driver.findElement(By.xpath("//*[@id=\"no\"]\r\n" + "")).click();
		
		driver.findElement(By.id("insured_street_name")).sendKeys("ssonnenStrasse");
		
		driver.findElement(By.name("house-number-insured")).sendKeys("5");
		
		driver.findElement(By.id("insured_postalcode_city")).sendKeys("12345");
		
		driver.findElement(By.xpath("//*[@id=\"insured_postalcode_city\" and @placeholder='Sonnenstadt']\r\n" + "")).sendKeys("sun city");

		
		driver.findElement(By.xpath("/html/body/div[2]/div/main/div/div/div/div/div/form/div/div[15]/button/span\r\n" + "")).click();

		
//------------- Page 4 of 6 "Zahlungsdaten" -----------------------------------------------------------------------------------------------------------------

		driver.findElement(By.id("iban")).sendKeys("DE89 3704 0044 0532 0130 00");
		
		driver.findElement(By.xpath("/html/body/div[2]/div/main/div/div/div/div/div/form/div/div[6]/button/span\r\n" + "")).click();

		
//------------- Page 5 of 6 "Ausgewählter Versicherungsschutz" -----------------------------------------------------------------------------------------------------------------
		
		driver.findElement(By.id("documents_accepted_at")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/main/div/div/div/div/div/form/div/div[4]/div[1]/div[2]/div/div/div/div/div[5]/button/span\r\n" + "")).click();
		driver.findElement(By.name("e_mail")).click();
		driver.findElement(By.name("telephone")).click();

		driver.findElement(By.xpath("/html/body/div[2]/div/main/div/div/div/div/div/form/div/div[7]/button/span\r\n" + "")).click();

//------------- Page 6 of 6 "Versicherungsschutz" -----------------------------------------------------------------------------------------------------------------

		driver.findElement(By.xpath("/html/body/div[2]/div/main/div/div/div/div/div/form/div/div[4]/button/span\r\n" + "")).click();

		System.out.println("Automation test completes successfully");
		
		
	}

}
