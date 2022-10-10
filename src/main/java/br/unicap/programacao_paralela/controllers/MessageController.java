package br.unicap.programacao_paralela.controllers;

import br.unicap.programacao_paralela.connections.RabbitMQConnection;
import br.unicap.programacao_paralela.connections.RabbitMQConstants;
import br.unicap.programacao_paralela.dtos.ChatMessageDto;
import br.unicap.programacao_paralela.services.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "mensagens")
public class MessageController {

    @Autowired
    RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity enviaMensagem(@RequestBody ChatMessageDto messageDto) {

        System.out.println("Message to send: " + messageDto.getMessage());

        this.rabbitMQService.enviaMensagem(RabbitMQConstants.DESTINO, messageDto);

        return new ResponseEntity(HttpStatus.OK);
    }
}
