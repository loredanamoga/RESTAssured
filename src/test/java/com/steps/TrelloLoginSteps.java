package com.steps;

import com.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by loredanamoga on 8/22/2017.
 */
public class TrelloLoginSteps extends ScenarioSteps {

    private LoginPage loginPage;

    @Step
    public void navigateToLoginPage() {
        loginPage.open();
    }

    @Step
    public void loginOnTrello(String username, String password) {
        loginPage.loginOnTrello(username, password);
    }
}
