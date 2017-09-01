package com.deserialize.cards;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"board",
"card"
})
public class Trello {

@JsonProperty("board")
private Integer board;
@JsonProperty("card")
private Integer card;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("board")
public Integer getBoard() {
return board;
}

@JsonProperty("board")
public void setBoard(Integer board) {
this.board = board;
}

@JsonProperty("card")
public Integer getCard() {
return card;
}

@JsonProperty("card")
public void setCard(Integer card) {
this.card = card;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}