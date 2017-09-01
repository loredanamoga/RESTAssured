package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


/**
 * Created by loredanamoga on 8/22/2017.
 */
public class CreatedBoardPage extends PageObject {

//   Actions builder = new Actions(getDriver());

    @FindBy(css = ".list-header-target")
    private List<WebElement> boardLists;

    @FindBy(css = ".list-card-title.js-card-name")
    private List<WebElement> cardsList;

    @FindBy(css = ".button-link.js-attach")
    private WebElement attachmentLink;

    @FindBy(css = ".uploader")
    private WebElement attachFromComputerButton;

    @FindBy(css = ".attachment-thumbnail-details-options")
    private List<WebElement> download;


    @FindBy(css = ".attachment-thumbnail")
    private List<WebElement> attachmentsList;

    public void selectAndDragAndDropCard(String cardName) {
        for (WebElement card : cardsList) {
            if (card.getText().contains(cardName)) {
                Action dragAndDrop = new Actions(getDriver()).clickAndHold(card).moveToElement(boardLists.get(1))
                        .release(boardLists.get(1)).build();
                dragAndDrop.perform();

            }
        }

    }

    public void selectSpecificCard(String cardName) {
        for (WebElement card : cardsList) {
            if (card.getText().contains(cardName)) {
                card.click();
            }
        }
    }

    public void clickOnAttachmentButton() {
        attachmentLink.click();
    }

    public void attachFileFromComputer(String filePath) {
        getDriver().findElement(By.className("js-attach-file")).sendKeys(filePath);
    }

    public void downloadFileToComputer() {
        waitFor(download.get(0));
        System.out.println(download.get(0).getText());
        clickOn(download.get(0));
        waitFor(5000);
    }

    public void downloadAttachment(String fileName) {
        try {
            AuxFunctions.saveFileFromUrlWithJavaIO(fileName, getDriver().findElement(By.cssSelector(".js-download")).getAttribute("href"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}




