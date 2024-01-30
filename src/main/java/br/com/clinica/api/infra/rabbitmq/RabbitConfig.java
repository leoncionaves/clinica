package br.com.clinica.api.infra.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

//@Configuration
public class RabbitConfig {

    @Bean
    public Queue criaFila(){

        //return new Queue("agendamento.confirmacao", false);

        return QueueBuilder.nonDurable("agendamento.confirmacao").build();
    }

    @Bean
    public RabbitAdmin criaRabbitAdmin (ConnectionFactory conn){
        return new RabbitAdmin(conn);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }
}
