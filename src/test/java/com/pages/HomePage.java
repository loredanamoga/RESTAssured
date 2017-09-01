package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * Created by loredanamoga on 8/22/2017.
 */
@DefaultUrl("https://trello.com/")
public class HomePage extends PageObject {


    @FindBy (css = "[href = '/login?returnUrl=%2F']")
    private WebElement loginLink;



}
