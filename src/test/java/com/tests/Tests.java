package com.tests;

import com.data.Constants;
import com.pages.AuxFunctions;
import com.steps.TrelloBoardSteps;
import com.steps.TrelloLoginSteps;
import com.steps.TrelloRESTSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.rules.TestWatchman;
import org.junit.runner.RunWith;
import org.junit.runners.model.FrameworkMethod;
import org.openqa.selenium.WebDriver;

/**
 * Created by loredanamoga on 8/21/2017.
 */
@RunWith(SerenityRunner.class)
public class Tests {

    private static String watchedLog;

    @Before
    public void maxiPage() {
        webDriver.manage().window().maximize();
    }

    @Managed(uniqueSession = true)
    private WebDriver webDriver;

    @Steps
    private TrelloRESTSteps trelloRESTSteps;

    @Steps
    private TrelloLoginSteps trelloLoginSteps;

    @Steps
    private TrelloBoardSteps trelloBoardSteps;

    @Rule
    public MethodRule watchman= new TestWatchman() {
        @Override

        public void failed(Throwable e, FrameworkMethod method) {
            AuxFunctions.takeScreenshotOnFailure("E:/Attachment/screenshot.jpg", webDriver);
            watchedLog+= method.getName() + " " + e.getClass().getSimpleName()
                    + "\n";
        }


    };

    @Test
    public void test01createNewBoard() {
        String boardId = trelloRESTSteps.createNewBoard(Constants.BOARD_NAME).getId();
        String listId = trelloRESTSteps.createNewList(Constants.LIST_NAME, boardId).getId();
        trelloRESTSteps.createNewCard(Constants.CARD_NAME, listId);
        trelloLoginSteps.navigateToLoginPage();
        trelloLoginSteps.loginOnTrello(Constants.USERNAME, Constants.PASSWORD);
//        trelloBoardSteps.openCreatedBoard(Constants.BOARD_NAME);
        trelloBoardSteps.openSpecificBoard(Constants.BOARD_NAME);
        trelloBoardSteps.selectAndDragAndDropCard(Constants.CARD_NAME);
        trelloBoardSteps.selectSpecificCard(Constants.CARD_NAME);
        trelloBoardSteps.clickOnAttachmentButton();
        trelloBoardSteps.attachFileFromComputer(Constants.UPLOAD_FILE_PATH);
        trelloBoardSteps.downloadFileToComputer();

    }


    @Test
    public void test02downloadAndComparePDFs() {
        trelloLoginSteps.navigateToLoginPage();
        trelloLoginSteps.loginOnTrello(Constants.USERNAME, Constants.PASSWORD);
        trelloBoardSteps.openSpecificBoard(Constants.BOARD_NAME);
        trelloBoardSteps.selectSpecificCard(Constants.CARD_NAME);
        trelloBoardSteps.downloadAttachment(Constants.DOWNLOAD_TO_PATH);
        trelloBoardSteps.comparePDFs(Constants.PFD_FILE_PATH, Constants.DOWNLOAD_TO_PATH);
        AuxFunctions.takeScreenshotOnFailure("E:/Attachment/screenshot.jpg", webDriver);
    }

    @Test
    public void test03takeScreenshotOnFailure() {
        trelloLoginSteps.navigateToLoginPage();
        trelloLoginSteps.loginOnTrello(Constants.USERNAME, Constants.PASSWORD);
        trelloBoardSteps.openSpecificBoard(Constants.BOARD_NAME);
        trelloBoardSteps.selectSpecificCard(Constants.CARD_NAME);
//        trelloBoardSteps.downloadFileToComputer();
        trelloBoardSteps.downloadAttachment(Constants.DOWNLOAD_TO_PATH);
        trelloBoardSteps.comparePDFs(Constants.PFD_FILE_PATH, Constants.DOWNLOAD_TO_PATH);

    }


    @Test
    public void test04closeSpecificBoard() {
        trelloLoginSteps.navigateToLoginPage();
        trelloLoginSteps.loginOnTrello(Constants.USERNAME, Constants.PASSWORD);
        trelloBoardSteps.closeSpecificBoard("myboard");

    }
}
