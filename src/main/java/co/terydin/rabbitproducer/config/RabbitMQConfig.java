package co.terydin.rabbitproducer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * for more details, read this response
 * <a href="https://stackoverflow.com/questions/41210688/multiple-rabbitmq-queues-with-spring-boot">Article</a>
 */
@Configuration
public class RabbitMQConfig {
  @Bean
  public Queue userCreated() {
    return new Queue("userCreated", false);
  }

  @Bean
  public Queue userUpdated() {
    return new Queue("userUpdated", false);
  }

  @Bean
  public Queue userDeleted() {
    return new Queue("userDeleted", false);
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
    return rabbitTemplate;
  }

}
