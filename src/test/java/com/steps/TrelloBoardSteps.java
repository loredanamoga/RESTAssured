package com.steps;

import com.pages.BoardsPage;
import com.pages.CreatedBoardPage;
import com.pages.AuxFunctions;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by loredanamoga on 8/22/2017.
 */
public class TrelloBoardSteps {

    private BoardsPage boardsPage;
    private CreatedBoardPage createdBoardPage;
    private AuxFunctions auxFunctions;

//    @Step
//    public void openCreatedBoard(String boardName) {
//        boardsPage.openCreatedBoard(boardName);
//    }


    @Step
    public void openSpecificBoard(String boardName) {
        boardsPage.openSpecificBoard(boardName);
    }

    @Step
    public void selectAndDragAndDropCard(String cardName) {
        createdBoardPage.selectAndDragAndDropCard(cardName);

    }

    @Step
    public void selectSpecificCard(String cardName) {
        createdBoardPage.selectSpecificCard(cardName);
    }

    @Step
    public void clickOnAttachmentButton() {
        createdBoardPage.clickOnAttachmentButton();
    }

    @Step
    public void attachFileFromComputer(String filePath) {
        createdBoardPage.attachFileFromComputer(filePath);
    }

    @Step
    public void downloadFileToComputer() {
        createdBoardPage.downloadFileToComputer();
    }

    @Step
    public void downloadAttachment(String fileName) {
        createdBoardPage.downloadAttachment(fileName);
    }

    @Step
    public void comparePDFs(String filepath, String downloadedFilepath) {
        String pdf = AuxFunctions.readPDFFromSpecifiedPath(filepath);
        String downloadedPdf = AuxFunctions.readPDFFromSpecifiedPath(downloadedFilepath);
        assertTrue(pdf.equals(downloadedPdf));

    }

    @Step
    public void closeSpecificBoard(String boardName){
        boardsPage.openSpecificBoard(boardName);
        boardsPage.clickOnOpenMoreSection();
        boardsPage.clickOnCloseBoard();
        boardsPage.clickOnConfirmCloseButton();
        boardsPage.navigateToBoardsPage();
        assertTrue(boardsPage.ckeckIfBoardWasClosed(boardName));
    }
}
