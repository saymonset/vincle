package com.example.demo.controllers;

import com.example.demo.models.Item;
import com.example.demo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Created by simon on 8/14/22.
 */
@Controller

public class IemsWebSocketController {
    @Autowired
    private ItemService service;


    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public List<Item> recibeMensaje(String msg){
 System.out.print("-------------msg ="+ msg);
        return service.listar();
    }
}
