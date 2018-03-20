package com.ctsdev.sqsdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Component;

@Component
public class SqsReceiverImpl implements SqsReceiver {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private QueueMessagingTemplate sqsTemplate;
	
	@Value("${queue.activation.name}")
	private String activationQueue;

	@Override
	public Object receiveMessage() {
		logger.info("Receiving Message from Queue: {}", activationQueue);
		String message = sqsTemplate.receiveAndConvert(activationQueue, String.class);
		logger.info("Message received:{}", message);
		return message;
	}
	
	@MessageMapping("${queue.activation.name}")
	public void pollForMessage(Object message, @Header("SenderId") String senderId) {
		logger.info("Received {} sent by {}, from Queue: {}", (String) message, senderId, activationQueue);		
	}

}
