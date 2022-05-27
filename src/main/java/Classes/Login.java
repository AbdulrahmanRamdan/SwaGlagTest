package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private By Error_mass=By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3");
    private By username=By.id("user-name");
    private By pass=By.id("password");
    private By products=By.cssSelector("#header_container > div.header_secondary_container > span");
    public Login(WebDriver driver){this.driver=driver;}
    public String Get_Error_Mass(){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Error_mass));
        return driver.findElement(Error_mass).getText();
    }
    public void Login(String user,String pas){
        driver.get("https://www.saucedemo.com/?fbclid=IwAR34fdV01rkGoF4qgpJ4z7QBeEl01by1xJwvvNQhbBUSIIE4xN-s8a4vysE");
        driver.findElement(username).sendKeys(user);
        driver.findElement(pass).sendKeys(pas);
        driver.findElement(By.id("login-button")).click();
    }
    public String Get_title(){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(products));
        return driver.findElement(products).getText();
    }

}
