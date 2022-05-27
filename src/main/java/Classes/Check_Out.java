package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Check_Out {
    WebDriver driver;
    By F_name=By.id("first-name");
    By S_name=By.id("last-name");
    By Zip_code=By.id("postal-code");
    By Con_btn=By.id("continue");
    By cancel=By.id("cancel");
    public Check_Out(WebDriver webDriver){
        this.driver=webDriver;
    }
    public void Contiue(String []attr){
        driver.findElement(F_name).sendKeys(attr[0]);
        driver.findElement(S_name).sendKeys(attr[1]);
        driver.findElement(Zip_code).sendKeys(attr[2]);
        driver.findElement(Con_btn).click();
    }
    public String get_name(){
        return driver.findElement(By.className("inventory_item_name")).getText();
    }
    public String Finish(){
        driver.findElement(By.id("finish")).click();
        return driver.findElement(By.className("complete-header")).getText();
    }
}
