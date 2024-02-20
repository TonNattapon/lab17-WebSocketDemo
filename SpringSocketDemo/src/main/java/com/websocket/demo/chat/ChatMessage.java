package com.websocket.demo.chat;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChatMessage {
    private String content;
    private String timestamp;
    private String sender;
    private MessageType type;
    private static int people ;
    private int cound  ;

    public static void addPeople() {
        people++ ;
    }
    public static void minusPeople() {
        people-- ;
    }
    public static  Integer getPeople() {
        return people;
    }


}
