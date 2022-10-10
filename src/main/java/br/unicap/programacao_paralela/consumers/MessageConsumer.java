package br.unicap.programacao_paralela.consumers;
import br.unicap.programacao_paralela.connections.RabbitMQConstants;
import br.unicap.programacao_paralela.dtos.ChatMessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @RabbitListener(queues = RabbitMQConstants.USUARIO)
    public void consumidor(ChatMessageDto messageDto){
        System.out.println(messageDto.getMessage());
    }
}
