package Classes;

import org.openqa.selenium.WebDriver;

public class pages {
    WebDriver driver;
    public pages(WebDriver webDriver){this.driver=webDriver;}
    public Login login(){return new Login(driver);}
    public Product_Page product_page(){
        driver.get("https://www.saucedemo.com/inventory.html");
        return new Product_Page(driver);
    }
}
