package Tests;

import Classes.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
private WebDriver driver;
protected pages pages;
@BeforeClass
    void setup(){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\ABDO\\Downloads\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.get("https://www.saucedemo.com/?fbclid=IwAR34fdV01rkGoF4qgpJ4z7QBeEl01by1xJwvvNQhbBUSIIE4xN-s8a4vysE");
    pages=new pages(driver);
    Assert.assertEquals(driver.getTitle(),"Swag Labs");
}
@AfterClass
    void finish(){
    driver.quit();
}
}
