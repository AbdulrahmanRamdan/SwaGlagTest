package Tests;

import Classes.Check_Out;
import Classes.Login;
import Classes.Product_Page;
import Classes.Shopping;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Products_Test extends Base{
    Product_Page product_page;
    Shopping shopping;
    List<String>exp;
    Check_Out check_out;
    @Test(priority = 1)
    void check_A_Z(){
        Login login=pages.login();
        login.Login("standard_user","secret_sauce");
        product_page=new Product_Page(login.getDriver());
         exp=new ArrayList<>(){};
         exp.add("Sauce Labs Backpack");exp.add("Sauce Labs Bike Light");exp.add("Sauce Labs Bolt T-Shirt");
         exp.add("Sauce Labs Fleece Jacket");exp.add("Sauce Labs Onesie");exp.add("Test.allTheThings() T-Shirt (Red)");
         Assert.assertEquals(product_page.GEt_names(),exp);
    }
    @Test(priority = 2)
    void check_Z_A(){
        product_page.Choose_Z_A();
        exp.clear();
        exp.add("Test.allTheThings() T-Shirt (Red)");exp.add("Sauce Labs Onesie");exp.add("Sauce Labs Fleece Jacket");
        exp.add("Sauce Labs Bolt T-Shirt");exp.add("Sauce Labs Bike Light");exp.add("Sauce Labs Backpack");
        Assert.assertEquals(product_page.GEt_names(),exp);
    }
    @Test(priority = 3)
    void check_hi_lo(){
        product_page.Choose_HI_Lo();
        exp.clear();
        exp.add("Sauce Labs Fleece Jacket");exp.add("Sauce Labs Backpack");exp.add("Sauce Labs Bolt T-Shirt");
        exp.add("Test.allTheThings() T-Shirt (Red)");exp.add("Sauce Labs Bike Light");exp.add("Sauce Labs Onesie");
        Assert.assertEquals(product_page.GEt_names(),exp);
    }
    @Test(priority = 4)
    void check_lo_hi(){
        product_page.Choose_Lo_Hi();
        exp.clear();
        exp.add("Sauce Labs Onesie");exp.add("Sauce Labs Bike Light");
        exp.add("Sauce Labs Bolt T-Shirt");exp.add("Test.allTheThings() T-Shirt (Red)");
        exp.add("Sauce Labs Backpack");exp.add("Sauce Labs Fleece Jacket");
        Assert.assertEquals(product_page.GEt_names(),exp);
    }
    @Test(priority = 5)
    void All_items(){
        product_page.Click_draw();
        product_page.All_items();
    }
    @Test(priority = 6)
    void Reset(){
        product_page.set_shoping_item();
        String b=product_page.Get_Shoping_Quantity();
        Assert.assertEquals(product_page.Get_Shoping_Quantity(),"1");
        product_page.Reset();
        Assert.assertEquals(product_page.Get_Shoping_Quantity(),"");
    }
    @Test(priority = 7)
    void Logout(){
        product_page.Logout();
        Login login=pages.login();
        login.Login("standard_user","secret_sauce");
    }
    @Test(priority = 8)
    void About(){
        product_page.Click_draw();
       String title= product_page.About();
       Assert.assertTrue(title.contains("Cross Browser Testing"));
    }
    @Test(priority = 9)
    void Add_item_and_cheeck(){
        product_page.Back();
        product_page.set_shoping_item();
        Assert.assertTrue(product_page.Get_Shoping_Quantity().equals("1"));
    }
    @Test(priority = 10)
    void Remove(){
        shopping=new Shopping(product_page.getDriver());
        shopping.Remove();
        Assert.assertTrue(shopping.check_vis());
        shopping.Back();
    }
    @Test(priority = 11)
    void Check(){
        Login login=new Login(shopping.getDriver());
        login.Login("standard_user","secret_sauce");
        product_page=new Product_Page(login.getDriver());
        product_page.set_shoping_item();
        product_page.Click_Shopping();
        shopping=new Shopping(product_page.getDriver());
        shopping.Check_out();
        Assert.assertEquals(shopping.get_title_check(),"Checkout: Your Information".toUpperCase(Locale.ROOT));
    }
    @Test(priority = 12)
    void Filldata(){
        check_out=new Check_Out(shopping.getDriver());
        check_out.Contiue(new String[]{"Abdo","12","02"});
        Assert.assertEquals(check_out.get_name(),"Sauce Labs Backpack");
    }
    @Test(priority = 13)
    void finish(){
       Assert.assertTrue( check_out.Finish().equals("THANK YOU FOR YOUR ORDER"));

    }
}
