package com.websocket.demo.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class chatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        ChatMessage.addPeople();
        var chatMessage1 = ChatMessage.builder()
                .content(chatMessage.getContent())
                .timestamp(chatMessage.getTimestamp())
                .sender(chatMessage.getSender())
                .type(MessageType.JOIN)
                .cound(ChatMessage.getPeople())
                .build();
        System.out.println(ChatMessage.getPeople());
        return chatMessage1;
    }
}
