package co.terydin.rabbitproducer;

import co.terydin.rabbitproducer.amqp.UserSender;
import co.terydin.rabbitproducer.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@Slf4j
@SpringBootApplication
public class SampleRabbitProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleRabbitProducerApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserSender userSender){
		return args -> {
			UserDto user = new UserDto();
			user.setId("TEST");
			user.setName("NAME");

			log.info("user to send {}", user);

			userSender.sendUserCreated(user);
		};
	}

}
