package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Shopping {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
    By Quan=By.xpath("//*[contains(@class,'cart_item')]/div[contains(@class,'cart_quantity')]");
    By Remove= By.id("remove-sauce-labs-backpack");
    By Check_Out=By.id("checkout");
    By Check_Title=By.className("title");
    public Shopping(WebDriver driver){this.driver=driver;}
    public void Back(){driver.navigate().back();}
    public void Remove(){driver.findElement(Remove).click();}
    public void Check_out(){driver.findElement(Check_Out).click();}
    public String Get_Quan(){return driver.findElement(Quan).getText();}
    public boolean check_vis(){
        boolean t=false;
        try {
            driver.findElement(Quan).getText();
        }catch (Exception e){
            t=true;
        }
        return t;
    }
    public String get_title_check(){
        return driver.findElement(Check_Title).getText();
    }
}
