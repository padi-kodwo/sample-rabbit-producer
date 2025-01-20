package co.terydin.rabbitproducer.amqp;

import co.terydin.rabbitproducer.dto.UserDto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSender {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private Queue userCreated;

  public void sendUserCreated(UserDto user){
    if (user != null)
    rabbitTemplate.convertAndSend(userCreated.getName(), user);
  }

}
