package com.pages;

import com.data.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * Created by loredanamoga on 8/22/2017.
 */
@DefaultUrl("https://trello.com/login")
public class LoginPage extends PageObject {
    @FindBy (css = ".hide-when-two-factor #user" )
    private WebElement inputUsername;

    @FindBy (css = ".hide-when-two-factor #password")
    private WebElement inputPassword;

    @FindBy (css = "#login.button")
    private WebElement loginButton;

    public void loginOnTrello(String username, String password) {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.submit();
    }

}
