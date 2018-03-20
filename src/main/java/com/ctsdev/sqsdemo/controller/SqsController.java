package com.ctsdev.sqsdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctsdev.sqsdemo.service.SqsSender;

@RestController
@RequestMapping("/api")
public class SqsController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SqsSender sqsSender;	
	
	@GetMapping("/hello")
	public String sayHello() {
		logger.info("Send Hello World! message.");
		sqsSender.sendMessage("Hello World!");
		return "MESSAGE_SENT";		
	}
	
}
