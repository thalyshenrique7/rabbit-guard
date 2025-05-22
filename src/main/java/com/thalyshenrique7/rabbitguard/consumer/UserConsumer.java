package com.thalyshenrique7.rabbitguard.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thalyshenrique7.rabbitguard.config.RabbitMQConfig;
import com.thalyshenrique7.rabbitguard.dto.UserDTO;
import com.thalyshenrique7.rabbitguard.service.UserServiceImpl;

@Service
public class UserConsumer {

	private static final Logger log = LoggerFactory.getLogger(UserConsumer.class);

	@Autowired
	private UserServiceImpl userService;

	@RabbitListener(queues = RabbitMQConfig.USER_QUEUE)
	public void consumeUser(UserDTO userDTO) {

		log.info("[CONSUMER] Received user: {}", userDTO);
		this.userService.saveUser(userDTO);
	}
}
