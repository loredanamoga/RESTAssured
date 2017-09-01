package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by loredanamoga on 8/22/2017.
 */
public class BoardsPage extends PageObject {

    @FindBy(css = "li:first-child .board-tile:first-child")
    private WebElement myBoard;

    @FindBy(css = ".boards-page-board-section-list-item")
    private List<WebElement> boardsList;

    @FindBy (css = ".board-menu-navigation-item-link.js-open-more")
    private WebElement openMoreButton;

    @FindBy (css = ".board-menu-navigation-item-link.js-close-board")
    private WebElement closeBoardButton;

    @FindBy (css = ".js-confirm")
    private WebElement confirmCloseButton;

    public void openCreatedBoard() {
        myBoard.click();
    }

    public void openSpecificBoard(String boardName) {
        waitFor(boardsList.get(0));
        for (WebElement board : boardsList) {
            if (board.getText().contains(boardName)) {
                board.click();
            }
        }

    }

    public void clickOnOpenMoreSection() {
        openMoreButton.click();
    }


    public void clickOnCloseBoard(){
        closeBoardButton.click();
    }

    public void clickOnConfirmCloseButton() {
        confirmCloseButton.click();
    }

    public boolean ckeckIfBoardWasClosed(String boardName) {
        for (WebElement board : boardsList) {
            return !board.getText().contains(boardName) ;
        }
        return false;
    }

    public void navigateToBoardsPage() {
        getDriver().navigate().to("https://trello.com/");
    }
}

