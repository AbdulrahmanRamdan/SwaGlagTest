package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Product_Page {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    WebDriverWait wait;
    By Names_items= By.className("inventory_item_name");
    By Price_items=By.className("inventory_item_price");
    By select=By.className("product_sort_container");
    By Z_A=By.xpath("//*[contains(text(),'Name (Z to A)')]");
    By Hi_lo=By.xpath("//*[contains(text(),'Price (high to low)')]");
    By lo_hi=By.xpath("//*[contains(text(),'Price (low to high)')]");
    By drawable=By.id("react-burger-menu-btn");
    By All_Items=By.id("inventory_sidebar_link");
    By About=By.id("about_sidebar_link");
    By Logour=By.id("logout_sidebar_link");
    By Reset=By.id("reset_sidebar_link");
    By shoping_link=By.className("shopping_cart_link");
    public Product_Page(WebDriver webDriver){
        this.driver=webDriver;
        wait=new WebDriverWait(driver,5);
    }
    public List<String> GEt_names(){
        List<String>name=new ArrayList<>();
        List<WebElement>webElements=driver.findElements(Names_items);
        for (WebElement e:webElements) {
            name.add(e.getText());
        }
        return name;
    }
    public void Choose_Z_A(){
        driver.findElement(select).click();
        driver.findElement(Z_A).click();
    }
    public void Choose_HI_Lo(){
        driver.findElement(select).click();
        driver.findElement(Hi_lo).click();
    }
    public void Choose_Lo_Hi(){
        driver.findElement(select).click();
        driver.findElement(lo_hi).click();
    }
    public String Get_Shoping_Quantity(){
        return driver.findElement(shoping_link).getText();
    }
    public void Click_Shopping(){driver.findElement(shoping_link).click();}
    public void Logout(){
        driver.findElement(Logour).click();
    }
    public void set_shoping_item(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }
    public void Reset(){

        driver.findElement(Reset).click();
    }
    public String About(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(About));
        driver.findElement(About).click();
        return driver.getTitle();
    }
    public void All_items(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(All_Items));
        driver.findElement(All_Items).click();
    }
    public void Click_draw(){
        driver.findElement(drawable).click();
    }
    public void Back(){driver.navigate().back();}
}
