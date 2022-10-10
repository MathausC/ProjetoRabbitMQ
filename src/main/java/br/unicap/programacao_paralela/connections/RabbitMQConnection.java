package br.unicap.programacao_paralela.connections;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {

    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private static final String NOME_EXCHANGE = "amq_direct";

    private Queue fila(String nomeFile) {
        return new Queue(nomeFile, true, false, false);
    }

    private DirectExchange trocaDireta() {
        return new DirectExchange(NOME_EXCHANGE, true, false);
    }

    private Binding relacionamento(Queue fila, DirectExchange trocaDireta) {
        return new Binding(fila.getName(), Binding.DestinationType.QUEUE, trocaDireta.getName(), fila.getName(), null);
    }

    @PostConstruct
    private void adiciona(){
        Queue filaUsuario = this.fila(RabbitMQConstants.USUARIO);
        Queue filaDestino = this.fila(RabbitMQConstants.DESTINO);
        DirectExchange troca = this.trocaDireta();

        this.amqpAdmin.declareQueue(filaUsuario);
        this.amqpAdmin.declareQueue(filaDestino);

        this.amqpAdmin.declareExchange(troca);
    }
}
