package com.steps;

import com.deserialize.cards.CreatedCard;
import com.data.Constants;
import com.deserialize.boards.CreatedBoard;
import com.jayway.restassured.RestAssured;
import com.deserialize.lists.CreatedList;
import com.serialize.board.CreateBoard;
import com.serialize.card.CreateCard;
import com.serialize.list.CreateList;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by loredanamoga on 8/21/2017.
 */
public class TrelloRESTSteps extends ScenarioSteps {

    private String key = "497c078886a812c5bc05333a47d00d7c";
    private String token = "f952901bcdc13572862ae4a58e0bf7bd590afa377fa2f912be28eb61874a486f";


    public void setKey(String key) {
        this.key = key;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Step
    public CreatedBoard createNewBoard(String boardName) {
        CreateBoard createBoard = new CreateBoard();
        createBoard.setName(boardName);
        createBoard.setKey(key);
        createBoard.setToken(token);
        return RestAssured.given().contentType("application/json").body(createBoard).post(Constants.CREATE_BOARD_LINK)
                .then().statusCode(200).extract().as(CreatedBoard.class);

    }

    @Step
    public CreatedList createNewList(String listName, String boardId) {
        CreateList createList = new CreateList();
        createList.setName(listName);
        createList.setIdBoard(boardId);
        createList.setKey(key);
        createList.setToken(token);
        return RestAssured.given().contentType("application/json").body(createList).post(Constants.CREATE_LIST_LINK)
                .then().statusCode(200).extract().as(CreatedList.class);
    }


    @Step
    public CreatedCard createNewCard(String cardName, String listId) {
        CreateCard createCard = new CreateCard();
        createCard.setName(cardName);
        createCard.setIdList(listId);
        createCard.setToken(token);
        createCard.setKey(key);
        return RestAssured.given().contentType("application/json").body(createCard).post(Constants.CREATE_CARD_LINK)
                .then().statusCode(200).extract().as(CreatedCard.class);
    }

}
