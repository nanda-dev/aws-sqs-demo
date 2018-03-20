package com.ctsdev.sqsdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class SqsSenderImpl implements SqsSender {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private QueueMessagingTemplate sqsTemplate;
	
	@Value("${queue.activation.name}")
	private String activationQueue;

	@Override
	public void sendMessage(String payload) {
		logger.info("Sending '{}' to Queue '{}'", payload, activationQueue);
		sqsTemplate.convertAndSend(activationQueue, payload);
		logger.info("Message sent to SQS activation-queue.");		
	}
}
