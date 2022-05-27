package Tests;

import Classes.Login;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Test extends Base{
    private Login login;
    String user_name="standard_user";
    String password="secret_sauce";
    @Test(priority = 1)
    void useronly(){
        login=pages.login();
        login.Login(user_name,"");
        Assert.assertEquals(login.Get_Error_Mass(),"Epic sadface: Password is required");
    }
    @Test(priority = 2)
    void passonly(){
        login.Login("",password);
        Assert.assertEquals(login.Get_Error_Mass(),"Epic sadface: Username is required");
    }
    @Test(priority = 3)
    void wrong_login(){
        login.Login(user_name,"121212121");
        Assert.assertEquals(login.Get_Error_Mass(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test(priority = 4)
    void Succ_Login(){
        login.Login(user_name,password);
        Assert.assertEquals(login.Get_title(),"PRODUCTS");
    }
}
