package com.ubt.sistemimonitorimitfermave.ws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubt.sistemimonitorimitfermave.data.PajisjaDTO;
import com.ubt.sistemimonitorimitfermave.data.SenzoriDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MessageManager {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    public void sendMessagePajisjet(List<PajisjaDTO> getAllPajisjet) {
        try {
            messagingTemplate.convertAndSend("/topic/pajisjet", new ObjectMapper().writeValueAsString(getAllPajisjet));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageSenzorat(List<SenzoriDTO> getAllSenzor) {
        try {
            messagingTemplate.convertAndSend("/topic/senzorat", new ObjectMapper().writeValueAsString(getAllSenzor));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}