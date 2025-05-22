package com.thalyshenrique7.rabbitguard.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thalyshenrique7.rabbitguard.config.RabbitMQConfig;
import com.thalyshenrique7.rabbitguard.dto.UserDTO;

@Service
public class UserProducer {

	private static final Logger log = LoggerFactory.getLogger(UserProducer.class);

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void sendUser(UserDTO userDTO) {

		this.amqpTemplate.convertAndSend(RabbitMQConfig.USER_QUEUE, userDTO);
		log.info("User sent to queue: {}", userDTO);
	}

}
